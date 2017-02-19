package wedfrend.wang.privateproject.recycle;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wedfrend.wang.privateproject.R;
import wedfrend.wang.privateproject.category.News;
import wedfrend.wang.privateproject.fragment.RightFragment;

/**
 * Created by welive on 2017/2/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNewsList;
    private Fragment mcontext;

    public NewsAdapter(List<News> newsList, Fragment context) {

        this.mNewsList = newsList;
        this.mcontext =  context;
    }


    boolean isTwoPane = false;
    public void setIsTwoPage(boolean isTwoPage){
        isTwoPane = isTwoPage;
    }


    /**
     *
     */
     class ViewHolder extends RecyclerView.ViewHolder{

        TextView newsTitleText;
        public ViewHolder(View itemView) {
            super(itemView);
            newsTitleText = ((TextView) itemView.findViewById(R.id.news_Title));
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        News news = mNewsList.get(position);
        holder.newsTitleText.setText(news.getTitle());

    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,null);
        final ViewHolder holder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News news = mNewsList.get(holder.getAdapterPosition());

                if(isTwoPane){//双页模式

                    RightFragment rightFragment = ((RightFragment)mcontext.getActivity().getSupportFragmentManager().findFragmentById(R.id.news_content_fragment));

                    rightFragment.onRefresh(news.getTitle(),news.getContetnt());

                }else{

                    NewsContentActivity.actionStart(mcontext.getContext(),news.getTitle(),news.getContetnt());
                }

            }
        });


        return holder;
    }
}
