package com.mbridge.msdk.tracker;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.v;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ReportRequest.java */
/* loaded from: classes6.dex */
public class v<T> extends com.mbridge.msdk.tracker.network.t<T> {
    private com.mbridge.msdk.tracker.network.e A;
    private Map<String, String> w;
    private t.a x;
    private v.b<T> y;
    private w z;

    public v(String str, int i) {
        super(i, str);
    }

    public v.b<T> C() {
        return this.y;
    }

    public void a(w wVar) {
        this.z = wVar;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public boolean a() {
        return false;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        hashMap.put("Charset", "UTF-8");
        return hashMap;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected Map<String, String> i() {
        return this.w;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public t.a l() {
        return this.x;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    public com.mbridge.msdk.tracker.network.x o() {
        if (y.b(this.A)) {
            this.A = new com.mbridge.msdk.tracker.network.e(30000, 0);
        }
        return this.A;
    }

    public v(String str, int i, int i2) {
        super(i, str, i2);
    }

    public void a(t.a aVar) {
        this.x = aVar;
    }

    public void a(Map<String, String> map) {
        this.w = map;
    }

    public void a(v.b<T> bVar) {
        this.y = bVar;
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected com.mbridge.msdk.tracker.network.v<T> a(com.mbridge.msdk.tracker.network.q qVar) {
        return this.z.a(qVar);
    }

    @Override // com.mbridge.msdk.tracker.network.t
    protected void a(T t) {
        v.b<T> C = C();
        this.y = C;
        if (C != null) {
            C.a(t);
        }
    }
}
