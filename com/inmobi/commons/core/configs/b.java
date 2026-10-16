package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.media.C2825q6;
import com.inmobi.media.C2826q7;
import com.inmobi.media.C2866t;
import com.inmobi.media.C2882u;
import com.inmobi.media.C2898v;
import com.inmobi.media.Dc;
import com.inmobi.media.Ec;
import com.inmobi.media.U6;

/* loaded from: classes4.dex */
public final class b {
    public static C2825q6 a() {
        return new C2825q6().a(new Ec("cache", AdConfig.class), (Dc) new C2826q7(new a(), AdConfig.CacheConfig.class)).a(new Ec("allowedContentType", AdConfig.VastVideoConfig.class), (Dc) new U6(new C2866t(), String.class)).a(new Ec("gestures", AdConfig.RenderingConfig.class), (Dc) new U6(new C2882u(), Integer.TYPE)).a(new Ec("skipFields", AdConfig.ContextualDataConfig.class), (Dc) new U6(new C2898v(), String.class));
    }
}
