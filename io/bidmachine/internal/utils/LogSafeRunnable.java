package io.bidmachine.internal.utils;

import io.bidmachine.core.Logger;
import io.bidmachine.utils.SafeRunnable;

/* loaded from: classes7.dex */
public interface LogSafeRunnable extends SafeRunnable {
    @Override // io.bidmachine.utils.SafeRunnable
    default void onThrows(Throwable throwable) throws Throwable {
        Logger.w(throwable);
    }
}
