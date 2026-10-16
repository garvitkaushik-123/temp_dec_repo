package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes7.dex */
public final class V implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ X f6499a;

    public V(X x) {
        this.f6499a = x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c2, code lost:
    
        if (r6.f6499a.e != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f9, code lost:
    
        if (r6.f6499a.e == false) goto L67;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        if (message.what != 2269) {
            return false;
        }
        W w = (W) message.obj;
        W w2 = W.h;
        if (w == w2) {
            X x = this.f6499a;
            x.g--;
            x.f6503a.executeMainThreadJobs();
            X x2 = this.f6499a;
            if (!x2.d) {
                return true;
            }
            if (x2.f6503a.getHaveAndroidWindowSupport() && !this.f6499a.e) {
                return true;
            }
            X x3 = this.f6499a;
            int i = x3.j;
            if (i >= 0) {
                if (i == 0) {
                    if (x3.f6503a.getSplashEnabled()) {
                        this.f6499a.f6503a.disableStaticSplashScreen();
                    }
                    if (this.f6499a.f6503a.shouldReportFullyDrawn()) {
                        this.f6499a.f6503a.reportFullyDrawn();
                    }
                }
                this.f6499a.j--;
            }
            if (!this.f6499a.f6503a.isFinishing() && !this.f6499a.f6503a.nativeRender()) {
                this.f6499a.f6503a.finish();
            }
        } else if (w == W.c) {
            Looper.myLooper().quit();
        } else if (w == W.b) {
            this.f6499a.d = true;
        } else if (w == W.f6501a) {
            this.f6499a.d = false;
        } else if (w == W.d) {
            this.f6499a.e = false;
        } else if (w == W.e) {
            X x4 = this.f6499a;
            x4.e = true;
            if (x4.f == 3) {
                if (x4.f6503a.getHaveAndroidWindowSupport()) {
                }
                this.f6499a.f6503a.nativeFocusChanged(true);
                this.f6499a.f = 1;
            }
        } else if (w == W.f) {
            X x5 = this.f6499a;
            if (x5.f == 1) {
                x5.f6503a.nativeFocusChanged(false);
            }
            this.f6499a.f = 2;
        } else if (w == W.g) {
            X x6 = this.f6499a;
            x6.f = 3;
            if (x6.f6503a.getHaveAndroidWindowSupport()) {
            }
            this.f6499a.f6503a.nativeFocusChanged(true);
            this.f6499a.f = 1;
        } else if (w == W.i) {
            X x7 = this.f6499a;
            x7.f6503a.nativeOrientationChanged(x7.h, x7.i);
        }
        X x8 = this.f6499a;
        if (x8.d && x8.g <= 0) {
            Message.obtain(x8.c, 2269, w2).sendToTarget();
            this.f6499a.g++;
        }
        return true;
    }
}
