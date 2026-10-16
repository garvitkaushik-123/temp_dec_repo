package io.adn.sdk.internal.ui.common.design.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SlideDirection.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/ui/common/design/compose/SlideDirection;", "", "<init>", "(Ljava/lang/String;I)V", "LeftToRight", "RightToLeft", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SlideDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SlideDirection[] $VALUES;
    public static final SlideDirection LeftToRight = new SlideDirection("LeftToRight", 0);
    public static final SlideDirection RightToLeft = new SlideDirection("RightToLeft", 1);

    private static final /* synthetic */ SlideDirection[] $values() {
        return new SlideDirection[]{LeftToRight, RightToLeft};
    }

    public static EnumEntries<SlideDirection> getEntries() {
        return $ENTRIES;
    }

    static {
        SlideDirection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SlideDirection(String str, int i) {
    }

    public static SlideDirection valueOf(String str) {
        return (SlideDirection) Enum.valueOf(SlideDirection.class, str);
    }

    public static SlideDirection[] values() {
        return (SlideDirection[]) $VALUES.clone();
    }
}
