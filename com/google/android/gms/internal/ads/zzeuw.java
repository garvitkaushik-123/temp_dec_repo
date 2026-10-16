package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeuw implements zzeuc {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzgdy zzc;
    private final ScheduledExecutorService zzd;
    private final zzedk zze;
    private final zzfcw zzf;
    private final VersionInfoParcel zzg;

    zzeuw(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzedk zzedkVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzgdyVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzedkVar;
        this.zzf = zzfcwVar;
        this.zzg = versionInfoParcel;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeuw zzeuwVar, final Throwable th) {
        zzeuwVar.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeut
            @Override // java.lang.Runnable
            public final void run() {
                boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkR)).booleanValue();
                Throwable th2 = th;
                if (booleanValue) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzx(th2, "TopicsSignalUnsampled.fetchTopicsSignal");
                } else {
                    com.google.android.gms.ads.internal.zzv.zzp().zzv(th2, "TopicsSignal.fetchTopicsSignal");
                }
            }
        });
        return zzgdn.zzh(th instanceof SecurityException ? new zzeuy("", 2, null) : th instanceof IllegalStateException ? new zzeuy("", 3, null) : th instanceof IllegalArgumentException ? new zzeuy("", 4, null) : th instanceof TimeoutException ? new zzeuy("", 5, null) : new zzeuy("", 0, null));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x009e, code lost:
    
        if (java.util.Arrays.asList(r0.split(",")).contains(r5.zzb.getPackageName()) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
    
        if (r5.zzf.zzd.zzy != com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED.getValue()) goto L10;
     */
    @Override // com.google.android.gms.internal.ads.zzeuc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ListenableFuture zzb() {
        ListenableFuture zzg;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkQ)).booleanValue() && this.zza.zzO()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkU)).booleanValue()) {
            }
            if (this.zzg.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkO)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkP)).intValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkM)).booleanValue()) {
                        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkN);
                        if (!TextUtils.isEmpty(str)) {
                        }
                    }
                    try {
                        zzg = zzgdn.zzo(this.zze.zza(false), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkS)).intValue(), TimeUnit.MILLISECONDS, this.zzd);
                    } catch (Exception e) {
                        zzg = zzgdn.zzg(e);
                    }
                    zzgde zzw = zzgde.zzw(zzg);
                    zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeuu
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj) {
                            GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
                            if (getTopicsResponse == null) {
                                return zzgdn.zzh(new zzeuy("", 1, null));
                            }
                            zzhcy zzc = zzhcz.zzc();
                            for (Topic topic : getTopicsResponse.getTopics()) {
                                zzhcw zzc2 = zzhcx.zzc();
                                zzc2.zzc(topic.getTopicId());
                                zzc2.zza(topic.getModelVersion());
                                zzc2.zzb(topic.getTaxonomyVersion());
                                zzc.zza((zzhcx) zzc2.zzbr());
                            }
                            return zzgdn.zzh(new zzeuy(Base64.encodeToString(((zzhcz) zzc.zzbr()).zzaV(), 1), 1, null));
                        }
                    };
                    zzgdy zzgdyVar = this.zzc;
                    return zzgdn.zzo((zzgde) zzgdn.zzf((zzgde) zzgdn.zzn(zzw, zzgcuVar, zzgdyVar), Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeuv
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj) {
                            return zzeuw.zzc(zzeuw.this, (Throwable) obj);
                        }
                    }, zzgdyVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkS)).intValue(), TimeUnit.MILLISECONDS, this.zzd);
                }
            }
        }
        return zzgdn.zzh(new zzeuy("", -1, null));
    }
}
