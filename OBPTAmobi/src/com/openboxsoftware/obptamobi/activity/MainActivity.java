package com.openboxsoftware.obptamobi.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.adapter.SectionsPagerAdapter;
import com.openboxsoftware.obptamobi.dialog.signin.SignInDialogFragment;

public class MainActivity extends FragmentActivity 
{
	private static final String SIGNED_IN_STATE = "signed_in_state";
	
	private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    
    private DialogFragment signInDialog;
    private boolean signedIn;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        
        signInDialog = new SignInDialogFragment();
        
        if(savedInstanceState != null) 
        {
        	signedIn = savedInstanceState.getBoolean(SIGNED_IN_STATE);
        }
        
        if(!isSignedIn()) 
        {
        	this.showSignInDialog();
        }
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.activity_pta, menu);
        return true;
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstance) 
    {
    	savedInstance.putBoolean(SIGNED_IN_STATE, signedIn);
    	super.onSaveInstanceState(savedInstance);
    }
    
    @Override
    protected void onPause() 
    {
    	if(signInDialog != null && signInDialog.isVisible()) 
    	{
    		signInDialog.dismiss();
    	}
    	
    	super.onPause();
    }

    public boolean isSignedIn() 
    {
    	return signedIn;
    }
    
    public void setSignedIn(boolean signedIn) 
    {
    	this.signedIn = signedIn;
    }
    
    public void showSignInDialog() 
    {
    	FragmentManager fm = getSupportFragmentManager();
    	signInDialog.show(fm, "sign_in_dialog");
    }
}
