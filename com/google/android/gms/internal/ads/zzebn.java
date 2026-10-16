package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.ads.zzbcj;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzebn {
    private final zzbcc zza;
    private final Context zzb;
    private final zzeas zzc;
    private final VersionInfoParcel zzd;

    public zzebn(Context context, VersionInfoParcel versionInfoParcel, zzbcc zzbccVar, zzeas zzeasVar) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbccVar;
        this.zzc = zzeasVar;
    }

    public final void zzb(final boolean z) {
        try {
            this.zzc.zza(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebk
                @Override // com.google.android.gms.internal.ads.zzfge
                public final Object zza(Object obj) {
                    zzebn.zza(zzebn.this, z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error in offline signals database startup: ".concat(valueOf));
        }
    }

    public static /* synthetic */ Void zza(zzebn zzebnVar, boolean z, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            zzebnVar.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(zzbcj.zzaf.zza.zzx(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzgzw e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to deserialize proto from offline signals database:");
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(e.getMessage());
                }
            }
            query.close();
            Context context = zzebnVar.zzb;
            zzbcj.zzaf.zzc zzi = zzbcj.zzaf.zzi();
            zzi.zzv(context.getPackageName());
            zzi.zzy(Build.MODEL);
            zzi.zzA(zzebh.zza(sQLiteDatabase, 0));
            zzi.zzh(arrayList);
            zzi.zzE(zzebh.zza(sQLiteDatabase, 1));
            zzi.zzx(zzebh.zza(sQLiteDatabase, 3));
            zzi.zzF(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
            zzi.zzB(zzebh.zzb(sQLiteDatabase, 2));
            final zzbcj.zzaf zzbr = zzi.zzbr();
            int size = arrayList.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbcj.zzaf.zza zzaVar = (zzbcj.zzaf.zza) arrayList.get(i2);
                if (zzaVar.zzk() == zzbcj.zzq.ENUM_TRUE && zzaVar.zze() > j) {
                    j = zzaVar.zze();
                }
            }
            if (j != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(j));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
            }
            zzbcc zzbccVar = zzebnVar.zza;
            zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzebl
                @Override // com.google.android.gms.internal.ads.zzbcb
                public final void zza(zzbcj.zzt.zza zzaVar2) {
                    zzaVar2.zzW(zzbcj.zzaf.this);
                }
            });
            VersionInfoParcel versionInfoParcel = zzebnVar.zzd;
            zzbcj.zzar.zza zzd = zzbcj.zzar.zzd();
            zzd.zzg(versionInfoParcel.buddyApkVersion);
            zzd.zzi(versionInfoParcel.clientJarVersion);
            zzd.zzh(true != versionInfoParcel.isClientJar ? 2 : 0);
            final zzbcj.zzar zzbr2 = zzd.zzbr();
            zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzebm
                @Override // com.google.android.gms.internal.ads.zzbcb
                public final void zza(zzbcj.zzt.zza zzaVar2) {
                    zzbcj.zzm.zza zzbM = zzaVar2.zzg().zzbM();
                    zzbM.zzw(zzbcj.zzar.this);
                    zzaVar2.zzK(zzbM);
                }
            });
            zzbccVar.zzc(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED);
            zzebh.zze(sQLiteDatabase);
        }
        return null;
    }
}
