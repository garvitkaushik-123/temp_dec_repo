package io.adn.sdk.internal.domain.model.ui;

import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LayoutPosition.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "", "<init>", "(Ljava/lang/String;I)V", AndroidBridgeConstants.BANNER_POSITION_TOPLEFT, AndroidBridgeConstants.BANNER_POSITION_TOPRIGHT, AndroidBridgeConstants.BANNER_POSITION_BOTTOMLEFT, AndroidBridgeConstants.BANNER_POSITION_BOTTOMRIGHT, "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LayoutPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutPosition[] $VALUES;
    public static final LayoutPosition TopLeft = new LayoutPosition(AndroidBridgeConstants.BANNER_POSITION_TOPLEFT, 0);
    public static final LayoutPosition TopRight = new LayoutPosition(AndroidBridgeConstants.BANNER_POSITION_TOPRIGHT, 1);
    public static final LayoutPosition BottomLeft = new LayoutPosition(AndroidBridgeConstants.BANNER_POSITION_BOTTOMLEFT, 2);
    public static final LayoutPosition BottomRight = new LayoutPosition(AndroidBridgeConstants.BANNER_POSITION_BOTTOMRIGHT, 3);

    private static final /* synthetic */ LayoutPosition[] $values() {
        return new LayoutPosition[]{TopLeft, TopRight, BottomLeft, BottomRight};
    }

    public static EnumEntries<LayoutPosition> getEntries() {
        return $ENTRIES;
    }

    private LayoutPosition(String str, int i) {
    }

    static {
        LayoutPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static LayoutPosition valueOf(String str) {
        return (LayoutPosition) Enum.valueOf(LayoutPosition.class, str);
    }

    public static LayoutPosition[] values() {
        return (LayoutPosition[]) $VALUES.clone();
    }
}
