package com.mihir1012.fictonarydictonary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mihir1012.fictonarydictonary.R;
import com.mihir1012.fictonarydictonary.WordMeaningActivity;

public class FragmentExample extends Fragment {

    public FragmentExample() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_defination,container ,false);//Inflate Layout

        Context context=getActivity();
        TextView text = (TextView) view.findViewById(R.id.textView);

        String example= ((WordMeaningActivity)context).example;

        text.setText(example);
        if(example==null)
        {
            text.setText("No Example found");
        }

        return view;

    }
}
