package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/DisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "Overlay", "Push", "BlurOverlay", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DisplayMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayMode[] $VALUES;
    public static final DisplayMode Overlay = new DisplayMode("Overlay", 0);
    public static final DisplayMode Push = new DisplayMode("Push", 1);
    public static final DisplayMode BlurOverlay = new DisplayMode("BlurOverlay", 2);

    private static final /* synthetic */ DisplayMode[] $values() {
        return new DisplayMode[]{Overlay, Push, BlurOverlay};
    }

    public static EnumEntries<DisplayMode> getEntries() {
        return $ENTRIES;
    }

    private DisplayMode(String str, int i) {
    }

    static {
        DisplayMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DisplayMode valueOf(String str) {
        return (DisplayMode) Enum.valueOf(DisplayMode.class, str);
    }

    public static DisplayMode[] values() {
        return (DisplayMode[]) $VALUES.clone();
    }
}
