package com.example.vdcdetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vdcdetails.R;
import com.example.vdcdetails.SingleDetail;
import com.example.vdcdetails.model.PersonDetails;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonDetailsAdapter extends RecyclerView.Adapter<PersonDetailsAdapter.PersondetailsViewHolder>{

    Context mContext;
    List<PersonDetails> personaList;

    public PersonDetailsAdapter(Context mContext,List<PersonDetails> personList){
        this.mContext = mContext;
        this.personaList = personList;
    }


    @NonNull
    @Override
    public PersondetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewTiype) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_list,viewGroup,false);
        return new PersondetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersondetailsViewHolder holder, int i) {
        PersonDetails person = personaList.get(i);
        holder.profile.setImageResource(person.getImageId());
        holder.fatherdt.setText(person.getFathername());
        holder.motherdt.setText(person.getMothername());
        holder.fullname.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return personaList.size();
    }

    public class PersondetailsViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView profile;
        TextView fullname,fatherdt,motherdt;

        public PersondetailsViewHolder(View view) {
            super(view);

            profile = view.findViewById(R.id.list_image);
            fullname = view.findViewById(R.id.tvfullname);
            fatherdt = view.findViewById(R.id.fatherdt);
            motherdt = view.findViewById(R.id.motherdt);

            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    System.out.println("clicked on "+position);
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    SingleDetail details = new SingleDetail();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, details).addToBackStack(null).commit();
                }
            });

        }
      /*  @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            System.out.println("clicked on "+position);

            SingleDetail details = new SingleDetail();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.viewContainer,details).addToBackStack(null).commit();

        }*/
    }


}
