package com.iab.omid.library.bytedance2.processor;

import android.view.View;
import com.iab.omid.library.bytedance2.processor.a;
import com.iab.omid.library.bytedance2.utils.e;
import com.iab.omid.library.bytedance2.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final a f1935a;

    public c(a aVar) {
        this.f1935a = aVar;
    }

    ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.bytedance2.internal.c c = com.iab.omid.library.bytedance2.internal.c.c();
        if (c != null) {
            Collection<com.iab.omid.library.bytedance2.adsession.a> a2 = c.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            Iterator<com.iab.omid.library.bytedance2.adsession.a> it = a2.iterator();
            while (it.hasNext()) {
                View c2 = it.next().c();
                if (c2 != null && h.e(c2) && (rootView = c2.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float c3 = h.c(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.c(arrayList.get(size - 1)) > c3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    @Override // com.iab.omid.library.bytedance2.processor.a
    public JSONObject a(View view) {
        JSONObject a2 = com.iab.omid.library.bytedance2.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.bytedance2.utils.c.a(a2, e.a());
        return a2;
    }

    @Override // com.iab.omid.library.bytedance2.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0248a interfaceC0248a, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            interfaceC0248a.a(it.next(), this.f1935a, jSONObject, z2);
        }
    }
}
