package io.bidmachine.media3.exoplayer.offline;

import java.io.IOException;

/* loaded from: classes7.dex */
public interface Downloader {

    public interface ProgressListener {
        void onProgress(long j, long j2, float f);
    }

    void cancel();

    void download(ProgressListener progressListener) throws IOException, InterruptedException;

    void remove();
}
