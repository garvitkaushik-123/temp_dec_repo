package io.adn.sdk.internal.data.repository;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceMetricsRepositoryImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/data/repository/ThermalState;", "", "value", "", "description", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDescription", "()Ljava/lang/String;", "NONE", "LOWEST", "NORMAL", "HIGH", "HIGHEST", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class ThermalState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ThermalState[] $VALUES;
    private final String description;
    private final int value;
    public static final ThermalState NONE = new ThermalState("NONE", 0, 0, "Unknown thermal state");
    public static final ThermalState LOWEST = new ThermalState("LOWEST", 1, 1, "Lowest thermal state");
    public static final ThermalState NORMAL = new ThermalState("NORMAL", 2, 2, "Normal thermal state");
    public static final ThermalState HIGH = new ThermalState("HIGH", 3, 3, "High thermal state");
    public static final ThermalState HIGHEST = new ThermalState("HIGHEST", 4, 4, "Highest thermal state");

    private static final /* synthetic */ ThermalState[] $values() {
        return new ThermalState[]{NONE, LOWEST, NORMAL, HIGH, HIGHEST};
    }

    public static EnumEntries<ThermalState> getEntries() {
        return $ENTRIES;
    }

    private ThermalState(String str, int i, int i2, String str2) {
        this.value = i2;
        this.description = str2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        ThermalState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ThermalState valueOf(String str) {
        return (ThermalState) Enum.valueOf(ThermalState.class, str);
    }

    public static ThermalState[] values() {
        return (ThermalState[]) $VALUES.clone();
    }
}
