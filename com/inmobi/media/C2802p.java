package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ScheduledFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2802p extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f2665a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2802p(Context context) {
        super(0);
        this.f2665a = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C2769n c2769n = C2849s.c;
        if (c2769n != null) {
            C2.a(new C2785o(this.f2665a, c2769n));
            C2849s.c = null;
        }
        ScheduledFuture scheduledFuture = C2849s.f;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        C2818q c2818q = C2849s.h;
        if (c2818q != null) {
            Uc.f().a(c2818q);
        }
        C2849s.h = null;
        C2849s.f = null;
        return Unit.INSTANCE;
    }
}
