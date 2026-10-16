package io.adn.sdk.internal.ui.common.design.compose;

import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlideDirection.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toSlideDirection", "Lio/adn/sdk/internal/ui/common/design/compose/SlideDirection;", "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SlideDirectionKt {

    /* compiled from: SlideDirection.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutPosition.values().length];
            try {
                iArr[LayoutPosition.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutPosition.BottomLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutPosition.TopRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutPosition.BottomRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SlideDirection toSlideDirection(LayoutPosition layoutPosition) {
        Intrinsics.checkNotNullParameter(layoutPosition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutPosition.ordinal()];
        if (i == 1 || i == 2) {
            return SlideDirection.LeftToRight;
        }
        if (i == 3 || i == 4) {
            return SlideDirection.RightToLeft;
        }
        throw new NoWhenBranchMatchedException();
    }
}
