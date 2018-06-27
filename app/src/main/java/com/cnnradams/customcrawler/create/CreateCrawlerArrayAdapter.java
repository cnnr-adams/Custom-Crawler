package com.cnnradams.customcrawler.create;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.cnnradams.customcrawler.CrawlerDataObject;
import com.cnnradams.customcrawler.R;

/**
 * Created by cnnr2 on 2018-06-27.
 */

public class CreateCrawlerArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private String[] data;

    public CreateCrawlerArrayAdapter(Context context, String[] data) {
        super(context, -1, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        if (data[position].equals("add")) {
            rowView = inflater.inflate(R.layout.dialog_list_item_addmore, parent, false);

        }

        else {
            rowView = inflater.inflate(R.layout.dialog_list_item, parent, false);
            Spinner spinner = rowView.findViewById(R.id.input_spinner);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                    R.array.create_input_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinner.setAdapter(adapter);
        }





        return rowView;
    }
}