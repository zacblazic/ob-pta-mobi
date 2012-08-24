package com.openboxsoftware.obptamobi.dialog;

import java.util.Calendar;

import com.openboxsoftware.obptamobi.R;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		DatePickerDialog dpd = new DatePickerDialog(getActivity(), this, year, month, day);
		dpd.setTitle("Date Worked");
		
		return dpd;
	}
	
	public void onDateSet(DatePicker view, int year, int month, int day) {
		Button dateWorkedButton = (Button)getActivity().findViewById(R.id.button_date_worked);
		dateWorkedButton.setText(day + "/" + month + "/" + year);
    } 
}
