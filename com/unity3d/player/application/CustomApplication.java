package com.unity3d.player.application;

import androidx.multidex.MultiDexApplication;
import io.voodoo.tools.LifecycleHandler;

/* loaded from: classes7.dex */
public class CustomApplication extends MultiDexApplication {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new LifecycleHandler());
    }
}
