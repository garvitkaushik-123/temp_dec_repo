package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public interface c extends k, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k {
    int R();

    Flow<d> a();

    StateFlow<Boolean> isPlaying();

    void s();
}
