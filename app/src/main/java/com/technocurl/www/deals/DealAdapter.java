package com.technocurl.www.deals;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by deadlydragger on 7/6/16.
 */
public class DealAdapter extends RecyclerView.Adapter<DealAdapter.Myviewholder> {
    private Context mContext;
    private List<GetdealData> albumList;


     public DealAdapter(Context context,List<GetdealData> list){
         this.mContext=context;
         this.albumList=list;
     }
    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_iteam,parent,false);
        return new  Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        GetdealData getdealData = albumList.get(position);
        holder.title.setText(getdealData.getDealDesc());
        holder.content.setText(getdealData.getLocPhone());
        Glide.with(mContext).load(getdealData.getImgUrl1()).into(holder.mainImage);


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
    public class Myviewholder extends RecyclerView.ViewHolder{
        ImageView mainImage;
        TextView title,content;

        public Myviewholder(View itemView) {
            super(itemView);
            mainImage=(ImageView)itemView.findViewById(R.id.mainImage);
            title=(TextView)itemView.findViewById(R.id.title);
            content=(TextView)itemView.findViewById(R.id.text);

        }
    }
}
