package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ActionType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "REJECT_ALL", "SHOW_OPTIONS", "ACCEPT_ALL", "MSG_CANCEL", "GET_MSG_ERROR", "GET_MSG_NOT_CALLED", "UNKNOWN", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeMessageActionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NativeMessageActionType[] $VALUES;
    private final int code;
    public static final NativeMessageActionType REJECT_ALL = new NativeMessageActionType("REJECT_ALL", 0, 13);
    public static final NativeMessageActionType SHOW_OPTIONS = new NativeMessageActionType("SHOW_OPTIONS", 1, 12);
    public static final NativeMessageActionType ACCEPT_ALL = new NativeMessageActionType("ACCEPT_ALL", 2, 11);
    public static final NativeMessageActionType MSG_CANCEL = new NativeMessageActionType("MSG_CANCEL", 3, 15);
    public static final NativeMessageActionType GET_MSG_ERROR = new NativeMessageActionType("GET_MSG_ERROR", 4, -2);
    public static final NativeMessageActionType GET_MSG_NOT_CALLED = new NativeMessageActionType("GET_MSG_NOT_CALLED", 5, -3);
    public static final NativeMessageActionType UNKNOWN = new NativeMessageActionType("UNKNOWN", 6, -1);

    private static final /* synthetic */ NativeMessageActionType[] $values() {
        return new NativeMessageActionType[]{REJECT_ALL, SHOW_OPTIONS, ACCEPT_ALL, MSG_CANCEL, GET_MSG_ERROR, GET_MSG_NOT_CALLED, UNKNOWN};
    }

    public static EnumEntries<NativeMessageActionType> getEntries() {
        return $ENTRIES;
    }

    public static NativeMessageActionType valueOf(String str) {
        return (NativeMessageActionType) Enum.valueOf(NativeMessageActionType.class, str);
    }

    public static NativeMessageActionType[] values() {
        return (NativeMessageActionType[]) $VALUES.clone();
    }

    private NativeMessageActionType(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        NativeMessageActionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
