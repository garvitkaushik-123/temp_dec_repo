package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.nearby.zznp;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzbv extends zznp {
    zzbv() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((SubscribeCallback) obj).onExpired();
    }
}
