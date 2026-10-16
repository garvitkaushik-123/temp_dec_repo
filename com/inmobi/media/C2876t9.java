package com.inmobi.media;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.t9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2876t9 extends AbstractC2843r9 {
    public final /* synthetic */ D9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2876t9(D9 d9) {
        super(d9);
        this.e = d9;
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Button(context.getApplicationContext());
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof Button) {
            D9.a(this.e, (Button) view, asset);
        }
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof Button) {
            HashMap hashMap = D9.c;
            TextView textView = (TextView) view;
            textView.setTypeface(Typeface.DEFAULT, 0);
            textView.setPaintFlags(textView.getPaintFlags() & (-17));
            textView.setPaintFlags(textView.getPaintFlags() & (-9));
            super.a(view);
        }
    }
}
