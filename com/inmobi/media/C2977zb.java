package com.inmobi.media;

import android.content.Context;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.zb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2977zb extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ab f2775a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2977zb(Ab ab, boolean z) {
        super(0);
        this.f2775a = ab;
        this.b = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Ab ab = this.f2775a;
        if (!ab.g.isEmpty() && !ab.h.isEmpty()) {
            String c = ab.c();
            Intrinsics.checkNotNullParameter(c, "<this>");
            if (!Intrinsics.areEqual(c, "{}")) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (this.f2775a.j.length() == 0) {
                    Ab ab2 = this.f2775a;
                    ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
                    Context context = ab2.f2235a;
                    Intrinsics.checkNotNullParameter(context, "context");
                    File file = new File(context.getFilesDir() + "/logging");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    ab2.j = context.getFilesDir() + "/logging/" + timeInMillis + ".txt";
                }
                Ab ab3 = this.f2775a;
                if (AbstractC2761m7.a("RemoteLogger", ab3.c(), ab3.j)) {
                    Ab ab4 = this.f2775a;
                    boolean z = this.b;
                    String str = ab4.j;
                    Y6 data = new Y6(str, timeInMillis, 0, 0L, z, ab4.k.get(), 12);
                    Z6 d = Nc.d();
                    d.getClass();
                    Intrinsics.checkNotNullParameter(data, "data");
                    if (T1.a(d, "filename=\"" + str + '\"', null, null, null, null, null, 62).isEmpty()) {
                        int i = this.f2775a.c;
                        d.a((Object) data);
                        if (d.b != null) {
                            C5.a();
                        }
                        ScheduledExecutorService scheduledExecutorService2 = AbstractC2745l7.f2631a;
                        Ab ab5 = this.f2775a;
                        AbstractC2729k7.a(d, timeInMillis - ab5.b, ab5.c);
                    } else {
                        d.b(data);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
