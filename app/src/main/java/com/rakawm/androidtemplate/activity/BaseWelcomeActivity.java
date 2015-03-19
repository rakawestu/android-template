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

package com.rakawm.androidtemplate.activity;

import android.os.Bundle;

import com.rakawm.androidtemplate.BaseActivity;

/**
 * Default activity class for authentication required.
 */
public class BaseWelcomeActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (!isAuthValid()) {
            onAuthError();
            finish();
        }
    }

    private boolean isAuthValid(){
        //Implement authentication checking here
        return true;
    }

    protected void onAuthError() {
        // Implement redirect to login
        // - clear user session
        // - open register/login screen
    }
}
