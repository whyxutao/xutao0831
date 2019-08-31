package bw.com.xutao0831aft.untils;

import android.os.Handler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

    //单例模式
    private static HttpUtil httpUtil = null;

    private HttpUtil(){}

    public static HttpUtil getInstance(){
        if (httpUtil==null) {
            synchronized (HttpUtil.class){
                if (httpUtil==null) {
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }

    //定义接口
    public interface ICallBack{
        void Success(Object obj);
        void Error(String msg);
    }

    //创建Handler
    private Handler handler = new Handler();

    //获取数据
    public void getJson(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    int responseCode = connection.getResponseCode();
                    if (responseCode==200) {
                        InputStream inputStream = connection.getInputStream();
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read(buffer))!=-1){
                            bos.write(buffer,0,len);
                        }
                        final String json = bos.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (iCallBack!=null) {
                                    iCallBack.Success(json);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
