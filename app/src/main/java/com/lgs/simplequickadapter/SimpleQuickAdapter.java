package com.lgs.simplequickadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract  class SimpleQuickAdapter<B> extends RecyclerView.Adapter<SimpleViewHolder> {
    private int layoutId;
    protected List<B> mData;

    /**
     * @param layoutId 子条目的布局
     * @param list      数据
     */
    public SimpleQuickAdapter(@LayoutRes int layoutId, List<B> list) {
        this.layoutId = layoutId;
        this.mData = list != null ? list : new ArrayList<B>();
    }


    protected Context mContext;
    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(layoutId, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(view);
        return holder;
    }

    private OnItemClickListener onItemClickListener;

    @Override
    public void onBindViewHolder(final SimpleViewHolder holder, final int position) {
        if (this.onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(SimpleQuickAdapter.this, holder.itemView, mData.get(position), position);
                }
            });
        }
        convert(holder, position, mData.get(position));
    }

    protected abstract void convert(SimpleViewHolder holder, int position, B b);

    public  interface OnItemClickListener {
        void onItemClick(SimpleQuickAdapter adapter, View itemView, Object b, int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
