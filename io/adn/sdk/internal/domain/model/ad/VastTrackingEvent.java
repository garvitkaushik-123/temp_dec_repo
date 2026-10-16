package io.adn.sdk.internal.domain.model.ad;

import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VastTracking.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastTrackingEvent;", "", "<init>", "(Ljava/lang/String;I)V", "CreativeView", "Start", "FirstQuartile", "Midpoint", "ThirdQuartile", "Complete", VastTagName.MUTE, "UnMute", "Pause", "Rewind", "Resume", "CloseLinear", "Skip", VastTagName.PROGRESS, "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastTrackingEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VastTrackingEvent[] $VALUES;
    public static final VastTrackingEvent CreativeView = new VastTrackingEvent("CreativeView", 0);
    public static final VastTrackingEvent Start = new VastTrackingEvent("Start", 1);
    public static final VastTrackingEvent FirstQuartile = new VastTrackingEvent("FirstQuartile", 2);
    public static final VastTrackingEvent Midpoint = new VastTrackingEvent("Midpoint", 3);
    public static final VastTrackingEvent ThirdQuartile = new VastTrackingEvent("ThirdQuartile", 4);
    public static final VastTrackingEvent Complete = new VastTrackingEvent("Complete", 5);
    public static final VastTrackingEvent Mute = new VastTrackingEvent(VastTagName.MUTE, 6);
    public static final VastTrackingEvent UnMute = new VastTrackingEvent("UnMute", 7);
    public static final VastTrackingEvent Pause = new VastTrackingEvent("Pause", 8);
    public static final VastTrackingEvent Rewind = new VastTrackingEvent("Rewind", 9);
    public static final VastTrackingEvent Resume = new VastTrackingEvent("Resume", 10);
    public static final VastTrackingEvent CloseLinear = new VastTrackingEvent("CloseLinear", 11);
    public static final VastTrackingEvent Skip = new VastTrackingEvent("Skip", 12);
    public static final VastTrackingEvent Progress = new VastTrackingEvent(VastTagName.PROGRESS, 13);

    private static final /* synthetic */ VastTrackingEvent[] $values() {
        return new VastTrackingEvent[]{CreativeView, Start, FirstQuartile, Midpoint, ThirdQuartile, Complete, Mute, UnMute, Pause, Rewind, Resume, CloseLinear, Skip, Progress};
    }

    public static EnumEntries<VastTrackingEvent> getEntries() {
        return $ENTRIES;
    }

    private VastTrackingEvent(String str, int i) {
    }

    static {
        VastTrackingEvent[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VastTrackingEvent valueOf(String str) {
        return (VastTrackingEvent) Enum.valueOf(VastTrackingEvent.class, str);
    }

    public static VastTrackingEvent[] values() {
        return (VastTrackingEvent[]) $VALUES.clone();
    }
}
