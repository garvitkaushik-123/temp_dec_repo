package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzmd {
    private static File zza;

    static Payload zza(Context context, zzmb zzmbVar) {
        long zzb = zzmbVar.zzb();
        int zza2 = zzmbVar.zza();
        if (zza2 == 1) {
            zzlx zzg = zzmbVar.zzg();
            return Payload.zza((byte[]) zzsg.zzc(zzg != null ? zzg.zzc() : zzmbVar.zzv(), "Payload bytes cannot be null if type is BYTES."), zzb);
        }
        if (zza2 != 2) {
            if (zza2 != 3) {
                Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzmbVar.zzb()), Integer.valueOf(zzmbVar.zza())));
                return null;
            }
            ParcelFileDescriptor zze = zzmbVar.zze();
            zzsg.zzc(zze, "Data ParcelFileDescriptor cannot be null for type STREAM");
            return Payload.zzc(Payload.Stream.zzb(zze), zzb);
        }
        String zzh = zzmbVar.zzh();
        Uri zzd = zzmbVar.zzd();
        if (zzh == null || zzd == null) {
            ParcelFileDescriptor zze2 = zzmbVar.zze();
            zzsg.zzc(zze2, "Data ParcelFileDescriptor cannot be null for type FILE");
            return Payload.zzb(Payload.File.zzb(zze2), zzb);
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(zzd, "r");
            if (openFileDescriptor != null) {
                return Payload.zzb(Payload.File.zza(new File(zzh), openFileDescriptor, zzmbVar.zzc(), zzd), zzb);
            }
            Log.w("NearbyConnections", String.format("Failed to get ParcelFileDescriptor for %s", zzd));
            return null;
        } catch (FileNotFoundException e) {
            Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", zzd, zzh), e);
            return null;
        } catch (SecurityException e2) {
            Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", zzd, zzh), e2);
            return null;
        }
    }

    static File zzb() {
        return zza;
    }

    public static void zzc(File file) {
        if (file == null) {
            Log.e("NearbyConnections", "Cannot set null temp directory");
        } else {
            zza = file;
        }
    }
}
