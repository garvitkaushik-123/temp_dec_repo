package com.ironsource;

import adn.analytics.Analytics;
import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import com.ironsource.InterfaceC3307t1;
import com.ironsource.sdk.utils.Logger;
import java.util.concurrent.Executors;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* renamed from: com.ironsource.r1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3273r1 {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3662a;
    private static final String b;

    /* renamed from: com.ironsource.r1$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f3663a;
        private final C3230o8.e b;
        private final String c;
        private final JSONObject d;

        public a(String name, C3230o8.e productType, String demandSourceName, JSONObject params) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(demandSourceName, "demandSourceName");
            Intrinsics.checkNotNullParameter(params, "params");
            this.f3663a = name;
            this.b = productType;
            this.c = demandSourceName;
            this.d = params;
        }

        public final String a() {
            return this.f3663a;
        }

        public final C3230o8.e b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final JSONObject d() {
            return this.d;
        }

        public final String e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f3663a, aVar.f3663a) && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d.toString(), aVar.d.toString());
        }

        public final String f() {
            return this.f3663a;
        }

        public final JSONObject g() {
            return this.d;
        }

        public final C3230o8.e h() {
            return this.b;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public final JSONObject i() {
            JSONObject put = new JSONObject(this.d.toString()).put(C3040d4.h.m, this.b).put("demandSourceName", this.c);
            Intrinsics.checkNotNullExpressionValue(put, "JSONObject(params.toStri…eName\", demandSourceName)");
            return put;
        }

        public String toString() {
            return "CallbackResult(name=" + this.f3663a + ", productType=" + this.b + ", demandSourceName=" + this.c + ", params=" + this.d + ")";
        }

        public final a a(String name, C3230o8.e productType, String demandSourceName, JSONObject params) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(demandSourceName, "demandSourceName");
            Intrinsics.checkNotNullParameter(params, "params");
            return new a(name, productType, demandSourceName, params);
        }

        public static /* synthetic */ a a(a aVar, String str, C3230o8.e eVar, String str2, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.f3663a;
            }
            if ((i & 2) != 0) {
                eVar = aVar.b;
            }
            if ((i & 4) != 0) {
                str2 = aVar.c;
            }
            if ((i & 8) != 0) {
                jSONObject = aVar.d;
            }
            return aVar.a(str, eVar, str2, jSONObject);
        }
    }

    /* renamed from: com.ironsource.r1$b */
    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    @DebugMetadata(c = "com.ironsource.sdk.controller.androidSandbox.AndroidSandboxJSHandler$handleAttributionClick$1", f = "AndroidSandboxJSHandler.kt", i = {}, l = {Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.ironsource.r1$c */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f3664a;
        final /* synthetic */ MeasurementManager c;
        final /* synthetic */ Uri d;
        final /* synthetic */ MotionEvent e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MeasurementManager measurementManager, Uri uri, MotionEvent motionEvent, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = measurementManager;
            this.d = uri;
            this.e = motionEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3273r1.this.new c(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3664a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C3273r1 c3273r1 = C3273r1.this;
                MeasurementManager measurementManager = this.c;
                Uri uri = this.d;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                MotionEvent motionEvent = this.e;
                this.f3664a = 1;
                if (c3273r1.a(measurementManager, uri, motionEvent, this) == coroutine_suspended) {
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
    }

    @DebugMetadata(c = "com.ironsource.sdk.controller.androidSandbox.AndroidSandboxJSHandler$handleAttributionImpression$1", f = "AndroidSandboxJSHandler.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.ironsource.r1$d */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f3665a;
        final /* synthetic */ MeasurementManager c;
        final /* synthetic */ Uri d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MeasurementManager measurementManager, Uri uri, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = measurementManager;
            this.d = uri;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3273r1.this.new d(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3665a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C3273r1 c3273r1 = C3273r1.this;
                MeasurementManager measurementManager = this.c;
                Uri uri = this.d;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                this.f3665a = 1;
                if (c3273r1.a(measurementManager, uri, null, this) == coroutine_suspended) {
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
    }

    static {
        b bVar = new b(null);
        f3662a = bVar;
        String name = bVar.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "this::class.java.name");
        b = name;
    }

    public final a a(Context context, InterfaceC3307t1 message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof InterfaceC3307t1.a) {
            return a(context, (InterfaceC3307t1.a) message);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final a a(Context context, InterfaceC3307t1.a aVar) {
        MeasurementManager a2 = C3137j0.a(context);
        if (a2 == null) {
            Logger.i(b, "could not obtain measurement manager");
            return a(aVar, "could not obtain measurement manager");
        }
        try {
            if (aVar instanceof InterfaceC3307t1.a.b) {
                return a(aVar, a2);
            }
            if (aVar instanceof InterfaceC3307t1.a.C0307a) {
                return a((InterfaceC3307t1.a.C0307a) aVar, a2);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            C3260q4.d().a(e);
            return a(aVar, "failed to handle attribution, message: " + e.getMessage());
        }
    }

    private final a a(InterfaceC3307t1.a aVar, MeasurementManager measurementManager) {
        BuildersKt__BuildersKt.runBlocking$default(null, new d(measurementManager, Uri.parse(aVar.b()), null), 1, null);
        return a(aVar);
    }

    private final a a(InterfaceC3307t1.a.C0307a c0307a, MeasurementManager measurementManager) {
        Uri parse = Uri.parse(c0307a.b());
        long uptimeMillis = SystemClock.uptimeMillis();
        BuildersKt__BuildersKt.runBlocking$default(null, new c(measurementManager, parse, MotionEvent.obtain(uptimeMillis, uptimeMillis, c0307a.n(), c0307a.o().c(), c0307a.o().d(), c0307a.p()), null), 1, null);
        return a(c0307a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(MeasurementManager measurementManager, Uri uri, MotionEvent motionEvent, Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        measurementManager.registerSource(uri, motionEvent, Executors.newSingleThreadExecutor(), C3290s1.a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    private final a a(InterfaceC3307t1.a aVar) {
        JSONObject params = new JSONObject().put("params", new JSONObject().put("type", aVar instanceof InterfaceC3307t1.a.C0307a ? "click" : "impression"));
        String a2 = aVar.a();
        C3230o8.e d2 = aVar.d();
        String e = aVar.e();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        return new a(a2, d2, e, params);
    }

    private final a a(InterfaceC3307t1 interfaceC3307t1, String str) {
        JSONObject put = new JSONObject().put("reason", str).put("type", interfaceC3307t1 instanceof InterfaceC3307t1.a.C0307a ? "click" : "impression");
        String c2 = interfaceC3307t1.c();
        C3230o8.e d2 = interfaceC3307t1.d();
        String e = interfaceC3307t1.e();
        JSONObject put2 = new JSONObject().put("params", put);
        Intrinsics.checkNotNullExpressionValue(put2, "JSONObject().put(\"params\", payload)");
        return new a(c2, d2, e, put2);
    }
}
