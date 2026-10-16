package com.unity3d.player.a;

import android.app.Activity;
import android.content.Context;
import android.view.PixelCopy;
import java.util.concurrent.Semaphore;

/* loaded from: classes7.dex */
public final class A implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f6509a;
    public final /* synthetic */ B b;

    public A(B b, Semaphore semaphore) {
        this.b = b;
        this.f6509a = semaphore;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        this.f6509a.release();
        if (i == 0) {
            Context context = this.b.b.f6511a;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new z(this));
            }
        }
    }
}
