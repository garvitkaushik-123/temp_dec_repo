package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.widget.FrameLayout;
import com.moloco.sdk.service_locator.a;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class t extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> {
    public static final int n = 8;
    public final Context h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d j;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i k;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m l;
    public final s m;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object>, SuspendFunction {
        public a(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m.class, "loadAndReadyMraid", "loadAndReadyMraid(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
            return ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m) this.receiver).b(continuation);
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(Object obj) {
            super(0, obj, t.class, "detachMraidViewFromAdViewWrapper", "detachMraidViewFromAdViewWrapper()V", 0);
        }

        public final void a() {
            ((t) this.receiver).q();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, t.class, "attachMraidViewToAdViewWrapper", "attachMraidViewToAdViewWrapper()V", 0);
        }

        public final void a() {
            ((t) this.receiver).o();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ t(Context context, String str, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d dVar, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, interfaceC3463m, zVar, (i & 16) != 0 ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d() : dVar, coroutineScope);
    }

    public static final Unit c(t tVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e adShowListener = tVar.getAdShowListener();
        if (adShowListener != null) {
            adShowListener.a();
        }
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        super.destroy();
        this.l.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void k() {
        FrameLayout a2 = this.j.a(this.h, this.l.c());
        this.i.a(a2);
        setAdView(a2);
    }

    public final void o() {
        k();
    }

    public final void q() {
        setAdView(null);
    }

    public static final Unit a(t tVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e adShowListener = tVar.getAdShowListener();
        if (adShowListener != null) {
            adShowListener.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.a(it));
        }
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public s getAdLoader() {
        return this.m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, String adm, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d webViewWrapper, CoroutineScope scope) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(webViewWrapper, "webViewWrapper");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.h = context;
        this.i = watermark;
        this.j = webViewWrapper;
        setTag("MolocoMraidBannerView");
        this.k = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m mVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m(context, adm, new b(this), new c(this), new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return t.c(t.this);
            }
        }, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return t.a(t.this, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) obj);
            }
        }, true, externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.h.a(context, scope, false), null, 512, null);
        this.l = mVar;
        this.m = new s(scope, null, a.C0463a.f5749a.a(), new a(mVar));
    }
}
