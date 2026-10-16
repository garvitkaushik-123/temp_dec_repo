package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public String f1097a = "";
    public final HashMap b;
    public JSONArray c;

    public r() {
        HashMap hashMap = new HashMap();
        hashMap.put(u.class, new u());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.d.class, new com.fyber.inneractive.sdk.config.global.features.d());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.l.class, new com.fyber.inneractive.sdk.config.global.features.l());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.f.class, new com.fyber.inneractive.sdk.config.global.features.f());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.k.class, new com.fyber.inneractive.sdk.config.global.features.k());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.e.class, new com.fyber.inneractive.sdk.config.global.features.e());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.r.class, new com.fyber.inneractive.sdk.config.global.features.r());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.i.class, new com.fyber.inneractive.sdk.config.global.features.i());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.q.class, new com.fyber.inneractive.sdk.config.global.features.q());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.n.class, new com.fyber.inneractive.sdk.config.global.features.n());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.c.class, new com.fyber.inneractive.sdk.config.global.features.c());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.m.class, new com.fyber.inneractive.sdk.config.global.features.m());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.b.class, new com.fyber.inneractive.sdk.config.global.features.b());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.g.class, new com.fyber.inneractive.sdk.config.global.features.g());
        hashMap.put(com.fyber.inneractive.sdk.config.global.features.j.class, new com.fyber.inneractive.sdk.config.global.features.j());
        this.b = hashMap;
        this.c = null;
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put((Class) entry.getKey(), ((com.fyber.inneractive.sdk.config.global.features.h) entry.getValue()).b());
        }
        this.b = hashMap2;
        IAlog.a("%s: created. Supported features: %s", "SupportedFeaturesProvider", hashMap2);
    }

    public static r a() {
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.featuresConfig");
        boolean z = false;
        if (!TextUtils.isEmpty(property)) {
            try {
                IAConfigManager.O.z.f1085a = l.a(new JSONObject(property));
                z = true;
            } catch (Exception unused) {
                IAlog.a("failed parsing local features json", new Object[0]);
            }
        }
        r rVar = new r();
        if (z) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.M.a(true, "");
            iAConfigManager.E.a(iAConfigManager.M);
        }
        return rVar;
    }

    public final JSONArray b() {
        JSONArray jSONArray = this.c;
        if (jSONArray == null || jSONArray.length() == 0) {
            JSONArray a2 = g.a(this.b, false);
            this.c = a2;
            IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", a2);
        }
        return this.c;
    }

    public final void a(e eVar) {
        for (com.fyber.inneractive.sdk.config.global.features.h hVar : this.b.values()) {
            hVar.getClass();
            ArrayList arrayList = new ArrayList(hVar.c.values());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                ArrayList arrayList2 = bVar.d;
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d dVar = (d) it.next();
                        if (dVar.a(eVar)) {
                            hVar.c.remove(bVar.f1086a);
                            hVar.d.remove(bVar.f1086a);
                            this.c = null;
                            IAlog.a("%s: Experiment %s filtered! after response %s", "SupportedFeaturesProvider", bVar.f1086a, dVar);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final com.fyber.inneractive.sdk.config.global.features.h a(Class cls) {
        if (this.b.containsKey(cls)) {
            com.fyber.inneractive.sdk.config.global.features.h hVar = (com.fyber.inneractive.sdk.config.global.features.h) this.b.get(cls);
            if (cls.isInstance(hVar)) {
                return hVar;
            }
        }
        try {
            return (com.fyber.inneractive.sdk.config.global.features.h) cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            IAlog.a("Couldn't create a feature for %s", e, cls.getName());
            return null;
        }
    }

    public final void a(boolean z, String str) {
        k kVar;
        e eVar;
        this.f1097a = str;
        a aVar = IAConfigManager.O.z;
        aVar.b = this;
        for (com.fyber.inneractive.sdk.config.global.features.h hVar : this.b.values()) {
            boolean z2 = hVar instanceof com.fyber.inneractive.sdk.config.global.features.o;
            if ((z2 && z) || (!z2 && !z)) {
                l lVar = aVar.f1085a;
                if (hVar != null && lVar != null) {
                    q qVar = (q) lVar.f1094a.get(hVar.b);
                    if (qVar != null) {
                        hVar.f1096a = qVar.f1096a;
                        IAlog.a("%s: Feature before variant merge: %s", "a", hVar);
                        HashMap hashMap = qVar.c;
                        Iterator it = hashMap.keySet().iterator();
                        while (it.hasNext()) {
                            b bVar = (b) hashMap.get((String) it.next());
                            if (bVar != null) {
                                int nextInt = new Random().nextInt(100) + 1;
                                if (bVar.b < nextInt) {
                                    IAlog.a("%s: Experiment '%s' filtered! rand: %d, with perc: %d", "a", bVar.f1086a, Integer.valueOf(nextInt), Integer.valueOf(bVar.b));
                                } else {
                                    ArrayList arrayList = bVar.d;
                                    if (arrayList != null) {
                                        Iterator it2 = arrayList.iterator();
                                        while (it2.hasNext()) {
                                            d dVar = (d) it2.next();
                                            try {
                                                Long valueOf = Long.valueOf(IAConfigManager.O.d);
                                                eVar = new e();
                                                eVar.b = valueOf;
                                                eVar.c = com.fyber.inneractive.sdk.serverapi.b.a(aVar.b.f1097a);
                                            } catch (NumberFormatException unused) {
                                                IAlog.a("%s: invalid publisherId", "a");
                                            }
                                            if (dVar.a(eVar)) {
                                                IAlog.a("%s: Experiment '%s' filtered! with %s", "a", bVar.f1086a, dVar);
                                                break;
                                            }
                                        }
                                    }
                                    int i = 0;
                                    if (hVar instanceof u) {
                                        Iterator it3 = bVar.c.iterator();
                                        while (it3.hasNext()) {
                                            k kVar2 = (k) it3.next();
                                            n nVar = kVar2.f1096a;
                                            if (nVar != null && nVar.a() != null && kVar2.f1096a.a().containsKey("use_fmp_cache_mechanism")) {
                                                com.fyber.inneractive.sdk.util.u uVar = (com.fyber.inneractive.sdk.util.u) IAConfigManager.O.J.get(v.Video);
                                                if (!(uVar != null ? uVar.a() : false)) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    IAlog.a("%s: Experiment '%s' NOT filtered! rand: %d, with perc: %d", "a", bVar.f1086a, Integer.valueOf(nextInt), Integer.valueOf(bVar.b));
                                    ArrayList arrayList2 = bVar.c;
                                    int nextInt2 = new Random().nextInt(100) + 1;
                                    IAlog.a("%s: selectVariant for experiment '%s' generated random number: %d", "a", bVar.f1086a, Integer.valueOf(nextInt2));
                                    Iterator it4 = arrayList2.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            kVar = null;
                                            break;
                                        }
                                        kVar = (k) it4.next();
                                        i += kVar.c;
                                        IAlog.a("%s: selectVariant variant found: %s", "a", kVar);
                                        if (i >= nextInt2) {
                                            break;
                                        } else {
                                            IAlog.a("%s: selectVariant variant '%s' percentage outside selected range", "a", kVar.b);
                                        }
                                    }
                                    if (kVar != null) {
                                        IAlog.a("%s: experiment '%s' variant selected! %s", "a", bVar.f1086a, kVar);
                                    } else {
                                        IAlog.a("%s: experiment '%s' no variant was selected! using control group", "a", bVar.f1086a);
                                    }
                                    hVar.c.put(bVar.f1086a, bVar);
                                    if (kVar != null) {
                                        hVar.d.put(bVar.f1086a, kVar);
                                    }
                                }
                            }
                        }
                    }
                    IAlog.a("%s: Feature after variant merge: %s", "a", hVar);
                }
            }
        }
    }
}
