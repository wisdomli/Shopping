package soexample.umeng.com.shopping.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.shopping.R;
import soexample.umeng.com.shopping.adpater.ShangJiaAdapter;
import soexample.umeng.com.shopping.moudle.ShoppinBean;
import soexample.umeng.com.shopping.mvp.view.AppDelegate;
import soexample.umeng.com.shopping.net.Http;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class ShopingFragmentPresenter extends AppDelegate implements View.OnClickListener {
    private ShangJiaAdapter shangJiaAdapter;
    private ImageView car_cricles;

    private List<ShoppinBean.DataBean> data1 = new ArrayList<>();
    private TextView zongji;
    private TextView sum_num;
    private ImageView child;


    @Override
    public int getLayoutId() {
        return R.layout.layout_shopping;


    }

    @Override
    public void initData() {
        super.initData();
//        child =(ImageView) get(R.id.car_cricle);
        RecyclerView recyclerView = get(R.id.show_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        shangJiaAdapter = new ShangJiaAdapter(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shangJiaAdapter);
        getString(0, Http.url);
        // 全选
        getClik(this, R.id.quanxuanzz);
        car_cricles = get(R.id.quanxuanzz);
        zongji = (TextView) get(R.id.zongji);
        sum_num = (TextView) get(R.id.sum_num);
        //接口回调获取状态
        shangJiaAdapter.setlisenter(new ShangJiaAdapter.ShopingCarBackLienter() {
            @Override
            public void CarBack(List<ShoppinBean.DataBean> list) {
                double allPice = 0;
                int num = 0;
                int allnum = 0;

                for (int a = 0; a < list.size(); a++) {
                    List<ShoppinBean.DataBean.ListBean> listAll = list.get(a).getList();

                    for (int i = 0; i < listAll.size(); i++) {
                        allnum = allnum + listAll.get(i).getNum();
                        // 去选中的状态
                        if (listAll.get(i).isCheck()) {
                            allPice = allPice + (listAll.get(i).getNum() * listAll.get(i).getPrice());
                            num = num + listAll.get(i).getNum();
                        }

                    }
                }
                child =(ImageView) get(R.id.car_cricle);
                if(num<allnum){// 判断是否被选中
                    child.setImageResource(R.drawable.cricle_no);
                    isChaict = true;
                }else {
                    child.setImageResource(R.drawable.cricle_yes);
                    isChaict = false;
                }

                zongji.setText("总价" + allPice);
                sum_num.setText("去计算(" + num + ")");
            }
        });

    }

    @Override
    public void suecssString(int type, String data) {
        super.suecssString(type, data);
        switch (type) {
            case 0:
                Gson gson = new Gson();
                ShoppinBean shoppinBean = gson.fromJson(data, ShoppinBean.class);
                data1 = shoppinBean.getData();
                shangJiaAdapter.setList(data1);

                break;
        }
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    private boolean isChaict = true;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.quanxuanzz:
                if (isChaict) {
                    car_cricles.setImageResource(R.drawable.cricle_yes);
                    isChaict = false;
                    childCk(true);
                } else {
                    car_cricles.setImageResource(R.drawable.cricle_no);
                    isChaict = true;
                    childCk(false);
                }
                break;
        }
    }

    private void childCk(boolean bool) {
        double allPrice = 0;
        int num = 0;

        for (int i = 0; i < data1.size(); i++) {
            List<ShoppinBean.DataBean.ListBean> listAll = data1.get(i).getList();
            for (int j = 0; j < listAll.size(); j++) {
                // 千万记住 不能写错下标
                listAll.get(j).setCheck(bool);
                allPrice = allPrice + (listAll.get(j).getPrice() * listAll.get(j).getNum());
                num = num + listAll.get(j).getNum();
            }
        }

        if (bool) {
            zongji.setText("总价" + allPrice);
            sum_num.setText("去计算(" + num + ")");
        } else {
            zongji.setText("总计");
            sum_num.setText("去计算(0)");
        }
        shangJiaAdapter.notifyDataSetChanged();
    }


}
