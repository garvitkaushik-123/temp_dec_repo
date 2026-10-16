package com.inmobi.media;

import android.content.Context;
import com.ironsource.C3040d4;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Fb extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Fb f2285a = new Fb();

    public Fb() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ConcurrentHashMap concurrentHashMap = C6.b;
        Context d = Uc.d();
        Intrinsics.checkNotNull(d);
        C6 a2 = B6.a(d, EventTaskParams.STATE_GROUP_DEFAULT);
        Intrinsics.checkNotNullParameter("enableImraidLogs", C3040d4.h.W);
        return Boolean.valueOf(a2.f2249a.getBoolean("enableImraidLogs", false));
    }
}
