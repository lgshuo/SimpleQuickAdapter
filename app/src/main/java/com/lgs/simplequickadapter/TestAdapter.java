package com.lgs.simplequickadapter;

import android.view.View;
import android.widget.TextView;

import com.lgs.simplequickadapter.R;

import java.util.List;


public class TestAdapter extends SimpleQuickAdapter<String> {
    public TestAdapter(int resLayout, List<String> data) {
        super(resLayout, data);
    }

    @Override
    protected void convert(SimpleViewHolder holder, int position, String s) {
        TextView test = holder.itemView.findViewById(R.id.test);
        test.setText(s);
    }
}
