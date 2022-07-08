package com.zy.blog.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;


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
