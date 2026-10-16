package com.sourcepoint.cmplibrary.model;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.InvalidResponseWebMessageException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageModelResp.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getAppliedLegislation", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MessageModelRespKt {
    public static final CampaignType getAppliedLegislation(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES)) {
            return CampaignType.GDPR;
        }
        if (Intrinsics.areEqual(lowerCase, "ccpa")) {
            return CampaignType.CCPA;
        }
        throw new InvalidResponseWebMessageException(null, "Invalid Legislation type", false, 5, null);
    }
}
