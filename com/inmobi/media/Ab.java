package com.inmobi.media;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Ab {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2235a;
    public final long b;
    public final int c;
    public boolean d;
    public final C2595c7 e;
    public final Pc f;
    public final List g;
    public final ConcurrentHashMap h;
    public final AtomicBoolean i;
    public String j;
    public final AtomicInteger k;

    public Ab(Context context, double d, EnumC2560a7 logLevel, long j, int i, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.f2235a = context;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = new C2595c7(logLevel);
        this.f = new Pc(d);
        this.g = Collections.synchronizedList(new ArrayList());
        this.h = new ConcurrentHashMap();
        this.i = new AtomicBoolean(false);
        this.j = "";
        this.k = new AtomicInteger(0);
    }

    public final void a(final EnumC2560a7 logLevel, String tag, String message) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.i.get()) {
            return;
        }
        SimpleDateFormat simpleDateFormat = AbstractC2612d7.f2545a;
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("scope", logLevel.name());
        jSONObject.put("timestamp", AbstractC2612d7.f2545a.format(new Date()));
        jSONObject.put("tag", tag);
        jSONObject.put("data", message);
        ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.Ab$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Ab.a(Ab.this, logLevel, jSONObject);
            }
        };
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        AbstractC2745l7.f2631a.submit(runnable);
    }

    public final void b() {
        Objects.toString(this.i);
        if ((this.d || this.f.a()) && !this.i.getAndSet(true)) {
            ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.Ab$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    Ab.b(Ab.this);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            AbstractC2745l7.f2631a.submit(runnable);
        }
    }

    public final String c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        synchronized (this.h) {
            for (Map.Entry entry : this.h.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
        }
        jSONObject.put("vitals", jSONObject2);
        jSONObject.put("log", d());
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        return jSONObject3;
    }

    public final JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        List logData = this.g;
        Intrinsics.checkNotNullExpressionValue(logData, "logData");
        synchronized (logData) {
            List logData2 = this.g;
            Intrinsics.checkNotNullExpressionValue(logData2, "logData");
            Iterator it = logData2.iterator();
            while (it.hasNext()) {
                jSONArray.put((JSONObject) it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
        return jSONArray;
    }

    public static final void b(Ab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.toString(this$0.i);
        ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
        if (Result.m10244exceptionOrNullimpl(AbstractC2729k7.a(new C2977zb(this$0, true))) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public static final void a(Ab this$0, EnumC2560a7 eventLogLevel, JSONObject data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventLogLevel, "$logLevel");
        Intrinsics.checkNotNullParameter(data, "$data");
        try {
            C2595c7 c2595c7 = this$0.e;
            c2595c7.getClass();
            Intrinsics.checkNotNullParameter(eventLogLevel, "eventLogLevel");
            int ordinal = c2595c7.f2534a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (eventLogLevel != EnumC2560a7.d) {
                            return;
                        }
                    } else if (eventLogLevel != EnumC2560a7.c && eventLogLevel != EnumC2560a7.d) {
                        return;
                    }
                } else if (eventLogLevel != EnumC2560a7.b && eventLogLevel != EnumC2560a7.c && eventLogLevel != EnumC2560a7.d) {
                    return;
                }
            }
            this$0.g.add(data);
        } catch (Exception e) {
            this$0.getClass();
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void a() {
        Objects.toString(this.i);
        if ((this.d || this.f.a()) && !this.i.get()) {
            ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.Ab$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Ab.a(Ab.this);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            AbstractC2745l7.f2631a.submit(runnable);
        }
    }

    public static final void a(Ab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k.getAndIncrement();
        Objects.toString(this$0.i);
        ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
        if (Result.m10244exceptionOrNullimpl(AbstractC2729k7.a(new C2977zb(this$0, false))) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}
