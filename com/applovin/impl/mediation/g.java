package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.h3;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v2;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g {
    private final k b;
    private final o c;

    /* renamed from: a, reason: collision with root package name */
    private final Map f589a = Collections.synchronizedMap(new HashMap(16));
    private final Object d = new Object();
    private final Map e = new HashMap();
    private final Set f = new HashSet();
    private final Object g = new Object();
    private final Set h = new HashSet();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f590a;
        private final String b;
        private final MaxAdFormat c;
        private final JSONObject d;

        a(String str, String str2, v2 v2Var, k kVar) {
            this.f590a = str;
            this.b = str2;
            JSONObject jSONObject = new JSONObject();
            this.d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (v2Var == null) {
                this.c = null;
            } else {
                this.c = v2Var.getFormat();
                JsonUtils.putString(jSONObject, "format", v2Var.getFormat().getLabel());
            }
        }

        JSONObject a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f590a.equals(aVar.f590a) || !this.b.equals(aVar.b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.c;
            MaxAdFormat maxAdFormat2 = aVar.c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int hashCode = ((this.f590a.hashCode() * 31) + this.b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.c;
            return hashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f590a + "', operationTag='" + this.b + "', format=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public g(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.b = kVar;
        this.c = kVar.O();
    }

    public Collection a() {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList(this.h.size());
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                arrayList.add(((a) it.next()).a());
            }
        }
        return arrayList;
    }

    public Collection b() {
        Set unmodifiableSet;
        synchronized (this.d) {
            unmodifiableSet = Collections.unmodifiableSet(this.f);
        }
        return unmodifiableSet;
    }

    public Collection c() {
        Set unmodifiableSet;
        synchronized (this.d) {
            HashSet hashSet = new HashSet(this.e.size());
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                hashSet.add(((Class) it.next()).getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    h a(h3 h3Var) {
        return a(h3Var, false);
    }

    h a(h3 h3Var, boolean z) {
        Class cls;
        h hVar;
        if (h3Var != null) {
            String c = h3Var.c();
            String b = h3Var.b();
            if (TextUtils.isEmpty(c)) {
                if (o.a()) {
                    this.c.b("MediationAdapterManager", "No adapter name provided for " + b + ", not loading the adapter ");
                }
                return null;
            }
            if (TextUtils.isEmpty(b)) {
                if (o.a()) {
                    this.c.b("MediationAdapterManager", "Unable to find default className for '" + c + "'");
                }
                return null;
            }
            if (z && (hVar = (h) this.f589a.get(b)) != null) {
                return hVar;
            }
            synchronized (this.d) {
                if (!this.f.contains(b)) {
                    if (this.e.containsKey(b)) {
                        cls = (Class) this.e.get(b);
                    } else {
                        Class a2 = a(b);
                        if (a2 == null) {
                            if (o.a()) {
                                this.c.k("MediationAdapterManager", "Adapter " + c + " could not be loaded, class " + b + " not found");
                            }
                            this.f.add(b);
                            return null;
                        }
                        cls = a2;
                    }
                    h a3 = a(h3Var, cls, z);
                    if (a3 != null) {
                        if (o.a()) {
                            this.c.a("MediationAdapterManager", "Loaded " + c);
                        }
                        this.e.put(b, cls);
                        if (z) {
                            this.f589a.put(h3Var.b(), a3);
                        }
                        return a3;
                    }
                    if (o.a()) {
                        this.c.b("MediationAdapterManager", "Failed to load " + c);
                    }
                    this.f.add(b);
                    return null;
                }
                if (o.a()) {
                    this.c.a("MediationAdapterManager", "Not attempting to load " + c + " due to prior errors");
                }
                return null;
            }
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    public void a(String str, String str2, v2 v2Var) {
        synchronized (this.g) {
            this.b.O();
            if (o.a()) {
                this.b.O().b("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.h.add(new a(str, str2, v2Var, this.b));
        }
    }

    private h a(h3 h3Var, Class cls, boolean z) {
        try {
            return new h(h3Var, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.b.z0()), z, this.b);
        } catch (Throwable th) {
            o.c("MediationAdapterManager", "Failed to load adapter: " + h3Var, th);
            return null;
        }
    }

    private Class a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            o.h("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
