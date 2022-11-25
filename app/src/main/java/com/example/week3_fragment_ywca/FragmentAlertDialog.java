package com.example.week3_fragment_ywca;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
// MVVM

/// View
// View Model
// Model

public class FragmentAlertDialog extends DialogFragment {

    String msg = "" ;

    public static FragmentAlertDialog newInstance (String alertMsg){
        FragmentAlertDialog fad = new FragmentAlertDialog();

        Bundle b = new Bundle();
        b.putString("alertMsg", alertMsg);
        fad.setArguments(b);

        return fad;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            msg = getArguments().getString("alertMsg");

        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage(msg)
                .setPositiveButton("OK", (dialog, which) -> {} )
                .create();
    }

    public static String TAG = "PurchaseConfirmationDialog";
}
