package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.impl.adview.e;

/* loaded from: classes2.dex */
public final class h extends e {
    public h(Context context) {
        super(context);
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i) {
        setViewScale(i / 30.0f);
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.INVISIBLE;
    }
}
