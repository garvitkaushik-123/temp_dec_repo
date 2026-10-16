package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.w9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2924w9 extends AbstractC2843r9 {
    public C2924w9(D9 d9) {
        super(d9);
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new J8(applicationContext);
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        HashMap hashMap = D9.c;
        C2779n9.a(view, asset.d);
    }
}
