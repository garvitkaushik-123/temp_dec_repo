package com.inmobi.media;

import android.util.SparseArray;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class D1 {
    public static final C1 b;
    public static final SparseArray c;
    public static final D1 d;
    public static final D1 e;
    public static final /* synthetic */ D1[] f;

    /* renamed from: a, reason: collision with root package name */
    public final int f2257a;

    static {
        D1 d1 = new D1(0, 0, "UNKNOWN");
        d = d1;
        D1 d12 = new D1(1, 1, "PLAYING");
        e = d12;
        D1[] d1Arr = {d1, d12, new D1(2, 2, "PAUSED"), new D1(3, 3, "COMPLETED")};
        f = d1Arr;
        EnumEntriesKt.enumEntries(d1Arr);
        b = new C1();
        c = new SparseArray();
        for (D1 d13 : values()) {
            c.put(d13.f2257a, d13);
        }
    }

    public D1(int i, int i2, String str) {
        this.f2257a = i2;
    }

    public static D1 valueOf(String str) {
        return (D1) Enum.valueOf(D1.class, str);
    }

    public static D1[] values() {
        return (D1[]) f.clone();
    }
}
