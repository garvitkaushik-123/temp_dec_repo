package com.bykv.vk.openvk.eli.eli.eli.MGA;

import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class MGA implements SurfaceHolder.Callback {
    private final WeakReference<SurfaceHolder.Callback> eli;

    public MGA(SurfaceHolder.Callback callback) {
        this.eli = new WeakReference<>(callback);
    }

    public SurfaceHolder.Callback eli() {
        return this.eli.get();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.eli.get();
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        SurfaceHolder.Callback callback = this.eli.get();
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.eli.get();
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }
}
