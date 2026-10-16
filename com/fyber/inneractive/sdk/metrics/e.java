package com.fyber.inneractive.sdk.metrics;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class e implements g {

    /* renamed from: a, reason: collision with root package name */
    public Long f1277a = null;
    public Long b = null;
    public Long c = null;
    public Long d = null;
    public Long e = null;
    public Long f = null;
    public Long g = null;
    public Long h = null;

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long b() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.g = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long c() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.f1277a = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long d() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.d = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long e() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.f = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long f() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.b = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long g() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.c = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long h() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.h = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long i() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.e = valueOf;
        return valueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final HashMap j() {
        HashMap hashMap = new HashMap();
        Long l = this.b;
        if (l != null && this.f1277a != null) {
            hashMap.put("sdk_init_network_req", Long.valueOf(l.longValue() - this.f1277a.longValue()));
        }
        Long l2 = this.h;
        if (l2 != null && this.b != null) {
            hashMap.put("sdk_got_response_from_markup_url", Long.valueOf(l2.longValue() - this.b.longValue()));
        }
        Long l3 = this.d;
        if (l3 != null && this.h != null) {
            hashMap.put("sdk_parsed_res", Long.valueOf(l3.longValue() - this.h.longValue()));
        }
        Long l4 = this.c;
        if (l4 != null && this.b != null) {
            hashMap.put("sdk_got_server_res", Long.valueOf(l4.longValue() - this.b.longValue()));
        }
        Long l5 = this.d;
        if (l5 != null && this.c != null) {
            hashMap.put("sdk_parsed_res", Long.valueOf(l5.longValue() - this.c.longValue()));
        }
        Long l6 = this.e;
        if (l6 != null && this.d != null) {
            hashMap.put("ad_loaded_result", Long.valueOf(l6.longValue() - this.d.longValue()));
        }
        Long l7 = this.f;
        if (l7 != null && this.e != null) {
            hashMap.put("publisher_notified", Long.valueOf(l7.longValue() - this.e.longValue()));
        }
        Long l8 = this.g;
        if (l8 != null && this.f1277a != null) {
            hashMap.put("roundtrip", Long.valueOf(l8.longValue() - this.f1277a.longValue()));
        }
        return hashMap;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MetricsCollectorData{");
        if (this.f1277a != null && this.b != null) {
            sb.append(" sdk_init_network_req=").append(this.b.longValue() - this.f1277a.longValue());
        }
        if (this.h != null && this.b != null) {
            sb.append(", sdk_got_response_from_markup_url=").append(this.h.longValue() - this.b.longValue());
        }
        if (this.c != null && this.b != null) {
            sb.append(", sdk_got_server_res=").append(this.c.longValue() - this.b.longValue());
        }
        if (this.d != null && this.c != null) {
            sb.append(", sdk_parsed_res=").append(this.d.longValue() - this.c.longValue());
        }
        if (this.e != null && this.d != null) {
            sb.append(", ad_loaded_result=").append(this.e.longValue() - this.d.longValue());
        }
        if (this.f != null && this.e != null) {
            sb.append(", publisher_notified=").append(this.f.longValue() - this.e.longValue());
        }
        if (this.g != null && this.f1277a != null) {
            sb.append(", roundtrip=").append(this.g.longValue() - this.f1277a.longValue());
        }
        sb.append(" }");
        return sb.toString();
    }
}
