package io.bidmachine.analytics;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\n\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/bidmachine/analytics/MonitorConfig;", "", "", "name", "url", "", "batchSize", "", "interval", "", "isReportEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJZ)V", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getUrl", "c", "I", "getBatchSize", "()I", "d", "J", "getInterval", "()J", "e", "Z", "()Z", "bidmachine-android-sdk_bg_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class MonitorConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* renamed from: b, reason: from kotlin metadata */
    private final String url;

    /* renamed from: c, reason: from kotlin metadata */
    private final int batchSize;

    /* renamed from: d, reason: from kotlin metadata */
    private final long interval;

    /* renamed from: e, reason: from kotlin metadata */
    private final boolean isReportEnabled;

    public MonitorConfig(String str, String str2, int i, long j, boolean z) {
        this.name = str;
        this.url = str2;
        this.batchSize = i;
        this.interval = j;
        this.isReportEnabled = z;
    }

    public final int getBatchSize() {
        return this.batchSize;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    /* renamed from: isReportEnabled, reason: from getter */
    public final boolean getIsReportEnabled() {
        return this.isReportEnabled;
    }
}
