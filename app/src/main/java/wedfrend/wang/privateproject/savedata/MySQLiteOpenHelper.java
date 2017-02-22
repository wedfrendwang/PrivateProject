package wedfrend.wang.privateproject.savedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by welive on 2017/2/20.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "MySQLiteOpenHelper";

    private Context mcontext;

    public static final String CREATE_CATEGORY = "create table category (id integer primary key autoincrement,"+
            "teacher text,grade text)";

    /**
     *
     * @param context
     * @param name        数据库名
     * @param factory     允许我们在查询的时候返回一个自定义的Cursor，一般传null
     * @param version     数据库版本号，用于对数据库升级操作
     */
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.i(TAG, "MySQLiteOpenHelper: MySQLiteOpenHelper");
        mcontext = context;
    }

    /**
     * 创建数据库
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i(TAG, "MySQLiteOpenHelper: onCreate");
        db.execSQL("create table Person (id integer primary key autoincrement,name text,age integer,sex text)");
        Toast.makeText(mcontext,"Create database success",Toast.LENGTH_SHORT).show();
    }

    /**
     * 升级数据库
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MySQLiteOpenHelper: onUpgrade");

        db.execSQL(CREATE_CATEGORY);

    }


    /**
     * 创建或者打开一个现有数据库，并返回可对数据库进行读写操作的对象，当数据库不可写入的时候，出现异常
     * @return
     */
    @Override
    public SQLiteDatabase getWritableDatabase() {
        Log.i(TAG, "MySQLiteOpenHelper: getWritableDatabase");
        return super.getWritableDatabase();
    }

    /**
     * 创建或者打开一个现有数据库，并返回可对数据库进行读写操作的对象，当数据库不可写入的时候，以只读的方式打开数据库
     * @return
     */
    @Override
    public SQLiteDatabase getReadableDatabase() {
        Log.i(TAG, "MySQLiteOpenHelper: getReadableDatabase");
        return super.getReadableDatabase();
    }
}
