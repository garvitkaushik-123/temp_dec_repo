package io.adn.sdk.internal.ui.common.mraid;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MraidOrientation.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toActivityOrientation", "", "Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation;", "(Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation;)Ljava/lang/Integer;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidOrientationKt {

    /* compiled from: MraidOrientation.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MraidOrientation.values().length];
            try {
                iArr[MraidOrientation.Portrait.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MraidOrientation.Landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MraidOrientation.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Integer toActivityOrientation(MraidOrientation mraidOrientation) {
        Intrinsics.checkNotNullParameter(mraidOrientation, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[mraidOrientation.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
