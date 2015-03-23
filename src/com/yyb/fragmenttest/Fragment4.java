package com.yyb.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment4 extends BaseFragment {

	public static BaseFragment newInstance(int index) { 
		BaseFragment fragment = new Fragment4();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	private View layoutView;
	private FragmentTabHost mTabHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		layoutView = inflater.inflate(R.layout.fragment4, null);
		
		return layoutView;
	}
}
