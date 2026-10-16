package io.bidmachine.rendering.measurer;

import android.view.View;

/* loaded from: classes8.dex */
public interface VideoMeasurer extends Measurer<View> {
    void onMediaCompleted();

    void onMediaFirstQuartile();

    void onMediaMidpoint();

    void onMediaPaused();

    void onMediaResumed();

    void onMediaSkipped();

    void onMediaStarted(float durationMs, float volume);

    void onMediaThirdQuartile();

    void onMediaVolumeChanged(float volume);
}
