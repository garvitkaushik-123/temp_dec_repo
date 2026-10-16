package com.applovin.impl;

import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class q1 extends d2 {
    private JSONObject i;

    public q1(com.applovin.impl.sdk.k kVar) {
        super(kVar, c2.b.ERROR);
    }

    public void a(String str, Throwable th) {
        a(str, th, new HashMap());
    }

    public void b() {
        this.i = JsonUtils.deserialize((String) this.f432a.a(v4.I));
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(String str, String str2, Throwable th) {
        a(str, str2, th, new HashMap());
    }

    public void a(String str, String str2, Throwable th, Map map) {
        a(str + ":" + str2, th, map);
    }

    public void b(final String str, final String str2, final Throwable th) {
        this.f432a.r0().a((g5) new p6(this.f432a, "reportCaughtException", new Runnable() { // from class: com.applovin.impl.q1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                q1.this.a(str, str2, th);
            }
        }), b6.b.OTHER);
    }

    public void a(String str, Throwable th, Map map) {
        map.put("source", str);
        map.put("top_main_method", th.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        for (Throwable th2 : th.getSuppressed()) {
            HashMap hashMap = new HashMap();
            CollectionUtils.putStringIfValid("source", str, hashMap);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), hashMap);
            CollectionUtils.putStringIfValid("suppressed_throwable", th2.toString(), hashMap);
            arrayList.add(hashMap);
        }
        a(c2.A0, arrayList, 0L);
    }

    public void a(String str, String str2, com.applovin.impl.sdk.ad.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        hashMap.put("error_message", str2);
        if (bVar != null) {
            hashMap.putAll(e2.a((AppLovinAdImpl) bVar));
            hashMap.putAll(e2.a(bVar));
            boolean O0 = bVar.O0();
            hashMap.put("is_video_stream", String.valueOf(O0));
            if (O0 && (bVar instanceof com.applovin.impl.sdk.ad.a)) {
                CollectionUtils.putStringIfValid("video_url", ((com.applovin.impl.sdk.ad.a) bVar).u1(), hashMap);
            } else {
                CollectionUtils.putStringIfValid("video_url", bVar.S(), hashMap);
            }
        }
        d(c2.F0, hashMap);
    }

    public void a(String str, String str2, int i, String str3) {
        List a2 = a(str2);
        boolean z = a2 != null;
        if (z && a2.contains(Integer.valueOf(i))) {
            return;
        }
        if (z || i >= 400) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("source", str);
            hashMap.put("url", StringUtils.emptyIfNull(str2));
            hashMap.put("code", String.valueOf(i));
            hashMap.put("error_message", e2.a(str3));
            d(c2.I0, hashMap);
        }
    }

    private List a(String str) {
        List<Integer> integerList = JsonUtils.getIntegerList(this.i, StringUtils.getHost(str), null);
        return integerList == null ? JsonUtils.getIntegerList(this.i, EventTaskParams.STATE_GROUP_DEFAULT, null) : integerList;
    }
}
