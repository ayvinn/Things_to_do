package com.example.freewaresys.thingsto_do;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class inboxFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //TextView tb = getActivity().findViewById(R.id.toolbar);
        getActivity().setTitle("INBOX");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.drawable.ic_menu_inbox);
        //DrawableCompat.setTint(R.id.);


        return inflater.inflate(R.layout.fragment_inbox, container, false);
    }
}
