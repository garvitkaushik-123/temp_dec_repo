package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.model.vast.a0;
import com.fyber.inneractive.sdk.model.vast.k;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.model.vast.m;
import com.fyber.inneractive.sdk.model.vast.q;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.s;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.model.vast.w;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.player.n;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import com.fyber.inneractive.sdk.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f1245a = -1;
    public int b = -1;
    public int c = -1;
    public boolean d = false;
    public boolean e = false;
    public final LinkedHashMap f = new LinkedHashMap();
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final ArrayList j = new ArrayList();

    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.h hVar, int i) {
        com.fyber.inneractive.sdk.model.vast.b bVar2;
        ArrayList arrayList = hVar.h;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!f0.e(str)) {
                    throw new b("Found non-secure click tracking url for companion. url: " + str, 0);
                }
            }
            if (i > 0) {
                this.h.add(hVar);
            }
        }
        String str2 = hVar.g;
        if (!f0.e(str2)) {
            throw new b("Found non-secure click through url: " + str2, 0);
        }
        if (!hVar.a()) {
            if (this.i.contains(hVar)) {
                return;
            }
            this.i.add(hVar);
            return;
        }
        Integer num = hVar.f1286a;
        Integer num2 = hVar.b;
        if (num == null || num2 == null || num.intValue() < 100 || num2.intValue() < 100) {
            throw new b("Incompatible size: " + num + "," + num2, 16);
        }
        ArrayList arrayList2 = hVar.j;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            w wVar = (w) it2.next();
            if (!f0.e(wVar.b)) {
                throw new b("Found non-secure tracking event: " + wVar, 0);
            }
        }
        String str3 = hVar.c;
        l lVar = hVar.d;
        if (lVar != null) {
            k a2 = k.a(lVar.f1288a);
            if (a2 == null) {
                throw new b("Found invalid creative type: " + lVar.f1288a, 32);
            }
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Static, i, num.intValue(), num2.intValue(), str3, str2, arrayList, arrayList2, lVar.b, a2);
        }
        String str4 = hVar.e;
        if (!TextUtils.isEmpty(str4)) {
            if (!f0.e(str4)) {
                throw new b("Found non-secure iframe url: " + str4, 0);
            }
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Iframe, i, num.intValue(), num2.intValue(), str3, str2, arrayList, arrayList2, str4, null);
        }
        String str5 = hVar.f;
        if (TextUtils.isEmpty(str5)) {
            bVar2 = bVar;
        } else {
            bVar2 = bVar;
            a(bVar2, com.fyber.inneractive.sdk.model.vast.i.Html, i, num.intValue(), num2.intValue(), str3, str2, arrayList, arrayList2, str5, null);
        }
        bVar2.g.size();
    }

    public final com.fyber.inneractive.sdk.model.vast.b a(com.fyber.inneractive.sdk.model.vast.f fVar, List list, String str) {
        int e = o.e();
        int d = o.d();
        IAlog.a("%sprocess started", "VastProcessor: ");
        if (fVar != null && fVar.c != null) {
            com.fyber.inneractive.sdk.model.vast.b bVar = new com.fyber.inneractive.sdk.model.vast.b(new g(this.c, e, d), new d(e, d));
            bVar.f1281a = str;
            ArrayList arrayList = fVar.c.c;
            if (arrayList != null) {
                List list2 = list;
                if (!arrayList.isEmpty()) {
                    if (list == null) {
                        list2 = list;
                        if (fVar.b != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(fVar);
                            list2 = arrayList2;
                        }
                    }
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            a0 a0Var = ((com.fyber.inneractive.sdk.model.vast.f) it.next()).b;
                            if (a0Var != null) {
                                a(bVar, a0Var);
                            }
                        }
                    }
                    a(bVar, fVar.c);
                    if (bVar.d.size() == 0) {
                        if (this.f.isEmpty()) {
                            throw new h("ErrorNoMediaFiles", "No media files exist after merge");
                        }
                        throw new h("ErrorNoCompatibleMediaFile", "No compatible media files after filtering");
                    }
                    ArrayList arrayList3 = new ArrayList(bVar.g);
                    Collections.sort(arrayList3, bVar.h);
                    if (!arrayList3.isEmpty()) {
                        Iterator it2 = this.i.iterator();
                        while (it2.hasNext()) {
                            com.fyber.inneractive.sdk.model.vast.h hVar = (com.fyber.inneractive.sdk.model.vast.h) it2.next();
                            if (!hVar.a()) {
                                Iterator it3 = arrayList3.iterator();
                                while (it3.hasNext()) {
                                    com.fyber.inneractive.sdk.model.vast.c cVar = (com.fyber.inneractive.sdk.model.vast.c) it3.next();
                                    ArrayList arrayList4 = hVar.h;
                                    if (arrayList4 != null) {
                                        Iterator it4 = arrayList4.iterator();
                                        while (it4.hasNext()) {
                                            cVar.a(x.EVENT_CLICK, (String) it4.next());
                                        }
                                    }
                                    String str2 = hVar.g;
                                    if (TextUtils.isEmpty(cVar.g)) {
                                        cVar.g = str2;
                                    }
                                    ArrayList arrayList5 = hVar.j;
                                    if (arrayList5 != null) {
                                        Iterator it5 = arrayList5.iterator();
                                        while (it5.hasNext()) {
                                            w wVar = (w) it5.next();
                                            x a2 = x.a(wVar.f1296a);
                                            String str3 = wVar.b;
                                            if (a2 != null && str3 != null) {
                                                cVar.a(a2, str3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    int i = 0;
                    if (IAlog.f1749a == 2) {
                        IAlog.e("%sLogging merged model media files: ", "VastProcessor: ");
                        Iterator it6 = new ArrayList(bVar.d).iterator();
                        int i2 = 0;
                        while (it6.hasNext()) {
                            IAlog.e("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i2), (r) it6.next());
                            i2++;
                        }
                    }
                    if (IAlog.f1749a == 2) {
                        IAlog.e("%sLogging merged model companion ads: ", "VastProcessor: ");
                        ArrayList arrayList6 = new ArrayList(bVar.g);
                        Collections.sort(arrayList6, bVar.h);
                        if (arrayList6.size() > 0) {
                            Iterator it7 = arrayList6.iterator();
                            while (it7.hasNext()) {
                                IAlog.e("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i), ((com.fyber.inneractive.sdk.model.vast.c) it7.next()).a());
                                i++;
                            }
                        } else {
                            IAlog.e("%sNo companion ads found!", "VastProcessor: ");
                        }
                    }
                    return bVar;
                }
            }
            throw new h("ErrorNoMediaFiles", "Empty inline with no creatives");
        }
        IAlog.a("%sno inline found", "VastProcessor: ");
        throw new h("ErrorNoMediaFiles", "Empty inline ad found");
    }

    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.g gVar) {
        String[] split;
        f fVar;
        Integer num;
        HashMap hashMap;
        List list;
        IAlog.a("%sprocessing ad element: %s", "VastProcessor: ", gVar);
        ArrayList arrayList = gVar.b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                IAlog.a("%sadding impression url: %s", "VastProcessor: ", str);
                x xVar = x.EVENT_IMPRESSION;
                if (f0.e(str)) {
                    bVar.a(xVar, str);
                } else {
                    throw new h("VastErrorUnsecure", "found unsecure tracking event: " + xVar.a());
                }
            }
        }
        String str2 = gVar.f1285a;
        if (!TextUtils.isEmpty(str2)) {
            IAlog.a("%sadding error url: %s", "VastProcessor: ", str2);
            bVar.a(x.EVENT_ERROR, str2);
        }
        if (IAConfigManager.O.K != null) {
            Iterator it2 = gVar.d.iterator();
            while (it2.hasNext()) {
                com.fyber.inneractive.sdk.measurement.h hVar = (com.fyber.inneractive.sdk.measurement.h) it2.next();
                if (hVar.b()) {
                    bVar.e.add(hVar);
                } else {
                    x xVar2 = x.EVENT_VERIFICATION_NOT_EXECUTED;
                    if (((xVar2 == null || (hashMap = hVar.c) == null || (list = (List) hashMap.get(xVar2)) == null) ? 0 : list.size()) > 0) {
                        n.a(new com.fyber.inneractive.sdk.measurement.g(hVar.a(xVar2), com.fyber.inneractive.sdk.measurement.i.VERIFICATION_NOT_SUPPORTED), xVar2);
                    }
                    this.j.add(hVar);
                }
            }
        }
        com.fyber.inneractive.sdk.model.vast.o oVar = gVar.e;
        if (oVar != null) {
            bVar.f = oVar;
        }
        v vVar = gVar.g;
        if (vVar != null) {
            bVar.p = vVar;
        }
        Iterator it3 = gVar.c.iterator();
        while (it3.hasNext()) {
            m mVar = (m) it3.next();
            q qVar = mVar.f1289a;
            if (qVar != null) {
                ArrayList arrayList2 = qVar.f1292a;
                if (arrayList2 != null) {
                    bVar.j = arrayList2.size();
                    Iterator it4 = arrayList2.iterator();
                    while (it4.hasNext()) {
                        r rVar = (r) it4.next();
                        String str3 = rVar.f1293a;
                        s sVar = s.progressive;
                        if (!str3.equals(sVar.a())) {
                            fVar = new f(e.UNSUPPORTED_DELIVERY, sVar.a());
                        } else {
                            if (this.b > -1 && (num = rVar.e) != null && num.intValue() != 0) {
                                int intValue = rVar.e.intValue();
                                int i = this.f1245a;
                                if (intValue < i) {
                                    fVar = new f(e.BITRATE_NOT_IN_RANGE, Integer.valueOf(i));
                                } else {
                                    int intValue2 = rVar.e.intValue();
                                    int i2 = this.b;
                                    if (intValue2 > i2) {
                                        fVar = new f(e.BITRATE_NOT_IN_RANGE, Integer.valueOf(i2));
                                    }
                                }
                            }
                            if (t.a(rVar.d) != t.UNKNOWN) {
                                if (this.d && rVar.b.intValue() >= rVar.c.intValue()) {
                                    fVar = new f(e.VERTICAL_VIDEO_EXPECTED);
                                } else {
                                    String str4 = rVar.f;
                                    if (str4 != null && this.e && str4.equalsIgnoreCase("VPAID")) {
                                        fVar = new f(e.FILTERED_BY_APP_OR_UNIT);
                                    } else if (TextUtils.isEmpty(rVar.g)) {
                                        fVar = new f(e.NO_CONTENT);
                                    } else {
                                        fVar = !f0.e(rVar.g) ? new f(e.UNSECURED_VIDEO_URL) : null;
                                    }
                                }
                            } else {
                                fVar = new f(e.UNSUPPORTED_MIME_TYPE);
                            }
                        }
                        if (fVar != null) {
                            IAlog.a("%smedia file filtered!: %s", "VastProcessor: ", rVar);
                            IAlog.a("%s-- %s", "VastProcessor: ", rVar);
                            IAlog.a("%s-- %s", "VastProcessor: ", fVar);
                            this.f.put(rVar, fVar);
                        } else {
                            IAlog.a("%sadding media file: %s", "VastProcessor: ", rVar);
                            bVar.d.add(rVar);
                            bVar.k.add(rVar);
                            bVar.i++;
                        }
                    }
                }
                ArrayList arrayList3 = qVar.d;
                if (arrayList3 != null) {
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        String str5 = (String) it5.next();
                        x xVar3 = x.EVENT_CLICK;
                        if (f0.e(str5)) {
                            bVar.a(xVar3, str5);
                        } else {
                            throw new h("VastErrorUnsecure", "found unsecure tracking event: " + xVar3.a());
                        }
                    }
                }
                ArrayList arrayList4 = qVar.b;
                if (arrayList4 != null) {
                    Iterator it6 = arrayList4.iterator();
                    while (it6.hasNext()) {
                        w wVar = (w) it6.next();
                        x a2 = x.a(wVar.f1296a);
                        if (a2 != x.UNKNOWN) {
                            bVar.a(a2, wVar.b);
                        }
                        if (a2 == x.EVENT_PROGRESS) {
                            String str6 = wVar.b;
                            String str7 = wVar.c;
                            com.fyber.inneractive.sdk.model.vast.e eVar = new com.fyber.inneractive.sdk.model.vast.e(str6, str7);
                            if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7) && eVar.d != 0) {
                                bVar.m.add(eVar);
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(qVar.c)) {
                    bVar.b = qVar.c;
                }
                String str8 = qVar.e;
                if (!TextUtils.isEmpty(str8) && (split = str8.split(":")) != null && split.length <= 3) {
                    if (split.length == 1) {
                        try {
                            Integer.parseInt(str8);
                        } catch (NumberFormatException unused) {
                        }
                    } else if (split.length == 2) {
                        Integer.parseInt(split[1]);
                        Integer.parseInt(split[0]);
                    } else {
                        Integer.parseInt(split[2]);
                        Integer.parseInt(split[1]);
                        Integer.parseInt(split[0]);
                    }
                }
            }
            com.fyber.inneractive.sdk.model.vast.j jVar = mVar.b;
            ArrayList<com.fyber.inneractive.sdk.model.vast.h> arrayList5 = jVar == null ? null : jVar.f1287a;
            if (arrayList5 != null) {
                for (com.fyber.inneractive.sdk.model.vast.h hVar2 : arrayList5) {
                    try {
                        a(bVar, hVar2, gVar.f);
                    } catch (b e) {
                        IAlog.a("Failed processing companion ad: %s error = %s", hVar2, e.getMessage());
                        hVar2.i = e;
                        this.g.add(hVar2);
                    }
                }
            }
        }
        ArrayList arrayList6 = gVar.h;
        String str9 = !arrayList6.isEmpty() ? ((com.fyber.inneractive.sdk.model.vast.n) arrayList6.get(0)).f1290a : null;
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        bVar.n = str9;
    }

    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.i iVar, int i, int i2, int i3, String str, String str2, List list, List list2, String str3, k kVar) {
        com.fyber.inneractive.sdk.model.vast.h hVar;
        Integer num;
        Integer num2;
        com.fyber.inneractive.sdk.model.vast.c cVar = new com.fyber.inneractive.sdk.model.vast.c(iVar, i2, i3, str, i);
        cVar.g = str2;
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                cVar.a(x.a(wVar.f1296a), wVar.b);
            }
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                cVar.a(x.EVENT_CLICK, (String) it2.next());
            }
        }
        if (!this.h.isEmpty()) {
            if (cVar.h > 0) {
                hVar = (com.fyber.inneractive.sdk.model.vast.h) this.h.remove(r8.size() - 1);
            } else {
                hVar = null;
            }
            String str4 = cVar.e;
            Iterator it3 = this.h.iterator();
            while (it3.hasNext()) {
                com.fyber.inneractive.sdk.model.vast.h hVar2 = (com.fyber.inneractive.sdk.model.vast.h) it3.next();
                String str5 = hVar2.c;
                if ((str4 != null && str4.equals(str5)) || ((str5 == null && (num = hVar2.f1286a) != null && cVar.c == num.intValue() && (num2 = hVar2.b) != null && cVar.d == num2.intValue()) || !hVar2.a())) {
                    ArrayList arrayList = hVar2.h;
                    if (arrayList.size() > 0) {
                        Iterator it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            String str6 = (String) it4.next();
                            if (f0.e(str6)) {
                                cVar.a(x.EVENT_CLICK, str6);
                            }
                        }
                    }
                }
            }
            if (hVar != null) {
                this.h.add(hVar);
            }
        }
        cVar.f = str3;
        cVar.b = kVar;
        bVar.g.add(cVar);
        bVar.l.add(cVar);
    }
}
