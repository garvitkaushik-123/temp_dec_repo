package io.adn.sdk.publisher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdnInitializationStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/publisher/AdnInitializationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_INITIALIZED", "INITIALIZING", "INITIALIZED_SUCCESS", "INITIALIZED_FAILURE", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnInitializationStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdnInitializationStatus[] $VALUES;
    public static final AdnInitializationStatus NOT_INITIALIZED = new AdnInitializationStatus("NOT_INITIALIZED", 0);
    public static final AdnInitializationStatus INITIALIZING = new AdnInitializationStatus("INITIALIZING", 1);
    public static final AdnInitializationStatus INITIALIZED_SUCCESS = new AdnInitializationStatus("INITIALIZED_SUCCESS", 2);
    public static final AdnInitializationStatus INITIALIZED_FAILURE = new AdnInitializationStatus("INITIALIZED_FAILURE", 3);

    private static final /* synthetic */ AdnInitializationStatus[] $values() {
        return new AdnInitializationStatus[]{NOT_INITIALIZED, INITIALIZING, INITIALIZED_SUCCESS, INITIALIZED_FAILURE};
    }

    public static EnumEntries<AdnInitializationStatus> getEntries() {
        return $ENTRIES;
    }

    private AdnInitializationStatus(String str, int i) {
    }

    static {
        AdnInitializationStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AdnInitializationStatus valueOf(String str) {
        return (AdnInitializationStatus) Enum.valueOf(AdnInitializationStatus.class, str);
    }

    public static AdnInitializationStatus[] values() {
        return (AdnInitializationStatus[]) $VALUES.clone();
    }
}
