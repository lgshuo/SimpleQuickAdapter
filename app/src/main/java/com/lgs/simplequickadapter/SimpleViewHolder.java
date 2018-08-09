package com.lgs.simplequickadapter;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;


public class SimpleViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> views;
    public SimpleViewHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
    }

    public <V extends View>V getView(int viewId){
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (V) view;
    }

    public SimpleViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    public SimpleViewHolder setText(@IdRes int viewId, @StringRes int strId) {
        TextView view = getView(viewId);
        view.setText(strId);
        return this;
    }
}
