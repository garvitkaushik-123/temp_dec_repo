package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzzu extends Handler implements Runnable {
    final /* synthetic */ zzaaa zza;
    private final zzzv zzb;
    private final long zzc;
    private zzzs zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzzu(zzaaa zzaaaVar, Looper looper, zzzv zzzvVar, zzzs zzzsVar, int i, long j) {
        super(looper);
        Objects.requireNonNull(zzaaaVar);
        this.zza = zzaaaVar;
        this.zzb = zzzvVar;
        this.zzd = zzzsVar;
        this.zzc = j;
    }

    private final void zzd() {
        zzaai zzaaiVar;
        zzzu zzzuVar;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.zzc;
        zzzs zzzsVar = this.zzd;
        zzzsVar.getClass();
        zzzsVar.zzL(this.zzb, elapsedRealtime, j, this.zzf);
        this.zze = null;
        zzaaa zzaaaVar = this.zza;
        zzaaiVar = zzaaaVar.zzc;
        zzzuVar = zzaaaVar.zzd;
        zzzuVar.getClass();
        zzaaiVar.execute(zzzuVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        int i2;
        int i3;
        long j;
        if (this.zzi) {
            return;
        }
        if (message.what == 1) {
            zzd();
            return;
        }
        if (message.what == 4) {
            throw ((Error) message.obj);
        }
        zzaaa zzaaaVar = this.zza;
        zzaaaVar.zzd = null;
        long j2 = this.zzc;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - j2;
        zzzs zzzsVar = this.zzd;
        zzzsVar.getClass();
        if (this.zzh) {
            zzzsVar.zzJ(this.zzb, elapsedRealtime, j3, false);
            return;
        }
        int i4 = message.what;
        if (i4 == 2) {
            try {
                zzzsVar.zzK(this.zzb, elapsedRealtime, j3);
                return;
            } catch (RuntimeException e) {
                zzea.zzd("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zze = new zzzy(e);
                return;
            }
        }
        if (i4 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i5 = this.zzf + 1;
        this.zzf = i5;
        zzzt zzu = zzzsVar.zzu(this.zzb, elapsedRealtime, j3, iOException, i5);
        i = zzu.zza;
        if (i == 3) {
            zzaaaVar.zze = this.zze;
            return;
        }
        i2 = zzu.zza;
        if (i2 != 2) {
            i3 = zzu.zza;
            if (i3 == 1) {
                this.zzf = 1;
            }
            j = zzu.zzb;
            zzc(j != -9223372036854775807L ? zzu.zzb : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z) {
                zzzv zzzvVar = this.zzb;
                Trace.beginSection("load:" + zzzvVar.getClass().getSimpleName());
                try {
                    zzzvVar.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (OutOfMemoryError e2) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "OutOfMemory error loading stream", e2);
            obtainMessage(3, new zzzy(e2)).sendToTarget();
        } catch (Error e3) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "Unexpected error loading stream", e3);
                obtainMessage(4, e3).sendToTarget();
            }
            throw e3;
        } catch (Exception e4) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "Unexpected exception loading stream", e4);
            obtainMessage(3, new zzzy(e4)).sendToTarget();
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzd = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzzs zzzsVar = this.zzd;
            zzzsVar.getClass();
            zzzsVar.zzJ(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzzu zzzuVar;
        zzaaa zzaaaVar = this.zza;
        zzzuVar = zzaaaVar.zzd;
        zzdd.zzf(zzzuVar == null);
        zzaaaVar.zzd = this;
        if (j > 0) {
            sendEmptyMessageDelayed(1, j);
        } else {
            zzd();
        }
    }
}
