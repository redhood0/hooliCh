package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.TransCoding;

import androidx.fragment.app.Fragment;

public class DynamicFragment extends Fragment {
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        tv = view.findViewById(R.id.tv);

        return view;
    }
}
