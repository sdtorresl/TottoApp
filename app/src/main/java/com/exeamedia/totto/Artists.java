package com.exeamedia.totto;

import android.net.Uri;
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

import java.util.Locale;


public class Artists extends ActionBarActivity implements SingleArtist.OnFragmentInteractionListener {

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
    static int N_ARTISTS = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);


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
        getMenuInflater().inflate(R.menu.menu_artists, menu);
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

    @Override
    public void onFragmentInteraction(Uri uri) {
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
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            String name;
            String age;
            String description;
            int imageResource;

            if (position == 0)
                return Artists.PlaceholderFragment.newInstance(position);

            switch (position){
                case 1:
                    name = getResources().getString(R.string.artist_title_1);
                    age = getResources().getString(R.string.artist_age_1);
                    description = getResources().getString(R.string.artist_description_1);
                    imageResource = R.mipmap.shirley_arias_chitiva;
                    break;
                case 2:
                    name = getResources().getString(R.string.artist_title_2);
                    age = getResources().getString(R.string.artist_age_2);
                    description = getResources().getString(R.string.artist_description_2);
                    imageResource = R.mipmap.karol_fuentes;
                    break;
                case 3:
                    name = getResources().getString(R.string.artist_title_3);
                    age = getResources().getString(R.string.artist_age_3);
                    description = getResources().getString(R.string.artist_description_3);
                    imageResource = R.mipmap.heidy_fuentes;
                    break;
                case 4:
                    name = getResources().getString(R.string.artist_title_4);
                    age = getResources().getString(R.string.artist_age_4);
                    description = getResources().getString(R.string.artist_description_4);
                    imageResource = R.mipmap.leidy_gonzalez;
                    break;
                case 5:
                    name = getResources().getString(R.string.artist_title_5);
                    age = getResources().getString(R.string.artist_age_5);
                    description = getResources().getString(R.string.artist_description_5);
                    imageResource = R.mipmap.sharon_gutierrez;
                    break;
                case 6:
                    name = getResources().getString(R.string.artist_title_6);
                    age = getResources().getString(R.string.artist_age_6);
                    description = getResources().getString(R.string.artist_description_6);
                    imageResource = R.mipmap.natalia_ibarra;
                    break;
                case 7:
                    name = getResources().getString(R.string.artist_title_7);
                    age = getResources().getString(R.string.artist_age_7);
                    description = getResources().getString(R.string.artist_description_7);
                    imageResource = R.mipmap.julian_patarroyo;
                    break;
                case 8:
                    name = getResources().getString(R.string.artist_title_8);
                    age = getResources().getString(R.string.artist_age_8);
                    description = getResources().getString(R.string.artist_description_8);
                    imageResource = R.mipmap.brayan_ramirez_pena;
                    break;
                case 9:
                    name = getResources().getString(R.string.artist_title_9);
                    age = getResources().getString(R.string.artist_age_9);
                    description = getResources().getString(R.string.artist_description_9);
                    imageResource = R.mipmap.joiner_rojas;
                    break;
                case 10:
                    name = getResources().getString(R.string.artist_title_10);
                    age = getResources().getString(R.string.artist_age_10);
                    description = getResources().getString(R.string.artist_description_10);
                    imageResource = R.mipmap.wendy_tovar;
                    break;
                case 11:
                    name = getResources().getString(R.string.artist_title_11);
                    age = getResources().getString(R.string.artist_age_11);
                    description = getResources().getString(R.string.artist_description_11);
                    imageResource = R.mipmap.nicolas_rincon;
                    break;
                default:
                    name = getResources().getString(R.string.artist_title_12);
                    age = getResources().getString(R.string.artist_age_12);
                    description = getResources().getString(R.string.artist_description_12);
                    imageResource = R.mipmap.jean_paul_moreno;
                    break;
            }

            return SingleArtist.newInstance(name, age, description, imageResource);
        }

        @Override
        public int getCount() {
            return N_ARTISTS +1;
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
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_artists, container, false);
            return rootView;
        }
    }

}
