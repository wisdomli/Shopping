package soexample.umeng.com.shopping.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.shopping.R;
import soexample.umeng.com.shopping.activity.MainActivity;
import soexample.umeng.com.shopping.fragment.HomeFragment;
import soexample.umeng.com.shopping.fragment.ListFragment;
import soexample.umeng.com.shopping.fragment.ShopingFragment;
import soexample.umeng.com.shopping.fragment.WodeFragment;
import soexample.umeng.com.shopping.mvp.view.AppDelegate;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class MainActivityPersenter extends AppDelegate{


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] title = {"首页","列表","购物车","我的"};
    private List<Fragment> listFRagment = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    public void initData() {
        super.initData();

         viewPager = get(R.id.viewpager);
         tabLayout =(TabLayout) get(R.id.tablayout);

        listFRagment.add(new HomeFragment());
        listFRagment.add(new ListFragment());
        listFRagment.add(new ShopingFragment());
        listFRagment.add(new WodeFragment());
        FragmentManager supportFragmentManager = ((MainActivity) context).getSupportFragmentManager();
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPageAdpter(supportFragmentManager);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class FragmentPageAdpter extends FragmentPagerAdapter{

        public FragmentPageAdpter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int i) {

            return listFRagment.get(i);
        }

        @Override
        public int getCount() {
            return listFRagment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }



    private Context context;
    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }
}
