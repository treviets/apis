package net.cd.extern.sms;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
public abstract class CdSMSAbstract {

    protected String url;
    public void setURL(String url) {
    		this.url = url;
    }
    public String getUrl() {
    		return url;
    }
    public abstract Object send()  throws Exception;
}
