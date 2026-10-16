package io.adn.sdk.internal.thirdparty.omsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: QuartileEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/model/QuartileEvent;", "", "<init>", "(Ljava/lang/String;I)V", "START", "FIRST_QUARTILE", "MIDPOINT", "THIRD_QUARTILE", "COMPLETE", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class QuartileEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QuartileEvent[] $VALUES;
    public static final QuartileEvent START = new QuartileEvent("START", 0);
    public static final QuartileEvent FIRST_QUARTILE = new QuartileEvent("FIRST_QUARTILE", 1);
    public static final QuartileEvent MIDPOINT = new QuartileEvent("MIDPOINT", 2);
    public static final QuartileEvent THIRD_QUARTILE = new QuartileEvent("THIRD_QUARTILE", 3);
    public static final QuartileEvent COMPLETE = new QuartileEvent("COMPLETE", 4);

    private static final /* synthetic */ QuartileEvent[] $values() {
        return new QuartileEvent[]{START, FIRST_QUARTILE, MIDPOINT, THIRD_QUARTILE, COMPLETE};
    }

    public static EnumEntries<QuartileEvent> getEntries() {
        return $ENTRIES;
    }

    private QuartileEvent(String str, int i) {
    }

    static {
        QuartileEvent[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static QuartileEvent valueOf(String str) {
        return (QuartileEvent) Enum.valueOf(QuartileEvent.class, str);
    }

    public static QuartileEvent[] values() {
        return (QuartileEvent[]) $VALUES.clone();
    }
}
