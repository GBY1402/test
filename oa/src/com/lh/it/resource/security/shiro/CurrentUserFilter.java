package com.lh.it.resource.security.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lh.it.resource.security.SecurityConstants;
import com.lh.it.resource.security.service.UserService;


@Component(value="currentUserFilter")
public class CurrentUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	
    	HttpServletRequest r_session = (HttpServletRequest)request; 
    	Object user = r_session.getSession().getAttribute(SecurityConstants.LOGIN_USER);
        request.setAttribute(SecurityConstants.LOGIN_USER, user);
        return true;
    }
}
