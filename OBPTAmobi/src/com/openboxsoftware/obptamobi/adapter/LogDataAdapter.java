package com.openboxsoftware.obptamobi.adapter;

import java.util.List;

import com.openboxsoftware.obptamobi.R;
import com.openboxsoftware.obptamobi.holder.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LogDataAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	private List<String> category;
	private List<String> hours;

	public LogDataAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}
	public LogDataAdapter(Context context, List<String> category, List<String> hours) {
		mInflater = LayoutInflater.from(context);
		this.category = category;
		this.hours = hours;
	}

	public int getCount() {
		
		return category.size();
	}

	public Object getItem(int arg0) {
		
		return category.get(arg0);
	}

	public long getItemId(int arg0) {
		return arg0;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder holder;
		
		if (arg1 == null)
		{
			arg1 = mInflater.inflate(R.layout.listview, null);
			holder = new ViewHolder();
			holder.txt1 = (TextView) arg1.findViewById(R.id.label_category);
			holder.txt2 = (TextView) arg1.findViewById(R.id.label_hours);
			
			arg1.setTag(holder);
		}
		
		else 
		{
			holder = (ViewHolder)arg1.getTag();
		}
		
		holder.txt1.setText(category.get(arg0));		
		holder.txt2.setText(hours.get(arg0));
		
		return arg1;
	}
	
}
