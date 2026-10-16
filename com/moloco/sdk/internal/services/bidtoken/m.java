package com.moloco.sdk.internal.services.bidtoken;

import com.ironsource.C3250pb;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public final class m implements l {
    public static final int e = 8;

    /* renamed from: a, reason: collision with root package name */
    public final y f5638a;
    public final q b;
    public final String c;
    public final Mutex d;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenServiceImpl", f = "BidTokenService.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 53, 60}, m = "bidToken", n = {"this", "metricsRecorder", "$this$withLock_u24default$iv", "this", "metricsRecorder", "$this$withLock_u24default$iv", "bidTokenTimer", "this", "metricsRecorder", "$this$withLock_u24default$iv", "bidTokenTimer", "serverBidToken"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5639a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return m.this.a(null, this);
        }
    }

    public m(y serverBidTokenService, q clientBidTokenService) {
        Intrinsics.checkNotNullParameter(serverBidTokenService, "serverBidTokenService");
        Intrinsics.checkNotNullParameter(clientBidTokenService, "clientBidTokenService");
        this.f5638a = serverBidTokenService;
        this.b = clientBidTokenService;
        this.c = "BidTokenServiceImpl";
        this.d = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0100 A[Catch: all -> 0x0051, TryCatch #1 {all -> 0x0051, blocks: (B:13:0x0046, B:14:0x00f1, B:17:0x00f8, B:19:0x0100, B:21:0x0131, B:26:0x0112), top: B:12:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0112 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #1 {all -> 0x0051, blocks: (B:13:0x0046, B:14:0x00f1, B:17:0x00f8, B:19:0x0100, B:21:0x0131, B:26:0x0112), top: B:12:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:36:0x006c, B:37:0x00c4, B:39:0x00d0), top: B:35:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.moloco.sdk.internal.services.bidtoken.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(MetricsRecorder metricsRecorder, Continuation<? super String> continuation) {
        a aVar;
        Object coroutine_suspended;
        int i;
        MetricsRecorder metricsRecorder2;
        Mutex mutex;
        m mVar;
        Mutex mutex2;
        Object a2;
        TimerEvent timerEvent;
        Mutex mutex3;
        MetricsRecorder metricsRecorder3;
        String d;
        String str;
        Object a3;
        MetricsRecorder metricsRecorder4;
        m mVar2;
        String str2;
        String str3;
        try {
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i2 = aVar.h;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    aVar.h = i2 - Integer.MIN_VALUE;
                    Object obj = aVar.f;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = aVar.h;
                    String str4 = "";
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex4 = this.d;
                        aVar.f5639a = this;
                        metricsRecorder2 = metricsRecorder;
                        aVar.b = metricsRecorder2;
                        aVar.c = mutex4;
                        aVar.h = 1;
                        if (mutex4.lock(null, aVar) != coroutine_suspended) {
                            mutex = mutex4;
                            mVar = this;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            str2 = (String) aVar.e;
                            timerEvent = (TimerEvent) aVar.d;
                            mutex2 = (Mutex) aVar.c;
                            metricsRecorder4 = (MetricsRecorder) aVar.b;
                            mVar2 = (m) aVar.f5639a;
                            try {
                                ResultKt.throwOnFailure(obj);
                                a3 = ((Result) obj).getValue();
                                if (Result.m10247isFailureimpl(a3)) {
                                    a3 = "";
                                }
                                str3 = (String) a3;
                                if (str3.length() != 0) {
                                    MolocoLogger.error$default(MolocoLogger.INSTANCE, mVar2.c, "CBT has error", null, false, 12, null);
                                    str = "client";
                                } else {
                                    str4 = str2 + AbstractJsonLexerKt.COLON + str3;
                                    str = null;
                                }
                                mVar = mVar2;
                                metricsRecorder3 = metricsRecorder4;
                                mVar.a(timerEvent, metricsRecorder3, str);
                                mutex2.unlock(null);
                                return str4;
                            } catch (Throwable th) {
                                th = th;
                                mutex3 = mutex2;
                                mutex3.unlock(null);
                                throw th;
                            }
                        }
                        timerEvent = (TimerEvent) aVar.d;
                        mutex3 = (Mutex) aVar.c;
                        metricsRecorder3 = (MetricsRecorder) aVar.b;
                        mVar = (m) aVar.f5639a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            k kVar = (k) obj;
                            d = kVar.d();
                            if (d.length() > 0) {
                                str = C3250pb.f3639a;
                                mutex2 = mutex3;
                                mVar.a(timerEvent, metricsRecorder3, str);
                                mutex2.unlock(null);
                                return str4;
                            }
                            String f = kVar.f();
                            f e2 = kVar.e();
                            q qVar = mVar.b;
                            aVar.f5639a = mVar;
                            aVar.b = metricsRecorder3;
                            aVar.c = mutex3;
                            aVar.d = timerEvent;
                            aVar.e = d;
                            aVar.h = 3;
                            a3 = qVar.a(metricsRecorder3, f, e2, aVar);
                            if (a3 != coroutine_suspended) {
                                mutex2 = mutex3;
                                metricsRecorder4 = metricsRecorder3;
                                mVar2 = mVar;
                                str2 = d;
                                if (Result.m10247isFailureimpl(a3)) {
                                }
                                str3 = (String) a3;
                                if (str3.length() != 0) {
                                }
                                mVar = mVar2;
                                metricsRecorder3 = metricsRecorder4;
                                mVar.a(timerEvent, metricsRecorder3, str);
                                mutex2.unlock(null);
                                return str4;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex3.unlock(null);
                            throw th;
                        }
                    }
                    Mutex mutex5 = (Mutex) aVar.c;
                    MetricsRecorder metricsRecorder5 = (MetricsRecorder) aVar.b;
                    mVar = (m) aVar.f5639a;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex5;
                    metricsRecorder2 = metricsRecorder5;
                    TimerEvent startTimerEvent = metricsRecorder2.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.l.c());
                    y yVar = mVar.f5638a;
                    aVar.f5639a = mVar;
                    aVar.b = metricsRecorder2;
                    aVar.c = mutex;
                    aVar.d = startTimerEvent;
                    aVar.h = 2;
                    a2 = yVar.a(metricsRecorder2, aVar);
                    if (a2 != coroutine_suspended) {
                        MetricsRecorder metricsRecorder6 = metricsRecorder2;
                        timerEvent = startTimerEvent;
                        obj = a2;
                        mutex3 = mutex;
                        metricsRecorder3 = metricsRecorder6;
                        k kVar2 = (k) obj;
                        d = kVar2.d();
                        if (d.length() > 0) {
                        }
                    }
                    return coroutine_suspended;
                }
            }
            TimerEvent startTimerEvent2 = metricsRecorder2.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.l.c());
            y yVar2 = mVar.f5638a;
            aVar.f5639a = mVar;
            aVar.b = metricsRecorder2;
            aVar.c = mutex;
            aVar.d = startTimerEvent2;
            aVar.h = 2;
            a2 = yVar2.a(metricsRecorder2, aVar);
            if (a2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex3 = mutex2;
            mutex3.unlock(null);
            throw th;
        }
        aVar = new a(continuation);
        Object obj2 = aVar.f;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.h;
        String str42 = "";
        if (i != 0) {
        }
    }

    public final void a(TimerEvent timerEvent, MetricsRecorder metricsRecorder, String str) {
        if (str != null) {
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.q.c());
            com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
            CountEvent withTag = countEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.b;
            metricsRecorder.recordCountEvent(withTag.withTag(cVar2.c(), str));
            metricsRecorder.recordTimerEvent(timerEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar2.c(), str));
            return;
        }
        CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.q.c());
        com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.d;
        metricsRecorder.recordCountEvent(countEvent2.withTag(cVar3.c(), "success"));
        metricsRecorder.recordTimerEvent(timerEvent.withTag(cVar3.c(), "success"));
    }
}
