package com.moloco.sdk.internal.services.bidtoken;

import io.bidmachine.media3.common.PlaybackException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.moloco.sdk.internal.services.bidtoken.b, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC3438b {
    public static final EnumC3438b b = new EnumC3438b("UNKNOWN", 0, -100);
    public static final EnumC3438b c = new EnumC3438b("HTTP_REQUEST_TIMEOUT", 1, -101);
    public static final EnumC3438b d = new EnumC3438b("UNKNOWN_HOST", 2, PlaybackException.ERROR_CODE_AUTHENTICATION_EXPIRED);
    public static final /* synthetic */ EnumC3438b[] e;
    public static final /* synthetic */ EnumEntries f;

    /* renamed from: a, reason: collision with root package name */
    public final int f5626a;

    static {
        EnumC3438b[] a2 = a();
        e = a2;
        f = EnumEntriesKt.enumEntries(a2);
    }

    public EnumC3438b(String str, int i, int i2) {
        this.f5626a = i2;
    }

    public static final /* synthetic */ EnumC3438b[] a() {
        return new EnumC3438b[]{b, c, d};
    }

    public static EnumEntries<EnumC3438b> b() {
        return f;
    }

    public static EnumC3438b valueOf(String str) {
        return (EnumC3438b) Enum.valueOf(EnumC3438b.class, str);
    }

    public static EnumC3438b[] values() {
        return (EnumC3438b[]) e.clone();
    }

    public final int c() {
        return this.f5626a;
    }
}
