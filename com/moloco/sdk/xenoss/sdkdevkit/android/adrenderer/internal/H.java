package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class H extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> {
    public static final int p = 8;
    public final Context h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y j;
    public final InterfaceC3463m k;
    public final CoroutineScope l;
    public final F m;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i n;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a o;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastBannerView$listenToPlayerEvents$1", f = "VastBannerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5795a;
        public /* synthetic */ Object b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super Unit> continuation) {
            return ((a) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = H.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5795a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b;
            if (Intrinsics.areEqual(bVar, b.i.b)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x adShowListener = H.this.getAdShowListener();
                if (adShowListener != null) {
                    adShowListener.a(true);
                }
            } else if (Intrinsics.areEqual(bVar, b.c.b)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x adShowListener2 = H.this.getAdShowListener();
                if (adShowListener2 != null) {
                    adShowListener2.a(false);
                }
            } else if (Intrinsics.areEqual(bVar, b.a.b)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x adShowListener3 = H.this.getAdShowListener();
                if (adShowListener3 != null) {
                    adShowListener3.a();
                }
            } else if (bVar instanceof b.f) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x adShowListener4 = H.this.getAdShowListener();
                if (adShowListener4 != null) {
                    adShowListener4.a(((b.f) bVar).a());
                }
            } else if (!Intrinsics.areEqual(bVar, b.g.b) && !Intrinsics.areEqual(bVar, b.C0533b.b) && !Intrinsics.areEqual(bVar, b.d.b) && !Intrinsics.areEqual(bVar, b.h.b) && !Intrinsics.areEqual(bVar, b.e.b)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y options, InterfaceC3463m externalLinkHandler, CoroutineScope scope, F adLoader) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        this.h = context;
        this.i = customUserEventBuilderService;
        this.j = options;
        this.k = externalLinkHandler;
        this.l = scope;
        this.m = adLoader;
        setTag("MolocoVastBannerView");
        this.n = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f5770a;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        super.destroy();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.o;
        if (aVar != null) {
            aVar.destroy();
        }
        this.o = null;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void k() {
        com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> a2 = getAdLoader().a();
        if (a2 instanceof v.a) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) a2).a();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x adShowListener = getAdShowListener();
            if (adShowListener != null) {
                adShowListener.a(cVar);
                return;
            }
            return;
        }
        if (!(a2 instanceof v.b)) {
            throw new NoWhenBranchMatchedException();
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a a3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) a2).a(), this.k, this.h, this.i, this.j.g(), this.j.e(), this.j.f(), this.j.c(), this.j.d(), this.j.b(), this.j.a());
        this.o = a3;
        setAdView(this.j.h().invoke(this.h, a3));
        o();
        a3.d();
    }

    public final void o() {
        Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> a2;
        Flow onEach;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.o;
        if (aVar == null || (a2 = aVar.a()) == null || (onEach = FlowKt.onEach(a2, new a(null))) == null) {
            return;
        }
        FlowKt.launchIn(onEach, this.l);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public F getAdLoader() {
        return this.m;
    }
}
