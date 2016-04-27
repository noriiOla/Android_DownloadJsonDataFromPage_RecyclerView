package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projects.ola.jsonapiinrecyclerview1tem1.model.Person;

import java.util.List;

/**
 * Created by Ola on 2016-04-24.
 */
public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.MyViewHolder> {
    private List<Person> personsList;

    public PersonsAdapter(List<Person> personsList) {
        this.personsList = personsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView surname;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.TextViewName);
            surname = (TextView) itemView.findViewById(R.id.TextViewSurname);
        }
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

}
