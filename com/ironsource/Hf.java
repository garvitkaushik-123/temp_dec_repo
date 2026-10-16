package com.ironsource;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class Hf {

    /* renamed from: a, reason: collision with root package name */
    private final D0 f2905a;

    public Hf(D0 d0) {
        this.f2905a = d0;
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        this.f2905a.a(A0.COLLECT_TOKENS_COMPLETED, hashMap);
    }

    public void b(Map<String, Object> map, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        this.f2905a.a(A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT, hashMap);
    }

    public void a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        this.f2905a.a(A0.COLLECT_TOKENS_FAILED, hashMap);
    }

    public void a() {
        this.f2905a.a(A0.COLLECT_TOKEN, new HashMap());
    }

    public void a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        this.f2905a.a(A0.INSTANCE_COLLECT_TOKEN, hashMap);
    }

    public void a(Map<String, Object> map, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        this.f2905a.a(A0.INSTANCE_COLLECT_TOKEN_SUCCESS, hashMap);
    }

    public void a(Map<String, Object> map, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        this.f2905a.a(A0.INSTANCE_COLLECT_TOKEN_FAILED, hashMap);
    }
}
