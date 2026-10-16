package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmType;", "type", "", "threshold", "weight", "<init>", "(Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmType;FF)V", "a", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmType;", "getType", "()Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "F", "getThreshold", "()F", "c", "getWeight", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class BrokenCreativeAlgorithmParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BrokenCreativeAlgorithmType type;

    /* renamed from: b, reason: from kotlin metadata */
    private final float threshold;

    /* renamed from: c, reason: from kotlin metadata */
    private final float weight;

    public BrokenCreativeAlgorithmParams(BrokenCreativeAlgorithmType type, float f, float f2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.threshold = f;
        this.weight = f2;
    }

    public final float getThreshold() {
        return this.threshold;
    }

    public final BrokenCreativeAlgorithmType getType() {
        return this.type;
    }

    public final float getWeight() {
        return this.weight;
    }
}
