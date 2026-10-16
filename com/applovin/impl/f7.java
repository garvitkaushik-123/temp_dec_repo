package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.o2;
import com.applovin.impl.p2;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class f7 extends k3 {

    /* renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f454a;
    private p2 b;

    class a extends p2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return d.values().length;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return i == d.SETTINGS.ordinal() ? f7.this.c() : f7.this.a();
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return i == d.SETTINGS.ordinal() ? e.values().length : c.values().length;
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return i == d.SETTINGS.ordinal() ? new t4("SETTINGS") : new t4("GDPR APPLICABILITY");
        }
    }

    class b implements p2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.k f455a;

        b(com.applovin.impl.sdk.k kVar) {
            this.f455a = kVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            if (i2Var.b() == d.SETTINGS.ordinal()) {
                if (i2Var.a() == e.PRIVACY_POLICY_URL.ordinal()) {
                    if (this.f455a.y().f() != null) {
                        h7.a(this.f455a.y().f(), com.applovin.impl.sdk.k.o(), this.f455a);
                        return;
                    } else {
                        k7.a("Missing Privacy Policy URL", "You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL", f7.this);
                        return;
                    }
                }
                if (i2Var.a() != e.TERMS_OF_SERVICE_URL.ordinal() || this.f455a.y().h() == null) {
                    return;
                }
                h7.a(this.f455a.y().h(), com.applovin.impl.sdk.k.o(), this.f455a);
            }
        }
    }

    private enum c {
        DESCRIPTION,
        CONSENT_FLOW_GEOGRAPHY,
        DEBUG_USER_GEOGRAPHY
    }

    private enum d {
        SETTINGS,
        GDPR_APPLICABILITY
    }

    private enum e {
        PRIVACY_POLICY_URL,
        TERMS_OF_SERVICE_URL
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(e.values().length);
        arrayList.add(b());
        arrayList.add(d());
        return arrayList;
    }

    private o2 d() {
        o2.b d2 = o2.a().d("Terms of Service URL");
        if (this.f454a.y().h() != null) {
            d2.a(R.drawable.applovin_ic_check_mark_bordered);
            d2.b(m0.a(R.color.applovin_sdk_checkmarkColor, this));
            d2.a(true);
        } else {
            d2.c("None");
            d2.a(false);
        }
        return d2.a();
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f454a;
    }

    public void initialize(com.applovin.impl.sdk.k kVar) {
        this.f454a = kVar;
        a aVar = new a(this);
        this.b = aVar;
        aVar.a(new b(kVar));
        this.b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("MAX Terms and Privacy Policy Flow");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p2 p2Var = this.b;
        if (p2Var != null) {
            p2Var.a((p2.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        ArrayList arrayList = new ArrayList(c.values().length);
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f454a.w().getConsentFlowUserGeography();
        AppLovinSdkConfiguration.ConsentFlowUserGeography d2 = this.f454a.y().d();
        boolean z = k7.c(this.f454a) && d2 != AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
        arrayList.add(o2.a().d("AppLovin determines whether the user is located in a GDPR region. If the user is in a GDPR region, the MAX SDK presents Google UMP.\n\nYou can test the flow on debug mode by overriding the region check by setting the debug user geography.").a());
        arrayList.add(a(consentFlowUserGeography, !z));
        arrayList.add(b(d2, z));
        return arrayList;
    }

    private o2 b() {
        boolean z = this.f454a.y().f() != null;
        return o2.a().d("Privacy Policy URL").a(z ? R.drawable.applovin_ic_check_mark_bordered : R.drawable.applovin_ic_x_mark).b(m0.a(z ? R.color.applovin_sdk_checkmarkColor : R.color.applovin_sdk_xmarkColor, this)).a(true).a();
    }

    private o2 b(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z) {
        return o2.a().d("Debug User Geography").c(consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "None").b(z).a();
    }

    private o2 a(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, boolean z) {
        return o2.a().d("Consent Flow Geography").c(consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "Unknown").b(z).a();
    }
}
