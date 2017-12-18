package net.cd.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

public class LocaleUtil {
    /**
     * Default locale
     */
    public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final Map<String, Locale> LOCALE_MAP = new HashMap<>();
    private static final Map<Locale, String> SUFFIX_MAP = new HashMap<>();


    static {
        LOCALE_MAP.put(Locale.ENGLISH.toString().toLowerCase(), Locale.ENGLISH);
        LOCALE_MAP.put(Locale.SIMPLIFIED_CHINESE.toString().toLowerCase(), Locale.SIMPLIFIED_CHINESE);
        LOCALE_MAP.put(Locale.TRADITIONAL_CHINESE.toString().toLowerCase(), Locale.TRADITIONAL_CHINESE);

        LOCALE_MAP.put("en", Locale.ENGLISH);
        LOCALE_MAP.put("zh-hans", Locale.SIMPLIFIED_CHINESE);
        LOCALE_MAP.put("zh-hant", Locale.TRADITIONAL_CHINESE);

        SUFFIX_MAP.put(null, "En");
        SUFFIX_MAP.put(Locale.ENGLISH, "En");
        SUFFIX_MAP.put(Locale.SIMPLIFIED_CHINESE, "ZhCn");
        SUFFIX_MAP.put(Locale.TRADITIONAL_CHINESE, "ZhTw");
    }

    /**
     * @param localeName locale name (en, zh_ch, zh_tw, zh-hant, zh-nahs), case insensitive
     * @return locale instance for given locale name
     */
    public static Locale toLocale(String localeName) {
        Locale locale = StringUtils.isEmpty(localeName) ? DEFAULT_LOCALE : LOCALE_MAP.get(localeName.toLowerCase());
        return locale != null ? locale : DEFAULT_LOCALE;
    }

    /**
     * @param request HTTP servlet request
     * @return locale for http request
     */
    public static Locale getLocale(HttpServletRequest request) {
        return toLocale(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
    }

    /**
     * @param request web request
     * @return locale for http request
     */
    public static Locale getLocale(WebRequest request) {
        return toLocale(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
    }

    /**
     * @param locale locale
     * @return suffix for localized java bean properties
     */
    public static String suffixFor(Locale locale) {
        return SUFFIX_MAP.get(locale);
    }

    /**
     * @param en     english object
     * @param zhCn   simplified chinese object
     * @param zhTw   traditional chinese object
     * @param locale locale (must be not null)
     * @param <T>    object type
     * @return object for given locale<br/>
     * if locale is SIMPLIFIED_CHINESE, returns zhCn<br/>
     * else if locale is TRADITIONAL_CHINESE, returns zhTw<br/>
     * else returns en
     */
    public static <T> T forLocale(T en, T zhCn, T zhTw, Locale locale) {
        if (locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            return zhCn;
        } else if (locale.equals(Locale.TRADITIONAL_CHINESE)) {
            return zhTw;
        } else {
            return en;
        }
    }

    /**
     * @param en     english supplier
     * @param zhCn   simplified chinese supplier
     * @param zhTw   traditional chinese supplier
     * @param locale locale (must be not null)
     * @param <T>    result type
     * @param <S>    supplier
     * @return returns supplied value for given locale<br/>
     * if locale is SIMPLIFIED_CHINESE, returns value by simplified chinese supplier<br/>
     * else if locale is TRADITIONAL_CHINESE, returns value by traditional chinese supplier<br/>
     * else returns value by english supplier
     */
    public static <T, S extends Supplier<T>> T getForLocale(S en, S zhCn, S zhTw, Locale locale) {
        return forLocale(en, zhCn, zhTw, locale).get();
    }

    public static <T> T forLocaleOrEn(T en, T zhCn, T zhTw, Locale locale) {
        T forLocale = forLocale(en, zhCn, zhTw, locale);
        return forLocale == null ? en : forLocale;
    }

    public static <T> T forLocaleOrDefault(T defaultValue, T zhCn, Locale locale) {
        return forLocaleOrEn(defaultValue, zhCn, null, locale);
    }

    public static <T> T forLocale(T zhCn, T zhTw, Locale locale) {
        if (locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            return zhCn;
        } else {
            return zhTw;
        }
    }

    public static <T> T forLocaleWithFallback(T en, T zhCn, T zhTw, Locale locale) {
        if (locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            return forCnWithFallback(en, zhCn, zhTw, locale);
        }
        if(locale.equals(Locale.TRADITIONAL_CHINESE)) {
            return forTwWithFallback(en, zhTw);
        }
        return en;
    }

    private static <T> T forCnWithFallback(T En, T zhCn, T zhTw, Locale locale) {
        return StringUtils.isEmpty(zhCn)
                ? forTwWithFallback(En, zhTw)
                : zhCn;
    }

    private static <T> T forTwWithFallback(T En, T zhTw) {
        return StringUtils.isEmpty(zhTw) ? En : zhTw;
    }
}
