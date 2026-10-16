package io.bidmachine.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import io.bidmachine.media3.common.util.Clock;

/* loaded from: classes7.dex */
public interface SuitableOutputChecker {

    public interface Callback {
        void onSelectedOutputSuitabilityChanged(boolean z);
    }

    void disable();

    void enable(Callback callback, Context context, Looper looper, Looper looper2, Clock clock);

    boolean isSelectedOutputSuitableForPlayback();
}
