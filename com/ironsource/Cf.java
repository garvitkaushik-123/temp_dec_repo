package com.ironsource;

/* loaded from: classes6.dex */
public interface Cf {
    static /* synthetic */ void a(Cf cf, Runnable runnable, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postReleaseTask");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        cf.a(runnable, j);
    }

    void a(Runnable runnable);

    void a(Runnable runnable, long j);
}
