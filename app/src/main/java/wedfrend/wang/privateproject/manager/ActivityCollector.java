package wedfrend.wang.privateproject.manager;

import android.app.Activity;
import android.util.Log;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by welive on 2017/2/16.
 * <p>
 * 使用单例模式
 */

public class ActivityCollector {

    private static final String TAG = "ActivityCollector";

    private ActivityCollector() {
    }

    private static ActivityCollector activityCollector = new ActivityCollector();

    public static ActivityCollector newInstance() {
        return activityCollector;
    }

    private Stack<Activity> stackActivity;

    /**
     * 将活动添加入栈
     *
     * @param activity
     */

    public void addActvity(Activity activity) {
        if (stackActivity == null || stackActivity.isEmpty()) {
            stackActivity = new Stack<Activity>();
        }
        Log.i(TAG, "addActivity: " + activity.getClass());
        stackActivity.add(activity);
    }


    /**
     * 将活动移除出栈
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (!stackActivity.isEmpty()) {
            stackActivity.remove(activity);
        }
    }


    /**
     * 将制定的Activity移除出栈
     *
     * @param cls
     */
    public String removeAssignActivity(Class<?> cls) {

        if (!stackActivity.isEmpty()) {
            Iterator<Activity> iterator = stackActivity.iterator();
            while (iterator.hasNext()) {//执行遍历循环
                Activity activity = iterator.next();
                if (activity.getClass().equals(cls)) {//查看是否一致
                    //一致便将该activity移除
                    iterator.remove();
                    activity.finish();
                }
            }

        }
        return checkActivity();
    }

    /**
     * 查询当前栈中的Activity
     */
    public String checkActivity() {

        StringBuffer stringBuffer = new StringBuffer();
        if (!stackActivity.isEmpty()) {
            Iterator<Activity> iterator = stackActivity.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next();
                Log.d(TAG, "checkActivity: " + activity.getClass());
                stringBuffer.append(activity.getClass()+"---");
            }
        }
        return stringBuffer.toString();
    }

    public void finishApplication(){

        if (!stackActivity.isEmpty()) {
            Iterator<Activity> iterator = stackActivity.iterator();
            while (iterator.hasNext()) {//执行遍历循环
                Activity activity = iterator.next();
                iterator.remove();
                activity.finish();
            }
            //杀掉进程
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}







