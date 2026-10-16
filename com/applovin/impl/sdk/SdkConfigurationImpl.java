package com.applovin.impl.sdk;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdkConfiguration;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class SdkConfigurationImpl implements AppLovinSdkConfiguration {

    /* renamed from: a, reason: collision with root package name */
    private final k f667a;
    private List b;

    public SdkConfigurationImpl(k kVar) {
        this.f667a = kVar;
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
        String str = this.f667a.o0().getExtraParameters().get("consent_dialog_state");
        if (!StringUtils.isValidString(str)) {
            str = (String) this.f667a.a(v4.I6);
        }
        return "applies".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.APPLIES : "does_not_apply".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY : AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public AppLovinSdkConfiguration.ConsentFlowUserGeography getConsentFlowUserGeography() {
        String str = (String) this.f667a.a(v4.I6);
        return "applies".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR : "does_not_apply".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER : AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public String getCountryCode() {
        return (String) this.f667a.a(v4.J6);
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public List<String> getEnabledAmazonAdUnitIds() {
        return this.b;
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public boolean isTestModeEnabled() {
        return this.f667a.t0().c();
    }

    public void setEnabledAmazonAdUnitIds(List<String> list) {
        this.b = list;
    }

    public String toString() {
        return "AppLovinSdkConfiguration{, countryCode=" + getCountryCode() + ", enabledAmazonAdUnitIds=" + getEnabledAmazonAdUnitIds() + ", testModeEnabled=" + isTestModeEnabled() + AbstractJsonLexerKt.END_OBJ;
    }
}
