package wedfrend.wang.privateproject.recycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wedfrend.wang.privateproject.R;
import wedfrend.wang.privateproject.category.FruitClass;

/**
 * 一个简单的新闻界面
 *
 */
public class RecycleViewActivity extends AppCompatActivity {

    private static final String TAG = "RecycleViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);


        RecyclerView recyclerView = ((RecyclerView) findViewById(R.id.recycleView));
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        /**
         * LayoutManager layout
         *
         * 1.LinearLayoutManager  为纵向，（默认的）
         * 2.LinearLayoutManager  并设置linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL)为横向
         * 3.StaggeredGridLayoutManager(int spanCount, int orientation),瀑布流布局，当orientation为VERTICAL参数spanCount表列数，当orientation为HORIZONTAL参数spanCount表示行数
         * 4. GridLayoutManager(Context context, int spanCount) ，网格布局 spanCount 表示列数
         *
         */



        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(initFruits());
        recyclerView.setAdapter(recyclerViewAdapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.w(TAG, "onScrollStateChanged: "+newState );
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.w(TAG, "onScrolled: "+dx);

                Log.w(TAG, "onScrolled: "+dy );
            }
        });

    }

    public List<FruitClass> initFruits(){

        List<FruitClass> fruitClassList = new ArrayList<>();

        for (int i = 0;i<3;i++){
            FruitClass fruitClass0 = new FruitClass();
            fruitClass0.setId(R.mipmap.ic_launcher);
            fruitClass0.setName(getRandomLengthName("apple"));
            fruitClassList.add(fruitClass0);

            FruitClass fruitClass1 = new FruitClass();
            fruitClass1.setId(R.mipmap.ic_launcher);
            fruitClass1.setName(getRandomLengthName("banana"));
            fruitClassList.add(fruitClass1);

            FruitClass fruitClass2 = new FruitClass();
            fruitClass2.setId(R.mipmap.ic_launcher);
            fruitClass2.setName(getRandomLengthName("pear"));
            fruitClassList.add(fruitClass2);

            FruitClass fruitClass3 = new FruitClass();
            fruitClass3.setId(R.mipmap.ic_launcher);
            fruitClass3.setName(getRandomLengthName("grape"));
            fruitClassList.add(fruitClass3);

            FruitClass fruitClass4 = new FruitClass();
            fruitClass4.setId(R.mipmap.ic_launcher);
            fruitClass4.setName(getRandomLengthName("cheer"));
            fruitClassList.add(fruitClass4);
        }
        return  fruitClassList;
    }


    /**
     * 使用StaggeredGridLayoutManager
     */
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<length;i++){
            stringBuilder.append(name+length);
        }
        return  stringBuilder.toString();
    }


}

