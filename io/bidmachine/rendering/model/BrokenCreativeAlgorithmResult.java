package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0003\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmResult;", "", "", "isBroken", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithmParams", "", "durationMs", "<init>", "(ZLio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;J)V", "a", "Z", "()Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "getAlgorithmParams", "()Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "c", "J", "getDurationMs", "()J", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class BrokenCreativeAlgorithmResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isBroken;

    /* renamed from: b, reason: from kotlin metadata */
    private final BrokenCreativeAlgorithmParams algorithmParams;

    /* renamed from: c, reason: from kotlin metadata */
    private final long durationMs;

    public BrokenCreativeAlgorithmResult(boolean z, BrokenCreativeAlgorithmParams algorithmParams, long j) {
        Intrinsics.checkNotNullParameter(algorithmParams, "algorithmParams");
        this.isBroken = z;
        this.algorithmParams = algorithmParams;
        this.durationMs = j;
    }

    public final BrokenCreativeAlgorithmParams getAlgorithmParams() {
        return this.algorithmParams;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: isBroken, reason: from getter */
    public final boolean getIsBroken() {
        return this.isBroken;
    }
}
