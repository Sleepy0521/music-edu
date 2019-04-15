package com.music.service.impl;

import com.music.service.ImgClientService;
import com.music.service.VideoClientService;
import com.music.utils.Msg;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ImgClientServiceFallbackFactory implements FallbackFactory<ImgClientService> {
    @Override
    public ImgClientService create(Throwable throwable) {
        return new ImgClientService() {
            @Override
            public Msg getImg() {
                return Msg.fail().add("info","未能成功调取到provider提供的接口，这是服务降级返回的信息--ImgController");
            }
        };
    }
}
