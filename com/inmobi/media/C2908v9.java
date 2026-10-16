package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.v9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2908v9 extends AbstractC2843r9 {
    public final /* synthetic */ D9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2908v9(D9 d9) {
        super(d9);
        this.e = d9;
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ImageView(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof ImageView) {
            D9.a(this.e, (ImageView) view, asset);
        }
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
            super.a(view);
        }
    }
}
