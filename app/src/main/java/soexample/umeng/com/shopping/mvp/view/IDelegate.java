package soexample.umeng.com.shopping.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public interface IDelegate {

    void  initData();

    void crate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle);

    View rootView();

    void getContext(Context context);

    void getString(int type,String url);

    void destry();
}
