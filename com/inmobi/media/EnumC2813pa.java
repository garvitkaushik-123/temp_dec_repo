package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.pa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2813pa {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC2813pa f2670a;
    public static final EnumC2813pa b;
    public static final EnumC2813pa c;
    public static final EnumC2813pa d;
    public static final /* synthetic */ EnumC2813pa[] e;

    static {
        EnumC2813pa enumC2813pa = new EnumC2813pa("PORTRAIT", 0);
        f2670a = enumC2813pa;
        EnumC2813pa enumC2813pa2 = new EnumC2813pa("LANDSCAPE", 1);
        b = enumC2813pa2;
        EnumC2813pa enumC2813pa3 = new EnumC2813pa("REVERSE_PORTRAIT", 2);
        c = enumC2813pa3;
        EnumC2813pa enumC2813pa4 = new EnumC2813pa("REVERSE_LANDSCAPE", 3);
        d = enumC2813pa4;
        EnumC2813pa[] enumC2813paArr = {enumC2813pa, enumC2813pa2, enumC2813pa3, enumC2813pa4};
        e = enumC2813paArr;
        EnumEntriesKt.enumEntries(enumC2813paArr);
    }

    public EnumC2813pa(String str, int i) {
    }

    public static EnumC2813pa valueOf(String str) {
        return (EnumC2813pa) Enum.valueOf(EnumC2813pa.class, str);
    }

    public static EnumC2813pa[] values() {
        return (EnumC2813pa[]) e.clone();
    }
}
