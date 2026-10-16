package com.inmobi.media;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class K5 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2336a;
    public final String b;

    public K5(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f2336a = z;
        this.b = AbstractC2673h0.a("TIM-", name);
    }

    public final boolean a() {
        return this.f2336a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        try {
            Thread thread = new Thread(r, this.b);
            thread.setDaemon(this.f2336a);
            return thread;
        } catch (InternalError e) {
            e.toString();
            return null;
        }
    }

    public /* synthetic */ K5(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K5(String name) {
        this(name, false);
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
