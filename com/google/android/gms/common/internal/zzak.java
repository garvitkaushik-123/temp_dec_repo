package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
public final class zzak {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    static Intent zza(Context context, zzo zzoVar) throws zzai {
        Bundle bundle;
        ContentProviderClient acquireUnstableContentProviderClient;
        String zzb = zzoVar.zzb();
        if (zzb == null) {
            return new Intent().setComponent(zzoVar.zza());
        }
        Intent intent = null;
        if (zzoVar.zzd()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", zzb);
            try {
                acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(zza);
            } catch (RemoteException | IllegalArgumentException e) {
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
            }
            if (acquireUnstableContentProviderClient == null) {
                throw new RemoteException("Failed to acquire ContentProviderClient");
            }
            try {
                bundle = acquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle2);
                acquireUnstableContentProviderClient.release();
                if (bundle != null) {
                    Intent intent2 = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                    if (intent2 != null) {
                        intent = intent2;
                    } else {
                        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("serviceMissingResolutionIntentKey");
                        if (pendingIntent != null) {
                            Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action " + zzb + " but has possible resolution");
                            throw new zzai(new ConnectionResult(25, pendingIntent));
                        }
                    }
                }
                if (intent == null) {
                    Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action: ".concat(zzb));
                }
            } catch (Throwable th) {
                acquireUnstableContentProviderClient.release();
                throw th;
            }
        }
        return intent == null ? new Intent(zzb).setPackage(zzoVar.zzc()) : intent;
    }
}
