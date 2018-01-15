package wedfrend.wang.privateproject.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

import wedfrend.wang.privateproject.R;

/**
 * Created by welive on 2018/1/15.
 */

public class ViewPagerClass extends AppCompatActivity {

    private static final String TAG = "ViewPagerClass";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        final ViewPager vp = ((ViewPager) findViewById(R.id.viewPager));
        /*
        对于这个方法的解释：
        1：当你的界面有3 个设置为2
        2：当界面有4个设置为3
        * */
        vp.setOffscreenPageLimit(3);
        final ViewPagerAdaper vadapter = new ViewPagerAdaper(getSupportFragmentManager(),4);
        vp.setAdapter(vadapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        RadioGroup radioGroup = ((RadioGroup) findViewById(R.id.rg));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int count = 0;
                Log.i(TAG, "onCheckedChanged: --"+checkedId);
                Log.i(TAG, "onCheckedChanged: ----"+vadapter.getItem(checkedId).getClass().getName()+"----"+checkedId);
                switch (checkedId){
                    case R.id.btn1:
                        count = 0;
                        break;
                    case R.id.btn2:
                        count = 1;
                        break;
                    case R.id.btn3:
                        count = 2;
                        break;
                    case R.id.btn4:
                        count = 3;
                        break;
                }
                vp.setCurrentItem(count);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: "+ this.getClass().getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: "+ this.getClass().getName());
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: "+ this.getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onStart: "+ this.getClass().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: "+ this.getClass().getName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: "+ this.getClass().getName());
    }
}
