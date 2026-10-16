package io.adn.sdk.internal.ui.common.mraid;

import androidx.webkit.Profile;
import io.bidmachine.rendering.model.EventTaskParams;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MraidViewState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidViewState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Loading", Profile.DEFAULT_PROFILE_NAME, "Resized", "Expanded", "Hidden", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidViewState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MraidViewState[] $VALUES;
    private final String value;
    public static final MraidViewState Loading = new MraidViewState("Loading", 0, "loading");
    public static final MraidViewState Default = new MraidViewState(Profile.DEFAULT_PROFILE_NAME, 1, EventTaskParams.STATE_GROUP_DEFAULT);
    public static final MraidViewState Resized = new MraidViewState("Resized", 2, "resized");
    public static final MraidViewState Expanded = new MraidViewState("Expanded", 3, "expanded");
    public static final MraidViewState Hidden = new MraidViewState("Hidden", 4, "hidden");

    private static final /* synthetic */ MraidViewState[] $values() {
        return new MraidViewState[]{Loading, Default, Resized, Expanded, Hidden};
    }

    public static EnumEntries<MraidViewState> getEntries() {
        return $ENTRIES;
    }

    private MraidViewState(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        MraidViewState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static MraidViewState valueOf(String str) {
        return (MraidViewState) Enum.valueOf(MraidViewState.class, str);
    }

    public static MraidViewState[] values() {
        return (MraidViewState[]) $VALUES.clone();
    }
}
