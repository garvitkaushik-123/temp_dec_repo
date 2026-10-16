package io.adn.sdk.internal.domain.model.config;

import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SdkParameterKey.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/model/config/SdkParameterKey;", "", C3040d4.h.W, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "DIAGNOSTIC_SAMPLING_PERCENTAGE", "ENABLE_SELF_ATTRIBUTION_TRACKING", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SdkParameterKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SdkParameterKey[] $VALUES;
    public static final SdkParameterKey DIAGNOSTIC_SAMPLING_PERCENTAGE = new SdkParameterKey("DIAGNOSTIC_SAMPLING_PERCENTAGE", 0, "diagnostic_sampling_percentage");
    public static final SdkParameterKey ENABLE_SELF_ATTRIBUTION_TRACKING = new SdkParameterKey("ENABLE_SELF_ATTRIBUTION_TRACKING", 1, "enable_self_attribution_tracking");
    private final String key;

    private static final /* synthetic */ SdkParameterKey[] $values() {
        return new SdkParameterKey[]{DIAGNOSTIC_SAMPLING_PERCENTAGE, ENABLE_SELF_ATTRIBUTION_TRACKING};
    }

    public static EnumEntries<SdkParameterKey> getEntries() {
        return $ENTRIES;
    }

    private SdkParameterKey(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        SdkParameterKey[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.key;
    }

    public static SdkParameterKey valueOf(String str) {
        return (SdkParameterKey) Enum.valueOf(SdkParameterKey.class, str);
    }

    public static SdkParameterKey[] values() {
        return (SdkParameterKey[]) $VALUES.clone();
    }
}
