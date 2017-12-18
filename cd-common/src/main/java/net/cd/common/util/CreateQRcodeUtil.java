package net.cd.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class CreateQRcodeUtil {
    public static void createQrCode(String text,OutputStream out){
        int width = 300;
        int height = 300;
        String format = "png";
        Hashtable<EncodeHintType, Object> hints= new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        try {
            MatrixToImageWriter.writeToStream(bitMatrix,format,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
