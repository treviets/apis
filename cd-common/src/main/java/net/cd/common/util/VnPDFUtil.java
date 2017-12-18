package net.cd.common.util;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Tree.Yip on 6/6/2016.
 */
public class VnPDFUtil {

    public static synchronized boolean fromXHTML(String in, String path) throws IOException, DocumentException {
        ITextRenderer renderer = new ITextRenderer();

        File hiragino = new File(System.getProperty("java.io.tmpdir") + File.separator + "Hiragino Sans GB W3.ttf");
        if (!hiragino.exists()) {
            Files.copy(VnPDFUtil.class.getResourceAsStream("/Hiragino Sans GB W3.ttf"), hiragino.toPath(), REPLACE_EXISTING);
        }
        renderer.getFontResolver().addFont(hiragino.getPath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        renderer.setDocumentFromString(in);
        renderer.layout();

        try {
            FileOutputStream fos = new FileOutputStream(path);
            renderer.createPDF(fos);
            fos.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
