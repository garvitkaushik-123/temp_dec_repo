package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfjx implements zzgdj {
    final /* synthetic */ zzfhj zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzcyi zzc;
    final /* synthetic */ zzfjy zzd;

    zzfjx(zzfjy zzfjyVar, zzfhj zzfhjVar, zzfhu zzfhuVar, zzcyi zzcyiVar) {
        this.zza = zzfhjVar;
        this.zzb = zzfhuVar;
        this.zzc = zzcyiVar;
        Objects.requireNonNull(zzfjyVar);
        this.zzd = zzfjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhx zzfhxVar;
        zzfhj zzfhjVar = this.zza;
        if (zzfhjVar == null) {
            return;
        }
        zzfhjVar.zzg(false);
        zzfhu zzfhuVar = this.zzb;
        if (zzfhuVar == null) {
            zzfhxVar = this.zzd.zzf;
            zzfhxVar.zzc(zzfhjVar.zzm());
        } else {
            zzfhuVar.zza(zzfhjVar);
            zzfhuVar.zzh();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a6  */
    @Override // com.google.android.gms.internal.ads.zzgdj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        com.google.android.gms.ads.internal.util.client.zzu zzuVar;
        char c;
        int i;
        int hashCode;
        zzfhx zzfhxVar;
        zzfhj zzfhjVar = this.zza;
        com.google.android.gms.ads.internal.util.client.zzt zztVar = (com.google.android.gms.ads.internal.util.client.zzt) obj;
        if (zzfhjVar != null) {
            zzfhjVar.zzg(zztVar == com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
            zzfhu zzfhuVar = this.zzb;
            if (zzfhuVar == null) {
                zzfhxVar = this.zzd.zzf;
                zzfhxVar.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zza(zzfhjVar);
                zzfhuVar.zzh();
            }
        }
        zzcyi zzcyiVar = this.zzc;
        if (zzcyiVar != null) {
            zzuVar = this.zzd.zzd;
            String zzb = zzuVar.zzb();
            if (TextUtils.isEmpty(zzb)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(zzb);
                Parcelable.Creator<com.google.android.gms.ads.internal.client.zzt> creator = com.google.android.gms.ads.internal.client.zzt.CREATOR;
                String optString = jSONObject.optString("type");
                String optString2 = jSONObject.optString("precision");
                String optString3 = jSONObject.optString("currency");
                long optLong = jSONObject.optLong("value", 0L);
                int hashCode2 = optString.hashCode();
                char c2 = 65535;
                if (hashCode2 == 66934) {
                    if (optString.equals("CPC")) {
                        c = 1;
                        if (c != 0) {
                        }
                        hashCode = optString2.hashCode();
                        if (hashCode == -2131980260) {
                        }
                        zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, c2 == 0 ? c2 != 1 ? c2 != 2 ? 0 : 3 : 2 : 1, optString3, optLong));
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                    hashCode = optString2.hashCode();
                    if (hashCode == -2131980260) {
                    }
                    zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, c2 == 0 ? c2 != 1 ? c2 != 2 ? 0 : 3 : 2 : 1, optString3, optLong));
                }
                if (hashCode2 == 66944) {
                    if (optString.equals("CPM")) {
                        c = 0;
                        if (c != 0) {
                        }
                        hashCode = optString2.hashCode();
                        if (hashCode == -2131980260) {
                        }
                        zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, c2 == 0 ? c2 != 1 ? c2 != 2 ? 0 : 3 : 2 : 1, optString3, optLong));
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                    hashCode = optString2.hashCode();
                    if (hashCode == -2131980260) {
                    }
                    zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, c2 == 0 ? c2 != 1 ? c2 != 2 ? 0 : 3 : 2 : 1, optString3, optLong));
                }
                if (hashCode2 == 1349395245 && optString.equals("ONE_PIXEL")) {
                    c = 2;
                    if (c != 0) {
                        i = 1;
                    } else if (c == 1) {
                        i = 2;
                    } else if (c != 2) {
                        i = 0;
                    } else {
                        optLong /= 1000;
                        i = 3;
                    }
                    hashCode = optString2.hashCode();
                    if (hashCode == -2131980260) {
                        if (hashCode != 399232571) {
                            if (hashCode == 1271254246 && optString2.equals("PUBLISHER_PROVIDED")) {
                                c2 = 1;
                            }
                        } else if (optString2.equals("PRECISE")) {
                            c2 = 2;
                        }
                    } else if (optString2.equals("ESTIMATED")) {
                        c2 = 0;
                    }
                    zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, c2 == 0 ? c2 != 1 ? c2 != 2 ? 0 : 3 : 2 : 1, optString3, optLong));
                }
                c = 65535;
                if (c != 0) {
                }
                hashCode = optString2.hashCode();
                if (hashCode == -2131980260) {
                }
                zzcyiVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, c2 == 0 ? c2 != 1 ? c2 != 2 ? 0 : 3 : 2 : 1, optString3, optLong));
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "UrlPinger.pingUrl");
            }
        }
    }
}
