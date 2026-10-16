package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public enum zzgyx {
    DOUBLE(0, 1, zzgzy.DOUBLE),
    FLOAT(1, 1, zzgzy.FLOAT),
    INT64(2, 1, zzgzy.LONG),
    UINT64(3, 1, zzgzy.LONG),
    INT32(4, 1, zzgzy.INT),
    FIXED64(5, 1, zzgzy.LONG),
    FIXED32(6, 1, zzgzy.INT),
    BOOL(7, 1, zzgzy.BOOLEAN),
    STRING(8, 1, zzgzy.STRING),
    MESSAGE(9, 1, zzgzy.MESSAGE),
    BYTES(10, 1, zzgzy.BYTE_STRING),
    UINT32(11, 1, zzgzy.INT),
    ENUM(12, 1, zzgzy.ENUM),
    SFIXED32(13, 1, zzgzy.INT),
    SFIXED64(14, 1, zzgzy.LONG),
    SINT32(15, 1, zzgzy.INT),
    SINT64(16, 1, zzgzy.LONG),
    GROUP(17, 1, zzgzy.MESSAGE),
    DOUBLE_LIST(18, 2, zzgzy.DOUBLE),
    FLOAT_LIST(19, 2, zzgzy.FLOAT),
    INT64_LIST(20, 2, zzgzy.LONG),
    UINT64_LIST(21, 2, zzgzy.LONG),
    INT32_LIST(22, 2, zzgzy.INT),
    FIXED64_LIST(23, 2, zzgzy.LONG),
    FIXED32_LIST(24, 2, zzgzy.INT),
    BOOL_LIST(25, 2, zzgzy.BOOLEAN),
    STRING_LIST(26, 2, zzgzy.STRING),
    MESSAGE_LIST(27, 2, zzgzy.MESSAGE),
    BYTES_LIST(28, 2, zzgzy.BYTE_STRING),
    UINT32_LIST(29, 2, zzgzy.INT),
    ENUM_LIST(30, 2, zzgzy.ENUM),
    SFIXED32_LIST(31, 2, zzgzy.INT),
    SFIXED64_LIST(32, 2, zzgzy.LONG),
    SINT32_LIST(33, 2, zzgzy.INT),
    SINT64_LIST(34, 2, zzgzy.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzgzy.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzgzy.FLOAT),
    INT64_LIST_PACKED(37, 3, zzgzy.LONG),
    UINT64_LIST_PACKED(38, 3, zzgzy.LONG),
    INT32_LIST_PACKED(39, 3, zzgzy.INT),
    FIXED64_LIST_PACKED(40, 3, zzgzy.LONG),
    FIXED32_LIST_PACKED(41, 3, zzgzy.INT),
    BOOL_LIST_PACKED(42, 3, zzgzy.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzgzy.INT),
    ENUM_LIST_PACKED(44, 3, zzgzy.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzgzy.INT),
    SFIXED64_LIST_PACKED(46, 3, zzgzy.LONG),
    SINT32_LIST_PACKED(47, 3, zzgzy.INT),
    SINT64_LIST_PACKED(48, 3, zzgzy.LONG),
    GROUP_LIST(49, 2, zzgzy.MESSAGE),
    MAP(50, 4, zzgzy.VOID);

    private static final zzgyx[] zzZ;
    private final int zzab;

    static {
        zzgyx[] values = values();
        zzZ = new zzgyx[values.length];
        for (zzgyx zzgyxVar : values) {
            zzZ[zzgyxVar.zzab] = zzgyxVar;
        }
    }

    zzgyx(int i, int i2, zzgzy zzgzyVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1) {
            zzgzyVar.zza();
        } else if (i3 == 3) {
            zzgzyVar.zza();
        }
        if (i2 == 1) {
            zzgzy zzgzyVar2 = zzgzy.VOID;
            zzgzyVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
