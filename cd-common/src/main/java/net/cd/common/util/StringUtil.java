package net.cd.common.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

public class StringUtil {

    /**
     * @param text text
     * @return list of non repeatable words, not null
     */
    public static List<String> textToWords(String text) {
        return StringUtils.isEmpty(text) ?
                Collections.emptyList() :
                Stream.of(text).
                        flatMap(s -> Arrays.stream(s.split("\\s"))).
                        map(String::trim).
                        filter(s -> !s.isEmpty()).
                        map(String::toLowerCase).
                        distinct().
                        collect(Collectors.toList());
    }

}
