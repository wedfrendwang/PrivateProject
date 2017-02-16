package wedfrend.wang.privateproject.landorport;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import wedfrend.wang.privateproject.R;
import wedfrend.wang.privateproject.base.BaseAppCompatActivity;

/**
 *
 * 该类进行  手机横竖屏幕的切换 实例，主要使用方法是将数据输出出来
 *
 */
public class LandOrPortActivity extends AppCompatActivity {

    private static final String TAG = "LandOrPortActivity";

    TextView tv_getText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: " );
        setContentView(R.layout.activity_land_or_port);
        tv_getText = (TextView) findViewById(R.id.tv_getText);
        
        if(savedInstanceState != null){
            tv_getText.setText(savedInstanceState.getString("message"));
        }else{

            tv_getText.setText(getIntent().getStringExtra("message"));
        }
        tv_getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: ");
        outState.putString("message","使用了onSaveInstanceState");
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged: ");
        switch (newConfig.orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                Log.i(TAG, "onConfigurationChanged: ORIENTATION_LANDSCAPE");
                break;

            case Configuration.ORIENTATION_PORTRAIT:
                Log.i(TAG, "onConfigurationChanged: ORIENTATION_PORTRAIT");
                break;

        }
    }
}
