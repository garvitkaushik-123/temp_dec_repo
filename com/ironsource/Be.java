package com.ironsource;

import com.ironsource.C3040d4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Be {

    /* renamed from: a, reason: collision with root package name */
    private Ce f2807a;

    public Be(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f2807a = Ce.b.a(config.optInt(C3040d4.a.t, Ce.CurrentlyLoadedAds.b()));
    }

    public final Ce a() {
        return this.f2807a;
    }
}
