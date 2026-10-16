package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfou implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final zzfpn zza;
    private final zzfph zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private boolean zze = false;

    zzfou(Context context, Looper looper, zzfph zzfphVar) {
        this.zzb = zzfphVar;
        this.zza = new zzfpn(context, looper, this, this, 12800000);
    }

    private final void zzb() {
        synchronized (this.zzc) {
            zzfpn zzfpnVar = this.zza;
            if (zzfpnVar.isConnected() || zzfpnVar.isConnecting()) {
                zzfpnVar.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc) {
            if (this.zze) {
                return;
            }
            this.zze = true;
            try {
                this.zza.zzp().zzg(new zzfpl(this.zzb.zzaV()));
            } catch (Exception unused) {
            } catch (Throwable th) {
                zzb();
                throw th;
            }
            zzb();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    final void zza() {
        synchronized (this.zzc) {
            if (!this.zzd) {
                this.zzd = true;
                this.zza.checkAvailabilityAndConnect();
            }
        }
    }
}
