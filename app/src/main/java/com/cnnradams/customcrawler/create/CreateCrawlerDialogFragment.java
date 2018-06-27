package com.cnnradams.customcrawler.create;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.cnnradams.customcrawler.R;

/**
 * Created by cnnr2 on 2018-06-27.
 */

public class CreateCrawlerDialogFragment extends DialogFragment {
    public static CreateCrawlerDialogFragment newInstance() {
        CreateCrawlerDialogFragment frag = new CreateCrawlerDialogFragment();
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.crawler_dialog_layout,null);
        builder.setView(view)
                .setPositiveButton(R.string.create_accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton(R.string.create_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        CreateCrawlerDialogFragment.this.getDialog().cancel();
                    }
                });
        ListView depthList = view.findViewById(R.id.depth_list);
        String[] baseAdapter = {"","add"};
        CreateCrawlerArrayAdapter emptyData = new CreateCrawlerArrayAdapter(this.getActivity(),baseAdapter);
        Log.d("a",emptyData.toString());
        depthList.setAdapter(emptyData);

        Spinner spinner = view.findViewById(R.id.time_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.times_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        return builder.create();
    }

}
