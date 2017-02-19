package wedfrend.wang.privateproject.recycle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wedfrend.wang.privateproject.R;
import wedfrend.wang.privateproject.fragment.RightFragment;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        RightFragment rightFragment = ((RightFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment));
        rightFragment.onRefresh(newsTitle,newsContent);

    }

    /**
     * 静态的跳转方法
     * @param context
     * @param newsTitle
     * @param newsContent
     */
    public static void actionStart(Context context,String newsTitle,String newsContent){

        Intent intent = new Intent();
        intent.setClass(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }


}
