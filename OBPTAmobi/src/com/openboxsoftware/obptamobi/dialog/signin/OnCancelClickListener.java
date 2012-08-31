package com.openboxsoftware.obptamobi.dialog.signin;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;

public class OnCancelClickListener implements OnClickListener 
{
	private DialogFragment dialog;
	
	public OnCancelClickListener(DialogFragment dialog)
	{
		this.dialog = dialog;
	}
	
	public void onClick(View view) 
	{
		dialog.getActivity().finish();
	}
}
