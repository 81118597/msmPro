package com.zyq;
import com.aliyuncs.exceptions.ClientException;
import com.zyq.http.OkHttpUtil;
import com.zyq.msm.msmend;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException, ClientException {
        msmend msmend = new msmend();
        msmend.sendmsm("13347348678");
//        msm();
//        msm();//短信方法
        //冒泡排序
//        int[] j=new int[]{90,80,100,1};
//        for(int end=j.length;end>0;end--){
//            for(int i=1;i<end;i++){
//                if(j[i]<j[i-1]){ //90<100
//                    int tem=j[i];
//                    j[i]=j[i-1];
//                    j[i-1]=tem;
//                }
//            }
//        }
        //选择排序
//        int[] j=new int[]{90,80,100,1};
//        for(int start=0;start<j.length;start++){
//            int index=start;//角标
//            for(int i=start+1;i<=j.length-1;i++){
//                if(j[i]<j[index]){
//                    index=i;
//                }
//            }
//            int tem=j[index];
//            j[index]=j[start];
//            j[start]=tem;
//        }
//        for(int i=1;i<=9;i++){
//            for(int j=1;j<=i;j++){
//                System.out.print(j+"*"+i+"="+j*i+" ");
//            }
//            System.out.println(" ");
//        }
//        for(int i=100;i<1000;i++){
//            int bw=i/100;
//            int sw=i/10%10;
//            int gw=i%10;
//            if(i==(bw*bw*bw)+(sw*sw*sw)+(gw*gw*gw)){
//                System.out.println(i);
//            }
//        }


//        File file = new File("C:/Users/81118/Desktop/link.jpg");
//        FileOutputStream fi = new FileOutputStream("like.jpg");
//
//        FileInputStream fileInputStream = new FileInputStream(file);
//        int leng;
//        byte[] bytes = new byte[1024];
//        while ((leng=fileInputStream.read(bytes))!=-1){
//            fi.write(bytes,0,leng);
//        }
    }
    public static void msm(){
//        OkHttpUtil.getONetWorkStringGet("13347348678");
//        OkHttpUtil.getONetWorkStringPost("13347348678");
    }
}
