package wedfrend.wang.privateproject.savedata;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.LitePal;
import org.litepal.LitePalDB;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import wedfrend.wang.privateproject.R;
import wedfrend.wang.privateproject.table.Book;

/**
 * 创建数据库的实例
 */
public class MySOLiteActivity extends AppCompatActivity {

    private static final String TAG = "MySOLiteActivity";
    //声明的辅助类
    MySQLiteOpenHelper mySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_solite);
        mySQLiteOpenHelper = new MySQLiteOpenHelper(MySOLiteActivity.this,"personInfo.db",null,3);

        findViewById(R.id.createDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySQLiteOpenHelper.getReadableDatabase();
            }
        });

        findViewById(R.id.addDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                //开始添加数据
                contentValues.put("name","wangxiaobo");
                contentValues.put("age",25);
                contentValues.put("sex","man");
                sqLiteDatabase.insert("Person",null,contentValues);
                contentValues.clear();
                //添加第二组数据
                contentValues.put("name","wedfrend");
                contentValues.put("age",24);
                contentValues.put("sex","man");
                sqLiteDatabase.insert("Person",null,contentValues);
                sqLiteDatabase.execSQL("insert into Person(name,age,sex) values(\"wedfrend xiaobo\",21,\"man\")");
                sqLiteDatabase.execSQL("insert into Person(name,age,sex) values(?,?,?)",new String[]{"wedfrend wang","22","man"});
                contentValues.clear();
            }
        });

        findViewById(R.id.deleteDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
                sqLiteDatabase.delete("Person","age > ?",new String[]{"23"});
            }
        });

        findViewById(R.id.updateDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("age",24);
                sqLiteDatabase.update("Person",contentValues,"name=?",new String[]{"wangxiaobo"});
            }
        });


        findViewById(R.id.selectDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
                Cursor cursor = sqLiteDatabase.query("Person",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        //遍历所有的数据处理
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        int age = cursor.getInt(cursor.getColumnIndex("age"));
                        String sex = cursor.getString(cursor.getColumnIndex("sex"));
                        Log.i(TAG, "onClick: name"+name);
                        Log.i(TAG, "onClick: age"+age);
                        Log.i(TAG, "onClick: sex"+sex);
                    }while(cursor.moveToNext());
                }

            }
        });


//        LitePal创建数据库以及增删改查的方法

        findViewById(R.id.LitePalCreateDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Connector.getDatabase();
            }
        });


        findViewById(R.id.LitePalAddDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("一个巨人的陨落");
                book.setPrices(84.3f);
                book.setAuthor("Ken Follett");
                //save()方法是继承DataSupport里面的方法
                book.save();

                Book book2 = new Book();
                book2.setName("阿弥陀佛么么哒");
                book2.setPrices(38.0f);
                book2.setAuthor("大冰");
                book2.save();

                Book book3 = new Book();
                book2.setName("第一行代码");
                book2.setPrices(38.9f);
                book2.setAuthor("郭霖");
                book2.save();

            }
        });

        findViewById(R.id.LitePalUpdateDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //参数1，查询类，参数2表示id
//                Book book = DataSupport.find(Book.class,1);
//                Log.i(TAG, "onClick: ------------"+book.getName());
//                Log.i(TAG, "onClick: ------------"+book.getAuthor());
//                Log.i(TAG, "onClick: ------------"+book.getPrices());
//                book.setName("wedfrend");
//                book.save();


                Book updata_book = new Book();
                updata_book.setPrices(0.0f);
                updata_book.update(1);

//                Book upDateBook = new Book();
//                upDateBook.setAuthor("wedfrend");
//                upDateBook.updateAll("name=?","阿弥陀佛么么哒");
            }
        });

        findViewById(R.id.LitePalDeleteDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除第二行数据
                DataSupport.delete(Book.class,1);
            }
        });



        findViewById(R.id.LitePalSelectDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提供方法完全符合SQLite语法


                List<Book> bookList = DataSupport.findAll(Book.class);


                for (Book book:bookList
                     ) {
                    Log.i(TAG, "onClick: book"+book.getName());
                    Log.i(TAG, "onClick: book"+book.getPrices());
                    Log.i(TAG, "onClick: book"+book.getAuthor());
                }
            }
        });
    }
}
