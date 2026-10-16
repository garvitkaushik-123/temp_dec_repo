package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Ta {
    public static final Ta b;
    public static final Ta c;
    public static final /* synthetic */ Ta[] d;

    /* renamed from: a, reason: collision with root package name */
    public final int f2440a;

    static {
        Ta ta = new Ta(0, 0, "HIGHEST");
        b = ta;
        Ta ta2 = new Ta(1, 1, "HIGH");
        Ta ta3 = new Ta(2, 2, "MEDIUM");
        c = ta3;
        Ta[] taArr = {ta, ta2, ta3, new Ta(3, 3, "LOW"), new Ta(4, 4, "LOWEST")};
        d = taArr;
        EnumEntriesKt.enumEntries(taArr);
    }

    public Ta(int i, int i2, String str) {
        this.f2440a = i2;
    }

    public static Ta valueOf(String str) {
        return (Ta) Enum.valueOf(Ta.class, str);
    }

    public static Ta[] values() {
        return (Ta[]) d.clone();
    }
}
