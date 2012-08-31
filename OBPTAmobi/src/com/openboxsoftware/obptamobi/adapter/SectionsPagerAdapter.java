package com.openboxsoftware.obptamobi.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.fragment.SummaryFragment;
import com.openboxsoftware.obptamobi.fragment.logwork.LogWorkFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter 
{
    private Context context;
    
	public SectionsPagerAdapter(Context context, FragmentManager fm) 
	{
		super(fm);
		this.context = context;
	}

    @Override
    public Fragment getItem(int i) 
    {
    	Fragment fragment;
        
    	switch(i) 
    	{
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
            case 0: return context.getString(R.string.title_section1).toUpperCase();
            case 1: return context.getString(R.string.title_section2).toUpperCase();
            case 2: return context.getString(R.string.title_section3).toUpperCase();
        }
        
        return null;
    }
}
