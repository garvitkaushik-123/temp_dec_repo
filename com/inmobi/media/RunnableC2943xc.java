package com.inmobi.media;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.xc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC2943xc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final C2895uc f2754a;
    public final C2911vc b;

    public RunnableC2943xc(C2895uc request, C2911vc c2911vc) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f2754a = request;
        this.b = c2911vc;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public static final void a(RunnableC2943xc this$0, C2962yc response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "$response");
        C2895uc request = this$0.f2754a;
        request.getClass();
        Intrinsics.checkNotNullParameter(response, "response");
        M9 m9 = request.l;
        if (m9 != null) {
            Intrinsics.checkNotNullParameter(response, "response");
            P9 response2 = D4.a(response);
            N9 request2 = m9.f2361a;
            Intrinsics.checkNotNullParameter(response2, "response");
            Intrinsics.checkNotNullParameter(request2, "request");
            m9.b.invoke(response2);
        }
        request.l = null;
        Set set = AbstractC2927wc.f2744a;
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            AbstractC2927wc.f2744a.remove(request);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2754a.getClass();
        int i = H9.f2306a;
        final C2962yc a2 = H9.a(this.f2754a, this.b);
        I9 i9 = a2.f2765a;
        if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.m) {
            ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.xc$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RunnableC2943xc.a(RunnableC2943xc.this, a2);
                }
            };
            executorC2793o7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            executorC2793o7.f2659a.post(runnable);
            this.f2754a.getClass();
        }
    }
}
