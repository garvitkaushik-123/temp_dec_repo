package com.ironsource;

import android.content.Context;
import com.ironsource.H8;
import com.ironsource.InterfaceC3293s4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.le, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3185le implements H8, H8.a {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3202me f3465a;
    private final InterfaceC3050de b;
    private final InterfaceC3293s4 c;
    private int d;
    private long e;

    /* renamed from: com.ironsource.le$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3466a = new a();
        public static final int b = -1;
        public static final int c = 0;
        public static final long d = -1;

        private a() {
        }
    }

    public C3185le(InterfaceC3202me storage, InterfaceC3050de initResponseStorage, InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(initResponseStorage, "initResponseStorage");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3465a = storage;
        this.b = initResponseStorage;
        this.c = currentTimeProvider;
        this.d = -1;
        this.e = -1L;
    }

    private final int b(Context context, InterfaceC3202me interfaceC3202me) {
        int b = interfaceC3202me.b(context, 0) + 1;
        interfaceC3202me.a(context, b);
        return b;
    }

    @Override // com.ironsource.H8.a
    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = b(context, this.f3465a);
        this.e = a(context, this.f3465a);
    }

    @Override // com.ironsource.H8
    public int c() {
        return this.d;
    }

    private final long a(Context context, InterfaceC3202me interfaceC3202me) {
        long a2 = interfaceC3202me.a(context, -1L);
        if (this.b.a(context) || a2 != -1) {
            return a2;
        }
        long a3 = this.c.a();
        IronLog.INTERNAL.verbose("set first session timestamp = " + a3);
        interfaceC3202me.b(context, a3);
        return a3;
    }

    @Override // com.ironsource.H8
    public String b() {
        String sessionId = IronSourceUtils.getSessionId();
        Intrinsics.checkNotNullExpressionValue(sessionId, "getSessionId()");
        return sessionId;
    }

    public /* synthetic */ C3185le(InterfaceC3202me interfaceC3202me, InterfaceC3050de interfaceC3050de, InterfaceC3293s4 interfaceC3293s4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC3202me, (i & 2) != 0 ? new C3067ee() : interfaceC3050de, (i & 4) != 0 ? new InterfaceC3293s4.a() : interfaceC3293s4);
    }

    @Override // com.ironsource.H8
    public long a() {
        return this.e;
    }
}
