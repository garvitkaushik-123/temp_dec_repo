package io.bidmachine.rendering.internal;

import io.bidmachine.util.SafeExecutable;

/* loaded from: classes8.dex */
public interface m<T> extends SafeExecutable<T> {
    @Override // io.bidmachine.util.SafeExecutable
    default void onThrows(Throwable throwable) {
        o.b(throwable);
    }
}
