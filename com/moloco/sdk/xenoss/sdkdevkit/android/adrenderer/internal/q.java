package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: classes6.dex */
public final class q implements p {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5921a = 0;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object>, SuspendFunction {
        public a(Object obj) {
            super(1, obj, b.class, "loadAndReadyMraid", "loadAndReadyMraid(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
            return ((b) this.receiver).b(continuation);
        }
    }

    public static final class b extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e {
        public final /* synthetic */ MutableStateFlow<Boolean> n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f fVar, MutableStateFlow<Boolean> mutableStateFlow, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.r rVar) {
            super(context, str, rVar, null, null, interfaceC3463m, false, fVar, 88, null);
            this.n = mutableStateFlow;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e
        public void t() {
            super.t();
            this.n.setValue(Boolean.FALSE);
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, b.class, "closeFullscreenAdRepresentation", "closeFullscreenAdRepresentation()V", 0);
        }

        public final void a() {
            ((b) this.receiver).t();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.p
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> a(Context context, CoroutineScope scope, com.moloco.sdk.internal.ortb.model.c bid, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, MutableStateFlow<Boolean> isAdDisplaying, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(isAdDisplaying, "isAdDisplaying");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.h.a(context, scope, z);
        b bVar = new b(context, externalLinkHandler, a2, isAdDisplaying, bid.a(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.r.c);
        return v.a(context, watermark, new s(scope, bid, a.C0463a.f5749a.a(), new a(bVar)), bVar, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k(true, new c(bVar), scope, UInt.m10336constructorimpl(RangesKt.coerceAtLeast(0, 0)), a2.c(), a2.w(), null), MraidActivity.INSTANCE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.p
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> a(Context context, com.moloco.sdk.internal.ortb.model.c bid, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        return J.a(context, bid, a.g.f5755a.b().h(), watermark, null, null, 48, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.p
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adm, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        return B.a(context, customUserEventBuilderService, adm, externalLinkHandler, watermark);
    }
}
