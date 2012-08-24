package com.openboxsoftware.obptamobi.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.openboxsoftware.obptamobi.PTAActivity;
import com.openboxsoftware.obptamobi.R;

public class SignInDialogFragment extends DialogFragment {

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
		
		View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
		Button signInButton = (Button)view.findViewById(R.id.button_sign_in);
		signInButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				Toast.makeText(getActivity(), "Signing in...", Toast.LENGTH_SHORT).show();
				
				((PTAActivity)getActivity()).setSignedIn(true);
				
				SignInDialogFragment.this.dismiss();
				Toast.makeText(getActivity(), "Signed in successfully.", Toast.LENGTH_SHORT).show();
			}
		});
		
		Button cancelButton = (Button)view.findViewById(R.id.button_cancel);
		cancelButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				Toast.makeText(getActivity(), "Exiting application...", Toast.LENGTH_SHORT).show();
				SignInDialogFragment.this.dismiss();
				((PTAActivity)getActivity()).finish();
			}
		});
		
		// Don't allow the dialog to be cancelled by touching outside of it
		this.getDialog().setCanceledOnTouchOutside(false);
		
		return view;
	}
}
