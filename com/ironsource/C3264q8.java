package com.ironsource;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;

/* renamed from: com.ironsource.q8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3264q8 {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f3655a = new HashMap<>();

    public HashMap<String, Object> a() {
        return this.f3655a;
    }

    public C3264q8 a(String str, Object obj) {
        if (obj != null) {
            this.f3655a.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }
}
