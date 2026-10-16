package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/model/Border;", "", "", "strokeWidthPx", "strokeColor", "<init>", "(II)V", "a", "I", "getStrokeWidthPx", "()I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getStrokeColor", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class Border {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int strokeWidthPx;

    /* renamed from: b, reason: from kotlin metadata */
    private final int strokeColor;

    public Border(int i, int i2) {
        this.strokeWidthPx = i;
        this.strokeColor = i2;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeWidthPx() {
        return this.strokeWidthPx;
    }
}
