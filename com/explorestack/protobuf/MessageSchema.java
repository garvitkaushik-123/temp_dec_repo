package com.explorestack.protobuf;

import com.explorestack.protobuf.ArrayDecoders;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.FieldSet;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.MapEntryLite;
import com.explorestack.protobuf.WireFormat;
import com.explorestack.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean isRequired(int i) {
        return (i & 268435456) != 0;
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int charAt;
        int charAt2;
        int charAt3;
        int charAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        char charAt5;
        int i6;
        char charAt6;
        int i7;
        char charAt7;
        int i8;
        char charAt8;
        int i9;
        char charAt9;
        int i10;
        char charAt10;
        int i11;
        char charAt11;
        int i12;
        char charAt12;
        int i13;
        int i14;
        int i15;
        int objectFieldOffset;
        String str;
        int i16;
        int i17;
        int i18;
        int i19;
        java.lang.reflect.Field reflectField;
        char charAt13;
        int i20;
        Object obj;
        java.lang.reflect.Field reflectField2;
        Object obj2;
        java.lang.reflect.Field reflectField3;
        int i21;
        char charAt14;
        int i22;
        char charAt15;
        int i23;
        char charAt16;
        int i24;
        char charAt17;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i25 = 1;
            while (true) {
                i = i25 + 1;
                if (stringInfo.charAt(i25) < 55296) {
                    break;
                }
                i25 = i;
            }
        } else {
            i = 1;
        }
        int i26 = i + 1;
        int charAt18 = stringInfo.charAt(i);
        if (charAt18 >= 55296) {
            int i27 = charAt18 & 8191;
            int i28 = 13;
            while (true) {
                i24 = i26 + 1;
                charAt17 = stringInfo.charAt(i26);
                if (charAt17 < 55296) {
                    break;
                }
                i27 |= (charAt17 & 8191) << i28;
                i28 += 13;
                i26 = i24;
            }
            charAt18 = i27 | (charAt17 << i28);
            i26 = i24;
        }
        if (charAt18 == 0) {
            charAt = 0;
            charAt2 = 0;
            charAt3 = 0;
            i3 = 0;
            charAt4 = 0;
            i2 = 0;
            iArr = EMPTY_INT_ARRAY;
            i4 = 0;
        } else {
            int i29 = i26 + 1;
            int charAt19 = stringInfo.charAt(i26);
            if (charAt19 >= 55296) {
                int i30 = charAt19 & 8191;
                int i31 = 13;
                while (true) {
                    i12 = i29 + 1;
                    charAt12 = stringInfo.charAt(i29);
                    if (charAt12 < 55296) {
                        break;
                    }
                    i30 |= (charAt12 & 8191) << i31;
                    i31 += 13;
                    i29 = i12;
                }
                charAt19 = i30 | (charAt12 << i31);
                i29 = i12;
            }
            int i32 = i29 + 1;
            int charAt20 = stringInfo.charAt(i29);
            if (charAt20 >= 55296) {
                int i33 = charAt20 & 8191;
                int i34 = 13;
                while (true) {
                    i11 = i32 + 1;
                    charAt11 = stringInfo.charAt(i32);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i33 |= (charAt11 & 8191) << i34;
                    i34 += 13;
                    i32 = i11;
                }
                charAt20 = i33 | (charAt11 << i34);
                i32 = i11;
            }
            int i35 = i32 + 1;
            charAt = stringInfo.charAt(i32);
            if (charAt >= 55296) {
                int i36 = charAt & 8191;
                int i37 = 13;
                while (true) {
                    i10 = i35 + 1;
                    charAt10 = stringInfo.charAt(i35);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i36 |= (charAt10 & 8191) << i37;
                    i37 += 13;
                    i35 = i10;
                }
                charAt = i36 | (charAt10 << i37);
                i35 = i10;
            }
            int i38 = i35 + 1;
            charAt2 = stringInfo.charAt(i35);
            if (charAt2 >= 55296) {
                int i39 = charAt2 & 8191;
                int i40 = 13;
                while (true) {
                    i9 = i38 + 1;
                    charAt9 = stringInfo.charAt(i38);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i39 |= (charAt9 & 8191) << i40;
                    i40 += 13;
                    i38 = i9;
                }
                charAt2 = i39 | (charAt9 << i40);
                i38 = i9;
            }
            int i41 = i38 + 1;
            charAt3 = stringInfo.charAt(i38);
            if (charAt3 >= 55296) {
                int i42 = charAt3 & 8191;
                int i43 = 13;
                while (true) {
                    i8 = i41 + 1;
                    charAt8 = stringInfo.charAt(i41);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i42 |= (charAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i8;
                }
                charAt3 = i42 | (charAt8 << i43);
                i41 = i8;
            }
            int i44 = i41 + 1;
            int charAt21 = stringInfo.charAt(i41);
            if (charAt21 >= 55296) {
                int i45 = charAt21 & 8191;
                int i46 = 13;
                while (true) {
                    i7 = i44 + 1;
                    charAt7 = stringInfo.charAt(i44);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i45 |= (charAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i7;
                }
                charAt21 = i45 | (charAt7 << i46);
                i44 = i7;
            }
            int i47 = i44 + 1;
            int charAt22 = stringInfo.charAt(i44);
            if (charAt22 >= 55296) {
                int i48 = charAt22 & 8191;
                int i49 = 13;
                while (true) {
                    i6 = i47 + 1;
                    charAt6 = stringInfo.charAt(i47);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i48 |= (charAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i6;
                }
                charAt22 = i48 | (charAt6 << i49);
                i47 = i6;
            }
            int i50 = i47 + 1;
            charAt4 = stringInfo.charAt(i47);
            if (charAt4 >= 55296) {
                int i51 = charAt4 & 8191;
                int i52 = 13;
                while (true) {
                    i5 = i50 + 1;
                    charAt5 = stringInfo.charAt(i50);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i51 |= (charAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i5;
                }
                charAt4 = i51 | (charAt5 << i52);
                i50 = i5;
            }
            int[] iArr2 = new int[charAt4 + charAt21 + charAt22];
            i2 = (charAt19 * 2) + charAt20;
            i3 = charAt21;
            iArr = iArr2;
            i4 = charAt19;
            i26 = i50;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[charAt3 * 3];
        Object[] objArr = new Object[charAt3 * 2];
        int i53 = i3 + charAt4;
        int i54 = i53;
        int i55 = charAt4;
        int i56 = 0;
        int i57 = 0;
        while (i26 < length) {
            int i58 = i26 + 1;
            int charAt23 = stringInfo.charAt(i26);
            if (charAt23 >= c) {
                int i59 = charAt23 & 8191;
                int i60 = i58;
                int i61 = 13;
                while (true) {
                    i23 = i60 + 1;
                    charAt16 = stringInfo.charAt(i60);
                    if (charAt16 < c) {
                        break;
                    }
                    i59 |= (charAt16 & 8191) << i61;
                    i61 += 13;
                    i60 = i23;
                }
                charAt23 = i59 | (charAt16 << i61);
                i13 = i23;
            } else {
                i13 = i58;
            }
            int i62 = i13 + 1;
            int charAt24 = stringInfo.charAt(i13);
            if (charAt24 >= c) {
                int i63 = charAt24 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i22 = i64 + 1;
                    charAt15 = stringInfo.charAt(i64);
                    i14 = length;
                    if (charAt15 < 55296) {
                        break;
                    }
                    i63 |= (charAt15 & 8191) << i65;
                    i65 += 13;
                    i64 = i22;
                    length = i14;
                }
                charAt24 = i63 | (charAt15 << i65);
                i15 = i22;
            } else {
                i14 = length;
                i15 = i62;
            }
            int i66 = charAt24 & 255;
            int[] iArr4 = iArr3;
            if ((charAt24 & 1024) != 0) {
                iArr[i56] = i57;
                i56++;
            }
            int i67 = charAt23;
            if (i66 >= 51) {
                int i68 = i15 + 1;
                int charAt25 = stringInfo.charAt(i15);
                char c2 = 55296;
                if (charAt25 >= 55296) {
                    int i69 = charAt25 & 8191;
                    int i70 = 13;
                    while (true) {
                        i21 = i68 + 1;
                        charAt14 = stringInfo.charAt(i68);
                        if (charAt14 < c2) {
                            break;
                        }
                        i69 |= (charAt14 & 8191) << i70;
                        i70 += 13;
                        i68 = i21;
                        c2 = 55296;
                    }
                    charAt25 = i69 | (charAt14 << i70);
                    i68 = i21;
                }
                int i71 = i66 - 51;
                int i72 = charAt25;
                if (i71 == 9 || i71 == 17) {
                    i20 = i2 + 1;
                    objArr[((i57 / 3) * 2) + 1] = objects[i2];
                } else {
                    if (i71 == 12 && !z) {
                        i20 = i2 + 1;
                        objArr[((i57 / 3) * 2) + 1] = objects[i2];
                    }
                    int i73 = i72 * 2;
                    obj = objects[i73];
                    if (!(obj instanceof java.lang.reflect.Field)) {
                        reflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        reflectField2 = reflectField(cls, (String) obj);
                        objects[i73] = reflectField2;
                    }
                    int i74 = i68;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(reflectField2);
                    int i75 = i73 + 1;
                    obj2 = objects[i75];
                    if (!(obj2 instanceof java.lang.reflect.Field)) {
                        reflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        reflectField3 = reflectField(cls, (String) obj2);
                        objects[i75] = reflectField3;
                    }
                    str = stringInfo;
                    i16 = (int) unsafe.objectFieldOffset(reflectField3);
                    i26 = i74;
                    i19 = objectFieldOffset2;
                    i18 = 0;
                }
                i2 = i20;
                int i732 = i72 * 2;
                obj = objects[i732];
                if (!(obj instanceof java.lang.reflect.Field)) {
                }
                int i742 = i68;
                int objectFieldOffset22 = (int) unsafe.objectFieldOffset(reflectField2);
                int i752 = i732 + 1;
                obj2 = objects[i752];
                if (!(obj2 instanceof java.lang.reflect.Field)) {
                }
                str = stringInfo;
                i16 = (int) unsafe.objectFieldOffset(reflectField3);
                i26 = i742;
                i19 = objectFieldOffset22;
                i18 = 0;
            } else {
                int i76 = i2 + 1;
                java.lang.reflect.Field reflectField4 = reflectField(cls, (String) objects[i2]);
                if (i66 == 9 || i66 == 17) {
                    objArr[((i57 / 3) * 2) + 1] = reflectField4.getType();
                } else {
                    if (i66 == 27 || i66 == 49) {
                        i2 += 2;
                        objArr[((i57 / 3) * 2) + 1] = objects[i76];
                    } else if (i66 == 12 || i66 == 30 || i66 == 44) {
                        if (!z) {
                            i2 += 2;
                            objArr[((i57 / 3) * 2) + 1] = objects[i76];
                        }
                    } else if (i66 == 50) {
                        int i77 = i55 + 1;
                        iArr[i55] = i57;
                        int i78 = (i57 / 3) * 2;
                        int i79 = i2 + 2;
                        objArr[i78] = objects[i76];
                        if ((charAt24 & 2048) != 0) {
                            objArr[i78 + 1] = objects[i79];
                            i2 += 3;
                        } else {
                            i2 = i79;
                        }
                        i55 = i77;
                    }
                    objectFieldOffset = (int) unsafe.objectFieldOffset(reflectField4);
                    if ((charAt24 & 4096) == 4096 || i66 > 17) {
                        str = stringInfo;
                        i16 = 1048575;
                        i17 = i15;
                        i18 = 0;
                    } else {
                        int i80 = i15 + 1;
                        int charAt26 = stringInfo.charAt(i15);
                        if (charAt26 >= 55296) {
                            int i81 = charAt26 & 8191;
                            int i82 = 13;
                            while (true) {
                                i17 = i80 + 1;
                                charAt13 = stringInfo.charAt(i80);
                                if (charAt13 < 55296) {
                                    break;
                                }
                                i81 |= (charAt13 & 8191) << i82;
                                i82 += 13;
                                i80 = i17;
                            }
                            charAt26 = i81 | (charAt13 << i82);
                        } else {
                            i17 = i80;
                        }
                        int i83 = (i4 * 2) + (charAt26 / 32);
                        Object obj3 = objects[i83];
                        str = stringInfo;
                        if (obj3 instanceof java.lang.reflect.Field) {
                            reflectField = (java.lang.reflect.Field) obj3;
                        } else {
                            reflectField = reflectField(cls, (String) obj3);
                            objects[i83] = reflectField;
                        }
                        i16 = (int) unsafe.objectFieldOffset(reflectField);
                        i18 = charAt26 % 32;
                    }
                    if (i66 >= 18 && i66 <= 49) {
                        iArr[i54] = objectFieldOffset;
                        i54++;
                    }
                    i19 = objectFieldOffset;
                    i26 = i17;
                }
                i2 = i76;
                objectFieldOffset = (int) unsafe.objectFieldOffset(reflectField4);
                if ((charAt24 & 4096) == 4096) {
                }
                str = stringInfo;
                i16 = 1048575;
                i17 = i15;
                i18 = 0;
                if (i66 >= 18) {
                    iArr[i54] = objectFieldOffset;
                    i54++;
                }
                i19 = objectFieldOffset;
                i26 = i17;
            }
            int i84 = i57 + 1;
            iArr4[i57] = i67;
            int i85 = i57 + 2;
            int i86 = i16;
            iArr4[i84] = ((charAt24 & 512) != 0 ? 536870912 : 0) | ((charAt24 & 256) != 0 ? 268435456 : 0) | (i66 << 20) | i19;
            i57 += 3;
            iArr4[i85] = (i18 << 20) | i86;
            iArr3 = iArr4;
            length = i14;
            stringInfo = str;
            c = 55296;
        }
        return new MessageSchema<>(iArr3, objArr, charAt, charAt2, rawMessageInfo.getDefaultInstance(), z, false, iArr, charAt4, i53, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i7] = i5;
                i7++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i = i5;
                iArr3[i8] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i8++;
                i4++;
                i5 = i + 3;
            }
            i = i5;
            i4++;
            i5 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, Object[] objArr) {
        int objectFieldOffset;
        int id;
        long objectFieldOffset2;
        int i2;
        int i3;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof != null) {
            id = fieldInfo.getType().id() + 51;
            objectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            objectFieldOffset2 = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fieldInfo.getType();
            objectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            id = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fieldInfo.getPresenceField();
                i2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                i3 = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                i2 = 0;
                i3 = 0;
            } else {
                objectFieldOffset2 = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i] = fieldInfo.getFieldNumber();
            iArr[i + 1] = (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | (id << 20) | objectFieldOffset;
            iArr[i + 2] = i2 | (i3 << 20);
            Class<?> messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            int i4 = (i / 3) * 2;
            objArr[i4] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i4 + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[i4 + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i2 = (int) objectFieldOffset2;
        i3 = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        if (!fieldInfo.isEnforceUtf8()) {
        }
        iArr[i + 1] = (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | (id << 20) | objectFieldOffset;
        iArr[i + 2] = i2 | (i3 << 20);
        Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
        }
    }

    @Override // com.explorestack.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.explorestack.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t, t2, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t2, offset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t, t2, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t, offset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t2, offset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, offset) != UnsafeUtil.getLong(t2, offset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, offset) != UnsafeUtil.getLong(t2, offset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, offset) != UnsafeUtil.getInt(t2, offset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, offset) != UnsafeUtil.getLong(t2, offset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, offset) != UnsafeUtil.getInt(t2, offset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getBoolean(t, offset) != UnsafeUtil.getBoolean(t2, offset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, offset) != UnsafeUtil.getInt(t2, offset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, offset) != UnsafeUtil.getInt(t2, offset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, offset) != UnsafeUtil.getInt(t2, offset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, offset) != UnsafeUtil.getLong(t2, offset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, offset) != UnsafeUtil.getInt(t2, offset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, offset) != UnsafeUtil.getLong(t2, offset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, offset), UnsafeUtil.getObject(t2, offset))) {
                }
                break;
        }
        return true;
    }

    @Override // com.explorestack.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int hashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i3);
            int numberAt = numberAt(i3);
            long offset = offset(typeAndOffsetAt);
            int i4 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, offset)));
                    i2 = i + hashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, offset));
                    i2 = i + hashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, offset));
                    i2 = i + hashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    hashLong = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                    i2 = i + hashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, offset);
                    if (object != null) {
                        i4 = object.hashCode();
                    }
                    i2 = (i2 * 53) + i4;
                    break;
                case 10:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getInt(t, offset);
                    i2 = i + hashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t, offset));
                    i2 = i + hashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, offset);
                    if (object2 != null) {
                        i4 = object2.hashCode();
                    }
                    i2 = (i2 * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                    i2 = i + hashLong;
                    break;
                case 51:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, offset)));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Float.floatToIntBits(oneofFloatAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashBoolean(oneofBooleanAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = ((String) UnsafeUtil.getObject(t, offset)).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = oneofIntAt(t, offset);
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t, offset));
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, numberAt, i3)) {
                        i = i2 * 53;
                        hashLong = UnsafeUtil.getObject(t, offset).hashCode();
                        i2 = i + hashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode() : hashCode;
    }

    @Override // com.explorestack.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, offset, UnsafeUtil.getDouble(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, offset, UnsafeUtil.getFloat(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, offset, UnsafeUtil.getBoolean(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, offset, UnsafeUtil.getInt(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, offset, UnsafeUtil.getLong(t2, offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, offset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, offset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, numberAt, i)) {
                    UnsafeUtil.putObject(t, offset, UnsafeUtil.getObject(t2, offset));
                    setOneofPresent(t, numberAt, i);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    private void mergeMessage(T t, T t2, int i) {
        long offset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, offset);
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        int numberAt = numberAt(i);
        long offset = offset(typeAndOffsetAt);
        if (isOneofPresent(t2, numberAt, i)) {
            Object object = isOneofPresent(t, numberAt, i) ? UnsafeUtil.getObject(t, offset) : null;
            Object object2 = UnsafeUtil.getObject(t2, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, offset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, numberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, offset, object2);
                setOneofPresent(t, numberAt, i);
            }
        }
    }

    @Override // com.explorestack.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSFixed32Size;
        boolean z;
        int computeSizeFixed32List;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < this.buffer.length) {
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            int numberAt = numberAt(i5);
            int type = type(typeAndOffsetAt);
            if (type <= 17) {
                i = this.buffer[i5 + 2];
                int i8 = i & i3;
                i2 = 1 << (i >>> 20);
                if (i8 != i4) {
                    i7 = unsafe.getInt(t, i8);
                    i4 = i8;
                }
            } else {
                i = (!this.useCachedSizeField || type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i5 + 2] & i3;
                i2 = 0;
            }
            long offset = offset(typeAndOffsetAt);
            switch (type) {
                case 0:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 1:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 2:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(t, offset));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 3:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(t, offset));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 4:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(t, offset));
                        i6 += computeDoubleSize;
                        break;
                    }
                case 5:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i6 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if ((i7 & i2) != 0) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i6 += computeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i6 += computeBoolSize;
                    }
                    break;
                case 8:
                    if ((i7 & i2) != 0) {
                        Object object = unsafe.getObject(t, offset);
                        if (object instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(numberAt, (String) object);
                        }
                        i6 += computeBoolSize;
                    }
                    break;
                case 9:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i5));
                        i6 += computeBoolSize;
                    }
                    break;
                case 10:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 11:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 12:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 13:
                    if ((i7 & i2) != 0) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i6 += computeBoolSize;
                    }
                    break;
                case 15:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 16:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 17:
                    if ((i7 & i2) != 0) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t, offset), getMessageFieldSchema(i5));
                        i6 += computeBoolSize;
                    }
                    break;
                case 18:
                    computeBoolSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeBoolSize;
                    break;
                case 19:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 23:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 26:
                    computeBoolSize = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(t, offset));
                    i6 += computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(t, offset), getMessageFieldSchema(i5));
                    i6 += computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(t, offset));
                    i6 += computeBoolSize;
                    break;
                case 29:
                    computeBoolSize = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeBoolSize;
                    break;
                case 30:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 31:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(t, offset), false);
                    i6 += computeSizeFixed32List;
                    break;
                case 35:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 36:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 37:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 38:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 39:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 40:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 41:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 42:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 43:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 44:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 45:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 46:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 47:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 48:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 49:
                    computeBoolSize = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(t, offset), getMessageFieldSchema(i5));
                    i6 += computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(t, offset), getMapFieldDefaultEntry(i5));
                    i6 += computeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i6 += computeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i6 += computeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i6 += computeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeSFixed32Size = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i6 += computeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, numberAt, i5)) {
                        Object object2 = unsafe.getObject(t, offset);
                        if (object2 instanceof ByteString) {
                            computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2);
                        } else {
                            computeBoolSize = CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        }
                        i6 += computeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i5));
                        i6 += computeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i6 += computeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i6 += computeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t, offset));
                        i6 += computeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, numberAt, i5)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t, offset), getMessageFieldSchema(i5));
                        i6 += computeBoolSize;
                    }
                    break;
            }
            i5 += 3;
            i3 = 1048575;
        }
        int unknownFieldsSerializedSize = i6 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int computeDoubleSize;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i2);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i2);
            long offset = offset(typeAndOffsetAt);
            int i3 = (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i2 + 2] & 1048575;
            switch (type) {
                case 0:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, i2)) {
                        Object object = UnsafeUtil.getObject(t, offset);
                        if (object instanceof ByteString) {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object);
                        } else {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object);
                        }
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i2));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, UnsafeUtil.getInt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, UnsafeUtil.getInt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, UnsafeUtil.getLong(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, i2)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i2));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 19:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 20:
                    computeDoubleSize = SchemaUtil.computeSizeInt64List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 21:
                    computeDoubleSize = SchemaUtil.computeSizeUInt64List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 22:
                    computeDoubleSize = SchemaUtil.computeSizeInt32List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 23:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 24:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 25:
                    computeDoubleSize = SchemaUtil.computeSizeBoolList(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 26:
                    computeDoubleSize = SchemaUtil.computeSizeStringList(numberAt, listAt(t, offset));
                    i += computeDoubleSize;
                    break;
                case 27:
                    computeDoubleSize = SchemaUtil.computeSizeMessageList(numberAt, listAt(t, offset), getMessageFieldSchema(i2));
                    i += computeDoubleSize;
                    break;
                case 28:
                    computeDoubleSize = SchemaUtil.computeSizeByteStringList(numberAt, listAt(t, offset));
                    i += computeDoubleSize;
                    break;
                case 29:
                    computeDoubleSize = SchemaUtil.computeSizeUInt32List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 30:
                    computeDoubleSize = SchemaUtil.computeSizeEnumList(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 31:
                    computeDoubleSize = SchemaUtil.computeSizeFixed32List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 32:
                    computeDoubleSize = SchemaUtil.computeSizeFixed64List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 33:
                    computeDoubleSize = SchemaUtil.computeSizeSInt32List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 34:
                    computeDoubleSize = SchemaUtil.computeSizeSInt64List(numberAt, listAt(t, offset), false);
                    i += computeDoubleSize;
                    break;
                case 35:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 36:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 37:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 38:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 39:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 40:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 41:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 42:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 43:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 44:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 45:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 46:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 47:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 48:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, offset));
                    if (computeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeDoubleSize = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i += computeDoubleSize;
                        break;
                    }
                case 49:
                    computeDoubleSize = SchemaUtil.computeSizeGroupList(numberAt, listAt(t, offset), getMessageFieldSchema(i2));
                    i += computeDoubleSize;
                    break;
                case 50:
                    computeDoubleSize = this.mapFieldSchema.getSerializedSize(numberAt, UnsafeUtil.getObject(t, offset), getMapFieldDefaultEntry(i2));
                    i += computeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, numberAt, i2)) {
                        Object object2 = UnsafeUtil.getObject(t, offset);
                        if (object2 instanceof ByteString) {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2);
                        } else {
                            computeDoubleSize = CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        }
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = SchemaUtil.computeSizeMessage(numberAt, UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i2));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) UnsafeUtil.getObject(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t, offset));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, numberAt, i2)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) UnsafeUtil.getObject(t, offset), getMessageFieldSchema(i2));
                        i += computeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    @Override // com.explorestack.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i;
        int i2;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
                length = this.buffer.length;
                Unsafe unsafe = UNSAFE;
                int i3 = 1048575;
                int i4 = 0;
                for (i = 0; i < length; i += 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    int type = type(typeAndOffsetAt);
                    if (type <= 17) {
                        int i5 = this.buffer[i + 2];
                        int i6 = i5 & 1048575;
                        if (i6 != i3) {
                            i4 = unsafe.getInt(t, i6);
                            i3 = i6;
                        }
                        i2 = 1 << (i5 >>> 20);
                    } else {
                        i2 = 0;
                    }
                    while (entry != null && this.extensionSchema.extensionNumber(entry) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long offset = offset(typeAndOffsetAt);
                    switch (type) {
                        case 0:
                            if ((i2 & i4) == 0) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, doubleAt(t, offset));
                                continue;
                            }
                        case 1:
                            if ((i2 & i4) != 0) {
                                writer.writeFloat(numberAt, floatAt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i2 & i4) != 0) {
                                writer.writeInt64(numberAt, unsafe.getLong(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i2 & i4) != 0) {
                                writer.writeUInt64(numberAt, unsafe.getLong(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i2 & i4) != 0) {
                                writer.writeInt32(numberAt, unsafe.getInt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i2 & i4) != 0) {
                                writer.writeFixed64(numberAt, unsafe.getLong(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i2 & i4) != 0) {
                                writer.writeFixed32(numberAt, unsafe.getInt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i2 & i4) != 0) {
                                writer.writeBool(numberAt, booleanAt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i2 & i4) != 0) {
                                writeString(numberAt, unsafe.getObject(t, offset), writer);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i2 & i4) != 0) {
                                writer.writeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                                break;
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i2 & i4) != 0) {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i2 & i4) != 0) {
                                writer.writeUInt32(numberAt, unsafe.getInt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i2 & i4) != 0) {
                                writer.writeEnum(numberAt, unsafe.getInt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i2 & i4) != 0) {
                                writer.writeSFixed32(numberAt, unsafe.getInt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i2 & i4) != 0) {
                                writer.writeSFixed64(numberAt, unsafe.getLong(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i2 & i4) != 0) {
                                writer.writeSInt32(numberAt, unsafe.getInt(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i2 & i4) != 0) {
                                writer.writeSInt64(numberAt, unsafe.getLong(t, offset));
                                break;
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i2 & i4) != 0) {
                                writer.writeGroup(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                                break;
                            } else {
                                continue;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i), (List) unsafe.getObject(t, offset), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i), (List) unsafe.getObject(t, offset), writer, getMessageFieldSchema(i));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i), (List) unsafe.getObject(t, offset), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, false);
                            continue;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) unsafe.getObject(t, offset), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(i), (List) unsafe.getObject(t, offset), writer, getMessageFieldSchema(i));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, unsafe.getObject(t, offset), i);
                            break;
                        case 51:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset));
                                break;
                            }
                            break;
                        case 52:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset));
                                break;
                            }
                            break;
                        case 53:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 54:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 55:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 56:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 57:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 58:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset));
                                break;
                            }
                            break;
                        case 59:
                            if (isOneofPresent(t, numberAt, i)) {
                                writeString(numberAt, unsafe.getObject(t, offset), writer);
                                break;
                            }
                            break;
                        case 60:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeMessage(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                                break;
                            }
                            break;
                        case 61:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(t, offset));
                                break;
                            }
                            break;
                        case 62:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 63:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 64:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 65:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 66:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset));
                                break;
                            }
                            break;
                        case 67:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset));
                                break;
                            }
                            break;
                        case 68:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeGroup(numberAt, unsafe.getObject(t, offset), getMessageFieldSchema(i));
                                break;
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
            }
        }
        it = null;
        entry = null;
        length = this.buffer.length;
        Unsafe unsafe2 = UNSAFE;
        int i32 = 1048575;
        int i42 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
                length = this.buffer.length;
                for (i = 0; i < length; i += 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(i);
                    int numberAt = numberAt(i);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (isFieldPresent(t, i)) {
                                writer.writeDouble(numberAt, doubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (isFieldPresent(t, i)) {
                                writer.writeFloat(numberAt, floatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (isFieldPresent(t, i)) {
                                writer.writeInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (isFieldPresent(t, i)) {
                                writer.writeUInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (isFieldPresent(t, i)) {
                                writer.writeInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (isFieldPresent(t, i)) {
                                writer.writeFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (isFieldPresent(t, i)) {
                                writer.writeFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (isFieldPresent(t, i)) {
                                writer.writeBool(numberAt, booleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (isFieldPresent(t, i)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (isFieldPresent(t, i)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (isFieldPresent(t, i)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (isFieldPresent(t, i)) {
                                writer.writeUInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (isFieldPresent(t, i)) {
                                writer.writeEnum(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (isFieldPresent(t, i)) {
                                writer.writeSFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (isFieldPresent(t, i)) {
                                writer.writeSFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (isFieldPresent(t, i)) {
                                writer.writeSInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (isFieldPresent(t, i)) {
                                writer.writeSInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (isFieldPresent(t, i)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(i));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(i));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), i);
                            break;
                        case 51:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (isOneofPresent(t, numberAt, i)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (isOneofPresent(t, numberAt, i)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(i));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
            }
        }
        it = null;
        entry = null;
        length = this.buffer.length;
        while (i < length) {
        }
        while (entry != null) {
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            if (!extensions.isEmpty()) {
                it = extensions.descendingIterator();
                entry = (Map.Entry) it.next();
                for (length = this.buffer.length - 3; length >= 0; length -= 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(length);
                    int numberAt = numberAt(length);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) > numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (isFieldPresent(t, length)) {
                                writer.writeDouble(numberAt, doubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (isFieldPresent(t, length)) {
                                writer.writeFloat(numberAt, floatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (isFieldPresent(t, length)) {
                                writer.writeInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (isFieldPresent(t, length)) {
                                writer.writeUInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (isFieldPresent(t, length)) {
                                writer.writeInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (isFieldPresent(t, length)) {
                                writer.writeFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (isFieldPresent(t, length)) {
                                writer.writeFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (isFieldPresent(t, length)) {
                                writer.writeBool(numberAt, booleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (isFieldPresent(t, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (isFieldPresent(t, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (isFieldPresent(t, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (isFieldPresent(t, length)) {
                                writer.writeUInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (isFieldPresent(t, length)) {
                                writer.writeEnum(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (isFieldPresent(t, length)) {
                                writer.writeSFixed32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (isFieldPresent(t, length)) {
                                writer.writeSFixed64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (isFieldPresent(t, length)) {
                                writer.writeSInt32(numberAt, intAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (isFieldPresent(t, length)) {
                                writer.writeSInt64(numberAt, longAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (isFieldPresent(t, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 23:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 24:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                            break;
                        case 29:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), length);
                            break;
                        case 51:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (isOneofPresent(t, numberAt, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeEnum(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (isOneofPresent(t, numberAt, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.explorestack.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B:290:0x0076, code lost:
    
        r0 = r14.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x007a, code lost:
    
        if (r0 >= r14.repeatedFieldOffsetStart) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x007c, code lost:
    
        r7 = filterMapUnknownEnumValues(r9, r14.intArray[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0087, code lost:
    
        if (r7 == null) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0601 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x05e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0631 A[LOOP:3: B:62:0x062d->B:64:0x0631, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x063e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i;
        ExtensionSchema<ET> extensionSchema2;
        Object findExtensionByNumber;
        Object obj;
        T t2 = t;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
        Object obj2 = null;
        FieldSet<ET> fieldSet = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int positionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (positionForFieldNumber >= 0) {
                    Reader reader2 = reader;
                    obj = obj2;
                    int typeAndOffsetAt = typeAndOffsetAt(positionForFieldNumber);
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            UnsafeUtil.putDouble(t2, offset(typeAndOffsetAt), reader2.readDouble());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 1:
                            UnsafeUtil.putFloat(t2, offset(typeAndOffsetAt), reader2.readFloat());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 2:
                            UnsafeUtil.putLong(t2, offset(typeAndOffsetAt), reader2.readInt64());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 3:
                            UnsafeUtil.putLong(t2, offset(typeAndOffsetAt), reader2.readUInt64());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 4:
                            UnsafeUtil.putInt(t2, offset(typeAndOffsetAt), reader2.readInt32());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 5:
                            UnsafeUtil.putLong(t2, offset(typeAndOffsetAt), reader2.readFixed64());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 6:
                            UnsafeUtil.putInt(t2, offset(typeAndOffsetAt), reader2.readFixed32());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 7:
                            UnsafeUtil.putBoolean(t2, offset(typeAndOffsetAt), reader2.readBool());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 8:
                            readString(t2, typeAndOffsetAt, reader2);
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 9:
                            if (isFieldPresent(t2, positionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(typeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, positionForFieldNumber);
                            }
                            obj2 = obj;
                        case 10:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), reader2.readBytes());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 11:
                            UnsafeUtil.putInt(t2, offset(typeAndOffsetAt), reader2.readUInt32());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 12:
                            int readEnum = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(positionForFieldNumber);
                            if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(readEnum)) {
                                obj2 = SchemaUtil.storeUnknownEnum(fieldNumber, readEnum, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putInt(t2, offset(typeAndOffsetAt), readEnum);
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                            break;
                        case 13:
                            UnsafeUtil.putInt(t2, offset(typeAndOffsetAt), reader2.readSFixed32());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 14:
                            UnsafeUtil.putLong(t2, offset(typeAndOffsetAt), reader2.readSFixed64());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 15:
                            UnsafeUtil.putInt(t2, offset(typeAndOffsetAt), reader2.readSInt32());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 16:
                            UnsafeUtil.putLong(t2, offset(typeAndOffsetAt), reader2.readSInt64());
                            setFieldPresent(t2, positionForFieldNumber);
                            obj2 = obj;
                        case 17:
                            if (isFieldPresent(t2, positionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(typeAndOffsetAt)), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, positionForFieldNumber);
                            }
                            obj2 = obj;
                        case 18:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 19:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 20:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 21:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 22:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 23:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 24:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 25:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            obj2 = obj;
                        case 26:
                            readStringList(t2, typeAndOffsetAt, reader2);
                            obj2 = obj;
                        case 27:
                            T t3 = t2;
                            try {
                                readMessageList(t3, typeAndOffsetAt, reader2, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite);
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                obj2 = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                t2 = t3;
                                extensionRegistryLite2 = extensionRegistryLite;
                                obj2 = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 28:
                            reader2.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 29:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 30:
                            List<Integer> mutableListAt = this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt));
                            reader2.readEnumList(mutableListAt);
                            obj2 = SchemaUtil.filterUnknownEnumList(fieldNumber, mutableListAt, getEnumFieldVerifier(positionForFieldNumber), obj, unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                        case 31:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 32:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 33:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 34:
                            reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 35:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 36:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 37:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 38:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 39:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 40:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 41:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 42:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 43:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 44:
                            List<Integer> mutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt));
                            reader2.readEnumList(mutableListAt2);
                            obj2 = SchemaUtil.filterUnknownEnumList(fieldNumber, mutableListAt2, getEnumFieldVerifier(positionForFieldNumber), obj, unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                        case 45:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 46:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 47:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            obj2 = obj;
                        case 48:
                            try {
                                reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(typeAndOffsetAt)));
                                extensionRegistryLite2 = extensionRegistryLite;
                                obj2 = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                extensionRegistryLite2 = extensionRegistryLite;
                                obj2 = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 49:
                            try {
                                try {
                                    readGroupList(t, offset(typeAndOffsetAt), reader, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite);
                                    t2 = t;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    obj2 = obj;
                                } catch (Throwable th) {
                                    th = th;
                                    t2 = t;
                                    obj2 = obj;
                                    for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                        obj2 = filterMapUnknownEnumValues(t2, this.intArray[i], obj2, unknownFieldSchema);
                                    }
                                    if (obj2 != null) {
                                        unknownFieldSchema.setBuilderToMessage(t2, obj2);
                                    }
                                    throw th;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                t2 = t;
                                reader2 = reader;
                                obj2 = obj;
                                extensionRegistryLite2 = extensionRegistryLite;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (obj2 == null) {
                                        obj2 = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(obj2, reader2)) {
                                        for (int i2 = this.checkInitializedCount; i2 < this.repeatedFieldOffsetStart; i2++) {
                                            obj2 = filterMapUnknownEnumValues(t2, this.intArray[i2], obj2, unknownFieldSchema);
                                        }
                                        if (obj2 == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, obj2);
                                        return;
                                    }
                                } else if (!reader2.skipField()) {
                                    for (int i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                        obj2 = filterMapUnknownEnumValues(t2, this.intArray[i3], obj2, unknownFieldSchema);
                                    }
                                    if (obj2 == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, obj2);
                                    return;
                                }
                            }
                        case 50:
                            try {
                                mergeMap(t2, positionForFieldNumber, getMapFieldDefaultEntry(positionForFieldNumber), extensionRegistryLite2, reader);
                                t2 = t;
                                extensionRegistryLite2 = extensionRegistryLite;
                                obj2 = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                t2 = t;
                                reader2 = reader;
                                extensionRegistryLite2 = extensionRegistryLite;
                                obj2 = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                t2 = t;
                                obj2 = obj;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (obj2 != null) {
                                }
                                throw th;
                            }
                            break;
                        case 51:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Double.valueOf(reader2.readDouble()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 52:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Float.valueOf(reader2.readFloat()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 53:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Long.valueOf(reader2.readInt64()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 54:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Long.valueOf(reader2.readUInt64()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 55:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Integer.valueOf(reader2.readInt32()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 56:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Long.valueOf(reader2.readFixed64()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 57:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Integer.valueOf(reader2.readFixed32()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 58:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Boolean.valueOf(reader2.readBool()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 59:
                            readString(t2, typeAndOffsetAt, reader2);
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 60:
                            if (isOneofPresent(t2, fieldNumber, positionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(typeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, positionForFieldNumber);
                            }
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 61:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), reader2.readBytes());
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 62:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Integer.valueOf(reader2.readUInt32()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 63:
                            int readEnum2 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(positionForFieldNumber);
                            if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(readEnum2)) {
                                obj2 = SchemaUtil.storeUnknownEnum(fieldNumber, readEnum2, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Integer.valueOf(readEnum2));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                            break;
                        case 64:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Integer.valueOf(reader2.readSFixed32()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 65:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Long.valueOf(reader2.readSFixed64()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 66:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Integer.valueOf(reader2.readSInt32()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 67:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), Long.valueOf(reader2.readSInt64()));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        case 68:
                            UnsafeUtil.putObject(t2, offset(typeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2));
                            setOneofPresent(t2, fieldNumber, positionForFieldNumber);
                            obj2 = obj;
                        default:
                            obj2 = obj == null ? unknownFieldSchema.newBuilder() : obj;
                            try {
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            if (!unknownFieldSchema.mergeOneFieldFrom(obj2, reader2)) {
                                for (int i4 = this.checkInitializedCount; i4 < this.repeatedFieldOffsetStart; i4++) {
                                    obj2 = filterMapUnknownEnumValues(t2, this.intArray[i4], obj2, unknownFieldSchema);
                                }
                                if (obj2 == null) {
                                    return;
                                }
                            }
                            break;
                    }
                } else if (fieldNumber == Integer.MAX_VALUE) {
                    for (int i5 = this.checkInitializedCount; i5 < this.repeatedFieldOffsetStart; i5++) {
                        obj2 = filterMapUnknownEnumValues(t2, this.intArray[i5], obj2, unknownFieldSchema);
                    }
                    if (obj2 == null) {
                        return;
                    }
                } else {
                    if (this.hasExtensions) {
                        extensionSchema2 = extensionSchema;
                        findExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                    } else {
                        extensionSchema2 = extensionSchema;
                        findExtensionByNumber = null;
                    }
                    if (findExtensionByNumber != null) {
                        if (fieldSet == null) {
                            try {
                                fieldSet = extensionSchema.getMutableExtensions(t);
                            } catch (Throwable th3) {
                                th = th3;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (obj2 != null) {
                                }
                                throw th;
                            }
                        }
                        FieldSet<ET> fieldSet2 = fieldSet;
                        obj2 = extensionSchema2.parseExtension(reader, findExtensionByNumber, extensionRegistryLite2, fieldSet2, obj2, unknownFieldSchema);
                        fieldSet = fieldSet2;
                    } else {
                        obj = obj2;
                        try {
                            if (unknownFieldSchema.shouldDiscardUnknownFields(reader)) {
                                if (!reader.skipField()) {
                                    obj2 = obj;
                                }
                                obj2 = obj;
                            } else {
                                obj2 = obj == null ? unknownFieldSchema.getBuilderFromMessage(t2) : obj;
                                if (unknownFieldSchema.mergeOneFieldFrom(obj2, reader)) {
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj2 = obj;
                            while (i < this.repeatedFieldOffsetStart) {
                            }
                            if (obj2 != null) {
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* renamed from: com.explorestack.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = decodeVarint32 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (decodeVarint32 < i4) {
            int i5 = decodeVarint32 + 1;
            int i6 = bArr[decodeVarint32];
            if (i6 < 0) {
                i5 = ArrayDecoders.decodeVarint32(i6, bArr, i5, registers);
                i6 = registers.int1;
            }
            int i7 = i5;
            int i8 = i6 >>> 3;
            int i9 = i6 & 7;
            if (i8 == 1) {
                if (i9 == metadata.keyType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i7, i2, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    decodeVarint32 = ArrayDecoders.skipField(i6, bArr, i7, i2, registers);
                }
            } else {
                if (i8 == 2 && i9 == metadata.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i7, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                }
                decodeVarint32 = ArrayDecoders.skipField(i6, bArr, i7, i2, registers);
            }
        }
        if (decodeVarint32 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufList);
        }
        Internal.ProtobufList protobufList2 = protobufList;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufList2, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        decodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufList2, registers);
                    }
                    return i;
                }
                decodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, (List<Integer>) protobufList2, getEnumFieldVerifier(i6), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return decodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufList2, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t, j, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws IOException {
        Object object;
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i4);
                return decodeVarint64;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i4);
                return decodeVarint32;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i4);
                return decodeVarint642;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i13 = registers.int1;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i13)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, decodeVarint322, i13, Internal.UTF_8));
                    decodeVarint322 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return decodeVarint322;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int decodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, i, i2, registers);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, registers.object1);
                } else {
                    unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t, j2, i4);
                return decodeMessageField;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int decodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i4);
                return decodeBytes;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                    unsafe.putObject(t, j, Integer.valueOf(i14));
                    unsafe.putInt(t, j2, i4);
                    return decodeVarint323;
                }
                getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                return decodeVarint323;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i4);
                return decodeVarint324;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i4);
                return decodeVarint643;
            case 68:
                if (i5 == 3) {
                    int decodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return decodeGroupField;
                }
                break;
        }
        return i;
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaFor;
        return schemaFor;
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:98:0x0091. Please report as an issue. */
    int parseProto2Message(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) throws IOException {
        int i4;
        T t2;
        Unsafe unsafe;
        int i5;
        MessageSchema<T> messageSchema;
        int positionForFieldNumber;
        ArrayDecoders.Registers registers2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        T t3;
        int i12;
        int decodeUnknownField;
        byte[] bArr2;
        int i13;
        Unsafe unsafe2;
        int i14;
        int i15;
        int i16;
        int decodeVarint32;
        int i17;
        int i18;
        Unsafe unsafe3;
        int i19;
        byte[] bArr3;
        int i20;
        int i21;
        MessageSchema<T> messageSchema2 = this;
        T t4 = t;
        byte[] bArr4 = bArr;
        int i22 = i2;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe4 = UNSAFE;
        int i23 = -1;
        int i24 = i;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 1048575;
        while (true) {
            if (i24 < i22) {
                int i30 = i24 + 1;
                int i31 = bArr4[i24];
                if (i31 < 0) {
                    i30 = ArrayDecoders.decodeVarint32(i31, bArr4, i30, registers3);
                    i31 = registers3.int1;
                }
                int i32 = i30;
                i28 = i31;
                int i33 = i28 >>> 3;
                int i34 = i28 & 7;
                if (i33 > i25) {
                    positionForFieldNumber = messageSchema2.positionForFieldNumber(i33, i26 / 3);
                } else {
                    positionForFieldNumber = messageSchema2.positionForFieldNumber(i33);
                }
                if (positionForFieldNumber == i23) {
                    registers2 = registers;
                    i6 = i32;
                    unsafe = unsafe4;
                    i7 = i23;
                    i8 = i27;
                    i9 = i28;
                    i10 = i33;
                    i11 = 0;
                    i5 = 1048575;
                    i4 = i3;
                    messageSchema = messageSchema2;
                } else {
                    int i35 = messageSchema2.buffer[positionForFieldNumber + 1];
                    int type = type(i35);
                    long offset = offset(i35);
                    if (type <= 17) {
                        int i36 = messageSchema2.buffer[positionForFieldNumber + 2];
                        int i37 = 1 << (i36 >>> 20);
                        int i38 = i36 & 1048575;
                        i10 = i33;
                        if (i38 != i29) {
                            if (i29 != 1048575) {
                                unsafe4.putInt(t4, i29, i27);
                            }
                            i27 = unsafe4.getInt(t4, i38);
                            i29 = i38;
                        }
                        switch (type) {
                            case 0:
                                Unsafe unsafe5 = unsafe4;
                                i19 = i22;
                                unsafe3 = unsafe5;
                                bArr3 = bArr;
                                i13 = positionForFieldNumber;
                                i14 = i29;
                                i15 = i32;
                                registers2 = registers;
                                if (i34 == 1) {
                                    UnsafeUtil.putDouble(t4, offset, ArrayDecoders.decodeDouble(bArr3, i15));
                                    i24 = i15 + 8;
                                    i27 |= i37;
                                    int i39 = i19;
                                    unsafe4 = unsafe3;
                                    i22 = i39;
                                    i29 = i14;
                                    registers3 = registers2;
                                    i26 = i13;
                                    bArr4 = bArr3;
                                    i25 = i10;
                                    i23 = -1;
                                    break;
                                } else {
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 1:
                                Unsafe unsafe6 = unsafe4;
                                i19 = i22;
                                unsafe3 = unsafe6;
                                bArr3 = bArr;
                                i13 = positionForFieldNumber;
                                i14 = i29;
                                i15 = i32;
                                registers2 = registers;
                                if (i34 == 5) {
                                    UnsafeUtil.putFloat(t4, offset, ArrayDecoders.decodeFloat(bArr3, i15));
                                    i24 = i15 + 4;
                                    i27 |= i37;
                                    int i392 = i19;
                                    unsafe4 = unsafe3;
                                    i22 = i392;
                                    i29 = i14;
                                    registers3 = registers2;
                                    i26 = i13;
                                    bArr4 = bArr3;
                                    i25 = i10;
                                    i23 = -1;
                                    break;
                                } else {
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i15 = i32;
                                registers2 = registers;
                                int i40 = i22;
                                if (i34 == 0) {
                                    int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i15, registers2);
                                    T t5 = t4;
                                    unsafe2.putLong(t5, offset, registers2.long1);
                                    t4 = t5;
                                    i27 |= i37;
                                    unsafe4 = unsafe2;
                                    i22 = i40;
                                    i29 = i14;
                                    i24 = decodeVarint64;
                                    registers3 = registers2;
                                    i26 = i13;
                                    bArr4 = bArr3;
                                    i25 = i10;
                                    i23 = -1;
                                    break;
                                } else {
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i15 = i32;
                                registers2 = registers;
                                i16 = i22;
                                if (i34 == 0) {
                                    decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                    unsafe2.putInt(t4, offset, registers2.int1);
                                    i27 |= i37;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i32;
                                registers2 = registers;
                                if (i34 == 1) {
                                    T t6 = t4;
                                    unsafe2.putLong(t6, offset, ArrayDecoders.decodeFixed64(bArr2, i17));
                                    unsafe2 = unsafe2;
                                    t4 = t6;
                                    decodeVarint32 = i17 + 8;
                                    i27 |= i37;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i32;
                                registers2 = registers;
                                if (i34 == 5) {
                                    unsafe2.putInt(t4, offset, ArrayDecoders.decodeFixed32(bArr2, i17));
                                    decodeVarint32 = i17 + 4;
                                    i27 |= i37;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 7:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i32;
                                registers2 = registers;
                                if (i34 == 0) {
                                    decodeVarint32 = ArrayDecoders.decodeVarint64(bArr2, i17, registers2);
                                    UnsafeUtil.putBoolean(t4, offset, registers2.long1 != 0);
                                    i27 |= i37;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 8:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                i14 = i29;
                                i16 = i22;
                                i17 = i32;
                                registers2 = registers;
                                if (i34 == 2) {
                                    if ((536870912 & i35) == 0) {
                                        decodeVarint32 = ArrayDecoders.decodeString(bArr2, i17, registers2);
                                    } else {
                                        decodeVarint32 = ArrayDecoders.decodeStringRequireUtf8(bArr2, i17, registers2);
                                    }
                                    unsafe2.putObject(t4, offset, registers2.object1);
                                    i27 |= i37;
                                    i29 = i14;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i17;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 9:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i32;
                                if (i34 == 2) {
                                    decodeVarint32 = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i13), bArr2, i18, i16, registers2);
                                    if ((i27 & i37) == 0) {
                                        unsafe2.putObject(t4, offset, registers2.object1);
                                    } else {
                                        unsafe2.putObject(t4, offset, Internal.mergeMessage(unsafe2.getObject(t4, offset), registers2.object1));
                                    }
                                    i27 |= i37;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 10:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i32;
                                if (i34 == 2) {
                                    decodeVarint32 = ArrayDecoders.decodeBytes(bArr2, i18, registers2);
                                    unsafe2.putObject(t4, offset, registers2.object1);
                                    i27 |= i37;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 12:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i32;
                                if (i34 != 0) {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                } else {
                                    decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i18, registers2);
                                    int i41 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i13);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i41)) {
                                        unsafe2.putInt(t4, offset, i41);
                                        i27 |= i37;
                                        i22 = i16;
                                        registers3 = registers2;
                                        i26 = i13;
                                        i25 = i10;
                                        i23 = -1;
                                        unsafe4 = unsafe2;
                                        i24 = decodeVarint32;
                                        bArr4 = bArr2;
                                        break;
                                    } else {
                                        getMutableUnknownFields(t4).storeField(i28, Long.valueOf(i41));
                                        i22 = i16;
                                        registers3 = registers2;
                                        i26 = i13;
                                        i25 = i10;
                                        i23 = -1;
                                        unsafe4 = unsafe2;
                                        i24 = decodeVarint32;
                                        bArr4 = bArr2;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i13 = positionForFieldNumber;
                                unsafe2 = unsafe4;
                                registers2 = registers;
                                i16 = i22;
                                i18 = i32;
                                if (i34 == 0) {
                                    decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i18, registers2);
                                    unsafe2.putInt(t4, offset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i27 |= i37;
                                    i22 = i16;
                                    registers3 = registers2;
                                    i26 = i13;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe2;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 16:
                                i13 = positionForFieldNumber;
                                i18 = i32;
                                if (i34 == 0) {
                                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i18, registers);
                                    T t7 = t4;
                                    Unsafe unsafe7 = unsafe4;
                                    unsafe7.putLong(t7, offset, CodedInputStream.decodeZigZag64(registers.long1));
                                    t4 = t7;
                                    i27 |= i37;
                                    i22 = i2;
                                    i26 = i13;
                                    bArr4 = bArr;
                                    i25 = i10;
                                    i23 = -1;
                                    unsafe4 = unsafe7;
                                    i24 = decodeVarint642;
                                    registers3 = registers;
                                    break;
                                } else {
                                    registers2 = registers;
                                    unsafe2 = unsafe4;
                                    i15 = i18;
                                    i14 = i29;
                                    unsafe3 = unsafe2;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            case 17:
                                if (i34 == 3) {
                                    int i42 = positionForFieldNumber;
                                    decodeVarint32 = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(positionForFieldNumber), bArr, i32, i22, (i10 << 3) | 4, registers);
                                    bArr2 = bArr;
                                    if ((i27 & i37) == 0) {
                                        unsafe4.putObject(t4, offset, registers.object1);
                                    } else {
                                        unsafe4.putObject(t4, offset, Internal.mergeMessage(unsafe4.getObject(t4, offset), registers.object1));
                                    }
                                    i27 |= i37;
                                    i22 = i2;
                                    registers3 = registers;
                                    i26 = i42;
                                    i25 = i10;
                                    i23 = -1;
                                    i24 = decodeVarint32;
                                    bArr4 = bArr2;
                                    break;
                                } else {
                                    i13 = positionForFieldNumber;
                                    registers2 = registers;
                                    unsafe3 = unsafe4;
                                    i14 = i29;
                                    i15 = i32;
                                    i29 = i14;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe3;
                                    i6 = i15;
                                    i8 = i27;
                                    i9 = i28;
                                    i11 = i13;
                                    i5 = 1048575;
                                    i7 = -1;
                                    i4 = i3;
                                    break;
                                }
                            default:
                                unsafe3 = unsafe4;
                                registers2 = registers;
                                i13 = positionForFieldNumber;
                                i14 = i29;
                                i15 = i32;
                                i29 = i14;
                                messageSchema = messageSchema2;
                                unsafe = unsafe3;
                                i6 = i15;
                                i8 = i27;
                                i9 = i28;
                                i11 = i13;
                                i5 = 1048575;
                                i7 = -1;
                                i4 = i3;
                                break;
                        }
                    } else {
                        Unsafe unsafe8 = unsafe4;
                        i10 = i33;
                        int i43 = positionForFieldNumber;
                        if (type != 27) {
                            i20 = i32;
                            if (type <= 49) {
                                i8 = i27;
                                i21 = i29;
                                unsafe = unsafe8;
                                i5 = 1048575;
                                i7 = -1;
                                int parseRepeatedField = messageSchema2.parseRepeatedField(t, bArr, i20, i2, i28, i10, i34, i43, i35, type, offset, registers);
                                i28 = i28;
                                i11 = i43;
                                if (parseRepeatedField != i20) {
                                    messageSchema2 = this;
                                    t4 = t;
                                    bArr4 = bArr;
                                    i22 = i2;
                                    i24 = parseRepeatedField;
                                    i26 = i11;
                                    i29 = i21;
                                    i27 = i8;
                                    unsafe4 = unsafe;
                                    i23 = -1;
                                    i25 = i10;
                                    registers3 = registers;
                                } else {
                                    messageSchema = this;
                                    i4 = i3;
                                    registers2 = registers;
                                    i6 = parseRepeatedField;
                                }
                            } else {
                                i28 = i28;
                                i21 = i29;
                                i8 = i27;
                                i11 = i43;
                                unsafe = unsafe8;
                                i5 = 1048575;
                                i7 = -1;
                                if (type == 50) {
                                    if (i34 == 2) {
                                        int parseMapField = parseMapField(t, bArr, i20, i2, i11, offset, registers);
                                        if (parseMapField != i20) {
                                            messageSchema2 = this;
                                            t4 = t;
                                            bArr4 = bArr;
                                            i22 = i2;
                                            registers3 = registers;
                                            i24 = parseMapField;
                                        } else {
                                            messageSchema = this;
                                            i4 = i3;
                                            registers2 = registers;
                                            i6 = parseMapField;
                                        }
                                    }
                                    messageSchema = this;
                                    i4 = i3;
                                    registers2 = registers;
                                    i6 = i20;
                                } else {
                                    i9 = i28;
                                    int parseOneofField = parseOneofField(t, bArr, i20, i2, i9, i10, i34, i35, type, offset, i11, registers);
                                    messageSchema = this;
                                    registers2 = registers;
                                    if (parseOneofField != i20) {
                                        t4 = t;
                                        bArr4 = bArr;
                                        i22 = i2;
                                        i28 = i9;
                                        i24 = parseOneofField;
                                        messageSchema2 = messageSchema;
                                        registers3 = registers2;
                                    } else {
                                        i4 = i3;
                                        i6 = parseOneofField;
                                        i29 = i21;
                                    }
                                }
                                i26 = i11;
                                i29 = i21;
                                i27 = i8;
                                unsafe4 = unsafe;
                                i23 = i7;
                                i25 = i10;
                            }
                        } else if (i34 == 2) {
                            Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe8.getObject(t4, offset);
                            if (!protobufList.isModifiable()) {
                                int size = protobufList.size();
                                protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe8.putObject(t4, offset, protobufList);
                            }
                            registers3 = registers;
                            int decodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i43), i28, bArr, i32, i2, protobufList, registers3);
                            bArr4 = bArr;
                            i22 = i2;
                            i24 = decodeMessageList;
                            i28 = i28;
                            i26 = i43;
                            unsafe4 = unsafe8;
                            i25 = i10;
                            i23 = -1;
                            t4 = t;
                        } else {
                            i20 = i32;
                            i21 = i29;
                            i8 = i27;
                            i11 = i43;
                            unsafe = unsafe8;
                            i5 = 1048575;
                            i7 = -1;
                            messageSchema = this;
                            i4 = i3;
                            registers2 = registers;
                            i6 = i20;
                        }
                        i9 = i28;
                        i29 = i21;
                    }
                }
                if (i9 != i4 || i4 == 0) {
                    if (messageSchema.hasExtensions && registers2.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                        i12 = i9;
                        decodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i12, bArr, i6, i2, t, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers2);
                        t3 = t;
                        i22 = i2;
                    } else {
                        t3 = t;
                        i12 = i9;
                        decodeUnknownField = ArrayDecoders.decodeUnknownField(i12, bArr, i6, i2, getMutableUnknownFields(t3), registers);
                        i22 = i2;
                    }
                    i24 = decodeUnknownField;
                    bArr4 = bArr;
                    registers3 = registers;
                    i28 = i12;
                    t4 = t3;
                    messageSchema2 = messageSchema;
                    i26 = i11;
                    i27 = i8;
                    unsafe4 = unsafe;
                    i23 = i7;
                    i25 = i10;
                } else {
                    t2 = t;
                    i22 = i2;
                    i24 = i6;
                    i28 = i9;
                    i27 = i8;
                }
            } else {
                i4 = i3;
                t2 = t4;
                unsafe = unsafe4;
                i5 = 1048575;
                messageSchema = messageSchema2;
            }
        }
        if (i29 != i5) {
            unsafe.putInt(t2, i29, i27);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i44 = messageSchema.checkInitializedCount; i44 < messageSchema.repeatedFieldOffsetStart; i44++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i44], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i24 != i22) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i24 > i22 || i28 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i24;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:79:0x0090. Please report as an issue. */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        int positionForFieldNumber;
        T t2;
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int decodeVarint32;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        MessageSchema<T> messageSchema = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i15 = i2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = UNSAFE;
        int i16 = -1;
        int i17 = i;
        int i18 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1048575;
        while (i17 < i15) {
            int i22 = i17 + 1;
            int i23 = bArr2[i17];
            if (i23 < 0) {
                i22 = ArrayDecoders.decodeVarint32(i23, bArr2, i22, registers2);
                i23 = registers2.int1;
            }
            int i24 = i22;
            int i25 = i23 >>> 3;
            int i26 = i23 & 7;
            if (i25 > i18) {
                positionForFieldNumber = messageSchema.positionForFieldNumber(i25, i19 / 3);
            } else {
                positionForFieldNumber = messageSchema.positionForFieldNumber(i25);
            }
            if (positionForFieldNumber == i16) {
                t2 = t3;
                unsafe = unsafe2;
                i3 = i23;
                i4 = i16;
                i5 = i24;
                i6 = i25;
                i7 = 0;
            } else {
                int i27 = messageSchema.buffer[positionForFieldNumber + 1];
                int type = type(i27);
                i3 = i23;
                int i28 = positionForFieldNumber;
                long offset = offset(i27);
                if (type <= 17) {
                    int i29 = messageSchema.buffer[i28 + 2];
                    int i30 = 1 << (i29 >>> 20);
                    int i31 = i29 & 1048575;
                    if (i31 != i21) {
                        if (i21 != 1048575) {
                            unsafe2.putInt(t3, i21, i20);
                            i10 = i31;
                            i9 = 1048575;
                        } else {
                            i9 = 1048575;
                            i10 = i31;
                        }
                        if (i10 != i9) {
                            i20 = unsafe2.getInt(t3, i10);
                        }
                        i21 = i10;
                    }
                    switch (type) {
                        case 0:
                            i8 = i28;
                            if (i26 != 1) {
                                i28 = i8;
                                int i32 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i32;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                UnsafeUtil.putDouble(t3, offset, ArrayDecoders.decodeDouble(bArr2, i24));
                                i17 = i24 + 8;
                                i20 |= i30;
                                i15 = i2;
                                i18 = i25;
                                i19 = i8;
                                i16 = -1;
                                break;
                            }
                        case 1:
                            i8 = i28;
                            if (i26 != 5) {
                                i28 = i8;
                                int i322 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i322;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                UnsafeUtil.putFloat(t3, offset, ArrayDecoders.decodeFloat(bArr2, i24));
                                i17 = i24 + 4;
                                i20 |= i30;
                                i15 = i2;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 2:
                        case 3:
                            i8 = i28;
                            if (i26 != 0) {
                                i28 = i8;
                                int i3222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i3222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i24, registers2);
                                Unsafe unsafe3 = unsafe2;
                                T t4 = t3;
                                unsafe3.putLong(t4, offset, registers2.long1);
                                unsafe2 = unsafe3;
                                t3 = t4;
                                i20 |= i30;
                                i17 = decodeVarint64;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                i15 = i2;
                                break;
                            }
                        case 4:
                        case 11:
                            i8 = i28;
                            if (i26 != 0) {
                                i28 = i8;
                                int i32222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i32222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i24, registers2);
                                unsafe2.putInt(t3, offset, registers2.int1);
                                i20 |= i30;
                                i15 = i2;
                                i17 = decodeVarint32;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 5:
                        case 14:
                            i8 = i28;
                            if (i26 != 1) {
                                i28 = i8;
                                int i322222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i322222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                Unsafe unsafe4 = unsafe2;
                                T t5 = t3;
                                unsafe4.putLong(t5, offset, ArrayDecoders.decodeFixed64(bArr2, i24));
                                unsafe2 = unsafe4;
                                t3 = t5;
                                i17 = i24 + 8;
                                i20 |= i30;
                                i15 = i2;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 6:
                        case 13:
                            i8 = i28;
                            if (i26 != 5) {
                                i28 = i8;
                                int i3222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i3222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                unsafe2.putInt(t3, offset, ArrayDecoders.decodeFixed32(bArr2, i24));
                                i17 = i24 + 4;
                                i20 |= i30;
                                i15 = i2;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 7:
                            i8 = i28;
                            if (i26 != 0) {
                                i28 = i8;
                                int i32222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i32222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr2, i24, registers2);
                                UnsafeUtil.putBoolean(t3, offset, registers2.long1 != 0);
                                i20 |= i30;
                                i17 = decodeVarint642;
                                i15 = i2;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 8:
                            i8 = i28;
                            if (i26 != 2) {
                                i28 = i8;
                                int i322222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i322222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                if ((i27 & 536870912) == 0) {
                                    decodeVarint32 = ArrayDecoders.decodeString(bArr2, i24, registers2);
                                } else {
                                    decodeVarint32 = ArrayDecoders.decodeStringRequireUtf8(bArr2, i24, registers2);
                                }
                                unsafe2.putObject(t3, offset, registers2.object1);
                                i20 |= i30;
                                i15 = i2;
                                i17 = decodeVarint32;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 9:
                            i8 = i28;
                            if (i26 != 2) {
                                i28 = i8;
                                int i3222222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i3222222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                decodeVarint32 = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(i8), bArr2, i24, i15, registers2);
                                Object object = unsafe2.getObject(t3, offset);
                                if (object == null) {
                                    unsafe2.putObject(t3, offset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t3, offset, Internal.mergeMessage(object, registers2.object1));
                                }
                                i20 |= i30;
                                i17 = decodeVarint32;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 10:
                            i8 = i28;
                            if (i26 != 2) {
                                i28 = i8;
                                int i32222222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i32222222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                decodeVarint32 = ArrayDecoders.decodeBytes(bArr2, i24, registers2);
                                unsafe2.putObject(t3, offset, registers2.object1);
                                i20 |= i30;
                                i17 = decodeVarint32;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 12:
                            i8 = i28;
                            if (i26 != 0) {
                                i28 = i8;
                                int i322222222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i322222222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i24, registers2);
                                unsafe2.putInt(t3, offset, registers2.int1);
                                i20 |= i30;
                                i17 = decodeVarint32;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 15:
                            i8 = i28;
                            if (i26 != 0) {
                                i28 = i8;
                                int i3222222222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i3222222222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i24, registers2);
                                unsafe2.putInt(t3, offset, CodedInputStream.decodeZigZag32(registers2.int1));
                                i20 |= i30;
                                i17 = decodeVarint32;
                                i19 = i8;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        case 16:
                            if (i26 != 0) {
                                int i32222222222222 = i28;
                                unsafe = unsafe2;
                                i5 = i24;
                                i7 = i32222222222222;
                                t2 = t3;
                                i6 = i25;
                                i4 = -1;
                                break;
                            } else {
                                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr2, i24, registers2);
                                Unsafe unsafe5 = unsafe2;
                                T t6 = t3;
                                unsafe5.putLong(t6, offset, CodedInputStream.decodeZigZag64(registers2.long1));
                                unsafe2 = unsafe5;
                                t3 = t6;
                                i20 |= i30;
                                i17 = decodeVarint643;
                                i19 = i28;
                                i18 = i25;
                                i16 = -1;
                                break;
                            }
                        default:
                            int i322222222222222 = i28;
                            unsafe = unsafe2;
                            i5 = i24;
                            i7 = i322222222222222;
                            t2 = t3;
                            i6 = i25;
                            i4 = -1;
                            break;
                    }
                } else {
                    if (type != 27) {
                        Unsafe unsafe6 = unsafe2;
                        if (type <= 49) {
                            i12 = i20;
                            unsafe = unsafe6;
                            i4 = -1;
                            i11 = i21;
                            int parseRepeatedField = messageSchema.parseRepeatedField(t, bArr, i24, i2, i3, i25, i26, i28, i27, type, offset, registers);
                            i14 = i25;
                            i7 = i28;
                            if (parseRepeatedField != i24) {
                                messageSchema = this;
                                t3 = t;
                                i15 = i2;
                                registers2 = registers;
                                i17 = parseRepeatedField;
                                i18 = i14;
                                i19 = i7;
                                i21 = i11;
                                i16 = -1;
                                unsafe2 = unsafe;
                                i20 = i12;
                                bArr2 = bArr;
                            } else {
                                t2 = t;
                                i5 = parseRepeatedField;
                                i6 = i14;
                            }
                        } else {
                            i7 = i28;
                            i12 = i20;
                            unsafe = unsafe6;
                            i4 = -1;
                            i13 = i24;
                            i11 = i21;
                            i14 = i25;
                            if (type != 50) {
                                i6 = i14;
                                int parseOneofField = parseOneofField(t, bArr, i13, i2, i3, i6, i26, i27, type, offset, i7, registers);
                                t2 = t;
                                if (parseOneofField != i13) {
                                    messageSchema = this;
                                    registers2 = registers;
                                    i18 = i6;
                                    i17 = parseOneofField;
                                    t3 = t2;
                                    i19 = i7;
                                    i21 = i11;
                                    i16 = -1;
                                    unsafe2 = unsafe;
                                    i20 = i12;
                                    bArr2 = bArr;
                                    i15 = i2;
                                } else {
                                    i5 = parseOneofField;
                                }
                            } else if (i26 == 2) {
                                int parseMapField = parseMapField(t, bArr, i13, i2, i7, offset, registers);
                                if (parseMapField != i13) {
                                    messageSchema = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i15 = i2;
                                    registers2 = registers;
                                    i17 = parseMapField;
                                    i18 = i14;
                                    i19 = i7;
                                    i21 = i11;
                                    i16 = -1;
                                    unsafe2 = unsafe;
                                    i20 = i12;
                                } else {
                                    t2 = t;
                                    i5 = parseMapField;
                                    i6 = i14;
                                }
                            } else {
                                t2 = t;
                                i5 = i13;
                                i6 = i14;
                            }
                        }
                    } else if (i26 == 2) {
                        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t3, offset);
                        if (!protobufList.isModifiable()) {
                            int size = protobufList.size();
                            protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t3, offset, protobufList);
                        }
                        int decodeMessageList = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i28), i3, bArr2, i24, i2, protobufList, registers2);
                        bArr2 = bArr;
                        registers2 = registers;
                        i17 = decodeMessageList;
                        i19 = i28;
                        i18 = i25;
                        unsafe2 = unsafe2;
                        i16 = -1;
                        t3 = t;
                        i15 = i2;
                    } else {
                        unsafe = unsafe2;
                        i11 = i21;
                        i12 = i20;
                        i13 = i24;
                        i14 = i25;
                        i4 = -1;
                        i7 = i28;
                        t2 = t;
                        i5 = i13;
                        i6 = i14;
                    }
                    i21 = i11;
                    i20 = i12;
                }
            }
            int decodeUnknownField = ArrayDecoders.decodeUnknownField(i3, bArr, i5, i2, getMutableUnknownFields(t2), registers);
            bArr2 = bArr;
            registers2 = registers;
            i18 = i6;
            t3 = t2;
            i19 = i7;
            i16 = i4;
            unsafe2 = unsafe;
            i15 = i2;
            i17 = decodeUnknownField;
            messageSchema = this;
        }
        Unsafe unsafe7 = unsafe2;
        int i33 = i15;
        int i34 = i21;
        int i35 = i20;
        T t7 = t3;
        if (i34 != 1048575) {
            unsafe7.putInt(t7, i34, i35);
        }
        if (i17 == i33) {
            return i17;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.explorestack.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    @Override // com.explorestack.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i2 >= i) {
                break;
            }
            long offset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, offset);
            if (object != null) {
                UnsafeUtil.putObject(t, offset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    @Override // com.explorestack.protobuf.Schema
    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.checkInitializedCount) {
            int i6 = this.intArray[i4];
            int numberAt = numberAt(i6);
            int typeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i5 = UNSAFE.getInt(t, i8);
                }
                i2 = i5;
                i = i8;
            } else {
                i = i3;
                i2 = i5;
            }
            T t2 = t;
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t2, i6, i, i2, i9)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type == 9 || type == 17) {
                if (isFieldPresent(t2, i6, i, i2, i9) && !isInitialized(t2, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t2, numberAt, i6) && !isInitialized(t2, typeAndOffsetAt, getMessageFieldSchema(i6))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t2, typeAndOffsetAt, i6)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t2, typeAndOffsetAt, i6)) {
                    return false;
                }
            }
            i4++;
            t = t2;
            i3 = i;
            i5 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.explorestack.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? r5 = 0;
        for (Object obj : forMapData.values()) {
            r5 = r5;
            if (r5 == 0) {
                r5 = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!r5.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(t, i);
        }
        return (i3 & i4) != 0;
    }

    private boolean isFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(t, j) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return UnsafeUtil.getDouble(t, offset) != 0.0d;
            case 1:
                return UnsafeUtil.getFloat(t, offset) != 0.0f;
            case 2:
                return UnsafeUtil.getLong(t, offset) != 0;
            case 3:
                return UnsafeUtil.getLong(t, offset) != 0;
            case 4:
                return UnsafeUtil.getInt(t, offset) != 0;
            case 5:
                return UnsafeUtil.getLong(t, offset) != 0;
            case 6:
                return UnsafeUtil.getInt(t, offset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t, offset);
            case 8:
                Object object = UnsafeUtil.getObject(t, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t, offset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, offset));
            case 11:
                return UnsafeUtil.getInt(t, offset) != 0;
            case 12:
                return UnsafeUtil.getInt(t, offset) != 0;
            case 13:
                return UnsafeUtil.getInt(t, offset) != 0;
            case 14:
                return UnsafeUtil.getLong(t, offset) != 0;
            case 15:
                return UnsafeUtil.getInt(t, offset) != 0;
            case 16:
                return UnsafeUtil.getLong(t, offset) != 0;
            case 17:
                return UnsafeUtil.getObject(t, offset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setFieldPresent(T t, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t, j, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t, j));
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, presenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int numberAt = numberAt(i4);
            if (i == numberAt) {
                return i4;
            }
            if (i < numberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
