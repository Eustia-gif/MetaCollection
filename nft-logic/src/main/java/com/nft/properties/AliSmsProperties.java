package com.nft.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AliSmsProperties {

    @Getter
    public static String accessKeyId;
    @Getter
    public static String accessKeySecret;
    @Value("${aliyun.sms.access-key-id}")
    public void setAccessKeyId(String accessKeyId) {
        AliSmsProperties.accessKeyId = accessKeyId;
    }
    @Value("${aliyun.sms.access-key-secret}")
    public void setAccessKeySecret(String accessKeySecret) {
        AliSmsProperties.accessKeySecret = accessKeySecret;
    }

}