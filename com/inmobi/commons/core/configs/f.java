package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.media.C2618dd;
import com.inmobi.media.C2635ed;
import com.inmobi.media.C2653fd;
import com.inmobi.media.C2670gd;
import com.inmobi.media.C2686hd;
import com.inmobi.media.C2825q6;
import com.inmobi.media.C2826q7;
import com.inmobi.media.Dc;
import com.inmobi.media.Ec;
import com.inmobi.media.U6;

/* loaded from: classes4.dex */
public final class f {
    public static C2825q6 a() {
        return new C2825q6().a(new Ec("carrierNames", SignalsConfig.NovatiqConfig.class), (Dc) new U6(new C2618dd(), String.class)).a(new Ec("control", SignalsConfig.SessionConfig.class), (Dc) new U6(new C2635ed(), Integer.TYPE)).a(new Ec("generalKeys", SignalsConfig.PublisherConfig.class), (Dc) new C2826q7(new C2653fd(), String.class)).a(new Ec("adSpecificKeys", SignalsConfig.PublisherConfig.class), (Dc) new C2826q7(new C2670gd(), String.class)).a(new Ec("versionList", SignalsConfig.Purchases.class), (Dc) new U6(new C2686hd(), String.class));
    }
}
