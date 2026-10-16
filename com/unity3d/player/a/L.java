package com.unity3d.player.a;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.player.OrientationLockListener;

/* loaded from: classes7.dex */
public final class L extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final OrientationLockListener f6518a;

    public L(Handler handler, OrientationLockListener orientationLockListener) {
        super(handler);
        this.f6518a = orientationLockListener;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        OrientationLockListener orientationLockListener = this.f6518a;
        if (orientationLockListener != null) {
            orientationLockListener.nativeUpdateOrientationLockState(Settings.System.getInt(orientationLockListener.b.getContentResolver(), "accelerometer_rotation", 0));
        }
    }
}
