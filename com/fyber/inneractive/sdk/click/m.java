package com.fyber.inneractive.sdk.click;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.e0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class m implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1065a;
    public final /* synthetic */ String b;
    public final /* synthetic */ r c;

    public m(r rVar, String str, String str2) {
        this.c = rVar;
        this.f1065a = str;
        this.b = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        c cVar = (c) obj;
        if (this.c.e) {
            return;
        }
        if (exc != null) {
            r.a(this.c, null, this.f1065a, this.b, exc);
            return;
        }
        if (cVar != null) {
            String str = this.f1065a;
            if (cVar.f1057a.size() > 1) {
                ArrayList arrayList = cVar.f1057a;
                str = (String) arrayList.get(arrayList.size() - 1);
            }
            b a2 = this.c.a(str);
            if ((a2 == null || a2.f1056a == q.FAILED) && !TextUtils.isEmpty(cVar.b)) {
                r rVar = this.c;
                rVar.getClass();
                Iterator it = cVar.f1057a.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!TextUtils.equals(str2, str)) {
                        rVar.f.add(new j(str2, true, q.INTERNAL_REDIRECT, null));
                    }
                }
                r.a(this.c, cVar.b, str, this.b, null);
                return;
            }
            r rVar2 = this.c;
            rVar2.getClass();
            Iterator it2 = cVar.f1057a.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                if (!TextUtils.equals(str3, str)) {
                    rVar2.f.add(new j(str3, false, q.INTERNAL_REDIRECT, null));
                }
            }
            if (this.c.f.size() == 0) {
                this.c.f.add(new j(str, false, q.INTERNAL_REDIRECT, null));
            }
            this.c.a(r.a(str, "followRedirects", "Invalid response"));
        }
    }
}
