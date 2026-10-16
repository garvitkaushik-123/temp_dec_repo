package io.adn.sdk.publisher;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdnAdPlacement.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/publisher/AdnAdPlacement;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INTERSTITIAL", "REWARDED", "NATIVE", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnAdPlacement {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdnAdPlacement[] $VALUES;
    private final String value;
    public static final AdnAdPlacement INTERSTITIAL = new AdnAdPlacement("INTERSTITIAL", 0, "Interstitial");
    public static final AdnAdPlacement REWARDED = new AdnAdPlacement("REWARDED", 1, IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
    public static final AdnAdPlacement NATIVE = new AdnAdPlacement("NATIVE", 2, "Native");

    private static final /* synthetic */ AdnAdPlacement[] $values() {
        return new AdnAdPlacement[]{INTERSTITIAL, REWARDED, NATIVE};
    }

    public static EnumEntries<AdnAdPlacement> getEntries() {
        return $ENTRIES;
    }

    private AdnAdPlacement(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AdnAdPlacement[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AdnAdPlacement valueOf(String str) {
        return (AdnAdPlacement) Enum.valueOf(AdnAdPlacement.class, str);
    }

    public static AdnAdPlacement[] values() {
        return (AdnAdPlacement[]) $VALUES.clone();
    }
}
