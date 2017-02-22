package wedfrend.wang.privateproject;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import wedfrend.wang.privateproject.base.BaseAppCompatActivity;
import wedfrend.wang.privateproject.broadcast.BroadCastActivity;
import wedfrend.wang.privateproject.broadcast.LocalBroadCastActivity;
import wedfrend.wang.privateproject.landorport.LandOrPortActivity;
import wedfrend.wang.privateproject.recycle.FragmentActivity;
import wedfrend.wang.privateproject.recycle.RecycleViewActivity;
import wedfrend.wang.privateproject.savedata.FilesActivity;
import wedfrend.wang.privateproject.savedata.MySOLiteActivity;
import wedfrend.wang.privateproject.savedata.SharedPreferencesActivity;
import wedfrend.wang.privateproject.sendobject.ParcelableActivity;
import wedfrend.wang.privateproject.sendobject.PersonInfo;
import wedfrend.wang.privateproject.sendobject.PersonMessage;
import wedfrend.wang.privateproject.sendobject.SerializableActivity;

public class MainActivity extends BaseAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //关于DrawerListener
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*下面的方法用来相应的点击的事件操作*/

        /**
         * 横竖屏界面的演示
         */
        Button btn_landOrPort = ((Button) findViewById(R.id.btn_landOrPort));
        btn_landOrPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 显示Intent的加载方式
                 */
                Intent intent = new Intent(MainActivity.this,LandOrPortActivity.class);
                intent.putExtra("message","进行横竖屏幕的切换演示");
                startActivity(intent);
            }
        });

        /**
         * 隐式Intent的调用
         */
        Button btn_intent = (Button) findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("wedfrend.wang.privateproject.INTENT");
                intent.addCategory("wedfrend.wang.privateproject.INTENT_CATEGORY");
                startActivity(intent);
            }
        });


        /**
         * 隐式调用Intent，修改的是增加一个可选择的浏览器
         */
        Button btn_intentForAndroid = (Button) findViewById(R.id.btn_intentForAndroid);

        btn_intentForAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com/"));
                startActivity(intent);
            }
        });


        /**
         * 传递实现 Serializable 接口的序列化类
         */
        Button btn_sendValueSerializable = (Button) findViewById(R.id.btn_sendValueSerializable);
        btn_sendValueSerializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonInfo personInfo = new PersonInfo();
                personInfo.setName("wedfrendWang");
                personInfo.setAge(24);
                personInfo.setAddress("Fujian XM");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SerializableActivity.class);
                intent.putExtra("Serializable",personInfo);
                startActivity(intent);
            }
        });

        Button btn_sendValueParcelable = ((Button) findViewById(R.id.btn_sendValueParcelable));
        btn_sendValueParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonMessage personMessage = new PersonMessage();
                personMessage.setName("wedfrend");
                personMessage.setAge(24);
                personMessage.setAddress("XM china");
                //传值方法
                Intent intent = new Intent(MainActivity.this,ParcelableActivity.class);
                intent.putExtra("parcelable",personMessage);

                //startActivity(intent);
                startActivityForResult(intent,0);
            }
        });


        findViewById(R.id.btn_nextSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.btn_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,FragmentActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.btn_RecycleView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,RecycleViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.SharedPreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.files).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilesActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.mySQLiteDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MySOLiteActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_BroadCastReceiver_Code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,BroadCastActivity.class);
                startActivity(intent);
            }
        });



        findViewById(R.id.btn_MyBroadCastReceiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("wedfrend.wang.privateproject.MYBROADCASTRECEIVER");
//                sendBroadcast(intent);
                sendOrderedBroadcast(intent,null);
            }

        });

        findViewById(R.id.btn_MyBroadCastReceiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocalBroadCastActivity.class);
                startActivity(intent);
            }

        });

        findViewById(R.id.btn_usePhone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);

                }else{
                    call();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 0:

                Log.i(TAG, "onRequestPermissionsResult: "+permissions[0]);
                Log.i(TAG, "onRequestPermissionsResult: "+grantResults[0]);
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    call();
                }else{
                    Toast.makeText(MainActivity.this,"您已经拒绝的权限请求",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private void call(){
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 0:
                if(resultCode == 1){
                    Toast.makeText(this,data.getStringExtra("value"),Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
