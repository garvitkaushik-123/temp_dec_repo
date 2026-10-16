package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/bidmachine/rendering/model/SideBindParams;", "", "Lio/bidmachine/rendering/model/SideType;", "targetSideType", "", "targetName", "<init>", "(Lio/bidmachine/rendering/model/SideType;Ljava/lang/String;)V", "a", "Lio/bidmachine/rendering/model/SideType;", "getTargetSideType", "()Lio/bidmachine/rendering/model/SideType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getTargetName", "()Ljava/lang/String;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class SideBindParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SideType targetSideType;

    /* renamed from: b, reason: from kotlin metadata */
    private final String targetName;

    public SideBindParams(SideType targetSideType, String targetName) {
        Intrinsics.checkNotNullParameter(targetSideType, "targetSideType");
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        this.targetSideType = targetSideType;
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = targetName.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        this.targetName = lowerCase;
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final SideType getTargetSideType() {
        return this.targetSideType;
    }
}
