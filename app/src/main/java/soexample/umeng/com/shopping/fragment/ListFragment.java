package soexample.umeng.com.shopping.fragment;

import soexample.umeng.com.shopping.mvp.presenter.BaseFragmentPresenter;
import soexample.umeng.com.shopping.presenter.ListFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class ListFragment extends BaseFragmentPresenter<ListFragmentPresenter>{
    @Override
    public Class<ListFragmentPresenter> getClassDelegate() {
        return ListFragmentPresenter.class;
    }
}
