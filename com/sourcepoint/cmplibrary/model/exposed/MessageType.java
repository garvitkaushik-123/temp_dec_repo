package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SpConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "", "(Ljava/lang/String;I)V", "MOBILE", "OTT", "LEGACY_OTT", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MessageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageType[] $VALUES;
    public static final MessageType MOBILE = new MessageType("MOBILE", 0);
    public static final MessageType OTT = new MessageType("OTT", 1);
    public static final MessageType LEGACY_OTT = new MessageType("LEGACY_OTT", 2);

    private static final /* synthetic */ MessageType[] $values() {
        return new MessageType[]{MOBILE, OTT, LEGACY_OTT};
    }

    public static EnumEntries<MessageType> getEntries() {
        return $ENTRIES;
    }

    public static MessageType valueOf(String str) {
        return (MessageType) Enum.valueOf(MessageType.class, str);
    }

    public static MessageType[] values() {
        return (MessageType[]) $VALUES.clone();
    }

    private MessageType(String str, int i) {
    }

    static {
        MessageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
