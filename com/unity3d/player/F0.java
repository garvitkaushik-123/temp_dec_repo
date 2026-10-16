package com.unity3d.player;

import android.content.res.Configuration;

/* loaded from: classes7.dex */
public final class F0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Configuration f6471a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public F0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Configuration configuration) {
        this.b = unityPlayerForActivityOrService;
        this.f6471a = configuration;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.nativeConfigurationChanged(this.f6471a);
    }
}
