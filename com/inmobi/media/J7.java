package com.inmobi.media;

import android.app.Activity;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class J7 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2325a;
    public final /* synthetic */ T7 b;

    public J7(T7 t7, T7 originalContainer) {
        Intrinsics.checkNotNullParameter(originalContainer, "originalContainer");
        this.b = t7;
        this.f2325a = new WeakReference(originalContainer);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        T7 t7;
        Activity context = this.b.f();
        if (context == null) {
            Intrinsics.checkNotNullExpressionValue(this.b.m, "access$getTAG$p(...)");
            return;
        }
        T7 t72 = (T7) this.f2325a.get();
        if (t72 == null || t72.t) {
            return;
        }
        try {
            C2811p8 c2811p8 = t72.b;
            JSONArray jSONArray = c2811p8.f;
            try {
                if (jSONArray != null && !B2.a(jSONArray)) {
                    Intrinsics.checkNotNullExpressionValue(this.b.m, "access$getTAG$p(...)");
                    JSONObject e = c2811p8.e();
                    if (e == null) {
                        return;
                    }
                    boolean z = this.b.f2437a == 0;
                    T7 t73 = this.b;
                    C2811p8 dataModel = new C2811p8(t73.f2437a, e, c2811p8, z, t73.s, t73.j);
                    if (!dataModel.f()) {
                        T7 t74 = this.b;
                        InterfaceC2971z5 interfaceC2971z5 = t74.j;
                        if (interfaceC2971z5 != null) {
                            String str3 = t74.m;
                            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                            ((A5) interfaceC2971z5).b(str3, "Invalid data model for end-card container! End card will not be shown ...");
                            return;
                        }
                        return;
                    }
                    String adImpressionId = this.b.getImpressionId();
                    T7 t75 = this.b;
                    AdConfig adConfig = t75.s;
                    long j = t75.e;
                    boolean z2 = t75.f;
                    String creativeId = t75.getCreativeId();
                    T7 t76 = this.b;
                    S6 s6 = t76.i;
                    InterfaceC2971z5 interfaceC2971z52 = t76.j;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(dataModel, "dataModel");
                    Intrinsics.checkNotNullParameter(adImpressionId, "adImpressionId");
                    Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                    Intrinsics.checkNotNullParameter(creativeId, "creativeId");
                    try {
                        if (dataModel.c().contains("VIDEO")) {
                            try {
                                str2 = "access$getTAG$p(...)";
                                t7 = new C2562a9(context, (byte) 0, dataModel, adImpressionId, null, adConfig, j, z2, creativeId, null, s6, interfaceC2971z52);
                            } catch (Exception e2) {
                                e = e2;
                                str2 = "access$getTAG$p(...)";
                                str = str2;
                                T7 t77 = this.b;
                                InterfaceC2971z5 interfaceC2971z53 = t77.j;
                                if (interfaceC2971z53 != null) {
                                    String str4 = t77.m;
                                    Intrinsics.checkNotNullExpressionValue(str4, str);
                                    ((A5) interfaceC2971z53).a(str4, "Encountered unexpected error in EndCardBuilder: ", e);
                                }
                                S5 s5 = S5.f2425a;
                                S5.d.a(AbstractC2920w5.a(e, "event"));
                                return;
                            }
                        } else {
                            str2 = "access$getTAG$p(...)";
                            t7 = new T7(context, (byte) 0, dataModel, adImpressionId, null, adConfig, j, z2, creativeId, null, s6, interfaceC2971z52);
                        }
                        t7.H = t72.H;
                        t7.v = t72;
                        T7 t78 = this.b;
                        InterfaceC2971z5 interfaceC2971z54 = t78.j;
                        if (interfaceC2971z54 != null) {
                            String str5 = t78.m;
                            Intrinsics.checkNotNullExpressionValue(str5, str2);
                            ((A5) interfaceC2971z54).a(str5, "End-card container built successfully ...");
                        }
                        t72.J = t7;
                        return;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                Intrinsics.checkNotNullExpressionValue(this.b.m, "access$getTAG$p(...)");
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            str = "access$getTAG$p(...)";
        }
    }
}
