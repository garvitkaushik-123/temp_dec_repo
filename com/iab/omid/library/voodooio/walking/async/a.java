package com.iab.omid.library.voodooio.walking.async;

import com.iab.omid.library.voodooio.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a extends b {
    protected final HashSet<String> c;
    protected final JSONObject d;
    protected final long e;

    public a(b.InterfaceC0275b interfaceC0275b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0275b);
        this.c = new HashSet<>(hashSet);
        this.d = jSONObject;
        this.e = j;
    }
}
