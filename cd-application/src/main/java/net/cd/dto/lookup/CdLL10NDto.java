package net.cd.dto.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Vincent 01/12/2017
 */
public class CdLL10NDto {

    @JsonProperty("en_US")
    private String enUs;
    @JsonProperty("zh_HK")
    private String zhHk;
    @JsonProperty("zh_TW")
    private String zhTw;
    @JsonProperty("zh_Hans")
    private String zhHans;

    public CdLL10NDto() {
    }

    public CdLL10NDto(String enUs, String zhHk, String zhHans) {
        this.enUs = enUs;
        this.zhHk = zhHk;
        this.zhHans = zhHans;
    }

    public String getEnUs() {
        return enUs;
    }

    public void setEnUs(String enUs) {
        this.enUs = enUs;
    }

    public String getZhHk() {
        return zhHk;
    }

    public void setZhHk(String zhHk) {
        this.zhHk = zhHk;
    }

    public String getZhTw() {
        return zhTw;
    }

    public void setZhTw(String zhTw) {
        this.zhTw = zhTw;
    }

    public String getZhHans() {
        return zhHans;
    }

    public void setZhHans(String zhHans) {
        this.zhHans = zhHans;
    }

    public String getLocalized(String acceptLanguage) {
        if (acceptLanguage.contains("zh")) {
            return (acceptLanguage.equalsIgnoreCase("zh-Hant") || acceptLanguage.equalsIgnoreCase("zh-HK") || acceptLanguage.equalsIgnoreCase("zh-TW")) ? zhHk : zhHans;
        }
        return enUs;
    }
}
