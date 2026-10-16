package com.unity3d.player;

import android.graphics.SurfaceTexture;

/* renamed from: com.unity3d.player.m, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3534m implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3538o f6567a;

    public C3534m(C3538o c3538o) {
        this.f6567a = c3538o;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ((Camera2Wrapper) this.f6567a.f6569a).a(surfaceTexture);
    }
}
