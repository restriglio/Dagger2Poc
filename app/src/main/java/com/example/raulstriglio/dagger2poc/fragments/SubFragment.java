package com.example.raulstriglio.dagger2poc.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.raulstriglio.dagger2poc.MainActivity;
import com.example.raulstriglio.dagger2poc.R;
import com.example.raulstriglio.dagger2poc.component.DaggerSubFragmentComponent;
import com.example.raulstriglio.dagger2poc.model.NewClass;
import com.example.raulstriglio.dagger2poc.module.SubFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by raul.striglio on 23/11/17.
 */

public class SubFragment extends Fragment {

    @Inject
    @Named("fomartString2")
    NewClass newClass2;

    public static SubFragment newInstance() {

        Bundle args = new Bundle();

        SubFragment fragment = new SubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DaggerSubFragmentComponent.builder().mainActivityComponent(((MainActivity) getActivity()).getMainActivityComponent())
                .subFragmentModule(new SubFragmentModule())
                .build().inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.sub_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getContext(), newClass2.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
