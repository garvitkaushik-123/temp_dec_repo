package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StoreOverlay.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class StoreOverlayKt$dragDismissable$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ float $containerHeight;
    final /* synthetic */ float $dismissThresholdFraction;
    final /* synthetic */ Function0<Unit> $onDismiss;

    StoreOverlayKt$dragDismissable$1(float f, Function0<Unit> function0, float f2) {
        this.$dismissThresholdFraction = f;
        this.$onDismiss = function0;
        this.$containerHeight = f2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceableGroup(414646200);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(414646200, i, -1, "io.adn.sdk.internal.ui.common.design.compose.dragDismissable.<anonymous> (StoreOverlay.kt:205)");
        }
        composer.startReplaceableGroup(-1878729351);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final Animatable animatable = (Animatable) rememberedValue;
        composer.endReplaceableGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float mo630toPx0680j_4 = ((Density) consume).mo630toPx0680j_4(this.$containerHeight);
        float f = mo630toPx0680j_4 * this.$dismissThresholdFraction;
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue2 = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-1878722166);
        boolean changedInstance = composer.changedInstance(animatable);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$dragDismissable$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    IntOffset invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = StoreOverlayKt$dragDismissable$1.invoke$lambda$3$lambda$2(Animatable.this, (Density) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier offset = OffsetKt.offset(composed, (Function1) rememberedValue3);
        Unit unit = Unit.INSTANCE;
        composer.startReplaceableGroup(-1878719282);
        boolean changedInstance2 = composer.changedInstance(animatable) | composer.changed(f) | composer.changed(this.$onDismiss) | composer.changedInstance(coroutineScope) | composer.changed(mo630toPx0680j_4);
        Function0<Unit> function0 = this.$onDismiss;
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = (Function2) new StoreOverlayKt$dragDismissable$1$2$1(animatable, f, function0, coroutineScope, mo630toPx0680j_4, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(offset, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pointerInput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset invoke$lambda$3$lambda$2(Animatable animatable, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.m6508boximpl(IntOffsetKt.IntOffset(0, MathKt.roundToInt(((Number) animatable.getValue()).floatValue())));
    }
}
