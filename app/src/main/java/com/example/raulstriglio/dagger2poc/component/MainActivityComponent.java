package com.example.raulstriglio.dagger2poc.component;

import com.example.raulstriglio.dagger2poc.MainActivity;
import com.example.raulstriglio.dagger2poc.model.AppModule;
import com.example.raulstriglio.dagger2poc.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raul.striglio on 10/11/17.
 */

@Singleton
@Component(modules = {MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
