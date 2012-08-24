package com.openboxsoftware.obptamobi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SlidingDrawer;

import com.openboxsoftware.obptamobi.R;

public class LogWorkFragment extends Fragment
{
	
	SlidingDrawer drawer;
	
	
	public LogWorkFragment() {
		
	}

	public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
    {
        View v;
    	v = inflater.inflate(R.layout.fragment_log_work, container, false);
    	
    	    	
    	return v;
    }
}
