package io.bidmachine.media3.exoplayer.offline;

import io.bidmachine.media3.exoplayer.offline.DownloadManager;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes7.dex */
public final /* synthetic */ class DownloadManager$InternalHandler$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareStartTimes;
        compareStartTimes = DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
        return compareStartTimes;
    }
}
