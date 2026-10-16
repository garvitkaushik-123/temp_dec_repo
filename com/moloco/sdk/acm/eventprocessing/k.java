package com.moloco.sdk.acm.eventprocessing;

import io.ktor.http.HeadersBuilder;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k implements j {

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.http.e f5338a;
    public final com.moloco.sdk.acm.db.d b;
    public final f c;
    public final Function1<HeadersBuilder, Unit> d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestAndPurgeDBImpl", f = "RequestAndPurgeDB.kt", i = {0, 1}, l = {38, 48}, m = "invoke-IoAF18A", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5339a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            Object a2 = k.this.a(this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(com.moloco.sdk.acm.http.e metricsRequest, com.moloco.sdk.acm.db.d metricsDAO, f dataAgeChecker, Function1<? super HeadersBuilder, Unit> headers) {
        Intrinsics.checkNotNullParameter(metricsRequest, "metricsRequest");
        Intrinsics.checkNotNullParameter(metricsDAO, "metricsDAO");
        Intrinsics.checkNotNullParameter(dataAgeChecker, "dataAgeChecker");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f5338a = metricsRequest;
        this.b = metricsDAO;
        this.c = dataAgeChecker;
        this.d = headers;
        this.e = "RequestAndPurgeDB";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.moloco.sdk.acm.eventprocessing.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Continuation<? super Result<String>> continuation) {
        a aVar;
        Object coroutine_suspended;
        int i;
        k kVar;
        com.moloco.sdk.acm.http.d a2;
        Object a3;
        k kVar2;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.d = i2 - Integer.MIN_VALUE;
                Object obj = aVar.b;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.acm.db.d dVar = this.b;
                    aVar.f5339a = this;
                    aVar.d = 1;
                    obj = dVar.a(aVar);
                    if (obj != coroutine_suspended) {
                        kVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kVar2 = (k) aVar.f5339a;
                    ResultKt.throwOnFailure(obj);
                    a3 = ((Result) obj).getValue();
                    if (Result.m10248isSuccessimpl(a3)) {
                        com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f5359a, kVar2.e, "Request Success", false, 4, null);
                    }
                    m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a3);
                    if (m10244exceptionOrNullimpl != null) {
                        com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, kVar2.e, "Request failure: " + m10244exceptionOrNullimpl.getMessage(), null, false, 12, null);
                    }
                    return a3;
                }
                kVar = (k) aVar.f5339a;
                ResultKt.throwOnFailure(obj);
                List<com.moloco.sdk.acm.db.b> list = (List) obj;
                com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f5359a, kVar.e, list.size() + " events processed.", false, 4, null);
                a2 = new b(kVar.c).a(list);
                if (!a2.a().isEmpty() && a2.b().isEmpty()) {
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m10241constructorimpl("No metrics to process");
                }
                com.moloco.sdk.acm.http.e eVar = kVar.f5338a;
                Function1<HeadersBuilder, Unit> function1 = kVar.d;
                aVar.f5339a = kVar;
                aVar.d = 2;
                a3 = eVar.a(a2, function1, aVar);
                if (a3 != coroutine_suspended) {
                    kVar2 = kVar;
                    if (Result.m10248isSuccessimpl(a3)) {
                    }
                    m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a3);
                    if (m10244exceptionOrNullimpl != null) {
                    }
                    return a3;
                }
                return coroutine_suspended;
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.b;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.d;
        if (i != 0) {
        }
        List<com.moloco.sdk.acm.db.b> list2 = (List) obj2;
        com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f5359a, kVar.e, list2.size() + " events processed.", false, 4, null);
        a2 = new b(kVar.c).a(list2);
        if (!a2.a().isEmpty()) {
        }
        com.moloco.sdk.acm.http.e eVar2 = kVar.f5338a;
        Function1<HeadersBuilder, Unit> function12 = kVar.d;
        aVar.f5339a = kVar;
        aVar.d = 2;
        a3 = eVar2.a(a2, function12, aVar);
        if (a3 != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
