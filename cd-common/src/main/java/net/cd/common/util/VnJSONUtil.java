package net.cd.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Tree.Yip on 2/8/2016.
 */
public class VnJSONUtil {

    public static synchronized boolean isJSON(String in) {
        boolean valid = true;
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(in);
        } catch(JsonProcessingException e){
            valid = false;
        } catch (IOException e) {
            valid = false;
        }
        return valid;
    }
}
