package com.openboxsoftware.obptamobi.fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.adapter.LogDataAdapter;
import com.openboxsoftware.obptamobi.dialog.AddNewCategoryDialogFragment;
import com.openboxsoftware.obptamobi.dialog.DatePickerFragment;

public class LogWorkFragment extends Fragment
{
	String stuff[] = new String[6];
	
	public LogWorkFragment() {
		stuff [0]= "Cake";
		stuff [1]= "IS";
		stuff [2]= "Very";
		stuff [3]= "Lekka";
		stuff [4]= "Mr";
		stuff [5]= "Spriteman";
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
		
		
		ListView lv = (ListView)view.findViewById(R.id.list_view);
		/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
				, android.R.layout.simple_list_item_1
				, android.R.id.text1
				, stuff);
		
		lv.setAdapter(adapter);
		*/

		List<String> cat = new ArrayList<String>();
		cat.add("OB:Admin - Training\nTraining\nnon-Project related training");
		cat.add("OB:Leave - Admin\nOther Leave\nStudy Leave");
		cat.add("OB:Leave - Admin\nPublic Holidays\nAll Public Holidays");
		List<String> hrs = new ArrayList<String>();
		hrs.add("0");
		hrs.add("6");
		hrs.add("0");
		
		LogDataAdapter adapter = new LogDataAdapter(getActivity(), cat, hrs);
		
		lv.setAdapter(adapter);
    	
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
