package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzazx {
    private final Object zza = new Object();
    private zzazv zzb = null;
    private boolean zzc = false;

    public final Activity zza() {
        synchronized (this.zza) {
            zzazv zzazvVar = this.zzb;
            if (zzazvVar == null) {
                return null;
            }
            return zzazvVar.zza();
        }
    }

    public final Context zzb() {
        synchronized (this.zza) {
            zzazv zzazvVar = this.zzb;
            if (zzazvVar == null) {
                return null;
            }
            return zzazvVar.zzb();
        }
    }

    public final void zzc(zzazw zzazwVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzazv();
            }
            this.zzb.zzf(zzazwVar);
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Can not cast Context to Application");
                } else {
                    if (this.zzb == null) {
                        this.zzb = new zzazv();
                    }
                    this.zzb.zzg(application, context);
                    this.zzc = true;
                }
            }
        }
    }

    public final void zze(zzazw zzazwVar) {
        synchronized (this.zza) {
            zzazv zzazvVar = this.zzb;
            if (zzazvVar == null) {
                return;
            }
            zzazvVar.zzh(zzazwVar);
        }
    }
}
