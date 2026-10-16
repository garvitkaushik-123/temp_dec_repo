package com.inmobi.media;

import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class G extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2288a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(I i) {
        super(0);
        this.f2288a = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ScheduledFuture scheduledFuture = this.f2288a.k;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        Df df = this.f2288a.l;
        if (df != null) {
            df.a();
        }
        I i = this.f2288a;
        i.l = null;
        i.k = null;
        i.a(new A4(0.0f, null, null));
        return Unit.INSTANCE;
    }
}
