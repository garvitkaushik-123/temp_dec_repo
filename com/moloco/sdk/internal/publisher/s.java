package com.moloco.sdk.internal.publisher;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f5579a = new s("BANNER", 0);
    public static final s b = new s("BANNER_TABLET", 1);
    public static final s c = new s("MREC", 2);
    public static final s d = new s("NATIVE_AD_MEDIATION", 3);
    public static final s e = new s("NATIVE_BANNER", 4);
    public static final s f = new s("INTERSTITIAL", 5);
    public static final s g = new s("REWARDED", 6);
    public static final /* synthetic */ s[] h;
    public static final /* synthetic */ EnumEntries i;

    static {
        s[] a2 = a();
        h = a2;
        i = EnumEntriesKt.enumEntries(a2);
    }

    public s(String str, int i2) {
    }

    public static final /* synthetic */ s[] a() {
        return new s[]{f5579a, b, c, d, e, f, g};
    }

    public static EnumEntries<s> b() {
        return i;
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) h.clone();
    }
}
