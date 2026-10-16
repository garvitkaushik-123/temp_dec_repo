package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f1342a = new JSONObject();

    public final x a(Object obj, String str) {
        try {
            this.f1342a.put(str, obj);
            return this;
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", str, obj);
            return this;
        }
    }
}
