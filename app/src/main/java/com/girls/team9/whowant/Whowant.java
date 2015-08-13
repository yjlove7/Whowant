package com.girls.team9.whowant;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by hyemi on 2015-08-14.
 */
public class Whowant extends Application {

    String APPLICATION_ID ="L2yes9VmFrSxAwKDU942H4CUPyJCvAdV8uwdw6nN";
    String CLIENT_KEY = "QT3lxiZv63TzWK47RPeh4uTFm3T42hIx8APbvrvU";


    @Override
    public void onCreate() {
        super.onCreate();



        Parse.enableLocalDatastore(this);

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParseACL defaultACL=new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}//class
