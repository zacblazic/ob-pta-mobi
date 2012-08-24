package com.openboxsoftware.obptamobi.fragment;

import java.util.Calendar;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.dialog.AddNewCategoryDialogFragment;
import com.openboxsoftware.obptamobi.dialog.DatePickerFragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LogWorkFragment extends Fragment
{
	
	
	public LogWorkFragment() {
		
	}

	public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
    {
        View view;
    	
    	view = inflater.inflate(R.layout.fragment_log_work, container, false);
    	
    	Button newCategoryButton = (Button)view.findViewById(R.id.button_new_category);
		newCategoryButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				showAddCategoryDialog();
			}
		});
		final Calendar c = Calendar.getInstance();
		
		Button dateWorkedButton = (Button)view.findViewById(R.id.button_date_worked);
		dateWorkedButton.setText(c.get(Calendar.DAY_OF_MONTH) + "/" 
								+ c.get(Calendar.MONTH) 
								+ "/" + c.get(Calendar.YEAR));
		dateWorkedButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				showDatePickerDialog();
			}
		});
    	
    	return view;
    }
    

	private void showAddCategoryDialog() {
		FragmentManager fm = getFragmentManager();
    	FragmentTransaction ft = fm.beginTransaction();
    	Fragment previous = fm.findFragmentByTag("add_new_category_dialog");
    	
    	if(previous != null) {
    		ft.remove(previous);
    	}
    	
    	ft.addToBackStack(null);
    	
    	DialogFragment fragment = AddNewCategoryDialogFragment.newInstance();
    	fragment.show(ft, "add_new_category_dialog");
	}
	
	private void showDatePickerDialog()
	{
		DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(this.getFragmentManager(), "datePicker");
	}
}
