package com.iab.omid.library.voodooio.processor;

import android.view.View;
import com.iab.omid.library.voodooio.processor.a;
import com.iab.omid.library.voodooio.utils.e;
import com.iab.omid.library.voodooio.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f2155a;

    public c(a aVar) {
        this.f2155a = aVar;
    }

    ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.voodooio.internal.c c = com.iab.omid.library.voodooio.internal.c.c();
        if (c != null) {
            Collection<com.iab.omid.library.voodooio.adsession.a> a2 = c.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            Iterator<com.iab.omid.library.voodooio.adsession.a> it = a2.iterator();
            while (it.hasNext()) {
                View c2 = it.next().c();
                if (c2 != null && h.g(c2) && (rootView = c2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
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

    @Override // com.iab.omid.library.voodooio.processor.a
    public JSONObject a(View view) {
        JSONObject a2 = com.iab.omid.library.voodooio.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.voodooio.utils.c.a(a2, e.a());
        return a2;
    }

    @Override // com.iab.omid.library.voodooio.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0272a interfaceC0272a, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            interfaceC0272a.a(it.next(), this.f2155a, jSONObject, z2);
        }
    }
}
