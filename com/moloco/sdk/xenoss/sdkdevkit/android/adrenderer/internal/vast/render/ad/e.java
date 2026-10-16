package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class e {
    public static final c a(StateFlow<? extends k> currentPlaylistItem, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(currentPlaylistItem, "currentPlaylistItem");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new d(currentPlaylistItem, scope);
    }
}
