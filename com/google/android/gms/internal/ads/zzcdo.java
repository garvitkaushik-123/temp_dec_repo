package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdo implements zzbkf {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = "Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str));
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    @Override // com.google.android.gms.internal.ads.zzbkf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcdn zzcdnVar;
        int i;
        zzccb zzccbVar = (zzccb) obj;
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcdg zzA = com.google.android.gms.ads.internal.zzv.zzA();
        if (map.containsKey("abort")) {
            if (zzA.zzd(zzccbVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer zzb = zzb(map, "periodicReportIntervalMs");
        Integer zzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer zzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcca zzccaVar = new zzcca((String) map.get("flags"));
        boolean z = zzccaVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            zzcdf zzcdfVar = null;
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    i = 0;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            strArr2[i2] = jSONArray.getString(i2);
                        } catch (JSONException unused) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                            strArr = null;
                            if (strArr == null) {
                            }
                            if (!z) {
                            }
                            if (zzcdfVar == null) {
                            }
                        }
                    }
                    strArr = strArr2;
                } catch (JSONException unused2) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (strArr == null) {
                strArr = new String[1];
                strArr[i] = str;
            }
            if (!z) {
                Iterator it = zzA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zzcdf zzcdfVar2 = (zzcdf) it.next();
                    if (zzcdfVar2.zza == zzccbVar && str.equals(zzcdfVar2.zze())) {
                        zzcdfVar = zzcdfVar2;
                        break;
                    }
                }
            } else {
                zzcdfVar = zzA.zza(zzccbVar);
            }
            if (zzcdfVar == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache task is already running.");
                return;
            }
            if (zzccbVar.zzj() == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache requires a dependency provider.");
                return;
            }
            Integer zzb4 = zzb(map, "player");
            if (zzb4 == null) {
                zzb4 = Integer.valueOf(i);
            }
            if (zzb != null) {
                zzccbVar.zzA(zzb.intValue());
            }
            if (zzb2 != null) {
                zzccbVar.zzy(zzb2.intValue());
            }
            if (zzb3 != null) {
                zzccbVar.zzx(zzb3.intValue());
            }
            int intValue = zzb4.intValue();
            zzccy zzccyVar = zzccbVar.zzj().zzb;
            if (intValue > 0) {
                int i3 = zzccaVar.zzg;
                int zzu = zzcbs.zzu();
                if (zzu < i3) {
                    zzcdnVar = new zzcdw(zzccbVar, zzccaVar);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzp)).booleanValue()) {
                        zzu = zzcdt.zzi();
                    }
                    zzcdnVar = zzu < zzccaVar.zzb ? new zzcdt(zzccbVar, zzccaVar) : new zzcdr(zzccbVar);
                }
            } else {
                zzcdnVar = new zzcdq(zzccbVar);
            }
            new zzcdf(zzccbVar, zzcdnVar, str, strArr).zzb();
        } else {
            zzcdf zza = zzA.zza(zzccbVar);
            if (zza == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache must specify a source.");
                return;
            }
            zzcdnVar = zza.zzb;
        }
        Integer zzb5 = zzb(map, "minBufferMs");
        if (zzb5 != null) {
            zzcdnVar.zzs(zzb5.intValue());
        }
        Integer zzb6 = zzb(map, "maxBufferMs");
        if (zzb6 != null) {
            zzcdnVar.zzr(zzb6.intValue());
        }
        Integer zzb7 = zzb(map, "bufferForPlaybackMs");
        if (zzb7 != null) {
            zzcdnVar.zzp(zzb7.intValue());
        }
        Integer zzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (zzb8 != null) {
            zzcdnVar.zzq(zzb8.intValue());
        }
    }
}
