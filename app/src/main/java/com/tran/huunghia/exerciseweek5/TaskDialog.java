package com.tran.huunghia.exerciseweek5;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by user on 06/04/2018.
 */

public class TaskDialog extends DialogFragment {
    public static EditText edtTask;
    public static CheckBox cbHigh, cbLow, cbNormal;
    static String nameOfTask = "";
    DatePicker datePicker;
    static String priorityOfTask = "";
    PassValue passValue;
    AlertDialog.Builder abc;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        passValue = (PassValue) getActivity();
        abc = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View mview = inflater.inflate(R.layout.fragment_task,null);
        abc.setView(mview);
        edtTask = (EditText) mview.findViewById(R.id.etInputTask);
        cbHigh = (CheckBox) mview.findViewById(R.id.cbHigh);
        datePicker = (DatePicker) mview.findViewById(R.id.datePicker);
        cbNormal = (CheckBox) mview.findViewById(R.id.cbNormal);
        cbLow = (CheckBox) mview.findViewById(R.id.cbLow);
        /*btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtTask.equals("")){
                    nameOfTask = edtTask.getText().toString();
                }
                if (cbHigh.isChecked()){
                    priorityOfTask = "High";
                }
                else if (cbLow.isChecked()){
                    priorityOfTask = "Low";
                }
                else if (cbNormal.isChecked()){
                    priorityOfTask = "Normal";
                }
                String day = String.valueOf(datePicker.getDayOfMonth());
                String month = String.valueOf(datePicker.getMonth()+1);
                String year = String.valueOf(datePicker.getYear());
                passValue.openDialog(nameOfTask,priorityOfTask,day+"/"+month+"/"+year);
            }
        });*/
        abc.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!edtTask.equals("")){
                    nameOfTask = edtTask.getText().toString();
                }
                if (cbHigh.isChecked()){
                    priorityOfTask = "High";
                }
                else if (cbLow.isChecked()){
                    priorityOfTask = "Low";
                }
                else if (cbNormal.isChecked()){
                    priorityOfTask = "Normal";
                }
                String day = String.valueOf(datePicker.getDayOfMonth());
                String month = String.valueOf(datePicker.getMonth()+1);
                String year = String.valueOf(datePicker.getYear());
                passValue.openDialog(nameOfTask,priorityOfTask,day+"/"+month+"/"+year);
            }
        });
        abc.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return abc.create();
    }
}
