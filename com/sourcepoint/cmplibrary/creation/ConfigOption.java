package com.sourcepoint.cmplibrary.creation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SpConfigDataBuilder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sourcepoint/cmplibrary/creation/ConfigOption;", "", "option", "", "(Ljava/lang/String;ILjava/lang/String;)V", "TRANSITION_CCPA_AUTH", "SUPPORT_LEGACY_USPSTRING", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConfigOption[] $VALUES;
    public static final ConfigOption TRANSITION_CCPA_AUTH = new ConfigOption("TRANSITION_CCPA_AUTH", 0, "transitionCCPAAuth");
    public static final ConfigOption SUPPORT_LEGACY_USPSTRING = new ConfigOption("SUPPORT_LEGACY_USPSTRING", 1, "supportLegacyUSPString");

    private static final /* synthetic */ ConfigOption[] $values() {
        return new ConfigOption[]{TRANSITION_CCPA_AUTH, SUPPORT_LEGACY_USPSTRING};
    }

    public static EnumEntries<ConfigOption> getEntries() {
        return $ENTRIES;
    }

    public static ConfigOption valueOf(String str) {
        return (ConfigOption) Enum.valueOf(ConfigOption.class, str);
    }

    public static ConfigOption[] values() {
        return (ConfigOption[]) $VALUES.clone();
    }

    private ConfigOption(String str, int i, String str2) {
    }

    static {
        ConfigOption[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
