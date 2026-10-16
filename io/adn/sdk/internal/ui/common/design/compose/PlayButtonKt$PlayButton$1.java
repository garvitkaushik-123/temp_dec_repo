package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayButton.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class PlayButtonKt$PlayButton$1 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ Function1<Boolean, Unit> $onPlayStateChange;
    final /* synthetic */ Painter $pauseIcon;
    final /* synthetic */ Painter $playIcon;
    final /* synthetic */ long $size;
    final /* synthetic */ boolean $useDefaultBackground;

    /* JADX WARN: Multi-variable type inference failed */
    PlayButtonKt$PlayButton$1(boolean z, Painter painter, Painter painter2, boolean z2, Function1<? super Boolean, Unit> function1, long j, long j2, boolean z3) {
        this.$isPlaying = z;
        this.$pauseIcon = painter;
        this.$playIcon = painter2;
        this.$isEnabled = z2;
        this.$onPlayStateChange = function1;
        this.$color = j;
        this.$size = j2;
        this.$useDefaultBackground = z3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
        invoke(animatedVisibilityScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(22308010, i, -1, "io.adn.sdk.internal.ui.common.design.compose.PlayButton.<anonymous> (PlayButton.kt:24)");
        }
        Painter painter = this.$isPlaying ? this.$pauseIcon : this.$playIcon;
        composer.startReplaceableGroup(542043430);
        boolean changed = composer.changed(this.$isEnabled) | composer.changed(this.$onPlayStateChange) | composer.changed(this.$isPlaying);
        final boolean z = this.$isEnabled;
        final Function1<Boolean, Unit> function1 = this.$onPlayStateChange;
        final boolean z2 = this.$isPlaying;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.PlayButtonKt$PlayButton$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = PlayButtonKt$PlayButton$1.invoke$lambda$1$lambda$0(z, function1, z2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter, (Function0) rememberedValue, null, false, "Pause/Play", this.$color, this.$size, this.$useDefaultBackground, 0.0f, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 537);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(boolean z, Function1 function1, boolean z2) {
        if (z) {
            function1.invoke(Boolean.valueOf(!z2));
        }
        return Unit.INSTANCE;
    }
}
