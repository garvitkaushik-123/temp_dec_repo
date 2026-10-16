package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbcj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzebd implements zzgdj {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzebe zzb;

    zzebd(zzebe zzebeVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzebeVar);
        this.zzb = zzebeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    @Override // com.google.android.gms.internal.ads.zzgdj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<String> emptyList;
        List asList;
        char c;
        zzebe zzebeVar = this.zzb;
        zzcva zzcvaVar = (zzcva) obj;
        if (zzebeVar.zzf()) {
            return;
        }
        Bundle bundle = zzcvaVar.zza;
        Object obj2 = bundle.get("ad_types");
        if (obj2 instanceof List) {
            asList = (List) obj2;
        } else {
            if (!(obj2 instanceof String[])) {
                emptyList = Collections.emptyList();
                final ArrayList arrayList = new ArrayList();
                for (String str : emptyList) {
                    switch (str.hashCode()) {
                        case -1396342996:
                            if (str.equals("banner")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1052618729:
                            if (str.equals("native")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -239580146:
                            if (str.equals("rewarded")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 604727084:
                            if (str.equals("interstitial")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    arrayList.add(c != 0 ? c != 1 ? c != 2 ? c != 3 ? zzbcj.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzbcj.zzd.zza.REWARD_BASED_VIDEO_AD : zzbcj.zzd.zza.NATIVE_APP_INSTALL : zzbcj.zzd.zza.INTERSTITIAL : zzbcj.zzd.zza.BANNER);
                }
                final zzbcj.zzaf.zzd zzb = zzebe.zzb(zzebeVar, bundle);
                final zzbcj.zzab zza = zzebe.zza(zzebeVar, bundle);
                final boolean z = this.zza;
                zzebeVar.zza.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebc
                    @Override // com.google.android.gms.internal.ads.zzfge
                    public final Object zza(Object obj3) {
                        zzeaw zzeawVar;
                        zzebe zzebeVar2 = zzebd.this.zzb;
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                        if (zzebeVar2.zzf()) {
                            return null;
                        }
                        zzbcj.zzaf.zzd zzdVar = zzb;
                        zzbcj.zzab zzabVar = zza;
                        ArrayList arrayList2 = arrayList;
                        boolean z2 = z;
                        byte[] zze = zzebe.zze(zzebeVar2, z2, arrayList2, zzabVar, zzdVar);
                        zzebh.zzf(sQLiteDatabase, z2, true);
                        zzeawVar = zzebeVar2.zzf;
                        zzebh.zzc(sQLiteDatabase, zzeawVar.zzd(), zze);
                        return null;
                    }
                });
            }
            asList = Arrays.asList((String[]) obj2);
        }
        ArrayList arrayList2 = new ArrayList(asList.size());
        for (Object obj3 : asList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        emptyList = Collections.unmodifiableList(arrayList2);
        final ArrayList arrayList3 = new ArrayList();
        while (r1.hasNext()) {
        }
        final zzbcj.zzaf.zzd zzb2 = zzebe.zzb(zzebeVar, bundle);
        final zzbcj.zzab zza2 = zzebe.zza(zzebeVar, bundle);
        final boolean z2 = this.zza;
        zzebeVar.zza.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebc
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj32) {
                zzeaw zzeawVar;
                zzebe zzebeVar2 = zzebd.this.zzb;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj32;
                if (zzebeVar2.zzf()) {
                    return null;
                }
                zzbcj.zzaf.zzd zzdVar = zzb2;
                zzbcj.zzab zzabVar = zza2;
                ArrayList arrayList22 = arrayList3;
                boolean z22 = z2;
                byte[] zze = zzebe.zze(zzebeVar2, z22, arrayList22, zzabVar, zzdVar);
                zzebh.zzf(sQLiteDatabase, z22, true);
                zzeawVar = zzebeVar2.zzf;
                zzebh.zzc(sQLiteDatabase, zzeawVar.zzd(), zze);
                return null;
            }
        });
    }
}
