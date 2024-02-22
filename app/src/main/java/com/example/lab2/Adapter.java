package com.example.lab2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    final ArrayList<Contact> listContact;
    Adapter(ArrayList<Contact>listContact){
        this.listContact = listContact;
    }
    @Override
    public int getCount(){
        return listContact.size();
    }
    @Override
    public Object getItem(int position){
        return listContact.get(position);
    }
    @Override
    public long getItemId(int position){
        return listContact.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View viewContact = convertView;
        if (viewContact == null) {
            viewContact = View.inflate(parent.getContext(), R.layout.contact_layout, null);
        }

        final Contact contact = listContact.get(position);
        TextView textViewName = viewContact.findViewById(R.id.txtHoten);
        TextView textViewPhoneNumber = viewContact.findViewById(R.id.txtSDT);
        CheckBox checkBoxStatus = viewContact.findViewById(R.id.checkBox1);

        textViewName.setText(contact.getName());
        textViewPhoneNumber.setText(contact.getPhoneNumber());
        checkBoxStatus.setChecked(contact.isStatus());

        checkBoxStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                contact.setStatus(isChecked);
            }
        });

        return viewContact;
    }
}
