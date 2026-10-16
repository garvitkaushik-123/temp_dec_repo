package com.unity3d.player;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.unity3d.player.k, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3530k extends CameraDevice.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3538o f6563a;

    public C3530k(C3538o c3538o) {
        this.f6563a = c3538o;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f6563a.b = cameraDevice;
        C3538o.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        C3538o.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        com.unity3d.player.a.t.Log(5, "Camera2: CameraDevice disconnected.");
        this.f6563a.a(cameraDevice);
        C3538o.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        com.unity3d.player.a.t.Log(6, "Camera2: Error opening CameraDevice " + i);
        this.f6563a.a(cameraDevice);
        C3538o.D.release();
    }
}
