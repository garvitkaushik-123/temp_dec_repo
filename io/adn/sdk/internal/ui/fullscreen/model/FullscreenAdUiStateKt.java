package io.adn.sdk.internal.ui.fullscreen.model;

import io.adn.sdk.internal.domain.model.ad.DisplayMode;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdUiState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"toOverlayMode", "Lio/adn/sdk/internal/ui/fullscreen/model/OverlayMode;", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "icon", "", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdUiStateKt {

    /* compiled from: FullscreenAdUiState.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayMode.values().length];
            try {
                iArr[DisplayMode.Overlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayMode.Push.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayMode.BlurOverlay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final OverlayMode toOverlayMode(DisplayMode displayMode) {
        Intrinsics.checkNotNullParameter(displayMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[displayMode.ordinal()];
        if (i == 1) {
            return OverlayMode.Transparent;
        }
        if (i == 2) {
            return OverlayMode.None;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return OverlayMode.Blurred;
    }

    public static final Object icon(PromotedAppUiState promotedAppUiState) {
        Intrinsics.checkNotNullParameter(promotedAppUiState, "<this>");
        File localIcon = promotedAppUiState.getLocalIcon();
        return localIcon == null ? promotedAppUiState.getRemoteIcon() : localIcon;
    }
}
