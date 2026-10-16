package com.inmobi.media;

import com.inmobi.unifiedId.InMobiUnifiedIdService;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class J5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f2324a;

    public J5(JSONObject jSONObject) {
        this.f2324a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Boolean c = C2881te.f2715a.c();
        boolean booleanValue = c != null ? c.booleanValue() : true;
        if (booleanValue) {
            InMobiUnifiedIdService.reset();
        }
        if (booleanValue) {
            return;
        }
        Q5.a(this.f2324a);
    }
}
