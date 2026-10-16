package io.bidmachine.models;

import java.util.List;

/* loaded from: classes7.dex */
public interface IUserRestrictionsParams<SelfType> {
    SelfType setConsentConfig(boolean hasConsent, String consentString);

    SelfType setCoppa(Boolean coppa);

    SelfType setGPP(String gppString, List<Integer> gppIds);

    SelfType setSubjectToGDPR(Boolean subject);

    SelfType setUSPrivacyString(String usPrivacyString);
}
