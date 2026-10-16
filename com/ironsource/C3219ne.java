package com.ironsource;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ne, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3219ne implements InterfaceC3202me {

    /* renamed from: a, reason: collision with root package name */
    private final I8 f3604a;

    /* renamed from: com.ironsource.ne$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3605a = new a();
        public static final String b = "sessionNumber";
        public static final String c = "firstSessionTimestamp";

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3219ne() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.InterfaceC3236oe
    public void a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3604a.a(context, a.b, i);
    }

    @Override // com.ironsource.InterfaceC3236oe
    public int b(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f3604a.b(context, a.b, i);
    }

    public C3219ne(I8 sdkSharedPref) {
        Intrinsics.checkNotNullParameter(sdkSharedPref, "sdkSharedPref");
        this.f3604a = sdkSharedPref;
    }

    @Override // com.ironsource.Vd
    public long a(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f3604a.b(context, "firstSessionTimestamp", j);
    }

    @Override // com.ironsource.Vd
    public void b(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3604a.a(context, "firstSessionTimestamp", j);
    }

    public /* synthetic */ C3219ne(I8 i8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C3253pe() : i8);
    }
}
