package com.moloco.sdk.internal.services;

import adn.analytics.Analytics;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* loaded from: classes6.dex */
public final class t implements s {
    public static final a c = new a(null);
    public static final int d = 0;
    public static final String e = "ClickthroughService";

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC3463m f5720a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ClickthroughServiceImpl", f = "ClickthroughService.kt", i = {0, 0}, l = {TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER, Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER}, m = "runClickThrough", n = {"this", "clickthroughEvent"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5721a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return t.this.a(null, null, null, null, this);
        }
    }

    public t(InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        this.f5720a = externalLinkHandler;
        this.b = customUserEventBuilderService;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e8, code lost:
    
        if (r1.emit(r3, r8) == r2) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.moloco.sdk.internal.services.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super Unit> continuation) {
        b bVar;
        int i;
        MutableSharedFlow mutableSharedFlow2;
        Object a2;
        t tVar;
        String str2;
        InterfaceC3463m interfaceC3463m;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.e = i2 - Integer.MIN_VALUE;
                b bVar2 = bVar;
                Object obj = bVar2.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bVar2.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis = System.currentTimeMillis();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c cVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f6046a;
                    a.AbstractC0571a.d dVar = new a.AbstractC0571a.d(new a.AbstractC0571a.f(cVar.a(aVar.g()), cVar.a(aVar.h())), new a.AbstractC0571a.f(cVar.a(aVar.i()), cVar.a(aVar.j())), new a.AbstractC0571a.g(cVar.a(aVar.l()), cVar.a(aVar.k())), hVar.q());
                    com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar2 = this.b;
                    bVar2.f5721a = this;
                    mutableSharedFlow2 = mutableSharedFlow;
                    bVar2.b = mutableSharedFlow2;
                    bVar2.e = 1;
                    a2 = aVar2.a(currentTimeMillis, dVar, str, bVar2);
                    if (a2 != coroutine_suspended) {
                        tVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                MutableSharedFlow mutableSharedFlow3 = (MutableSharedFlow) bVar2.b;
                tVar = (t) bVar2.f5721a;
                ResultKt.throwOnFailure(obj);
                a2 = obj;
                mutableSharedFlow2 = mutableSharedFlow3;
                str2 = (String) a2;
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, e, "Launching url: " + str2, false, 4, null);
                interfaceC3463m = tVar.f5720a;
                if (str2 == null) {
                    str2 = "";
                }
                if (interfaceC3463m.a(str2) || mutableSharedFlow2 == null) {
                    return Unit.INSTANCE;
                }
                Unit unit = Unit.INSTANCE;
                bVar2.f5721a = null;
                bVar2.b = null;
                bVar2.e = 2;
            }
        }
        bVar = new b(continuation);
        b bVar22 = bVar;
        Object obj2 = bVar22.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar22.e;
        if (i != 0) {
        }
        str2 = (String) a2;
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, e, "Launching url: " + str2, false, 4, null);
        interfaceC3463m = tVar.f5720a;
        if (str2 == null) {
        }
        if (interfaceC3463m.a(str2)) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.s
    public Object a(String str, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super Unit> continuation) {
        InterfaceC3463m interfaceC3463m = this.f5720a;
        if (str == null) {
            str = "";
        }
        if (interfaceC3463m.a(str) && mutableSharedFlow != null) {
            Unit unit = Unit.INSTANCE;
            Object emit = mutableSharedFlow.emit(unit, continuation);
            return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : unit;
        }
        return Unit.INSTANCE;
    }
}
