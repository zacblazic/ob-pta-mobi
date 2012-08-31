package com.openboxsoftware.obptamobi.dialog.signin;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;

public class OnSignInClickListener implements OnClickListener 
{
private DialogFragment dialog;
	
	public OnSignInClickListener(DialogFragment dialog)
	{
		this.dialog = dialog;
	}
	
	public void onClick(View view) 
	{
		dialog.dismiss();
	}
}
