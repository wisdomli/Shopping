package soexample.umeng.com.shopping.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import soexample.umeng.com.shopping.net.Okhttp;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public abstract class AppDelegate implements IDelegate{


    private View rootview;

    @Override
    public void initData() {

    }

    private SparseArray<View> views = new SparseArray<>();
    public <T extends View> T get(int id){
        T view = (T) views.get(id);
        if (view == null){
            view = rootview.findViewById(id);
            views.put(id,view);
        }
        return view;
    }

    public void getClik(View.OnClickListener listener,int... ids){
        if (ids == null){
            return;
        }
        for (int id : ids){
            get(id).setOnClickListener(listener);
        }
    }



    @Override
    public void crate(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        rootview = inflater.inflate(getLayoutId(), viewGroup, false);
    }



    @Override
    public View rootView() {
        return rootview;
    }
    private Context context;
    @Override
    public void getContext(Context context) {
     this.context = context;
    }
    public abstract int getLayoutId();


    @Override
    public void getString(final int type, String url){
      new Okhttp().get(url).resout(new Okhttp.HttpLisenter() {
          @Override
          public void suecss(String data) {
              suecssString(type,data);
          }

          @Override
          public void fail() {

          }
      });

    }


    public void suecssString(int type,String data){}

    public void failString(String error){}

    @Override
    public void destry() {
        rootview = null;
    }
}
