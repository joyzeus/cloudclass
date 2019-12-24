package com.jay.book.admin.interceptor.api;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    private int apiVersion;

    private int getApiVersion() {
        return apiVersion;
    }

    ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher matcher = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
        if (matcher.find()) {
            Integer version = Integer.valueOf(matcher.group(1));
            if (version >= this.apiVersion) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion() - this.apiVersion;
    }
}
