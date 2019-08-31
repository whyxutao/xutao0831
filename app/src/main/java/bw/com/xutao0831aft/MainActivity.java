package bw.com.xutao0831aft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bw.com.xutao0831aft.base.BaseActivity;
import bw.com.xutao0831aft.contract.HomeContract;

public class MainActivity extends BaseActivity implements HomeContract.IView {


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError(Throwable e) {

    }
}
