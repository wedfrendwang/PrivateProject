package wedfrend.wang.privateproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import wedfrend.wang.privateproject.base.BaseAppCompatActivity;
import wedfrend.wang.privateproject.landorport.LandOrPortActivity;
import wedfrend.wang.privateproject.manager.ActivityCollector;

public class FourActivity extends BaseAppCompatActivity {

    TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        tv_show = ((TextView) findViewById(R.id.tv_show));
        findViewById(R.id.btn_checkAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText(ActivityCollector.newInstance().checkActivity());
            }
        });

        findViewById(R.id.btn_removeAssign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText(ActivityCollector.newInstance().removeAssignActivity(SecondActivity.class));
            }
        });
    }
}
