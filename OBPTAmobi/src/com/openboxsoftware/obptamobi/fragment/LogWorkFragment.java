package com.openboxsoftware.obptamobi.fragment;

import com.openboxsoftware.obptamobi.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LogWorkFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view;
    	
    	view = inflater.inflate(R.layout.fragment_log_work, container, false);
    	
    	return view;
    }
}
