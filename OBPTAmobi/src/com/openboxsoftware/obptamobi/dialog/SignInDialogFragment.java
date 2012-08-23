package com.openboxsoftware.obptamobi.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openboxsoftware.obptamobi.R;

public class SignInDialogFragment extends DialogFragment {
	
	public static SignInDialogFragment newInstance() {
		return new SignInDialogFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int style = DialogFragment.STYLE_NO_TITLE;
		int theme = android.R.style.Theme_Holo_Dialog;
		
		this.setStyle(style, theme);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_sign_in, container, false);
	}
}
