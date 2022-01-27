package com.example.recyclerviewfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewfragment.fragments.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewFragment.RecyclerListener {


    private RecyclerViewFragment recyclerViewFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        myFragment = new MyFragment();
        recyclerViewFragment = new RecyclerViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.myFragment, myFragment).replace(R.id.myRecyclerViewFragment, recyclerViewFragment).commit();

    }


    @Override
    public void recyclerListener(Contact contact) {
        myFragment.updateMyFragment(contact);
    }
}