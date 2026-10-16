package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "", "(Ljava/lang/String;I)V", "rejectedAll", "rejectedSome", "rejectedNone", "consentedAll", "linkedNoAction", "unknown", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CcpaStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CcpaStatus[] $VALUES;
    public static final CcpaStatus rejectedAll = new CcpaStatus("rejectedAll", 0);
    public static final CcpaStatus rejectedSome = new CcpaStatus("rejectedSome", 1);
    public static final CcpaStatus rejectedNone = new CcpaStatus("rejectedNone", 2);
    public static final CcpaStatus consentedAll = new CcpaStatus("consentedAll", 3);
    public static final CcpaStatus linkedNoAction = new CcpaStatus("linkedNoAction", 4);
    public static final CcpaStatus unknown = new CcpaStatus("unknown", 5);

    private static final /* synthetic */ CcpaStatus[] $values() {
        return new CcpaStatus[]{rejectedAll, rejectedSome, rejectedNone, consentedAll, linkedNoAction, unknown};
    }

    public static EnumEntries<CcpaStatus> getEntries() {
        return $ENTRIES;
    }

    public static CcpaStatus valueOf(String str) {
        return (CcpaStatus) Enum.valueOf(CcpaStatus.class, str);
    }

    public static CcpaStatus[] values() {
        return (CcpaStatus[]) $VALUES.clone();
    }

    private CcpaStatus(String str, int i) {
    }

    static {
        CcpaStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
