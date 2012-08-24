package com.openboxsoftware.obptamobi;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.openboxsoftware.obptamobi.dialog.SignInDialogFragment;
import com.openboxsoftware.obptamobi.fragment.LogWorkFragment;
import com.openboxsoftware.obptamobi.fragment.SummaryFragment;

public class PTAActivity extends FragmentActivity {

    private static final String SIGNED_IN_STATE = "signed_in_state";
	
	private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private boolean signedIn;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pta);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        
        if(savedInstanceState != null) {
        	signedIn = savedInstanceState.getBoolean(SIGNED_IN_STATE);
        }
        
        if(!isSignedIn()) {
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
    protected void onSaveInstanceState(Bundle savedInstance) {
    	savedInstance.putBoolean(SIGNED_IN_STATE, signedIn);
    	super.onSaveInstanceState(savedInstance);
    }

    public boolean isSignedIn() {
    	return signedIn;
    }
    
    public void setSignedIn(boolean signedIn) {
    	this.signedIn = signedIn;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter 
    {

        public SectionsPagerAdapter(FragmentManager fm) 
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) 
        {
        	Fragment fragment;
            
        	switch(i) {
        		case 0 : fragment = new SummaryFragment(); break;
        		case 1 : fragment = new LogWorkFragment(); break;
        		default : fragment = new SummaryFragment();
        	}

            return fragment;
        }

        @Override
        public int getCount() 
        {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) 
        {
            switch (position) 
            {
                case 0: return getString(R.string.title_section1).toUpperCase();
                case 1: return getString(R.string.title_section2).toUpperCase();
                case 2: return getString(R.string.title_section3).toUpperCase();
            }
            return null;
        }
    }
    
    public void showSignInDialog() {
    	FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction ft = fm.beginTransaction();
    	Fragment previous = fm.findFragmentByTag("sign_in_dialog");
    	
    	if(previous != null) {
    		ft.remove(previous);
    	}
    	
    	ft.addToBackStack(null);
    	
    	DialogFragment fragment = SignInDialogFragment.newInstance();
    	fragment.show(ft, "sign_in_dialog");
    }
}
