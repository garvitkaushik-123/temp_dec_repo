package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Loading", "LoadSuccess", "LoadFailure", "Showing", "Destroyed", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdState[] $VALUES;
    public static final AdState None = new AdState("None", 0);
    public static final AdState Loading = new AdState("Loading", 1);
    public static final AdState LoadSuccess = new AdState("LoadSuccess", 2);
    public static final AdState LoadFailure = new AdState("LoadFailure", 3);
    public static final AdState Showing = new AdState("Showing", 4);
    public static final AdState Destroyed = new AdState("Destroyed", 5);

    private static final /* synthetic */ AdState[] $values() {
        return new AdState[]{None, Loading, LoadSuccess, LoadFailure, Showing, Destroyed};
    }

    public static EnumEntries<AdState> getEntries() {
        return $ENTRIES;
    }

    private AdState(String str, int i) {
    }

    static {
        AdState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AdState valueOf(String str) {
        return (AdState) Enum.valueOf(AdState.class, str);
    }

    public static AdState[] values() {
        return (AdState[]) $VALUES.clone();
    }
}
