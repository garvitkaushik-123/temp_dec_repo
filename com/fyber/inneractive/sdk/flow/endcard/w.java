package com.fyber.inneractive.sdk.flow.endcard;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;

/* loaded from: classes4.dex */
public final class w extends a {
    public Bitmap c;
    public final ImageView d;
    public final ViewGroup e;

    public w(v vVar) {
        super(vVar);
        ImageView imageView = new ImageView(IAConfigManager.O.v.a());
        imageView.setId(R.id.ia_inneractive_vast_endcard_static);
        this.d = imageView;
        this.e = a.a(imageView);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final View b() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.a, com.fyber.inneractive.sdk.flow.endcard.n
    public final void destroy() {
        com.fyber.inneractive.sdk.util.t.a(b());
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.c = null;
        this.d.setImageBitmap(null);
    }
}
