package io.adn.sdk.internal.ui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ViewVisibilityTracker.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/ui/utils/TrackerState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Active", "Destroyed", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class TrackerState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TrackerState[] $VALUES;
    public static final TrackerState None = new TrackerState("None", 0);
    public static final TrackerState Active = new TrackerState("Active", 1);
    public static final TrackerState Destroyed = new TrackerState("Destroyed", 2);

    private static final /* synthetic */ TrackerState[] $values() {
        return new TrackerState[]{None, Active, Destroyed};
    }

    public static EnumEntries<TrackerState> getEntries() {
        return $ENTRIES;
    }

    static {
        TrackerState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private TrackerState(String str, int i) {
    }

    public static TrackerState valueOf(String str) {
        return (TrackerState) Enum.valueOf(TrackerState.class, str);
    }

    public static TrackerState[] values() {
        return (TrackerState[]) $VALUES.clone();
    }
}
