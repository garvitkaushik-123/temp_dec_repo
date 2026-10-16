package com.applovin.sdk;

import android.net.Uri;
import com.applovin.sdk.AppLovinSdkConfiguration;

/* loaded from: classes2.dex */
public interface AppLovinTermsAndPrivacyPolicyFlowSettings {
    AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography();

    Uri getPrivacyPolicyUri();

    Uri getTermsOfServiceUri();

    boolean isEnabled();

    void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography);

    void setEnabled(boolean z);

    void setPrivacyPolicyUri(Uri uri);

    void setShowTermsAndPrivacyPolicyAlertInGdpr(boolean z);

    void setTermsOfServiceUri(Uri uri);

    boolean shouldShowTermsAndPrivacyPolicyAlertInGdpr();
}
