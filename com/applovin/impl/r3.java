package com.applovin.impl;

import com.applovin.impl.p3;
import com.applovin.impl.q3;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class r3 {
    private static final HashMap d = new HashMap();
    private static final Object e = new Object();
    private static final HashMap f = new HashMap();
    private static final Object g = new Object();
    private static final HashMap h = new LinkedHashMap();
    private static final Object i = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f644a;
    private final JSONObject b = a(o3.h8);
    private final JSONObject c = a(o3.g8);

    public r3(com.applovin.impl.sdk.k kVar) {
        this.f644a = kVar;
        a((String) y4.a(x4.J, (Object) null, com.applovin.impl.sdk.k.o()), q3.a.AD_UNIT_ID);
        a((String) y4.a(x4.K, (Object) null, com.applovin.impl.sdk.k.o()), q3.a.AD_FORMAT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l, Long l2) {
        return l;
    }

    private JSONObject a(v4 v4Var) {
        return JsonUtils.jsonObjectFromJsonString((String) this.f644a.a(v4Var), new JSONObject());
    }

    private Map b(p3 p3Var, q3 q3Var, p3.b bVar) {
        if (!a(p3Var, q3Var, bVar) || !b(p3Var, q3Var)) {
            return null;
        }
        String b = q3Var.b();
        HashMap a2 = a(q3Var.a());
        Object b2 = b(q3Var.a());
        HashMap hashMap = new HashMap();
        synchronized (b2) {
            if (q3Var instanceof n3) {
                a((n3) q3Var, a2);
            }
            HashMap hashMap2 = (HashMap) a2.get(b);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
                a2.put(b, hashMap2);
            }
            Iterator it = p3Var.b().iterator();
            while (it.hasNext()) {
                String b3 = ((p3.a) it.next()).b();
                HashMap hashMap3 = (HashMap) hashMap2.get(b3);
                if (hashMap3 == null) {
                    hashMap3 = new HashMap();
                    hashMap2.put(b3, hashMap3);
                }
                Object a3 = bVar.a(hashMap3.get(p3Var));
                hashMap3.put(p3Var, a3);
                hashMap.put(b3, a3);
            }
        }
        Boolean bool = (Boolean) this.f644a.a(o3.j8);
        if (p3Var.a(p3.a.INSTALL) && bool.booleanValue()) {
            b(q3Var);
        }
        return hashMap;
    }

    private x4 c(q3.a aVar) {
        if (aVar == q3.a.AD_UNIT_ID) {
            return x4.J;
        }
        if (aVar == q3.a.AD_FORMAT) {
            return x4.K;
        }
        return null;
    }

    public Map a(p3 p3Var, q3 q3Var) {
        return b(p3Var, q3Var, new p3.b() { // from class: com.applovin.impl.r3$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.p3.b
            public final Object a(Object obj) {
                Long a2;
                a2 = r3.a((Long) obj);
                return a2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l) {
        return Long.valueOf(l != null ? 1 + l.longValue() : 1L);
    }

    public void a(p3 p3Var, q3 q3Var, final Long l) {
        b(p3Var, q3Var, new p3.b() { // from class: com.applovin.impl.r3$$ExternalSyntheticLambda1
            @Override // com.applovin.impl.p3.b
            public final Object a(Object obj) {
                Long a2;
                a2 = r3.a(l, (Long) obj);
                return a2;
            }
        });
    }

    public Map a(p3 p3Var, q3.a aVar) {
        return a(p3Var, aVar, p3.a.SESSION);
    }

    private Map a(p3 p3Var, q3.a aVar, p3.a aVar2) {
        HashMap a2 = a(aVar);
        Object b = b(aVar);
        HashMap hashMap = new HashMap();
        synchronized (b) {
            for (String str : a2.keySet()) {
                HashMap hashMap2 = (HashMap) a2.get(str);
                String b2 = aVar2.b();
                if (hashMap2 != null && hashMap2.containsKey(b2)) {
                    HashMap hashMap3 = (HashMap) hashMap2.get(b2);
                    if (aVar == q3.a.AD) {
                        hashMap.put(g3.a(str).b(), hashMap3.get(p3Var));
                    } else {
                        hashMap.put(str, hashMap3.get(p3Var));
                    }
                }
            }
        }
        return hashMap;
    }

    private void a(n3 n3Var, Map map) {
        MaxAdFormat a2 = n3Var.c().a();
        Integer integer = JsonUtils.getInteger(this.c, a2.getLabel(), null);
        if (integer == null) {
            return;
        }
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (g3.a((String) it.next()).a().equals(a2)) {
                i2++;
            }
        }
        if (i2 < integer.intValue()) {
            return;
        }
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext() && i2 >= integer.intValue()) {
            if (g3.a((String) ((Map.Entry) it2.next()).getKey()).a().equals(a2)) {
                it2.remove();
                i2--;
            }
        }
    }

    private Object b(q3.a aVar) {
        if (aVar == q3.a.AD_UNIT_ID) {
            return e;
        }
        if (aVar == q3.a.AD_FORMAT) {
            return g;
        }
        return i;
    }

    private boolean b(p3 p3Var, q3 q3Var) {
        Iterator<String> keys = this.b.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equals(q3Var.a().toString().toLowerCase()) && JsonUtils.valueExists(JsonUtils.getJSONArray(this.b, next, new JSONArray()), p3Var.a())) {
                return false;
            }
        }
        return true;
    }

    private HashMap a(q3.a aVar) {
        if (aVar == q3.a.AD_UNIT_ID) {
            return d;
        }
        if (aVar == q3.a.AD_FORMAT) {
            return f;
        }
        return h;
    }

    private void b(q3 q3Var) {
        x4 c = c(q3Var.a());
        if (c == null) {
            return;
        }
        y4.b(c, a((Map) a(q3Var)), com.applovin.impl.sdk.k.o());
    }

    private boolean a(p3 p3Var, q3 q3Var, p3.b bVar) {
        if (p3Var == null) {
            this.f644a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f644a.O().b("MediationStatsManager", "Failed to update stat, no stat provided");
            }
            return false;
        }
        if (q3Var == null) {
            this.f644a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f644a.O().b("MediationStatsManager", "Failed to update stat, no dimension key provided");
            }
            return false;
        }
        if (bVar != null) {
            return true;
        }
        this.f644a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f644a.O().b("MediationStatsManager", "Failed to update stat, no stat updater provided");
        }
        return false;
    }

    private HashMap a(q3 q3Var) {
        HashMap hashMap = new HashMap();
        HashMap a2 = a(q3Var.a());
        synchronized (b(q3Var.a())) {
            for (Map.Entry entry : a2.entrySet()) {
                String str = (String) entry.getKey();
                HashMap hashMap2 = (HashMap) entry.getValue();
                if (!CollectionUtils.isEmpty(hashMap2)) {
                    HashMap hashMap3 = (HashMap) hashMap2.get(p3.a.INSTALL.b());
                    if (!CollectionUtils.isEmpty(hashMap3)) {
                        hashMap.put(str, new HashMap(hashMap3));
                    }
                }
            }
        }
        return hashMap;
    }

    private String a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                p3 p3Var = (p3) entry2.getKey();
                Object value = entry2.getValue();
                if (value != null) {
                    JsonUtils.putObject(jSONObject2, p3Var.toString(), value);
                }
            }
            JsonUtils.putJSONObject(jSONObject, (String) entry.getKey(), jSONObject2);
        }
        return jSONObject.toString();
    }

    private void a(String str, q3.a aVar) {
        if (StringUtils.isValidString(str)) {
            HashMap a2 = a(aVar);
            Object b = b(aVar);
            Map<String, Object> stringObjectMap = JsonUtils.toStringObjectMap(str);
            synchronized (b) {
                for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()) {
                    String key = entry.getKey();
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        p3 a3 = p3.a((String) entry2.getKey());
                        if (a3 != null) {
                            hashMap.put(a3, a(entry2.getValue()));
                        }
                    }
                    if (!CollectionUtils.isEmpty(hashMap)) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(p3.a.INSTALL.b(), hashMap);
                        a2.put(key, hashMap2);
                    }
                }
            }
        }
    }

    private Object a(Object obj) {
        return obj instanceof Integer ? Long.valueOf(((Integer) obj).longValue()) : obj;
    }
}
