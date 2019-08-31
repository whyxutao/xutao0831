package bw.com.xutao0831aft.contract;

import android.view.View;

public interface HomeContract {

    interface IView{
        //View 与 Presenter交互 获取Presenter数据传递给 View
        void onSuccess();
        void onError(Throwable e);
    }

    interface IPresenter{
        //绑定view
        void attachView(View view);
        //解绑
        void DetachView();
        //初始化model
        void getModel();

    }

    interface IMdel{
        //获取数据
        void getModelData(String path);
    }
}
