package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeq implements zzds {
    private Message zza;

    private zzeq() {
        throw null;
    }

    /* synthetic */ zzeq(zzer zzerVar) {
    }

    public final zzeq zzb(Message message, zzes zzesVar) {
        this.zza = message;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzds
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        this.zza = null;
        zzes.zzm(this);
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzes.zzm(this);
        return sendMessageAtFrontOfQueue;
    }
}
