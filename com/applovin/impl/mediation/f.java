package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.e2;
import com.applovin.impl.g6;
import com.applovin.impl.h3;
import com.applovin.impl.i5;
import com.applovin.impl.k1;
import com.applovin.impl.o3;
import com.applovin.impl.q4;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.x4;
import com.applovin.mediation.adapter.MaxAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final k f588a;
    private final o b;
    private final AtomicBoolean c = new AtomicBoolean();
    private final Set d = new HashSet();
    private final Object e = new Object();
    private final JSONArray f = new JSONArray();
    private final LinkedHashMap g = new LinkedHashMap();
    private final Object h = new Object();
    private final Map i = new HashMap();
    private final Map j = new HashMap();
    private final Object k = new Object();
    private List l;

    public f(k kVar) {
        this.f588a = kVar;
        this.b = kVar.O();
    }

    public void a(Activity activity) {
        if (this.c.compareAndSet(false, true)) {
            String str = (String) this.f588a.a(x4.F);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<h3> a2 = a(JsonUtils.getJSONArray(jSONObject, this.f588a.t0().c() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.l = a2;
                    for (h3 h3Var : a2) {
                        this.i.put(h3Var.b(), h3Var);
                    }
                    long parseLong = StringUtils.parseLong(this.f588a.o0().getExtraParameters().get("adapter_initialization_delay_ms"), -1L);
                    i5 i5Var = new i5(a2, activity, this.f588a);
                    if (parseLong > 0) {
                        this.f588a.r0().a(i5Var, b6.b.MEDIATION, parseLong);
                    } else {
                        this.f588a.r0().a(i5Var);
                    }
                } catch (JSONException e) {
                    if (o.a()) {
                        this.b.a("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e);
                    }
                    k1.a((Throwable) e);
                }
            }
        }
    }

    public JSONArray b() {
        JSONArray shallowCopy;
        synchronized (this.h) {
            shallowCopy = JsonUtils.shallowCopy(this.f);
        }
        return shallowCopy;
    }

    public boolean c() {
        return this.c.get();
    }

    private void c(h3 h3Var) {
        String b = h3Var.b();
        synchronized (this.e) {
            if (this.d.contains(b)) {
                return;
            }
            this.d.add(b);
            this.f588a.P().d(c2.O, e2.a(h3Var));
        }
    }

    boolean b(h3 h3Var) {
        boolean containsKey;
        synchronized (this.h) {
            containsKey = this.g.containsKey(h3Var.b());
        }
        return containsKey;
    }

    public q4 a(h3 h3Var, Activity activity) {
        h3 a2 = a(h3Var);
        if (a2 == null) {
            return q4.a("AdapterInitialization:" + h3Var.c(), MaxAdapter.InitializationStatus.DOES_NOT_APPLY);
        }
        String b = h3Var.b();
        synchronized (this.k) {
            q4 q4Var = (q4) this.j.get(b);
            if (q4Var != null && (!q4Var.d() || !a2.q())) {
                return q4Var;
            }
            final q4 q4Var2 = new q4("AdapterInitialization:" + h3Var.c());
            this.j.put(b, q4Var2);
            h a3 = this.f588a.T().a(a2);
            if (a3 == null) {
                q4Var2.a("Adapter implementation not found");
                return q4Var2;
            }
            if (o.a()) {
                this.b.d("MediationAdapterInitializationManager", "Initializing adapter " + a2);
            }
            c(a2);
            a3.a(MaxAdapterParametersImpl.a(a2), activity, new MaxAdapter.OnCompletionListener() { // from class: com.applovin.impl.mediation.f$$ExternalSyntheticLambda0
                @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
                public final void onCompletion(MaxAdapter.InitializationStatus initializationStatus, String str) {
                    f.a(q4.this, initializationStatus, str);
                }
            });
            g6.a(a2.m(), q4Var2, "The adapter (" + h3Var.c() + ") timed out initializing", "MediationAdapterInitializationManager", this.f588a);
            return q4Var2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(q4 q4Var, MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            if (initializationStatus == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE) {
                q4Var.a(str);
                return;
            } else {
                q4Var.b(initializationStatus);
                return;
            }
        }
        k1.a("Adapters should never report a null or INITIALIZING status.", new Object[0]);
        q4Var.a("Adapter reported INITIALIZING");
    }

    private h3 a(h3 h3Var) {
        List<h3> list;
        if (((Boolean) this.f588a.a(o3.l8)).booleanValue()) {
            h3 h3Var2 = (h3) this.i.get(h3Var.b());
            return h3Var2 != null ? h3Var2 : h3Var;
        }
        if (!this.f588a.t0().c() || (list = this.l) == null) {
            return h3Var;
        }
        for (h3 h3Var3 : list) {
            if (h3Var3.b().equals(h3Var.b())) {
                return h3Var3;
            }
        }
        return null;
    }

    public Integer a(String str) {
        Integer num;
        synchronized (this.h) {
            num = (Integer) this.g.get(str);
        }
        return num;
    }

    public Set a() {
        HashSet hashSet;
        synchronized (this.h) {
            hashSet = new HashSet(this.g.keySet());
        }
        return hashSet;
    }

    void a(h3 h3Var, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean b;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.h) {
            b = b(h3Var);
            if (!b) {
                this.g.put(h3Var.b(), Integer.valueOf(initializationStatus.getCode()));
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putString(jSONObject, "class", h3Var.b());
                JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                JsonUtils.putLong(jSONObject, "init_time_ms", j);
                JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                this.f.put(jSONObject);
            }
        }
        if (b) {
            return;
        }
        this.f588a.a(h3Var);
        this.f588a.X().processAdapterInitializationPostback(h3Var, j, initializationStatus, str);
        this.f588a.u().a(initializationStatus, h3Var.b());
    }

    private List a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new h3(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.f588a));
        }
        return arrayList;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.h) {
            this.g.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.f588a.u().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }
}
