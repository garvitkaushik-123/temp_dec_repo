package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.x;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class h implements com.fyber.inneractive.sdk.response.i {

    /* renamed from: a, reason: collision with root package name */
    public URL f1271a;
    public String b;
    public String d;
    public String e;
    public String f;
    public final HashMap c = new HashMap();
    public boolean g = false;

    public final void a(x xVar, String str) {
        List list = (List) this.c.get(xVar);
        if (list == null) {
            list = new ArrayList();
            this.c.put(xVar, list);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        list.add(str);
    }

    public final boolean b() {
        if (!this.g || this.f1271a == null) {
            return false;
        }
        String str = this.b;
        if (str != null) {
            return !TextUtils.isEmpty(str) && this.b.equalsIgnoreCase(CampaignEx.KEY_OMID);
        }
        return true;
    }

    public final String toString() {
        return "Verification{mJavaScriptResource=" + this.f1271a + ", mTrackingEvents=" + this.c + ", mVerificationParameters='" + this.d + "', mVendor='" + this.e + "'}";
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(x xVar) {
        HashMap hashMap;
        if (xVar == null || (hashMap = this.c) == null) {
            return null;
        }
        return (List) hashMap.get(xVar);
    }

    public final String a() {
        if (!this.g) {
            return "JavaScriptResource = ";
        }
        if (TextUtils.isEmpty(this.b)) {
            return "apiFramework = ";
        }
        if (!this.b.equalsIgnoreCase(CampaignEx.KEY_OMID)) {
            return "apiFramework = " + this.b;
        }
        return "JavaScriptResource_url = " + (TextUtils.isEmpty(this.f) ? "" : this.f);
    }
}
