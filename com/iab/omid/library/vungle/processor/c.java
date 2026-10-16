package com.iab.omid.library.vungle.processor;

import android.view.View;
import com.iab.omid.library.vungle.processor.a;
import com.iab.omid.library.vungle.utils.e;
import com.iab.omid.library.vungle.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f2192a;

    public c(a aVar) {
        this.f2192a = aVar;
    }

    ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.vungle.internal.c c = com.iab.omid.library.vungle.internal.c.c();
        if (c != null) {
            Collection<com.iab.omid.library.vungle.adsession.a> a2 = c.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            Iterator<com.iab.omid.library.vungle.adsession.a> it = a2.iterator();
            while (it.hasNext()) {
                View e = it.next().e();
                if (e != null && h.g(e) && (rootView = e.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d = h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.d(arrayList.get(size - 1)) > d) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    @Override // com.iab.omid.library.vungle.processor.a
    public JSONObject a(View view) {
        JSONObject a2 = com.iab.omid.library.vungle.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.vungle.utils.c.a(a2, e.a());
        return a2;
    }

    @Override // com.iab.omid.library.vungle.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0276a interfaceC0276a, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            interfaceC0276a.a(it.next(), this.f2192a, jSONObject, z2);
        }
    }
}
