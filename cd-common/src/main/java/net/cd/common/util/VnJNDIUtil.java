package net.cd.common.util;

import org.springframework.jndi.JndiLocatorDelegate;

import javax.naming.NamingException;

/**
 * Created by Tree.Yip on 3/4/2016.
 */
public class VnJNDIUtil {

    private static VnJNDIUtil ourInstance = new VnJNDIUtil();
    private String profile;

    public static VnJNDIUtil getInstance() {
        return ourInstance;
    }

    private VnJNDIUtil() {
        JndiLocatorDelegate jndiLocatorDelegate = JndiLocatorDelegate.createDefaultResourceRefLocator();
        try {
            this.profile = jndiLocatorDelegate.lookup("java:/comp/env/cd/springProfilesActive", String.class).split(",")[0];
        } catch (NamingException ignore) {}
    }

    public synchronized String getString(String name) {
        JndiLocatorDelegate jndiLocatorDelegate = JndiLocatorDelegate.createDefaultResourceRefLocator();
        String rtn = null;
        try {
            rtn = jndiLocatorDelegate.lookup("java:/comp/env/cd/" + this.profile + "/" + name, String.class);
        } catch (NamingException ignore) {}
        return rtn;
    }

    public synchronized Integer getInteger(String name) {
        JndiLocatorDelegate jndiLocatorDelegate = JndiLocatorDelegate.createDefaultResourceRefLocator();
        Integer rtn = null;
        try {
            rtn = jndiLocatorDelegate.lookup("java:/comp/env/cd/" + this.profile + "/" + name, Integer.class);
        } catch (NamingException ignore) {}
        return rtn;
    }

    public synchronized Boolean getBoolean(String name) {
        JndiLocatorDelegate jndiLocatorDelegate = JndiLocatorDelegate.createDefaultResourceRefLocator();
        Boolean rtn = null;
        try {
            rtn = jndiLocatorDelegate.lookup("java:/comp/env/cd/" + this.profile + "/" + name, Boolean.class);
        } catch (NamingException ignore) {}
        return rtn;
    }
}
