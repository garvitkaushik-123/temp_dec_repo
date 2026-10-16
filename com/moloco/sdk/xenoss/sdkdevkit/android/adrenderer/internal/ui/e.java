package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class e {

    public static final class a implements Function2<Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BoxScope f6005a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i b;
        public final /* synthetic */ Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> c;
        public final /* synthetic */ boolean d;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0515a extends FunctionReferenceImpl implements Function0<Unit> {
            public C0515a(Object obj) {
                super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "goNextAdPartOrDismissAd", "goNextAdPartOrDismissAd()V", 0);
            }

            public final void a() {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).y();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<a.AbstractC0571a.c, Unit> {
            public b(Object obj) {
                super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
            }

            public final void a(a.AbstractC0571a.c p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).a(p0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a.AbstractC0571a.c cVar) {
                a(cVar);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, boolean z) {
            this.f6005a = boxScope;
            this.b = iVar;
            this.c = function10;
            this.d = z;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(504986716, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButton.<anonymous>.<anonymous> (AdGoNextButton.kt:47)");
            }
            BoxScope boxScope = this.f6005a;
            StateFlow<d.a> m = this.b.m();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar = this.b;
            composer.startReplaceableGroup(328179957);
            boolean changed = composer.changed(iVar);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new C0515a(iVar);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Function0 function0 = (Function0) ((KFunction) rememberedValue);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar2 = this.b;
            composer.startReplaceableGroup(328181678);
            boolean changed2 = composer.changed(iVar2);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new b(iVar2);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            e.a(boxScope, m, (Function0<Unit>) function0, (Function1<? super a.AbstractC0571a.c, Unit>) ((KFunction) rememberedValue2), this.c, this.d, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButtonKt$GoNextButton$1$1", f = "AdGoNextButton.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6006a;
        public final /* synthetic */ State<d.a> b;
        public final /* synthetic */ MutableState<Integer> c;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MutableState<Integer> f6007a;

            public a(MutableState<Integer> mutableState) {
                this.f6007a = mutableState;
            }

            public final Object a(int i, Continuation<? super Unit> continuation) {
                e.a(this.f6007a, i);
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).intValue(), continuation);
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$b$b, reason: collision with other inner class name */
        public static final class C0516b implements Flow<Integer> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Flow f6008a;

            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$b$b$a */
            public static final class a<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FlowCollector f6009a;

                @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButtonKt$GoNextButton$1$1$invokeSuspend$$inlined$filter$1$2", f = "AdGoNextButton.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$b$b$a$a, reason: collision with other inner class name */
                public static final class C0517a extends ContinuationImpl {

                    /* renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f6010a;
                    public int b;
                    public Object c;
                    public Object d;

                    public C0517a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6010a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(FlowCollector flowCollector) {
                    this.f6009a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    C0517a c0517a;
                    int i;
                    if (continuation instanceof C0517a) {
                        c0517a = (C0517a) continuation;
                        int i2 = c0517a.b;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            c0517a.b = i2 - Integer.MIN_VALUE;
                            Object obj2 = c0517a.f6010a;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = c0517a.b;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.f6009a;
                                if (((Number) obj).intValue() > 0) {
                                    c0517a.b = 1;
                                    if (flowCollector.emit(obj, c0517a) == coroutine_suspended) {
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
                    c0517a = new C0517a(continuation);
                    Object obj22 = c0517a.f6010a;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c0517a.b;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public C0516b(Flow flow) {
                this.f6008a = flow;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                Object collect = this.f6008a.collect(new a(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(State<? extends d.a> state, MutableState<Integer> mutableState, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = state;
            this.c = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6006a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final State<d.a> state = this.b;
                Flow take = FlowKt.take(new C0516b(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$b$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(e.b.a(State.this));
                    }
                })), 1);
                a aVar = new a(this.c);
                this.f6006a = 1;
                if (take.collect(aVar, this) == coroutine_suspended) {
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

        public static final int a(State state) {
            d.a a2 = e.a((State<? extends d.a>) state);
            d.a.b bVar = a2 instanceof d.a.b ? (d.a.b) a2 : null;
            if (bVar != null) {
                return bVar.b();
            }
            return 0;
        }
    }

    public static final Unit a(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, i.a aVar, Function10 function10, Function10 function102, int i, Composer composer, int i2) {
        a(boxScope, iVar, aVar, function10, function102, composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final Unit a(BoxScope boxScope, StateFlow stateFlow, Function0 function0, Function1 function1, Function10 function10, boolean z, int i, Composer composer, int i2) {
        a(boxScope, (StateFlow<? extends d.a>) stateFlow, (Function0<Unit>) function0, (Function1<? super a.AbstractC0571a.c, Unit>) function1, (Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>) function10, z, composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final void a(final BoxScope boxScope, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, final i.a aVar, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function102, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        Composer startRestartGroup = composer.startRestartGroup(1217166503);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(adViewModel) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(aVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(function10) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(function102) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217166503, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButton (AdGoNextButton.kt:27)");
            }
            Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function103 = null;
            Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.a()) : null;
            if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                function103 = function102;
            } else if (Intrinsics.areEqual(valueOf, Boolean.FALSE)) {
                function103 = function10;
            } else if (valueOf != null) {
                throw new NoWhenBranchMatchedException();
            }
            boolean z = aVar instanceof i.a.C0539a;
            boolean z2 = (z || (aVar instanceof i.a.b) || !(aVar instanceof i.a.c)) ? false : true;
            if (function103 != null) {
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 504986716, true, new a(boxScope, adViewModel, function103, z2));
                if (z) {
                    startRestartGroup.startReplaceableGroup(-1024214432);
                    composableLambda.invoke(startRestartGroup, 6);
                    startRestartGroup.endReplaceableGroup();
                } else if (aVar instanceof i.a.b) {
                    startRestartGroup.startReplaceableGroup(-1024212640);
                    composableLambda.invoke(startRestartGroup, 6);
                    startRestartGroup.endReplaceableGroup();
                } else if (aVar instanceof i.a.c) {
                    startRestartGroup.startReplaceableGroup(-1024210752);
                    composableLambda.invoke(startRestartGroup, 6);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-1685727487);
                    startRestartGroup.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return e.a(BoxScope.this, adViewModel, aVar, function10, function102, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(final BoxScope boxScope, final StateFlow<? extends d.a> stateFlow, final Function0<Unit> function0, final Function1<? super a.AbstractC0571a.c, Unit> function1, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, final boolean z, Composer composer, final int i) {
        BoxScope boxScope2;
        int i2;
        Function0<Unit> function02;
        Function1<? super a.AbstractC0571a.c, Unit> function12;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function102;
        Composer startRestartGroup = composer.startRestartGroup(12332512);
        if ((i & 6) == 0) {
            boxScope2 = boxScope;
            i2 = (startRestartGroup.changed(boxScope2) ? 4 : 2) | i;
        } else {
            boxScope2 = boxScope;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(stateFlow) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function02 = function0;
            i2 |= startRestartGroup.changed(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        if ((i & 3072) == 0) {
            function12 = function1;
            i2 |= startRestartGroup.changed(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        if ((i & 24576) == 0) {
            function102 = function10;
            i2 |= startRestartGroup.changed(function102) ? 16384 : 8192;
        } else {
            function102 = function10;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(12332512, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.GoNextButton (AdGoNextButton.kt:76)");
            }
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(stateFlow, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, (i2 >> 3) & 14, 7);
            startRestartGroup.startReplaceableGroup(-2101091474);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(-2101089382);
            boolean changed = startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new b(collectAsStateWithLifecycle, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
            int m10336constructorimpl = UInt.m10336constructorimpl(a((MutableState<Integer>) mutableState));
            d.a a2 = a((State<? extends d.a>) collectAsStateWithLifecycle);
            d.a.b bVar = a2 instanceof d.a.b ? (d.a.b) a2 : null;
            int m10336constructorimpl2 = UInt.m10336constructorimpl(bVar != null ? bVar.b() : 0);
            Boolean valueOf = Boolean.valueOf(a((State<? extends d.a>) collectAsStateWithLifecycle) instanceof d.a.C0557a);
            Boolean valueOf2 = Boolean.valueOf(!(a((State<? extends d.a>) collectAsStateWithLifecycle) instanceof d.a.c));
            Boolean valueOf3 = Boolean.valueOf(z);
            UInt m10330boximpl = UInt.m10330boximpl(m10336constructorimpl);
            UInt m10330boximpl2 = UInt.m10330boximpl(m10336constructorimpl2);
            int i3 = i2 << 3;
            function102.invoke(boxScope2, valueOf, valueOf2, function02, function12, valueOf3, m10330boximpl, m10330boximpl2, startRestartGroup, Integer.valueOf((i2 & 14) | (i3 & 7168) | (i3 & 57344) | (458752 & i2) | ((i2 << 12) & 234881024)));
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return e.a(BoxScope.this, stateFlow, function0, function1, function10, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    public static final d.a a(State<? extends d.a> state) {
        return state.getValue();
    }

    public static final int a(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }
}
