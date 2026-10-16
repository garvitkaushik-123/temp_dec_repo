package com.inmobi.media;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class E9 {
    public static String a(String valueTypeString) {
        Intrinsics.checkNotNullParameter(valueTypeString, "valueTypeString");
        int length = valueTypeString.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) valueTypeString.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, valueTypeString, i);
        int hashCode = a2.hashCode();
        return hashCode != -1900324833 ? hashCode != -835221992 ? hashCode != 116079 ? (hashCode == 3213227 && a2.equals(AnalyticsConstants.CREATIVE_TYPE_HTML)) ? "HTML" : "UNKNOWN" : !a2.equals("url") ? "UNKNOWN" : "URL" : !a2.equals("reference_iframe") ? "UNKNOWN" : "REF_IFRAME" : !a2.equals("reference_html") ? "UNKNOWN" : "REF_HTML";
    }
}
