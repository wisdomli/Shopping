package soexample.umeng.com.shopping.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import soexample.umeng.com.shopping.R;
import soexample.umeng.com.shopping.moudle.ShoppinBean;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class ShopingChildAdpter extends RecyclerView.Adapter<ShopingChildAdpter.MyHolder>{
    private List<ShoppinBean.DataBean.ListBean> list ;
    private Context context;

    public ShopingChildAdpter(Context context, List<ShoppinBean.DataBean.ListBean> list) {
        this.context = context;
       this.list = list;
    }

    @NonNull
    @Override
    public ShopingChildAdpter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.shop_car_adapter,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopingChildAdpter.MyHolder myHolder, final int i) {
        Glide.with(context).load(list.get(i).getImages().split("\\|")[0]).into(myHolder.imageView);
         myHolder.textView.setText(list.get(i).getTitle());
         myHolder.price.setText("价格:"+list.get(i).getPrice());

        // 判断 商品选中的状态
         if (list.get(i).isCheck()){
             myHolder.isck.setImageResource(R.drawable.cricle_yes);
         }else {
             myHolder.isck.setImageResource(R.drawable.cricle_no);
         }


       // 点击选中商品
        myHolder.isck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(i).isCheck()){
                    list.get(i).setCheck(false);
                }else {
                    list.get(i).setCheck(true);
                }
                notifyItemChanged(i);
                 lsiener.CarBack();
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView,isck;
        TextView textView;
        TextView price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.car_image);
            textView = itemView.findViewById(R.id.car_title);
            isck =  itemView.findViewById(R.id.car_cricle);
            price = itemView.findViewById(R.id.car_price);
        }
    }
  private ShopCarBackLsiener lsiener;
    public void setLisenter (ShopCarBackLsiener lsiener){
        this.lsiener = lsiener;
    }

    public interface ShopCarBackLsiener{
        void CarBack();
    }

}
