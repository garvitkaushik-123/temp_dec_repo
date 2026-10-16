package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public enum zzhck {
    DOUBLE(zzhcl.DOUBLE, 1),
    FLOAT(zzhcl.FLOAT, 5),
    INT64(zzhcl.LONG, 0),
    UINT64(zzhcl.LONG, 0),
    INT32(zzhcl.INT, 0),
    FIXED64(zzhcl.LONG, 1),
    FIXED32(zzhcl.INT, 5),
    BOOL(zzhcl.BOOLEAN, 0),
    STRING(zzhcl.STRING, 2),
    GROUP(zzhcl.MESSAGE, 3),
    MESSAGE(zzhcl.MESSAGE, 2),
    BYTES(zzhcl.BYTE_STRING, 2),
    UINT32(zzhcl.INT, 0),
    ENUM(zzhcl.ENUM, 0),
    SFIXED32(zzhcl.INT, 5),
    SFIXED64(zzhcl.LONG, 1),
    SINT32(zzhcl.INT, 0),
    SINT64(zzhcl.LONG, 0);

    private final zzhcl zzt;

    zzhck(zzhcl zzhclVar, int i) {
        this.zzt = zzhclVar;
    }

    public final zzhcl zza() {
        return this.zzt;
    }
}
