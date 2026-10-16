package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.I;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class I implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5796a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i c;
    public final CoroutineScope d;
    public final F e;
    public final MutableStateFlow<Boolean> f;
    public final StateFlow<Boolean> g;
    public final MutableStateFlow<Boolean> h;
    public final StateFlow<Boolean> i;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastFullscreenAdImpl$show$1", f = "VastFullscreenAd.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5797a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y d;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.I$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0469a extends FunctionReferenceImpl implements Function0<Unit> {
            public C0469a(Object obj) {
                super(0, obj, I.class, "onClose", "onClose()V", 0);
            }

            public final void a() {
                ((I) this.receiver).o();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y yVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = xVar;
            this.d = yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return I.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5797a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> a2 = I.this.e.a();
                if (a2 instanceof v.a) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) a2).a();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar = this.c;
                    if (xVar != null) {
                        xVar.a(cVar);
                    }
                    return Unit.INSTANCE;
                }
                if (!(a2 instanceof v.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) a2).a();
                if (!aVar2.j().j().exists()) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastFullscreenAdImpl", "VAST ad media file does not exist", null, false, 12, null);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar2 = this.c;
                    if (xVar2 != null) {
                        xVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l.d);
                    }
                    return Unit.INSTANCE;
                }
                try {
                    VastActivity.Companion companion = VastActivity.INSTANCE;
                    Context context = I.this.f5796a;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y yVar = this.d;
                    C0469a c0469a = new C0469a(I.this);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar = I.this.b;
                    final I i2 = I.this;
                    final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar3 = this.c;
                    Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.I$a$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return I.a.a(I.this, xVar3, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) obj2);
                        }
                    };
                    this.f5797a = 1;
                    aVar = this;
                    try {
                        if (companion.a(aVar2, context, yVar, c0469a, zVar, function1, aVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        I.this.f.setValue(Boxing.boxBoolean(false));
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    aVar = this;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    ResultKt.throwOnFailure(obj);
                    aVar = this;
                } catch (Throwable th4) {
                    th = th4;
                    aVar = this;
                    I.this.f.setValue(Boxing.boxBoolean(false));
                    throw th;
                }
            }
            I.this.f.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }

        public static final Unit a(I i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            i.a(bVar, xVar);
            return Unit.INSTANCE;
        }
    }

    public I(Context context, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, InterfaceC3460j decLoader, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        this.f5796a = context;
        this.b = watermark;
        this.c = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f5770a;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.d = CoroutineScope;
        this.e = new F(bid, CoroutineScope, loadVast, decLoader, z);
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.f = MutableStateFlow;
        this.g = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.h = MutableStateFlow2;
        this.i = MutableStateFlow2;
    }

    public static Object f(I i) {
        return Reflection.property0(new PropertyReference0Impl(i.e, F.class, "isLoaded", "isLoaded()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.h.setValue(Boolean.TRUE);
        this.f.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.e.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    public StateFlow<Boolean> k() {
        return this.i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return this.g;
    }

    public final void q() {
        this.f.setValue(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        this.e.a(j, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar) {
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(xVar, options, null), 3, null);
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar) {
        if (Intrinsics.areEqual(bVar, b.g.b)) {
            q();
            return;
        }
        if (Intrinsics.areEqual(bVar, b.C0533b.b)) {
            q();
            return;
        }
        if (Intrinsics.areEqual(bVar, b.d.b)) {
            q();
            return;
        }
        if (Intrinsics.areEqual(bVar, b.i.b)) {
            if (xVar != null) {
                xVar.a(true);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(bVar, b.c.b)) {
            if (xVar != null) {
                xVar.a(false);
            }
        } else if (Intrinsics.areEqual(bVar, b.a.b)) {
            if (xVar != null) {
                xVar.a();
            }
        } else if (bVar instanceof b.f) {
            if (xVar != null) {
                xVar.a(((b.f) bVar).a());
            }
        } else if (!Intrinsics.areEqual(bVar, b.h.b) && !Intrinsics.areEqual(bVar, b.e.b)) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
