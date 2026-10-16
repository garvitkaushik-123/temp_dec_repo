package io.adn.sdk.internal.ui.utils;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* compiled from: Constants.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001f¨\u0006$"}, d2 = {"Lio/adn/sdk/internal/ui/utils/UIConstants;", "", "<init>", "()V", "SCREEN_BACKGROUND_COLOR", "Landroidx/compose/ui/graphics/Color;", "getSCREEN_BACKGROUND_COLOR-0d7_KjU$adn_sdk_release", "()J", "J", "CTA_BACKGROUND_COLOR", "getCTA_BACKGROUND_COLOR-0d7_KjU$adn_sdk_release", "ICON_BUTTON_COLOR_DISABLED", "getICON_BUTTON_COLOR_DISABLED-0d7_KjU$adn_sdk_release", "COUNTDOWN_PROGRESS_COLOR", "getCOUNTDOWN_PROGRESS_COLOR-0d7_KjU$adn_sdk_release", "NATIVE_ICON_BUTTON_COLOR", "getNATIVE_ICON_BUTTON_COLOR-0d7_KjU$adn_sdk_release", "COUNTDOWN_STROKE_SIZE", "Landroidx/compose/ui/unit/Dp;", "getCOUNTDOWN_STROKE_SIZE-D9Ej5fM$adn_sdk_release", "()F", "F", "TEXT_BUTTON_TEXT_SIZE", "Landroidx/compose/ui/unit/TextUnit;", "getTEXT_BUTTON_TEXT_SIZE-XSAIIZE$adn_sdk_release", "NATIVE_ICON_BUTTON_SIZE", "Landroidx/compose/ui/unit/DpSize;", "getNATIVE_ICON_BUTTON_SIZE-MYxV2XQ$adn_sdk_release", "ICON_BUTTON_PADDING", "Landroidx/compose/foundation/layout/PaddingValues;", "getICON_BUTTON_PADDING$adn_sdk_release", "()Landroidx/compose/foundation/layout/PaddingValues;", "STORE_PADDING", "getSTORE_PADDING$adn_sdk_release", "TEXT_BUTTON_PADDING", "getTEXT_BUTTON_PADDING$adn_sdk_release", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class UIConstants {
    public static final int $stable = 0;
    private static final PaddingValues ICON_BUTTON_PADDING;
    private static final long NATIVE_ICON_BUTTON_SIZE;
    private static final PaddingValues STORE_PADDING;
    public static final UIConstants INSTANCE = new UIConstants();
    private static final long SCREEN_BACKGROUND_COLOR = ColorKt.Color(4278979596L);
    private static final long CTA_BACKGROUND_COLOR = ColorKt.Color(4280361249L);
    private static final long ICON_BUTTON_COLOR_DISABLED = ColorKt.Color(4288585374L);
    private static final long COUNTDOWN_PROGRESS_COLOR = ColorKt.Color(4283224189L);
    private static final long NATIVE_ICON_BUTTON_COLOR = Color.INSTANCE.m4100getWhite0d7_KjU();
    private static final float COUNTDOWN_STROKE_SIZE = Dp.m6389constructorimpl(2);
    private static final long TEXT_BUTTON_TEXT_SIZE = TextUnitKt.getSp(20);
    private static final PaddingValues TEXT_BUTTON_PADDING = PaddingKt.m874PaddingValuesYgX7TsA$default(0.0f, Dp.m6389constructorimpl(15), 1, null);

    private UIConstants() {
    }

    static {
        float f = 26;
        NATIVE_ICON_BUTTON_SIZE = DpKt.m6411DpSizeYgX7TsA(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
        float f2 = 10;
        ICON_BUTTON_PADDING = PaddingKt.m873PaddingValuesYgX7TsA(Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(30));
        STORE_PADDING = PaddingKt.m873PaddingValuesYgX7TsA(Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(20));
    }

    /* renamed from: getSCREEN_BACKGROUND_COLOR-0d7_KjU$adn_sdk_release, reason: not valid java name */
    public final long m9600getSCREEN_BACKGROUND_COLOR0d7_KjU$adn_sdk_release() {
        return SCREEN_BACKGROUND_COLOR;
    }

    /* renamed from: getCTA_BACKGROUND_COLOR-0d7_KjU$adn_sdk_release, reason: not valid java name */
    public final long m9596getCTA_BACKGROUND_COLOR0d7_KjU$adn_sdk_release() {
        return CTA_BACKGROUND_COLOR;
    }

    /* renamed from: getICON_BUTTON_COLOR_DISABLED-0d7_KjU$adn_sdk_release, reason: not valid java name */
    public final long m9597getICON_BUTTON_COLOR_DISABLED0d7_KjU$adn_sdk_release() {
        return ICON_BUTTON_COLOR_DISABLED;
    }

    /* renamed from: getCOUNTDOWN_PROGRESS_COLOR-0d7_KjU$adn_sdk_release, reason: not valid java name */
    public final long m9594getCOUNTDOWN_PROGRESS_COLOR0d7_KjU$adn_sdk_release() {
        return COUNTDOWN_PROGRESS_COLOR;
    }

    /* renamed from: getNATIVE_ICON_BUTTON_COLOR-0d7_KjU$adn_sdk_release, reason: not valid java name */
    public final long m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release() {
        return NATIVE_ICON_BUTTON_COLOR;
    }

    /* renamed from: getCOUNTDOWN_STROKE_SIZE-D9Ej5fM$adn_sdk_release, reason: not valid java name */
    public final float m9595getCOUNTDOWN_STROKE_SIZED9Ej5fM$adn_sdk_release() {
        return COUNTDOWN_STROKE_SIZE;
    }

    /* renamed from: getTEXT_BUTTON_TEXT_SIZE-XSAIIZE$adn_sdk_release, reason: not valid java name */
    public final long m9601getTEXT_BUTTON_TEXT_SIZEXSAIIZE$adn_sdk_release() {
        return TEXT_BUTTON_TEXT_SIZE;
    }

    /* renamed from: getNATIVE_ICON_BUTTON_SIZE-MYxV2XQ$adn_sdk_release, reason: not valid java name */
    public final long m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release() {
        return NATIVE_ICON_BUTTON_SIZE;
    }

    public final PaddingValues getICON_BUTTON_PADDING$adn_sdk_release() {
        return ICON_BUTTON_PADDING;
    }

    public final PaddingValues getSTORE_PADDING$adn_sdk_release() {
        return STORE_PADDING;
    }

    public final PaddingValues getTEXT_BUTTON_PADDING$adn_sdk_release() {
        return TEXT_BUTTON_PADDING;
    }
}
