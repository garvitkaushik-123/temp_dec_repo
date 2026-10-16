package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.MessageListener;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zznl extends zznp {
    final /* synthetic */ List zza;

    zznl(zznm zznmVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        zznm.zzc(this.zza, (MessageListener) obj);
    }
}
