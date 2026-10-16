package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Gpp.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SpGppOptionBinary;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "YES", "NO", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpGppOptionBinary {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpGppOptionBinary[] $VALUES;
    private final String type;
    public static final SpGppOptionBinary YES = new SpGppOptionBinary("YES", 0, "yes");
    public static final SpGppOptionBinary NO = new SpGppOptionBinary("NO", 1, "no");

    private static final /* synthetic */ SpGppOptionBinary[] $values() {
        return new SpGppOptionBinary[]{YES, NO};
    }

    public static EnumEntries<SpGppOptionBinary> getEntries() {
        return $ENTRIES;
    }

    public static SpGppOptionBinary valueOf(String str) {
        return (SpGppOptionBinary) Enum.valueOf(SpGppOptionBinary.class, str);
    }

    public static SpGppOptionBinary[] values() {
        return (SpGppOptionBinary[]) $VALUES.clone();
    }

    private SpGppOptionBinary(String str, int i, String str2) {
        this.type = str2;
    }

    public final String getType() {
        return this.type;
    }

    static {
        SpGppOptionBinary[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
