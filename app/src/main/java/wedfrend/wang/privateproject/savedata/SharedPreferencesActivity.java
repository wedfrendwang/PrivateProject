package wedfrend.wang.privateproject.savedata;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import wedfrend.wang.privateproject.R;

/**
 * 使用SharedPreferences存储
 * <p>
 * 1.获取SharedPreferences对象
 * 2.调用SharedPreferences.Editor对象添加数据
 * 3.调用apply()方法提交数据
 */

public class SharedPreferencesActivity extends AppCompatActivity {


    private static final String TAG = "SharedPreferencesActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);

        //activity中调用getPreferences()方法
        findViewById(R.id.btn_activityPreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("money", 20.5f);
                editor.apply();
            }
        });


        //activity中调用getSharedPreferences()方法
        findViewById(R.id.btn_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("ACTIVITY_sharedPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", "wedfrend");
                editor.putInt("age", 24);
                editor.putString("sex", "man");
                editor.apply();
            }
        });

        //context调用getSharedPreferences()方法
        findViewById(R.id.btn_Context).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils sharedPreferencesUtils = new SharedPreferencesUtils(SharedPreferencesActivity.this);
                sharedPreferencesUtils.putDateToShare("wedfrend");


            }
        });


        //PreferenceManager调用getDefaultSharedPreferences()方法
        findViewById(R.id.btn_defaultSharePreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SharedPreferencesActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("age", 25);
                editor.putString("name", "wedfrend");
                editor.putBoolean("is_man", true);
                editor.apply();
            }
        });



        findViewById(R.id.getSharePreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("ACTIVITY_sharedPreferences",MODE_PRIVATE);
                int age = sharedPreferences.getInt("age",10);
                String name = sharedPreferences.getString("name","");
                boolean is_man = sharedPreferences.getBoolean("is_man",false);
                String address = sharedPreferences.getString("address","noAddress");
                Log.i(TAG, "onClick: "+age);
                Log.i(TAG, "onClick: "+name);
                Log.i(TAG, "onClick: "+is_man);
                Log.i(TAG, "onClick: "+address);
            }
        });

    }
}
