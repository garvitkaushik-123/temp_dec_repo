package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.g3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2660g3 implements N2 {
    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this) {
            C2676h3 c2676h3 = C2676h3.f2585a;
            Intrinsics.checkNotNullExpressionValue("h3", "<get-TAG>(...)");
            C2676h3.d = (SignalsConfig) config;
            SignalsConfig signalsConfig = C2676h3.d;
            C2676h3.f = AbstractC2710j4.a(signalsConfig != null ? signalsConfig.getKA() : null);
            c2676h3.b();
            Unit unit = Unit.INSTANCE;
        }
    }
}
