package com.webchat.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
    public static void ajaxSendResponse(HttpServletResponse response, WcResponse wcResponse){
        try {
            ajaxSendResponse(response, JSONObject.toJSONString(wcResponse));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ajaxSendResponse(HttpServletResponse response, String content) throws IOException{
        if(content == null)
            content = "";
        PrintWriter writer = response.getWriter();
        writer.print(content);
        writer.flush();
    }
}
