package com.fyber.inneractive.sdk.ignite;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.y0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class h implements com.digitalturbine.ignite.authenticator.listeners.api.a, AuthenticationServiceListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f1259a;
    public IIgniteServiceAPI b;
    public long k;
    public String l;
    public d m;
    public com.digitalturbine.ignite.authenticator.listeners.internal.a n;
    public com.fyber.inneractive.sdk.config.global.r o;
    public l p;
    public final Bundle c = new Bundle();
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    public boolean i = false;
    public boolean j = false;
    public final i d = new i(new e(this));

    public final void a(com.fyber.inneractive.sdk.config.global.r rVar) {
        boolean z;
        h hVar;
        this.o = rVar;
        if (!TextUtils.isEmpty(this.l)) {
            IAlog.a("%s : Ignite installed will init IgniteManager", "IgniteAdapter");
            com.fyber.inneractive.sdk.config.global.features.i iVar = (com.fyber.inneractive.sdk.config.global.features.i) rVar.a(com.fyber.inneractive.sdk.config.global.features.i.class);
            IAlog.a("%s : initializing ignite features", "IgniteAdapter");
            Boolean c = iVar.c("odt");
            this.e = c != null ? c.booleanValue() : false;
            Boolean c2 = iVar.c("flow");
            this.f = c2 != null ? c2.booleanValue() : false;
            Boolean c3 = iVar.c("updates");
            this.g = c3 != null ? c3.booleanValue() : false;
            Context context = this.f1259a;
            if (context != null && ((z = this.e) || this.f)) {
                if (this.p == null) {
                    this.j = false;
                    hVar = this;
                    l lVar = new l(context, new k(), new com.fyber.inneractive.sdk.ignite.events.wrappers.a(), z, this.f, this.g, hVar);
                    hVar.p = lVar;
                    lVar.authenticate();
                } else {
                    hVar = this;
                }
                hVar.k = TimeUnit.SECONDS.toMillis(IAConfigManager.O.w.f1125a.b.a("igniteInstallTimeOutInSeconds", 15, 1));
            }
        }
    }

    public final void m() {
        d dVar = this.m;
        if (dVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar);
            this.m = null;
        }
    }

    public final boolean n() {
        l lVar = this.p;
        return lVar != null && lVar.isConnected() && this.p.isAuthenticated();
    }

    public final boolean o() {
        l lVar = this.p;
        return lVar == null || lVar.f984a.f();
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public final void onCredentialsRequestFailed(String str) {
        l lVar = this.p;
        if (lVar != null) {
            lVar.onCredentialsRequestFailed(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public final void onCredentialsRequestSuccess(String str, String str2) {
        l lVar = this.p;
        if (lVar != null) {
            lVar.onCredentialsRequestSuccess(str, str2);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceAuthenticated(String str) {
        this.c.putString("clientToken", str);
        IAlog.a("IgniteAdapter: onIgniteServiceAuthenticated", new Object[0]);
        com.digitalturbine.ignite.authenticator.listeners.internal.a aVar = this.n;
        if (aVar != null) {
            aVar.a();
            this.n = null;
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceAuthenticationFailed(String str) {
        this.b = null;
        a(j.FAILED_TO_AUTHENTICATE, str);
        IAlog.a("IgniteAdapter: onIgniteServiceAuthenticationFailed : error : %s", str);
        com.digitalturbine.ignite.authenticator.listeners.internal.a aVar = this.n;
        if (aVar != null) {
            aVar.a(str);
            this.n = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onIgniteServiceConnected(ComponentName componentName, IBinder iBinder) {
        o newBuilder;
        String str;
        Context context;
        IAlog.a("IgniteAdapter: onIgniteServiceConnected", new Object[0]);
        this.l = componentName.getPackageName();
        this.b = IIgniteServiceAPI.Stub.asInterface(iBinder);
        if (this.j) {
            l lVar = this.p;
            if (lVar != null) {
                lVar.authenticate();
                return;
            }
            return;
        }
        this.j = true;
        byte[] bArr = null;
        try {
            newBuilder = IgniteRequestOuterClass$IgniteRequest.newBuilder();
            String str2 = IAConfigManager.O.c;
            newBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setAppId(str2);
            String packageName = com.fyber.inneractive.sdk.util.o.f1770a.getPackageName();
            newBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setBundle(packageName);
            String version = InneractiveAdManager.getVersion();
            newBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setSdkVersion(version);
            String str3 = this.l;
            newBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setIgnitePackageName(str3);
        } catch (Throwable unused) {
            IAlog.a("Failed to build ignite request", new Object[0]);
        }
        if (!TextUtils.isEmpty(this.l) && (context = this.f1259a) != null) {
            try {
                str = context.getPackageManager().getPackageInfo(this.l, 0).versionName;
            } catch (Exception unused2) {
                IAlog.a("Failed to resolve ignite version", new Object[0]);
            }
            newBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setIgniteVersionName(str);
            String a2 = com.fyber.inneractive.sdk.util.o.a(this.f1259a);
            newBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setAppSignature(a2);
            bArr = ((IgniteRequestOuterClass$IgniteRequest) newBuilder.a()).toByteArray();
            if (bArr == null) {
                IAConfigManager.O.s.b(new y0(new b(this), bArr, this.o));
                return;
            }
            return;
        }
        str = null;
        newBuilder.c();
        ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setIgniteVersionName(str);
        String a22 = com.fyber.inneractive.sdk.util.o.a(this.f1259a);
        newBuilder.c();
        ((IgniteRequestOuterClass$IgniteRequest) newBuilder.b).setAppSignature(a22);
        bArr = ((IgniteRequestOuterClass$IgniteRequest) newBuilder.a()).toByteArray();
        if (bArr == null) {
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceConnectionFailed(String str) {
        IAlog.a("IgniteAdapter: onIgniteServiceConnectionFailed : error : %s", str);
        a(j.FAILED_TO_BIND_SERVICE, str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onOdtUnsupported() {
        l lVar;
        IAlog.f("%s: onOdtUnsupported : unsupported ignite version", "IgniteAdapter");
        if (this.f || (lVar = this.p) == null) {
            return;
        }
        lVar.destroy();
        this.p = null;
    }

    public final void a(j jVar, String str) {
        if (this.i) {
            return;
        }
        this.i = true;
        t tVar = t.IGNITE_FLOW_FAILED_TO_START;
        w wVar = new w((com.fyber.inneractive.sdk.response.e) null);
        wVar.b = tVar;
        wVar.f1340a = null;
        wVar.d = null;
        JSONObject jSONObject = new JSONObject();
        String a2 = jVar.a();
        try {
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, a2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", AndroidBridgeConstants.ERROR_CODE, a2);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", PglCryptUtils.KEY_MESSAGE, str);
            }
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }

    public final void a(com.digitalturbine.ignite.authenticator.listeners.internal.a aVar) {
        IAlog.a("IgniteAdapter : reconnectIgnite : with callback : " + aVar, new Object[0]);
        this.n = aVar;
        l lVar = this.p;
        if (lVar != null) {
            lVar.authenticate();
        }
    }

    public final void a(String str, g gVar) {
        String a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.a("Starting install timeout with %d", Long.valueOf(this.k));
        d dVar = new d(this);
        this.m = dVar;
        com.fyber.inneractive.sdk.util.r.b.postDelayed(dVar, this.k);
        if (n() && !o() && this.b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME, str);
                jSONObject.put("data", jSONObject2);
                IIgniteServiceAPI iIgniteServiceAPI = this.b;
                String jSONObject3 = jSONObject.toString();
                Bundle bundle = this.c;
                Bundle bundle2 = new Bundle();
                i iVar = this.d;
                c cVar = new c(this, gVar);
                iVar.getClass();
                iIgniteServiceAPI.install(jSONObject3, bundle, bundle2, new s((e) iVar.f1260a, cVar));
                return;
            } catch (Exception unused) {
                IAlog.a("Failed to install app", new Object[0]);
                return;
            }
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                if (o()) {
                    a2 = j.SESSION_EXPIRED.a();
                } else {
                    a2 = j.NOT_CONNECTED.a();
                }
                rVar.a((String) null, a2, (String) null);
            }
        }
    }
}
