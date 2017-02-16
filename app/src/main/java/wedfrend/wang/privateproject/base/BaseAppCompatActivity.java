package wedfrend.wang.privateproject.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import wedfrend.wang.privateproject.manager.ActivityCollector;

/**
 * Created by welive on 2017/2/16.
 */

public class BaseAppCompatActivity extends AppCompatActivity {

    private static final String TAG = "BaseAppCompatActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: "+getClass().getName());
        Log.i(TAG, "onCreate: "+getClass().getSimpleName());
        ActivityCollector.newInstance().addActvity(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.newInstance().removeActivity(this);
    }
}
