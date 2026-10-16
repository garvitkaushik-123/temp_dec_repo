package com.inmobi.media;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.y4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2954y4 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2954y4 f2760a = new C2954y4();

    public C2954y4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new ScheduledThreadPoolExecutor(AbstractC2970z4.f2771a, new K5("ExecutorProvider.normal"));
    }
}
