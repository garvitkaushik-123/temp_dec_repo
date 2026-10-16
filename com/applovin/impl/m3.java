package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.b3;
import com.applovin.impl.b6;
import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.N6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class m3 implements q0.e {
    private static WeakReference l;
    private static final AtomicBoolean m = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f544a;
    private final com.applovin.impl.sdk.o b;
    private final Context c;
    private final l3 d;
    private boolean g;
    private boolean i;
    private Map j;
    private final b0 k;
    private final Map e = new HashMap();
    private final AtomicBoolean f = new AtomicBoolean();
    private int h = 2;

    class a extends b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.o.g("AppLovinSdk", "Started mediation debugger");
                if (!m3.this.c() || m3.l.get() != activity) {
                    MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                    WeakReference unused = m3.l = new WeakReference(maxDebuggerActivity);
                    maxDebuggerActivity.setListAdapter(m3.this.d, m3.this.f544a.e());
                }
                m3.m.set(false);
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.o.g("AppLovinSdk", "Mediation debugger destroyed");
                WeakReference unused = m3.l = null;
            }
        }
    }

    public m3(com.applovin.impl.sdk.k kVar) {
        this.f544a = kVar;
        this.b = kVar.O();
        Context o = com.applovin.impl.sdk.k.o();
        this.c = o;
        l3 l3Var = new l3(o);
        this.d = l3Var;
        this.k = new b0(kVar, l3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Activity v0 = this.f544a.v0();
        if (v0 == null || v0.isFinishing()) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "MAX Mediation Debugger has flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this log will only be shown in your development builds. Live apps will not be affected.");
        } else {
            new AlertDialog.Builder(v0).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.m3$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    m3.this.a(dialogInterface, i);
                }
            }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
        }
    }

    private void f() {
        this.f544a.e().a(new a());
    }

    public void e() {
        if (this.f.compareAndSet(false, true)) {
            this.f544a.r0().a((g5) new u5(this, this.f544a), b6.b.OTHER);
        }
    }

    public boolean g() {
        return this.g;
    }

    public void h() {
        a((Map) null);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.d + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        WeakReference weakReference = l;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void a(boolean z, int i) {
        this.g = z;
        this.h = i;
    }

    public void a(Map map) {
        this.j = map;
        e();
        if (!c() && m.compareAndSet(false, true)) {
            if (!this.i) {
                f();
                this.i = true;
            }
            Intent intent = new Intent(this.c, (Class<?>) MaxDebuggerActivity.class);
            intent.setFlags(268435456);
            com.applovin.impl.sdk.o.g("AppLovinSdk", "Starting mediation debugger...");
            this.c.startActivity(intent);
            return;
        }
        com.applovin.impl.sdk.o.h("AppLovinSdk", "Mediation debugger is already showing");
    }

    public List a(String str) {
        Map map = this.j;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (List) this.j.get(str);
    }

    private void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b3 b3Var = (b3) it.next();
            if (b3Var.A() && b3Var.q() == b3.a.INVALID_INTEGRATION) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.m3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        m3.this.d();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        h();
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, N6.D1, new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                b3 b3Var = new b3(jSONObject2, kVar);
                arrayList.add(b3Var);
                this.e.put(b3Var.b(), b3Var);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List a(JSONObject jSONObject, List list, com.applovin.impl.sdk.k kVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new n(jSONObject2, this.e, kVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List a(List list, com.applovin.impl.sdk.k kVar) {
        List<String> adUnitIds = kVar.K() != null ? kVar.K().getAdUnitIds() : null;
        if (adUnitIds != null && !adUnitIds.isEmpty()) {
            ArrayList arrayList = new ArrayList(adUnitIds.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (adUnitIds.contains(nVar.c())) {
                    arrayList.add(nVar);
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private List a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : JsonUtils.getList(jSONObject, "required_app_ads_txt_entries", new ArrayList())) {
            a0 a0Var = new a0(str);
            if (a0Var.h()) {
                arrayList.add(a0Var);
            } else if (com.applovin.impl.sdk.o.a()) {
                this.b.b("MediationDebuggerService", "app-ads.txt entry passed down for validation is misformatted: " + str);
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.q0.e
    public void a(String str, JSONObject jSONObject, int i) {
        List a2 = a(jSONObject, this.f544a);
        List a3 = a(jSONObject, a2, this.f544a);
        List a4 = a(a3, this.f544a);
        List a5 = a(jSONObject);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        this.d.a(a2, a3, a4, a5, JsonUtils.getString(jSONObject2, "title", null), JsonUtils.getString(jSONObject2, PglCryptUtils.KEY_MESSAGE, null), JsonUtils.getString(jSONObject, "account_id", null), JsonUtils.getBoolean(jSONObject, "should_display_cmp_details", Boolean.TRUE).booleanValue(), this.f544a);
        if (!a5.isEmpty()) {
            this.k.a();
        }
        if (g()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.m3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    m3.this.h();
                }
            }, TimeUnit.SECONDS.toMillis(this.h));
        } else {
            a(a2);
        }
    }

    @Override // com.applovin.impl.q0.e
    public void a(String str, int i, String str2, JSONObject jSONObject) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.b("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i);
        }
        com.applovin.impl.sdk.o.h("AppLovinSdk", "Unable to show mediation debugger.");
        this.f544a.E().a("fetchMediationDebuggerInfo", str, i, str2);
        this.d.a(null, null, null, null, null, null, null, false, this.f544a);
        this.f.set(false);
    }
}
