package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.tracker.network.v;
import java.nio.charset.StandardCharsets;

/* compiled from: MBridgeStringRequest.java */
/* loaded from: classes6.dex */
public class k extends h<String> implements v.a {
    private final j<String> C;

    public k(int i, String str, String str2, long j, j<String> jVar) {
        super(i, str, 0, str2, j);
        this.C = jVar;
        a((v.a) this);
    }

    private void b(v<String> vVar) {
        j<String> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.b(this, vVar, vVar.c.f4937a);
            } catch (Exception e) {
                p0.b(h.B, "parseNetworkResponse error: ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected v<String> a(q qVar) {
        try {
            v<String> a2 = v.a(new String(qVar.b, StandardCharsets.UTF_8), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
            a(a2, qVar);
            return a2;
        } catch (Throwable th) {
            p0.b(h.B, "parseNetworkResponse error: ", th);
            v<String> a3 = v.a(new a0(th));
            b(a3);
            return a3;
        }
    }

    private void a(v<String> vVar, q qVar) {
        j<String> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.a(this, vVar, qVar);
            } catch (Exception e) {
                p0.b(h.B, "parseNetworkResponse error: ", e);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.v.a
    public void a(b0 b0Var) {
        b(v.a(b0Var));
    }
}
