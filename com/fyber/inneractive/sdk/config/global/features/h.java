package com.fyber.inneractive.sdk.config.global.features;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class h extends com.fyber.inneractive.sdk.config.global.p {
    public String b;
    public HashMap c = new HashMap();
    public HashMap d = new HashMap();

    public h(String str) {
        this.b = str;
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final String a(String str, String str2) {
        String str3;
        Iterator it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str3 = null;
                break;
            }
            str3 = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).b(str);
            if (str3 != null) {
                break;
            }
        }
        if (str3 != null) {
            return str3;
        }
        com.fyber.inneractive.sdk.config.global.n nVar = this.f1096a;
        return nVar != null ? nVar.a(str, str2) : str2;
    }

    public abstract h b();

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final String b(String str) {
        return a(str, null);
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Boolean c(String str) {
        Boolean bool;
        Iterator it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bool = null;
                break;
            }
            bool = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).c(str);
            if (bool != null) {
                break;
            }
        }
        return bool == null ? super.c(str) : bool;
    }

    public final String toString() {
        return String.format("id: %s, params: %s exp: %s", this.b, this.f1096a, this.c);
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Integer a(String str) {
        Integer num;
        Iterator it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).a(str);
            if (num != null) {
                break;
            }
        }
        return num == null ? super.a(str) : num;
    }

    public final void a(h hVar) {
        hVar.b = this.b;
        hVar.f1096a = this.f1096a;
        hVar.c = new HashMap(this.c);
        hVar.d = new HashMap(this.d);
    }
}
