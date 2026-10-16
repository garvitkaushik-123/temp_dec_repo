package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.C3230o8;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC3344v4;
import com.ironsource.InterfaceC3361w4;
import com.ironsource.InterfaceC3378x4;
import com.ironsource.R7;
import com.ironsource.V4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class n implements l {

    /* renamed from: a, reason: collision with root package name */
    private final R7 f3751a;
    private final String b;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f3752a;
        final /* synthetic */ f.c b;

        a(l.a aVar, f.c cVar) {
            this.f3752a = aVar;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f3752a == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", false);
                jSONObject.put("reason", n.this.b);
                this.f3752a.a(new f.a(this.b.f(), jSONObject));
            } catch (JSONException e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3378x4 f3753a;
        final /* synthetic */ V4 b;

        b(InterfaceC3378x4 interfaceC3378x4, V4 v4) {
            this.f3753a = interfaceC3378x4;
            this.b = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3753a.a(C3230o8.e.RewardedVideo, this.b.h(), n.this.b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3378x4 f3754a;
        final /* synthetic */ JSONObject b;

        c(InterfaceC3378x4 interfaceC3378x4, JSONObject jSONObject) {
            this.f3754a = interfaceC3378x4;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3754a.b(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3361w4 f3755a;
        final /* synthetic */ V4 b;

        d(InterfaceC3361w4 interfaceC3361w4, V4 v4) {
            this.f3755a = interfaceC3361w4;
            this.b = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3755a.a(C3230o8.e.Interstitial, this.b.h(), n.this.b);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3361w4 f3756a;
        final /* synthetic */ String b;

        e(InterfaceC3361w4 interfaceC3361w4, String str) {
            this.f3756a = interfaceC3361w4;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3756a.a(this.b, n.this.b);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3361w4 f3757a;
        final /* synthetic */ V4 b;

        f(InterfaceC3361w4 interfaceC3361w4, V4 v4) {
            this.f3757a = interfaceC3361w4;
            this.b = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3757a.a(this.b.h(), n.this.b);
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3361w4 f3758a;
        final /* synthetic */ JSONObject b;

        g(InterfaceC3361w4 interfaceC3361w4, JSONObject jSONObject) {
            this.f3758a = interfaceC3361w4;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3758a.d(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3361w4 f3759a;
        final /* synthetic */ V4 b;

        h(InterfaceC3361w4 interfaceC3361w4, V4 v4) {
            this.f3759a = interfaceC3361w4;
            this.b = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3759a.d(this.b.h(), n.this.b);
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3344v4 f3760a;
        final /* synthetic */ Map b;

        i(InterfaceC3344v4 interfaceC3344v4, Map map) {
            this.f3760a = interfaceC3344v4;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3760a.c((String) this.b.get("demandSourceName"), n.this.b);
        }
    }

    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3344v4 f3761a;
        final /* synthetic */ JSONObject b;

        j(InterfaceC3344v4 interfaceC3344v4, JSONObject jSONObject) {
            this.f3761a = interfaceC3344v4;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3761a.c(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    n(String str, R7 r7) {
        this.f3751a = r7;
        this.b = str;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        return false;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(V4 v4) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void g() {
    }

    @Override // com.ironsource.sdk.controller.l
    public C3230o8.c h() {
        return C3230o8.c.Native;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4) {
        if (interfaceC3361w4 != null) {
            a(new f(interfaceC3361w4, v4));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3378x4 interfaceC3378x4) {
        if (interfaceC3378x4 != null) {
            a(new b(interfaceC3378x4, v4));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3378x4 interfaceC3378x4) {
        if (interfaceC3378x4 != null) {
            a(new c(interfaceC3378x4, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3361w4 interfaceC3361w4) {
        if (interfaceC3361w4 != null) {
            a(new d(interfaceC3361w4, v4));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, InterfaceC3361w4 interfaceC3361w4) {
        if (interfaceC3361w4 != null) {
            a(new e(interfaceC3361w4, str));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3361w4 interfaceC3361w4) {
        if (interfaceC3361w4 != null) {
            a(new g(interfaceC3361w4, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4) {
        if (interfaceC3361w4 != null) {
            a(new h(interfaceC3361w4, v4));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3344v4 interfaceC3344v4) {
        if (interfaceC3344v4 != null) {
            interfaceC3344v4.a(C3230o8.e.Banner, v4.h(), this.b);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4, Map<String, String> map, InterfaceC3344v4 interfaceC3344v4) {
        if (interfaceC3344v4 != null) {
            a(new i(interfaceC3344v4, map));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3344v4 interfaceC3344v4) {
        if (interfaceC3344v4 != null) {
            a(new j(interfaceC3344v4, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        a(new a(aVar, cVar));
    }

    void a(Runnable runnable) {
        R7 r7 = this.f3751a;
        if (r7 != null) {
            r7.c(runnable);
        }
    }
}
