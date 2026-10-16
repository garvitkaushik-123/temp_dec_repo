package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class U8 {

    /* renamed from: a, reason: collision with root package name */
    private final D0 f3075a;

    public U8(D0 d0) {
        this.f3075a = d0;
    }

    public void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_EXT1, str + "|" + str2);
        this.f3075a.a(A0.INIT_STARTED, hashMap);
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        this.f3075a.a(A0.INIT_ENDED, hashMap);
    }

    public void a() {
        this.f3075a.a(A0.INIT_SUCCESS, null);
    }

    public void a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("reason", str);
        this.f3075a.a(A0.INIT_FAILED, hashMap);
    }
}
