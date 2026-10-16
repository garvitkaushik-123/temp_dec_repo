package com.inmobi.media;

/* renamed from: com.inmobi.media.k4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2726k4 {
    public static EnumC2758m4 a(int i) {
        if (400 <= i && 500 > i) {
            return EnumC2758m4.f;
        }
        if (200 < i && 300 > i) {
            return EnumC2758m4.g;
        }
        EnumC2758m4 enumC2758m4 = (EnumC2758m4) EnumC2758m4.c.get(i);
        return enumC2758m4 == null ? EnumC2758m4.d : enumC2758m4;
    }
}
