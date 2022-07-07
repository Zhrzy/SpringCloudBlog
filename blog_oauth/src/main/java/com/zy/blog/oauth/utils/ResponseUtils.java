package com.zy.blog.oauth.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zy.blog.oauth.model.ResultMsg;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/22 13:23
 **/
public class ResponseUtils {
    public static void result(HttpServletResponse response, ResultMsg msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(msg).getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
