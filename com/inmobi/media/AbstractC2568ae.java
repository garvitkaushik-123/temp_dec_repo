package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ae, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2568ae {
    public static final short a(EnumC2790o4 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        int ordinal = errorCode.ordinal();
        if (ordinal == 0) {
            return (short) 2122;
        }
        if (ordinal == 18) {
            return (short) 2229;
        }
        switch (ordinal) {
            case 12:
                return (short) 2123;
            case 13:
                return (short) 2124;
            case 14:
                return (short) 2125;
            case 15:
                return (short) 2126;
            case 16:
                return (short) 2127;
            default:
                return (short) 2122;
        }
    }
}
