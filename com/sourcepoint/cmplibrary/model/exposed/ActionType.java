package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ActionType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SHOW_OPTIONS", "REJECT_ALL", "ACCEPT_ALL", "MSG_CANCEL", "CUSTOM", "SAVE_AND_EXIT", "PM_DISMISS", "GET_MSG_ERROR", "GET_MSG_NOT_CALLED", "UNKNOWN", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActionType[] $VALUES;
    private final int code;
    public static final ActionType SHOW_OPTIONS = new ActionType("SHOW_OPTIONS", 0, 12);
    public static final ActionType REJECT_ALL = new ActionType("REJECT_ALL", 1, 13);
    public static final ActionType ACCEPT_ALL = new ActionType("ACCEPT_ALL", 2, 11);
    public static final ActionType MSG_CANCEL = new ActionType("MSG_CANCEL", 3, 15);
    public static final ActionType CUSTOM = new ActionType("CUSTOM", 4, 9);
    public static final ActionType SAVE_AND_EXIT = new ActionType("SAVE_AND_EXIT", 5, 1);
    public static final ActionType PM_DISMISS = new ActionType("PM_DISMISS", 6, 2);
    public static final ActionType GET_MSG_ERROR = new ActionType("GET_MSG_ERROR", 7, -2);
    public static final ActionType GET_MSG_NOT_CALLED = new ActionType("GET_MSG_NOT_CALLED", 8, -3);
    public static final ActionType UNKNOWN = new ActionType("UNKNOWN", 9, -1);

    private static final /* synthetic */ ActionType[] $values() {
        return new ActionType[]{SHOW_OPTIONS, REJECT_ALL, ACCEPT_ALL, MSG_CANCEL, CUSTOM, SAVE_AND_EXIT, PM_DISMISS, GET_MSG_ERROR, GET_MSG_NOT_CALLED, UNKNOWN};
    }

    public static EnumEntries<ActionType> getEntries() {
        return $ENTRIES;
    }

    public static ActionType valueOf(String str) {
        return (ActionType) Enum.valueOf(ActionType.class, str);
    }

    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }

    private ActionType(String str, int i, int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        ActionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
