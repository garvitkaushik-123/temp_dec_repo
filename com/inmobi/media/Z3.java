package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Z3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Z3 f2503a;
    public static final /* synthetic */ Z3[] b;

    static {
        Z3 z3 = new Z3("URL", 0);
        f2503a = z3;
        Z3[] z3Arr = {z3, new Z3("HTML", 1)};
        b = z3Arr;
        EnumEntriesKt.enumEntries(z3Arr);
    }

    public Z3(String str, int i) {
    }

    public static Z3 valueOf(String str) {
        return (Z3) Enum.valueOf(Z3.class, str);
    }

    public static Z3[] values() {
        return (Z3[]) b.clone();
    }
}
