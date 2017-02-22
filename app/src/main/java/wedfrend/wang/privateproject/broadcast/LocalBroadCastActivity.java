package wedfrend.wang.privateproject.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import wedfrend.wang.privateproject.R;

public class LocalBroadCastActivity extends AppCompatActivity {

    private LocalBroadcastManager localBroadcastManager;
    LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loacl_broad_cast);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("wedfrend.wang.privateproject.LOCALBROADCAST");
        localReceiver = new LocalReceiver();
        //注册广播接收器
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

        //发送本地广播
        Intent intent = new Intent("wedfrend.wang.privateproject.LOCALBROADCAST");
        localBroadcastManager.sendBroadcast(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"wedfrend.wang.privateproject.LOCALBROADCAST",Toast.LENGTH_SHORT).show();
        }
    }
}
