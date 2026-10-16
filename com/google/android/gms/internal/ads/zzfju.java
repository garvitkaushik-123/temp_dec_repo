package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfju {
    private final zzehb zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfco zzf;
    private final zzfcp zzg;
    private final Clock zzh;
    private final zzavu zzi;

    public zzfju(zzehb zzehbVar, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfco zzfcoVar, zzfcp zzfcpVar, Clock clock, zzavu zzavuVar) {
        this.zza = zzehbVar;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfcoVar;
        this.zzg = zzfcpVar;
        this.zzh = clock;
        this.zzi = zzavuVar;
    }

    public static String zzc(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzg(String str) {
        return TextUtils.isEmpty(str) ? "" : com.google.android.gms.ads.internal.util.client.zzl.zzk() ? "fakeForAdDebugLog" : str;
    }

    public final List zzd(zzfcn zzfcnVar, zzfca zzfcaVar, List list) {
        return zze(zzfcnVar, zzfcaVar, false, "", "", list, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0106, code lost:
    
        if (r2 == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zze(zzfcn zzfcnVar, zzfca zzfcaVar, boolean z, String str, String str2, List list, zzcuu zzcuuVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String zzc = zzc(zzc(zzc((String) it.next(), "@gw_adlocid@", zzfcnVar.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? "0" : "1"), "@gw_sdkver@", this.zzb);
            if (zzfcaVar != null) {
                String zzc2 = zzc(zzc(zzc(zzc, "@gw_qdata@", zzfcaVar.zzy), "@gw_adnetid@", zzfcaVar.zzx), "@gw_allocid@", zzfcaVar.zzw);
                Context context = this.zze;
                zzc = zzbyq.zzc(zzc2, context, zzfcaVar.zzW, zzfcaVar.zzaw);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznK)).booleanValue() && zzfcaVar.zze == 4) {
                    com.google.android.gms.ads.internal.zzv.zzr();
                    zzc = zzc(zzc, "@gw_aps@", true == com.google.android.gms.ads.internal.util.zzs.zzH(context) ? "1" : "0");
                }
            }
            zzehb zzehbVar = this.zza;
            String zzc3 = zzc(zzc(zzc(zzc(zzc, "@gw_adnetstatus@", zzehbVar.zzg()), "@gw_ttr@", Long.toString(zzehbVar.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznR)).booleanValue()) {
                zzc3 = (zzcuuVar == null || zzcuuVar.zza() <= 0) ? zzc(zzc3, "@gw_placement_id@", "") : zzc(zzc3, "@gw_placement_id@", Long.toString(zzcuuVar.zza(), 10));
            }
            boolean z3 = false;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdO)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean z4 = !isEmpty;
            if (z3) {
                z2 = z4;
            }
            if (this.zzi.zzf(Uri.parse(zzc3))) {
                Uri.Builder buildUpon = Uri.parse(zzc3).buildUpon();
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzc3 = buildUpon.build().toString();
                arrayList.add(zzc3);
            }
            arrayList.add(zzc3);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0065 A[LOOP:0: B:10:0x005f->B:12:0x0065, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzf(zzfca zzfcaVar, List list, zzbwc zzbwcVar) {
        zzfco zzfcoVar;
        zzfvn zzd;
        Iterator it;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzh.currentTimeMillis();
        try {
            String zzc = zzbwcVar.zzc();
            String num = Integer.toString(zzbwcVar.zzb());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdP)).booleanValue()) {
                zzfcp zzfcpVar = this.zzg;
                if (zzfcpVar == null) {
                    zzd = zzfvn.zzc();
                    String str = (String) zzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjs
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj) {
                            String zzg;
                            zzg = zzfju.zzg(((zzfco) obj).zza);
                            return zzg;
                        }
                    }).zzb("");
                    String str2 = (String) zzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjt
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj) {
                            String zzg;
                            zzg = zzfju.zzg(((zzfco) obj).zzb);
                            return zzg;
                        }
                    }).zzb("");
                    it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(zzbyq.zzc(zzc(zzc(zzc(zzc(zzc(zzc((String) it.next(), "@gw_rwd_userid@", Uri.encode(str)), "@gw_rwd_custom_data@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(zzc)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzb), this.zze, zzfcaVar.zzW, zzfcaVar.zzaw));
                    }
                    return arrayList;
                }
                zzfcoVar = zzfcpVar.zza;
            } else {
                zzfcoVar = this.zzf;
            }
            zzd = zzfvn.zzd(zzfcoVar);
            String str3 = (String) zzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjs
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj) {
                    String zzg;
                    zzg = zzfju.zzg(((zzfco) obj).zza);
                    return zzg;
                }
            }).zzb("");
            String str22 = (String) zzd.zza(new zzfve() { // from class: com.google.android.gms.internal.ads.zzfjt
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj) {
                    String zzg;
                    zzg = zzfju.zzg(((zzfco) obj).zzb);
                    return zzg;
                }
            }).zzb("");
            it = list.iterator();
            while (it.hasNext()) {
            }
            return arrayList;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
