package com.specoria.firstrun;

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;

public class MainActivity extends ActionBarActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link FragmentPagerAdapter} derivative, which will keep every
	 * loaded fragment in memory. If this becomes too memory intensive, it
	 * may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

    private TextView dot1TextView;
    private TextView dot2TextView;
	private TextView dot3TextView;
    private FrameLayout pageIndicator;
    private TextView skipTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

       /**
		*Create the adapter that will return a fragment for each of the three
		*primary sections of the activity.
		*/
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

       /**
		* Set up the ViewPager with the sections adapter.
        */
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		final int disabled = getResources().getColor(R.color.dot_disabled);
		final int enabled = getResources().getColor(R.color.dot_enabled);

		dot1TextView = (TextView) findViewById(R.id.dot_1);
		dot2TextView = (TextView) findViewById(R.id.dot_2);
		dot3TextView = (TextView) findViewById(R.id.dot_3);
        pageIndicator = (FrameLayout) findViewById(R.id.pageIndicator);
        skipTextView = (TextView) findViewById(R.id.skip);

		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i, float v, int i2) {

			}

			@Override
			public void onPageSelected(int page) {
				dot1TextView.setTextColor(disabled);
				dot2TextView.setTextColor(disabled);
				dot3TextView.setTextColor(disabled);
                pageIndicator.setVisibility(View.VISIBLE);
				switch(page) {
					case 0:
                        skipTextView.setVisibility(INVISIBLE);
						dot1TextView.setTextColor(enabled);
						break ;
					case 1:
                        skipTextView.setVisibility(View.VISIBLE);
						dot2TextView.setTextColor(enabled);
						break ;
					case 2:
                        skipTextView.setVisibility(INVISIBLE);
                        dot3TextView.setTextColor(enabled);
                        break ;
					case 3:
					case 4:
                        pageIndicator.setVisibility(INVISIBLE);
						break ;
				}

			}

			@Override
			public void onPageScrollStateChanged(int i) {

			}
		});
	}


//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.menu_main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//
//		//noinspection SimplifiableIfStatement
//		if (id == R.id.action_settings) {
//			return true;
//		}
//
//		return super.onOptionsItemSelected(item);
//	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {

			switch(position) {
				case 0:
					return PlaceholderFragment.newInstance(R.layout.fragment_page1);
				case 1:
					return PlaceholderFragment.newInstance(R.layout.fragment_page2);
				case 2:
					return PlaceholderFragment.newInstance(R.layout.fragment_page3);
                case 3:
                    return PlaceholderFragment.newInstance(R.layout.fragment_page4);
                case 4:
                    return PlaceholderFragment.newInstance(R.layout.fragment_page5);
			}
			return null ;

		   /**
            * getItem is called to instantiate the fragment for the given page.
			* Return a PlaceholderFragment (defined as a static inner class below).
            */
		}

		@Override
		public int getCount() {
            /**
             * Show 5 total pages.
             */
			return 5;
		}

//		@Override
//		public CharSequence getPageTitle(int position) {
//			Locale l = Locale.getDefault();
//			switch (position) {
//				case 0:
//					return getString(R.string.title_section1).toUpperCase(l);
//				case 1:
//					return getString(R.string.title_section2).toUpperCase(l);
//				case 2:
//					return getString(R.string.title_section3).toUpperCase(l);
//                case 3:
//                    return getString(R.string.title_section4).toUpperCase(l);
//                case 4:
//                    return getString(R.string.title_section5).toUpperCase(l);
//			}
//			return null;
//		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this fragment.
		 */
		private static final String ARG_LAYOUT_ID = "layout_id";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int layoutId) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_LAYOUT_ID, layoutId);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
								 Bundle savedInstanceState) {
			Bundle arguments = getArguments();
			View rootView;
            rootView = inflater.inflate(arguments.getInt(ARG_LAYOUT_ID), container, false);
            return rootView;
		}
	}

}
