package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaqq implements zzaqc {
    private final Map zza = new HashMap();
    private final zzapp zzb;
    private final BlockingQueue zzc;
    private final zzapu zzd;

    zzaqq(zzapp zzappVar, BlockingQueue blockingQueue, zzapu zzapuVar) {
        this.zzd = zzapuVar;
        this.zzb = zzappVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final synchronized void zza(zzaqd zzaqdVar) {
        Map map = this.zza;
        String zzj = zzaqdVar.zzj();
        List list = (List) map.remove(zzj);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (zzaqp.zzb) {
            zzaqp.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), zzj);
        }
        zzaqd zzaqdVar2 = (zzaqd) list.remove(0);
        map.put(zzj, list);
        zzaqdVar2.zzu(this);
        try {
            this.zzc.put(zzaqdVar2);
        } catch (InterruptedException e) {
            zzaqp.zzb("Couldn't add request to queue. %s", e.toString());
            Thread.currentThread().interrupt();
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zzb(zzaqd zzaqdVar, zzaqj zzaqjVar) {
        List list;
        zzapm zzapmVar = zzaqjVar.zzb;
        if (zzapmVar == null || zzapmVar.zza(System.currentTimeMillis())) {
            zza(zzaqdVar);
            return;
        }
        String zzj = zzaqdVar.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(zzj);
        }
        if (list != null) {
            if (zzaqp.zzb) {
                zzaqp.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), zzj);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zzb((zzaqd) it.next(), zzaqjVar, null);
            }
        }
    }

    final synchronized boolean zzc(zzaqd zzaqdVar) {
        Map map = this.zza;
        String zzj = zzaqdVar.zzj();
        if (!map.containsKey(zzj)) {
            map.put(zzj, null);
            zzaqdVar.zzu(this);
            if (zzaqp.zzb) {
                zzaqp.zza("new request, sending to network %s", zzj);
            }
            return false;
        }
        List list = (List) map.get(zzj);
        if (list == null) {
            list = new ArrayList();
        }
        zzaqdVar.zzm("waiting-for-response");
        list.add(zzaqdVar);
        map.put(zzj, list);
        if (zzaqp.zzb) {
            zzaqp.zza("Request for cacheKey=%s is in flight, putting on hold.", zzj);
        }
        return true;
    }
}
