package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A9 extends AbstractC2843r9 {
    public final /* synthetic */ D9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A9(D9 d9) {
        super(d9);
        this.e = d9;
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new C2763m9(applicationContext);
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof C2763m9) {
            C2763m9 c2763m9 = (C2763m9) view;
            this.e.getClass();
            HashMap hashMap = D9.c;
            C2779n9.a(c2763m9, asset.d);
            Object obj = asset.u;
            if (obj instanceof Bitmap) {
                c2763m9.setPosterImage((Bitmap) obj);
            }
            c2763m9.getProgressBar().setVisibility(0);
        }
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof C2763m9) {
            C2763m9 c2763m9 = (C2763m9) view;
            c2763m9.getProgressBar().setVisibility(8);
            c2763m9.setPosterImage((Bitmap) null);
            c2763m9.getVideoView().f();
            super.a(view);
        }
    }
}
