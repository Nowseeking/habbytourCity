package com.fh.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


public class SmsUtils {


    //短信API产品名称
    static final String product="Dysmsapi";
    //短信API产品域名
    static final String domain="dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAI4GFm8DdrW1ETYQ6DiqYs";
    static final String accessKeySecret = "W6sYOkkuzZC5AyTeyamixoNbqWr4cM";

    public static SendSmsResponse sendSms(String telphone) throws Exception{
        int code = (int)(Math.random()*9999)+1000;
        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "60000");
        System.setProperty("sun.net.client.defaultReadTimeout", "60000");
        //初始化ascClient
        IClientProfile profile= DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou",product, domain);
        IAcsClient acsClient=new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request=new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //待发送的手机号
        request.setPhoneNumbers(telphone);
        //短信签名
        request.setSignName("实训1912");
        //短信模板ID
        request.setTemplateCode("SMS_205401689");
        /*
         * 可选:模板中的变量替换JSON串,
         * 如模板内容为"亲爱的${name},您的验证码为${code}"时,
         * 此处的值为{"name":"Tom","code":"44"}
         *   \  反斜杠为转义字符，使得输出双引号
         */
        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\""+code+"\"}");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("44");
        SendSmsResponse response=acsClient.getAcsResponse(request);
        response.setMessage(String.valueOf(code));
       /* Map<Object, Object> map = new HashMap<>();
        map.put("data",code);
        map.put("code",200);*/
        return response;
    }
 }
