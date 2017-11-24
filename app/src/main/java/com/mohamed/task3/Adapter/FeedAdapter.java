package com.mohamed.task3.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohamed.task3.Model.RssObject;
import com.mohamed.task3.R;
import com.mohamed.task3.interference.ItemClickListner;

/**
 * Created by mohamed on 11/23/2017.
 */
class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public TextView textTitle,textPubDate,textContent;
    private ItemClickListner itemClickListner;



    public FeedViewHolder(View itemView) {
        super(itemView);
        textTitle = (TextView)itemView.findViewById(R.id.textTitle);
        textPubDate = (TextView)itemView.findViewById(R.id.textPubDate);
        textContent = (TextView)itemView.findViewById(R.id.textContent);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);


    }
    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
    itemClickListner.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListner.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder>{

    private RssObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RssObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.textTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.textPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.textContent.setText(rssObject.getItems().get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
