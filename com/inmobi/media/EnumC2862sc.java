package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.sc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2862sc {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC2862sc f2704a;
    public static final /* synthetic */ EnumC2862sc[] b;

    static {
        EnumC2862sc enumC2862sc = new EnumC2862sc("HIGH", 0);
        EnumC2862sc enumC2862sc2 = new EnumC2862sc("LOW", 1);
        f2704a = enumC2862sc2;
        EnumC2862sc[] enumC2862scArr = {enumC2862sc, enumC2862sc2};
        b = enumC2862scArr;
        EnumEntriesKt.enumEntries(enumC2862scArr);
    }

    public EnumC2862sc(String str, int i) {
    }

    public static EnumC2862sc valueOf(String str) {
        return (EnumC2862sc) Enum.valueOf(EnumC2862sc.class, str);
    }

    public static EnumC2862sc[] values() {
        return (EnumC2862sc[]) b.clone();
    }
}
