package com.moloco.sdk.acm;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f5344a = new f("INITIALIZED", 0);
    public static final f b = new f("INITIALIZING", 1);
    public static final f c = new f("UNINITIALIZED", 2);
    public static final /* synthetic */ f[] d;
    public static final /* synthetic */ EnumEntries e;

    static {
        f[] a2 = a();
        d = a2;
        e = EnumEntriesKt.enumEntries(a2);
    }

    public f(String str, int i) {
    }

    public static final /* synthetic */ f[] a() {
        return new f[]{f5344a, b, c};
    }

    public static EnumEntries<f> b() {
        return e;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) d.clone();
    }
}
