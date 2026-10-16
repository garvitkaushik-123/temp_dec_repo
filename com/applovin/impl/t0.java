package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.privacy.consentFlow.TermsAndPrivacyPolicyFlowSettingsImpl;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t0;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdError;
import com.inmobi.sdk.InMobiSdk;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class t0 implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f734a;
    private final y0 b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f735a;

        static {
            int[] iArr = new int[AppLovinSdkConfiguration.ConsentFlowUserGeography.values().length];
            f735a = iArr;
            try {
                iArr[AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f735a[AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f735a[AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f736a;
        private boolean b;
        private boolean c;
        private AppLovinCmpError d;
        private s0 e;

        public b() {
        }

        public boolean b() {
            return this.f736a;
        }

        protected void c() {
            this.c = true;
            this.f736a = true;
        }

        protected void d() {
            this.b = true;
            this.f736a = true;
        }

        public b(s0 s0Var) {
            this.e = s0Var;
        }

        public boolean a() {
            return this.c;
        }

        protected void a(AppLovinCmpError appLovinCmpError) {
            this.d = appLovinCmpError;
        }

        protected void a(s0 s0Var) {
            this.e = s0Var;
        }
    }

    public interface c {
        void a(b bVar);
    }

    public t0(com.applovin.impl.sdk.k kVar) {
        this.f734a = kVar;
        this.b = new y0(kVar);
        if (k7.k(com.applovin.impl.sdk.k.o())) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.k.o()).subscribe(this, "start_sdk_consent_flow");
        }
    }

    public static TermsAndPrivacyPolicyFlowSettingsImpl a(Context context) {
        if (context == null) {
            com.applovin.impl.sdk.o.h("ConsentFlowManager", "Failed to get default Terms and Privacy Policy flow settings.");
            return new TermsAndPrivacyPolicyFlowSettingsImpl(false, false, AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, null, null);
        }
        String a2 = k7.a(context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName()), context, (com.applovin.impl.sdk.k) null);
        JSONObject jSONObject = JsonUtils.getJSONObject(StringUtils.isValidString(a2) ? JsonUtils.jsonObjectFromJsonString(a2, new JSONObject()) : new JSONObject(), "consent_flow_settings", new JSONObject());
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = JsonUtils.getBoolean(jSONObject, "consent_flow_enabled", bool);
        Boolean bool3 = JsonUtils.getBoolean(jSONObject, "consent_flow_show_terms_and_privacy_policy_alert_in_gdpr", bool);
        String string = JsonUtils.getString(jSONObject, "consent_flow_debug_user_geography", "");
        String string2 = JsonUtils.getString(jSONObject, "consent_flow_terms_of_service", null);
        Uri parse = URLUtil.isValidUrl(string2) ? Uri.parse(string2) : null;
        String string3 = JsonUtils.getString(jSONObject, "consent_flow_privacy_policy", null);
        return new TermsAndPrivacyPolicyFlowSettingsImpl(bool2.booleanValue(), bool3.booleanValue(), a(string), URLUtil.isValidUrl(string3) ? Uri.parse(string3) : null, parse);
    }

    private TermsAndPrivacyPolicyFlowSettingsImpl c() {
        return (TermsAndPrivacyPolicyFlowSettingsImpl) this.f734a.o0().getTermsAndPrivacyPolicyFlowSettings();
    }

    public JSONObject b() {
        TermsAndPrivacyPolicyFlowSettingsImpl c2 = c();
        Uri privacyPolicyUri = c2.getPrivacyPolicyUri();
        Uri termsOfServiceUri = c2.getTermsOfServiceUri();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "enabled", String.valueOf(j()));
        JsonUtils.putString(jSONObject, "privacy_policy_url", privacyPolicyUri != null ? privacyPolicyUri.toString() : "");
        JsonUtils.putString(jSONObject, "terms_of_service_url", termsOfServiceUri != null ? termsOfServiceUri.toString() : "");
        return jSONObject;
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography d() {
        return c().getDebugUserGeography();
    }

    public String e() {
        Object f = f();
        Object h = h();
        StringBuilder append = new StringBuilder("\nConsent Flow Enabled - ").append(j()).append("\nTerms of Service - ");
        if (h == null) {
            h = AdError.UNDEFINED_DOMAIN;
        }
        StringBuilder append2 = append.append(h).append("\nPrivacy Policy - ");
        if (f == null) {
            f = AdError.UNDEFINED_DOMAIN;
        }
        return append2.append(f).toString();
    }

    public Uri f() {
        return c().getPrivacyPolicyUri();
    }

    public String g() {
        return "Migrate to the new Terms and Privacy Policy Flow by following these steps:\n\t1. Delete the 'terms_flow_settings' entry from your 'applovin_settings.xml' file.\n\t2. Follow the integration instructions in our documentation: " + a();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "consent_flow_manager";
    }

    public Uri h() {
        return c().getTermsOfServiceUri();
    }

    public boolean i() {
        return this.b.a();
    }

    public boolean j() {
        Map<String, String> extraParameters = this.f734a.o0().getExtraParameters();
        return extraParameters.containsKey("consent_flow_enabled") ? Boolean.parseBoolean(extraParameters.get("consent_flow_enabled")) : c().isEnabled();
    }

    public boolean k() {
        if (k7.c(this.f734a)) {
            int i = a.f735a[d().ordinal()];
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
        }
        return this.f734a.w().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
    }

    public boolean l() {
        return this.f734a.o0().getExtraParameters().containsKey("terms_flow_settings");
    }

    public boolean m() {
        return c().shouldShowTermsAndPrivacyPolicyAlertInGdpr();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.b.a(this.f734a.v0(), new c() { // from class: com.applovin.impl.t0$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.t0.c
            public final void a(t0.b bVar) {
                t0.this.a(bVar);
            }
        });
    }

    private void b(final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.t0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                t0.this.a(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Uri uri, DialogInterface dialogInterface, int i) {
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    public void a(Activity activity, final c cVar) {
        if (!j()) {
            cVar.a(new b(new s0(s0.c, "Failed to start consent flow. Please make sure that the consent flow is enabled.")));
        } else if (c().getPrivacyPolicyUri() == null) {
            b(activity);
        } else {
            this.b.a(activity, new c() { // from class: com.applovin.impl.t0$$ExternalSyntheticLambda4
                @Override // com.applovin.impl.t0.c
                public final void a(t0.b bVar) {
                    t0.this.a(cVar, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, b bVar) {
        if (bVar.e == null) {
            this.f734a.b(x4.s, Boolean.FALSE);
        }
        cVar.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        if (bVar.e == null) {
            this.f734a.b(x4.s, Boolean.FALSE);
        }
        AppLovinCommunicator.getInstance(com.applovin.impl.sdk.k.o()).getMessagingService().publish(new AppLovinCommunicatorMessage(new Bundle(), "sdk_consent_flow_finished", this));
    }

    private static AppLovinSdkConfiguration.ConsentFlowUserGeography a(String str) {
        if (InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES.equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
        }
        if ("other".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER;
        }
        return AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        final Uri a2 = a();
        new AlertDialog.Builder(activity).setTitle("Missing Privacy Policy URL").setMessage("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL").setNeutralButton("Go To Documentation", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.t0$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                t0.this.a(a2, dialogInterface, i);
            }
        }).setNegativeButton("DISMISS", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.t0$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                t0.b(a2, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Uri uri, DialogInterface dialogInterface, int i) {
        h7.a(uri, com.applovin.impl.sdk.k.o(), this.f734a);
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    private Uri a() {
        return Uri.parse((String) this.f734a.a(this.f734a.I0() ? v4.M6 : v4.L6));
    }
}
