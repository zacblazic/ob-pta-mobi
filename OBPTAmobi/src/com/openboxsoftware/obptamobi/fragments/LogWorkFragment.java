package com.openboxsoftware.obptamobi.fragments;

import com.openboxsoftware.obptamobi.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LogWorkFragment extends Fragment
{
	
	
	public LogWorkFragment() {
		
	}

	public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
    {
        /*TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        Bundle args = getArguments();
        textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
        return textView;*/
    	
    	return inflater.inflate(R.layout.fragment_log_work, container, false);
    }
}
