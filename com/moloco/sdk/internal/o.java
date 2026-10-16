package com.moloco.sdk.internal;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class o implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c {

    /* renamed from: a, reason: collision with root package name */
    public static final o f5436a = new o("AD_LOAD_LIMIT_REACHED", 0);
    public static final o b = new o("BID_LOAD_ERROR_CANNOT_PROCESS_BID_RESPONSE", 1);
    public static final o c = new o("BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE", 2);
    public static final o d = new o("AD_SHOW_ERROR_NOT_LOADED", 3);
    public static final o e = new o("AD_SHOW_ERROR_ALREADY_DISPLAYING", 4);
    public static final /* synthetic */ o[] f;
    public static final /* synthetic */ EnumEntries g;

    static {
        o[] b2 = b();
        f = b2;
        g = EnumEntriesKt.enumEntries(b2);
    }

    public o(String str, int i) {
    }

    public static final /* synthetic */ o[] b() {
        return new o[]{f5436a, b, c, d, e};
    }

    public static EnumEntries<o> c() {
        return g;
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) f.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
