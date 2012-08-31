package com.openboxsoftware.obptamobi.dialog.signin;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.preference.SignInPreferenceManager;

public class OnSignInClickListener implements OnClickListener 
{
private DialogFragment dialog;
	
	public OnSignInClickListener(DialogFragment dialog)
	{
		this.dialog = dialog;
	}
	
	public void onClick(View view) 
	{
		SignInPreferenceManager pm = SignInPreferenceManager.get(dialog.getActivity());
		CheckBox remember = (CheckBox)view.getRootView().findViewById(R.id.check_box_remember);
		
		if(remember.isChecked() && !pm.isRememberEnabled())
		{
			pm.setRememberEnabled(true);
		}
		else if(!remember.isChecked() && pm.isRememberEnabled())
		{
			pm.setRememberEnabled(false);
		}
		
		dialog.dismiss();
	}
}
