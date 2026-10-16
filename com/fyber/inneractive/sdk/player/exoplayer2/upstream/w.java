package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1579a = new HashMap();
    public Map b;

    public final synchronized Map a() {
        if (this.b == null) {
            this.b = Collections.unmodifiableMap(new HashMap(this.f1579a));
        }
        return this.b;
    }
}
