package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.internal.ads.zzfob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzek {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final Set zzh;
    private final Bundle zzi;
    private final Set zzj;
    private final boolean zzk;
    private final String zzl;
    private final int zzm;
    private long zzn = 0;
    private long zzo;

    public zzek(zzej zzejVar, zzfob zzfobVar) {
        String str;
        List list;
        HashSet hashSet;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z;
        String str4;
        int i2;
        long j;
        this.zzo = 0L;
        str = zzejVar.zzg;
        this.zza = str;
        list = zzejVar.zzh;
        this.zzb = list;
        hashSet = zzejVar.zza;
        this.zzc = Collections.unmodifiableSet(hashSet);
        bundle = zzejVar.zzb;
        this.zzd = bundle;
        hashMap = zzejVar.zzc;
        Collections.unmodifiableMap(hashMap);
        str2 = zzejVar.zzi;
        this.zze = str2;
        str3 = zzejVar.zzj;
        this.zzf = str3;
        i = zzejVar.zzk;
        this.zzg = i;
        hashSet2 = zzejVar.zzd;
        this.zzh = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzejVar.zze;
        this.zzi = bundle2;
        hashSet3 = zzejVar.zzf;
        this.zzj = Collections.unmodifiableSet(hashSet3);
        z = zzejVar.zzl;
        this.zzk = z;
        str4 = zzejVar.zzm;
        this.zzl = str4;
        i2 = zzejVar.zzn;
        this.zzm = i2;
        j = zzejVar.zzo;
        this.zzo = j;
    }

    public final int zza() {
        return this.zzm;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzo;
    }

    public final long zzd() {
        return this.zzn;
    }

    public final Bundle zze(Class cls) {
        Bundle bundle = this.zzd.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zzf() {
        return this.zzi;
    }

    public final Bundle zzg(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final Bundle zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzl;
    }

    public final String zzj() {
        return this.zza;
    }

    public final String zzk() {
        return this.zze;
    }

    public final String zzl() {
        return this.zzf;
    }

    public final List zzm() {
        return new ArrayList(this.zzb);
    }

    public final Set zzn() {
        return this.zzj;
    }

    public final Set zzo() {
        return this.zzc;
    }

    public final void zzp(long j) {
        this.zzn = j;
    }

    @Deprecated
    public final boolean zzq() {
        return this.zzk;
    }

    public final boolean zzr(Context context) {
        RequestConfiguration zzc = zzey.zzf().zzc();
        zzbb.zzb();
        Set set = this.zzh;
        String zzD = com.google.android.gms.ads.internal.util.client.zzf.zzD(context);
        return set.contains(zzD) || zzc.getTestDeviceIds().contains(zzD);
    }
}
