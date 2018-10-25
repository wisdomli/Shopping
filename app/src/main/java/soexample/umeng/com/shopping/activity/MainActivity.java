package soexample.umeng.com.shopping.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import soexample.umeng.com.shopping.R;
import soexample.umeng.com.shopping.mvp.presenter.BaseActivityPresenter;
import soexample.umeng.com.shopping.presenter.MainActivityPersenter;

public class MainActivity extends BaseActivityPresenter<MainActivityPersenter> {

    @Override
    public Class<MainActivityPersenter> getClassDelegate() {
        return MainActivityPersenter.class;
    }


}
