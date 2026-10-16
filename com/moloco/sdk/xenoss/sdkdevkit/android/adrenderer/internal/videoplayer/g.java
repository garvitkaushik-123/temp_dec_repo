package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class g {
    public static final Flow<Boolean> b(K k, View view) {
        Flow<Boolean> a2;
        return (view == null || (a2 = k.a(view)) == null) ? FlowKt.flowOf(Boolean.FALSE) : a2;
    }
}
