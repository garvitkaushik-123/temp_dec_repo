package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaay {
    private final Context zza;
    private boolean zzb;
    private zztr zzc = zztr.zza;
    private final zztd zzd;
    private Handler zze;
    private zzacj zzf;

    public zzaay(Context context) {
        this.zza = context;
        this.zzd = new zzsx(context, null, null);
    }

    public final zzaay zze(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzaay zzf(zzacj zzacjVar) {
        this.zzf = zzacjVar;
        return this;
    }

    public final zzaay zzg(zztr zztrVar) {
        this.zzc = zztrVar;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r3.zzf != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaba zzh() {
        boolean z;
        zzdd.zzf(!this.zzb);
        Handler handler = this.zze;
        if (handler != null || this.zzf != null) {
            z = false;
            if (handler != null) {
            }
            zzdd.zzf(z);
            this.zzb = true;
            return new zzaba(this);
        }
        z = true;
        zzdd.zzf(z);
        this.zzb = true;
        return new zzaba(this);
    }
}
