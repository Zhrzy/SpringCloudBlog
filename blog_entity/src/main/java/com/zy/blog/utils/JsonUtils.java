package com.zy.blog.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;


/**
 * @author  小章鱼 1716457206@qq.com
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /** @author  小章鱼
     * @Description //对象转json
     * @Param [obj]
     * @return java.lang.String
     **/
    public static String objectToJson (Object obj){

        //Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            //String json = gson.toJson(obj);
            String json = JSON.toJSONString(obj);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Json转换成Map<String, ?>
     *
     * @param json
     * @param clazz
     * @return
     */
    public static Map<String, ?> jsonToMap(String json, Class<?> clazz) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .serializeNulls()
                .create();
        Map<String, ?> map = null;
        try {
            Type type = new TypeToken<Map<String, ?>>() {
            }.getType();

            map = gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static  JSONObject strToJson(String str){
        if (str==null) str="";
        JSONObject jsonObject =JSON.parseObject(str);
        return jsonObject;
    }


    public static <T> T jsonToObj(String json,Class<T> Class){
        try {
            T t = objectMapper.readValue(json, Class);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
