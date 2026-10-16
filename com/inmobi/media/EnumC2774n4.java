package com.inmobi.media;

import io.bidmachine.media3.common.PlaybackException;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.n4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2774n4 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumC2774n4[] f2646a;

    static {
        EnumC2774n4[] enumC2774n4Arr = {new EnumC2774n4(0, -100, "PING_V2_DISABLED", "Ping V2 is disabled from SDK config"), new EnumC2774n4(1, -101, "PING_ID_MISSING", "Ping ID is missing"), new EnumC2774n4(2, PlaybackException.ERROR_CODE_AUTHENTICATION_EXPIRED, "PING_URL_INVALID", "Ping url is invalid"), new EnumC2774n4(3, PlaybackException.ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED, "PING_URL_MISSING", "Ping URL is missing"), new EnumC2774n4(4, PlaybackException.ERROR_CODE_CONCURRENT_STREAM_LIMIT, "PING_JSON_INVALID", "Ping JSON is invalid"), new EnumC2774n4(5, PlaybackException.ERROR_CODE_PARENTAL_CONTROL_RESTRICTED, "PING_ARRAY_EMPTY", "Ping array is empty"), new EnumC2774n4(6, PlaybackException.ERROR_CODE_NOT_AVAILABLE_IN_REGION, "PING_UNKNOWN_RESPONSE", "Ping response is unknown"), new EnumC2774n4(7, PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED, "PING_EXCEPTION", "Ping exception occurred")};
        f2646a = enumC2774n4Arr;
        EnumEntriesKt.enumEntries(enumC2774n4Arr);
    }

    public EnumC2774n4(int i, int i2, String str, String str2) {
    }

    public static EnumC2774n4 valueOf(String str) {
        return (EnumC2774n4) Enum.valueOf(EnumC2774n4.class, str);
    }

    public static EnumC2774n4[] values() {
        return (EnumC2774n4[]) f2646a.clone();
    }
}
