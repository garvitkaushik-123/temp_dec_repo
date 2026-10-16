package com.ironsource;

import android.app.Activity;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes6.dex */
public interface Od {
    void a(Activity activity);

    void a(String str, String str2, int i);

    void a(String str, String str2, String str3, Map<String, String> map, InterfaceC3318tc interfaceC3318tc);

    void a(String str, String str2, String str3, Map<String, String> map, InterfaceC3403yc interfaceC3403yc);

    void a(JSONObject jSONObject);

    boolean a(String str);

    void b(JSONObject jSONObject);

    void c(JSONObject jSONObject);

    void onPause(Activity activity);

    void onResume(Activity activity);
}
