package com.inmobi.media;

import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Re extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Re f2419a = new Re();

    public Re() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Se se = Se.f2431a;
        Intrinsics.checkNotNullExpressionValue("Se", "access$getTAG$p(...)");
        return Executors.newCachedThreadPool(new K5("Se"));
    }
}
