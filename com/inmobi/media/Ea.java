package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ea implements N2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fa f2274a;

    public Ea(Fa fa) {
        this.f2274a = fa;
    }

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof AdConfig) {
            AdConfig.PingsV2Config pingV2 = ((AdConfig) config).getPingV2();
            Fa fa = this.f2274a;
            fa.getClass();
            Intrinsics.checkNotNullParameter(pingV2, "<set-?>");
            fa.f = pingV2;
        }
    }
}
