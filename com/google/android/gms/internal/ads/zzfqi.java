package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfqi {
    final zzfql zza;
    final boolean zzb;

    private zzfqi(zzfql zzfqlVar) {
        this.zza = zzfqlVar;
        this.zzb = zzfqlVar != null;
    }

    public static zzfqi zzb(Context context, String str, String str2) {
        zzfql zzfqjVar;
        try {
            try {
                try {
                    IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    IBinder iBinder = instantiate;
                    if (instantiate == null) {
                        zzfqjVar = null;
                    } else {
                        IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfqjVar = queryLocalInterface instanceof zzfql ? (zzfql) queryLocalInterface : new zzfqj(instantiate);
                    }
                    zzfql zzfqlVar = zzfqjVar;
                    zzfqjVar.zze(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfqi(zzfqjVar);
                } catch (RemoteException | zzfpk | NullPointerException | SecurityException unused) {
                    Log.d("GASS", "Cannot dynamite load clearcut");
                    return new zzfqi(new zzfqm());
                }
            } catch (Exception e) {
                throw new zzfpk(e);
            }
        } catch (Exception e2) {
            throw new zzfpk(e2);
        }
    }

    public static zzfqi zzc() {
        zzfqm zzfqmVar = new zzfqm();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfqi(zzfqmVar);
    }

    public final zzfqg zza(byte[] bArr) {
        return new zzfqg(this, bArr, null);
    }
}
