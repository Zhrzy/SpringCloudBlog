package com.zy.blog.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  小章鱼 1716457206@qq.com
 * 接口响应结果
 */
public class ResultUtil1 {
    final static String CODE = "code";
    final static String SUCCESS = "success";
    final static String ERROR = "error";
    final static String DATA = "data";
    final static String MESSAGE = "message";
    final static int NUM_TWO = 2;
    final static int NUM_THREE = 3;

    /** @author  小章鱼
     * @Description //接口返回的数据
     * @Param [code, message, data]
     * @return java.lang.String
     **/
    public static String result(String code, String message, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        return JsonUtils.objectToJson(map);
    }

    /**
     * @param code success error
     * @param data 返回的数据
     * @return String
     */
    public static String result(Object code, Object data) {
        return resultWithData(code, data);
    }

    /**
     * 返回结果【只携带数据】
     *
     * @param code success error
     * @param data 返回的数据
     * @return String
     */
    public static String resultWithData(Object code, Object data) {
        Map<Object, Object> map = new HashMap<>(NUM_TWO);
        map.put(CODE, code);
        map.put(DATA, data);
        return JsonUtils.objectToJson(map);
    }
    public static String successWithData(Object data) {
        return resultWithData(SUCCESS, data);
    }
}
