package com.ardakazanci.recyclerviewtutorial3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private List<Model> feedItemList;
    private Context context;


    public Adapter(Context context, List<Model> model) {

        this.context = context;
        this.feedItemList = model;

    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Model feedItem = feedItemList.get(position); // ilgili verinin pozisyon bilgisi
        // Picasso kullanarak görüntüyü gösterme işlemi

        if (!TextUtils.isEmpty(feedItem.getThumbnail())) {
            Picasso.with(context).load(feedItem.getThumbnail())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);

        }

        holder.textView.setText(Html.fromHtml(feedItem.getTitle()));


    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);


    }

    // Görünüm refranslarını oluşturma ve eşleştirme.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView textView;

        // itemview View türünden bir argüman alır. Bunun aracılığıyla XML içinde ki değerlere ulaşabiliriz.
        public CustomViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.textView = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
