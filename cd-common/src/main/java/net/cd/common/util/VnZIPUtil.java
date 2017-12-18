package net.cd.common.util;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Tree.Yip on 6/8/2016.
 */
public class VnZIPUtil {

    public byte[] deflate(List<FileInputStream> fileInputStreamList, List<String> fileNameList) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        for (int i = 0; i < fileInputStreamList.size(); i++) {
            ZipEntry entry = new ZipEntry(fileNameList.get(i));
            zos.putNextEntry(entry);
            zos.write(IOUtils.toByteArray(fileInputStreamList.get(i)));
            zos.closeEntry();
        }
        zos.close();
        return baos.toByteArray();
    }
}
