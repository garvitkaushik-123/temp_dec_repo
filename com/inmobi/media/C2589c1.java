package com.inmobi.media;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.util.Log;
import com.ironsource.C3040d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.c1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2589c1 extends G3 {
    public final Context b;
    public final long c;
    public final int d;
    public final ActivityManager e;
    public final C6 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2589c1(Context context, H3 listener, long j, int i) {
        super(listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b = context;
        this.c = j;
        this.d = i;
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        this.e = (ActivityManager) systemService;
        ConcurrentHashMap concurrentHashMap = C6.b;
        this.f = B6.a(context, "appClose");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00a7  */
    /* JADX WARN: Type inference failed for: r17v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(C2589c1 this$0, ApplicationExitInfo applicationExitInfo) {
        ApplicationExitInfo applicationExitInfo2;
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        H3 h3 = this$0.f2290a;
        int reason = applicationExitInfo.getReason();
        String description = applicationExitInfo.getDescription();
        InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
        int i = this$0.d;
        Intrinsics.checkNotNullParameter("\"main\"", "startMarker");
        Intrinsics.checkNotNullParameter("ZygoteInit.java", "endMarker");
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        if (traceInputStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(traceInputStream));
                int i2 = i;
                boolean z = false;
                ApplicationExitInfo applicationExitInfo3 = applicationExitInfo;
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                sb = sb5;
                                break;
                            }
                            if (i > 0 && !z) {
                                sb5.append(readLine).append("\n");
                                i--;
                            }
                            int i3 = i;
                            sb = sb5;
                            try {
                                if (StringsKt.startsWith$default(readLine, "\"main\"", false, 2, (Object) null)) {
                                    StringsKt.clear(sb);
                                    z = true;
                                }
                                if (z) {
                                    i2--;
                                    sb4.append(readLine).append("\n");
                                }
                                if (StringsKt.contains$default((CharSequence) readLine, (CharSequence) "ZygoteInit.java", false, 2, (Object) null) || i2 <= 0) {
                                    break;
                                }
                                i = i3;
                                sb5 = sb;
                                applicationExitInfo3 = sb;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader.close();
                                throw th;
                            }
                        } catch (IOException e) {
                            e = e;
                            applicationExitInfo2 = applicationExitInfo3;
                            Log.e("CommonExt", "Error reading from input stream", e);
                            sb2 = applicationExitInfo2;
                            if (sb4.length() != 0) {
                            }
                            h3.a(new C2606d1(description, reason, sb3));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                bufferedReader.close();
                sb2 = sb;
            } catch (IOException e2) {
                e = e2;
                applicationExitInfo2 = sb5;
            }
        } else {
            sb2 = sb5;
        }
        if (sb4.length() != 0) {
            sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        } else {
            sb3 = sb4.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        }
        h3.a(new C2606d1(description, reason, sb3));
    }

    @Override // com.inmobi.media.G3
    public final void b() {
    }

    @Override // com.inmobi.media.G3
    public final void a() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.c1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2589c1.a(C2589c1.this);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ie.f2319a.execute(runnable);
    }

    public static final void a(final C2589c1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<ApplicationExitInfo> historicalProcessExitReasons = this$0.e.getHistoricalProcessExitReasons(this$0.b.getPackageName(), 0, 10);
        Intrinsics.checkNotNullExpressionValue(historicalProcessExitReasons, "getHistoricalProcessExitReasons(...)");
        C6 c6 = this$0.f;
        c6.getClass();
        Intrinsics.checkNotNullParameter("exitReasonTimestamp", C3040d4.h.W);
        long j = c6.f2249a.getLong("exitReasonTimestamp", 0L);
        long j2 = j;
        for (final ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
            if (applicationExitInfo.getTimestamp() > j) {
                long j3 = this$0.c;
                Runnable runnable = new Runnable() { // from class: com.inmobi.media.c1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2589c1.a(C2589c1.this, applicationExitInfo);
                    }
                };
                ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                Ie.f2319a.schedule(runnable, j3, TimeUnit.MILLISECONDS);
                if (applicationExitInfo.getTimestamp() > j2) {
                    j2 = applicationExitInfo.getTimestamp();
                }
            }
        }
        C6.a(this$0.f, "exitReasonTimestamp", j2, false, 4, (Object) null);
    }
}
