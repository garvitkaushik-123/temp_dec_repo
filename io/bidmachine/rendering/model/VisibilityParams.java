package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0011B%\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0012"}, d2 = {"Lio/bidmachine/rendering/model/VisibilityParams;", "", "", "visibilityPercent", "", "isIgnoreWindowFocus", "isIgnoreOverlap", "<init>", "(FZZ)V", "a", "F", "getVisibilityPercent", "()F", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "()Z", "c", "Builder", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class VisibilityParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float visibilityPercent;

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean isIgnoreWindowFocus;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isIgnoreOverlap;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0003R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/bidmachine/rendering/model/VisibilityParams$Builder;", "", "<init>", "()V", "", "visibilityPercent", "setVisibilityPercent", "(F)Lio/bidmachine/rendering/model/VisibilityParams$Builder;", "", "isIgnoreWindowFocus", "setIgnoreWindowFocus", "(Z)Lio/bidmachine/rendering/model/VisibilityParams$Builder;", "isIgnoreOverlap", "setIgnoreOverlap", "Lio/bidmachine/rendering/model/VisibilityParams;", "build", "()Lio/bidmachine/rendering/model/VisibilityParams;", "a", "F", "getVisibilityPercent$annotations", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "c", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float visibilityPercent = 0.5f;

        /* renamed from: b, reason: from kotlin metadata */
        private boolean isIgnoreWindowFocus;

        /* renamed from: c, reason: from kotlin metadata */
        private boolean isIgnoreOverlap;

        public final VisibilityParams build() {
            return new VisibilityParams(this.visibilityPercent, this.isIgnoreWindowFocus, this.isIgnoreOverlap);
        }

        public final Builder setIgnoreOverlap(boolean isIgnoreOverlap) {
            this.isIgnoreOverlap = isIgnoreOverlap;
            return this;
        }

        public final Builder setIgnoreWindowFocus(boolean isIgnoreWindowFocus) {
            this.isIgnoreWindowFocus = isIgnoreWindowFocus;
            return this;
        }

        public final Builder setVisibilityPercent(float visibilityPercent) {
            this.visibilityPercent = visibilityPercent;
            return this;
        }
    }

    public VisibilityParams() {
        this(0.0f, false, false, 7, null);
    }

    public final float getVisibilityPercent() {
        return this.visibilityPercent;
    }

    /* renamed from: isIgnoreOverlap, reason: from getter */
    public final boolean getIsIgnoreOverlap() {
        return this.isIgnoreOverlap;
    }

    /* renamed from: isIgnoreWindowFocus, reason: from getter */
    public final boolean getIsIgnoreWindowFocus() {
        return this.isIgnoreWindowFocus;
    }

    public VisibilityParams(float f, boolean z, boolean z2) {
        this.visibilityPercent = f;
        this.isIgnoreWindowFocus = z;
        this.isIgnoreOverlap = z2;
    }

    public /* synthetic */ VisibilityParams(float f, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }
}
