/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.huskykoglhof.sbrick_configurator_debug;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.apache.cordova.CordovaPlugin;

import com.judax.cordova.plugin.gamepad.CordovaPluginGamepad;

import org.apache.cordova.*;

public class MainActivity extends CordovaActivity
{
    @Override
    public boolean dispatchGenericMotionEvent (MotionEvent ev) {
        System.out.println("dispatchGenericMotionEvent called");
        return super.dispatchGenericMotionEvent(ev);

    }

    @Override
    public boolean dispatchKeyEvent (KeyEvent event) {
        PluginManager pm = super.appView.getPluginManager();
        CordovaPluginGamepad myPlugin = (CordovaPluginGamepad)pm.getPlugin("Gamepad");
        if (!myPlugin.useEventKey(event)) {
            return super.dispatchKeyEvent(event);
        } else {
            return false;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }
}
