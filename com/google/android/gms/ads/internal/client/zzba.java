package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbez;
import com.google.android.gms.internal.ads.zzbfn;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
abstract class zzba {
    private static final zzcr zza;

    static {
        zzcr zzcrVar = null;
        try {
            Object newInstance = zzaz.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (newInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzcrVar = queryLocalInterface instanceof zzcr ? (zzcr) queryLocalInterface : new zzcp(iBinder);
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzcrVar;
    }

    zzba() {
    }

    private final Object zze() {
        zzcr zzcrVar = zza;
        if (zzcrVar == null) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zzb(zzcrVar);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot invoke remote loader.", e);
            return null;
        }
    }

    protected abstract Object zza();

    protected abstract Object zzb(zzcr zzcrVar) throws RemoteException;

    protected abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z) {
        boolean z2;
        Object zze;
        if (!z) {
            zzbb.zzb();
            if (!com.google.android.gms.ads.internal.util.client.zzf.zzx(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                com.google.android.gms.ads.internal.util.client.zzo.zze("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z3 = false;
        boolean z4 = !(DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
        zzbde.zza(context);
        if (((Boolean) zzbez.zza.zze()).booleanValue()) {
            z2 = false;
        } else if (((Boolean) zzbez.zzb.zze()).booleanValue()) {
            z2 = true;
            z3 = true;
        } else {
            z3 = z | z4;
            z2 = false;
        }
        if (z3) {
            zze = zze();
            if (zze == null && !z2) {
                zze = zzf();
            }
        } else {
            Object zzf = zzf();
            if (zzf == null) {
                if (zzbb.zze().nextInt(((Long) zzbfn.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzbb.zzb().zzs(context, zzbb.zzc().afmaVersion, "gmob-apps", bundle, true);
                }
            }
            zze = zzf == null ? zze() : zzf;
        }
        return zze == null ? zza() : zze;
    }
}
