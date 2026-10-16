package com.fyber.inneractive.sdk.flow;

import android.os.Handler;
import android.os.HandlerThread;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class k implements com.fyber.inneractive.sdk.interfaces.c, com.fyber.inneractive.sdk.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1207a;
    public com.fyber.inneractive.sdk.response.e b;
    public x c;
    public com.fyber.inneractive.sdk.interfaces.a d;
    public com.fyber.inneractive.sdk.interfaces.b e;
    public com.fyber.inneractive.sdk.config.r0 f;
    public com.fyber.inneractive.sdk.config.global.r g;
    public com.fyber.inneractive.sdk.network.timeouts.content.a j;
    public boolean h = false;
    public int i = 0;
    public final j l = new j(this);
    public d k = new d(this);

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.interfaces.a aVar, com.fyber.inneractive.sdk.interfaces.b bVar) {
        this.f1207a = inneractiveAdRequest;
        this.b = eVar;
        this.d = aVar;
        this.e = bVar;
        this.k = new d(this);
        this.g = rVar;
        UnitDisplayType unitDisplayType = eVar.p;
        this.j = new com.fyber.inneractive.sdk.network.timeouts.content.a((unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED) ? unitDisplayType.name().toLowerCase(Locale.US) : UnitDisplayType.BANNER.name().toLowerCase(Locale.US), com.fyber.inneractive.sdk.response.a.a(eVar.g) == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST ? "video" : "display", (int) eVar.K, eVar.D, IAConfigManager.O.l, this.g);
        if (this.f1207a == null) {
            this.f = com.fyber.inneractive.sdk.config.a.a(eVar.o);
        }
        try {
            h();
        } catch (Throwable th) {
            IAlog.f("Failed to start ContentLoader", IAlog.a(this));
            com.fyber.inneractive.sdk.network.z.a(th, inneractiveAdRequest, eVar);
            this.k.a();
            a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.CONTENT_LOADER_START_FAILED));
        }
    }

    public final void b(InneractiveInfrastructureError inneractiveInfrastructureError) {
        com.fyber.inneractive.sdk.util.r.f1777a.execute(new e(new f(this.b, this.f1207a, d(), this.g.b()), inneractiveInfrastructureError));
    }

    public InneractiveInfrastructureError c() {
        i iVar = i.WEBVIEW_LOAD_TIMEOUT;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if ("video".equalsIgnoreCase((eVar == null || com.fyber.inneractive.sdk.response.a.a(eVar.g) != com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST) ? "display" : "video")) {
            iVar = i.VIDEO_AD_LOAD_TIMEOUT;
        }
        return new InneractiveInfrastructureError(InneractiveErrorCode.LOAD_TIMEOUT, iVar);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c
    public abstract void cancel();

    public abstract String d();

    public final com.fyber.inneractive.sdk.config.s0 e() {
        InneractiveAdRequest inneractiveAdRequest = this.f1207a;
        return inneractiveAdRequest == null ? this.f : inneractiveAdRequest.getSelectedUnitConfig();
    }

    public final void f() {
        String str;
        this.k.a();
        InneractiveAdRequest inneractiveAdRequest = this.f1207a;
        if (inneractiveAdRequest != null) {
            str = inneractiveAdRequest.b;
        } else {
            com.fyber.inneractive.sdk.response.e eVar = this.b;
            if (eVar == null || (str = eVar.B) == null) {
                str = null;
            }
        }
        com.fyber.inneractive.sdk.metrics.d.d.a(str).i();
        x xVar = this.c;
        if (xVar != null) {
            xVar.a(str);
        }
        com.fyber.inneractive.sdk.interfaces.a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.f1207a);
        }
    }

    public abstract void g();

    public final void h() {
        int i = this.i;
        this.i = i + 1;
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        if (aVar != null) {
            if (aVar.g) {
                i = aVar.f1338a - i;
            }
            r2 = (i == aVar.f1338a ? aVar.h : 0) + (aVar.b * i) + aVar.d;
        }
        IAlog.a("%s : IAAdContentLoaderImpl : Start timeout: %d, attempt number: %d", IAlog.a(this), Integer.valueOf(r2), Integer.valueOf(this.i - 1));
        d dVar = this.k;
        if (dVar.f1180a == null) {
            HandlerThread handlerThread = new HandlerThread("TimeoutHandlerThread");
            handlerThread.start();
            dVar.f1180a = new Handler(handlerThread.getLooper());
        }
        dVar.f1180a.postDelayed(dVar.d, r2);
        g();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void b() {
        String a2 = IAlog.a(this);
        Integer valueOf = Integer.valueOf(this.i - 1);
        int i = this.i - 1;
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        if (aVar != null) {
            if (aVar.g) {
                i = aVar.f1338a - i;
            }
            r4 = (i == aVar.f1338a ? aVar.h : 0) + (aVar.b * i) + aVar.d;
        }
        IAlog.a("%s : IAAdContentLoaderImpl : onRetry() attempt: %d timeout: %d", a2, valueOf, Integer.valueOf(r4));
        com.fyber.inneractive.sdk.interfaces.b bVar = this.e;
        if (bVar != null) {
            bVar.b();
        }
        h();
    }

    public void a() {
        int i;
        InneractiveInfrastructureError inneractiveInfrastructureError;
        String a2 = IAlog.a(this);
        Integer valueOf = Integer.valueOf(this.i - 1);
        int i2 = this.i - 1;
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        if (aVar != null) {
            if (aVar.g) {
                i2 = aVar.f1338a - i2;
            }
            i = (aVar.b * i2) + aVar.d + (i2 == aVar.f1338a ? aVar.h : 0);
        } else {
            i = 0;
        }
        IAlog.a("%s : IAAdContentLoaderImpl : onTimeout() attempt: %d timeout: %d", a2, valueOf, Integer.valueOf(i));
        com.fyber.inneractive.sdk.interfaces.b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar2 = this.j;
        if (this.i <= (aVar2 != null ? aVar2.f1338a : 0)) {
            inneractiveInfrastructureError = c();
        } else {
            inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.IN_FLIGHT_TIMEOUT, i.NO_TIME_TO_LOAD_AD_CONTENT);
        }
        b(inneractiveInfrastructureError);
        a(inneractiveInfrastructureError);
    }

    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s : IAAdContentLoaderImpl : Handle Retry for error: %s", IAlog.a(this), inneractiveInfrastructureError.getErrorCode().toString());
        d dVar = this.k;
        dVar.getClass();
        IAlog.a("%s : ContentLoadTimeoutHandler stopping timeout handler", IAlog.a(dVar));
        Handler handler = dVar.f1180a;
        if (handler != null) {
            handler.removeCallbacks(dVar.d);
        }
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        boolean z = this.i <= (aVar != null ? aVar.f1338a : 0);
        IAlog.a("%s : IAAdContentLoaderImpl : should retry: %s", IAlog.a(this), Boolean.valueOf(z));
        if (z) {
            x xVar = this.c;
            if (xVar != null) {
                xVar.a();
                this.c = null;
            }
            com.fyber.inneractive.sdk.network.timeouts.content.a aVar2 = this.j;
            int i = aVar2 != null ? aVar2.e : 0;
            IAlog.a("%s : IAAdContentLoaderImpl : retryLoad : post load ad content retry task with delay: %d", IAlog.a(this), Integer.valueOf(i));
            com.fyber.inneractive.sdk.util.r.b.postDelayed(this.l, i);
            return;
        }
        com.fyber.inneractive.sdk.interfaces.a aVar3 = this.d;
        if (aVar3 != null) {
            aVar3.a(inneractiveInfrastructureError);
        }
        cancel();
        InneractiveAdRequest inneractiveAdRequest = this.f1207a;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        com.fyber.inneractive.sdk.config.global.r rVar = this.g;
        a.a(inneractiveAdRequest, inneractiveInfrastructureError, this.c, eVar, rVar != null ? rVar.b() : null);
    }
}
