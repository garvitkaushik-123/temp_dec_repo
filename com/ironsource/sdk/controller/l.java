package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.C3230o8;
import com.ironsource.C3368wb;
import com.ironsource.InterfaceC3344v4;
import com.ironsource.InterfaceC3361w4;
import com.ironsource.InterfaceC3378x4;
import com.ironsource.V4;
import com.ironsource.sdk.controller.f;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface l {

    public interface a {
        void a(f.a aVar);
    }

    public interface b {
        void a(C3368wb c3368wb);
    }

    void a();

    void a(Activity activity);

    void a(Context context);

    void a(V4 v4);

    void a(V4 v4, Map<String, String> map, InterfaceC3344v4 interfaceC3344v4);

    void a(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4);

    void a(f.c cVar, a aVar);

    void a(String str, InterfaceC3361w4 interfaceC3361w4);

    void a(String str, String str2, V4 v4, InterfaceC3344v4 interfaceC3344v4);

    void a(String str, String str2, V4 v4, InterfaceC3361w4 interfaceC3361w4);

    void a(String str, String str2, V4 v4, InterfaceC3378x4 interfaceC3378x4);

    void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, InterfaceC3344v4 interfaceC3344v4);

    void a(JSONObject jSONObject, InterfaceC3361w4 interfaceC3361w4);

    void a(JSONObject jSONObject, InterfaceC3378x4 interfaceC3378x4);

    boolean a(String str);

    void b();

    void b(Context context);

    void b(V4 v4);

    void b(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4);

    void b(JSONObject jSONObject);

    void e();

    @Deprecated
    void f();

    void g();

    C3230o8.c h();
}
