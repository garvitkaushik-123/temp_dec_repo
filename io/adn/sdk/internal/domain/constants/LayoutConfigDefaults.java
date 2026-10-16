package io.adn.sdk.internal.domain.constants;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.adn.sdk.internal.domain.model.ad.DisplayMode;
import io.adn.sdk.internal.domain.model.ad.LoadingStrategy;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.domain.model.ui.CloseButtonType;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutConfigDefaults.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0011J\u0016\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=2\u0006\u0010:\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u000e\u0010\u001b\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u000e\u0010$\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u00104\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u000e\u00106\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lio/adn/sdk/internal/domain/constants/LayoutConfigDefaults;", "", "<init>", "()V", "CLOSE_POSITION", "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "getCLOSE_POSITION", "()Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "CLOSE_TYPE", "Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "getCLOSE_TYPE", "()Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "CLOSE_CLICK_RATIO", "", "AUTO_CLOSE_ENABLED", "", "CLOSE_DELAY", "", "PRIVACY_ENABLED", "PRIVACY_POSITION", "getPRIVACY_POSITION", "PRIVACY_SIZE", "BUTTON_COLOR", "BUTTON_SIZE", "CTA_ENABLED", "CTA_POSITION", "getCTA_POSITION", "CTA_TEXT_SIZE", "CTA_TEXT_COLOR", "CTA_BUTTON_COLOR", "CTA_TEXT", "", "PROMOTED_APP_DESC", "MUTE_ENABLED", "MUTE_POSITION", "getMUTE_POSITION", "PROGRESS_BAR_ENABLED", "PROGRESS_BAR_COLOR", "PROGRESS_BAR_POSITION", "getPROGRESS_BAR_POSITION", "REDIRECTION_STRATEGY", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "getREDIRECTION_STRATEGY", "()Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "STORE_OVERLAY_DELAY", "", "STORE_DISMISSABLE", "END_CARD_DISPLAY_MODE", "Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "getEND_CARD_DISPLAY_MODE", "()Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "PROMOTED_APP_CARD_ENABLED", "PROMOTED_APP_CARD_REDIRECTION_STRATEGY", "getPROMOTED_APP_CARD_REDIRECTION_STRATEGY", "PROMOTED_APP_CARD__CLOSE_DELAY", "LOADING_CARD_ENABLED", "loadingStrategy", "Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", FirebaseAnalytics.Param.INDEX, "closeDelay", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LayoutConfigDefaults {
    public static final int $stable = 0;
    public static final boolean AUTO_CLOSE_ENABLED = true;
    public static final int BUTTON_COLOR = -16777216;
    public static final int BUTTON_SIZE = 26;
    public static final float CLOSE_CLICK_RATIO = 1.0f;
    public static final int CLOSE_DELAY = 5;
    public static final int CTA_BUTTON_COLOR = -12417548;
    public static final boolean CTA_ENABLED = false;
    public static final String CTA_TEXT = "Install";
    public static final int CTA_TEXT_COLOR = -1;
    public static final int CTA_TEXT_SIZE = 22;
    public static final boolean LOADING_CARD_ENABLED = false;
    public static final boolean MUTE_ENABLED = true;
    public static final boolean PRIVACY_ENABLED = true;
    public static final int PRIVACY_SIZE = 22;
    public static final int PROGRESS_BAR_COLOR = -65536;
    public static final boolean PROGRESS_BAR_ENABLED = true;
    public static final boolean PROMOTED_APP_CARD_ENABLED = false;
    public static final int PROMOTED_APP_CARD__CLOSE_DELAY = 2;
    public static final String PROMOTED_APP_DESC = "Sponsored";
    public static final boolean STORE_DISMISSABLE = true;
    public static final double STORE_OVERLAY_DELAY = -1.0d;
    public static final LayoutConfigDefaults INSTANCE = new LayoutConfigDefaults();
    private static final LayoutPosition CLOSE_POSITION = LayoutPosition.TopRight;
    private static final CloseButtonType CLOSE_TYPE = CloseButtonType.SimpleCross;
    private static final LayoutPosition PRIVACY_POSITION = LayoutPosition.BottomLeft;
    private static final LayoutPosition CTA_POSITION = LayoutPosition.BottomRight;
    private static final LayoutPosition MUTE_POSITION = LayoutPosition.TopLeft;
    private static final LayoutPosition PROGRESS_BAR_POSITION = LayoutPosition.BottomLeft;
    private static final RedirectionStrategy REDIRECTION_STRATEGY = RedirectionStrategy.KeepAll;
    private static final DisplayMode END_CARD_DISPLAY_MODE = DisplayMode.Overlay;
    private static final RedirectionStrategy PROMOTED_APP_CARD_REDIRECTION_STRATEGY = RedirectionStrategy.DisableAll;

    private LayoutConfigDefaults() {
    }

    public final LayoutPosition getCLOSE_POSITION() {
        return CLOSE_POSITION;
    }

    public final CloseButtonType getCLOSE_TYPE() {
        return CLOSE_TYPE;
    }

    public final LayoutPosition getPRIVACY_POSITION() {
        return PRIVACY_POSITION;
    }

    public final LayoutPosition getCTA_POSITION() {
        return CTA_POSITION;
    }

    public final LayoutPosition getMUTE_POSITION() {
        return MUTE_POSITION;
    }

    public final LayoutPosition getPROGRESS_BAR_POSITION() {
        return PROGRESS_BAR_POSITION;
    }

    public final RedirectionStrategy getREDIRECTION_STRATEGY() {
        return REDIRECTION_STRATEGY;
    }

    public final DisplayMode getEND_CARD_DISPLAY_MODE() {
        return END_CARD_DISPLAY_MODE;
    }

    public final RedirectionStrategy getPROMOTED_APP_CARD_REDIRECTION_STRATEGY() {
        return PROMOTED_APP_CARD_REDIRECTION_STRATEGY;
    }

    public final LoadingStrategy loadingStrategy(int index) {
        if (index == 0) {
            return LoadingStrategy.DownloadAndPreload;
        }
        return LoadingStrategy.DownloadOnly;
    }

    public final int closeDelay(AdnAdPlacement placement, int index) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        return (index == 0 && placement == AdnAdPlacement.REWARDED) ? 15 : 5;
    }
}
