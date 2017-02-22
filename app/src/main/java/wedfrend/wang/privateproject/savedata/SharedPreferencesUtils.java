package wedfrend.wang.privateproject.savedata;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by welive on 2017/2/20.
 */

public class SharedPreferencesUtils {

    private Context mcontext;


    public SharedPreferencesUtils(Context context) {

        mcontext = context;

    }

    /*存储值*/
    public void putDateToShare(Object object){

        SharedPreferences sharedPreferences = mcontext.getSharedPreferences("CONTEXT_SharePreferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(object instanceof String){
            editor.putString("name",(String) object);
        }
        editor.apply();
    }

    /*获取值*/

    public Object getDateToShare(Object object){

        SharedPreferences sharedPreferences = mcontext.getSharedPreferences("CONTEXT_SharePreferences",Context.MODE_PRIVATE);

        if(object instanceof String){
            return sharedPreferences.getString("name","");
        }
        return null;
    }


}
