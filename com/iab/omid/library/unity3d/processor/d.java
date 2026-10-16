package com.iab.omid.library.unity3d.processor;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.unity3d.processor.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f2119a = new int[2];

    private void a(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0268a interfaceC0268a, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            interfaceC0268a.a(viewGroup.getChildAt(i), this, jSONObject, z);
        }
    }

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0268a interfaceC0268a, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                interfaceC0268a.a((View) it2.next(), this, jSONObject, z);
            }
        }
    }

    @Override // com.iab.omid.library.unity3d.processor.a
    public JSONObject a(View view) {
        if (view == null) {
            return com.iab.omid.library.unity3d.utils.c.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f2119a);
        int[] iArr = this.f2119a;
        return com.iab.omid.library.unity3d.utils.c.a(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.unity3d.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0268a interfaceC0268a, boolean z, boolean z2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z) {
                b(viewGroup, jSONObject, interfaceC0268a, z2);
            } else {
                a(viewGroup, jSONObject, interfaceC0268a, z2);
            }
        }
    }
}
