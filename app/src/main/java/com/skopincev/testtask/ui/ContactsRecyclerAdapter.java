package com.skopincev.testtask.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.skopincev.testtask.R;
import com.skopincev.testtask.db.entity.Contact;

import java.util.List;

/**
 * Created by skopi on 16.06.2017.
 */

public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsRecyclerAdapter.ContactViewHolder> {

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_full_name;

        public ContactViewHolder(ViewGroup parent, View itemView) {
            super(itemView);
            tv_full_name = (TextView) itemView.findViewById(R.id.tv_full_name);
        }

        public void bind(Contact data){
            String fullName = data.getFirstName() + " " + data.getLastName();
            tv_full_name.setText(fullName);
        }
    }

    private List<Contact> items;
    private LayoutInflater inflater;

    public ContactsRecyclerAdapter(Context context, List<Contact> items)
    {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    public void add(Contact contact){
        items.add(contact);
        notifyItemInserted(items.size() - 1);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rvi_contact, parent, false);
        ContactViewHolder holder = new ContactViewHolder(parent, view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact data = items.get(position);
        if (data != null) {
            holder.bind(data);
        }
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }
}