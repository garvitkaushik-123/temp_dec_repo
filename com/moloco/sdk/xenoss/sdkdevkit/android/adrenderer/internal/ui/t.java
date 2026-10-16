package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3457g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class t {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButtonKt$LifecycleAwareAdCountdownButton$1$1", f = "LifecycleAwareAdCountdownButton.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6035a;
        public final /* synthetic */ State<UInt> b;
        public final /* synthetic */ State<Function0<Unit>> c;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$a, reason: collision with other inner class name */
        public static final class C0521a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ State<Function0<Unit>> f6036a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0521a(State<? extends Function0<Unit>> state) {
                this.f6036a = state;
            }

            public final Object a(int i, Continuation<? super Unit> continuation) {
                t.b(this.f6036a).invoke();
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((UInt) obj).getData(), continuation);
            }
        }

        public static final class b implements Flow<UInt> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Flow f6037a;

            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$b$a, reason: collision with other inner class name */
            public static final class C0522a<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f6038a;

                @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButtonKt$LifecycleAwareAdCountdownButton$1$1$invokeSuspend$$inlined$filter$1$2", f = "LifecycleAwareAdCountdownButton.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$b$a$a, reason: collision with other inner class name */
                public static final class C0523a extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f6039a;
                    public int b;
                    public Object c;
                    public Object d;

                    public C0523a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6039a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return C0522a.this.emit(null, this);
                    }
                }

                public C0522a(FlowCollector flowCollector) {
                    this.f6038a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    C0523a c0523a;
                    int i;
                    if (continuation instanceof C0523a) {
                        c0523a = (C0523a) continuation;
                        int i2 = c0523a.b;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            c0523a.b = i2 - Integer.MIN_VALUE;
                            Object obj2 = c0523a.f6039a;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = c0523a.b;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.f6038a;
                                if (((UInt) obj).getData() == 0) {
                                    c0523a.b = 1;
                                    if (flowCollector.emit(obj, c0523a) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    c0523a = new C0523a(continuation);
                    Object obj22 = c0523a.f6039a;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c0523a.b;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public b(Flow flow) {
                this.f6037a = flow;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super UInt> flowCollector, Continuation continuation) {
                Object collect = this.f6037a.collect(new C0522a(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(State<UInt> state, State<? extends Function0<Unit>> state2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = state;
            this.c = state2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6035a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final State<UInt> state = this.b;
                b bVar = new b(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return t.a.a(State.this);
                    }
                }));
                C0521a c0521a = new C0521a(this.c);
                this.f6035a = 1;
                if (bVar.collect(c0521a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        public static final UInt a(State state) {
            return UInt.m10330boximpl(t.a(state));
        }
    }

    public static final Unit a(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m mVar, boolean z, boolean z2, Function0 function0, Function0 function02, Function1 function1, Function10 function10, boolean z3, int i, Composer composer, int i2) {
        a(boxScope, mVar, z, z2, function0, function02, function1, function10, z3, composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final Function0<Unit> b(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    public static final void a(final BoxScope boxScope, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<UInt> initialSecondsLeft, final boolean z, final boolean z2, final Function0<Unit> onCountdownFinished, final Function0<Unit> onClick, final Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> basedOnAdCountdownButton, final boolean z3, Composer composer, final int i) {
        int i2;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(initialSecondsLeft, "initialSecondsLeft");
        Intrinsics.checkNotNullParameter(onCountdownFinished, "onCountdownFinished");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(basedOnAdCountdownButton, "basedOnAdCountdownButton");
        Composer startRestartGroup = composer.startRestartGroup(686000336);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(initialSecondsLeft) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z4 = z2;
            i2 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        } else {
            z4 = z2;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(onCountdownFinished) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(onClick) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(onButtonRendered) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(basedOnAdCountdownButton) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            z5 = z3;
            i2 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
        } else {
            z5 = z3;
        }
        if ((38347923 & i2) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(686000336, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButton (LifecycleAwareAdCountdownButton.kt:33)");
            }
            startRestartGroup.startReplaceableGroup(773894976);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1117955184);
            boolean changed = startRestartGroup.changed(initialSecondsLeft);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = C3457g.a(initialSecondsLeft.a().getData(), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle((StateFlow) rememberedValue2, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onCountdownFinished, startRestartGroup, (i2 >> 12) & 14);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1117962924);
            boolean changed2 = startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changed(rememberUpdatedState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new a(collectAsStateWithLifecycle, rememberUpdatedState, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 6);
            int i3 = i2 >> 6;
            basedOnAdCountdownButton.invoke(boxScope, Boolean.valueOf(z4), Boolean.valueOf(z), onClick, onButtonRendered, Boolean.valueOf(z5), initialSecondsLeft.a(), UInt.m10330boximpl(a(collectAsStateWithLifecycle)), startRestartGroup, Integer.valueOf(((i2 << 3) & 234881024) | (i2 & 14) | (i3 & 112) | (i2 & 896) | (i3 & 7168) | (i3 & 57344) | ((i2 >> 9) & 458752)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return t.a(BoxScope.this, initialSecondsLeft, z, z2, onCountdownFinished, onClick, onButtonRendered, basedOnAdCountdownButton, z3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final int a(State<UInt> state) {
        return state.getValue().getData();
    }
}
