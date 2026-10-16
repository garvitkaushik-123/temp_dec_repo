package io.adn.sdk.publisher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdnAdRequest.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/publisher/AdnLoadTimeout;", "", "durationMs", "", "<init>", "(Ljava/lang/String;IJ)V", "getDurationMs", "()J", "MEDIATION", "DEFAULT", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnLoadTimeout {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdnLoadTimeout[] $VALUES;
    private final long durationMs;
    public static final AdnLoadTimeout MEDIATION = new AdnLoadTimeout("MEDIATION", 0, 29000);
    public static final AdnLoadTimeout DEFAULT = new AdnLoadTimeout("DEFAULT", 1, 60000);

    private static final /* synthetic */ AdnLoadTimeout[] $values() {
        return new AdnLoadTimeout[]{MEDIATION, DEFAULT};
    }

    public static EnumEntries<AdnLoadTimeout> getEntries() {
        return $ENTRIES;
    }

    private AdnLoadTimeout(String str, int i, long j) {
        this.durationMs = j;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    static {
        AdnLoadTimeout[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AdnLoadTimeout valueOf(String str) {
        return (AdnLoadTimeout) Enum.valueOf(AdnLoadTimeout.class, str);
    }

    public static AdnLoadTimeout[] values() {
        return (AdnLoadTimeout[]) $VALUES.clone();
    }
}
