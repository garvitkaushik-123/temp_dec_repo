package io.bidmachine.rendering.internal;

import io.bidmachine.util.SafeRunnable;

/* loaded from: classes8.dex */
public interface n extends SafeRunnable {
    @Override // io.bidmachine.util.SafeRunnable
    default void onThrows(Throwable throwable) {
        o.b(throwable);
    }
}
