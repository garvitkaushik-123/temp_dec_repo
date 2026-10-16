package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzaqd implements Comparable {
    private final zzaqo zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzaqh zzf;
    private Integer zzg;
    private zzaqg zzh;
    private boolean zzi;
    private zzapm zzj;
    private zzaqc zzk;
    private final zzapr zzl;

    public zzaqd(int i, String str, zzaqh zzaqhVar) {
        Uri parse;
        String host;
        this.zza = zzaqo.zza ? new zzaqo() : null;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzaqhVar;
        this.zzl = new zzapr();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaqd) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(valueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzapm zzd() {
        return this.zzj;
    }

    public final zzaqd zze(zzapm zzapmVar) {
        this.zzj = zzapmVar;
        return this;
    }

    public final zzaqd zzf(zzaqg zzaqgVar) {
        this.zzh = zzaqgVar;
        return this;
    }

    public final zzaqd zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    protected abstract zzaqj zzh(zzapz zzapzVar);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzapl {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaqo.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzaqm zzaqmVar) {
        zzaqh zzaqhVar;
        synchronized (this.zze) {
            zzaqhVar = this.zzf;
        }
        zzaqhVar.zza(zzaqmVar);
    }

    protected abstract void zzo(Object obj);

    final void zzp(String str) {
        zzaqg zzaqgVar = this.zzh;
        if (zzaqgVar != null) {
            zzaqgVar.zzb(this);
        }
        if (zzaqo.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaqb(this, str, id));
                return;
            }
            zzaqo zzaqoVar = this.zza;
            zzaqoVar.zza(str, id);
            zzaqoVar.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    final void zzr() {
        zzaqc zzaqcVar;
        synchronized (this.zze) {
            zzaqcVar = this.zzk;
        }
        if (zzaqcVar != null) {
            zzaqcVar.zza(this);
        }
    }

    final void zzs(zzaqj zzaqjVar) {
        zzaqc zzaqcVar;
        synchronized (this.zze) {
            zzaqcVar = this.zzk;
        }
        if (zzaqcVar != null) {
            zzaqcVar.zzb(this, zzaqjVar);
        }
    }

    final void zzt(int i) {
        zzaqg zzaqgVar = this.zzh;
        if (zzaqgVar != null) {
            zzaqgVar.zzc(this, i);
        }
    }

    final void zzu(zzaqc zzaqcVar) {
        synchronized (this.zze) {
            this.zzk = zzaqcVar;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzapl {
        return null;
    }

    public final zzapr zzy() {
        return this.zzl;
    }
}
