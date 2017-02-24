package wedfrend.wang.privateproject.base;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by welive on 2017/2/21.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
