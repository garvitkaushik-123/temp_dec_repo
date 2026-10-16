package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* renamed from: com.unity3d.player.j, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3528j extends CameraCaptureSession.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3538o f6561a;

    public C3528j(C3538o c3538o) {
        this.f6561a = c3538o;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        C3538o c3538o = this.f6561a;
        if (c3538o.b == null) {
            return;
        }
        synchronized (c3538o.t) {
            C3538o c3538o2 = this.f6561a;
            c3538o2.r = cameraCaptureSession;
            try {
                c3538o2.q = c3538o2.b.createCaptureRequest(1);
                C3538o c3538o3 = this.f6561a;
                c3538o3.q.addTarget(c3538o3.w);
                C3538o c3538o4 = this.f6561a;
                c3538o4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c3538o4.n);
                this.f6561a.e();
            } catch (CameraAccessException e) {
                com.unity3d.player.a.t.Log(6, "Camera2: CameraAccessException " + e);
            } catch (IllegalStateException e2) {
                com.unity3d.player.a.t.Log(6, "Camera2: IllegalStateException " + e2);
            }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.f6561a.A = 3;
        com.unity3d.player.a.t.Log(6, "Camera2: CaptureSession configuration failed.");
    }
}
