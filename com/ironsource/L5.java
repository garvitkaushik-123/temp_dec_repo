package com.ironsource;

import android.util.Log;
import android.util.Pair;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes6.dex */
public class L5 {
    private static final String e = "EventsTracker";

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC3195m7 f2938a;
    private F5 b;
    private F7 c;
    private ExecutorService d;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2939a;

        a(String str) {
            this.f2939a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3218nd c3218nd = new C3218nd();
                ArrayList<Pair<String, String>> d = L5.this.b.d();
                if ("POST".equals(L5.this.b.e())) {
                    c3218nd = C3007b8.b(L5.this.b.b(), this.f2939a, d);
                } else if ("GET".equals(L5.this.b.e())) {
                    c3218nd = C3007b8.a(L5.this.b.b(), this.f2939a, d);
                }
                L5.this.a("response status code: " + c3218nd.f3603a);
            } catch (Exception e) {
                C3260q4.d().a(e);
            }
        }
    }

    public L5(F5 f5, InterfaceC3195m7 interfaceC3195m7) {
        if (f5 == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        }
        if (f5.c() == null) {
            throw new InvalidParameterException("Null formatter not supported ");
        }
        this.b = f5;
        this.f2938a = interfaceC3195m7;
        this.c = f5.c();
        this.d = Executors.newSingleThreadExecutor();
    }

    private void b(String str) {
        this.d.submit(new a(str));
    }

    public void a(String str, Map<String, Object> map) {
        a(String.format(Locale.ENGLISH, "%s %s", str, map.toString()));
        if (this.b.a() && !str.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("eventname", str);
            a(hashMap, this.f2938a.a());
            a(hashMap, map);
            b(this.c.a(hashMap));
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.b.f()) {
            Log.d(e, str);
        }
    }
}
