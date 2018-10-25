package soexample.umeng.com.shopping.net;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者:李自强
 * <p>
 * 2018/10/25
 **/
public class Okhttp {

private final int HTTP_SUECSS = 100;
    private final int HTTP_FAIL = 101;
    public Okhttp get(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
          okHttpClient.newCall(request).enqueue(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
                  handler.sendEmptyMessage(HTTP_FAIL);
              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {
                  String string = response.body().string();
                  Message message = Message.obtain();
                  message.obj = string;
                  message.what = HTTP_SUECSS;
                  handler.sendMessage(message);
              }
          });
        return this;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case HTTP_SUECSS:
                    String data = (String) msg.obj;
                    lisenter.suecss(data);
                    break;
                case HTTP_FAIL:
                    lisenter.fail();
                    break;
            }
        }
    };
    private HttpLisenter lisenter;
    public void resout(HttpLisenter lisenter){
        this.lisenter = lisenter;
    }

public interface HttpLisenter{
    void suecss(String data);
    void fail();
}

}
