package com.unity3d.player.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public final class B extends View {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f6510a;
    public final /* synthetic */ C b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C c, Context context) {
        super(context);
        this.b = c;
    }

    public final void a(SurfaceView surfaceView) {
        this.f6510a = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("PlaceHolderView");
        handlerThread.start();
        Semaphore semaphore = new Semaphore(0);
        PixelCopy.request(surfaceView, this.f6510a, new A(this, semaphore), new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(2000L, TimeUnit.MILLISECONDS)) {
                t.Log(5, "Timeout while copying surface view.");
            }
        } catch (InterruptedException e) {
            t.Log(6, e.getMessage());
        }
        handlerThread.quitSafely();
    }
}
