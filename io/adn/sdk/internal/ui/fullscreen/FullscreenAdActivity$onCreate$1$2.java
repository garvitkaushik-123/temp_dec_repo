package io.adn.sdk.internal.ui.fullscreen;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreenKt;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: FullscreenAdActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class FullscreenAdActivity$onCreate$1$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ FullscreenAdViewModel $controller;

    FullscreenAdActivity$onCreate$1$2(FullscreenAdViewModel fullscreenAdViewModel) {
        this.$controller = fullscreenAdViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906560947, i, -1, "io.adn.sdk.internal.ui.fullscreen.FullscreenAdActivity.onCreate.<anonymous>.<anonymous> (FullscreenAdActivity.kt:32)");
            }
            FullscreenAdScreenKt.FullscreenAdScreen(this.$controller, null, composer, 0, 2);
            composer.startReplaceableGroup(728837938);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.FullscreenAdActivity$onCreate$1$2$$ExternalSyntheticLambda0
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
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue, composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
