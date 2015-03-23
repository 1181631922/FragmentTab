package com.yyb.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment11 extends BaseFragment {

	public static BaseFragment newInstance(int index) {
		BaseFragment fragment = new Fragment11();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		fragment.setIndex(index);
		return fragment;
	}

	private View layoutView;
	private FragmentTabHost mTabHost;
	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		layoutView = inflater.inflate(R.layout.fragment1, null);

		init(getIndex());
		// Log.e("标题栏为多少", getIndex()+"");

		return layoutView;
	}

	public void init(int i) {
		

		if (i == 0) {
			TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
			tv.setText( 1+ "");

			Log.e("标题栏为多少", 1 + "");
		}
		if (i == 1) {
			TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
			tv.setText( 2+ "");
			Log.e("标题栏为多少", 2 + "");
		}
		if (i == 2) {
			TextView tv = (TextView) layoutView.findViewById(R.id.textView111);
			tv.setText( 3+ "");
			Log.e("标题栏为多少", 3 + "");
		}
	}

}
