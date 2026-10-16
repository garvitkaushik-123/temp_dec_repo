package io.bidmachine.rendering.model;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"toImageViewScaleType", "Landroid/widget/ImageView$ScaleType;", "Lio/bidmachine/rendering/model/ScaleType;", "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class ScaleTypeKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScaleType.values().length];
            try {
                iArr[ScaleType.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleType.ToFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleType.AspectFill.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScaleType.AspectFit.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ImageView.ScaleType toImageViewScaleType(ScaleType scaleType) {
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[scaleType.ordinal()];
        if (i == -1 || i == 1) {
            return null;
        }
        if (i == 2) {
            return ImageView.ScaleType.FIT_XY;
        }
        if (i == 3) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if (i == 4) {
            return ImageView.ScaleType.CENTER_INSIDE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
