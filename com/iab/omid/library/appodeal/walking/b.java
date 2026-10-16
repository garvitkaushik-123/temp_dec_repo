package com.iab.omid.library.appodeal.walking;

import com.iab.omid.library.appodeal.walking.async.b;
import com.iab.omid.library.appodeal.walking.async.d;
import com.iab.omid.library.appodeal.walking.async.e;
import com.iab.omid.library.appodeal.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0247b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f1917a;
    private final com.iab.omid.library.appodeal.walking.async.c b;

    public b(com.iab.omid.library.appodeal.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.appodeal.walking.async.b.InterfaceC0247b
    public JSONObject a() {
        return this.f1917a;
    }

    @Override // com.iab.omid.library.appodeal.walking.async.b.InterfaceC0247b
    public void a(JSONObject jSONObject) {
        this.f1917a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }
}
