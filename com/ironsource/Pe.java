package com.ironsource;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Pe implements I3 {
    public static final a d = new a(null);
    public static final int e = -1;
    public static final long f = -1;

    /* renamed from: a, reason: collision with root package name */
    private final Context f2997a;
    private final String b;
    private final I8 c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public Pe(Context context, String baseName, I8 sdkSharedPref) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseName, "baseName");
        Intrinsics.checkNotNullParameter(sdkSharedPref, "sdkSharedPref");
        this.f2997a = context;
        this.b = baseName;
        this.c = sdkSharedPref;
    }

    @Override // com.ironsource.I3
    public void a(String identifier, int i) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.c.a(this.f2997a, new Qe(identifier, this.b + ".show_count_show_counter").a(), i);
    }

    @Override // com.ironsource.I3
    public Long b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return a(Long.valueOf(this.c.b(this.f2997a, new Qe(identifier, this.b + ".pacing_last_show_time").a(), -1L)));
    }

    @Override // com.ironsource.I3
    public Integer c(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return a(Integer.valueOf(this.c.b(this.f2997a, new Qe(identifier, this.b + ".show_count_show_counter").a(), -1)));
    }

    @Override // com.ironsource.I3
    public void a(String identifier, long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.c.a(this.f2997a, new Qe(identifier, this.b + ".pacing_last_show_time").a(), j);
    }

    @Override // com.ironsource.I3
    public void b(String identifier, long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.c.a(this.f2997a, new Qe(identifier, this.b + ".show_count_threshold").a(), j);
    }

    public /* synthetic */ Pe(Context context, String str, I8 i8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? new C3253pe() : i8);
    }

    @Override // com.ironsource.I3
    public Long a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return a(Long.valueOf(this.c.b(this.f2997a, new Qe(identifier, this.b + ".show_count_threshold").a(), -1L)));
    }

    private final Long a(Long l) {
        if (l != null && l.longValue() == -1) {
            return null;
        }
        return l;
    }

    private final Integer a(Integer num) {
        if (num != null && num.intValue() == -1) {
            return null;
        }
        return num;
    }
}
