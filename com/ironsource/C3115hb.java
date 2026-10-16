package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* renamed from: com.ironsource.hb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3115hb {

    /* renamed from: a, reason: collision with root package name */
    private final D0 f3336a;

    public C3115hb(D0 d0) {
        this.f3336a = d0;
    }

    public void a(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f3336a.a(A0.LOAD_AD, hashMap);
    }

    public void b(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        this.f3336a.a(A0.SKIP_RELOAD_AD, hashMap);
    }

    public void b(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        this.f3336a.a(A0.RELOAD_AD_NO_FILL, hashMap);
    }

    public void a() {
        this.f3336a.a(A0.RELOAD_AD, new HashMap());
    }

    public void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", Integer.valueOf(i));
        this.f3336a.a(A0.DESTROY_AD, hashMap);
    }

    public void a(long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f3336a.a(A0.LOAD_AD_SUCCESS, hashMap);
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        this.f3336a.a(A0.RELOAD_AD_SUCCESS, hashMap);
    }

    public void a(long j, int i, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f3336a.a(A0.LOAD_AD_FAILED, hashMap);
    }

    public void a(long j, int i, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f3336a.a(A0.LOAD_AD_FAILED_WITH_REASON, hashMap);
    }

    public void a(long j, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        this.f3336a.a(A0.RELOAD_AD_FAILED_WITH_REASON, hashMap);
    }

    public void a(boolean z, long j, boolean z2) {
        A0 a0;
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        if (z2) {
            hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS));
            hashMap.put("reason", "loaded ads are expired");
        }
        D0 d0 = this.f3336a;
        if (z) {
            a0 = A0.AD_AVAILABILITY_CHANGED_TRUE;
        } else {
            a0 = A0.AD_AVAILABILITY_CHANGED_FALSE;
        }
        d0.a(a0, hashMap);
    }

    public void a(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        this.f3336a.a(A0.LOAD_AD_NO_FILL, hashMap);
    }

    public void a(Boolean bool, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        this.f3336a.a(bool.booleanValue() ? A0.AD_READY_TRUE : A0.AD_READY_FALSE, hashMap);
    }
}
