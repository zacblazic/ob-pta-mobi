package com.openboxsoftware.obptamobi.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.adapter.SectionsPagerAdapter;

public class MainFragmentActivity extends FragmentActivity 
{
	private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.activity_main_fragment, menu);
        return true;
    }
}
