package io.adn.sdk.internal.ui.common.lifecycle;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BindWithLifecycle.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a7\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002²\u0006\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002"}, d2 = {"ObserveLifecycle", "", "onForeground", "Lkotlin/Function0;", "onBackground", "onDispose", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release", "foregroundCallback", "backgroundCallback", "disposeCallback"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BindWithLifecycleKt {

    /* compiled from: BindWithLifecycle.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveLifecycle$lambda$7(Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        ObserveLifecycle(function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ObserveLifecycle(final Function0<Unit> onForeground, final Function0<Unit> onBackground, final Function0<Unit> onDispose, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onForeground, "onForeground");
        Intrinsics.checkNotNullParameter(onBackground, "onBackground");
        Intrinsics.checkNotNullParameter(onDispose, "onDispose");
        Composer startRestartGroup = composer.startRestartGroup(-422001702);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onForeground) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackground) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onDispose) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-422001702, i2, -1, "io.adn.sdk.internal.ui.common.lifecycle.ObserveLifecycle (BindWithLifecycle.kt:15)");
            }
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(consume, startRestartGroup, 0);
            final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onForeground, startRestartGroup, i2 & 14);
            final State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onBackground, startRestartGroup, (i2 >> 3) & 14);
            final State rememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(onDispose, startRestartGroup, (i2 >> 6) & 14);
            Object value = rememberUpdatedState.getValue();
            startRestartGroup.startReplaceableGroup(693779788);
            boolean changed = startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changed(rememberUpdatedState3) | startRestartGroup.changed(rememberUpdatedState4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: io.adn.sdk.internal.ui.common.lifecycle.BindWithLifecycleKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ObserveLifecycle$lambda$6$lambda$5;
                        ObserveLifecycle$lambda$6$lambda$5 = BindWithLifecycleKt.ObserveLifecycle$lambda$6$lambda$5(State.this, rememberUpdatedState2, rememberUpdatedState3, rememberUpdatedState4, (DisposableEffectScope) obj);
                        return ObserveLifecycle$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(value, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.lifecycle.BindWithLifecycleKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ObserveLifecycle$lambda$7;
                    ObserveLifecycle$lambda$7 = BindWithLifecycleKt.ObserveLifecycle$lambda$7(Function0.this, onBackground, onDispose, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ObserveLifecycle$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ObserveLifecycle$lambda$6$lambda$5(State state, final State state2, final State state3, final State state4, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final Lifecycle lifecycle = ((LifecycleOwner) state.getValue()).getLifecycle();
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: io.adn.sdk.internal.ui.common.lifecycle.BindWithLifecycleKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                BindWithLifecycleKt.ObserveLifecycle$lambda$6$lambda$5$lambda$3(State.this, state3, lifecycleOwner, event);
            }
        };
        lifecycle.addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: io.adn.sdk.internal.ui.common.lifecycle.BindWithLifecycleKt$ObserveLifecycle$lambda$6$lambda$5$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Function0 ObserveLifecycle$lambda$2;
                Lifecycle.this.removeObserver(lifecycleEventObserver);
                ObserveLifecycle$lambda$2 = BindWithLifecycleKt.ObserveLifecycle$lambda$2(state4);
                ObserveLifecycle$lambda$2.invoke();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ObserveLifecycle$lambda$6$lambda$5$lambda$3(State state, State state2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            ObserveLifecycle$lambda$0(state).invoke();
        } else {
            if (i != 2) {
                return;
            }
            ObserveLifecycle$lambda$1(state2).invoke();
        }
    }

    private static final Function0<Unit> ObserveLifecycle$lambda$0(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    private static final Function0<Unit> ObserveLifecycle$lambda$1(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> ObserveLifecycle$lambda$2(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }
}
