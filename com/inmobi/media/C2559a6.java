package com.inmobi.media;

import com.ironsource.C3040d4;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.a6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2559a6 {

    /* renamed from: a, reason: collision with root package name */
    public final long f2516a;

    public C2559a6(long j) {
        this.f2516a = j;
    }

    public final void a(final String message, final String exitData, final int i, final long j) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exitData, "exitData");
        ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.a6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2559a6.a(C2559a6.this, j, message, i, exitData);
            }
        };
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        AbstractC2745l7.f2631a.submit(runnable);
    }

    public static final void a(C2559a6 c2559a6, long j, String message, int i, String exitData) {
        Object m10241constructorimpl;
        Object m10241constructorimpl2;
        C2559a6 this$0 = c2559a6;
        long j2 = j;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        Intrinsics.checkNotNullParameter(exitData, "$exitData");
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = D5.f2259a;
        ArrayList arrayList2 = new ArrayList();
        Y5 y5 = new Y5();
        ArrayList arrayList3 = new ArrayList();
        Z6 d = Nc.d();
        ArrayList a2 = T1.a(d, "hasLoggerFinished=0", null, null, null, null, Integer.valueOf(T1.a(d, null, null, 63)), 30);
        X5 action = new X5(y5, arrayList3);
        Intrinsics.checkNotNullParameter(a2, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator it = CollectionsKt.filterNotNull(a2).iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        B5 action2 = new B5(arrayList2);
        Intrinsics.checkNotNullParameter(arrayList3, "<this>");
        Intrinsics.checkNotNullParameter(action2, "action");
        Iterator it2 = CollectionsKt.filterNotNull(arrayList3).iterator();
        while (it2.hasNext()) {
            action2.invoke(it2.next());
        }
        arrayList.addAll(arrayList2);
        Iterator it3 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            C2611d6 c2611d6 = (C2611d6) next;
            this$0.getClass();
            long j3 = c2611d6.f2544a.c.b;
            if (j2 >= j3 && j2 - j3 <= this$0.f2516a) {
                String message2 = "Message - " + message + ", Reason - " + i + ", Timestamp - " + j2 + ", Data - " + exitData;
                Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                Intrinsics.checkNotNullParameter(message2, "message");
                try {
                    JSONArray jSONArray = c2611d6.f2544a.b;
                    EnumC2560a7 logLevel = EnumC2560a7.c;
                    SimpleDateFormat simpleDateFormat = AbstractC2612d7.f2545a;
                    Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                    Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                    Intrinsics.checkNotNullParameter(message2, "message");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("scope", "ERROR");
                    jSONObject.put("timestamp", AbstractC2612d7.f2545a.format(new Date()));
                    jSONObject.put("tag", "IncompleteLogFinalizer");
                    jSONObject.put("data", message2);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
                String value = String.valueOf(i);
                Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                Intrinsics.checkNotNullParameter("exitReason", C3040d4.h.W);
                Intrinsics.checkNotNullParameter(value, "value");
                try {
                    c2611d6.f2544a.f2504a.put("exitReason", value);
                } catch (Exception unused2) {
                }
                Intrinsics.checkNotNullParameter("IncompleteLogFinalizer", "tag");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject2 = c2611d6.f2544a.f2504a;
                    Intrinsics.checkNotNullParameter(jSONObject2, "<this>");
                    if (!Intrinsics.areEqual(jSONObject2.toString(), "{}") && !B2.a(c2611d6.f2544a.b)) {
                        ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
                        AbstractC2729k7.a(new C2594c6(c2611d6));
                    }
                    m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        C2640f2 event = new C2640f2(m10244exceptionOrNullimpl);
                        S5 s5 = S5.f2425a;
                        Intrinsics.checkNotNullParameter(event, "event");
                        S5.d.a(event);
                        try {
                            ScheduledExecutorService scheduledExecutorService2 = AbstractC2745l7.f2631a;
                            m10241constructorimpl2 = Result.m10241constructorimpl(Result.m10240boximpl(AbstractC2729k7.a(new C2577b6(c2611d6))));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.INSTANCE;
                            m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th2));
                        }
                        Throwable m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(m10241constructorimpl2);
                        if (m10244exceptionOrNullimpl2 != null) {
                            try {
                                Result.Companion companion5 = Result.INSTANCE;
                                C2640f2 event2 = new C2640f2(m10244exceptionOrNullimpl2);
                                S5 s52 = S5.f2425a;
                                Intrinsics.checkNotNullParameter(event2, "event");
                                S5.d.a(event2);
                                m10241constructorimpl2 = Result.m10241constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th3) {
                                Result.Companion companion6 = Result.INSTANCE;
                                m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th3));
                            }
                        }
                        Result.m10241constructorimpl(Result.m10240boximpl(m10241constructorimpl2));
                    } catch (Throwable th4) {
                        Result.Companion companion7 = Result.INSTANCE;
                        Result.m10241constructorimpl(ResultKt.createFailure(th4));
                    }
                }
            }
            this$0 = c2559a6;
            j2 = j;
        }
    }
}
