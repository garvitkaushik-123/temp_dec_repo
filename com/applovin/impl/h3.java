package com.applovin.impl;

import android.os.Bundle;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class h3 {

    /* renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f476a;
    private final JSONObject b;
    protected final JSONObject d;
    private final Map f;
    private final f5 g;
    protected final f5 h;
    private String i;
    private String j;
    private final Object c = new Object();
    protected final Object e = new Object();

    public h3(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        this.f476a = kVar;
        if (((Boolean) kVar.a(v4.q6)).booleanValue()) {
            this.g = new f5(jSONObject2);
            this.h = new f5(jSONObject);
            this.b = null;
            this.d = null;
        } else {
            this.b = jSONObject2;
            this.d = jSONObject;
            this.g = null;
            this.h = null;
        }
        this.f = map;
    }

    private int j() {
        return a("mute_state", b("mute_state", ((Integer) this.f476a.a(o3.S7)).intValue()));
    }

    protected JSONObject a() {
        JSONObject jSONObject;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a();
        }
        synchronized (this.e) {
            jSONObject = this.d;
        }
        return jSONObject;
    }

    protected Boolean b(String str, Boolean bool) {
        Boolean bool2;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a(str, bool);
        }
        synchronized (this.c) {
            bool2 = JsonUtils.getBoolean(this.b, str, bool);
        }
        return bool2;
    }

    protected boolean c(String str) {
        boolean has;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str);
        }
        synchronized (this.e) {
            has = this.d.has(str);
        }
        return has;
    }

    protected boolean d(String str) {
        boolean has;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a(str);
        }
        synchronized (this.c) {
            has = this.b.has(str);
        }
        return has;
    }

    protected Object e(String str) {
        Object opt;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.b(str);
        }
        synchronized (this.e) {
            opt = this.d.opt(str);
        }
        return opt;
    }

    public Bundle f() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), l());
    }

    public JSONObject g() {
        JSONObject jSONObject;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a();
        }
        synchronized (this.c) {
            jSONObject = this.b;
        }
        return jSONObject;
    }

    public String getAdUnitId() {
        return b("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.i;
    }

    public long h() {
        return a("init_completion_delay_ms", -1L);
    }

    public Map i() {
        return this.f;
    }

    public String k() {
        return c().split("_")[0];
    }

    public Bundle l() {
        Bundle bundle;
        if (e("server_parameters") instanceof JSONObject) {
            f5 f5Var = this.h;
            bundle = f5Var != null ? (Bundle) f5Var.a(new Function() { // from class: com.applovin.impl.h3$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Bundle a2;
                    a2 = h3.a((f5) obj);
                    return a2;
                }
            }) : JsonUtils.toBundle(a("server_parameters", (JSONObject) null));
        } else {
            bundle = new Bundle();
        }
        int j = j();
        if (j != -1) {
            if (j == 2) {
                bundle.putBoolean("is_muted", this.f476a.o0().isMuted());
            } else {
                bundle.putBoolean("is_muted", j == 0);
            }
        }
        if (!bundle.containsKey("amount")) {
            bundle.putLong("amount", b("amount", 0L));
        }
        if (!bundle.containsKey("currency")) {
            bundle.putString("currency", b("currency", ""));
        }
        return bundle;
    }

    public long m() {
        return a("adapter_timeout_ms", ((Long) this.f476a.a(o3.o7)).longValue());
    }

    public Boolean n() {
        String str = this.f476a.o0().getExtraParameters().get("huc");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c("huc") ? a("huc", Boolean.FALSE) : b("huc", (Boolean) null);
    }

    public Boolean o() {
        String str = this.f476a.o0().getExtraParameters().get("dns");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c("dns") ? a("dns", Boolean.FALSE) : b("dns", (Boolean) null);
    }

    public boolean p() {
        return a("is_testing", Boolean.FALSE).booleanValue();
    }

    public boolean q() {
        return a("reinitialize_if_init_fails", Boolean.FALSE).booleanValue();
    }

    public boolean r() {
        return a("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    public boolean s() {
        return a("eagerly_initialize", Boolean.TRUE).booleanValue();
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + b() + "', adapterName='" + c() + "', isTesting=" + p() + AbstractJsonLexerKt.END_OBJ;
    }

    public void f(String str) {
        this.j = str;
    }

    protected Boolean a(String str, Boolean bool) {
        Boolean bool2;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, bool);
        }
        synchronized (this.e) {
            bool2 = JsonUtils.getBoolean(this.d, str, bool);
        }
        return bool2;
    }

    protected int b(String str, int i) {
        int i2;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a(str, i);
        }
        synchronized (this.c) {
            i2 = JsonUtils.getInt(this.b, str, i);
        }
        return i2;
    }

    protected void c(String str, int i) {
        f5 f5Var = this.h;
        if (f5Var != null) {
            f5Var.b(str, i);
            return;
        }
        synchronized (this.e) {
            JsonUtils.putInt(this.d, str, i);
        }
    }

    public String d() {
        if (c("consent_string")) {
            return a("consent_string", (String) null);
        }
        if (d("consent_string")) {
            return b("consent_string", (String) null);
        }
        return this.f476a.s0().j();
    }

    public String e() {
        return this.j;
    }

    public void g(String str) {
        this.i = str;
    }

    protected float a(String str, float f) {
        float f2;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, f);
        }
        synchronized (this.e) {
            f2 = JsonUtils.getFloat(this.d, str, f);
        }
        return f2;
    }

    protected JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a(str, jSONArray);
        }
        synchronized (this.c) {
            jSONArray2 = JsonUtils.getJSONArray(this.b, str, jSONArray);
        }
        return jSONArray2;
    }

    protected void c(String str, long j) {
        f5 f5Var = this.h;
        if (f5Var != null) {
            f5Var.b(str, j);
            return;
        }
        synchronized (this.e) {
            JsonUtils.putLong(this.d, str, j);
        }
    }

    protected int a(String str, int i) {
        int i2;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, i);
        }
        synchronized (this.e) {
            i2 = JsonUtils.getInt(this.d, str, i);
        }
        return i2;
    }

    protected long b(String str, long j) {
        long j2;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a(str, j);
        }
        synchronized (this.c) {
            j2 = JsonUtils.getLong(this.b, str, j);
        }
        return j2;
    }

    protected void c(String str, String str2) {
        f5 f5Var = this.h;
        if (f5Var != null) {
            f5Var.b(str, str2);
            return;
        }
        synchronized (this.e) {
            JsonUtils.putString(this.d, str, str2);
        }
    }

    protected JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, jSONArray);
        }
        synchronized (this.e) {
            jSONArray2 = JsonUtils.getJSONArray(this.d, str, jSONArray);
        }
        return jSONArray2;
    }

    protected String b(String str, String str2) {
        String string;
        f5 f5Var = this.g;
        if (f5Var != null) {
            return f5Var.a(str, str2);
        }
        synchronized (this.c) {
            string = JsonUtils.getString(this.b, str, str2);
        }
        return string;
    }

    public String c() {
        return a("name", (String) null);
    }

    protected JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, jSONObject);
        }
        synchronized (this.e) {
            jSONObject2 = JsonUtils.getJSONObject(this.d, str, jSONObject);
        }
        return jSONObject2;
    }

    public String b() {
        return a("class", (String) null);
    }

    public List b(String str) {
        List optList;
        List optList2;
        if (str != null) {
            f5 f5Var = this.g;
            if (f5Var != null) {
                optList = f5Var.b(str, Collections.emptyList());
            } else {
                optList = JsonUtils.optList(b(str, new JSONArray()), Collections.emptyList());
            }
            f5 f5Var2 = this.h;
            if (f5Var2 != null) {
                optList2 = f5Var2.b(str, Collections.emptyList());
            } else {
                optList2 = JsonUtils.optList(a(str, new JSONArray()), Collections.emptyList());
            }
            ArrayList arrayList = new ArrayList(optList.size() + optList2.size());
            arrayList.addAll(optList);
            arrayList.addAll(optList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    protected long a(String str, long j) {
        long j2;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, j);
        }
        synchronized (this.e) {
            j2 = JsonUtils.getLong(this.d, str, j);
        }
        return j2;
    }

    protected String a(String str, String str2) {
        String string;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return f5Var.a(str, str2);
        }
        synchronized (this.e) {
            string = JsonUtils.getString(this.d, str, str2);
        }
        return string;
    }

    protected void a(String str, Object obj) {
        f5 f5Var = this.h;
        if (f5Var != null) {
            f5Var.a(str, obj);
            return;
        }
        synchronized (this.e) {
            JsonUtils.putObject(this.d, str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle a(f5 f5Var) {
        return JsonUtils.toBundle(f5Var.a("server_parameters", (JSONObject) null));
    }

    public String a(String str) {
        String a2 = a(str, "");
        return StringUtils.isValidString(a2) ? a2 : b(str, "");
    }
}
