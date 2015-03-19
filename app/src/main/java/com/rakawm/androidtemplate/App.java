/*
 * Copyright (C) 2015 Rakawm.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rakawm.androidtemplate;

import android.app.Application;
import android.content.res.Resources;

import com.rakawm.androidtemplate.inject.module.ApplicationModule;
import com.rakawm.androidtemplate.inject.module.PrefsModule;
import com.rakawm.androidtemplate.session.SessionPrefs;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import timber.log.Timber;

/**
 * Base Application class.
 */
public class App extends Application {
    private static App context;
    private ObjectGraph mObjectGraph;
    private static SessionPrefs sSessionPrefs;
    @Inject
    SessionPrefs mSessionPrefs;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Timber.d("Application is started.");
        JodaTimeAndroid.init(this);

        //Injections
        mObjectGraph = ObjectGraph.create(getModules().toArray());
        mObjectGraph.inject(this);

        //Enable Logging using Timber.
        Timber.plant(BuildConfig.DEBUG ? new Timber.DebugTree() : new Timber.HollowTree() {
            @Override
            public void e(String message, Object... args) {
                super.e(message, args);
            }

            @Override
            public void e(Throwable t, String message, Object... args) {
                super.e(t, message, args);
            }
        });

        //Initialize static variable
        sSessionPrefs = mSessionPrefs;
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new ApplicationModule(this),
                new PrefsModule()
        );
    }

    public static void logout() {
        sSessionPrefs.logout(context);
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return mObjectGraph.plus(modules);
    }

    public static App getContext() {
        return context;
    }

    public static Resources getRes() {
        return context.getResources();
    }
}
