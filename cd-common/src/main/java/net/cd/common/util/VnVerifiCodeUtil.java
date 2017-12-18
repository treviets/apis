package net.cd.common.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tree.Yip on 4/4/2016.
 */
public class VnVerifiCodeUtil {

    public static String generate(int length) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < length; x++) {
            builder.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return builder.toString();
    }
}
