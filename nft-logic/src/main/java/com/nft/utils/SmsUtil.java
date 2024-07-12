package com.nft.utils;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.nft.properties.AliSmsProperties;
import org.springframework.stereotype.Component;

@Component
public class SmsUtil {
        public static com.aliyun.dysmsapi20170525.Client createClient() throws Exception {
            com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                    .setAccessKeyId(AliSmsProperties.getAccessKeyId())
                    .setAccessKeySecret(AliSmsProperties.getAccessKeySecret());
            config.endpoint = "dysmsapi.aliyuncs.com";
            return new com.aliyun.dysmsapi20170525.Client(config);
        }

    public static void sendSms(String code, String templateCode, String phoneNumber) throws Exception {
        System.out.println("Sending SMS...");
        com.aliyun.dysmsapi20170525.Client client = createClient();
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("nft")
                .setTemplateCode(templateCode)
                .setPhoneNumbers(phoneNumber)
                .setTemplateParam("{\"code\":\"" + code + "\"}");
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            client.sendSmsWithOptions(sendSmsRequest, runtime);
            System.out.println("SMS sent successfully.");
            System.out.println("Code: " + code+ " TemplateCode: " + templateCode + " PhoneNumber: " + phoneNumber);
        } catch (TeaException error) {
            System.out.println("Failed to send SMS: " + error.getMessage());
            System.out.println(error.getData().get("Recommend"));
            Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            System.out.println("Failed to send SMS: " + error.getMessage());
            System.out.println(error.getData().get("Recommend"));
            Common.assertAsString(error.message);
        }
    }
    }
