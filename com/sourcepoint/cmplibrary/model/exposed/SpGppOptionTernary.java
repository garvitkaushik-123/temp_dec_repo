package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Gpp.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionTernary;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "YES", "NO", "NOT_APPLICABLE", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpGppOptionTernary {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpGppOptionTernary[] $VALUES;
    private final String type;
    public static final SpGppOptionTernary YES = new SpGppOptionTernary("YES", 0, "yes");
    public static final SpGppOptionTernary NO = new SpGppOptionTernary("NO", 1, "no");
    public static final SpGppOptionTernary NOT_APPLICABLE = new SpGppOptionTernary("NOT_APPLICABLE", 2, "na");

    private static final /* synthetic */ SpGppOptionTernary[] $values() {
        return new SpGppOptionTernary[]{YES, NO, NOT_APPLICABLE};
    }

    public static EnumEntries<SpGppOptionTernary> getEntries() {
        return $ENTRIES;
    }

    public static SpGppOptionTernary valueOf(String str) {
        return (SpGppOptionTernary) Enum.valueOf(SpGppOptionTernary.class, str);
    }

    public static SpGppOptionTernary[] values() {
        return (SpGppOptionTernary[]) $VALUES.clone();
    }

    private SpGppOptionTernary(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        SpGppOptionTernary[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
