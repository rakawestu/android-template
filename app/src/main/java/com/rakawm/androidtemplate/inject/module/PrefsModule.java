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

package com.rakawm.androidtemplate.inject.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.rakawm.androidtemplate.inject.ForApplication;
import com.rakawm.androidtemplate.session.SessionPrefs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Prefs Module for injection use.
 */
@Module(library = true, complete = false)
public class PrefsModule {
    private static final String PREFS_NAME_SESSION = "session";

    @Provides
    @Singleton
    SessionPrefs provideSessionPrefs(@ForApplication Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME_SESSION, Context.MODE_PRIVATE);
        return SessionPrefs.getInstance(prefs);
    }
}
