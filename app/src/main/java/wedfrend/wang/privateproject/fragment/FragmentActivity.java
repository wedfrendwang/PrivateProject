package wedfrend.wang.privateproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import wedfrend.wang.privateproject.R;

/**
 * Fragment的实践,另外一种控件的点击方法,使用隐藏和显示的方法
 */
public class FragmentActivity extends AppCompatActivity implements View.OnClickListener{

    FrameLayout frame_fragment;
    Button btn_firstFragment,btn_secondFragment;

    Fragment firstFragment,secondFragment;

    private static final String TAG = "FragmentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_fragment);
//        实例化控件
        frame_fragment = ((FrameLayout) findViewById(R.id.frame_fragment));
        btn_firstFragment = ((Button) findViewById(R.id.btn_firstFragment));
        btn_secondFragment = ((Button) findViewById(R.id.btn_secondFragment));
        btn_firstFragment.setOnClickListener(this);
        btn_secondFragment.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_firstFragment:
                setFragment(0);
//                replaceFragment(new FirstFragment());
                break;
            case R.id.btn_secondFragment:
                setFragment(1);
//                replaceFragment(new SecondFragment());
                break;
        }
    }

    public void setFragment(int i){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(firstFragment != null){
            fragmentTransaction.hide(firstFragment);
        }
        if(secondFragment != null){
            fragmentTransaction.hide(secondFragment);
        }

        switch (i){
            case 0:
                if(firstFragment == null){
                    firstFragment = new FirstFragment();
                    fragmentTransaction.add(R.id.frame_fragment,firstFragment);
                }else{
                    fragmentTransaction.show(firstFragment);
                }
                break;

            case 1:
                if(secondFragment == null){
                    secondFragment = new SecondFragment();
                    fragmentTransaction.add(R.id.frame_fragment,secondFragment);
                }else{
                    fragmentTransaction.show(secondFragment);
                }
                break;
        }
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    /**
     * 说明：
     *
     * 动态添加碎片5个步骤
     *
     * 1.创建待添加碎片的实例
     *
     * 2.获取FragmentManager实例，在活动中通过getSupportFragmentManager()方法获取
     *
     * 3.开启一个事务，通过调用 beginTransaction()方法开启
     *
     * 4.向容器内添加或者替换碎片，使用replace()方式
     *
     * 5.提交事务，使用commit()完成
     *
     *
     *
     * 对于第4点，这里进行补充，FragmentTransaction提供操作碎片的方法中有
     *
     * add(),hide(),show(),remove(),replace();
     *
     * 在实际的项目中，具体使用那些方式需要你根据实际的情况进行考虑
     */

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
