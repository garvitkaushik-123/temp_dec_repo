package com.unity3d.player;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes7.dex */
public final class C0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f6466a;

    public C0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6466a = unityPlayerForActivityOrService;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f6466a.invokeOnMainThread((Runnable) new C3541p0(this, windowInsets));
        return windowInsets;
    }
}
