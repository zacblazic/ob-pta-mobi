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

public class PTAActivity extends FragmentActivity 
{
	private static final String SIGNED_IN_STATE = "signed_in_state";
	
	private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    
    private DialogFragment mSignInDialog;
    private boolean mSignedIn;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pta);

        mSectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        
        mSignInDialog = new SignInDialogFragment();
        
        if(savedInstanceState != null) 
        {
        	mSignedIn = savedInstanceState.getBoolean(SIGNED_IN_STATE);
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
    	savedInstance.putBoolean(SIGNED_IN_STATE, mSignedIn);
    	super.onSaveInstanceState(savedInstance);
    }
    
    @Override
    protected void onPause() 
    {
    	if(mSignInDialog != null && mSignInDialog.isVisible()) 
    	{
    		mSignInDialog.dismiss();
    	}
    	
    	super.onPause();
    }

    public boolean isSignedIn() 
    {
    	return mSignedIn;
    }
    
    public void setSignedIn(boolean signedIn) 
    {
    	this.mSignedIn = signedIn;
    }
    
    public void showSignInDialog() 
    {
    	FragmentManager fm = getSupportFragmentManager();
    	mSignInDialog.show(fm, "sign_in_dialog");
    }
}
