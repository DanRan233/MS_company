package com.wzk.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description:  阿里云短信发送工具类
 * @date 2020/11/15 16:13
 */
public class SendSmsUtil {


    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    //读取配置文件
    FileUtil fileUtil=new FileUtil();

    /**
     * description: 发送短信工具
     * TODO:
     * @date         2020/12/4 18:44
     * @author      DanRan233
     * @Param       [telephone, code]
     * @return      com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse
     */
    public  SendSmsResponse sendSms(String telephone, String code) throws ClientException {
        //超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        // 阿里云accessKeyId及accessKeySecret使用FileUtil工具类读取保证可替换性。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", fileUtil.getProperties("accessKeyId"), fileUtil.getProperties("accessKeySecret"));
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //待发送手机号
        request.setPhoneNumbers(telephone);
        //短信签名
        request.setSignName("DANRAN");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_205457462");//SMS_开头的模板Code
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("短信发送成功！");
        } else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
}
