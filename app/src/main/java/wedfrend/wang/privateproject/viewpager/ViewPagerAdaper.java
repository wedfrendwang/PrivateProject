package wedfrend.wang.privateproject.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by welive on 2018/1/15.
 */

public class ViewPagerAdaper extends FragmentPagerAdapter {

    private int count;
    private static final String TAG = "ViewPagerAdaper";
    public ViewPagerAdaper(FragmentManager fm ,int count) {
        super(fm);
        this.count = count;
        Log.i(TAG, "ViewPagerAdaper: "+count);
    }

    @Override
    public Fragment getItem(int position) {
        return ItemFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return count;
    }


}
