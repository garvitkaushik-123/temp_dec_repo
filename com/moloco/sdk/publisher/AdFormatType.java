package com.moloco.sdk.publisher;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/moloco/sdk/publisher/AdFormatType;", "", "<init>", "(Ljava/lang/String;I)V", "BANNER", "INTERSTITIAL", "REWARDED", "MREC", "NATIVE", "toLowercase", "", "toTitlecase", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AdFormatType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdFormatType[] $VALUES;
    public static final AdFormatType BANNER = new AdFormatType("BANNER", 0);
    public static final AdFormatType INTERSTITIAL = new AdFormatType("INTERSTITIAL", 1);
    public static final AdFormatType REWARDED = new AdFormatType("REWARDED", 2);
    public static final AdFormatType MREC = new AdFormatType("MREC", 3);
    public static final AdFormatType NATIVE = new AdFormatType("NATIVE", 4);

    private static final /* synthetic */ AdFormatType[] $values() {
        return new AdFormatType[]{BANNER, INTERSTITIAL, REWARDED, MREC, NATIVE};
    }

    static {
        AdFormatType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AdFormatType(String str, int i) {
    }

    public static EnumEntries<AdFormatType> getEntries() {
        return $ENTRIES;
    }

    public static AdFormatType valueOf(String str) {
        return (AdFormatType) Enum.valueOf(AdFormatType.class, str);
    }

    public static AdFormatType[] values() {
        return (AdFormatType[]) $VALUES.clone();
    }

    public final String toLowercase() {
        String lowerCase = toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String toTitlecase() {
        String lowercase = toLowercase();
        if (lowercase.length() <= 0) {
            return lowercase;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = lowercase.charAt(0);
        StringBuilder append = sb.append((Object) (Character.isLowerCase(charAt) ? CharsKt.titlecase(charAt) : String.valueOf(charAt)));
        String substring = lowercase.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return append.append(substring).toString();
    }
}
