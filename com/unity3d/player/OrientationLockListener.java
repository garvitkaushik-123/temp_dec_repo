package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* loaded from: classes7.dex */
public class OrientationLockListener {

    /* renamed from: a, reason: collision with root package name */
    public com.unity3d.player.a.M f6485a;
    public final Context b;

    public final native void nativeUpdateOrientationLockState(int i);

    public OrientationLockListener(Context context) {
        this.b = context;
        this.f6485a = new com.unity3d.player.a.M(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        com.unity3d.player.a.M m = this.f6485a;
        m.getClass();
        m.b = new com.unity3d.player.a.L(new Handler(Looper.getMainLooper()), this);
        m.f6519a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, m.b);
    }
}
