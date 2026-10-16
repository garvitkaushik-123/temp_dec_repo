package com.moloco.sdk.internal.client_metrics_data;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class c {
    public static final c b = new c("Reason", 0, "reason");
    public static final c c = new c("AdType", 1, "ad_type");
    public static final c d = new c("Result", 2, "result");
    public static final c e = new c("Country", 3, "country");
    public static final c f = new c("RetryAttempt", 4, "attempt");
    public static final c g = new c("Step", 5, "step");
    public static final /* synthetic */ c[] h;
    public static final /* synthetic */ EnumEntries i;

    /* renamed from: a, reason: collision with root package name */
    public final String f5379a;

    static {
        c[] a2 = a();
        h = a2;
        i = EnumEntriesKt.enumEntries(a2);
    }

    public c(String str, int i2, String str2) {
        this.f5379a = str2;
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{b, c, d, e, f, g};
    }

    public static EnumEntries<c> b() {
        return i;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) h.clone();
    }

    public final String c() {
        return this.f5379a;
    }
}
