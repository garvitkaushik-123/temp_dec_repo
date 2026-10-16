package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.ironsource.xb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3385xb {

    /* renamed from: a, reason: collision with root package name */
    private String f3937a;

    public C3385xb(String str) {
        this.f3937a = str;
    }

    private C3382x8 a() throws Exception {
        C3382x8 c3382x8 = new C3382x8(this.f3937a, "metadata.json");
        if (!c3382x8.exists()) {
            a(c3382x8);
        }
        return c3382x8;
    }

    synchronized JSONObject b() throws Exception {
        return new JSONObject(IronSourceStorageUtils.readFile(a()));
    }

    private void a(C3382x8 c3382x8) throws Exception {
        IronSourceStorageUtils.saveFile(new JSONObject().toString().getBytes(), c3382x8.getPath());
    }

    synchronized boolean b(String str, JSONObject jSONObject) throws Exception {
        JSONObject b;
        b = b();
        JSONObject optJSONObject = b.optJSONObject(str);
        if (optJSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                optJSONObject.putOpt(next, jSONObject.opt(next));
            }
        } else {
            b.putOpt(str, jSONObject);
        }
        return a(b);
    }

    private boolean a(JSONObject jSONObject) throws Exception {
        return IronSourceStorageUtils.saveFile(jSONObject.toString().getBytes(), a().getPath()) != 0;
    }

    synchronized boolean a(String str, JSONObject jSONObject) throws Exception {
        JSONObject b;
        b = b();
        b.put(str, jSONObject);
        return a(b);
    }

    synchronized boolean a(String str) throws Exception {
        JSONObject b = b();
        if (!b.has(str)) {
            return true;
        }
        b.remove(str);
        return a(b);
    }

    boolean a(ArrayList<C3382x8> arrayList) throws Exception {
        Iterator<C3382x8> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!a(it.next().getName())) {
                z = false;
            }
        }
        return z;
    }
}
