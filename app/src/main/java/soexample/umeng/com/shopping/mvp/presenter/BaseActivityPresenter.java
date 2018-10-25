package soexample.umeng.com.shopping.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import soexample.umeng.com.shopping.mvp.view.IDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public abstract class BaseActivityPresenter <T extends IDelegate> extends AppCompatActivity {

    private  T delegate;

    public abstract Class<T>  getClassDelegate();

    public BaseActivityPresenter(){
        try {
            delegate = getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate.crate(getLayoutInflater(),null,savedInstanceState);
        setContentView(delegate.rootView());
        delegate.getContext(this);
        delegate.initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delegate.destry();
        delegate= null;
    }
}
