package com.zemel.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

public class TestZuulFallbackFactory implements ZuulFallbackProvider {


    @Override
    public ClientHttpResponse fallbackResponse() {

        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "text/html;charset=UTF-8");

                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                // 当出现服务调用错误之后返回的内容
                // 服务端死掉，会自动找zuul的失败回退服务降级
                return new ByteArrayInputStream("\"deptno\":7777,\"dname\":\"【error】Zuul-Fallback\",\"loc\":\"Gateway\"".getBytes());
            }

            @Override
            public String getStatusText() throws IOException {

                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {

                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {

                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public void close() {
                // TODO Auto-generated method stub

            }
        };
    }

    @Override
    public String getRoute() {

        // 设置好处理失败的路由
        return "dept-8001";
    }

}