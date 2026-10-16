package com.ironsource;

import com.ironsource.mediationsdk.e;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.ironsource.i2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3123i2 extends e.a {
    public C3123i2(S1 s1, URL url, JSONObject jSONObject, boolean z, C3241p2 c3241p2) {
        super(s1, url, jSONObject, z, c3241p2);
    }

    @Override // com.ironsource.mediationsdk.e.a
    protected void a(boolean z, S1 s1, long j) {
        try {
            if (z) {
                ((InterfaceC3001b2) s1).a(this.b, this.f + 1, j, this.j, this.i);
            } else {
                s1.a(this.c, this.d, this.f + 1, this.g, j);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            s1.a(1009, e.getMessage(), this.f + 1, this.g, j);
        }
    }
}
