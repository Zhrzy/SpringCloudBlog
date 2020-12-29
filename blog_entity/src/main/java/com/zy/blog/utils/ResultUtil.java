package com.zy.blog.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zy 1716457206@qq.com
 * 接口响应结果
 */
public class ResultUtil {

    /** @Author zy
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
}
