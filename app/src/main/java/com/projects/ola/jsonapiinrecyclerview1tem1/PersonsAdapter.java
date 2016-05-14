package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.ola.jsonapiinrecyclerview1tem1.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ola on 2016-04-24.
 */

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.MyViewHolder> {
    private List<Person> personsList=new ArrayList<>();

    public PersonsAdapter(List<Person> personsList) {

        this.personsList = personsList;
    }

    @Override
    public PersonsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_row_in_recycle_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PersonsAdapter.MyViewHolder holder, int position) {
        Person person = personsList.get(position);
        holder.name.setText(person.getName());
        holder.surname.setText(person.getSurname());
    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Nullable @Bind(R.id.TextViewName) TextView name;
        @Nullable @Bind(R.id.TextViewSurname) TextView surname;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //name = (TextView) itemView.findViewById(R.id.TextViewName);
            //surname = (TextView) itemView.findViewById(R.id.TextViewSurname);
        }
    }
}
