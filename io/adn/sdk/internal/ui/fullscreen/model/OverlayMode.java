package io.adn.sdk.internal.ui.fullscreen.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FullscreenAdUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/OverlayMode;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Transparent", "Blurred", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OverlayMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OverlayMode[] $VALUES;
    public static final OverlayMode None = new OverlayMode("None", 0);
    public static final OverlayMode Transparent = new OverlayMode("Transparent", 1);
    public static final OverlayMode Blurred = new OverlayMode("Blurred", 2);

    private static final /* synthetic */ OverlayMode[] $values() {
        return new OverlayMode[]{None, Transparent, Blurred};
    }

    public static EnumEntries<OverlayMode> getEntries() {
        return $ENTRIES;
    }

    static {
        OverlayMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private OverlayMode(String str, int i) {
    }

    public static OverlayMode valueOf(String str) {
        return (OverlayMode) Enum.valueOf(OverlayMode.class, str);
    }

    public static OverlayMode[] values() {
        return (OverlayMode[]) $VALUES.clone();
    }
}
