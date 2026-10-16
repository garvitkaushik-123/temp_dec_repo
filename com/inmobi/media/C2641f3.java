package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.f3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2641f3 implements N2 {
    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        List<String> emptyList;
        AdConfig.ContextualDataConfig contextualData;
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this) {
            C2676h3 c2676h3 = C2676h3.f2585a;
            Intrinsics.checkNotNullExpressionValue("h3", "<get-TAG>(...)");
            C2676h3.e = (AdConfig) config;
            String str = C2676h3.g;
            AdConfig adConfig = C2676h3.e;
            if (adConfig == null || (contextualData = adConfig.getContextualData()) == null || (emptyList = contextualData.getSkipFields()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C2692i3.j);
            arrayList.removeAll(emptyList);
            String joinToString$default = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
            C2676h3.g = joinToString$default;
            if (!Intrinsics.areEqual(joinToString$default, str)) {
                c2676h3.e();
            }
            C2676h3.a();
            Unit unit = Unit.INSTANCE;
        }
    }
}
