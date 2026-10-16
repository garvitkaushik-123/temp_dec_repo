package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzro implements zzqo {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private zzrf zzA;
    private zzbb zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;
    private ByteBuffer zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private zzf zzU;
    private zzpp zzV;
    private long zzW;
    private boolean zzX;
    private boolean zzY;
    private Looper zzZ;
    private long zzaa;
    private long zzab;
    private Handler zzac;
    private Context zzad;
    private boolean zzae;
    private final zzre zzaf;
    private final zzqu zzag;
    private final Context zzd;
    private final zzqt zze;
    private final zzry zzf;
    private final zzcr zzg;
    private final zzrx zzh;
    private final zzfyq zzi;
    private final zzqs zzj;
    private final ArrayDeque zzk;
    private zzrm zzl;
    private final zzri zzm;
    private final zzri zzn;
    private final int zzo;
    private zzph zzp;
    private zzql zzq;
    private zzrd zzr;
    private zzrd zzs;
    private zzck zzt;
    private AudioTrack zzu;
    private zzpj zzv;
    private zzpo zzw;
    private zzrh zzx;
    private zze zzy;
    private zzrf zzz;

    public static /* synthetic */ void zzH(zzro zzroVar) {
        if (zzroVar.zzab >= 300000) {
            ((zzrs) zzroVar.zzq).zza.zzn = true;
            zzroVar.zzab = 0L;
        }
    }

    static /* synthetic */ void zzJ(AudioTrack audioTrack, final zzql zzqlVar, Handler handler, final zzqi zzqiVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqlVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqx
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqg zzqgVar;
                        zzqgVar = ((zzrs) zzql.this).zza.zzc;
                        zzqgVar.zzr(zzqiVar);
                    }
                });
            }
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzqlVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqx
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqg zzqgVar;
                        zzqgVar = ((zzrs) zzql.this).zza.zzc;
                        zzqgVar.zzr(zzqiVar);
                    }
                });
            }
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzM() {
        boolean z;
        synchronized (zza) {
            z = zzc > 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzN() {
        return this.zzs.zzc == 0 ? this.zzD / r0.zzb : this.zzE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzO() {
        zzrd zzrdVar = this.zzs;
        if (zzrdVar.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j2 = zzrdVar.zzd;
        String str = zzex.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzP(zzrd zzrdVar) throws zzqk {
        Context context;
        try {
            int i = this.zzT;
            int i2 = this.zzo;
            Context context2 = null;
            if (i2 != -1 && (context = this.zzd) != null && Build.VERSION.SDK_INT >= 34) {
                if (this.zzad == null) {
                    this.zzad = context.createDeviceContext(i2);
                }
                context2 = this.zzad;
                i = 0;
            }
            return zzae(zzrdVar.zza(), this.zzy, i, zzrdVar.zza, context2);
        } catch (zzqk e) {
            zzql zzqlVar = this.zzq;
            if (zzqlVar != null) {
                zzqlVar.zza(e);
            }
            throw e;
        }
    }

    private final void zzQ(long j) {
        zzbb zzbbVar;
        boolean z;
        zzqg zzqgVar;
        if (zzad()) {
            zzre zzreVar = this.zzaf;
            zzbbVar = this.zzB;
            zzreVar.zzc(zzbbVar);
        } else {
            zzbbVar = zzbb.zza;
        }
        zzbb zzbbVar2 = zzbbVar;
        this.zzB = zzbbVar2;
        if (zzad()) {
            zzre zzreVar2 = this.zzaf;
            z = this.zzC;
            zzreVar2.zzd(z);
        } else {
            z = false;
        }
        this.zzC = z;
        this.zzk.add(new zzrf(zzbbVar2, Math.max(0L, j), zzex.zzt(zzO(), this.zzs.zze), null));
        zzZ();
        zzql zzqlVar = this.zzq;
        if (zzqlVar != null) {
            boolean z2 = this.zzC;
            zzqgVar = ((zzrs) zzqlVar).zza.zzc;
            zzqgVar.zzy(z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzR(long j) throws zzqn {
        zzql zzqlVar;
        zzqn zzqnVar;
        zzql zzqlVar2;
        if (this.zzO == null) {
            return;
        }
        zzri zzriVar = this.zzn;
        if (zzriVar.zzc()) {
            return;
        }
        int remaining = this.zzO.remaining();
        int write = this.zzu.write(this.zzO, remaining, 1);
        this.zzW = SystemClock.elapsedRealtime();
        if (write >= 0) {
            zzriVar.zza();
            if (zzac(this.zzu)) {
                if (this.zzG > 0) {
                    this.zzY = false;
                }
                if (this.zzS && (zzqlVar = this.zzq) != null && write < remaining) {
                }
            }
            int i = this.zzs.zzc;
            if (i == 0) {
                this.zzF += write;
            }
            if (write == remaining) {
                if (i != 0) {
                    zzdd.zzf(this.zzO == this.zzM);
                    this.zzG += this.zzH * this.zzN;
                }
                this.zzO = null;
                return;
            }
            return;
        }
        if (write == -6 || write == -32) {
            if (zzO() <= 0) {
                if (zzac(this.zzu)) {
                    zzS();
                }
            }
            zzqnVar = new zzqn(write, this.zzs.zza, r2);
            zzqlVar2 = this.zzq;
            if (zzqlVar2 != null) {
                zzqlVar2.zza(zzqnVar);
            }
            if (zzqnVar.zzb || this.zzd == null) {
                zzriVar.zzb(zzqnVar);
            }
            zzpj zzpjVar = zzpj.zza;
            this.zzv = zzpjVar;
            this.zzw.zzg(zzpjVar);
            throw zzqnVar;
        }
        r2 = false;
        zzqnVar = new zzqn(write, this.zzs.zza, r2);
        zzqlVar2 = this.zzq;
        if (zzqlVar2 != null) {
        }
        if (zzqnVar.zzb) {
        }
        zzriVar.zzb(zzqnVar);
    }

    private final void zzS() {
        if (this.zzs.zzc == 1) {
            this.zzX = true;
        }
    }

    @EnsuresNonNull({"audioCapabilities"})
    private final void zzT() {
        Context context;
        if (this.zzw == null && (context = this.zzd) != null) {
            this.zzZ = Looper.myLooper();
            zzpo zzpoVar = new zzpo(context, new zzqy(this), this.zzy, this.zzV);
            this.zzw = zzpoVar;
            this.zzv = zzpoVar.zzc();
        }
        this.zzv.getClass();
    }

    private final void zzU() {
        if (this.zzQ) {
            return;
        }
        this.zzQ = true;
        this.zzj.zzb(zzO());
        if (zzac(this.zzu)) {
            this.zzR = false;
        }
        this.zzu.stop();
    }

    private final void zzV(long j) throws zzqn {
        zzR(j);
        if (this.zzO != null) {
            return;
        }
        if (!this.zzt.zzh()) {
            ByteBuffer byteBuffer = this.zzM;
            if (byteBuffer != null) {
                zzX(byteBuffer);
                zzR(j);
                return;
            }
            return;
        }
        while (!this.zzt.zzg()) {
            do {
                ByteBuffer zzb2 = this.zzt.zzb();
                if (zzb2.hasRemaining()) {
                    zzX(zzb2);
                    zzR(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzM;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzt.zze(this.zzM);
                    }
                }
            } while (this.zzO == null);
            return;
        }
    }

    private final void zzW(zzbb zzbbVar) {
        zzrf zzrfVar = new zzrf(zzbbVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzab()) {
            this.zzz = zzrfVar;
        } else {
            this.zzA = zzrfVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzX(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        zzdd.zzf(this.zzO == null);
        if (byteBuffer.hasRemaining()) {
            if (this.zzs.zzc == 0) {
                int zzp = (int) zzex.zzp(zzex.zzs(20L), this.zzs.zze);
                long zzO = zzO();
                long j = zzp;
                if (zzO < j) {
                    zzrd zzrdVar = this.zzs;
                    int i11 = zzrdVar.zzg;
                    int i12 = zzrdVar.zzd;
                    ByteBuffer order = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int position = byteBuffer.position();
                    int i13 = (int) zzO;
                    while (byteBuffer.hasRemaining() && i13 < zzp) {
                        if (i11 != 2) {
                            if (i11 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i11 != 4) {
                                if (i11 != 21) {
                                    if (i11 == 22) {
                                        i7 = byteBuffer.get() & 255;
                                        i8 = (byteBuffer.get() & 255) << 8;
                                        i9 = (byteBuffer.get() & 255) << 16;
                                        i10 = (byteBuffer.get() & 255) << 24;
                                    } else if (i11 == 268435456) {
                                        i = (byteBuffer.get() & 255) << 24;
                                        i2 = (byteBuffer.get() & 255) << 16;
                                    } else if (i11 == 1342177280) {
                                        i4 = (byteBuffer.get() & 255) << 24;
                                        i5 = (byteBuffer.get() & 255) << 16;
                                        i6 = (byteBuffer.get() & 255) << 8;
                                    } else {
                                        if (i11 != 1610612736) {
                                            throw new IllegalStateException();
                                        }
                                        i7 = (byteBuffer.get() & 255) << 24;
                                        i8 = (byteBuffer.get() & 255) << 16;
                                        i9 = (byteBuffer.get() & 255) << 8;
                                        i10 = byteBuffer.get() & 255;
                                    }
                                    i3 = i7 | i8 | i9 | i10;
                                } else {
                                    i4 = (byteBuffer.get() & 255) << 8;
                                    i5 = (byteBuffer.get() & 255) << 16;
                                    i6 = (byteBuffer.get() & 255) << 24;
                                }
                                i3 = i4 | i5 | i6;
                            } else {
                                float max = Math.max(-1.0f, Math.min(byteBuffer.getFloat(), 1.0f));
                                i3 = (int) (max < 0.0f ? (-max) * (-2.1474836E9f) : max * 2.1474836E9f);
                            }
                            int i14 = (int) ((i3 * i13) / j);
                            if (i11 != 2) {
                                order.put((byte) (i14 >> 16));
                                order.put((byte) (i14 >> 24));
                            } else if (i11 == 3) {
                                order.put((byte) (i14 >> 24));
                            } else if (i11 != 4) {
                                if (i11 == 21) {
                                    order.put((byte) (i14 >> 8));
                                    order.put((byte) (i14 >> 16));
                                    order.put((byte) (i14 >> 24));
                                } else if (i11 == 22) {
                                    order.put((byte) i14);
                                    order.put((byte) (i14 >> 8));
                                    order.put((byte) (i14 >> 16));
                                    order.put((byte) (i14 >> 24));
                                } else if (i11 == 268435456) {
                                    order.put((byte) (i14 >> 24));
                                    order.put((byte) (i14 >> 16));
                                } else if (i11 == 1342177280) {
                                    order.put((byte) (i14 >> 24));
                                    order.put((byte) (i14 >> 16));
                                    order.put((byte) (i14 >> 8));
                                } else {
                                    if (i11 != 1610612736) {
                                        throw new IllegalStateException();
                                    }
                                    order.put((byte) (i14 >> 24));
                                    order.put((byte) (i14 >> 16));
                                    order.put((byte) (i14 >> 8));
                                    order.put((byte) i14);
                                }
                            } else if (i14 < 0) {
                                order.putFloat((-i14) / (-2.1474836E9f));
                            } else {
                                order.putFloat(i14 / 2.1474836E9f);
                            }
                            if (byteBuffer.position() != position + i12) {
                                i13++;
                                position = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            i2 = (byteBuffer.get() & 255) << 24;
                        }
                        i3 = i | i2;
                        int i142 = (int) ((i3 * i13) / j);
                        if (i11 != 2) {
                        }
                        if (byteBuffer.position() != position + i12) {
                        }
                    }
                    order.put(byteBuffer);
                    order.flip();
                    byteBuffer2 = order;
                    this.zzO = byteBuffer2;
                }
            }
            byteBuffer2 = byteBuffer;
            this.zzO = byteBuffer2;
        }
    }

    private final void zzY() {
        if (zzab()) {
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzZ() {
        zzck zzckVar = this.zzs.zzi;
        this.zzt = zzckVar;
        zzckVar.zzc();
    }

    private final boolean zzaa() throws zzqn {
        if (!this.zzt.zzh()) {
            zzR(Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzd();
        zzV(Long.MIN_VALUE);
        if (!this.zzt.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzO;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    private final boolean zzab() {
        return this.zzu != null;
    }

    private static boolean zzac(AudioTrack audioTrack) {
        return Build.VERSION.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzad() {
        zzrd zzrdVar = this.zzs;
        if (zzrdVar.zzc != 0) {
            return false;
        }
        int i = zzrdVar.zza.zzI;
        return true;
    }

    private static final AudioTrack zzae(zzqi zzqiVar, zze zzeVar, int i, zzz zzzVar, Context context) throws zzqk {
        zzz zzzVar2;
        Exception exc;
        try {
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzeVar.zza().zza).setAudioFormat(zzex.zzx(zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza)).setTransferMode(1).setBufferSizeInBytes(zzqiVar.zze).setSessionId(i);
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    sessionId.setOffloadedPlayback(zzqiVar.zzd);
                } catch (IllegalArgumentException | UnsupportedOperationException e) {
                    exc = e;
                    zzzVar2 = zzzVar;
                    throw new zzqk(0, zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza, zzqiVar.zze, zzzVar2, zzqiVar.zzd, exc);
                }
            }
            if (Build.VERSION.SDK_INT >= 34 && context != null) {
                sessionId.setContext(context);
            }
            AudioTrack build = sessionId.build();
            int state = build.getState();
            if (state == 1) {
                return build;
            }
            try {
                build.release();
            } catch (Exception unused) {
            }
            throw new zzqk(state, zzqiVar.zzb, zzqiVar.zzc, zzqiVar.zza, zzqiVar.zze, zzzVar, zzqiVar.zzd, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            zzzVar2 = zzzVar;
            exc = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzA() {
        if (zzab()) {
            return this.zzP && !zzz();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzB(zzz zzzVar) {
        return zza(zzzVar) != 0;
    }

    public final void zzK(zzpj zzpjVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zzZ;
        if (looper != myLooper) {
            String name = looper == null ? "null" : looper.getThread().getName();
            throw new IllegalStateException("Current looper (" + (myLooper != null ? myLooper.getThread().getName() : "null") + ") is not the playback looper (" + name + ")");
        }
        zzpj zzpjVar2 = this.zzv;
        if (zzpjVar2 == null || zzpjVar.equals(zzpjVar2)) {
            return;
        }
        this.zzv = zzpjVar;
        zzql zzqlVar = this.zzq;
        if (zzqlVar != null) {
            ((zzrs) zzqlVar).zza.zzC();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final int zza(zzz zzzVar) {
        zzT();
        if (!"audio/raw".equals(zzzVar.zzo)) {
            return this.zzv.zzb(zzzVar, this.zzy) != null ? 2 : 0;
        }
        int i = zzzVar.zzI;
        if (zzex.zzK(i)) {
            return i != 2 ? 1 : 2;
        }
        zzea.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final long zzb() {
        if (!zzab()) {
            return -9223372036854775807L;
        }
        AudioTrack audioTrack = this.zzu;
        zzrd zzrdVar = this.zzs;
        if (zzrdVar.zzc == 0) {
            return zzex.zzt(audioTrack.getBufferSizeInFrames(), zzrdVar.zze);
        }
        long bufferSizeInFrames = audioTrack.getBufferSizeInFrames();
        int zza2 = zzadz.zza(zzrdVar.zzg);
        zzdd.zzf(zza2 != -2147483647);
        return zzex.zzu(bufferSizeInFrames, 1000000L, zza2, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final long zzc(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzab() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzj.zza(), zzex.zzt(zzO(), this.zzs.zze));
        while (true) {
            arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || min < ((zzrf) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzA = (zzrf) arrayDeque.remove();
        }
        zzrf zzrfVar = this.zzA;
        long j2 = min - zzrfVar.zzc;
        long zzq = zzex.zzq(j2, zzrfVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long zza2 = this.zzaf.zza(j2);
            zzrf zzrfVar2 = this.zzA;
            j = zzrfVar2.zzb + zza2;
            zzrfVar2.zzd = zza2 - zzq;
        } else {
            zzrf zzrfVar3 = this.zzA;
            j = zzrfVar3.zzb + zzq + zzrfVar3.zzd;
        }
        long zzb2 = this.zzaf.zzb();
        long zzt = j + zzex.zzt(zzb2, this.zzs.zze);
        long j3 = this.zzaa;
        if (zzb2 > j3) {
            long zzt2 = zzex.zzt(zzb2 - j3, this.zzs.zze);
            this.zzaa = zzb2;
            this.zzab += zzt2;
            if (this.zzac == null) {
                this.zzac = new Handler(Looper.myLooper());
            }
            this.zzac.removeCallbacksAndMessages(null);
            this.zzac.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqw
                @Override // java.lang.Runnable
                public final void run() {
                    zzro.zzH(zzro.this);
                }
            }, 100L);
        }
        return zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final zzbb zzd() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final zzps zze(zzz zzzVar) {
        return this.zzX ? zzps.zza : this.zzag.zza(zzzVar, this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzf(zzz zzzVar, int i, int[] iArr) throws zzqj {
        zzck zzckVar;
        int i2;
        int i3;
        int i4;
        int intValue;
        int i5;
        int i6;
        zzT();
        if ("audio/raw".equals(zzzVar.zzo)) {
            int i7 = zzzVar.zzI;
            zzdd.zzd(zzex.zzK(i7));
            int i8 = zzzVar.zzG;
            i4 = zzex.zzk(i7) * i8;
            zzfyn zzfynVar = new zzfyn();
            zzfynVar.zzh(this.zzi);
            zzfynVar.zzf(this.zzg);
            zzfynVar.zzg(this.zzaf.zze());
            zzckVar = new zzck(zzfynVar.zzi());
            if (zzckVar.equals(this.zzt)) {
                zzckVar = this.zzt;
            }
            this.zzf.zzq(zzzVar.zzJ, zzzVar.zzK);
            this.zze.zzo(iArr);
            try {
                zzcl zza2 = zzckVar.zza(new zzcl(zzzVar.zzH, i8, i7));
                int i9 = zza2.zzd;
                i2 = zza2.zzb;
                int i10 = zza2.zzc;
                int zzi = zzex.zzi(i10);
                int zzk = zzex.zzk(i9) * i10;
                i3 = 0;
                intValue = zzi;
                i5 = i9;
                i6 = zzk;
            } catch (zzcm e) {
                throw new zzqj(e, zzzVar);
            }
        } else {
            zzckVar = new zzck(zzfyq.zzn());
            i2 = zzzVar.zzH;
            zzps zzpsVar = zzps.zza;
            Pair zzb2 = this.zzv.zzb(zzzVar, this.zzy);
            if (zzb2 == null) {
                throw new zzqj("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzzVar))), zzzVar);
            }
            int intValue2 = ((Integer) zzb2.first).intValue();
            i3 = 2;
            i4 = -1;
            intValue = ((Integer) zzb2.second).intValue();
            i5 = intValue2;
            i6 = -1;
        }
        int i11 = i2;
        if (i5 == 0) {
            throw new zzqj("Invalid output encoding (mode=" + i3 + ") for: " + String.valueOf(zzzVar), zzzVar);
        }
        if (intValue == 0) {
            throw new zzqj("Invalid output channel config (mode=" + i3 + ") for: " + String.valueOf(zzzVar), zzzVar);
        }
        int i12 = zzzVar.zzj;
        if ("audio/vnd.dts.hd;profile=lbr".equals(zzzVar.zzo) && i12 == -1) {
            i12 = 768000;
        }
        int i13 = i12;
        int minBufferSize = AudioTrack.getMinBufferSize(i11, intValue, i5);
        zzdd.zzf(minBufferSize != -2);
        int i14 = i6 != -1 ? i6 : 1;
        int i15 = i5;
        int zzb3 = zzrq.zzb(minBufferSize, i15, i3, i14, i11, i13);
        int i16 = i14;
        this.zzX = false;
        zzrd zzrdVar = new zzrd(zzzVar, i4, i3, i6, i11, intValue, i15, (((Math.max(minBufferSize, zzb3) + i16) - 1) / i16) * i16, zzckVar, false, false, false);
        if (zzab()) {
            this.zzr = zzrdVar;
        } else {
            this.zzs = zzrdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzg() {
        if (zzab()) {
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzF = 0L;
            this.zzG = 0L;
            this.zzY = false;
            this.zzH = 0;
            this.zzA = new zzrf(this.zzB, 0L, 0L, null);
            this.zzK = 0L;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzR = false;
            this.zzf.zzp();
            zzZ();
            zzqs zzqsVar = this.zzj;
            if (zzqsVar.zzh()) {
                this.zzu.pause();
            }
            if (zzac(this.zzu)) {
                zzrm zzrmVar = this.zzl;
                zzrmVar.getClass();
                zzrmVar.zzb(this.zzu);
            }
            final zzqi zza2 = this.zzs.zza();
            zzrd zzrdVar = this.zzr;
            if (zzrdVar != null) {
                this.zzs = zzrdVar;
                this.zzr = null;
            }
            zzqsVar.zzc();
            zzrh zzrhVar = this.zzx;
            if (zzrhVar != null) {
                zzrhVar.zzb();
                this.zzx = null;
            }
            final AudioTrack audioTrack = this.zzu;
            final zzql zzqlVar = this.zzq;
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    String str = zzex.zza;
                    final String str2 = "ExoPlayer:AudioTrackReleaseThread";
                    zzb = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(str2) { // from class: com.google.android.gms.internal.ads.zzew
                        public final /* synthetic */ String zza = "ExoPlayer:AudioTrackReleaseThread";

                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            String str3 = zzex.zza;
                            return new Thread(runnable, this.zza);
                        }
                    });
                }
                zzc++;
                zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqv
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzro.zzJ(audioTrack, zzqlVar, handler, zza2);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            }
            this.zzu = null;
        }
        this.zzn.zza();
        this.zzm.zza();
        this.zzaa = 0L;
        this.zzab = 0L;
        Handler handler2 = this.zzac;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzh() {
        this.zzI = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzi() {
        this.zzS = false;
        if (zzab()) {
            if (this.zzj.zzk() || zzac(this.zzu)) {
                this.zzu.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzj() {
        this.zzS = true;
        if (zzab()) {
            this.zzj.zzf();
            this.zzu.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzk() throws zzqn {
        if (!this.zzP && zzab() && zzaa()) {
            zzU();
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzl() {
        zzpo zzpoVar = this.zzw;
        if (zzpoVar != null) {
            zzpoVar.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzm() {
        zzg();
        zzfyq zzfyqVar = this.zzi;
        int size = zzfyqVar.size();
        for (int i = 0; i < size; i++) {
            ((zzcn) zzfyqVar.get(i)).zzf();
        }
        this.zzg.zzf();
        this.zzh.zzf();
        zzck zzckVar = this.zzt;
        if (zzckVar != null) {
            zzckVar.zzf();
        }
        this.zzS = false;
        this.zzX = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzn(zze zzeVar) {
        if (this.zzy.equals(zzeVar)) {
            return;
        }
        this.zzy = zzeVar;
        zzpo zzpoVar = this.zzw;
        if (zzpoVar != null) {
            zzpoVar.zzh(zzeVar);
        }
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzo(int i) {
        zzqg zzqgVar;
        zztb zztbVar;
        zztb zztbVar2;
        if (this.zzT != i) {
            this.zzT = i;
            zzg();
            zzql zzqlVar = this.zzq;
            if (zzqlVar != null) {
                if (Build.VERSION.SDK_INT >= 35) {
                    zzru zzruVar = ((zzrs) zzqlVar).zza;
                    zztbVar = zzruVar.zze;
                    if (zztbVar != null) {
                        zztbVar2 = zzruVar.zze;
                        zztbVar2.zzd(i);
                    }
                }
                zzqgVar = ((zzrs) zzqlVar).zza.zzc;
                zzqgVar.zzo(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzp(zzf zzfVar) {
        if (this.zzU.equals(zzfVar)) {
            return;
        }
        if (this.zzu != null) {
            int i = this.zzU.zza;
        }
        this.zzU = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzq(zzdj zzdjVar) {
        this.zzj.zze(zzdjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzr(zzql zzqlVar) {
        this.zzq = zzqlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzs(int i, int i2) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzac(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzt(zzbb zzbbVar) {
        float f = zzbbVar.zzb;
        String str = zzex.zza;
        this.zzB = new zzbb(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzbbVar.zzc, 8.0f)));
        zzW(zzbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzu(zzph zzphVar) {
        this.zzp = zzphVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzw(boolean z) {
        this.zzC = z;
        zzW(this.zzB);
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzx(float f) {
        if (this.zzL != f) {
            this.zzL = f;
            zzY();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026a  */
    @Override // com.google.android.gms.internal.ads.zzqo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzy(ByteBuffer byteBuffer, long j, int i) throws zzqk, zzqn {
        AudioTrack zzP;
        zzqg zzqgVar;
        zzph zzphVar;
        zzrd zzrdVar;
        boolean z;
        int zzb2;
        int i2;
        int i3;
        byte b;
        int i4;
        int i5;
        ByteBuffer byteBuffer2 = this.zzM;
        zzdd.zzd(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzr != null) {
            if (!zzaa()) {
                return false;
            }
            zzrd zzrdVar2 = this.zzr;
            zzrd zzrdVar3 = this.zzs;
            if (zzrdVar3.zzc == zzrdVar2.zzc && zzrdVar3.zzg == zzrdVar2.zzg && zzrdVar3.zze == zzrdVar2.zze && zzrdVar3.zzf == zzrdVar2.zzf && zzrdVar3.zzd == zzrdVar2.zzd) {
                boolean z2 = zzrdVar3.zzj;
                boolean z3 = zzrdVar2.zzj;
                boolean z4 = zzrdVar3.zzk;
                boolean z5 = zzrdVar2.zzk;
                this.zzs = zzrdVar2;
                this.zzr = null;
                AudioTrack audioTrack = this.zzu;
                if (audioTrack != null && zzac(audioTrack)) {
                    boolean z6 = this.zzs.zzk;
                }
            } else {
                zzU();
                if (zzz()) {
                    return false;
                }
                zzg();
            }
            zzQ(j);
        }
        if (!zzab()) {
            try {
                if (this.zzm.zzc()) {
                    return false;
                }
                try {
                    zzrdVar = this.zzs;
                } catch (zzqk e) {
                    zzrd zzrdVar4 = this.zzs;
                    if (zzrdVar4.zzh > 1000000) {
                        zzz zzzVar = zzrdVar4.zza;
                        int i6 = zzrdVar4.zzb;
                        int i7 = zzrdVar4.zzc;
                        int i8 = zzrdVar4.zzd;
                        int i9 = zzrdVar4.zze;
                        int i10 = zzrdVar4.zzf;
                        int i11 = zzrdVar4.zzg;
                        zzck zzckVar = zzrdVar4.zzi;
                        boolean z7 = zzrdVar4.zzj;
                        boolean z8 = zzrdVar4.zzk;
                        boolean z9 = zzrdVar4.zzl;
                        zzrd zzrdVar5 = new zzrd(zzzVar, i6, i7, i8, i9, i10, i11, 1000000, zzckVar, false, false, false);
                        try {
                            zzP = zzP(zzrdVar5);
                            this.zzs = zzrdVar5;
                        } catch (zzqk e2) {
                            e.addSuppressed(e2);
                            zzS();
                            throw e;
                        }
                    }
                    zzS();
                    throw e;
                }
                if (zzrdVar == null) {
                    throw null;
                }
                zzrd zzrdVar6 = zzrdVar;
                zzP = zzP(zzrdVar);
                this.zzu = zzP;
                if (zzac(zzP)) {
                    AudioTrack audioTrack2 = this.zzu;
                    if (this.zzl == null) {
                        this.zzl = new zzrm(this);
                    }
                    this.zzl.zza(audioTrack2);
                    boolean z10 = this.zzs.zzk;
                }
                if (Build.VERSION.SDK_INT >= 31 && (zzphVar = this.zzp) != null) {
                    AudioTrack audioTrack3 = this.zzu;
                    LogSessionId zza2 = zzphVar.zza();
                    if (!zza2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                        audioTrack3.setLogSessionId(zza2);
                    }
                }
                this.zzT = this.zzu.getAudioSessionId();
                zzqs zzqsVar = this.zzj;
                AudioTrack audioTrack4 = this.zzu;
                zzrd zzrdVar7 = this.zzs;
                zzqsVar.zzd(audioTrack4, zzrdVar7.zzc == 2, zzrdVar7.zzg, zzrdVar7.zzd, zzrdVar7.zzh, this.zzae);
                zzY();
                int i12 = this.zzU.zza;
                zzpp zzppVar = this.zzV;
                if (zzppVar != null) {
                    zzqz.zza(this.zzu, zzppVar);
                    zzpo zzpoVar = this.zzw;
                    if (zzpoVar != null) {
                        zzpoVar.zzi(this.zzV.zza);
                    }
                }
                zzpo zzpoVar2 = this.zzw;
                if (zzpoVar2 != null) {
                    this.zzx = new zzrh(this.zzu, zzpoVar2);
                }
                this.zzJ = true;
                zzql zzqlVar = this.zzq;
                if (zzqlVar != null) {
                    zzqi zza3 = this.zzs.zza();
                    zzqgVar = ((zzrs) zzqlVar).zza.zzc;
                    zzqgVar.zzq(zza3);
                }
            } catch (zzqk e3) {
                if (e3.zzb) {
                    throw e3;
                }
                this.zzm.zzb(e3);
                return false;
            }
        }
        this.zzm.zza();
        if (this.zzJ) {
            this.zzK = Math.max(0L, j);
            this.zzI = false;
            this.zzJ = false;
            zzQ(j);
            if (this.zzS) {
                zzj();
            }
        }
        zzqs zzqsVar2 = this.zzj;
        zzqsVar2.zzj(zzO());
        if (this.zzM == null) {
            zzdd.zzd(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzrd zzrdVar8 = this.zzs;
            if (zzrdVar8.zzc != 0 && this.zzH == 0) {
                int i13 = zzrdVar8.zzg;
                if (i13 != 20) {
                    if (i13 != 30) {
                        switch (i13) {
                            case 5:
                            case 6:
                                zzb2 = zzacu.zza(byteBuffer);
                                z = true;
                                break;
                            case 7:
                            case 8:
                                break;
                            case 9:
                                zzb2 = zzaeo.zzc(zzex.zzj(byteBuffer, byteBuffer.position()));
                                if (zzb2 == -1) {
                                    throw new IllegalArgumentException();
                                }
                                z = true;
                                break;
                            case 10:
                                zzb2 = 1024;
                                z = true;
                                break;
                            case 11:
                            case 12:
                                zzb2 = 2048;
                                z = true;
                                break;
                            default:
                                switch (i13) {
                                    case 14:
                                        int i14 = zzacu.zza;
                                        int position = byteBuffer.position();
                                        int limit = byteBuffer.limit() - 10;
                                        int i15 = position;
                                        while (true) {
                                            if (i15 > limit) {
                                                i5 = -1;
                                            } else if ((zzex.zzj(byteBuffer, i15 + 4) & (-2)) == -126718022) {
                                                i5 = i15 - position;
                                            } else {
                                                i15++;
                                            }
                                        }
                                        if (i5 != -1) {
                                            zzb2 = (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                                            break;
                                        } else {
                                            zzb2 = 0;
                                            break;
                                        }
                                    case 15:
                                        zzb2 = 512;
                                        break;
                                    case 16:
                                        break;
                                    case 17:
                                        int i16 = zzacy.zza;
                                        byte[] bArr = new byte[16];
                                        int position2 = byteBuffer.position();
                                        byteBuffer.get(bArr);
                                        byteBuffer.position(position2);
                                        zzb2 = zzacy.zzb(new zzem(bArr, 16)).zzc;
                                        break;
                                    case 18:
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected audio encoding: " + i13);
                                }
                                z = true;
                                break;
                        }
                    }
                    int i17 = zzadu.zza;
                    if (byteBuffer.getInt(0) != -233094848) {
                        if (byteBuffer.getInt(0) != -398277519) {
                            if (byteBuffer.getInt(0) == 622876772) {
                                zzb2 = 4096;
                                z = true;
                            } else {
                                int position3 = byteBuffer.position();
                                byte b2 = byteBuffer.get(position3);
                                if (b2 != -2) {
                                    if (b2 == -1) {
                                        i3 = (byteBuffer.get(position3 + 4) & 7) << 4;
                                        b = byteBuffer.get(position3 + 7);
                                    } else if (b2 != 31) {
                                        i3 = (byteBuffer.get(position3 + 4) & 1) << 6;
                                        i4 = byteBuffer.get(position3 + 5) & 252;
                                        i2 = (i4 >> 2) | i3;
                                        z = true;
                                    } else {
                                        i3 = (byteBuffer.get(position3 + 5) & 7) << 4;
                                        b = byteBuffer.get(position3 + 6);
                                    }
                                    i4 = b & 60;
                                    i2 = (i4 >> 2) | i3;
                                    z = true;
                                } else {
                                    z = true;
                                    i2 = ((byteBuffer.get(position3 + 5) & 1) << 6) | ((byteBuffer.get(position3 + 4) & 252) >> 2);
                                }
                                zzb2 = (i2 + 1) * 32;
                            }
                        }
                        zzb2 = 1024;
                        z = true;
                    } else {
                        z = true;
                        zzb2 = 1024;
                    }
                } else {
                    z = true;
                    zzb2 = zzaeq.zzb(byteBuffer);
                }
                this.zzH = zzb2;
                if (zzb2 == 0) {
                    return z;
                }
            }
            if (this.zzz != null) {
                if (!zzaa()) {
                    return false;
                }
                zzQ(j);
                this.zzz = null;
            }
            long zzt = this.zzK + zzex.zzt(zzN() - this.zzf.zzo(), this.zzs.zza.zzH);
            if (!this.zzI && Math.abs(zzt - j) > 200000) {
                zzql zzqlVar2 = this.zzq;
                if (zzqlVar2 != null) {
                    zzqlVar2.zza(new zzqm(j, zzt));
                }
                this.zzI = true;
            }
            if (this.zzI) {
                if (!zzaa()) {
                    return false;
                }
                long j2 = j - zzt;
                this.zzK += j2;
                this.zzI = false;
                zzQ(j);
                zzql zzqlVar3 = this.zzq;
                if (zzqlVar3 != null && j2 != 0) {
                    ((zzrs) zzqlVar3).zza.zzas();
                }
            }
            if (this.zzs.zzc == 0) {
                this.zzD += byteBuffer.remaining();
            } else {
                this.zzE += this.zzH * i;
            }
            this.zzM = byteBuffer;
            this.zzN = i;
        }
        zzV(j);
        if (!this.zzM.hasRemaining()) {
            this.zzM = null;
            this.zzN = 0;
            return true;
        }
        if (!zzqsVar2.zzi(zzO())) {
            return false;
        }
        zzea.zzf("DefaultAudioSink", "Resetting stalled audio track");
        zzg();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final boolean zzz() {
        if (zzab()) {
            return !(Build.VERSION.SDK_INT >= 29 && this.zzu.isOffloadedPlayback() && this.zzR) && this.zzj.zzg(zzO());
        }
        return false;
    }

    /* synthetic */ zzro(zzrc zzrcVar, zzrn zzrnVar) {
        Context context;
        Context context2;
        Context applicationContext;
        zzre zzreVar;
        zzqu zzquVar;
        Context context3;
        Context context4;
        context = zzrcVar.zza;
        zzrn zzrnVar2 = null;
        if (context == null) {
            applicationContext = null;
        } else {
            context2 = zzrcVar.zza;
            applicationContext = context2.getApplicationContext();
        }
        this.zzd = applicationContext;
        this.zzy = zze.zza;
        this.zzv = applicationContext != null ? null : zzrcVar.zzb;
        zzreVar = zzrcVar.zzf;
        this.zzaf = zzreVar;
        zzquVar = zzrcVar.zzg;
        zzquVar.getClass();
        this.zzag = zzquVar;
        this.zzj = new zzqs(new zzrj(this, zzrnVar2));
        zzqt zzqtVar = new zzqt();
        this.zze = zzqtVar;
        zzry zzryVar = new zzry();
        this.zzf = zzryVar;
        this.zzg = new zzcr();
        this.zzh = new zzrx();
        this.zzi = zzfyq.zzp(zzryVar, zzqtVar);
        this.zzL = 1.0f;
        this.zzT = 0;
        this.zzU = new zzf(0, 0.0f);
        zzbb zzbbVar = zzbb.zza;
        this.zzA = new zzrf(zzbbVar, 0L, 0L, null);
        this.zzB = zzbbVar;
        this.zzC = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzri();
        this.zzn = new zzri();
        int i = -1;
        if (Build.VERSION.SDK_INT >= 34) {
            context3 = zzrcVar.zza;
            if (context3 != null) {
                context4 = zzrcVar.zza;
                int deviceId = context4.getDeviceId();
                if (deviceId != 0 && deviceId != -1) {
                    i = deviceId;
                }
            }
        }
        this.zzo = i;
        this.zzae = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqo
    public final void zzv(AudioDeviceInfo audioDeviceInfo) {
        this.zzV = audioDeviceInfo == null ? null : new zzpp(audioDeviceInfo);
        zzpo zzpoVar = this.zzw;
        if (zzpoVar != null) {
            zzpoVar.zzi(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzqz.zza(audioTrack, this.zzV);
        }
    }
}
