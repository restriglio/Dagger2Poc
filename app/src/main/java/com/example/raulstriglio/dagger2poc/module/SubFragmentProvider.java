package com.example.raulstriglio.dagger2poc.module;

import com.example.raulstriglio.dagger2poc.fragments.SubFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public abstract class SubFragmentProvider {


    @ContributesAndroidInjector(modules = SubFragmentModule.class)
    abstract SubFragment provideSubFragmentFactory();

}
