package com.example.vdcdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vdcdetails.adapter.PersonDetailsAdapter;
import com.example.vdcdetails.model.PersonDetails;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FragmentViewlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentViewlist extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentViewlist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentViewlist.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentViewlist newInstance(String param1, String param2) {
        FragmentViewlist fragment = new FragmentViewlist();
        Bundle args = new Bundle();
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

        List<PersonDetails> personList = new ArrayList<>();
        personList.add(new PersonDetails("जित बहादुर मगर","कृष्ण बहादुर मगर","माया मगर",R.drawable.person));
        personList.add(new PersonDetails("जित बहादुर मगर","कृष्ण बहादुर मगर","माया मगर",R.drawable.person));
        personList.add(new PersonDetails("जित बहादुर मगर","कृष्ण बहादुर मगर","माया मगर",R.drawable.person));
        personList.add(new PersonDetails("जित बहादुर मगर","कृष्ण बहादुर मगर","माया मगर",R.drawable.person));
        personList.add(new PersonDetails("जित बहादुर मगर","कृष्ण बहादुर मगर","माया मगर",R.drawable.person));

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_viewlist, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.itemrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        PersonDetailsAdapter personAdapter = new PersonDetailsAdapter(getActivity(),personList);
        recyclerView.setAdapter(personAdapter);


        return view;
    }

}
