package soexample.umeng.com.shopping.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import soexample.umeng.com.shopping.mvp.view.IDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public abstract class BaseFragmentPresenter<T extends IDelegate> extends Fragment{

    private  T delegate;

    public abstract Class<T> getClassDelegate();
    public BaseFragmentPresenter(){
        try {
             delegate = getClassDelegate().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        delegate.crate(inflater,container,savedInstanceState);
        return delegate.rootView();

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        delegate.getContext(getActivity());
        delegate.initData();
    }


}
