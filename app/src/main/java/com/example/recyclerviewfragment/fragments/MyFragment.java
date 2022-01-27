package com.example.recyclerviewfragment.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewfragment.Contact;
import com.example.recyclerviewfragment.R;


public class MyFragment extends Fragment {
    TextView name;
    TextView number;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        name = v.findViewById(R.id.name);
        number = v.findViewById(R.id.number);
        return v;
    }

    public void updateMyFragment(Contact contact) {
        name.setText(contact.getName());
        number.setText(contact.getNumber());
    }




}