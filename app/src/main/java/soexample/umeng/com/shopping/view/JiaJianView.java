package soexample.umeng.com.shopping.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import soexample.umeng.com.shopping.R;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class JiaJianView extends LinearLayout {

    public JiaJianView(Context context) {
        super(context);
        initdata(context);
    }

    public JiaJianView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initdata(context);
    }

    public JiaJianView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initdata(context);
    }
    private Context context;
    private void initdata(Context context) {
        View view = View.inflate(context, R.layout.shop_car_price_layout,null);
        addView(view);

    }


}
