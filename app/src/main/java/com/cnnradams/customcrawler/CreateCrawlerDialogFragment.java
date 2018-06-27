package com.cnnradams.customcrawler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

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
        builder.setView(inflater.inflate(R.layout.crawler_dialog_layout,null))
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
        return builder.create();
    }

}
