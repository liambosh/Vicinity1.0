/**
 * @author Liam Boshell
 * @Date 14/05/2012
 * @Project - Vicinity - Android Application
 * @Version 1.0
 * 
 * @Description - Action Bar Class - Creates a relative layout containing a textured background
 * with an imageView(the logo) and an imageButton(the filter button)
 * 
 * In order to use this class new activities should inherit ActionBar
 * i.e. public class XXXX extends ActionBar{
 * 
 * CreateActionBar() returns a relative layout which can be added to the required view
 * 
 * To create the ActionBar call "ActionBar" = super.CreateActionBar(); (where "action bar"
 * is a relative layout in the new activity)
 * 
 * To add the "ActionBar" to the required view call YYY.addView(ActionBar) where YYY is another layout
 * 
 * 
 * Note to Author - Need to add padding to create the correct Alignment :D
 */
package liam.vicinity;

import liam.vicinity1.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Shader;

public abstract class ActionBar extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/*
	 * @Name - CreateActionBar()
	 * 
	 * @Return - the ActionBar (a correctly formatted Relative Layout")
	 * 
	 * @Dependencies - small_logo - logo for the image View - filter - image for
	 * the image Button - texture2 - Image for the repeating background
	 * 
	 * @Description - Creates a Relative Layout of height 50dp, adds an image view of width
	 * 100dp - logo = small logo, adds an imageButton with a source image = filter
	 */
	public RelativeLayout CreateActionBar() {
		// Creates a new Relative Layout
		RelativeLayout ActionBar = new RelativeLayout(this);
		// Defining the layout parameters for the Actionbar.
		RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		// set the height to 50dp
		rlp.height = calculatepx(50);

		// Creates a new ImageView
		ImageView iv = new ImageView(this);

		// Sets the logo to the Imageview
		iv.setImageResource(R.drawable.small_logo);

		// scale the logo to fit within the ImageView
		iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

		// Sets the layout parameters of the imageView
		RelativeLayout.LayoutParams lp0 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		// sets the width of the imageView to 100dp
		lp0.width = calculatepx(100);
		// sets the relative Positioning
		lp0.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp0.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lp0.leftMargin = calculatepx(15);
		// Set the above parameters onto the imageView
		iv.setLayoutParams(lp0);

		// Adding the ImageView to the ActionBar(RelativeLayout) as a child
		ActionBar.addView(iv);

		// Creates a new ImageButton
		ImageButton ib = new ImageButton(this);

		// sets the image for the button
		ib.setImageResource(R.drawable.filter);

		// scale the logo within the imageButton
		ib.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

		// Sets the layout parameters of the imageButton
		RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp1.rightMargin = calculatepx(10);
		lp1.topMargin =calculatepx(5);
		lp1.width = calculatepx(45);
		// Set the above parameters onto the imageButton
		ib.setLayoutParams(lp1);

		// Adding the ImageButton to the ActionBar(RelativeLayout)
		// RelativeLayout as a child
		ActionBar.addView(ib);

		// create a new tiled texture from the source texture
		Bitmap bmp = BitmapFactory.decodeResource(getResources(),
				R.drawable.texture2);
		BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
		bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT,
				Shader.TileMode.REPEAT);

		// Set the tiled texture to be the background of the actionBar
		ActionBar.setBackgroundDrawable(bitmapDrawable);

		// Set the Layout parameters for the action Bar
		ActionBar.setLayoutParams(rlp);
		super.setContentView(ActionBar);
		return ActionBar;
	}

	
	/*
	 * @Name - calculatepx()
	 
	 * @param - dpValue - the value of dp required
	 * 
	 * @return - px - the value in px of the specified dp
	 * 
	 * @Description - calculates the pixel value for a given dp value
	 */
	private int calculatepx(int dpValue) {
		// calculate the number of pixels based on dpValue parameter and then set the width
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dpValue, getResources().getDisplayMetrics());
		return px;
	}
}
