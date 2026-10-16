package io.adn.sdk.internal.ui.common.lifecycle;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: LifecycleCountdown.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\f\u0010\u000b\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002"}, d2 = {"LifecycleCountdown", "", "state", "Lio/adn/sdk/internal/ui/common/lifecycle/LifecycleCountdownState;", "(Lio/adn/sdk/internal/ui/common/lifecycle/LifecycleCountdownState;Landroidx/compose/runtime/Composer;I)V", "rememberLifecycleCountdownState", "initialTimeLeft", "", "timeInterval", "(JJLandroidx/compose/runtime/Composer;I)Lio/adn/sdk/internal/ui/common/lifecycle/LifecycleCountdownState;", "adn-sdk_release", "countdownJob", "Lkotlinx/coroutines/Job;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LifecycleCountdownKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LifecycleCountdown$lambda$9(LifecycleCountdownState lifecycleCountdownState, int i, Composer composer, int i2) {
        LifecycleCountdown(lifecycleCountdownState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LifecycleCountdown(final LifecycleCountdownState state, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(-1328033127);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1328033127, i2, -1, "io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdown (LifecycleCountdown.kt:17)");
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2020435545);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2020424611);
            boolean changedInstance = ((i2 & 14) == 4) | startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit LifecycleCountdown$lambda$4$lambda$3;
                        LifecycleCountdown$lambda$4$lambda$3 = LifecycleCountdownKt.LifecycleCountdown$lambda$4$lambda$3(CoroutineScope.this, mutableState, state);
                        return LifecycleCountdown$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function0 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2020423072);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit LifecycleCountdown$lambda$6$lambda$5;
                        LifecycleCountdown$lambda$6$lambda$5 = LifecycleCountdownKt.LifecycleCountdown$lambda$6$lambda$5(MutableState.this);
                        return LifecycleCountdown$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function02 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2020421536);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit LifecycleCountdown$lambda$8$lambda$7;
                        LifecycleCountdown$lambda$8$lambda$7 = LifecycleCountdownKt.LifecycleCountdown$lambda$8$lambda$7(MutableState.this);
                        return LifecycleCountdown$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            BindWithLifecycleKt.ObserveLifecycle(function0, function02, (Function0) rememberedValue5, startRestartGroup, 432);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LifecycleCountdown$lambda$9;
                    LifecycleCountdown$lambda$9 = LifecycleCountdownKt.LifecycleCountdown$lambda$9(LifecycleCountdownState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LifecycleCountdown$lambda$9;
                }
            });
        }
    }

    private static final Job LifecycleCountdown$lambda$1(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    private static final void LifecycleCountdown$startCountdownJob(CoroutineScope coroutineScope, MutableState<Job> mutableState, LifecycleCountdownState lifecycleCountdownState) {
        Job launch$default;
        Job LifecycleCountdown$lambda$1 = LifecycleCountdown$lambda$1(mutableState);
        if (LifecycleCountdown$lambda$1 != null) {
            Job.DefaultImpls.cancel$default(LifecycleCountdown$lambda$1, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1(lifecycleCountdownState, null), 3, null);
        mutableState.setValue(launch$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LifecycleCountdown$lambda$4$lambda$3(CoroutineScope coroutineScope, MutableState mutableState, LifecycleCountdownState lifecycleCountdownState) {
        LifecycleCountdown$startCountdownJob(coroutineScope, mutableState, lifecycleCountdownState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LifecycleCountdown$lambda$6$lambda$5(MutableState mutableState) {
        Job LifecycleCountdown$lambda$1 = LifecycleCountdown$lambda$1(mutableState);
        if (LifecycleCountdown$lambda$1 != null) {
            Job.DefaultImpls.cancel$default(LifecycleCountdown$lambda$1, (CancellationException) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LifecycleCountdown$lambda$8$lambda$7(MutableState mutableState) {
        Job LifecycleCountdown$lambda$1 = LifecycleCountdown$lambda$1(mutableState);
        if (LifecycleCountdown$lambda$1 != null) {
            Job.DefaultImpls.cancel$default(LifecycleCountdown$lambda$1, (CancellationException) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static final LifecycleCountdownState rememberLifecycleCountdownState(final long j, final long j2, Composer composer, int i) {
        composer.startReplaceableGroup(282948155);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(282948155, i, -1, "io.adn.sdk.internal.ui.common.lifecycle.rememberLifecycleCountdownState (LifecycleCountdown.kt:39)");
        }
        Object[] objArr = new Object[0];
        Saver<LifecycleCountdownState, Object> saver = LifecycleCountdownState.INSTANCE.getSaver();
        composer.startReplaceableGroup(68328056);
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(j)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(j2)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    LifecycleCountdownState rememberLifecycleCountdownState$lambda$11$lambda$10;
                    rememberLifecycleCountdownState$lambda$11$lambda$10 = LifecycleCountdownKt.rememberLifecycleCountdownState$lambda$11$lambda$10(j, j2);
                    return rememberLifecycleCountdownState$lambda$11$lambda$10;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LifecycleCountdownState lifecycleCountdownState = (LifecycleCountdownState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lifecycleCountdownState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleCountdownState rememberLifecycleCountdownState$lambda$11$lambda$10(long j, long j2) {
        return new LifecycleCountdownState(j, j2);
    }
}
