package com.fyber.inneractive.sdk.cache.session;

import com.fyber.inneractive.sdk.util.o;
import java.io.UnsupportedEncodingException;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.session.enums.a f1049a;
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.session.enums.c b;
    public final /* synthetic */ e c;

    public d(e eVar, com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.c cVar) {
        this.c = eVar;
        this.f1049a = aVar;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.c) {
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = this.f1049a;
            if (aVar != com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION) {
                g gVar = (g) this.c.f1050a.f1054a.get(this.b);
                if (gVar != null) {
                    int i = f.f1052a[aVar.ordinal()];
                    if (i == 1) {
                        gVar.b++;
                    } else if (i == 2) {
                        gVar.c++;
                    } else if (i == 3) {
                        gVar.f1053a++;
                    }
                }
            } else {
                this.c.f1050a = new i();
            }
            try {
                o.a(o.f1770a, e.a(this.c).toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
            this.c.getClass();
        }
    }
}
