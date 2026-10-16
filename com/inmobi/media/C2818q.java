package com.inmobi.media;

import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2818q extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2675a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2818q(long j) {
        super(1);
        this.f2675a = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2607d2 it = (C2607d2) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f2542a;
        if (i != 101) {
            if (i == 102) {
                ScheduledFuture scheduledFuture = C2849s.f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                C2849s.f = null;
            }
        } else if (C2849s.f == null && C2849s.d.get()) {
            C2849s c2849s = C2849s.f2699a;
            C2849s.a(this.f2675a);
        }
        return Unit.INSTANCE;
    }
}
