package com.example.raulstriglio.dagger2poc;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.raulstriglio.dagger2poc.component.DaggerMainActivityComponent;
import com.example.raulstriglio.dagger2poc.component.DaggerSubFragmentComponent;
import com.example.raulstriglio.dagger2poc.component.MainActivityComponent;
import com.example.raulstriglio.dagger2poc.component.SubFragmentComponent;
import com.example.raulstriglio.dagger2poc.fragments.SubFragment;
import com.example.raulstriglio.dagger2poc.model.NewClass;
import com.example.raulstriglio.dagger2poc.module.MainActivityModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named("fomartString")
    NewClass newClass;

    @Inject
    SubFragment subFragment;

    private MainActivityComponent mainActivityComponent;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule())
                .build();

        mainActivityComponent.inject(this);
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        goToFragmentWithStack(R.id.fragment_container, subFragment, "subFragment");
    }


    public void goToFragmentWithStack(int fragmentContainer, Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentContainer, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, newClass.getMessage(), Toast.LENGTH_SHORT).show();

    }

    public MainActivityComponent getMainActivityComponent(){
        return mainActivityComponent;
    }

}