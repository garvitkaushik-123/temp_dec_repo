package io.bidmachine.media3.common;

import io.bidmachine.media3.common.Player;
import io.bidmachine.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes7.dex */
public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda39 implements ListenerSet.Event {
    @Override // io.bidmachine.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRenderedFirstFrame();
    }
}
