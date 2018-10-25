package soexample.umeng.com.shopping.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.shopping.R;
import soexample.umeng.com.shopping.moudle.ShoppinBean;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25.
 **/
public class ShangJiaAdapter extends RecyclerView.Adapter<ShangJiaAdapter.MyHolder> {
    private List<ShoppinBean.DataBean> list = new ArrayList<>();
    private Context context;

    public ShangJiaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_shangjia, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        myHolder.textView.setText(list.get(i).getSellerName());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        myHolder.recyclerView.setLayoutManager(linearLayoutManager);
        ShopingChildAdpter shopingChildAdpter = new ShopingChildAdpter(context, list.get(i).getList());
        myHolder.recyclerView.setAdapter(shopingChildAdpter);
        shopingChildAdpter.setLisenter(new ShopingChildAdpter.ShopCarBackLsiener() {
            @Override
            public void CarBack() {
                lienter.CarBack(list);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<ShoppinBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.show_RecyclerView);
            textView = itemView.findViewById(R.id.shangjia);
        }
    }
 private ShopingCarBackLienter lienter;
public void setlisenter (ShopingCarBackLienter lienter){
        this.lienter = lienter;
}
public interface  ShopingCarBackLienter{
        void CarBack(List<ShoppinBean.DataBean> list);
}
}
