package com.example.recyclerviewfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewfragment.fragments.MyFragment;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    RecyclerListener recyclerListener;
    private ArrayList<Contact> contactList;
    public ContactAdapter.OnClickListener onClickListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        initViews(container.getContext(), view);
        return view;
    }

    private void initViews(Context context, View view) {

        contactList = createList();
        onClickListener = position -> recyclerListener.recyclerListener(contactList.get(position));
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        ContactAdapter contactAdapter = new ContactAdapter(contactList, onClickListener);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        recyclerView.setAdapter(contactAdapter);

    }

    private ArrayList<Contact> createList() {
        ArrayList<Contact> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list.add(new Contact("Jamshid", "+998932006746"));
            list.add(new Contact("Otabek", "+998974291916"));
            list.add(new Contact("Nodirbek", "+998946163209"));
            list.add(new Contact("Asadbek", "+998949099664"));
            list.add(new Contact("G'ayrat", "+998932020305"));
        }
        return list;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof RecyclerListener) {
            recyclerListener = (RecyclerListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement RecyclerListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        recyclerListener = null;
    }

    interface RecyclerListener {
        void recyclerListener(Contact contact);
    }
}