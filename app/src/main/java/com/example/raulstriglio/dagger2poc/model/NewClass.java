package com.example.raulstriglio.dagger2poc.model;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by raul.striglio on 09/11/17.
 */

public class NewClass {

    String s;

    @Inject
    public NewClass(String s) {
        this.s = s;
    }

    public String getMessage() {
        return s;
    }

    public void setMessage(String message) {
        this.s = message;
    }
}
