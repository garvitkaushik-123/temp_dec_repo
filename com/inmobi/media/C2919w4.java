package com.inmobi.media;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.w4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2919w4 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2919w4 f2740a = new C2919w4();

    public C2919w4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = AbstractC2970z4.f2771a;
        return new ScheduledThreadPoolExecutor(5, new K5("ExecutorProvider.high"));
    }
}
