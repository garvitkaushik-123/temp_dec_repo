package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.u9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2892u9 extends AbstractC2843r9 {
    public final /* synthetic */ D9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2892u9(D9 d9) {
        super(d9);
        this.e = d9;
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new K4(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof K4) {
            K4 k4 = (K4) view;
            this.e.getClass();
            HashMap hashMap = D9.c;
            k4.setLayoutParams(new ViewGroup.LayoutParams(C2779n9.a(asset.d.f2560a.x), C2779n9.a(asset.d.f2560a.y)));
            k4.setContentMode(asset.d.g);
            Intrinsics.checkNotNull(asset, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeGifAsset");
            k4.setGifImpl((I4) ((C2858s8) asset).y.getValue());
            C2779n9.a(k4, asset.d);
        }
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof K4) {
            ((K4) view).setGifImpl(null);
            super.a(view);
        }
    }
}
