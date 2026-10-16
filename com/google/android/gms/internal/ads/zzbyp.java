package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbyp {
    static zzbyp zzi;

    public static synchronized zzbyp zzb(Context context) {
        synchronized (zzbyp.class) {
            zzbyp zzbypVar = zzi;
            if (zzbypVar != null) {
                return zzbypVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbde.zza(applicationContext);
            com.google.android.gms.ads.internal.util.zzg zzi2 = com.google.android.gms.ads.internal.zzv.zzp().zzi();
            zzi2.zzp(applicationContext);
            zzbyh zzbyhVar = new zzbyh(null);
            zzbyhVar.zzb(applicationContext);
            zzbyhVar.zzc(com.google.android.gms.ads.internal.zzv.zzD());
            zzbyhVar.zza(zzi2);
            zzbyhVar.zzd(com.google.android.gms.ads.internal.zzv.zzo());
            zzbyp zze = zzbyhVar.zze();
            zzi = zze;
            ((zzbyb) ((zzbyi) zze).zzc.zzb()).zza();
            zzbyt zzbytVar = (zzbyt) ((zzbyi) zzi).zzh.zzb();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaJ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                Map zzw = com.google.android.gms.ads.internal.util.zzs.zzw((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaK));
                Iterator it = zzw.keySet().iterator();
                while (it.hasNext()) {
                    zzbytVar.zzc((String) it.next());
                }
                zzbytVar.zzd(new zzbyr(zzbytVar, zzw));
            }
            return zzi;
        }
    }

    abstract zzbyf zza();
}
