package io.adn.sdk.internal.ui.nativead;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: NativeAdViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class NativeAdViewModel$mainMediaView$1$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ NativeMediaViewModel $viewModel;
    final /* synthetic */ NativeAdViewModel this$0;

    NativeAdViewModel$mainMediaView$1$1$1(NativeMediaViewModel nativeMediaViewModel, NativeAdViewModel nativeAdViewModel) {
        this.$viewModel = nativeMediaViewModel;
        this.this$0 = nativeAdViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-428113180, i, -1, "io.adn.sdk.internal.ui.nativead.NativeAdViewModel.mainMediaView.<anonymous>.<anonymous>.<anonymous> (NativeAdViewModel.kt:75)");
        }
        NativeMediaViewModel nativeMediaViewModel = this.$viewModel;
        composer.startReplaceableGroup(-1074153011);
        boolean changedInstance = composer.changedInstance(this.this$0);
        final NativeAdViewModel nativeAdViewModel = this.this$0;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.nativead.NativeAdViewModel$mainMediaView$1$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = NativeAdViewModel$mainMediaView$1$1$1.invoke$lambda$1$lambda$0(NativeAdViewModel.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        NativeAdMediaContentKt.NativeAdMediaContent(nativeMediaViewModel, (Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(NativeAdViewModel nativeAdViewModel) {
        nativeAdViewModel.handleAdClick(AdnClickElement.MainMedia.INSTANCE);
        return Unit.INSTANCE;
    }
}
