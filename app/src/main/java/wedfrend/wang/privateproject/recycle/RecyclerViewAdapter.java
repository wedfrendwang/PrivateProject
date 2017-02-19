package wedfrend.wang.privateproject.recycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wedfrend.wang.privateproject.R;
import wedfrend.wang.privateproject.category.FruitClass;

/**
 * Created by welive on 2017/2/18.
 *
 * 创建RecyclerView适配器的基本操作以及需要重写的方法
 *
 * 1.创建RecyclerViewAdapter继承自RecycleView.Adapter<>,传入的参数为我们定义的内部类RecyclerViewAdapter.ViewHolder
 *
 * 2.我们定义的内部类RecyclerViewAdapter.ViewHolder继承自RecyclerView.ViewHolder
 *
 * 3.RecyclerViewAdapter.ViewHolder必须要实现一个带有参数View的构造函数，而这个View代表RecyclerView子项的最外层的布局
 *    对于toString（）方法可以写也可以不写（随意）
 *
 * 4.之后需要重写onBindViewHolder（），onCreateViewHolder（），getItemCount（）方法
 *
 *
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    /**
     * 把需要显示的数据源传进来
     */
    private List<FruitClass> mFruitList;
    public RecyclerViewAdapter(List<FruitClass> fruitList) {
        mFruitList = fruitList;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_info;
        ImageView iv_image;

        /**
         * 缓存实例
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            tv_info = ((TextView) itemView.findViewById(R.id.tv_info));
            iv_image = ((ImageView) itemView.findViewById(R.id.iv_image));
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.iv_image.setImageResource(mFruitList.get(position).getId());
        holder.tv_info.setText(mFruitList.get(position).getName());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
