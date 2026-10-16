package com.applovin.impl;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.b6;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.ScriptInjector;
import com.iab.omid.library.applovin.adsession.Partner;
import com.ironsource.C3040d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/* loaded from: classes2.dex */
public class g4 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f463a;
    private final Context b = com.applovin.impl.sdk.k.o();
    private String c;

    public g4(com.applovin.impl.sdk.k kVar) {
        this.f463a = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.c != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getResources().openRawResource(R.raw.omsdk_v1_5_3)));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            this.c = sb.toString();
                            bufferedReader.close();
                            return;
                        }
                        sb.append(readLine);
                    }
                } catch (Throwable th) {
                    try {
                        Log.e("OpenMeasurementService", "Failed to load JavaScript Open Measurement SDK", th);
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
            }
        } catch (Throwable th3) {
            this.f463a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f463a.O().a("OpenMeasurementService", "Failed to retrieve resource omsdk_v1_5_3.js", th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        long currentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.b);
        this.f463a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f463a.O().a("OpenMeasurementService", "Init " + (d() ? "succeeded" : C3040d4.h.t) + " and took " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        h();
    }

    private void h() {
        this.f463a.r0().a((g5) new p6(this.f463a, "OpenMeasurementService", new Runnable() { // from class: com.applovin.impl.g4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                g4.this.f();
            }
        }), b6.b.OTHER);
    }

    public String a() {
        return this.c;
    }

    public Partner b() {
        return Partner.createPartner((String) this.f463a.a(v4.e0), AppLovinSdk.VERSION);
    }

    public String c() {
        return Omid.getVersion();
    }

    public boolean d() {
        return Omid.isActive();
    }

    public boolean e() {
        String str = this.f463a.o0().getExtraParameters().get("enable_omsdk_testing");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    public void i() {
        if (((Boolean) this.f463a.a(v4.d0)).booleanValue()) {
            this.f463a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f463a.O().a("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.g4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    g4.this.g();
                }
            });
        }
    }

    public String a(String str, Map map) {
        String str2;
        try {
            if (e()) {
                String a2 = h4.a(this.f463a, map);
                if (StringUtils.isValidString(a2)) {
                    str2 = ScriptInjector.injectScriptContentIntoHtml(a2, str);
                    return ScriptInjector.injectScriptContentIntoHtml(this.c, str2);
                }
            }
            str2 = str;
            return ScriptInjector.injectScriptContentIntoHtml(this.c, str2);
        } catch (Throwable th) {
            this.f463a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f463a.O().a("OpenMeasurementService", "Failed to inject JavaScript SDK into HTML", th);
            }
            return str;
        }
    }
}
