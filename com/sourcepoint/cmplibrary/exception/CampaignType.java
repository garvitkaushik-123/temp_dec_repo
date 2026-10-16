package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ErrorMessageManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "", "(Ljava/lang/String;I)V", "GDPR", "CCPA", "USNAT", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CampaignType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CampaignType[] $VALUES;
    public static final CampaignType GDPR = new CampaignType("GDPR", 0);
    public static final CampaignType CCPA = new CampaignType("CCPA", 1);
    public static final CampaignType USNAT = new CampaignType("USNAT", 2);

    private static final /* synthetic */ CampaignType[] $values() {
        return new CampaignType[]{GDPR, CCPA, USNAT};
    }

    public static EnumEntries<CampaignType> getEntries() {
        return $ENTRIES;
    }

    public static CampaignType valueOf(String str) {
        return (CampaignType) Enum.valueOf(CampaignType.class, str);
    }

    public static CampaignType[] values() {
        return (CampaignType[]) $VALUES.clone();
    }

    private CampaignType(String str, int i) {
    }

    static {
        CampaignType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
