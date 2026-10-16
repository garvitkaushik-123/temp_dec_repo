package io.bidmachine.media3.exoplayer.source;

import io.bidmachine.media3.exoplayer.LoadingInfo;

/* loaded from: classes7.dex */
public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t);
    }

    boolean continueLoading(LoadingInfo loadingInfo);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j);
}
