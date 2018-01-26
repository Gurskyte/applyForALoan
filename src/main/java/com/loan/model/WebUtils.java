package com.loan.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebUtils {

    private HttpServletRequest request;

    @Autowired
    public WebUtils(HttpServletRequest request) {
        this.request = request;
    }


    public String getClientIp(){
        return request.getRemoteAddr();
    }
}
