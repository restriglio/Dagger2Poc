package com.example.raulstriglio.dagger2poc.module;

import com.example.raulstriglio.dagger2poc.fragments.SubFragment;
import com.example.raulstriglio.dagger2poc.model.NewClass;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 09/11/17.
 */

@Module
public class MainActivityModule {

    @Provides
    @Named("fomartString")
    public NewClass formatString(){
        return new NewClass("Activity String");
    }

    @Provides
    public SubFragment getFragment(){
        return SubFragment.newInstance();
    }
}
