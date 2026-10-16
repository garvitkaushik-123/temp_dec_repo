package com.ironsource;

import android.text.TextUtils;
import com.ironsource.C3230o8;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class W4 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, V4> f3105a = new LinkedHashMap();
    private final Map<String, V4> b = new LinkedHashMap();
    private final Map<String, V4> c = new LinkedHashMap();

    private Map<String, V4> b(C3230o8.e eVar) {
        if (eVar.name().equalsIgnoreCase(C3230o8.e.RewardedVideo.name())) {
            return this.f3105a;
        }
        if (eVar.name().equalsIgnoreCase(C3230o8.e.Interstitial.name())) {
            return this.b;
        }
        if (eVar.name().equalsIgnoreCase(C3230o8.e.Banner.name())) {
            return this.c;
        }
        return null;
    }

    public Collection<V4> a(C3230o8.e eVar) {
        Map<String, V4> b = b(eVar);
        return b != null ? b.values() : new ArrayList();
    }

    public V4 a(C3230o8.e eVar, String str) {
        Map<String, V4> b;
        if (TextUtils.isEmpty(str) || (b = b(eVar)) == null) {
            return null;
        }
        return b.get(str);
    }

    public void b(C3230o8.e eVar, String str) {
        Map<String, V4> b;
        V4 remove;
        if (TextUtils.isEmpty(str) || (b = b(eVar)) == null || (remove = b.remove(str)) == null) {
            return;
        }
        remove.a();
    }

    private void a(C3230o8.e eVar, String str, V4 v4) {
        Map<String, V4> b;
        if (TextUtils.isEmpty(str) || v4 == null || (b = b(eVar)) == null) {
            return;
        }
        b.put(str, v4);
    }

    public V4 a(C3230o8.e eVar, B9 b9) {
        V4 v4 = new V4(b9);
        a(eVar, b9.e(), v4);
        return v4;
    }

    public V4 a(C3230o8.e eVar, String str, Map<String, String> map, InterfaceC3268qc interfaceC3268qc) {
        V4 v4 = new V4(str, str, map, interfaceC3268qc);
        a(eVar, str, v4);
        return v4;
    }
}
