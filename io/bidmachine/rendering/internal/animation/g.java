package io.bidmachine.rendering.internal.animation;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.model.SideBindParams;
import io.bidmachine.rendering.model.SideType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/bidmachine/rendering/model/ElementLayoutParams;", "Lio/bidmachine/rendering/model/SideType;", "a", "(Lio/bidmachine/rendering/model/ElementLayoutParams;)Lio/bidmachine/rendering/model/SideType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class g {
    public static final SideType a(ElementLayoutParams elementLayoutParams) {
        SideBindParams rightSideBindParams;
        Intrinsics.checkNotNullParameter(elementLayoutParams, "<this>");
        if (elementLayoutParams.getLeftSideBindParams() != null) {
            SideBindParams leftSideBindParams = elementLayoutParams.getLeftSideBindParams();
            if (leftSideBindParams != null) {
                return leftSideBindParams.getTargetSideType();
            }
            return null;
        }
        if (elementLayoutParams.getRightSideBindParams() == null || (rightSideBindParams = elementLayoutParams.getRightSideBindParams()) == null) {
            return null;
        }
        return rightSideBindParams.getTargetSideType();
    }

    public static final SideType b(ElementLayoutParams elementLayoutParams) {
        SideBindParams bottomSideBindParams;
        Intrinsics.checkNotNullParameter(elementLayoutParams, "<this>");
        if (elementLayoutParams.getTopSideBindParams() != null) {
            SideBindParams topSideBindParams = elementLayoutParams.getTopSideBindParams();
            if (topSideBindParams != null) {
                return topSideBindParams.getTargetSideType();
            }
            return null;
        }
        if (elementLayoutParams.getBottomSideBindParams() == null || (bottomSideBindParams = elementLayoutParams.getBottomSideBindParams()) == null) {
            return null;
        }
        return bottomSideBindParams.getTargetSideType();
    }
}
