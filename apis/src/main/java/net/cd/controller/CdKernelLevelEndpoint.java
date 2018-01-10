package net.cd.controller;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.cd.dto.CdDefaultDtoUtil;
import net.cd.dto.kernal.CdKAssetDto;
import net.cd.dto.kernal.CdKNoticeDto;
import net.cd.dto.xtras.CdXReferenceDto;
import net.cd.exception.CdErrors;
import net.cd.exception.CdException;
import net.cd.jpa.entity.kernal.CdKAssetEntity;
import net.cd.service.kernal.CdKAssetService;

/**
 * Created by Vincent on 05/12/2017.
 */
@RestController
@RequestMapping("/kernel")
@Api(value = "Kernal Level Functions API Endpoint", description = "Manipulate Kernal Level Data Entities Endpoint")
public class CdKernelLevelEndpoint {

    @Autowired
    private CdKAssetService cdKAssetService;

    @Autowired
    @Value("#{cdPathAsset}")
    private String cdPathAsset;

    @Autowired
    @Value("#{cdInvoiceTemplateHTML}")
    private Integer cdInvoiceTemplateHTML;

    @RequestMapping(value = "/asset", method = RequestMethod.POST)
    @ApiOperation("Retain digital asset")
    public CdXReferenceDto retainAsset(@RequestParam("file") MultipartFile file, @RequestParam String type) throws IOException, NoSuchAlgorithmException {

        if (file == null || file.isEmpty()) {
            throw new CdException(CdErrors.CD_K_ASSET_RETAIN_FAILURE_FILE_EMPTY);
        }

        CdKAssetDto cdKAssetDto = processRetainAsset(file, null, CdKAssetEntity.AssetTypes.valueOf(type));
        return new CdXReferenceDto(cdKAssetDto.getReference());
    }

    private CdKAssetDto processRetainAsset(MultipartFile file, String note, CdKAssetEntity.AssetTypes type) throws IOException, NoSuchAlgorithmException {
        File tmp = File.createTempFile(cdPathAsset + File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date()), ".tmp");
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(tmp));
        FileCopyUtils.copy(file.getInputStream(), stream);
        stream.close();

        FileInputStream fis = new FileInputStream(tmp);
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
        fis.close();
        CdKAssetDto cdKAssetDto = CdDefaultDtoUtil.getVnKAssetDto();
        cdKAssetDto.setNote(note);
        cdKAssetDto.setMd5(md5);
        cdKAssetDto.setType(type);
        cdKAssetDto.setName(file.getOriginalFilename());
        cdKAssetDto = cdKAssetService.save(cdKAssetDto);
        cdKAssetDto = cdKAssetService.findOne(cdKAssetDto.getId());

        Files.move(Paths.get(tmp.getCanonicalPath()), Paths.get(cdPathAsset).resolve(cdKAssetDto.getReference()), StandardCopyOption.REPLACE_EXISTING);
        return cdKAssetDto;
    }
    
   
    @PreAuthorize("hasAnyRole('CD_ROLE_REGISTRANT')")
    @RequestMapping(value = "/asset/{reference}/description", method = RequestMethod.PUT)
    @ApiOperation("Purge digital asset")
    public boolean addNoteForAsset(@PathVariable String reference, @RequestParam String note) {
        CdKAssetDto cdKAssetDto = cdKAssetService.findByReference(reference);
        cdKAssetDto.setNote(note);
        cdKAssetService.save(cdKAssetDto);
        return true;
    }

    @PreAuthorize("hasAnyRole('CD_ROLE_REGISTRANT')")
    @RequestMapping(value = "/asset/{reference}/purge", method = RequestMethod.DELETE)
    @ApiOperation("Purge digital asset")
    public boolean purgeAsset(@PathVariable String reference) {
        CdKAssetDto cdKAssetDto = cdKAssetService.findByReference(reference);
        cdKAssetDto.setPurgable(1);
        cdKAssetService.save(cdKAssetDto);
        return true;
    }

    @RequestMapping(value = "/asset/{reference}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ApiOperation("Fetch digital asset")
    public byte[] fetchAsset(@PathVariable String reference) throws IOException {
        CdKAssetDto cdKAssetDto = cdKAssetService.findByReference(reference);
        String target = cdPathAsset + File.separator + cdKAssetDto.getReference();
        if (cdKAssetDto == null || !new File(target).exists()) {
            throw new CdException(CdErrors.CD_K_ASSET_FETCH_FAILURE_FILE_UNAVAILABLE);
        }
        InputStream in = new FileInputStream(new File(target).getCanonicalFile());
        return IOUtils.toByteArray(in);
    }

    @RequestMapping(value = "/asset/{reference}/thumb/{size}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation("Fetch digital asset in thumbnail")
    public byte[] fetchAssetThumbnail(@PathVariable String reference, @PathVariable int size) throws IOException {
        CdKAssetDto cdKAssetDto = cdKAssetService.findByReference(reference);
        String target = cdPathAsset + File.separator + "VnKAny" + File.separator + cdKAssetDto.getReference();

        if (cdKAssetDto == null || !new File(target).exists()) {
            throw new CdException(CdErrors.CD_K_ASSET_FETCH_FAILURE_FILE_UNAVAILABLE);
        }

        InputStream in = new FileInputStream(new File(target).getCanonicalFile());
        BufferedImage bufferedImage = ImageIO.read(in);

        if (bufferedImage == null) {
            return new byte[0];
        }

        boolean portrait = bufferedImage.getHeight() / size > bufferedImage.getWidth() / size;
        float targetWidth = portrait ? size * bufferedImage.getWidth() / bufferedImage.getHeight() : size;
        float targetHeight = portrait ? size : size * bufferedImage.getHeight() / bufferedImage.getWidth();

        BufferedImage thumbImage = new BufferedImage((int)targetWidth, (int)targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = thumbImage.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(targetWidth/bufferedImage.getWidth(), targetHeight/bufferedImage.getHeight());
        g.drawRenderedImage(bufferedImage, at);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(thumbImage, "jpg", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();

        return imageInByte;
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    @ApiOperation("Fetch notice")
    public List<CdKNoticeDto> fetchNotice() {

        // TODO

        List<CdKNoticeDto> cdKNoticeDtoList = new ArrayList<>();
        return cdKNoticeDtoList;
    }
}