package soexample.umeng.com.shopping.fragment;

import soexample.umeng.com.shopping.mvp.presenter.BaseFragmentPresenter;
import soexample.umeng.com.shopping.presenter.ShopingFragmentPresenter;
import soexample.umeng.com.shopping.presenter.WodeFragmentPsenter;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class WodeFragment extends BaseFragmentPresenter<WodeFragmentPsenter>{
    @Override
    public Class<WodeFragmentPsenter> getClassDelegate() {
        return WodeFragmentPsenter.class;
    }
}
