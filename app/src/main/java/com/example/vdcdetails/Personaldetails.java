package com.example.vdcdetails;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Personaldetails.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Personaldetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Personaldetails extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RadioGroup radiogrp;
    TextInputLayout spouseprofession,abroadfrm;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Personaldetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Personaldetails.
     */
    // TODO: Rename and change types and number of parameters
    public static Personaldetails newInstance(String param1, String param2) {
        Personaldetails fragment = new Personaldetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personaldetails, container, false);

        radiogrp = (RadioGroup) view.findViewById(R.id.radioGroup);
        spouseprofession =(TextInputLayout) view.findViewById(R.id.spouse_profession);
        abroadfrm = (TextInputLayout) view.findViewById(R.id.abroadfrom);

        radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yes){
                    spouseprofession.setVisibility(View.VISIBLE);
                    abroadfrm.setVisibility(View.VISIBLE);
                }else{
                    spouseprofession.setVisibility(View.GONE);
                    abroadfrm.setVisibility(View.GONE);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private Button nextBT;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextBT = view.findViewById(R.id.nextBT);

    }

    @Override
    public void onResume() {
        super.onResume();
        nextBT.setOnClickListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        nextBT.setOnClickListener(null);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.nextBT:
                if (mListener != null)
                    mListener.onNextPressed(this);
                break;
        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        nextBT = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        //void onFragmentInteraction(Uri uri);
        void onNextPressed(Fragment fragment);
    }
}
