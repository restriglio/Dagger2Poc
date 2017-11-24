package com.example.raulstriglio.dagger2poc.component;

import com.example.raulstriglio.dagger2poc.MainActivity;
import com.example.raulstriglio.dagger2poc.fragments.SubFragment;
import com.example.raulstriglio.dagger2poc.module.SubFragmentModule;
import com.example.raulstriglio.dagger2poc.scopes.SubFragmentScope;

import dagger.Component;

/**
 * Created by raul.striglio on 23/11/17.
 */

@SubFragmentScope
@Component(dependencies = MainActivityComponent.class, modules = SubFragmentModule.class)
public interface SubFragmentComponent {

    void inject(SubFragment subFragment);
}
