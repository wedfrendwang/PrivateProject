package wedfrend.wang.privateproject.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wedfrend.wang.privateproject.FourActivity;

/**
 * Created by welive on 2018/1/15.
 */

public class ItemFragment extends Fragment {

    public static ItemFragment newInstance(int index) {

        Bundle args = new Bundle();
        args.putInt("index",index);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private static final String TAG = "ItemFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ---->第"+getArguments().get("index")+"个");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("点击我跳转至另外界面");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FourActivity.class));
            }
        });
        return textView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ---->第"+getArguments().get("index")+"个");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ---->第"+getArguments().get("index")+"个");

    }

    @Override
    public void onResume() {
        super.onResume();

        if(getUserVisibleHint()){
            //
            Log.e(TAG, "onResume: 我开始加载相应的数据---------网罗数据刷新数据" );
        }

        Log.i(TAG, "onResume: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(TAG, "onHiddenChanged: ---->第"+getArguments().get("index")+"个");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, "setUserVisibleHint: ---->第"+getArguments().get("index")+"个----"
                +
                isVisibleToUser);
    }

    @Override
    public boolean getUserVisibleHint() {

        Log.i(TAG, "getUserVisibleHint: ---->第"+getArguments().get("index")+"个");
        return super.getUserVisibleHint();
    }
}
