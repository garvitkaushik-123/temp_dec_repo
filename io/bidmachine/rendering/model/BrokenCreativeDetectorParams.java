package io.bidmachine.rendering.model;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0007\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\b\u0010\u001bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/bidmachine/rendering/model/BrokenCreativeDetectorParams;", "", "", "timeout", "", "downscaleFactor", "", "isErrorOnly", "isAllowDuplicate", "Lio/bidmachine/rendering/model/StopDetectorAfter;", "stopAfter", "weightThreshold", "", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithms", "<init>", "(JDZZLio/bidmachine/rendering/model/StopDetectorAfter;DLjava/util/List;)V", "a", "J", "getTimeout", "()J", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "D", "getDownscaleFactor", "()D", "c", "Z", "()Z", "d", "e", "Lio/bidmachine/rendering/model/StopDetectorAfter;", "getStopAfter", "()Lio/bidmachine/rendering/model/StopDetectorAfter;", InneractiveMediationDefs.GENDER_FEMALE, "getWeightThreshold", "g", "Ljava/util/List;", "getAlgorithms", "()Ljava/util/List;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class BrokenCreativeDetectorParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long timeout;

    /* renamed from: b, reason: from kotlin metadata */
    private final double downscaleFactor;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isErrorOnly;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean isAllowDuplicate;

    /* renamed from: e, reason: from kotlin metadata */
    private final StopDetectorAfter stopAfter;

    /* renamed from: f, reason: from kotlin metadata */
    private final double weightThreshold;

    /* renamed from: g, reason: from kotlin metadata */
    private final List<BrokenCreativeAlgorithmParams> algorithms;

    public BrokenCreativeDetectorParams(long j, double d, boolean z, boolean z2, StopDetectorAfter stopAfter, double d2, List<BrokenCreativeAlgorithmParams> algorithms) {
        Intrinsics.checkNotNullParameter(stopAfter, "stopAfter");
        Intrinsics.checkNotNullParameter(algorithms, "algorithms");
        this.timeout = j;
        this.downscaleFactor = d;
        this.isErrorOnly = z;
        this.isAllowDuplicate = z2;
        this.stopAfter = stopAfter;
        this.weightThreshold = d2;
        this.algorithms = algorithms;
    }

    public final List<BrokenCreativeAlgorithmParams> getAlgorithms() {
        return this.algorithms;
    }

    public final double getDownscaleFactor() {
        return this.downscaleFactor;
    }

    public final StopDetectorAfter getStopAfter() {
        return this.stopAfter;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final double getWeightThreshold() {
        return this.weightThreshold;
    }

    /* renamed from: isAllowDuplicate, reason: from getter */
    public final boolean getIsAllowDuplicate() {
        return this.isAllowDuplicate;
    }

    /* renamed from: isErrorOnly, reason: from getter */
    public final boolean getIsErrorOnly() {
        return this.isErrorOnly;
    }
}
