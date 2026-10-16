package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.util.IAlog;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class f implements com.fyber.inneractive.sdk.cache.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1082a = false;

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String a() {
        String str = IAConfigManager.O.c;
        StringBuilder sb = new StringBuilder("https://");
        int i = k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.baseConfigUrl");
        if (TextUtils.isEmpty(property)) {
            sb.append("cdn2.inner-active.mobi/ia-sdk-config/apps/");
        } else {
            sb.append(property);
        }
        String sb2 = sb.append(str).append('/').append(str).append(".json").toString();
        IAlog.d("%s: %s", "APP_CONFIG_REQUEST", sb2);
        return sb2;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String b() {
        return "IALastModifiedFromHeader";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String c() {
        return "inneractive.config";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final boolean d() {
        String string = com.fyber.inneractive.sdk.util.o.f1770a.getSharedPreferences("IAConfigurationPreferences", 0).getString("cached.config.appid", null);
        return string != null && string.equalsIgnoreCase(IAConfigManager.O.c);
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final void a(Object obj) {
        h0 h0Var = (h0) obj;
        if (h0Var == null || h0Var.f1099a == null) {
            return;
        }
        com.fyber.inneractive.sdk.util.o.f1770a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("cached.config.appid", h0Var.f1099a).apply();
    }

    public final void a(String str, Throwable th) {
        String str2;
        String str3;
        String str4;
        if (this.f1082a) {
            return;
        }
        this.f1082a = true;
        if (TextUtils.isEmpty(str)) {
            str2 = "Empty Json Data";
        } else {
            str2 = str.length() > 501 ? str.substring(0, 500) : str.substring(0, str.length() - 1);
        }
        String str5 = str2;
        if (th != null) {
            str3 = th.getClass().getName();
            str4 = th.getLocalizedMessage();
        } else {
            str3 = "Bad remote configuration";
            str4 = UnityAdsConstants.Messages.MSG_INTERNAL_ERROR;
        }
        String str6 = str3;
        String str7 = IAConfigManager.O.c;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(com.fyber.inneractive.sdk.network.t.FATAL_CONFIGURATION_ERROR);
        if (str4 == null) {
            str4 = "No message";
        }
        String str8 = str4;
        if (TextUtils.isEmpty(str7)) {
            str7 = "EMPTY_APP_ID";
        }
        wVar.a("exception", str6, PglCryptUtils.KEY_MESSAGE, str8, "data", str5, "appId", str7).a((String) null);
    }

    public static h0 a(com.fyber.inneractive.sdk.config.remote.e eVar) {
        boolean z;
        h0 h0Var;
        Iterator it;
        HashMap hashMap;
        Iterator it2;
        boolean z2;
        ArrayList arrayList;
        UnitDisplayType unitDisplayType;
        Integer num;
        Boolean bool;
        UnitDisplayType unitDisplayType2;
        String b;
        com.fyber.inneractive.sdk.config.remote.e eVar2 = eVar;
        h0 h0Var2 = new h0();
        h0Var2.c = eVar2.c;
        com.fyber.inneractive.sdk.config.remote.a aVar = eVar2.f1117a;
        h0Var2.b = aVar.b;
        h0Var2.f1099a = aVar.f1115a;
        Iterator it3 = eVar2.b.iterator();
        while (it3.hasNext()) {
            com.fyber.inneractive.sdk.config.remote.h hVar = (com.fyber.inneractive.sdk.config.remote.h) it3.next();
            HashMap hashMap2 = h0Var2.d;
            String str = hVar.f1120a;
            com.fyber.inneractive.sdk.config.remote.a aVar2 = eVar2.f1117a;
            HashMap hashMap3 = h0Var2.e;
            j0 j0Var = h0Var2.f;
            q0 q0Var = new q0();
            int i = 2;
            int i2 = 0;
            com.fyber.inneractive.sdk.config.remote.c[] cVarArr = {aVar2, hVar};
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    z = true;
                    break;
                }
                com.fyber.inneractive.sdk.config.remote.c cVar = cVarArr[i3];
                if (cVar != null && (b = cVar.b()) != null && b.equals("false")) {
                    z = false;
                    break;
                }
                i3++;
                i = 2;
            }
            q0Var.b = z;
            Iterator it4 = hVar.g.iterator();
            while (it4.hasNext()) {
                com.fyber.inneractive.sdk.config.remote.i iVar = (com.fyber.inneractive.sdk.config.remote.i) it4.next();
                r0 r0Var = new r0();
                String str2 = iVar.f1121a;
                if (str2 != null) {
                    int i4 = i2;
                    String str3 = iVar.b;
                    if (str3 == null) {
                        i2 = i4;
                    } else {
                        r0Var.f1114a = str2;
                        r0Var.b = str3;
                        com.fyber.inneractive.sdk.config.remote.g gVar = iVar.e;
                        if (gVar != null) {
                            p0 p0Var = new p0();
                            UnitDisplayType unitDisplayType3 = gVar.f1119a;
                            if (unitDisplayType3 == UnitDisplayType.DEFAULT) {
                                p0Var.f1111a = unitDisplayType3;
                                r0Var.e = p0Var;
                            } else {
                                i2 = i4;
                            }
                        }
                        com.fyber.inneractive.sdk.config.remote.b bVar = iVar.c;
                        if (bVar != null) {
                            com.fyber.inneractive.sdk.config.remote.b bVar2 = hVar.c;
                            com.fyber.inneractive.sdk.config.remote.b bVar3 = aVar2.e;
                            l0 l0Var = new l0();
                            h0Var = h0Var2;
                            UnitDisplayType unitDisplayType4 = bVar.f1116a;
                            it = it3;
                            if (unitDisplayType4 == UnitDisplayType.BANNER || unitDisplayType4 == UnitDisplayType.MRECT || unitDisplayType4.isFullscreenUnit()) {
                                l0Var.b = bVar.f1116a;
                                Integer num2 = bVar.c;
                                Integer num3 = bVar2 != null ? bVar2.c : null;
                                if (bVar3 != null) {
                                    it2 = it4;
                                    num = bVar3.c;
                                } else {
                                    it2 = it4;
                                    num = null;
                                }
                                Integer num4 = (Integer) a((Object) null, num2, num3, num);
                                if (num4 != null && num4.intValue() >= 5 && num4.intValue() <= 60) {
                                    l0Var.f1105a = num4;
                                }
                                Boolean bool2 = Boolean.TRUE;
                                Boolean bool3 = bVar.b;
                                Boolean bool4 = bVar2 != null ? bVar2.b : null;
                                if (bVar3 != null) {
                                    hashMap = hashMap2;
                                    bool = bVar3.b;
                                } else {
                                    hashMap = hashMap2;
                                    bool = null;
                                }
                                Boolean bool5 = (Boolean) a(bool2, bool3, bool4, bool);
                                bool5.getClass();
                                l0Var.c = bool5;
                                Integer num5 = (Integer) a((Object) null, bVar.d, bVar2 != null ? bVar2.d : null, bVar3 != null ? bVar3.d : null);
                                if (num5 != null && num5.intValue() >= 5 && num5.intValue() <= 60) {
                                    l0Var.d = num5;
                                }
                                if (l0Var.d == null && !l0Var.c.booleanValue() && ((unitDisplayType2 = bVar.f1116a) == UnitDisplayType.INTERSTITIAL || unitDisplayType2 == UnitDisplayType.REWARDED)) {
                                    l0Var.c = bool2;
                                }
                                r0Var.c = l0Var;
                            } else {
                                i2 = i4;
                                h0Var2 = h0Var;
                                it3 = it;
                            }
                        } else {
                            h0Var = h0Var2;
                            it = it3;
                            hashMap = hashMap2;
                            it2 = it4;
                        }
                        com.fyber.inneractive.sdk.config.remote.j jVar = iVar.f;
                        if (jVar != null) {
                            UnitDisplayType unitDisplayType5 = jVar.j;
                            UnitDisplayType unitDisplayType6 = UnitDisplayType.REWARDED;
                            if (unitDisplayType5 == unitDisplayType6 && iVar.c == null) {
                                l0 l0Var2 = new l0();
                                r0Var.c = l0Var2;
                                l0Var2.c = Boolean.FALSE;
                                l0Var2.d = -1;
                                l0 l0Var3 = r0Var.c;
                                l0Var3.b = unitDisplayType6;
                                l0Var3.f1105a = -1;
                            }
                            t0 t0Var = new t0();
                            com.fyber.inneractive.sdk.config.remote.j jVar2 = iVar.f;
                            com.fyber.inneractive.sdk.config.remote.j jVar3 = hVar.e;
                            com.fyber.inneractive.sdk.config.remote.j jVar4 = aVar2.d;
                            UnitDisplayType unitDisplayType7 = jVar2.j;
                            if (unitDisplayType7 != UnitDisplayType.LANDSCAPE && unitDisplayType7 != UnitDisplayType.SQUARE && unitDisplayType7 != (unitDisplayType = UnitDisplayType.INTERSTITIAL) && unitDisplayType7 != UnitDisplayType.VERTICAL && unitDisplayType7 != unitDisplayType6 && unitDisplayType7 != UnitDisplayType.MRECT) {
                                if (r0Var.e != null) {
                                    t0Var.j = unitDisplayType;
                                } else {
                                    i2 = i4;
                                    h0Var2 = h0Var;
                                    it3 = it;
                                    it4 = it2;
                                    hashMap2 = hashMap;
                                }
                            } else {
                                t0Var.j = unitDisplayType7;
                            }
                            Object a2 = a((Object) null, jVar2.f1122a, jVar3 != null ? jVar3.f1122a : null, jVar4 != null ? jVar4.f1122a : null);
                            if (a2 != null) {
                                t0Var.f1126a = (Boolean) a2;
                                t0Var.b = (Integer) a((Object) 5000, jVar2.b, jVar3 != null ? jVar3.b : null, jVar4 != null ? jVar4.b : null);
                                Integer num6 = (Integer) a(Integer.valueOf(i4), jVar2.c, jVar3 != null ? jVar3.c : null, jVar4 != null ? jVar4.c : null);
                                t0Var.c = Integer.valueOf(num6.intValue() < 0 ? i4 : num6.intValue());
                                t0Var.d = (Boolean) a(Boolean.TRUE, jVar2.e, jVar3 != null ? jVar3.e : null, jVar4 != null ? jVar4.e : null);
                                t0Var.e = (Orientation) a(Orientation.USER, jVar2.g, jVar3 != null ? jVar3.g : null, jVar4 != null ? jVar4.g : null);
                                Integer num7 = (Integer) a(Integer.valueOf(i4), jVar2.i, jVar3 != null ? jVar3.i : null, jVar4 != null ? jVar4.i : null);
                                t0Var.f = Integer.valueOf(num7.intValue() < 0 ? i4 : num7.intValue());
                                Integer num8 = (Integer) a((Object) 2048, jVar2.h, jVar3 != null ? jVar3.h : null, jVar4 != null ? jVar4.h : null);
                                if (num8.intValue() > t0Var.b.intValue()) {
                                    num8 = t0Var.b;
                                }
                                t0Var.g = num8;
                                t0Var.h = (Skip) a(Skip._0, jVar2.d, jVar3 != null ? jVar3.d : null, jVar4 != null ? jVar4.d : null);
                                t0Var.i = (TapAction) a(TapAction.DO_NOTHING, jVar2.f, jVar3 != null ? jVar3.f : null, jVar4 != null ? jVar4.f : null);
                                ArrayList arrayList2 = new ArrayList();
                                com.fyber.inneractive.sdk.config.remote.d[] dVarArr = new com.fyber.inneractive.sdk.config.remote.d[1];
                                dVarArr[i4] = iVar;
                                com.fyber.inneractive.sdk.config.remote.j a3 = dVarArr[i4].a();
                                if (a3 != null && (arrayList = a3.k) != null && arrayList.size() > 0) {
                                    arrayList2 = a3.k;
                                }
                                t0Var.k = arrayList2;
                                r0Var.f = t0Var;
                            } else {
                                i2 = i4;
                                h0Var2 = h0Var;
                                it3 = it;
                                it4 = it2;
                                hashMap2 = hashMap;
                            }
                        }
                        o0 o0Var = new o0();
                        HashSet hashSet = new HashSet();
                        com.fyber.inneractive.sdk.config.remote.f fVar = iVar.d;
                        Set set = fVar != null ? fVar.f1118a : null;
                        com.fyber.inneractive.sdk.config.remote.f fVar2 = hVar.d;
                        Set set2 = fVar2 != null ? fVar2.f1118a : null;
                        com.fyber.inneractive.sdk.config.remote.f fVar3 = aVar2.c;
                        o0Var.f1109a = (Set) a(hashSet, set, set2, fVar3 != null ? fVar3.f1118a : null);
                        r0Var.d = o0Var;
                        u0 u0Var = new u0();
                        com.fyber.inneractive.sdk.config.remote.k kVar = iVar.g;
                        com.fyber.inneractive.sdk.config.remote.k kVar2 = hVar.f;
                        com.fyber.inneractive.sdk.config.remote.k kVar3 = aVar2.f;
                        Integer num9 = (Integer) a((Object) 1, kVar != null ? kVar.f1123a : null, kVar2 != null ? kVar2.f1123a : null, kVar3 != null ? kVar3.f1123a : null);
                        if (num9.intValue() <= 0 && num9.intValue() > 100) {
                            z2 = true;
                            u0Var.f1128a = 1;
                        } else {
                            z2 = true;
                            u0Var.f1128a = num9;
                        }
                        Integer num10 = (Integer) a(Integer.valueOf(i4), kVar != null ? kVar.b : null, kVar2 != null ? kVar2.b : null, kVar3 != null ? kVar3.b : null);
                        if (num10.intValue() < 0 && num10.intValue() > 100) {
                            u0Var.b = Integer.valueOf(i4);
                        } else {
                            u0Var.b = num10;
                        }
                        Set<Vendor> set3 = (Set) a(new HashSet(), kVar != null ? kVar.c : null, kVar2 != null ? kVar2.c : null, kVar3 != null ? kVar3.c : null);
                        u0Var.c = set3;
                        r0Var.g = u0Var;
                        if (j0Var != null && set3 != null) {
                            for (Vendor vendor : set3) {
                                if (vendor != null && !j0Var.f1101a.contains(vendor)) {
                                    j0Var.f1101a.add(vendor);
                                }
                            }
                        }
                        q0Var.f1113a.add(r0Var);
                        hashMap3.put(r0Var.f1114a, r0Var);
                        i2 = i4;
                        h0Var2 = h0Var;
                        it3 = it;
                        it4 = it2;
                        hashMap2 = hashMap;
                    }
                }
            }
            hashMap2.put(str, q0Var);
            eVar2 = eVar;
        }
        return h0Var2;
    }

    public static Object a(Object obj, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final Object a(String str) {
        try {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.D.f();
            com.fyber.inneractive.sdk.config.remote.e a2 = com.fyber.inneractive.sdk.config.remote.e.a(new JSONObject(str));
            String str2 = iAConfigManager.c;
            if (a2 != null && str2.equals(a2.f1117a.f1115a)) {
                return a(a2);
            }
            IAlog.b("internal error while parsing local configuration", new Object[0]);
            if (a2 != null && !str2.equals(a2.f1117a.f1115a)) {
                throw new InvalidAppIdException();
            }
            a(str, (Throwable) null);
            return null;
        } catch (Throwable th) {
            a(str, th);
            IAlog.b("Exception Error while parsing local configuration", new Object[0]);
            throw th;
        }
    }
}
