package com.example.raulstriglio.dagger2poc.module;

import com.example.raulstriglio.dagger2poc.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by raul.striglio on 24/11/17.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, SubFragmentProvider.class})
    abstract MainActivity bindMainActivity();

}