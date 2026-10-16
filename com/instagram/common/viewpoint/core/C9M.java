package com.instagram.common.viewpoint.core;

import android.os.SystemClock;
import java.lang.Exception;

/* renamed from: com.facebook.ads.redexgen.X.9M, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C9M<T extends Exception> {
    public long A00;
    public T A01;
    public final long A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9M != com.facebook.ads.androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<T extends java.lang.Exception> */
    public C9M(long j) {
        this.A02 = j;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9M != com.facebook.ads.androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<T extends java.lang.Exception> */
    public final void A00() {
        this.A01 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9M != com.facebook.ads.androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<T extends java.lang.Exception> */
    public final void A01(T exception) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.A01 == null) {
            this.A01 = exception;
            long nowMs = this.A02;
            this.A00 = nowMs + elapsedRealtime;
        }
        if (elapsedRealtime >= this.A00) {
            if (this.A01 != exception) {
                this.A01.addSuppressed(exception);
            }
            T t = this.A01;
            A00();
            throw t;
        }
    }
}
