package io.adn.sdk.publisher;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnNativeAdContainer.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"AdnNativeAdContainer", "", "ad", "Lio/adn/sdk/publisher/AdnNativeAd;", "content", "Lkotlin/Function1;", "Lio/adn/sdk/publisher/AdnNativeAdScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "(Lio/adn/sdk/publisher/AdnNativeAd;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnNativeAdContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdnNativeAdContainer$lambda$0(AdnNativeAd adnNativeAd, Function3 function3, int i, Composer composer, int i2) {
        AdnNativeAdContainer(adnNativeAd, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdnNativeAdContainer$lambda$3(AdnNativeAd adnNativeAd, Function3 function3, int i, Composer composer, int i2) {
        AdnNativeAdContainer(adnNativeAd, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AdnNativeAdContainer(final AdnNativeAd ad, final Function3<? super AdnNativeAdScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1140245102);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(ad) : startRestartGroup.changedInstance(ad) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1140245102, i2, -1, "io.adn.sdk.publisher.AdnNativeAdContainer (AdnNativeAdContainer.kt:9)");
            }
            AdnNativeAdRenderer adnNativeAdRenderer = ad.getAdnNativeAdRenderer();
            if (adnNativeAdRenderer == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.publisher.AdnNativeAdContainerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AdnNativeAdContainer$lambda$0;
                            AdnNativeAdContainer$lambda$0 = AdnNativeAdContainerKt.AdnNativeAdContainer$lambda$0(AdnNativeAd.this, content, i, (Composer) obj, ((Integer) obj2).intValue());
                            return AdnNativeAdContainer$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            String uuid = ad.getUuid();
            startRestartGroup.startReplaceableGroup(397802245);
            boolean changed = startRestartGroup.changed(uuid);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                AdnNativeInteractionHandler adnNativeInteractionHandler = new AdnNativeInteractionHandler();
                ad.prepareForInteraction(adnNativeInteractionHandler);
                rememberedValue = new AdnNativeAdScope(adnNativeAdRenderer, adnNativeInteractionHandler);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            content.invoke((AdnNativeAdScope) rememberedValue, startRestartGroup, Integer.valueOf(i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: io.adn.sdk.publisher.AdnNativeAdContainerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdnNativeAdContainer$lambda$3;
                    AdnNativeAdContainer$lambda$3 = AdnNativeAdContainerKt.AdnNativeAdContainer$lambda$3(AdnNativeAd.this, content, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdnNativeAdContainer$lambda$3;
                }
            });
        }
    }
}
