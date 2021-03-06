package com.exeamedia.totto;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SingleArtist.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SingleArtist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleArtist extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE_RESOURCE = "imageResource";

    // TODO: Rename and change types of parameters
    private String name;
    private String age;
    private String description;
    private int imageResource;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static SingleArtist newInstance(String name, String age, String description, int imageResource) {
        SingleArtist fragment = new SingleArtist();
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putString(AGE, age);
        args.putString(DESCRIPTION, description);
        args.putInt(IMAGE_RESOURCE, imageResource);
        fragment.setArguments(args);
        return fragment;
    }

    public SingleArtist() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME);
            age = getArguments().getString(AGE);
            description = getArguments().getString(DESCRIPTION);
            imageResource = getArguments().getInt(IMAGE_RESOURCE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_single_artist, container, false);

        TextView nameTextView = (TextView) rootView.findViewById(R.id.textArtistTitle);
        TextView ageTextView = (TextView) rootView.findViewById(R.id.textArtistAge);
        TextView descriptionTextView = (TextView) rootView.findViewById(R.id.textArtistDescription);
        ImageView picture = (ImageView) rootView.findViewById(R.id.artistPicture);

        nameTextView.setText(name);
        ageTextView.setText(age);
        descriptionTextView.setText(description);
        picture.setImageResource(imageResource);

        return rootView;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
