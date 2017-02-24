package wedfrend.wang.privateproject.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by welive on 2017/2/23.
 *
 * 将自己创建的数据进行共享，那么其他的应用程序也是可以进行访问的。
 *
 *
 */

public class MyContentProvider extends ContentProvider {


    private static final String TAG = "MyContentProvider";

    private ComputerDataBase computerDateBase;

    public static final String authority = "wedfrend.wang.privateproject.provider";

    public static final String path = "computer";

    public static final int COMPUTER_DIR = 0;

    public static final int COMPUTER_ITEM = 1;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(authority,path,COMPUTER_DIR);
        uriMatcher.addURI(authority,path+"/#",COMPUTER_ITEM);
    }



    /*
    初始化内容提供器时候调用，通常完成数据库的创建和升级等操作
    只有当存在ContentResolver尝试访问我们程序当中的数据的时候，内容提供器才会被初始化。
     */
    @Override
    public boolean onCreate() {
        Log.i(TAG, "onCreate: ");
        computerDateBase = new ComputerDataBase(getContext(),"computerData.db",null,1);
        return true;
    }

    /*
    从内容提供器中查询数据。使用uri参数来确定查询哪张表，查询结果会存放在Cursor对象中
     */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.i(TAG, "query: "+uri.toString());

        SQLiteDatabase sqliteDatabase = computerDateBase.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case COMPUTER_DIR:
                cursor = sqliteDatabase.query("computer",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case COMPUTER_ITEM:
                Log.i(TAG, "uri"+uri.toString());
                String id = uri.getPathSegments().get(1);
                Log.i(TAG, "query: "+id);
                cursor = sqliteDatabase.query("computer",projection,"id=?",new String[]{id},null,null,sortOrder);
                break;
        }
        return cursor;
    }


    /*
    向内容提供器中添加一条数据，添加完成之后，返回一个用于表示这条记录的URI
     */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i(TAG, "insert: ");
        SQLiteDatabase sqliteDatabase = computerDateBase.getWritableDatabase();
        Uri uriId = null;
        switch (uriMatcher.match(uri)){
            case COMPUTER_DIR:
            case COMPUTER_ITEM:
                long computerId = sqliteDatabase.insert("computer",null,values);
                uriId = Uri.parse("content://"+authority+"/computer/"+computerId);
                break;
        }
        return uriId;
    }


    /*
    更新内容提供器中已有的数据，返回受影响的行数
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.i(TAG, "update: ");
        SQLiteDatabase sqliteDatabase = computerDateBase.getWritableDatabase();
        int upDateRows=0;
        switch (uriMatcher.match(uri)){
            case COMPUTER_DIR:
                upDateRows = sqliteDatabase.update("computer",values,selection,selectionArgs);
                break;
            case COMPUTER_ITEM:
                String upId = uri.getPathSegments().get(1);
                Log.i(TAG, "update: "+upId);
                upDateRows = sqliteDatabase.update("computer",values,"id=?",new String[]{upId});
        }
        return upDateRows;
    }

    /*
    删除一条数据，返回被删除的行数
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.i(TAG, "delete: ");
        SQLiteDatabase sqliteDatabase = computerDateBase.getWritableDatabase();
        int deletesRows = 0;
        switch (uriMatcher.match(uri)){
            case COMPUTER_DIR:
                deletesRows = sqliteDatabase.delete("computer",selection,selectionArgs);
                break;
            case COMPUTER_ITEM:
                String deleteId = uri.getPathSegments().get(1);
                Log.i(TAG, "delete: "+deleteId);
                deletesRows = sqliteDatabase.delete("computer","id=?",new String[]{deleteId});
                break;
        }
        return deletesRows;
    }

    /*
    根据传入的内容URI来返回相应的MIME类型

    android规定一个内容URI所对应的MIME字符串主要由3部分组成

    1.必须以vnd开头

    2.如果URI是以路径结尾，则后面接 .android.cursor.dir/
      如果URI是以id结尾，则后面接   .android.cursor.item/

    3.最后需要接 vnd.<authority>.<path>

     */
    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.i(TAG, "getType: ");
        switch (uriMatcher.match(uri)){
            case COMPUTER_DIR:
                return "vnd.android.cursor.dir/vnd.wedfrend.wang.privateproject.provider.computer";
            case COMPUTER_ITEM:
                return "vnd.android.cursor.item/vnd.wedfrend.wang.privateproject.provider.computer";
        }
        return null;
    }
}
