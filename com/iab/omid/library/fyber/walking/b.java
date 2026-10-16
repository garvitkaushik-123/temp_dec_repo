package com.iab.omid.library.fyber.walking;

import com.iab.omid.library.fyber.walking.async.b;
import com.iab.omid.library.fyber.walking.async.d;
import com.iab.omid.library.fyber.walking.async.e;
import com.iab.omid.library.fyber.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0255b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f1989a;
    private final com.iab.omid.library.fyber.walking.async.c b;

    public b(com.iab.omid.library.fyber.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.fyber.walking.async.b.InterfaceC0255b
    public JSONObject a() {
        return this.f1989a;
    }

    @Override // com.iab.omid.library.fyber.walking.async.b.InterfaceC0255b
    public void a(JSONObject jSONObject) {
        this.f1989a = jSONObject;
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
