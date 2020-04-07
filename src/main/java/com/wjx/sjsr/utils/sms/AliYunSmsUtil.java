package com.wjx.sjsr.utils.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/***
 * @classname: AliYunSmsUtil
 * @description:
 * @author: wjx zhijiu
 * @date: 2020/02/26 14:00
 */
public class AliYunSmsUtil {

    static final String product = "Dysmsapi";

    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAI4FrfGhtidPykj1Y51LWp";

    static final String accessKeySecret = "D8hERsnNdIXQ5HHFtUBiC9NCYywPLT";

    static final String regionId = "cn-hangzhou";

    static final String signName = "小旁的博客";

    static final String templateCode = "SMS_184210310";

    public static SendSmsResponse sendSms(String telephone, String code){

        //超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        // 初始化acsClient
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint(regionId, regionId, product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(telephone);
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return sendSmsResponse;
    }

    /**
    验证码
     */
    public static void main(String[] args){
        String code = "123456";
        //填写你需要测试的手机号码
        SendSmsResponse sendSms =sendSms("18846085334", code);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSms.getCode());
        System.out.println("Message=" + sendSms.getMessage());
        System.out.println("RequestId=" + sendSms.getRequestId());
        System.out.println("BizId=" + sendSms.getBizId());

    }
}