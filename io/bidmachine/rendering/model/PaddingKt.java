package io.bidmachine.rendering.model;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.util.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"setPadding", "", "Landroid/view/View;", VastAttributes.PADDING, "Lio/bidmachine/rendering/model/Padding;", "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PaddingKt {
    public static final void setPadding(View view, Padding padding) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (padding == null) {
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dpToPx = UtilsKt.dpToPx(context, padding.getLeftDp());
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int dpToPx2 = UtilsKt.dpToPx(context2, padding.getTopDp());
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        int dpToPx3 = UtilsKt.dpToPx(context3, padding.getRightDp());
        Context context4 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        view.setPadding(dpToPx, dpToPx2, dpToPx3, UtilsKt.dpToPx(context4, padding.getBottomDp()));
    }
}
