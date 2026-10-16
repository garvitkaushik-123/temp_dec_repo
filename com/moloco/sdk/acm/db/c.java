package com.moloco.sdk.acm.db;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f5316a = new c("TIMER", 0);
    public static final c b = new c("COUNT", 1);
    public static final /* synthetic */ c[] c;
    public static final /* synthetic */ EnumEntries d;

    static {
        c[] a2 = a();
        c = a2;
        d = EnumEntriesKt.enumEntries(a2);
    }

    public c(String str, int i) {
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f5316a, b};
    }

    public static EnumEntries<c> b() {
        return d;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) c.clone();
    }
}
