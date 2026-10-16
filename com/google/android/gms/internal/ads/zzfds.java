package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfds {
    private static zzfds zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcy zzc;
    private final AtomicReference zzd = new AtomicReference();

    zzfds(Context context, com.google.android.gms.ads.internal.client.zzcy zzcyVar) {
        this.zzb = context;
        this.zzc = zzcyVar;
    }

    static com.google.android.gms.ads.internal.client.zzcy zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzcx.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfds zzd(Context context) {
        synchronized (zzfds.class) {
            zzfds zzfdsVar = zza;
            if (zzfdsVar != null) {
                return zzfdsVar;
            }
            Context applicationContext = context.getApplicationContext();
            long longValue = ((Long) zzbff.zzb.zze()).longValue();
            com.google.android.gms.ads.internal.client.zzcy zzcyVar = null;
            if (longValue > 0 && longValue <= 252530000) {
                zzcyVar = zza(applicationContext);
            }
            zzfds zzfdsVar2 = new zzfds(applicationContext, zzcyVar);
            zza = zzfdsVar2;
            return zzfdsVar2;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzfd zzg() {
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.zzc;
        if (zzcyVar != null) {
            try {
                return zzcyVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbpq zzb() {
        return (zzbpq) this.zzd.get();
    }

    public final VersionInfoParcel zzc(int i, boolean z, int i2) {
        com.google.android.gms.ads.internal.client.zzfd zzg;
        com.google.android.gms.ads.internal.zzv.zzr();
        boolean zzF = com.google.android.gms.ads.internal.util.zzs.zzF(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i2, true, zzF);
        return (((Boolean) zzbff.zzc.zze()).booleanValue() && (zzg = zzg()) != null) ? new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, zzg.zza(), true, zzF) : versionInfoParcel;
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzfd zzg = zzg();
        if (zzg != null) {
            return zzg.zzb();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(zzbpq zzbpqVar) {
        zzbpq adapterCreator;
        if (!((Boolean) zzbff.zza.zze()).booleanValue()) {
            zzfdr.zza(this.zzd, null, zzbpqVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.zzc;
        if (zzcyVar != null) {
            try {
                adapterCreator = zzcyVar.getAdapterCreator();
            } catch (RemoteException unused) {
            }
            AtomicReference atomicReference = this.zzd;
            if (adapterCreator != null) {
                zzbpqVar = adapterCreator;
            }
            zzfdr.zza(atomicReference, null, zzbpqVar);
        }
        adapterCreator = null;
        AtomicReference atomicReference2 = this.zzd;
        if (adapterCreator != null) {
        }
        zzfdr.zza(atomicReference2, null, zzbpqVar);
    }
}
