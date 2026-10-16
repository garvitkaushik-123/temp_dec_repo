package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzac implements RemoteCall {
    public final /* synthetic */ zzax zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzac(zzax zzaxVar, String str) {
        this.zza = zzaxVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzax zzaxVar = this.zza;
        String str = this.zzb;
        zzau zzauVar = new zzau(zzaxVar, (TaskCompletionSource) obj2);
        zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
        zzbs zzbsVar = new zzbs();
        zzbsVar.zza(zzauVar);
        zzbsVar.zzb(str);
        zzdrVar.zzi(zzbsVar.zzc());
    }
}
