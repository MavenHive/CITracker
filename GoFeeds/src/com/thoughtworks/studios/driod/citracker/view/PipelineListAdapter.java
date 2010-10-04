package com.thoughtworks.studios.driod.citracker.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.thoughtworks.studios.driod.citracker.model.Pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PipelineListAdapter extends ArrayAdapter<Pipeline> {
    private static Map<String, Integer> colourStatus = new HashMap<String, Integer>();
    static{
        colourStatus.put("failed", Color.RED);
        colourStatus.put("passed", Color.GREEN);
        colourStatus.put("cancelled", Color.YELLOW);
    };

    public PipelineListAdapter(Context context, int textViewResourceId, List<Pipeline> messages) {
        super(context, textViewResourceId, messages);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        Pipeline item = getItem(position);
        view.setBackgroundColor(colourStatus.get(item.getCurrentStatus()));
        return view;
    }
}