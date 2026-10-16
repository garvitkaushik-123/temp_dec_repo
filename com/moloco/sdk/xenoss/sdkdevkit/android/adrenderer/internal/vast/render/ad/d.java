package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final StateFlow<k> f6167a;
    public final MutableStateFlow<d.a> b;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdGoNextActionImpl$1", f = "AdGoNextAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<k, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6168a;
        public /* synthetic */ Object b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(k kVar, Continuation<? super Unit> continuation) {
            return ((a) create(kVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6168a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            k kVar = (k) this.b;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d a2 = kVar instanceof k.a ? ((k.a) kVar).a() : kVar instanceof k.b ? ((k.b) kVar).a() : null;
            if (a2 == null) {
                return Unit.INSTANCE;
            }
            a2.reset();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(StateFlow<? extends k> currentPlaylistItem, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(currentPlaylistItem, "currentPlaylistItem");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f6167a = currentPlaylistItem;
        FlowKt.stateIn(FlowKt.onEach(currentPlaylistItem, new a(null)), scope, SharingStarted.INSTANCE.getEagerly(), null);
        this.b = StateFlowKt.MutableStateFlow(d.a.c.b);
    }

    @Deprecated(message = "TODO. https://mlc.atlassian.net/browse/SDK-1385")
    public static /* synthetic */ void f() {
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> m() {
        k value = this.f6167a.getValue();
        if (value instanceof k.a) {
            return ((k.a) value).a().m();
        }
        if (value instanceof k.b) {
            return ((k.b) value).a().m();
        }
        if (value instanceof k.c) {
            return ((k.c) value).a().m();
        }
        if (value instanceof k.d) {
            return ((k.d) value).a().m();
        }
        if (value == null) {
            return this.b;
        }
        throw new NoWhenBranchMatchedException();
    }
}
