package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.tracker.network.v;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MBridgeJsonRequest.java */
/* loaded from: classes6.dex */
public class i extends h<JSONObject> implements v.a {
    private final j<JSONObject> C;

    public i(int i, String str, String str2, long j, j<JSONObject> jVar) {
        super(i, str, 0, str2, j);
        this.C = jVar;
        a((v.a) this);
    }

    private void b(v<JSONObject> vVar) {
        j<JSONObject> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.b(this, vVar, vVar.c.f4937a);
            } catch (Exception e) {
                p0.b(h.B, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected v<JSONObject> a(q qVar) {
        try {
            String str = new String(qVar.b, StandardCharsets.UTF_8);
            if (qVar.f4947a == 204) {
                v<JSONObject> a2 = v.a(new JSONObject(), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
                a(a2, qVar);
                return a2;
            }
            v<JSONObject> a3 = v.a(new JSONObject(str), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
            a(a3, qVar);
            return a3;
        } catch (JSONException e) {
            p0.b(h.B, e.getMessage());
            v<JSONObject> a4 = v.a(new s(e));
            b(a4);
            return a4;
        } catch (Throwable th) {
            v<JSONObject> a5 = v.a(new a0(th));
            b(a5);
            return a5;
        }
    }

    private void a(v<JSONObject> vVar, q qVar) {
        j<JSONObject> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.a(this, vVar, qVar);
            } catch (Exception e) {
                p0.b(h.B, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.v.a
    public void a(b0 b0Var) {
        b(v.a(b0Var));
    }
}
