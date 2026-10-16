package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Td {

    /* renamed from: a, reason: collision with root package name */
    public static final Td f2443a;
    public static final Td b;
    public static final /* synthetic */ Td[] c;

    static {
        Td td = new Td("SDK", 0);
        f2443a = td;
        Td td2 = new Td("TEMPLATE", 1);
        b = td2;
        Td[] tdArr = {td, td2};
        c = tdArr;
        EnumEntriesKt.enumEntries(tdArr);
    }

    public Td(String str, int i) {
    }

    public static Td valueOf(String str) {
        return (Td) Enum.valueOf(Td.class, str);
    }

    public static Td[] values() {
        return (Td[]) c.clone();
    }
}
