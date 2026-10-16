package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import com.ironsource.C3061e8;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiStateKt;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.internal.ui.utils.UIConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreOverlay.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001ay\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a¡\u0001\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 \u001a3\u0010!\u001a\u00020\"*\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0002¢\u0006\u0004\b'\u0010(¨\u0006)²\u0006\n\u0010*\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"storeOverlay", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "delayBeforeDisplay", "", "isDismissable", "", "onCtaClick", "Lkotlin/Function0;", "onDismiss", "alignment", "Landroidx/compose/ui/Alignment;", VastAttributes.PADDING, "Landroidx/compose/foundation/layout/PaddingValues;", "promotedApp", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "ctaConfig", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "(DZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/layout/PaddingValues;Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function3;", "name", "", "icon", "", "description", "ctaText", "ctaColor", "Landroidx/compose/ui/graphics/Color;", "ctaTextColor", "storeOverlay-6NCvTQU", "(DZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/layout/PaddingValues;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;JJLandroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function3;", "dragDismissable", "Landroidx/compose/ui/Modifier;", "containerHeight", "Landroidx/compose/ui/unit/Dp;", "dismissThresholdFraction", "", "dragDismissable-ziNgDLE", "(Landroidx/compose/ui/Modifier;FFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "adn-sdk_release", C3061e8.k}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class StoreOverlayKt {
    public static final Function3<BoxScope, Composer, Integer, Unit> storeOverlay(double d, boolean z, final Function0<Unit> onCtaClick, Function0<Unit> function0, Alignment alignment, PaddingValues paddingValues, final PromotedAppUiState promotedApp, final AdCtaConfig ctaConfig, Composer composer, int i, int i2) {
        final Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(onCtaClick, "onCtaClick");
        Intrinsics.checkNotNullParameter(promotedApp, "promotedApp");
        Intrinsics.checkNotNullParameter(ctaConfig, "ctaConfig");
        composer.startReplaceableGroup(256871549);
        final double d2 = (i2 & 1) != 0 ? 1.0d : d;
        final boolean z2 = (i2 & 2) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-1043537086);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            function02 = (Function0) rememberedValue;
        } else {
            function02 = function0;
        }
        final Alignment bottomCenter = (i2 & 16) != 0 ? Alignment.INSTANCE.getBottomCenter() : alignment;
        final PaddingValues sTORE_PADDING$adn_sdk_release = (i2 & 32) != 0 ? UIConstants.INSTANCE.getSTORE_PADDING$adn_sdk_release() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(256871549, i, -1, "io.adn.sdk.internal.ui.common.design.compose.storeOverlay (StoreOverlay.kt:65)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -2016190813, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$storeOverlay$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope boxScope, Composer composer2, int i3) {
                int i4;
                Intrinsics.checkNotNullParameter(boxScope, "<this>");
                if ((i3 & 6) == 0) {
                    i4 = i3 | (composer2.changed(boxScope) ? 4 : 2);
                } else {
                    i4 = i3;
                }
                if ((i4 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2016190813, i4, -1, "io.adn.sdk.internal.ui.common.design.compose.storeOverlay.<anonymous> (StoreOverlay.kt:66)");
                    }
                    StoreOverlayKt.m9535storeOverlay6NCvTQU(d2, z2, onCtaClick, function02, bottomCenter, sTORE_PADDING$adn_sdk_release, promotedApp.getName(), FullscreenAdUiStateKt.icon(promotedApp), promotedApp.getDescription(), ctaConfig.getText(), ComposeKt.toColor(ctaConfig.getColor()), ComposeKt.toColor(ctaConfig.getTextColor()), composer2, 0, 0, 0).invoke(boxScope, composer2, Integer.valueOf(i4 & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* renamed from: storeOverlay-6NCvTQU, reason: not valid java name */
    public static final Function3<BoxScope, Composer, Integer, Unit> m9535storeOverlay6NCvTQU(double d, boolean z, Function0<Unit> onCtaClick, Function0<Unit> function0, Alignment alignment, PaddingValues paddingValues, String str, Object obj, String str2, String ctaText, long j, long j2, Composer composer, int i, int i2, int i3) {
        Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(onCtaClick, "onCtaClick");
        Intrinsics.checkNotNullParameter(ctaText, "ctaText");
        composer.startReplaceableGroup(121743673);
        double d2 = (i3 & 1) != 0 ? 1.0d : d;
        boolean z2 = (i3 & 2) != 0 ? true : z;
        if ((i3 & 8) != 0) {
            composer.startReplaceableGroup(-1043513982);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            function02 = (Function0) rememberedValue;
        } else {
            function02 = function0;
        }
        Alignment bottomCenter = (i3 & 16) != 0 ? Alignment.INSTANCE.getBottomCenter() : alignment;
        PaddingValues sTORE_PADDING$adn_sdk_release = (i3 & 32) != 0 ? UIConstants.INSTANCE.getSTORE_PADDING$adn_sdk_release() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(121743673, i, i2, "io.adn.sdk.internal.ui.common.design.compose.storeOverlay (StoreOverlay.kt:96)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -2008234273, true, new StoreOverlayKt$storeOverlay$4(d2, bottomCenter, sTORE_PADDING$adn_sdk_release, z2, function02, obj, j, j2, onCtaClick, str, str2, ctaText));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* renamed from: dragDismissable-ziNgDLE$default, reason: not valid java name */
    static /* synthetic */ Modifier m9534dragDismissableziNgDLE$default(Modifier modifier, float f, float f2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.5f;
        }
        return m9533dragDismissableziNgDLE(modifier, f, f2, function0);
    }

    /* renamed from: dragDismissable-ziNgDLE, reason: not valid java name */
    private static final Modifier m9533dragDismissableziNgDLE(Modifier modifier, float f, float f2, Function0<Unit> function0) {
        return ComposedModifierKt.composed$default(modifier, null, new StoreOverlayKt$dragDismissable$1(f2, function0, f), 1, null);
    }
}
