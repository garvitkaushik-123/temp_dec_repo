package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* renamed from: com.ironsource.sb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3300sb extends Oc {
    public static final a d = new a(null);
    private static final String e = "ManualTrigger";

    /* renamed from: com.ironsource.sb$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public C3300sb() {
        this(false, 1, null);
    }

    @Override // com.ironsource.Oc
    public String b() {
        return e;
    }

    public final void e() {
        a(true);
    }

    public final void f() {
        a(false);
    }

    public C3300sb(boolean z) {
        super(z);
    }

    public /* synthetic */ C3300sb(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
