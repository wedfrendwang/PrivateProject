package wedfrend.wang.privateproject.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import wedfrend.wang.privateproject.R;

import static android.R.drawable.ic_dialog_email;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        final NotificationManager notificationManager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this);
        Intent intent = new Intent(NotificationActivity.this,NotificationActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this,0,intent,0);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_dialog_map));

        builder.setContentTitle("通知");

        builder.setWhen(System.currentTimeMillis());

        builder.setSmallIcon(android.R.drawable.ic_dialog_email);

        builder.setContentIntent(pendingIntent);


        builder.setAutoCancel(true);

        findViewById(R.id.btn_Notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setContentText("您有一条未读短信");
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_dialog_map));

                Notification notification =builder.build();
                notificationManager.notify(1,notification);
            }
        });



        findViewById(R.id.btn_NotificationMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText("关于钱和理想的问题，曾经有个工程师在微信上问我，如何从为了钱而编程进化到为了理想编程。我的回复是，先把钱挣够了，就可以为理想编程了。\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "初入职场，最重要的事就是提升自己的能力，而不是去做自己喜欢的事情，这个阶段钱能够养活自己就行。等你到了技能等身、拔剑四顾的阶段，尽快把这些技能转化成银元，这个阶段，不要对自己说，钱我看的很淡。照顾好自己，照顾好家人，为他们提供更好的生活条件才是你应该做的事情。等财富稍微自由一些，你会突然发现，世界变得更加广阔，你的很多顾虑、担心、畏缩消失不见了，这时候，就到了为理想编程的时候！"));
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_dialog_map));

                builder.setVibrate(new long[]{0,1000,1000,1000});

//                builder.setDefaults(NotificationCompat.DEFAULT_ALL);

                Notification notification = builder.build();

                notificationManager.notify(2,notification);
            }
        });


        findViewById(R.id.btn_NotificationPriority).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_dialog_map));



                builder.setContentText("您有一条未读短信");
//                builder.setStyle(new NotificationCompat.BigTextStyle().bigText("你有一条消息"));

                builder.setDefaults(NotificationCompat.DEFAULT_ALL);

                Notification notification = builder.setPriority(NotificationCompat.PRIORITY_MAX).build();

                notificationManager.notify(3,notification);
            }
        });


    }
}
