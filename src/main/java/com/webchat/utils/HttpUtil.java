package com.webchat.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
    public static void ajaxSendResponse(HttpServletResponse response, Object object){
        try {
            ajaxSendResponse(response, "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ajaxSendResponse(HttpServletResponse response, String content) throws IOException{
        if(content == null)
            content = "";
        PrintWriter writer = response.getWriter();
        writer.print(content);
        writer.flush();
    }
}
