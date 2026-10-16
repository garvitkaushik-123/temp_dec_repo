package io.bidmachine.media3.exoplayer.offline;

import java.io.IOException;

/* loaded from: classes7.dex */
public interface DownloadIndex {
    Download getDownload(String str) throws IOException;

    DownloadCursor getDownloads(int... iArr) throws IOException;
}
