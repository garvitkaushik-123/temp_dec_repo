package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.rc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2846rc {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC2846rc f2696a;
    public static final EnumC2846rc b;
    public static final /* synthetic */ EnumC2846rc[] c;

    static {
        EnumC2846rc enumC2846rc = new EnumC2846rc("GET", 0);
        f2696a = enumC2846rc;
        EnumC2846rc enumC2846rc2 = new EnumC2846rc("POST", 1);
        b = enumC2846rc2;
        EnumC2846rc[] enumC2846rcArr = {enumC2846rc, enumC2846rc2, new EnumC2846rc("PUT", 2), new EnumC2846rc("DELETE", 3), new EnumC2846rc("PATCH", 4)};
        c = enumC2846rcArr;
        EnumEntriesKt.enumEntries(enumC2846rcArr);
    }

    public EnumC2846rc(String str, int i) {
    }

    public static EnumC2846rc valueOf(String str) {
        return (EnumC2846rc) Enum.valueOf(EnumC2846rc.class, str);
    }

    public static EnumC2846rc[] values() {
        return (EnumC2846rc[]) c.clone();
    }
}
