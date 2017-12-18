package net.cd.common.util;

import java.util.Random;

/**
 * Created by Tree.Yip on 19/11/2016.
 */
public class VnRfc6238SecretUtil {

    public static synchronized String generate(int length) {
        String[] allowedCharacters = {"2","3","4","5","6","7","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(allowedCharacters[rand.nextInt(allowedCharacters.length-1)]);
        }

        return stringBuilder.toString();
    }
}
