package com.lzm.showgirls;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fmsirvent.ParallaxEverywhere.PEWImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by luzhiming on 16/9/9.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<VH> {
    List<String> mList;
    Context mContext;

    public RecyclerAdapter(List<String> mList, Context context) {
        this.mList = mList;
        this.mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        Picasso.with(mContext).load(mList.get(position))
                .placeholder(R.drawable.test1)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ShowImage.class);
                intent.putExtra("image_url", mList.get(position));
                AnimationUtils.myTransitionImage((Activity) mContext, holder.imageView, "myview");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, holder.imageView, "myview");
                mContext.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

class VH extends RecyclerView.ViewHolder {
    PEWImageView imageView;

    public VH(View itemView) {
        super(itemView);
        imageView = (PEWImageView) itemView.findViewById(R.id.pew_image);
    }

}


