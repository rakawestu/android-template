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

package com.rakawm.androidtemplate.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Base session handling class.
 */
public class SessionPrefs {
    /* Instances */
    private static SessionPrefs instance;
    private SharedPreferences mPrefs;

    /**
     * Default Constructor.
     * @param prefs
     */
    public SessionPrefs(SharedPreferences prefs) {
        mPrefs = prefs;
    }

    /**
     *
     * @param prefs    SharedPeferences
     * @return  instance of SessionPrefs class
     */
    public static SessionPrefs getInstance(SharedPreferences prefs) {
        if (instance == null) {
            instance = new SessionPrefs(prefs);
        }
        return instance;
    }

    /**
     * Check if user has logged in to apps
     * @return boolean
     */
    public boolean isLoggedIn(){
        //define logged in condition
        return false;
    }

    /**
     * Clear Preferences to logout
     * @param context    context
     */
    public void logout(Context context){
        mPrefs.edit().clear().apply();
    }


}
