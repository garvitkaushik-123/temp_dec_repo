package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.s2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2852s2 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2869t2 f2700a;
    public final InterfaceC2971z5 b;

    public C2852s2(InterfaceC2869t2 mEventHandler, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(mEventHandler, "mEventHandler");
        this.f2700a = mEventHandler;
        this.b = interfaceC2971z5;
    }

    public final void a(C2740l2 click) {
        AdConfig.ImaiConfig imaiConfig;
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(click, "click");
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                String f = C2933x2.f();
                Intrinsics.checkNotNullExpressionValue(f, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).c(f, "ping - " + click.f2628a);
            }
            N9 mRequest = new N9(click.b, this.b);
            HashMap a2 = C2933x2.a(C2933x2.f2748a, click);
            if (!a2.isEmpty()) {
                mRequest.i.putAll(a2);
            }
            mRequest.x = false;
            mRequest.t = false;
            mRequest.u = false;
            Map map = click.c;
            if (map != null && (hashMap = mRequest.j) != null) {
                hashMap.putAll(map);
            }
            mRequest.r = click.d;
            imaiConfig = C2933x2.g;
            if (imaiConfig != null) {
                mRequest.p = imaiConfig.getPingTimeout() * 1000;
                mRequest.q = imaiConfig.getPingTimeout() * 1000;
            }
            Intrinsics.checkNotNullParameter(mRequest, "mRequest");
            P9 b = mRequest.b();
            if (!b.b()) {
                this.f2700a.a(click);
                return;
            }
            I9 i9 = b.d;
            EnumC2790o4 enumC2790o4 = i9 != null ? i9.f2315a : EnumC2790o4.e;
            if (EnumC2790o4.k == enumC2790o4) {
                this.f2700a.a(click);
                return;
            }
            if (!click.d && (EnumC2790o4.v == enumC2790o4 || EnumC2790o4.x == enumC2790o4)) {
                this.f2700a.a(click);
                return;
            }
            boolean z = T9.f2439a;
            if (T9.f2439a && (enumC2790o4 == EnumC2790o4.q || enumC2790o4 == EnumC2790o4.p || enumC2790o4 == EnumC2790o4.o || enumC2790o4 == EnumC2790o4.n || enumC2790o4 == EnumC2790o4.r)) {
                return;
            }
            this.f2700a.a(click, enumC2790o4);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
            InterfaceC2869t2 interfaceC2869t2 = this.f2700a;
            EnumC2790o4 errorCode = EnumC2790o4.e;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            interfaceC2869t2.a(click, errorCode);
        }
    }
}
