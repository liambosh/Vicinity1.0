/*
 * 
 */
package liam.vicinity;

import liam.vicinity1.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * @author Liam
 * 
 */
public class testBench extends ActionBar {
	
	RelativeLayout ActionBar;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);
		ActionBar = super.CreateActionBar();
		LinearLayout l = (LinearLayout) findViewById(R.id.LL1);
		//l.addView(ActionBar);
		
		
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
