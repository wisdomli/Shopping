package soexample.umeng.com.shopping.fragment;

import soexample.umeng.com.shopping.mvp.presenter.BaseFragmentPresenter;
import soexample.umeng.com.shopping.presenter.ListFragmentPresenter;
import soexample.umeng.com.shopping.presenter.ShopingFragmentPresenter;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class ShopingFragment extends BaseFragmentPresenter<ShopingFragmentPresenter>{
    @Override
    public Class<ShopingFragmentPresenter> getClassDelegate() {
        return ShopingFragmentPresenter.class;
    }
}
