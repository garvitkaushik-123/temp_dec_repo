package com.iab.omid.library.inmobi.walking;

import com.iab.omid.library.inmobi.walking.async.b;
import com.iab.omid.library.inmobi.walking.async.d;
import com.iab.omid.library.inmobi.walking.async.e;
import com.iab.omid.library.inmobi.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0259b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f2027a;
    private final com.iab.omid.library.inmobi.walking.async.c b;

    public b(com.iab.omid.library.inmobi.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.inmobi.walking.async.b.InterfaceC0259b
    public JSONObject a() {
        return this.f2027a;
    }

    @Override // com.iab.omid.library.inmobi.walking.async.b.InterfaceC0259b
    public void a(JSONObject jSONObject) {
        this.f2027a = jSONObject;
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
