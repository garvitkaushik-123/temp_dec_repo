package com.moloco.sdk.internal.ilrd.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5426a = new a("MAX", 0);
    public static final a b = new a("LEVELPLAY", 1);
    public static final /* synthetic */ a[] c;
    public static final /* synthetic */ EnumEntries d;

    static {
        a[] a2 = a();
        c = a2;
        d = EnumEntriesKt.enumEntries(a2);
    }

    public a(String str, int i) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f5426a, b};
    }

    public static EnumEntries<a> b() {
        return d;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) c.clone();
    }
}
