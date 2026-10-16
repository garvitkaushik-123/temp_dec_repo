package com.inmobi.media;

import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.u4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2887u4 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2887u4 f2719a = new C2887u4();

    public C2887u4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Lazy lazy = AbstractC2903v4.f2730a;
        Intrinsics.checkNotNullExpressionValue("v4", "access$getTAG$p(...)");
        return Executors.newSingleThreadScheduledExecutor(new K5("v4"));
    }
}
