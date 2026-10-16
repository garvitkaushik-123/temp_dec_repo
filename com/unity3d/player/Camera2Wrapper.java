package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraManager;
import android.view.Surface;
import com.unity3d.player.a.C3506n;
import com.unity3d.player.a.InterfaceC3509q;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class Camera2Wrapper implements InterfaceC3509q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6467a;
    public C3538o b = null;

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    public Camera2Wrapper(Context context) {
        this.f6467a = context;
        initCamera2Jni();
    }

    public int getCamera2Count() {
        return C3538o.getCameraIds(this.f6467a).length;
    }

    public int getCamera2SensorOrientation(int i) {
        return C3538o.c(this.f6467a, i);
    }

    public boolean isCamera2FrontFacing(int i) {
        return C3538o.e(this.f6467a, i);
    }

    public int getCamera2FocalLengthEquivalent(int i) {
        return C3538o.a(this.f6467a, i);
    }

    public int[] getCamera2Resolutions(int i) {
        return C3538o.b(this.f6467a, i);
    }

    public boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        C3538o c3538o;
        if (this.b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        CameraManager cameraManager = C3538o.B;
        if (PlatformSupport.QUINCE_TART_SUPPORT) {
            c3538o = new C3506n(this);
        } else {
            c3538o = new C3538o(this);
        }
        C3538o c3538o2 = c3538o;
        this.b = c3538o2;
        return c3538o2.a(this.f6467a, i, i2, i3, i4, i5, surface);
    }

    public boolean isCamera2AutoFocusPointSupported(int i) {
        return C3538o.d(this.f6467a, i);
    }

    public boolean setAutoFocusPoint(float f, float f2) {
        C3538o c3538o = this.b;
        if (c3538o != null && c3538o.h > 0) {
            if (!c3538o.m) {
                c3538o.i = f;
                c3538o.j = f2;
                synchronized (c3538o.t) {
                    if (c3538o.r != null && c3538o.A != 2) {
                        c3538o.d();
                    }
                }
                return true;
            }
            com.unity3d.player.a.t.Log(5, "Camera2: Setting manual focus point already started.");
        }
        return false;
    }

    public Rect getFrameSizeCamera2() {
        C3538o c3538o = this.b;
        if (c3538o == null) {
            return new Rect();
        }
        return c3538o.e;
    }

    public void closeCamera2() {
        C3538o c3538o = this.b;
        if (c3538o != null) {
            c3538o.a();
        }
        this.b = null;
    }

    public void startCamera2() {
        C3538o c3538o = this.b;
        if (c3538o != null) {
            c3538o.f();
        }
    }

    public void pauseCamera2() {
        C3538o c3538o = this.b;
        if (c3538o != null) {
            c3538o.c();
        }
    }

    public void stopCamera2() {
        C3538o c3538o = this.b;
        if (c3538o != null) {
            c3538o.g();
        }
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }
}
