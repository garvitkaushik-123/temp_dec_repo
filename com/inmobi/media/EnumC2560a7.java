package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.a7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2560a7 {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC2560a7 f2517a;
    public static final EnumC2560a7 b;
    public static final EnumC2560a7 c;
    public static final EnumC2560a7 d;
    public static final /* synthetic */ EnumC2560a7[] e;

    static {
        EnumC2560a7 enumC2560a7 = new EnumC2560a7("INFO", 0);
        f2517a = enumC2560a7;
        EnumC2560a7 enumC2560a72 = new EnumC2560a7("DEBUG", 1);
        b = enumC2560a72;
        EnumC2560a7 enumC2560a73 = new EnumC2560a7("ERROR", 2);
        c = enumC2560a73;
        EnumC2560a7 enumC2560a74 = new EnumC2560a7("STATE", 3);
        d = enumC2560a74;
        EnumC2560a7[] enumC2560a7Arr = {enumC2560a7, enumC2560a72, enumC2560a73, enumC2560a74};
        e = enumC2560a7Arr;
        EnumEntriesKt.enumEntries(enumC2560a7Arr);
    }

    public EnumC2560a7(String str, int i) {
    }

    public static EnumC2560a7 valueOf(String str) {
        return (EnumC2560a7) Enum.valueOf(EnumC2560a7.class, str);
    }

    public static EnumC2560a7[] values() {
        return (EnumC2560a7[]) e.clone();
    }
}
