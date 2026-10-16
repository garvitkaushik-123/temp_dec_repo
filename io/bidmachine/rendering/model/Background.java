package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/bidmachine/rendering/model/Background;", "", "", VastAttributes.OPACITY, "Lio/bidmachine/rendering/model/BackgroundSource;", "source", "Lio/bidmachine/rendering/model/Placeholder;", "placeholder", "<init>", "(FLio/bidmachine/rendering/model/BackgroundSource;Lio/bidmachine/rendering/model/Placeholder;)V", "a", "F", "getOpacity", "()F", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/model/BackgroundSource;", "getSource", "()Lio/bidmachine/rendering/model/BackgroundSource;", "c", "Lio/bidmachine/rendering/model/Placeholder;", "getPlaceholder", "()Lio/bidmachine/rendering/model/Placeholder;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class Background {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float opacity;

    /* renamed from: b, reason: from kotlin metadata */
    private final BackgroundSource source;

    /* renamed from: c, reason: from kotlin metadata */
    private final Placeholder placeholder;

    public Background(float f, BackgroundSource backgroundSource, Placeholder placeholder) {
        this.opacity = f;
        this.source = backgroundSource;
        this.placeholder = placeholder;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }

    public final BackgroundSource getSource() {
        return this.source;
    }

    public /* synthetic */ Background(float f, BackgroundSource backgroundSource, Placeholder placeholder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? null : backgroundSource, (i & 4) != 0 ? null : placeholder);
    }
}
