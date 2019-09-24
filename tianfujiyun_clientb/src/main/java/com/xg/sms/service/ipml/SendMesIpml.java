package com.xg.sms.service.ipml;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xg.sms.entity.SendParam;

import com.xg.sms.service.SendMes;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SendMesIpml implements SendMes {

    @Override
    public boolean SendMessage(SendParam sendParam) {
            try{
            /**
             * 这是key（需要申请阿里云） 目前Kid是错的
             */
            DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIDIsyxj7PScou", "StIDEsLEJ94K6IdclVQcOUWXHzmBfK");
            IAcsClient client = new DefaultAcsClient(profile);
            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain("dysmsapi.aliyuncs.com");
            request.setVersion("2017-05-25");
            request.setAction("SendSms");
            request.putQueryParameter("RegionId", "default");
            /**
             * 这是你需要发送信息的手机号
             */
            if (sendParam.getTelIphone().trim().length() != 11){
                System.out.println("手机号格式有误！");
            }else{
                String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(sendParam.getTelIphone().trim());
                if (m.matches()){
                    request.putQueryParameter("PhoneNumbers", sendParam.getTelIphone().trim());
                    }
            }
            /**
             * 这是签名名称（需要申请）
             */
            request.putQueryParameter("SignName", "乔家大院");
            /**
             * 申请短信模板的code。
             */
            request.putQueryParameter("TemplateCode", "SMS_173247860");
//         int radomInt = new Random().nextInt(999999);
//            int radomInt2 =(int)((Math.random()*9+1)*100000);
            String code = sendParam.getCode().trim();
            request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
            try {
                CommonResponse response = client.getCommonResponse(request);
                System.out.println(response.getData());
            } catch (ServerException e) {
                e.printStackTrace();
                return  false;
            } catch (ClientException e) {
                e.printStackTrace();
                return  false;
            }
                return  true;
            }catch(Exception e){
                e.printStackTrace();
                return  false;
            }
    }
}
