package bw.com.xutao0831aft.untils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {

    //单例模式
    private static NetUtil netUtil = null;

    private NetUtil(){}

    public static NetUtil getInstance(){
        if (netUtil==null){
            synchronized (NetUtil.class){
                if (netUtil==null) {
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    //网络判断
    public boolean getWang(Context context){

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null) {
            return info.isAvailable();
        }
        return false;
    }

}
