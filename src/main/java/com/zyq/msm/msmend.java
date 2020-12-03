package com.zyq.msm;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zyq.utlis.RandomUtil;

import java.util.HashMap;

public class msmend {
    public  boolean sendmsm(String phone) throws ClientException {
        HashMap<String, Object> map = new HashMap<>();
            map.put("code", RandomUtil.getFourBitRandom());
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI4GA76zMtgTRZWaExJTda", "REhBb0pOns8xF4VSJRpftg0oHKOT8H");
        IAcsClient client = new DefaultAcsClient(profile);


        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "我的通威渔具在线网站");
        request.putQueryParameter("TemplateCode", "SMS_204287611");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));//转换json
        System.out.println(JSONObject.toJSONString(map));
        try {
            CommonResponse commonResponse = client.getCommonResponse(request);
            System.out.println(commonResponse.getData());
            boolean success = commonResponse.getHttpResponse().isSuccess();
            return success;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
