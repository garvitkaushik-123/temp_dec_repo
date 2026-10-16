package com.applovin.impl;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.impl.b6;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class a6 extends g5 {
    private final com.applovin.impl.sdk.k g;

    public a6(com.applovin.impl.sdk.k kVar) {
        super("TaskInitializeSdk", kVar, true);
        this.g = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.g.S().a(this.g.e().b());
    }

    private void f() {
        if (this.g.S().c()) {
            return;
        }
        Activity v0 = this.g.v0();
        if (v0 != null) {
            this.g.S().a(v0);
        } else {
            this.g.E().a(c2.p0, this.b + ":maybeInitializeAdapters()");
            this.g.r0().a(new p6(this.g, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.a6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a6.this.e();
                }
            }), b6.b.CORE, TimeUnit.SECONDS.toMillis(1L));
        }
    }

    private void g() {
        boolean c = this.g.p0().c();
        Map o = this.g.B().o();
        Map K = this.g.B().K();
        String a2 = c ? this.g.B().f().a() : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        String str = c ? o.get("idfv") + " (use this for test devices)" : "<Enable verbose logging to see the App Set ID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        s2 s2Var = new s2();
        s2Var.a().a("=====AppLovin SDK=====");
        s2Var.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.g.a(v4.I3)).a("Ad Review Version", j.b()).a("OM SDK Version", this.g.e0().c());
        s2Var.a("===Device Info===").a(com.moloco.sdk.acm.b.d, k7.d()).a(IronSourceConstants.TYPE_GAID, a2).a("App Set ID", str).a(ExifInterface.TAG_MODEL, o.get(N6.B)).a("Locale", o.get("locale")).a("Emulator", o.get("sim")).a("Tablet", o.get("is_tablet"));
        s2Var.a("===App Info===").a("Application ID", K.get("package_name")).a("Target SDK", K.get("target_sdk"));
        s2Var.a("===SDK Settings===").a("SDK Key", this.g.j0()).a("Mediation Provider", this.g.V()).a("TG", j7.a(this.g)).a("MD", this.g.a(v4.t)).a("Test Mode On", Boolean.valueOf(this.g.t0().c())).a("Verbose Logging On", Boolean.valueOf(c));
        s2Var.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(p0.a(a()));
        s2Var.a("===MAX Terms and Privcay Policy Flow===");
        t0 y = this.g.y();
        boolean j = y.j();
        s2Var.a("Enabled", Boolean.valueOf(j));
        if (j) {
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.g.w().getConsentFlowUserGeography();
            AppLovinSdkConfiguration.ConsentFlowUserGeography d = y.d();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography2 = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            String str2 = "Other";
            s2Var.a("Consent Flow Geography", consentFlowUserGeography == consentFlowUserGeography2 ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "Unknown");
            if (k7.c(this.g)) {
                if (d == consentFlowUserGeography2) {
                    str2 = "GDPR";
                } else if (consentFlowUserGeography != AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER) {
                    str2 = "None";
                }
                s2Var.a("Debug User Geography", str2);
            }
        }
        s2Var.a("Privacy Policy URI", y.f()).a("Terms of Service URI", y.h());
        s2Var.a("===CMP (CONSENT MANAGEMENT PLATFORM)===").a(this.g.s0().i());
        s2Var.a();
        com.applovin.impl.sdk.o.g("AppLovinSdk", s2Var.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0197, code lost:
    
        if (r12.g.C0() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0224, code lost:
    
        r2 = com.ironsource.C3040d4.h.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0225, code lost:
    
        r8.a(r9, r4.append(r2).append(" in ").append(java.lang.System.currentTimeMillis() - r6).append("ms").toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0241, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0221, code lost:
    
        if (r12.g.C0() != false) goto L51;
     */
    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.applovin.impl.sdk.o oVar;
        String str;
        StringBuilder append;
        long currentTimeMillis = System.currentTimeMillis();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Initializing AppLovin SDK v" + AppLovinSdk.VERSION + "...");
        }
        try {
            this.g.H().b(a());
            this.g.H().e(a());
            this.g.r0().a((g5) new h5(this.g), b6.b.OTHER);
            this.g.B().U();
            this.g.m0().c();
            this.g.z().l();
            if (k7.c(this.g)) {
                this.g.a();
            }
            this.g.Z0();
            this.g.p().collectAppHubData();
            g();
            f();
            this.g.a(true);
            this.g.f0().b();
            this.g.k().maybeFireAppKilledWhilePlayingAdPostback();
            if (((Boolean) this.g.a(v4.A2)).booleanValue()) {
                this.g.X().maybeFireAppKilledWhilePlayingMediatedAdPostback();
            }
            this.g.G().maybeTrackAppOpenEvent();
            this.g.A().a();
            if (((Boolean) this.g.a(v4.N2)).booleanValue()) {
                this.g.y0().b();
            }
            if (((Boolean) this.g.a(v4.W0)).booleanValue()) {
                this.g.h().b();
            } else {
                this.g.h().g();
            }
            if (this.g.U().g() || (((Boolean) this.g.a(o3.l7)).booleanValue() && k7.c(this.g) && this.g.H0())) {
                this.g.U().e();
            }
            if (this.g.h0() != null) {
                this.g.h0().b((String) this.g.a(v4.u));
            }
            this.g.e0().i();
            if (!com.applovin.impl.sdk.o.a()) {
                return;
            }
            oVar = this.c;
            str = this.b;
            append = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
        } catch (Throwable th) {
            try {
                com.applovin.impl.sdk.o.c("AppLovinSdk", "Failed to initialize SDK!", th);
                this.g.a(false);
                a(th);
                if (((Boolean) this.g.a(v4.i)).booleanValue()) {
                    this.g.f0().a();
                }
                if (((Boolean) this.g.a(v4.h)).booleanValue()) {
                    this.g.V0();
                }
                if (this.g.h0() != null) {
                    this.g.h0().b((String) this.g.a(v4.u));
                }
                this.g.e0().i();
                if (!com.applovin.impl.sdk.o.a()) {
                    return;
                }
                oVar = this.c;
                str = this.b;
                append = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
            } catch (Throwable th2) {
                if (this.g.h0() != null) {
                    this.g.h0().b((String) this.g.a(v4.u));
                }
                this.g.e0().i();
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "AppLovin SDK " + AppLovinSdk.VERSION + " initialization " + (this.g.C0() ? "succeeded" : C3040d4.h.t) + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                throw th2;
            }
        }
    }
}
