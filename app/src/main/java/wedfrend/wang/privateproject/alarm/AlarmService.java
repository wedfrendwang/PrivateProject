package wedfrend.wang.privateproject.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Timer;

public class AlarmService extends Service {


    int i = 0;

    AlarmManager manager;

    PendingIntent pendingIntent;

    private static final String TAG = "AlarmService";

    public AlarmService() {
        
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"启动服务",Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStartCommand: i------>"+i++);

        manager = ((AlarmManager) getSystemService(ALARM_SERVICE));

        int time = 10*1000;

        long triggerAtTime = SystemClock.elapsedRealtime()+time;

        Intent i = new Intent(this,AlarmService.class);

        pendingIntent = PendingIntent.getService(this,0,i,0);

        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);



        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: AlarmManager is cancel");
        manager.cancel(pendingIntent);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

}
