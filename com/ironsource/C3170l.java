package com.ironsource;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* renamed from: com.ironsource.l, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3170l implements cg {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f3413a;

    public C3170l(Activity activity) {
        this.f3413a = new WeakReference<>(activity);
    }

    @Override // com.ironsource.cg
    public void a() {
        Activity activity = this.f3413a.get();
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }
}
