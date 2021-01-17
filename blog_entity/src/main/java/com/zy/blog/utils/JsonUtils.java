package com.zy.blog.utils;

import com.alibaba.fastjson.JSON;


/**
 * @author zy 1716457206@qq.com
 */
public class JsonUtils {

    /** @Author zy
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
}
