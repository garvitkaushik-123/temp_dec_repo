package com.iab.omid.library.voodooio.walking;

import com.iab.omid.library.voodooio.walking.async.b;
import com.iab.omid.library.voodooio.walking.async.d;
import com.iab.omid.library.voodooio.walking.async.e;
import com.iab.omid.library.voodooio.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0275b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f2172a;
    private final com.iab.omid.library.voodooio.walking.async.c b;

    public b(com.iab.omid.library.voodooio.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.voodooio.walking.async.b.InterfaceC0275b
    public JSONObject a() {
        return this.f2172a;
    }

    @Override // com.iab.omid.library.voodooio.walking.async.b.InterfaceC0275b
    public void a(JSONObject jSONObject) {
        this.f2172a = jSONObject;
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
