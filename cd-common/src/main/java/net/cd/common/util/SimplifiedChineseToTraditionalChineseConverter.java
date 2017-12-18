package net.cd.common.util;

public class SimplifiedChineseToTraditionalChineseConverter {
    public static String convert(String sc){
        if(sc == null || sc.equals("")){
            return sc;
        }
        return VnZHConverter.convert(sc, VnZHConverter.TRADITIONAL);
    }
}


