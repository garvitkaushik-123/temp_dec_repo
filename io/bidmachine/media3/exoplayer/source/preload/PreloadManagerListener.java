package io.bidmachine.media3.exoplayer.source.preload;

import io.bidmachine.media3.common.MediaItem;

/* loaded from: classes7.dex */
public interface PreloadManagerListener {
    default void onCompleted(MediaItem mediaItem) {
    }

    default void onError(PreloadException preloadException) {
    }
}
