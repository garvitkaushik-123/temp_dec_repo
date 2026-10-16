package com.ironsource;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.i8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3129i8 {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC3095g8 f3357a;
    private WebView c;
    private String d;
    private String e = "i8";
    private String[] f = {"handleGetViewVisibility"};
    private final String[] g = {C3061e8.h, C3061e8.i, C3061e8.g, "handleGetViewVisibility", C3061e8.j};
    private Zf b = new Zf();

    /* renamed from: com.ironsource.i8$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3358a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ JSONObject d;

        a(String str, String str2, String str3, JSONObject jSONObject) {
            this.f3358a = str;
            this.b = str2;
            this.c = str3;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!C3129i8.this.b(this.f3358a)) {
                    String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.f3358a;
                    Log.e(C3129i8.this.e, str);
                    C3129i8.this.a(this.b, str);
                } else if (this.f3358a.equalsIgnoreCase("handleGetViewVisibility")) {
                    C3129i8.this.e(this.c);
                } else if (this.f3358a.equalsIgnoreCase(C3061e8.j) || this.f3358a.equalsIgnoreCase(C3061e8.i)) {
                    C3129i8.this.a(this.d.getString("params"), this.c, this.b);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.f3358a;
                Log.e(C3129i8.this.e, str2);
                C3129i8.this.a(this.b, str2);
            }
        }
    }

    /* renamed from: com.ironsource.i8$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3359a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.f3359a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3129i8.this.c.evaluateJavascript(this.f3359a, null);
            } catch (Throwable th) {
                C3260q4.d().a(th);
                Log.e(C3129i8.this.e, "injectJavaScriptIntoWebView | Error while trying inject JS into external adUnit: " + this.b + "Android API level: " + Build.VERSION.SDK_INT);
            }
        }
    }

    private void d() {
        if (this.f3357a == null || this.b == null) {
            return;
        }
        a(C3061e8.f3269a, a());
    }

    private boolean h(String str) {
        for (String str2 : this.f) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(WebView webView) {
        this.c = webView;
    }

    public void b() {
        this.f3357a = null;
        this.b = null;
    }

    public String c() {
        return this.d;
    }

    public void e() {
        if (this.f3357a == null || this.b == null) {
            return;
        }
        a(C3061e8.b, a());
    }

    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.d);
            a(str, jSONObject);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void g(String str) {
        this.d = str;
    }

    public void a(InterfaceC3095g8 interfaceC3095g8) {
        this.f3357a = interfaceC3095g8;
    }

    public void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("method");
            if (TextUtils.isEmpty(optString) || !h(optString)) {
                a(jSONObject.optString(C3061e8.v, C3061e8.c), jSONObject);
            } else if (optString.equalsIgnoreCase("handleGetViewVisibility")) {
                a(jSONObject, (String) null, (String) null);
            }
        } catch (JSONException e) {
            C3260q4.d().a(e);
            Log.e(this.e, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        for (String str2 : this.g) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, JSONObject jSONObject) {
        InterfaceC3095g8 interfaceC3095g8 = this.f3357a;
        if (interfaceC3095g8 != null) {
            interfaceC3095g8.a(str, jSONObject);
        }
    }

    private boolean i(String str) {
        return str.equalsIgnoreCase(C3061e8.k);
    }

    public void a(String str, String str2) {
        InterfaceC3095g8 interfaceC3095g8 = this.f3357a;
        if (interfaceC3095g8 != null) {
            interfaceC3095g8.a(str, str2, this.d);
        }
    }

    public void e(String str) throws JSONException {
        JSONObject a2 = this.b.a();
        a2.put("adViewId", this.d);
        a(str, a2);
    }

    void a(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.f3357a == null) {
            C3348v8.a(Md.t, new C3264q8().a(D5.y, "mDelegate is null").a());
        } else {
            R7.f3025a.d(new a(str, str3, str2, jSONObject));
        }
    }

    private void d(String str) {
        R7.f3025a.d(new b("javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}", str));
    }

    public void a(String str, int i, boolean z) {
        this.b.a(str, i, z);
        if (i(str)) {
            d();
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C3061e8.s, this.b.a());
            jSONObject.put(C3061e8.p, jSONObject2);
            jSONObject.put("adViewId", c());
            return jSONObject;
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        a(a(jSONObject).toString(), str, str2);
    }

    public void a(String str, String str2, String str3) throws JSONException {
        if (this.c == null) {
            String str4 = "No external adUnit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.e, str4);
            this.f3357a.a(str3, str4, this.d);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            str = "\"" + str + "\"";
        }
        d(a(str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.d);
        a(str2, jSONObject);
    }

    private String a(String str) {
        return String.format(C3061e8.u, str);
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", jSONObject.getString("id"));
            jSONObject2.put("data", this.b.a());
            return jSONObject2;
        } catch (Exception e) {
            C3260q4.d().a(e);
            Log.e(this.e, "Error while trying execute method buildVisibilityMessageForAdUnit | params: " + jSONObject);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject2;
        }
    }
}
