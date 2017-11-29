package com.example.raulstriglio.dagger2poc.module;

import com.example.raulstriglio.dagger2poc.model.NewClass;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 23/11/17.
 */

@Module
public class SubFragmentModule {

    @Provides
    @Named("fomartString2")
    public NewClass formatString2(){
        return new NewClass("Fragment String");
    }

}
