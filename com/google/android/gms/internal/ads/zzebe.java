package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.autofill.HintConstants;
import com.google.android.gms.internal.ads.zzbcj;
import com.ironsource.C3040d4;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzebe extends zzebf {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcvb zzd;
    private final TelephonyManager zze;
    private final zzeaw zzf;
    private zzbcj.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbcj.zzaf.zzd.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbcj.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbcj.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbcj.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbcj.zzaf.zzd.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbcj.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbcj.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbcj.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbcj.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbcj.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbcj.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbcj.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbcj.zzaf.zzd.CONNECTING);
    }

    zzebe(Context context, zzcvb zzcvbVar, zzeaw zzeawVar, zzeas zzeasVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzeasVar, zzgVar);
        this.zzc = context;
        this.zzd = zzcvbVar;
        this.zzf = zzeawVar;
        this.zze = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    static /* bridge */ /* synthetic */ zzbcj.zzab zza(zzebe zzebeVar, Bundle bundle) {
        zzbcj.zzab.zzb zzbVar;
        zzbcj.zzab.zza zza = zzbcj.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzebeVar.zzg = zzbcj.zzq.ENUM_TRUE;
        } else {
            zzebeVar.zzg = zzbcj.zzq.ENUM_FALSE;
            if (i == 0) {
                zza.zzd(zzbcj.zzab.zzc.CELL);
            } else if (i != 1) {
                zza.zzd(zzbcj.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zza.zzd(zzbcj.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbcj.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbcj.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbcj.zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbcj.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zza.zzc(zzbVar);
        }
        return zza.zzbr();
    }

    static /* bridge */ /* synthetic */ zzbcj.zzaf.zzd zzb(zzebe zzebeVar, Bundle bundle) {
        return (zzbcj.zzaf.zzd) zzb.get(zzfdk.zza(zzfdk.zza(bundle, C3040d4.h.G), "network").getInt("active_network_state", -1), zzbcj.zzaf.zzd.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzebe zzebeVar, boolean z, ArrayList arrayList, zzbcj.zzab zzabVar, zzbcj.zzaf.zzd zzdVar) {
        zzbcj.zzaf.zza.C0217zza zzn = zzbcj.zzaf.zza.zzn();
        zzn.zzn(arrayList);
        Context context = zzebeVar.zzc;
        zzn.zzD(zzg(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzn.zzE(com.google.android.gms.ads.internal.zzv.zzs().zzg(context, zzebeVar.zze));
        zzeaw zzeawVar = zzebeVar.zzf;
        zzn.zzM(zzeawVar.zze());
        zzn.zzL(zzeawVar.zzb());
        zzn.zzG(zzeawVar.zza());
        zzn.zzH(zzdVar);
        zzn.zzJ(zzabVar);
        zzn.zzK(zzebeVar.zzg);
        zzn.zzN(zzg(z));
        zzn.zzP(zzeawVar.zzd());
        zzn.zzO(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        zzn.zzQ(zzg(Settings.Global.getInt(context.getContentResolver(), "wifi_on", 0) != 0));
        return zzn.zzbr().zzaV();
    }

    private static final zzbcj.zzq zzg(boolean z) {
        return z ? zzbcj.zzq.ENUM_TRUE : zzbcj.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgdn.zzr(this.zzd.zzb(new Bundle()), new zzebd(this, z), zzcaf.zzg);
    }
}
