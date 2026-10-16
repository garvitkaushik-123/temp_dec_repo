package com.fyber.inneractive.sdk.flow.storepromo.loader;

import com.fyber.inneractive.sdk.util.r;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1222a;
    public final /* synthetic */ f b;

    public e(f fVar, d dVar) {
        this.b = fVar;
        this.f1222a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.flow.storepromo.model.c cVar;
        f fVar = this.b;
        if (fVar.f == null || (cVar = fVar.b) == null) {
            return;
        }
        d dVar = this.f1222a;
        StringBuilder sb = new StringBuilder("\n<script>\n");
        ArrayList arrayList = cVar.f1233a;
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            com.fyber.inneractive.sdk.flow.storepromo.model.a aVar = (com.fyber.inneractive.sdk.flow.storepromo.model.a) it.next();
            int i3 = h.f1225a[aVar.f1232a.ordinal()];
            if (i3 == 1) {
                i++;
                String str = i.f1226a;
                String format = String.format("app_screen_%d", Integer.valueOf(i));
                sb2.append("var " + format + "_el = document.createElement('img');\n" + format + "_el.id = '" + format + "';\ndocument.getElementById('carousel').appendChild(" + format + "_el);\n");
                sb2.append(String.format(i.f1226a, Integer.valueOf(i), aVar.b));
                sb2.append(String.format(i.b, Integer.valueOf(i), Integer.valueOf(i)));
            } else if (i3 == 2) {
                i2++;
                String str2 = i.f1226a;
                String format2 = String.format("app_video_url_%d", Integer.valueOf(i2));
                sb2.append("var " + format2 + "_el = document.createElement('video');\n" + format2 + "_el.id = '" + format2 + "';\ndocument.getElementById('carousel').appendChild(" + format2 + "_el);\n");
                sb2.append(String.format(i.c, Integer.valueOf(i2), aVar.b));
                sb2.append(String.format(i.d, Integer.valueOf(i2), Integer.valueOf(i2)));
            } else if (i3 == 3) {
                sb2.append(String.format(i.e, aVar.b));
                sb2.append(i.f);
            } else if (i3 == 4) {
                sb2.append(String.format(i.q, aVar.b));
                sb2.append(i.r);
            }
        }
        StringBuilder append = sb.append(sb2.toString()).append(String.format(i.g, cVar.b.replace("`", "\\`")) + i.h + String.format(i.i, cVar.f.replace("`", "\\`")) + i.j + String.format(i.k, cVar.g.b.replace("`", "\\`")) + i.l + String.format(i.o, cVar.g.f1234a.replace("`", "\\`")) + i.p + String.format(i.m, cVar.g.c.replace("`", "\\`")) + i.n);
        StringBuilder sb3 = new StringBuilder();
        boolean parseBoolean = Boolean.parseBoolean(cVar.d);
        boolean parseBoolean2 = Boolean.parseBoolean(cVar.e);
        sb3.append(i.a(parseBoolean, "in_app_purchases"));
        sb3.append(i.a(parseBoolean2, "app_contains_ads"));
        if (parseBoolean2 && parseBoolean) {
            z = true;
        }
        sb3.append(i.a(z, "app_subtitle_separator"));
        String str3 = cVar.c + append.append(sb3.toString()).append("</script>").toString();
        dVar.getClass();
        r.b.post(new c(dVar, str3));
    }
}
