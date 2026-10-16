package com.mbridge.msdk.video.dynview.energize;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.listener.e;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: DataEnergize.java */
/* loaded from: classes6.dex */
public class a {
    private static volatile a b;

    /* renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.inter.a f5032a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (b != null) {
            return b;
        }
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    private void b(c cVar, View view, Map map, e eVar) {
        new com.mbridge.msdk.video.dynview.wrapper.a().b(cVar, view, map, eVar);
    }

    private void c(c cVar, View view, Map map, e eVar) {
        new com.mbridge.msdk.video.dynview.wrapper.a().c(cVar, view, map, eVar);
    }

    public void d() {
        com.mbridge.msdk.video.dynview.inter.a aVar = this.f5032a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void b() {
        com.mbridge.msdk.video.dynview.inter.a aVar = this.f5032a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        com.mbridge.msdk.video.dynview.inter.a aVar = this.f5032a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(View view, c cVar, Map map, e eVar) {
        int g = cVar.g();
        if (g == 1) {
            a(cVar, view, map, eVar);
            return;
        }
        if (g == 2) {
            b(cVar, view, map, eVar);
            return;
        }
        if (g == 4) {
            a(cVar, view, eVar);
        } else if (g != 5) {
            eVar.a(view, new ArrayList());
        } else {
            c(cVar, view, map, eVar);
        }
    }

    private void a(c cVar, View view, Map map, e eVar) {
        com.mbridge.msdk.video.dynview.wrapper.a aVar = new com.mbridge.msdk.video.dynview.wrapper.a();
        aVar.a(cVar, view, map, eVar);
        this.f5032a = aVar.l;
    }

    private void a(c cVar, View view, e eVar) {
        new com.mbridge.msdk.video.dynview.wrapper.a().a(cVar, view, eVar);
    }
}
