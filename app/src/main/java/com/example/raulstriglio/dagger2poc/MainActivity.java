package com.example.raulstriglio.dagger2poc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raulstriglio.dagger2poc.fragments.OtherFragment;
import com.example.raulstriglio.dagger2poc.fragments.SubFragment;
import com.example.raulstriglio.dagger2poc.model.NewClass;

import java.sql.Time;
import java.util.Timer;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    @Named("fomartString")
    NewClass newClass;

    @Inject
    SubFragment subFragment;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    TextView clickeable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

        setContentView(R.layout.activity_main);

        clickeable = (TextView) findViewById(R.id.clickeable);

        clickeable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFragmentWithStack(
                        R.id.fragment_container, OtherFragment.newInstance(), "otherFragment"
                );
            }
        });

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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}