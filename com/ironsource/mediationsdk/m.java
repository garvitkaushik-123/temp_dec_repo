package com.ironsource.mediationsdk;

import com.ironsource.C3132ib;
import com.ironsource.C3207n2;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private HashSet<ImpressionDataListener> f3548a;
    protected com.ironsource.r b;
    protected IronSourceSegment c;
    protected AdInfo d;

    public m(HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        new HashSet();
        this.f3548a = hashSet;
        this.b = new com.ironsource.r();
        this.c = ironSourceSegment;
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f3548a.remove(impressionDataListener);
        }
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f3548a.add(impressionDataListener);
        }
    }

    public void c() {
        synchronized (this) {
            this.f3548a.clear();
        }
    }

    protected String e() {
        return "fallback_" + System.currentTimeMillis();
    }

    public void f() {
        this.d = null;
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.c = ironSourceSegment;
    }

    public void a(ImpressionData impressionData, C3132ib c3132ib) {
        if (impressionData != null) {
            this.d = new AdInfo(impressionData, c3132ib);
        }
    }

    protected void a(C3207n2 c3207n2, String str) {
        HashSet hashSet;
        if (c3207n2 != null) {
            ImpressionData a2 = c3207n2.a(str);
            if (a2 != null) {
                synchronized (this) {
                    hashSet = (HashSet) this.f3548a.clone();
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ImpressionDataListener impressionDataListener = (ImpressionDataListener) it.next();
                    IronLog.CALLBACK.info("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + a2);
                    impressionDataListener.onImpressionSuccess(a2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
    }

    protected void a(JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        this.b.a(ad_unit, jSONObject != null ? jSONObject.optBoolean(d.f, false) : false);
    }

    protected void a(IronSource.AD_UNIT ad_unit) {
        this.b.a(ad_unit, false);
    }
}
