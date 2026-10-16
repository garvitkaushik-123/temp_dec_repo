package com.moloco.sdk.internal.services.bidtoken;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public static final B f5625a = new B("NEEDS_REFRESH", 0);
    public static final B b = new B("EXPIRING", 1);
    public static final B c = new B("NO_REFRESH_NEEDED", 2);
    public static final /* synthetic */ B[] d;
    public static final /* synthetic */ EnumEntries e;

    static {
        B[] a2 = a();
        d = a2;
        e = EnumEntriesKt.enumEntries(a2);
    }

    public B(String str, int i) {
    }

    public static final /* synthetic */ B[] a() {
        return new B[]{f5625a, b, c};
    }

    public static EnumEntries<B> c() {
        return e;
    }

    public static B valueOf(String str) {
        return (B) Enum.valueOf(B.class, str);
    }

    public static B[] values() {
        return (B[]) d.clone();
    }

    public final boolean b() {
        return this == b || this == c;
    }
}
