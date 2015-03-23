package com.yyb.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class Fragment1 extends BaseFragment implements OnClickListener{

	public static BaseFragment newInstance(int index) { 
		BaseFragment fragment = new Fragment1();
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

		layoutView = inflater.inflate(R.layout.fragment_tabs, null);
		
		layoutView.findViewById(R.id.button1).setOnClickListener(this);
		layoutView.findViewById(R.id.button1).setSelected(true);
		layoutView.findViewById(R.id.button2).setOnClickListener(this);
		layoutView.findViewById(R.id.button3).setOnClickListener(this);

		if(savedInstanceState ==null){
			BaseFragment fragment = (BaseFragment)getChildFragmentManager().findFragmentByTag(0+"");// getActivity().getSupportFragmentManager().findFragmentByTag(index+""); 
			if(fragment==null){
				init(0);
			}
		}//默认填充0fragment
		
		
		return layoutView;
	}
	
	private void init(int index) {
		FragmentTransaction ft = getChildFragmentManager().beginTransaction();
		ft.add(R.id.realtabcontent, Fragment11.newInstance(index) ,index+"");//将得到的fragment 替换当前的viewGroup内容，add则不替换会依次累加
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);//设置动画效果
		ft.commit();//提交
	}

	@Override
	public void onClick(View v) {
		
		allNoSelect();
		
		switch (v.getId()) {
		case R.id.button1:
			placeView(0);
			break;
		case R.id.button2:
			placeView(1);
			break;
		case R.id.button3:
			placeView(2);
			break;
		default:
			break;
		}
		
		v.setSelected(true);
	}

	private void allNoSelect() {
		layoutView.findViewById(R.id.button1).setSelected(false);
		layoutView.findViewById(R.id.button2).setSelected(false);
		layoutView.findViewById(R.id.button3).setSelected(false);
	}

	public void placeView(int index){
		BaseFragment fragment = (BaseFragment)getChildFragmentManager().findFragmentByTag(index+"");
		// getActivity().getSupportFragmentManager().findFragmentByTag(index+""); 获取顶层的fragement
		//得到一个fragment 事务（类似sqlite的操作）
		FragmentTransaction ft = getChildFragmentManager().beginTransaction();
		if (fragment == null ) {
			switch (index) {
			case 0:
				fragment = Fragment11.newInstance(index); 
//				Log.e("标题栏为多少", index+"");
				return;
			case 1:
				fragment = Fragment11.newInstance(index); 
//				Log.e("标题栏为多少", index+"");
				break;
			case 2:
				fragment = Fragment11.newInstance(index); 
//				Log.e("标题栏为多少", index+"");
				break;
			default:

				return;
			}

		}
		ft.replace(R.id.realtabcontent, fragment,index+"");//将得到的fragment 替换当前的viewGroup内容，add则不替换会依次累加
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);//设置动画效果
		ft.addToBackStack(null);
		ft.commit();//提交

	}
}
