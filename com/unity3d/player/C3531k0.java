package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;

/* renamed from: com.unity3d.player.k0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3531k0 extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6564a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3531k0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.f6564a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        UnityPlayer unityPlayer = this.f6564a;
        unityPlayer.onOrientationChanged(unityPlayer.mNaturalOrientation, i);
    }
}
