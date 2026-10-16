package com.iab.omid.library.fyber.processor;

import android.view.View;
import com.iab.omid.library.fyber.processor.a;
import com.iab.omid.library.fyber.utils.e;
import com.iab.omid.library.fyber.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f1972a;

    public c(a aVar) {
        this.f1972a = aVar;
    }

    ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.fyber.internal.c c = com.iab.omid.library.fyber.internal.c.c();
        if (c != null) {
            Collection<com.iab.omid.library.fyber.adsession.a> a2 = c.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            Iterator<com.iab.omid.library.fyber.adsession.a> it = a2.iterator();
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

    @Override // com.iab.omid.library.fyber.processor.a
    public JSONObject a(View view) {
        JSONObject a2 = com.iab.omid.library.fyber.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.fyber.utils.c.a(a2, e.a());
        return a2;
    }

    @Override // com.iab.omid.library.fyber.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0252a interfaceC0252a, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            interfaceC0252a.a(it.next(), this.f1972a, jSONObject, z2);
        }
    }
}
