package com.openboxsoftware.obptamobi.listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.activity.MainFragmentActivity;
import com.openboxsoftware.obptamobi.preference.SignInPreferenceManager;

public class OnSignInClickListener implements OnClickListener 
{
	private Context context;
	
	public OnSignInClickListener(Context context)
	{
		this.context = context;
	}
	
	public void onClick(View view) 
	{
		SignInPreferenceManager pm = SignInPreferenceManager.get(context);
		CheckBox remember = (CheckBox)view.getRootView().findViewById(R.id.check_box_remember);
		
		if(remember.isChecked() && !pm.isRememberEnabled())
		{
			pm.setRememberEnabled(true);
		}
		else if(!remember.isChecked() && pm.isRememberEnabled())
		{
			pm.setRememberEnabled(false);
		}
		
		Intent intent = new Intent(context, MainFragmentActivity.class);
		context.startActivity(intent);
		
		((Activity)context).finish();
	}
}
