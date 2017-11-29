package com.example.raulstriglio.dagger2poc.module;


import android.content.Context;
import com.example.raulstriglio.dagger2poc.MyApplication;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by raul.striglio on 10/11/17.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(MyApplication application) {
        return application;
    }


}
