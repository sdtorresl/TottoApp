package com.exeamedia.totto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;


public class Techniques extends ActionBarActivity {

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
    final int N_TECHNIQUES = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techniques);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_techniques, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


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
            String techniqueName;
            String techniqueDescription;

            switch (position){
                case 0:
                    techniqueName = getResources().getString(R.string.title_fragment_technique_1);
                    techniqueDescription = getResources().getString(R.string.description_fragment_technique_1);
                    break;
                case 1:
                    techniqueName = getResources().getString(R.string.title_fragment_technique_2);
                    techniqueDescription = getResources().getString(R.string.description_fragment_technique_2);
                    break;
                case 2:
                    techniqueName = getResources().getString(R.string.title_fragment_technique_3);
                    techniqueDescription = getResources().getString(R.string.description_fragment_technique_3);
                    break;
                case 3:
                    techniqueName = getResources().getString(R.string.title_fragment_technique_4);
                    techniqueDescription = getResources().getString(R.string.description_fragment_technique_4);
                    break;
                default:
                    techniqueName = getResources().getString(R.string.title_fragment_technique_5);
                    techniqueDescription = getResources().getString(R.string.description_fragment_technique_5);
                    break;
            }

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(techniqueName, techniqueDescription);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return N_TECHNIQUES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String TECHNIQUE_NAME = "name";
        private static final String TECHNIQUE_DESCRIPTION = "description";

        private String techniqueName;
        private String techniqueDescription;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                techniqueName = getArguments().getString(TECHNIQUE_NAME);
                techniqueDescription = getArguments().getString(TECHNIQUE_DESCRIPTION);
            }
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String techniqueName, String techniqueDescription) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(TECHNIQUE_NAME, techniqueName);
            args.putString(TECHNIQUE_DESCRIPTION, techniqueDescription);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_techniques, container, false);

            TextView techniqueNameTextView = (TextView) rootView.findViewById(R.id.technique_name);
            TextView techniqueDescriptionTextView = (TextView) rootView.findViewById(R.id.technique_description);

            techniqueNameTextView.setText(this.techniqueName);
            techniqueDescriptionTextView.setText(this.techniqueDescription);

            return rootView;
        }
    }

}
