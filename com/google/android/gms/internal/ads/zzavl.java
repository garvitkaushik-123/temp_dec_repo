package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzavl implements Runnable {
    final /* synthetic */ zzavm zza;

    zzavl(zzavm zzavmVar) {
        this.zza = zzavmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        zzfoi zzfoiVar;
        Object obj2;
        zzavm zzavmVar = this.zza;
        obj = zzavmVar.zzo;
        synchronized (obj) {
            z = zzavmVar.zzp;
            if (z) {
                return;
            }
            zzavmVar.zzp = true;
            try {
                zzavm.zzj(zzavmVar);
            } catch (Exception e) {
                zzfoiVar = this.zza.zzh;
                zzfoiVar.zzc(2023, -1L, e);
            }
            zzavm zzavmVar2 = this.zza;
            obj2 = zzavmVar2.zzo;
            synchronized (obj2) {
                zzavmVar2.zzp = false;
            }
        }
    }
}
