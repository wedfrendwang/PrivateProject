package wedfrend.wang.privateproject.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by welive on 2017/2/19.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    public NetworkChangeReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = ((ConnectivityManager)
        context.getSystemService(Context.CONNECTIVITY_SERVICE));

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isAvailable()){
            Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
        }


    }
}
