package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.C3000b1;
import com.ironsource.C3260q4;
import com.ironsource.J8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class y implements J8.b {

    /* renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f3591a;
    protected C3000b1 b;
    private boolean c;
    protected JSONObject d;
    protected String e;
    protected int f;
    protected Long g = null;

    y(C3000b1 c3000b1, AbstractAdapter abstractAdapter) {
        this.b = c3000b1;
        this.f3591a = abstractAdapter;
        this.d = c3000b1.c();
    }

    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.ironsource.J8.b
    public int b() {
        return this.b.e();
    }

    @Override // com.ironsource.J8.b
    public String c() {
        return this.b.f();
    }

    public abstract IronSource.AD_UNIT d();

    public Long e() {
        return this.g;
    }

    public String f() {
        return String.format("%s %s", i(), Integer.valueOf(hashCode()));
    }

    public int g() {
        return this.b.d();
    }

    public boolean h() {
        return this.c;
    }

    public String i() {
        return this.b.h().isMultipleInstances() ? this.b.h().getProviderTypeForReflection() : this.b.h().getProviderName();
    }

    public String j() {
        return this.b.g();
    }

    public abstract String k();

    public int l() {
        return 1;
    }

    public Map<String, Object> m() {
        HashMap hashMap = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.f3591a;
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f3591a;
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            hashMap.put("spId", this.b.i());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.b.a());
            hashMap.put("instanceType", Integer.valueOf(p() ? 2 : 1));
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(l()));
            if (!TextUtils.isEmpty(this.e)) {
                hashMap.put("dynamicDemandSource", this.e);
                return hashMap;
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + c() + ")", th);
        }
        return hashMap;
    }

    public int n() {
        return this.f;
    }

    public boolean o() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        try {
            if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !this.f3591a.isUsingActivityBeforeImpression(d())) {
                return false;
            }
            ironLog.verbose(c() + " - is using activity before impression and activity is null");
            return true;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            b("Exception while calling adapter.isUsingActivityBeforeImpression() - " + th.getLocalizedMessage());
            return true;
        }
    }

    public boolean p() {
        return this.b.j();
    }

    public void q() {
        try {
            AbstractAdapter abstractAdapter = this.f3591a;
            if (abstractAdapter != null) {
                abstractAdapter.releaseMemory(this.b.b(), this.d);
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error("exception - " + th.getMessage());
        }
        this.f3591a = null;
    }

    public boolean r() {
        if (o()) {
            return false;
        }
        return p() || s();
    }

    public boolean s() {
        return this.b.k();
    }

    public void a(String str) {
        a(str, 0);
    }

    public void b(String str) {
        a(str, 3);
    }

    public void c(String str) {
        this.e = d.b().c(str);
    }

    private void a(String str, int i) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, k() + " " + c() + " : " + str, i);
    }
}
