package soexample.umeng.com.shopping.fragment;

import soexample.umeng.com.shopping.mvp.presenter.BaseFragmentPresenter;
import soexample.umeng.com.shopping.presenter.HomeFragmentPsenter;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class HomeFragment extends BaseFragmentPresenter<HomeFragmentPsenter>{
    @Override
    public Class<HomeFragmentPsenter> getClassDelegate() {
        return HomeFragmentPsenter.class;
    }
}
