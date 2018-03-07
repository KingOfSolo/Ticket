package nju.edu.util;

import org.json.JSONObject;

/**
 * Created by xiaoJun on 2018/3/7.
 */
public class JSONResult {
    public static String fillResultString(Integer status, String message, Object result){
        JSONObject jsonObject = new JSONObject(){{
            put("status", status);
            put("message", message);
            put("result", result);
        }};
        return jsonObject.toString();
    }
}
