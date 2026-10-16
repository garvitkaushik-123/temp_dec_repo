package io.adn.sdk.internal.data.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AudioService.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/data/service/AudioUpdate;", "", "<init>", "(Ljava/lang/String;I)V", "SilentModeOn", "SilentModeOff", "VolumeUp", "VolumeMute", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AudioUpdate {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudioUpdate[] $VALUES;
    public static final AudioUpdate SilentModeOn = new AudioUpdate("SilentModeOn", 0);
    public static final AudioUpdate SilentModeOff = new AudioUpdate("SilentModeOff", 1);
    public static final AudioUpdate VolumeUp = new AudioUpdate("VolumeUp", 2);
    public static final AudioUpdate VolumeMute = new AudioUpdate("VolumeMute", 3);

    private static final /* synthetic */ AudioUpdate[] $values() {
        return new AudioUpdate[]{SilentModeOn, SilentModeOff, VolumeUp, VolumeMute};
    }

    public static EnumEntries<AudioUpdate> getEntries() {
        return $ENTRIES;
    }

    static {
        AudioUpdate[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AudioUpdate(String str, int i) {
    }

    public static AudioUpdate valueOf(String str) {
        return (AudioUpdate) Enum.valueOf(AudioUpdate.class, str);
    }

    public static AudioUpdate[] values() {
        return (AudioUpdate[]) $VALUES.clone();
    }
}
