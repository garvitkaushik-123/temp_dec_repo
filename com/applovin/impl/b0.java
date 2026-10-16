package com.applovin.impl;

import com.applovin.impl.q5;
import com.applovin.impl.s5;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class b0 implements s5.b, q5.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f392a;
    private final a b;
    private z c;
    private String d;

    public interface a {
        void a(b bVar, String str);

        void a(z zVar, String str);
    }

    public enum b {
        APP_DETAILS_NOT_FOUND,
        INVALID_DEVELOPER_URI,
        APPADSTXT_NOT_FOUND,
        MISSING_APPLOVIN_ENTRIES,
        MISSING_NON_APPLOVIN_ENTRIES
    }

    public b0(com.applovin.impl.sdk.k kVar, a aVar) {
        this.f392a = kVar;
        this.b = aVar;
    }

    public void a() {
        z zVar = this.c;
        if (zVar != null) {
            this.b.a(zVar, this.d);
        } else {
            this.f392a.r0().a(new s5(this.f392a, this));
        }
    }

    public static List a(z zVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a0 a0Var = (a0) it.next();
            List list2 = (List) zVar.a().get(a0Var.b());
            if (list2 != null) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((a0) it2.next()).a(a0Var)) {
                        break;
                    }
                }
            }
            arrayList.add(a0Var);
        }
        return arrayList;
    }

    @Override // com.applovin.impl.s5.b
    public void a(String str) {
        this.f392a.r0().a(new q5(this.f392a, str, this));
    }

    @Override // com.applovin.impl.s5.b
    public void a(b bVar) {
        this.b.a(bVar, (String) null);
    }

    @Override // com.applovin.impl.q5.b
    public void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = 1;
        for (String str3 : str.split("\n")) {
            String trim = str3.split("#", 2)[0].trim();
            if (StringUtils.isValidString(trim)) {
                a0 a0Var = new a0(trim, i);
                if (a0Var.h()) {
                    String b2 = a0Var.b();
                    List arrayList2 = hashMap.containsKey(b2) ? (List) hashMap.get(b2) : new ArrayList();
                    if (arrayList2 != null) {
                        arrayList2.add(a0Var);
                        hashMap.put(b2, arrayList2);
                    }
                } else {
                    arrayList.add(a0Var);
                }
            }
            i++;
        }
        this.c = new z(hashMap, arrayList);
        this.d = str2;
        this.f392a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f392a.O().a("AppAdsTxtService", "app-ads.txt fetched: " + this.c);
        }
        this.b.a(this.c, str2);
    }

    @Override // com.applovin.impl.q5.b
    public void a(b bVar, String str) {
        this.b.a(bVar, str);
    }
}
