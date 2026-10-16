package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.tracker.x;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: Global.java */
/* loaded from: classes6.dex */
class k {
    private static volatile String o = "";

    /* renamed from: a, reason: collision with root package name */
    private final String f4930a;
    private final m b;
    private Context c;
    private x d;
    private JSONObject e;
    private List<String> f;
    private List<String> g;
    private volatile c h;
    private volatile l i;
    private volatile d j;
    private volatile j k;
    private volatile s l;
    private volatile boolean m = true;
    private volatile o n;

    k(String str, m mVar) {
        this.f4930a = str;
        this.b = mVar;
    }

    void a(Context context) {
        this.c = context;
    }

    x b() {
        x xVar = this.d;
        if (xVar != null) {
            return xVar;
        }
        x a2 = new x.b().a();
        this.d = a2;
        return a2;
    }

    Context c() {
        return this.c;
    }

    c d() {
        if (y.b(this.h)) {
            synchronized (k.class) {
                if (y.b(this.h)) {
                    String t = t();
                    this.h = new c(new b(c(), e(), t), t);
                }
            }
        }
        return this.h;
    }

    String e() {
        return TextUtils.isEmpty(v()) ? String.format("track_manager_%s.db", EventTaskParams.STATE_GROUP_DEFAULT) : String.format("track_manager_%s.db", v());
    }

    d f() {
        if (y.b(this.j)) {
            this.j = b().h;
        }
        return this.j;
    }

    l g() {
        if (y.b(this.i)) {
            synchronized (k.class) {
                if (y.b(this.i)) {
                    this.i = new q(new g(d(), p()));
                }
            }
        }
        return this.i;
    }

    j h() {
        if (y.b(this.k)) {
            synchronized (k.class) {
                if (y.b(this.k)) {
                    this.k = new j();
                }
            }
        }
        return this.k;
    }

    int i() {
        if (b().f4976a < 0) {
            return 50;
        }
        return b().f4976a;
    }

    int j() {
        return Math.max(b().e, 0);
    }

    int k() {
        if (b().d <= 0) {
            return 2;
        }
        return b().d;
    }

    int l() {
        return Math.max(b().b, 0);
    }

    o m() {
        if (y.b(this.n)) {
            synchronized (k.class) {
                if (y.b(this.n)) {
                    this.n = new o(k(), n(), r(), q());
                }
            }
        }
        return this.n;
    }

    p n() {
        return b().g;
    }

    JSONObject o() {
        JSONObject jSONObject = this.e;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.e = jSONObject2;
        return jSONObject2;
    }

    s p() {
        if (y.b(this.l)) {
            synchronized (k.class) {
                if (y.b(this.l)) {
                    this.l = new s(this);
                }
            }
        }
        return this.l;
    }

    int q() {
        return b().c;
    }

    w r() {
        return b().i;
    }

    String s() {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        String uuid = UUID.randomUUID().toString();
        o = uuid;
        return uuid;
    }

    String t() {
        return "event_table";
    }

    m u() {
        return this.b;
    }

    String v() {
        return this.f4930a;
    }

    boolean w() {
        return this.m;
    }

    String x() {
        if (!y.b(this.c) && !y.b(this.d)) {
            try {
                p().j();
                this.m = false;
                if (TextUtils.isEmpty(o)) {
                    o = UUID.randomUUID().toString();
                }
                return o;
            } catch (Exception e) {
                if (a.f4921a) {
                    Log.e("TrackManager", "start error", e);
                }
                this.m = true;
            }
        }
        return "";
    }

    void a(x xVar) {
        this.d = xVar;
    }

    void a(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    boolean a(e eVar) {
        if (y.b(eVar)) {
            return false;
        }
        f fVar = b().j;
        if (y.a(fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e) {
                if (a.f4921a) {
                    Log.e("TrackManager", "event filter apply exception", e);
                }
            }
        }
        String b = eVar.b();
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (this.g != null) {
            try {
                return !r0.contains(b);
            } catch (Exception e2) {
                if (a.f4921a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e2);
                }
            }
        }
        List<String> list = this.f;
        if (list != null) {
            try {
                return list.contains(b);
            } catch (Exception e3) {
                if (a.f4921a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e3);
                }
            }
        }
        return true;
    }

    boolean a() throws IllegalStateException {
        if (!y.b(b())) {
            if (!y.b(f())) {
                if (!y.b(r())) {
                    if (!y.b(n()) && !y.b(n().b())) {
                        if (TextUtils.isEmpty(n().c())) {
                            throw new IllegalStateException("report url is null");
                        }
                        return true;
                    }
                    throw new IllegalStateException("networkStackConfig or stack can not be null");
                }
                throw new IllegalStateException("responseHandler can not be null");
            }
            throw new IllegalStateException("decorate can not be null");
        }
        throw new IllegalStateException("config can not be null");
    }
}
