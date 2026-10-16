package io.adn.sdk.internal.ui.fullscreen.model;

import androidx.compose.ui.graphics.Color;
import io.adn.sdk.internal.ui.utils.UIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdUiState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÇ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001e\u001a\u00020\u0003H×\u0001J\t\u0010\u001f\u001a\u00020 H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdUiState;", "", "activeSceneIndex", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "overlaySceneIndex", "overlayMode", "Lio/adn/sdk/internal/ui/fullscreen/model/OverlayMode;", "<init>", "(IJILio/adn/sdk/internal/ui/fullscreen/model/OverlayMode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveSceneIndex", "()I", "getBackgroundColor-0d7_KjU", "()J", "J", "getOverlaySceneIndex", "getOverlayMode", "()Lio/adn/sdk/internal/ui/fullscreen/model/OverlayMode;", "component1", "component2", "component2-0d7_KjU", "component3", "component4", "copy", "copy-RPmYEkk", "(IJILio/adn/sdk/internal/ui/fullscreen/model/OverlayMode;)Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdUiState;", "equals", "", "other", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class FullscreenAdUiState {
    public static final int $stable = 0;
    private final int activeSceneIndex;
    private final long backgroundColor;
    private final OverlayMode overlayMode;
    private final int overlaySceneIndex;

    public /* synthetic */ FullscreenAdUiState(int i, long j, int i2, OverlayMode overlayMode, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, j, i2, overlayMode);
    }

    /* renamed from: copy-RPmYEkk$default, reason: not valid java name */
    public static /* synthetic */ FullscreenAdUiState m9583copyRPmYEkk$default(FullscreenAdUiState fullscreenAdUiState, int i, long j, int i2, OverlayMode overlayMode, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = fullscreenAdUiState.activeSceneIndex;
        }
        if ((i3 & 2) != 0) {
            j = fullscreenAdUiState.backgroundColor;
        }
        if ((i3 & 4) != 0) {
            i2 = fullscreenAdUiState.overlaySceneIndex;
        }
        if ((i3 & 8) != 0) {
            overlayMode = fullscreenAdUiState.overlayMode;
        }
        return fullscreenAdUiState.m9585copyRPmYEkk(i, j, i2, overlayMode);
    }

    /* renamed from: component1, reason: from getter */
    public final int getActiveSceneIndex() {
        return this.activeSceneIndex;
    }

    /* renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component3, reason: from getter */
    public final int getOverlaySceneIndex() {
        return this.overlaySceneIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final OverlayMode getOverlayMode() {
        return this.overlayMode;
    }

    /* renamed from: copy-RPmYEkk, reason: not valid java name */
    public final FullscreenAdUiState m9585copyRPmYEkk(int activeSceneIndex, long backgroundColor, int overlaySceneIndex, OverlayMode overlayMode) {
        Intrinsics.checkNotNullParameter(overlayMode, "overlayMode");
        return new FullscreenAdUiState(activeSceneIndex, backgroundColor, overlaySceneIndex, overlayMode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FullscreenAdUiState)) {
            return false;
        }
        FullscreenAdUiState fullscreenAdUiState = (FullscreenAdUiState) other;
        return this.activeSceneIndex == fullscreenAdUiState.activeSceneIndex && Color.m4064equalsimpl0(this.backgroundColor, fullscreenAdUiState.backgroundColor) && this.overlaySceneIndex == fullscreenAdUiState.overlaySceneIndex && this.overlayMode == fullscreenAdUiState.overlayMode;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.activeSceneIndex) * 31) + Color.m4070hashCodeimpl(this.backgroundColor)) * 31) + Integer.hashCode(this.overlaySceneIndex)) * 31) + this.overlayMode.hashCode();
    }

    public String toString() {
        return "FullscreenAdUiState(activeSceneIndex=" + this.activeSceneIndex + ", backgroundColor=" + ((Object) Color.m4071toStringimpl(this.backgroundColor)) + ", overlaySceneIndex=" + this.overlaySceneIndex + ", overlayMode=" + this.overlayMode + ')';
    }

    private FullscreenAdUiState(int i, long j, int i2, OverlayMode overlayMode) {
        Intrinsics.checkNotNullParameter(overlayMode, "overlayMode");
        this.activeSceneIndex = i;
        this.backgroundColor = j;
        this.overlaySceneIndex = i2;
        this.overlayMode = overlayMode;
    }

    public final int getActiveSceneIndex() {
        return this.activeSceneIndex;
    }

    public /* synthetic */ FullscreenAdUiState(int i, long j, int i2, OverlayMode overlayMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? UIConstants.INSTANCE.m9600getSCREEN_BACKGROUND_COLOR0d7_KjU$adn_sdk_release() : j, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? OverlayMode.None : overlayMode, null);
    }

    /* renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m9586getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public final int getOverlaySceneIndex() {
        return this.overlaySceneIndex;
    }

    public final OverlayMode getOverlayMode() {
        return this.overlayMode;
    }
}
