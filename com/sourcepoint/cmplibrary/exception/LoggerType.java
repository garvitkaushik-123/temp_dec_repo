package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LoggerUtil.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/LoggerType;", "", "t", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getT", "()Ljava/lang/String;", "JSON_TYPE", "URL_TYPE", "ERROR_TYPE", "C_TYPE", "NL", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoggerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoggerType[] $VALUES;
    public static final LoggerType NL;
    private final String t;
    public static final LoggerType JSON_TYPE = new LoggerType("JSON_TYPE", 0, "*JSON*");
    public static final LoggerType URL_TYPE = new LoggerType("URL_TYPE", 1, "*URL*");
    public static final LoggerType ERROR_TYPE = new LoggerType("ERROR_TYPE", 2, "*ERROR*");
    public static final LoggerType C_TYPE = new LoggerType("C_TYPE", 3, "*COMPUTATION*");

    private static final /* synthetic */ LoggerType[] $values() {
        return new LoggerType[]{JSON_TYPE, URL_TYPE, ERROR_TYPE, C_TYPE, NL};
    }

    public static EnumEntries<LoggerType> getEntries() {
        return $ENTRIES;
    }

    public static LoggerType valueOf(String str) {
        return (LoggerType) Enum.valueOf(LoggerType.class, str);
    }

    public static LoggerType[] values() {
        return (LoggerType[]) $VALUES.clone();
    }

    private LoggerType(String str, int i, String str2) {
        this.t = str2;
    }

    public final String getT() {
        return this.t;
    }

    static {
        String property = System.getProperty("line.separator");
        NL = new LoggerType("NL", 4, property == null ? "\\n" : property);
        LoggerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
