package com.wiktor.demoretrofit2.Lesson2;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiktor.demoretrofit2.R;

import java.util.List;

public class RecyclerViewPostsAdapter extends RecyclerView.Adapter<RecyclerViewPostsAdapter.ViewHolder> {
private List<AnekdotModel> posts;

    public RecyclerViewPostsAdapter(List <AnekdotModel> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View myView = inflater.inflate(R.layout.post_item_lesson2, viewGroup, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AnekdotModel post = posts.get(i);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            viewHolder.post.setText(Html.fromHtml(post.getElementPureHtml(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            viewHolder.post.setText(Html.fromHtml(post.getElementPureHtml()));
        }
        viewHolder.site.setText(post.getSite());
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView post;
        TextView site;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post =itemView.findViewById(R.id.postitem_post);
            site =itemView.findViewById(R.id.postitem_site);
        }
    }

}
