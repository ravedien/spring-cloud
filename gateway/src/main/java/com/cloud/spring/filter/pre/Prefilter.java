package com.cloud.spring.filter.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class Prefilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(Prefilter.class);
	private static final String CONSTANT_PRE = "pre";

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		logger.info("%s request to %s", request.getMethod(), request.getRequestURL().toString());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return CONSTANT_PRE;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
