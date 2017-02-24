package wedfrend.wang.privateproject.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by welive on 2017/2/23.
 */

public class ComputerDataBase extends SQLiteOpenHelper {

    public static final String COMPUTER_TABLE = "create table computer(id integer primary key autoincrement,name text,price real)";

    public ComputerDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(COMPUTER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
