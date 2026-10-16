package com.inmobi.media;

import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class E2 extends FutureTask implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public volatile Ta f2269a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E2(Runnable runnable, Ta priority) {
        super(runnable, null);
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.f2269a = priority;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        E2 other = (E2) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.f2269a.f2440a, other.f2269a.f2440a);
    }
}
