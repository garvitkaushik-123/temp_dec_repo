package io.adn.sdk.publisher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdnMediationType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/publisher/AdnMediationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MAX_ADS", "IRONSOURCE", "NONE", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnMediationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdnMediationType[] $VALUES;
    private final String value;
    public static final AdnMediationType MAX_ADS = new AdnMediationType("MAX_ADS", 0, "maxads");
    public static final AdnMediationType IRONSOURCE = new AdnMediationType("IRONSOURCE", 1, "ironsource");
    public static final AdnMediationType NONE = new AdnMediationType("NONE", 2, "none");

    private static final /* synthetic */ AdnMediationType[] $values() {
        return new AdnMediationType[]{MAX_ADS, IRONSOURCE, NONE};
    }

    public static EnumEntries<AdnMediationType> getEntries() {
        return $ENTRIES;
    }

    private AdnMediationType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AdnMediationType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AdnMediationType valueOf(String str) {
        return (AdnMediationType) Enum.valueOf(AdnMediationType.class, str);
    }

    public static AdnMediationType[] values() {
        return (AdnMediationType[]) $VALUES.clone();
    }
}
