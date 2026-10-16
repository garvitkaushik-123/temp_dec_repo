package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.df, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2620df {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC2620df f2552a;
    public static final EnumC2620df b;
    public static final EnumC2620df c;
    public static final /* synthetic */ EnumC2620df[] d;

    static {
        EnumC2620df enumC2620df = new EnumC2620df("UNKNOWN", 0);
        f2552a = enumC2620df;
        EnumC2620df enumC2620df2 = new EnumC2620df("HIDDEN", 1);
        b = enumC2620df2;
        EnumC2620df enumC2620df3 = new EnumC2620df("VISIBLE", 2);
        c = enumC2620df3;
        EnumC2620df[] enumC2620dfArr = {enumC2620df, enumC2620df2, enumC2620df3};
        d = enumC2620dfArr;
        EnumEntriesKt.enumEntries(enumC2620dfArr);
    }

    public EnumC2620df(String str, int i) {
    }

    public static EnumC2620df valueOf(String str) {
        return (EnumC2620df) Enum.valueOf(EnumC2620df.class, str);
    }

    public static EnumC2620df[] values() {
        return (EnumC2620df[]) d.clone();
    }
}
