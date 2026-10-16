package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1334a;

    public q0(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.serverapi.d dVar) {
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1334a.put(str, str2);
    }
}
