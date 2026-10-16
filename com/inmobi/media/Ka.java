package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.media3.common.PlaybackException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ka {

    /* renamed from: a, reason: collision with root package name */
    public final Ja f2341a;

    public Ka(AdConfig.PingsV2Config pingsV2Config) {
        Intrinsics.checkNotNullParameter(pingsV2Config, "pingsV2Config");
        this.f2341a = pingsV2Config.getEnableOkhttp() ? new C2650fa(pingsV2Config) : new T6(pingsV2Config);
    }

    public final Da a(C2976za ping) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        Ja ja = this.f2341a;
        Object a2 = ja != null ? ja.a(ping) : null;
        if (a2 instanceof O9) {
            O9 o9 = (O9) a2;
            String str = ping.f2774a;
            o9.a();
            o9.b();
            return new Da(ping, o9.a(), o9.b());
        }
        if (!(a2 instanceof P9)) {
            EnumC2774n4[] enumC2774n4Arr = EnumC2774n4.f2646a;
            return new Da(ping, PlaybackException.ERROR_CODE_NOT_AVAILABLE_IN_REGION, "Ping response is unknown");
        }
        P9 p9 = (P9) a2;
        String str2 = ping.f2774a;
        p9.getClass();
        Integer num = p9.c;
        int intValue = num != null ? num.intValue() : 0;
        I9 i9 = p9.d;
        return new Da(ping, intValue, i9 != null ? i9.b : null);
    }
}
