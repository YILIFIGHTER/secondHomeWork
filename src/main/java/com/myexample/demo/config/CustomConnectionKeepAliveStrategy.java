package com.myexample.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.hc.client5.http.ConnectionKeepAliveStrategy;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CustomConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    private final long DEFAULT_SECONDS = 30;
    public static final String CONN_KEEP_ALIVE = "Keep-Alive";

    @Override
    public TimeValue getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long timeout = Arrays.stream(httpResponse.getHeaders(CONN_KEEP_ALIVE))
                .filter(h -> StringUtils.endsWithIgnoreCase(h.getName(), "timeout")
                                && StringUtils.isNumeric(h.getValue()))
                .findFirst()
                .map(h -> NumberUtils.toLong(h.getValue(), DEFAULT_SECONDS))
                .orElse(DEFAULT_SECONDS) * 1000;
        return TimeValue.of(timeout, TimeUnit.SECONDS);
    }
}
