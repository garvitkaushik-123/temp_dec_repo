package com.fyber.inneractive.sdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.network.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class e implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f1059a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ g c;

    public e(g gVar, List list, Uri uri) {
        this.c = gVar;
        this.f1059a = list;
        this.b = uri;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        c cVar = (c) obj;
        if (this.c.f) {
            return;
        }
        if (exc != null || cVar == null) {
            String uri = this.b.toString();
            IAConfigManager iAConfigManager = IAConfigManager.O;
            com.fyber.inneractive.sdk.util.r.b.post(new f0(uri, null));
            Uri uri2 = this.b;
            this.c.getClass();
            b a2 = r.a(uri2.toString(), "IgniteGooglePlay", "failed getting redirects");
            List list = this.f1059a;
            if (list != null) {
                list.add(new j(this.b.toString(), false, q.INTERNAL_REDIRECT, "failed getting redirects. ignite click handler"));
                List list2 = this.f1059a;
                a2.f.clear();
                a2.f.addAll(list2);
            }
            g gVar = this.c;
            f fVar = gVar.c;
            if (fVar != null) {
                fVar.a(a2, gVar.d, gVar.e);
                return;
            }
            return;
        }
        if (cVar.f1057a.size() > 0) {
            ArrayList arrayList = cVar.f1057a;
            String str = (String) arrayList.get(arrayList.size() - 1);
            if (this.f1059a != null) {
                Iterator it = cVar.f1057a.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!TextUtils.equals(str2, str)) {
                        this.f1059a.add(new j(str2, true, q.INTERNAL_REDIRECT, null));
                    }
                }
                List list3 = this.f1059a;
                q qVar = q.OPEN_INTERNAL_STORE;
                list3.add(new j(str, true, qVar, null));
                this.c.getClass();
                b bVar = new b(str, qVar, "IgniteGooglePlay", null);
                List list4 = this.f1059a;
                bVar.f.clear();
                bVar.f.addAll(list4);
                g gVar2 = this.c;
                f fVar2 = gVar2.c;
                if (fVar2 != null) {
                    fVar2.a(bVar, gVar2.d, gVar2.e);
                }
            }
            if (str.startsWith("market")) {
                String replace = str.replace("market://details?id=", "https://play.google.com/store/apps/details?id=");
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                com.fyber.inneractive.sdk.util.r.b.post(new f0(replace, null));
            } else {
                String str3 = cVar.b;
                IAConfigManager iAConfigManager3 = IAConfigManager.O;
                com.fyber.inneractive.sdk.util.r.b.post(new f0(str, str3));
            }
        }
    }
}
