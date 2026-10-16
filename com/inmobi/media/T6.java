package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class T6 implements Ja {
    public T6(AdConfig.PingsV2Config pingsConfig) {
        Intrinsics.checkNotNullParameter(pingsConfig, "pingsConfig");
    }

    @Override // com.inmobi.media.Ja
    public final Object a(C2976za ping) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        N9 mRequest = new N9(ping.f2774a, null);
        HashMap hashMap = new HashMap(ping.c);
        hashMap.put("user-agent", Uc.k());
        mRequest.i.putAll(hashMap);
        mRequest.x = false;
        mRequest.t = false;
        mRequest.u = false;
        mRequest.r = ping.d;
        Intrinsics.checkNotNullParameter(mRequest, "request");
        Intrinsics.checkNotNullParameter(mRequest, "mRequest");
        return mRequest.b();
    }
}
