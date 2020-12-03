package com.zyq.http;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class OkHttpUtil {
    public static void getONetWorkStringGet(String phone) {
        Logger logger=LoggerFactory.getLogger(Logger.class);
        String url = "https://www.ykt100.com/api/admin/mobile/sendMobile/common?mobile="+phone;
        String url1="https://developer.i4.cn/put/getMsgCode.xhtml?_=1606442692517&phoneNumber="+phone+"&codeType=6";
        List<String> list=new ArrayList<>();
        list.add(url);
        list.add(url1);
        for(String item:list){
            OkHttpClient build = new OkHttpClient.Builder()
                    .sslSocketFactory(createSSLSocketFactory())
                    .hostnameVerifier(new OkHttpUtil.TrustAllHostnameVerifier())
                    .build();
            final Request request = new Request.Builder().get().url(item).build();
            Call call  = build.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    logger.info(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException
                {
                    String res = response.body().string();
                }
            });
        }
    }
    public static void getONetWorkStringPost(String phone) {
        OkHttpClient build = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new OkHttpUtil.TrustAllHostnameVerifier())
                .build();
        String url1="https://api.gaotu100.com/v1/user/sendPasscode";
        String url3="https://www.tswq8.com/regMsg";
        List<String> list=new ArrayList<>();
        list.add(url3);
        RequestBody body = new FormBody.Builder()
                .add("mobile",phone)
                .add("type","3").build();
        RequestBody body1 = new FormBody.Builder()
                .add("phone",phone).build();
        final Request request = new Request.Builder().url(url1).post(body).build();
        for(String item:list){
            final Request request1 = new Request.Builder().url(item).post(body1).build();
            Call          call1    = build.newCall(request1);
            call1.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException
                {
                    String res = response.body().string();
                }
            });
        }
        Call          call    = build.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException
            {
                String res = response.body().string();
            }
        });
    }


    private static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
    }
    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null,  new TrustManager[] { new OkHttpUtil.TrustAllCerts() }, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }
}