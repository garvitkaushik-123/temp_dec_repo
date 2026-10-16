package com.ironsource;

import android.app.Activity;
import android.content.MutableContextWrapper;

/* renamed from: com.ironsource.g4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3091g4 {

    /* renamed from: a, reason: collision with root package name */
    MutableContextWrapper f3312a;

    public synchronized void a(Activity activity) {
        if (this.f3312a == null) {
            this.f3312a = new MutableContextWrapper(activity);
        }
        this.f3312a.setBaseContext(activity);
    }

    public synchronized void b() {
        this.f3312a = null;
    }

    public Activity a() {
        return (Activity) this.f3312a.getBaseContext();
    }
}
