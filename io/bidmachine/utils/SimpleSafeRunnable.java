package io.bidmachine.utils;

/* loaded from: classes8.dex */
public interface SimpleSafeRunnable extends SafeRunnable {
    @Override // io.bidmachine.utils.SafeRunnable
    default void onThrows(Throwable throwable) throws Throwable {
    }
}
