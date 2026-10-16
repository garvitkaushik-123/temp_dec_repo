package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class y implements InterfaceC3449b {
    public static final int g = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f6341a;
    public final CoroutineScope b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a c;
    public final String d;
    public final MutableStateFlow<Boolean> e;
    public final StateFlow<Boolean> f;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticAdLoad$load$1", f = "StaticAdLoad.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6342a;
        public final /* synthetic */ long c;
        public final /* synthetic */ InterfaceC3449b.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, InterfaceC3449b.a aVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return y.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6342a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = y.this.c;
                String str = y.this.f6341a;
                long j = this.c;
                this.f6342a = 1;
                obj = aVar.a(str, j, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            if (vVar instanceof v.b) {
                y.this.e.setValue(Boxing.boxBoolean(true));
                InterfaceC3449b.a aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC3449b.a aVar3 = this.d;
                if (aVar3 != null) {
                    aVar3.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public y(String adm, CoroutineScope scope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a staticWebView) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(staticWebView, "staticWebView");
        this.f6341a = adm;
        this.b = scope;
        this.c = staticWebView;
        this.d = "StaticAdLoad";
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.f;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new a(j, aVar, null), 3, null);
    }
}
