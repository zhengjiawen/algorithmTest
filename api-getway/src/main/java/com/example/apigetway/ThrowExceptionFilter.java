package com.example.apigetway;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ThrowExceptionFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run()  {
        logger.info("pre filter,throw a RuntimeException");
        RequestContext requestContext = RequestContext.getCurrentContext();
        try{

            doSomething();
        }catch (Exception e){
            throw new ZuulRuntimeException(e);
        }
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    private void doSomething(){
        throw new RuntimeException("Exit with error...");
    }
}
