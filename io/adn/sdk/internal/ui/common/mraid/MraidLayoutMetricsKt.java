package io.adn.sdk.internal.ui.common.mraid;

import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MraidLayoutMetrics.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"toAdLayoutMetrics", "Lio/adn/sdk/internal/ui/common/mraid/MraidLayoutMetrics;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "Landroid/view/View;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidLayoutMetricsKt {
    public static final MraidLayoutMetrics toAdLayoutMetrics(LayoutCoordinates layoutCoordinates, float f) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
            int left = (int) (boundsInWindow.getLeft() / f);
            int top = (int) (boundsInWindow.getTop() / f);
            int width = (int) (boundsInWindow.getWidth() / f);
            int height = (int) (boundsInWindow.getHeight() / f);
            RectValues rectValues = new RectValues(0, 0, width, height);
            RectValues rectValues2 = new RectValues(left, top, width, height);
            m10241constructorimpl = Result.m10241constructorimpl(new MraidLayoutMetrics(rectValues, rectValues2, rectValues2, rectValues2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        MraidLayoutMetrics mraidLayoutMetrics = new MraidLayoutMetrics(null, null, null, null, 15, null);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = mraidLayoutMetrics;
        }
        return (MraidLayoutMetrics) m10241constructorimpl;
    }

    public static final MraidLayoutMetrics toAdLayoutMetrics(View view) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            float f = view.getResources().getDisplayMetrics().density;
            view.getLocationOnScreen(new int[2]);
            int i = (int) (r1[0] / f);
            int i2 = (int) (r1[1] / f);
            int width = (int) (view.getWidth() / f);
            int height = (int) (view.getHeight() / f);
            RectValues rectValues = new RectValues(0, 0, width, height);
            RectValues rectValues2 = new RectValues(i, i2, width, height);
            m10241constructorimpl = Result.m10241constructorimpl(new MraidLayoutMetrics(rectValues, rectValues2, rectValues2, rectValues2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        MraidLayoutMetrics mraidLayoutMetrics = new MraidLayoutMetrics(null, null, null, null, 15, null);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = mraidLayoutMetrics;
        }
        return (MraidLayoutMetrics) m10241constructorimpl;
    }
}
