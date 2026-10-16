package com.fyber.inneractive.sdk.config.global.features;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class d extends h {
    public com.fyber.inneractive.sdk.model.vast.a e;

    public d() {
        super("cta_locale");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h b() {
        d dVar = new d();
        a(dVar);
        return dVar;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str) || this.e != null) {
            return;
        }
        this.e = new com.fyber.inneractive.sdk.model.vast.a(a("install_" + str, null), a("skip_ad_" + str, null), a("skip_in_" + str, null));
    }
}
