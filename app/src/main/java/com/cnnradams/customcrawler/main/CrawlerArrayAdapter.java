package com.cnnradams.customcrawler.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnnradams.customcrawler.CrawlerDataObject;
import com.cnnradams.customcrawler.R;

/**
 * Created by cnnr2 on 2018-06-27.
 */

public class CrawlerArrayAdapter extends ArrayAdapter<CrawlerDataObject> {

    private final Context context;
    private final CrawlerDataObject[] data;
    public CrawlerArrayAdapter(Context context, CrawlerDataObject[] data) {
        super(context, -1, data);
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.crawler_list_item, parent, false);
        TextView titleTextView = rowView.findViewById(R.id.title);
        TextView urlTextView = rowView.findViewById(R.id.url);
        titleTextView.setText(data[position].title);
        urlTextView.setText(data[position].url);

        return rowView;
    }
}
