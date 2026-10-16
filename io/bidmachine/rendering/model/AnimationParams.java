package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000f¨\u0006#"}, d2 = {"Lio/bidmachine/rendering/model/AnimationParams;", "", "Lio/bidmachine/rendering/model/AnimationEventType;", "event", "Lio/bidmachine/rendering/model/AnimationStyleType;", "style", "Lio/bidmachine/rendering/model/AnimationFunctionType;", "function", "", "duration", "Lio/bidmachine/rendering/model/AnimationDirectionType;", "direction", "<init>", "(Lio/bidmachine/rendering/model/AnimationEventType;Lio/bidmachine/rendering/model/AnimationStyleType;Lio/bidmachine/rendering/model/AnimationFunctionType;JLio/bidmachine/rendering/model/AnimationDirectionType;)V", "getDirectionOrDefault", "()Lio/bidmachine/rendering/model/AnimationDirectionType;", "a", "Lio/bidmachine/rendering/model/AnimationEventType;", "getEvent", "()Lio/bidmachine/rendering/model/AnimationEventType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/model/AnimationStyleType;", "getStyle", "()Lio/bidmachine/rendering/model/AnimationStyleType;", "c", "Lio/bidmachine/rendering/model/AnimationFunctionType;", "getFunction", "()Lio/bidmachine/rendering/model/AnimationFunctionType;", "d", "J", "getDuration", "()J", "e", "Lio/bidmachine/rendering/model/AnimationDirectionType;", "getDirection", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class AnimationParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AnimationEventType event;

    /* renamed from: b, reason: from kotlin metadata */
    private final AnimationStyleType style;

    /* renamed from: c, reason: from kotlin metadata */
    private final AnimationFunctionType function;

    /* renamed from: d, reason: from kotlin metadata */
    private final long duration;

    /* renamed from: e, reason: from kotlin metadata */
    private final AnimationDirectionType direction;

    public AnimationParams(AnimationEventType event, AnimationStyleType style, AnimationFunctionType animationFunctionType, long j, AnimationDirectionType animationDirectionType) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(style, "style");
        this.event = event;
        this.style = style;
        this.function = animationFunctionType;
        this.duration = j;
        this.direction = animationDirectionType;
    }

    public final AnimationDirectionType getDirection() {
        return this.direction;
    }

    public final AnimationDirectionType getDirectionOrDefault() {
        AnimationDirectionType animationDirectionType = this.direction;
        return animationDirectionType == null ? AnimationDirectionType.Left : animationDirectionType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final AnimationEventType getEvent() {
        return this.event;
    }

    public final AnimationFunctionType getFunction() {
        return this.function;
    }

    public final AnimationStyleType getStyle() {
        return this.style;
    }
}
