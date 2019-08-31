package bw.com.xutao0831aft.model;

import bw.com.xutao0831aft.app.App;
import bw.com.xutao0831aft.contract.HomeContract;
import bw.com.xutao0831aft.untils.HttpUtil;
import bw.com.xutao0831aft.untils.NetUtil;

public class HomeModel implements HomeContract.IMdel {
    @Override
    public void getModelData(String path) {
        if (NetUtil.getInstance().getWang(App.context)){
            HttpUtil.getInstance().getJson(path, new HttpUtil.ICallBack() {
                @Override
                public void Success(Object obj) {

                }

                @Override
                public void Error(String msg) {

                }
            });
        }else {

        }

    }
}
