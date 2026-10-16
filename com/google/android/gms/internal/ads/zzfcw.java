package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfcw {
    public final com.google.android.gms.ads.internal.client.zzgc zza;
    public final zzbmp zzb;
    public final zzeky zzc;
    public final com.google.android.gms.ads.internal.client.zzm zzd;
    public final com.google.android.gms.ads.internal.client.zzr zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbge zzi;
    public final com.google.android.gms.ads.internal.client.zzx zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzco zzn;
    public final zzfcj zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final boolean zzr;
    public final Bundle zzs;
    public final AtomicLong zzt;
    public final com.google.android.gms.ads.internal.client.zzcs zzu;

    /* synthetic */ zzfcw(zzfcu zzfcuVar, zzfcv zzfcvVar) {
        com.google.android.gms.ads.internal.client.zzr zzrVar;
        String str;
        com.google.android.gms.ads.internal.client.zzcs zzcsVar;
        com.google.android.gms.ads.internal.client.zzm zzmVar;
        com.google.android.gms.ads.internal.client.zzm zzmVar2;
        com.google.android.gms.ads.internal.client.zzm zzmVar3;
        com.google.android.gms.ads.internal.client.zzm zzmVar4;
        com.google.android.gms.ads.internal.client.zzm zzmVar5;
        com.google.android.gms.ads.internal.client.zzm zzmVar6;
        com.google.android.gms.ads.internal.client.zzm zzmVar7;
        com.google.android.gms.ads.internal.client.zzm zzmVar8;
        com.google.android.gms.ads.internal.client.zzm zzmVar9;
        com.google.android.gms.ads.internal.client.zzm zzmVar10;
        com.google.android.gms.ads.internal.client.zzm zzmVar11;
        com.google.android.gms.ads.internal.client.zzm zzmVar12;
        com.google.android.gms.ads.internal.client.zzm zzmVar13;
        com.google.android.gms.ads.internal.client.zzm zzmVar14;
        com.google.android.gms.ads.internal.client.zzm zzmVar15;
        com.google.android.gms.ads.internal.client.zzm zzmVar16;
        com.google.android.gms.ads.internal.client.zzm zzmVar17;
        com.google.android.gms.ads.internal.client.zzm zzmVar18;
        com.google.android.gms.ads.internal.client.zzm zzmVar19;
        com.google.android.gms.ads.internal.client.zzm zzmVar20;
        com.google.android.gms.ads.internal.client.zzm zzmVar21;
        com.google.android.gms.ads.internal.client.zzm zzmVar22;
        com.google.android.gms.ads.internal.client.zzm zzmVar23;
        com.google.android.gms.ads.internal.client.zzm zzmVar24;
        com.google.android.gms.ads.internal.client.zzm zzmVar25;
        com.google.android.gms.ads.internal.client.zzm zzmVar26;
        com.google.android.gms.ads.internal.client.zzm zzmVar27;
        com.google.android.gms.ads.internal.client.zzgc zzgcVar;
        zzbge zzbgeVar;
        com.google.android.gms.ads.internal.client.zzgc zzgcVar2;
        zzbge zzbgeVar2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        zzbge zzbgeVar3;
        zzbge zzbgeVar4;
        com.google.android.gms.ads.internal.client.zzx zzxVar;
        int i;
        AdManagerAdViewOptions adManagerAdViewOptions;
        PublisherAdViewOptions publisherAdViewOptions;
        com.google.android.gms.ads.internal.client.zzco zzcoVar;
        zzbmp zzbmpVar;
        zzfch zzfchVar;
        boolean z;
        boolean z2;
        zzeky zzekyVar;
        boolean z3;
        Bundle bundle;
        boolean z4;
        zzrVar = zzfcuVar.zzb;
        this.zze = zzrVar;
        str = zzfcuVar.zzc;
        this.zzf = str;
        zzcsVar = zzfcuVar.zzv;
        this.zzu = zzcsVar;
        zzmVar = zzfcuVar.zza;
        int i2 = zzmVar.zza;
        zzmVar2 = zzfcuVar.zza;
        long j = zzmVar2.zzb;
        zzmVar3 = zzfcuVar.zza;
        Bundle bundle2 = zzmVar3.zzc;
        zzmVar4 = zzfcuVar.zza;
        int i3 = zzmVar4.zzd;
        zzmVar5 = zzfcuVar.zza;
        List list = zzmVar5.zze;
        zzmVar6 = zzfcuVar.zza;
        boolean z5 = zzmVar6.zzf;
        zzmVar7 = zzfcuVar.zza;
        int i4 = zzmVar7.zzg;
        zzmVar8 = zzfcuVar.zza;
        boolean z6 = true;
        if (!zzmVar8.zzh) {
            z4 = zzfcuVar.zze;
            if (!z4) {
                z6 = false;
            }
        }
        zzmVar9 = zzfcuVar.zza;
        String str2 = zzmVar9.zzi;
        zzmVar10 = zzfcuVar.zza;
        com.google.android.gms.ads.internal.client.zzfz zzfzVar = zzmVar10.zzj;
        zzmVar11 = zzfcuVar.zza;
        Location location = zzmVar11.zzk;
        zzmVar12 = zzfcuVar.zza;
        String str3 = zzmVar12.zzl;
        zzmVar13 = zzfcuVar.zza;
        Bundle bundle3 = zzmVar13.zzm;
        zzmVar14 = zzfcuVar.zza;
        Bundle bundle4 = zzmVar14.zzn;
        zzmVar15 = zzfcuVar.zza;
        List list2 = zzmVar15.zzo;
        zzmVar16 = zzfcuVar.zza;
        String str4 = zzmVar16.zzp;
        zzmVar17 = zzfcuVar.zza;
        String str5 = zzmVar17.zzq;
        zzmVar18 = zzfcuVar.zza;
        boolean z7 = zzmVar18.zzr;
        zzmVar19 = zzfcuVar.zza;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzmVar19.zzs;
        zzmVar20 = zzfcuVar.zza;
        int i5 = zzmVar20.zzt;
        zzmVar21 = zzfcuVar.zza;
        String str6 = zzmVar21.zzu;
        zzmVar22 = zzfcuVar.zza;
        List list3 = zzmVar22.zzv;
        zzmVar23 = zzfcuVar.zza;
        int zza = com.google.android.gms.ads.internal.util.zzs.zza(zzmVar23.zzw);
        zzmVar24 = zzfcuVar.zza;
        String str7 = zzmVar24.zzx;
        zzmVar25 = zzfcuVar.zza;
        int i6 = zzmVar25.zzy;
        zzmVar26 = zzfcuVar.zza;
        long j2 = zzmVar26.zzz;
        zzmVar27 = zzfcuVar.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar28 = new com.google.android.gms.ads.internal.client.zzm(i2, j, bundle2, i3, list, z5, i4, z6, str2, zzfzVar, location, str3, bundle3, bundle4, list2, str4, str5, z7, zzcVar, i5, str6, list3, zza, str7, i6, j2, zzmVar27.zzA);
        this.zzd = zzmVar28;
        zzgcVar = zzfcuVar.zzd;
        if (zzgcVar != null) {
            zzgcVar2 = zzfcuVar.zzd;
        } else {
            zzbgeVar = zzfcuVar.zzh;
            if (zzbgeVar != null) {
                zzbgeVar2 = zzfcuVar.zzh;
                zzgcVar2 = zzbgeVar2.zzf;
            } else {
                zzgcVar2 = null;
            }
        }
        this.zza = zzgcVar2;
        arrayList = zzfcuVar.zzf;
        this.zzg = arrayList;
        arrayList2 = zzfcuVar.zzg;
        this.zzh = arrayList2;
        arrayList3 = zzfcuVar.zzf;
        if (arrayList3 == null) {
            zzbgeVar4 = null;
        } else {
            zzbgeVar3 = zzfcuVar.zzh;
            zzbgeVar4 = zzbgeVar3 == null ? new zzbge(new NativeAdOptions.Builder().build()) : zzfcuVar.zzh;
        }
        this.zzi = zzbgeVar4;
        zzxVar = zzfcuVar.zzi;
        this.zzj = zzxVar;
        i = zzfcuVar.zzm;
        this.zzk = i;
        adManagerAdViewOptions = zzfcuVar.zzj;
        this.zzl = adManagerAdViewOptions;
        publisherAdViewOptions = zzfcuVar.zzk;
        this.zzm = publisherAdViewOptions;
        zzcoVar = zzfcuVar.zzl;
        this.zzn = zzcoVar;
        zzbmpVar = zzfcuVar.zzn;
        this.zzb = zzbmpVar;
        zzfchVar = zzfcuVar.zzo;
        this.zzo = new zzfcj(zzfchVar, null);
        z = zzfcuVar.zzp;
        this.zzp = z;
        z2 = zzfcuVar.zzq;
        this.zzq = z2;
        zzekyVar = zzfcuVar.zzr;
        this.zzc = zzekyVar;
        z3 = zzfcuVar.zzs;
        this.zzr = z3;
        bundle = zzfcuVar.zzt;
        this.zzs = bundle;
        this.zzt = zzmVar28.zzA != 0 ? new AtomicLong(zzmVar28.zzA) : zzfcuVar.zzu;
    }

    public final boolean zza() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdx));
    }
}
