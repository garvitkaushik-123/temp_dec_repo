package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.c2;
import com.applovin.impl.k0;
import com.applovin.impl.k7;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final k f628a;
    private final o b;
    private ConsentForm c;
    private int d;

    /* renamed from: com.applovin.impl.privacy.cmp.a$a, reason: collision with other inner class name */
    public interface InterfaceC0100a {
        void onFlowHidden(Bundle bundle);

        void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl);

        void onFlowLoaded(Bundle bundle);

        void onFlowShowFailed(CmpErrorImpl cmpErrorImpl);
    }

    public a(k kVar) {
        this.f628a = kVar;
        this.b = kVar.O();
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(k.o());
        a("Initializing with SDK Version: " + b() + ", consentStatus: " + consentInformation.getConsentStatus() + ", consentFormAvailable: " + consentInformation.isConsentFormAvailable());
    }

    public void a() {
        if (this.c != null) {
            this.c = null;
        }
        this.d = 0;
    }

    public String b() {
        return null;
    }

    public void c() {
        a("Resetting consent information");
        UserMessagingPlatform.getConsentInformation(k.o()).reset();
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(InterfaceC0100a interfaceC0100a, FormError formError) {
        b("Failed to request consent info with error: " + formError.getMessage());
        interfaceC0100a.onFlowLoadFailed(a(formError, "Consent info update failed"));
    }

    private boolean c(String str) {
        if (!this.f628a.c(v4.P6).contains(str)) {
            return false;
        }
        Integer num = (Integer) this.f628a.a(v4.O6);
        return num.intValue() < 0 || this.d < num.intValue();
    }

    public void b(Activity activity, final k0 k0Var, final InterfaceC0100a interfaceC0100a) {
        if (this.c == null) {
            b("Failed to show - not ready yet");
            interfaceC0100a.onFlowShowFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form not ready"));
        } else {
            a("Showing consent form...");
            this.c.show(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda6
                @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
                public final void onConsentFormDismissed(FormError formError) {
                    a.this.a(k0Var, interfaceC0100a, formError);
                }
            });
        }
    }

    public void a(final Activity activity, k0 k0Var, final InterfaceC0100a interfaceC0100a) {
        ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
        if (k7.c(this.f628a) && k0Var.a() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            builder.setConsentDebugSettings(new ConsentDebugSettings.Builder(activity).setForceTesting(true).setDebugGeography(1).addTestDeviceHashedId(StringUtils.emptyIfNull(this.f628a.o0().getExtraParameters().get("google_test_device_hashed_id"))).build());
        }
        UserMessagingPlatform.getConsentInformation(activity).requestConsentInfoUpdate(activity, builder.build(), new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda0
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
            public final void onConsentInfoUpdateSuccess() {
                a.this.a(activity, interfaceC0100a);
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda1
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
            public final void onConsentInfoUpdateFailure(FormError formError) {
                a.this.b(interfaceC0100a, formError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(final FormError formError, final k0 k0Var, final InterfaceC0100a interfaceC0100a) {
        a("Retrying to load and show consent form...");
        this.d++;
        UserMessagingPlatform.loadConsentForm(k.o(), new UserMessagingPlatform.OnConsentFormLoadSuccessListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda4
            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
            public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
                a.this.a(interfaceC0100a, formError, k0Var, consentForm);
            }
        }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda5
            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
            public final void onConsentFormLoadFailure(FormError formError2) {
                a.this.a(interfaceC0100a, formError, formError2);
            }
        });
    }

    private void b(String str) {
        if (o.a()) {
            this.b.b("GoogleCmpAdapter", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, final InterfaceC0100a interfaceC0100a) {
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(activity);
        boolean isConsentFormAvailable = consentInformation.isConsentFormAvailable();
        int consentStatus = consentInformation.getConsentStatus();
        a("Loaded parameters consentStatus: " + consentStatus + ", consentFormAvailable: " + isConsentFormAvailable);
        if (!isConsentFormAvailable) {
            b("Failed to load form.");
            interfaceC0100a.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form unavailable"));
        } else if (consentStatus != 2) {
            b("Failed to load with consent status: " + consentStatus);
            interfaceC0100a.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_NOT_REQUIRED, "Consent form not required for consent status: " + consentStatus));
        } else {
            a("Successfully requested consent info");
            a("Loading consent form...");
            UserMessagingPlatform.loadConsentForm(activity, new UserMessagingPlatform.OnConsentFormLoadSuccessListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda2
                @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
                public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
                    a.this.a(interfaceC0100a, consentForm);
                }
            }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda3
                @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
                public final void onConsentFormLoadFailure(FormError formError) {
                    a.this.a(interfaceC0100a, formError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC0100a interfaceC0100a, ConsentForm consentForm) {
        a("Successfully loaded consent form");
        this.c = consentForm;
        interfaceC0100a.onFlowLoaded(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC0100a interfaceC0100a, FormError formError) {
        b("Failed to load with error: " + formError.getMessage());
        interfaceC0100a.onFlowLoadFailed(a(formError, "Consent form load failed"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final k0 k0Var, final InterfaceC0100a interfaceC0100a, final FormError formError) {
        if (formError != null) {
            String valueOf = String.valueOf(formError.getErrorCode());
            String message = formError.getMessage();
            HashMap hashMap = new HashMap(2);
            hashMap.put(AndroidBridgeConstants.ERROR_CODE, valueOf);
            hashMap.put("error_message", message);
            this.f628a.E().a(c2.B0, "googleConsentFormDismissed", hashMap);
            if (c(valueOf)) {
                a("Consent form was dismissed due to error: " + message);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.privacy.cmp.a$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(formError, k0Var, interfaceC0100a);
                    }
                });
                return;
            } else {
                b("Failed to show with error: " + message);
                interfaceC0100a.onFlowShowFailed(a(formError, "Consent form show failed"));
                return;
            }
        }
        a("Consent form finished showing");
        interfaceC0100a.onFlowHidden(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC0100a interfaceC0100a, FormError formError, k0 k0Var, ConsentForm consentForm) {
        a("Successfully re-loaded consent form");
        this.c = consentForm;
        Activity v0 = this.f628a.v0();
        if (v0 == null) {
            interfaceC0100a.onFlowShowFailed(a(formError, "Consent form show failed"));
        } else {
            b(v0, k0Var, interfaceC0100a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC0100a interfaceC0100a, FormError formError, FormError formError2) {
        b("Retry to load failed with error: " + formError2.getMessage());
        interfaceC0100a.onFlowShowFailed(a(formError, "Consent form show failed"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r1 != 4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CmpErrorImpl a(FormError formError, String str) {
        AppLovinCmpError.Code code = AppLovinCmpError.Code.UNSPECIFIED;
        int errorCode = formError.getErrorCode();
        if (errorCode != 1 && errorCode != 2) {
            if (errorCode == 3) {
                code = AppLovinCmpError.Code.INTEGRATION_ERROR;
            }
            return new CmpErrorImpl(code, str, formError.getErrorCode(), formError.getMessage());
        }
        code = AppLovinCmpError.Code.FORM_UNAVAILABLE;
        return new CmpErrorImpl(code, str, formError.getErrorCode(), formError.getMessage());
    }

    private void a(String str) {
        if (o.a()) {
            this.b.a("GoogleCmpAdapter", str);
        }
    }
}
