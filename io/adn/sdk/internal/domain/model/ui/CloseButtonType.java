package io.adn.sdk.internal.domain.model.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CloseButtonType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "ProgressbarWithClose", "CountdownWithClose", "SimpleCross", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CloseButtonType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CloseButtonType[] $VALUES;
    public static final CloseButtonType ProgressbarWithClose = new CloseButtonType("ProgressbarWithClose", 0);
    public static final CloseButtonType CountdownWithClose = new CloseButtonType("CountdownWithClose", 1);
    public static final CloseButtonType SimpleCross = new CloseButtonType("SimpleCross", 2);

    private static final /* synthetic */ CloseButtonType[] $values() {
        return new CloseButtonType[]{ProgressbarWithClose, CountdownWithClose, SimpleCross};
    }

    public static EnumEntries<CloseButtonType> getEntries() {
        return $ENTRIES;
    }

    private CloseButtonType(String str, int i) {
    }

    static {
        CloseButtonType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CloseButtonType valueOf(String str) {
        return (CloseButtonType) Enum.valueOf(CloseButtonType.class, str);
    }

    public static CloseButtonType[] values() {
        return (CloseButtonType[]) $VALUES.clone();
    }
}
