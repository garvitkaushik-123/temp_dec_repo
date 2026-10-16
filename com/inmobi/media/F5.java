package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class F5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final C2964ye f2281a;
    public final Be b;

    public F5(C2964ye c2964ye, Be request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f2281a = c2964ye;
        this.b = request;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        while (true) {
            Be be = this.b;
            if (i > be.y) {
                return;
            }
            P9 b = be.b();
            if (this.b.A.get()) {
                return;
            }
            if (b.b()) {
                Intrinsics.checkNotNullExpressionValue("F5", "TAG");
                I9 i9 = b.d;
                if (i == this.b.y) {
                    this.f2281a.a(i9);
                    return;
                }
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(b.a());
                    if (Intrinsics.areEqual(JSONObject.class, JSONObject.class)) {
                        this.f2281a.a(jSONObject);
                    } else {
                        this.f2281a.a(new C2825q6().a(jSONObject, JSONObject.class));
                    }
                    return;
                } catch (Exception e) {
                    Intrinsics.checkNotNullExpressionValue("F5", "TAG");
                    if (i == this.b.y) {
                        C2964ye c2964ye = this.f2281a;
                        EnumC2790o4 enumC2790o4 = EnumC2790o4.l;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Exception while parsing the response";
                        }
                        c2964ye.a(new I9(enumC2790o4, message));
                        return;
                    }
                }
            }
            try {
                Thread.sleep(this.b.z * 1000);
            } catch (InterruptedException unused) {
                Intrinsics.checkNotNullExpressionValue("F5", "TAG");
            }
            if (this.b.A.get()) {
                return;
            } else {
                i++;
            }
        }
    }
}
