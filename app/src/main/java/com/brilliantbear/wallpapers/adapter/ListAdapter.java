package com.brilliantbear.wallpapers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brilliantbear.wallpapers.R;
import com.brilliantbear.wallpapers.bean.ObjectsBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Bear on 2016-6-12.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ImageVIewHolder> {

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    private Context context;
    private List<ObjectsBean> objectsBeens;
    private OnItemClickListener listener;

    public ListAdapter(Context context, List<ObjectsBean> objectsBeens) {
        this.context = context;
        this.objectsBeens = objectsBeens;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ImageVIewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_iamge, parent, false);
        return new ImageVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageVIewHolder holder, final int position) {
        ObjectsBean objectsBean = objectsBeens.get(position);
        holder.tvName.setText(objectsBean.getCreator().getName());
        holder.tvTitle.setText(objectsBean.getTitle());
        Glide.with(context).load(objectsBean.getIphone_thumb()).into(holder.ivImg);

        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return objectsBeens == null ? 0 : objectsBeens.size();
    }

    public static class ImageVIewHolder extends RecyclerView.ViewHolder {

        ImageView ivImg;
        TextView tvTitle;
        TextView tvName;

        public ImageVIewHolder(View itemView) {
            super(itemView);
            ivImg = (ImageView) itemView.findViewById(R.id.iv_img);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
