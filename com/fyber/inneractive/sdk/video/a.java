package com.fyber.inneractive.sdk.video;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.cache.m;
import com.fyber.inneractive.sdk.util.s;
import com.fyber.inneractive.sdk.util.u;
import com.fyber.inneractive.sdk.util.v;

/* loaded from: classes4.dex */
public final class a implements u {
    @Override // com.fyber.inneractive.sdk.util.u
    public final boolean a() {
        return TextUtils.equals("vid_cache", "vid_cache") && m.f.c && s.a();
    }

    @Override // com.fyber.inneractive.sdk.util.u
    public final v getType() {
        return v.Video;
    }
}
