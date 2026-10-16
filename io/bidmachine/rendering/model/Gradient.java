package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/bidmachine/rendering/model/Gradient;", "", "Lio/bidmachine/rendering/model/GradientType;", "type", "Lio/bidmachine/rendering/model/GradientDirection;", "direction", "", "", "colors", "<init>", "(Lio/bidmachine/rendering/model/GradientType;Lio/bidmachine/rendering/model/GradientDirection;Ljava/util/List;)V", "a", "Lio/bidmachine/rendering/model/GradientType;", "getType", "()Lio/bidmachine/rendering/model/GradientType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/model/GradientDirection;", "getDirection", "()Lio/bidmachine/rendering/model/GradientDirection;", "c", "Ljava/util/List;", "getColors", "()Ljava/util/List;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class Gradient {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final GradientType type;

    /* renamed from: b, reason: from kotlin metadata */
    private final GradientDirection direction;

    /* renamed from: c, reason: from kotlin metadata */
    private final List<Integer> colors;

    public Gradient(GradientType type, GradientDirection direction, List<Integer> colors) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.type = type;
        this.direction = direction;
        this.colors = colors;
    }

    public final List<Integer> getColors() {
        return this.colors;
    }

    public final GradientDirection getDirection() {
        return this.direction;
    }

    public final GradientType getType() {
        return this.type;
    }
}
