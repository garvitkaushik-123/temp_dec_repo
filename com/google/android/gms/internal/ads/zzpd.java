package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import io.bidmachine.media3.common.MediaLibraryInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzpd implements zzmr, zzpe {
    private boolean zzA;
    private final Context zza;
    private final zzpf zzc;
    private final PlaybackSession zzd;
    private String zzj;
    private PlaybackMetrics.Builder zzk;
    private int zzl;
    private zzba zzo;
    private zzpc zzp;
    private zzpc zzq;
    private zzpc zzr;
    private zzz zzs;
    private zzz zzt;
    private zzz zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;
    private final Executor zzb = zzde.zza();
    private final zzbk zzf = new zzbk();
    private final zzbj zzg = new zzbj();
    private final HashMap zzi = new HashMap();
    private final HashMap zzh = new HashMap();
    private final long zze = SystemClock.elapsedRealtime();
    private int zzm = 0;
    private int zzn = 0;

    private zzpd(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzd = playbackSession;
        zzow zzowVar = new zzow(zzow.zza);
        this.zzc = zzowVar;
        zzowVar.zzh(this);
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzA(zzbl zzblVar, zzvh zzvhVar) {
        int zza;
        PlaybackMetrics.Builder builder = this.zzk;
        if (zzvhVar == null || (zza = zzblVar.zza(zzvhVar.zza)) == -1) {
            return;
        }
        zzbj zzbjVar = this.zzg;
        int i = 0;
        zzblVar.zzd(zza, zzbjVar, false);
        zzbk zzbkVar = this.zzf;
        zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L);
        zzak zzakVar = zzbkVar.zzd.zzb;
        if (zzakVar != null) {
            int zzo = zzex.zzo(zzakVar.zza);
            i = zzo != 0 ? zzo != 1 ? zzo != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i);
        long j = zzbkVar.zzm;
        if (j != -9223372036854775807L && !zzbkVar.zzk && !zzbkVar.zzi && !zzbkVar.zzb()) {
            builder.setMediaDurationMillis(zzex.zzv(j));
        }
        builder.setPlaybackType(true != zzbkVar.zzb() ? 1 : 2);
        this.zzA = true;
    }

    private final void zzB(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzs, zzzVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzzVar;
        zzC(1, j, zzzVar, i2);
    }

    private final void zzC(int i, long j, zzz zzzVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zze);
        if (zzzVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzzVar.zzn;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzzVar.zzo;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzzVar.zzk;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzzVar.zzj;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzzVar.zzv;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzzVar.zzw;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzzVar.zzG;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzzVar.zzH;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzzVar.zzd;
            if (str4 != null) {
                String str5 = zzex.zza;
                String[] split = str4.split("-", -1);
                Pair create = Pair.create(split[0], split.length >= 2 ? split[1] : null);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                if (create.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) create.second);
                }
            }
            float f = zzzVar.zzz;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzA = true;
        final TrackChangeEvent build = timeSinceCreatedMillis.build();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzox
            @Override // java.lang.Runnable
            public final void run() {
                zzpd.this.zzd.reportTrackChangeEvent(build);
            }
        });
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzD(zzpc zzpcVar) {
        if (zzpcVar != null) {
            return zzpcVar.zzc.equals(this.zzc.zze());
        }
        return false;
    }

    public static zzpd zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzpd(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzw(int i) {
        switch (zzex.zzl(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzx() {
        PlaybackMetrics.Builder builder = this.zzk;
        if (builder != null && this.zzA) {
            builder.setAudioUnderrunCount(this.zzz);
            this.zzk.setVideoFramesDropped(this.zzx);
            this.zzk.setVideoFramesPlayed(this.zzy);
            Long l = (Long) this.zzh.get(this.zzj);
            this.zzk.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzi.get(this.zzj);
            this.zzk.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzk.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics build = this.zzk.build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpa
                @Override // java.lang.Runnable
                public final void run() {
                    zzpd.this.zzd.reportPlaybackMetrics(build);
                }
            });
        }
        this.zzk = null;
        this.zzj = null;
        this.zzz = 0;
        this.zzx = 0;
        this.zzy = 0;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzA = false;
    }

    private final void zzy(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzt, zzzVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzzVar;
        zzC(0, j, zzzVar, i2);
    }

    private final void zzz(long j, zzz zzzVar, int i) {
        if (Objects.equals(this.zzu, zzzVar)) {
            return;
        }
        int i2 = this.zzu == null ? 1 : 0;
        this.zzu = zzzVar;
        zzC(2, j, zzzVar, i2);
    }

    public final LogSessionId zza() {
        return this.zzd.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zze(zzmp zzmpVar, zzz zzzVar, zzie zzieVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzf(zzmp zzmpVar, int i, long j, long j2) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar != null) {
            String zzf = this.zzc.zzf(zzmpVar.zzb, zzvhVar);
            HashMap hashMap = this.zzi;
            Long l = (Long) hashMap.get(zzf);
            HashMap hashMap2 = this.zzh;
            Long l2 = (Long) hashMap2.get(zzf);
            hashMap.put(zzf, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            hashMap2.put(zzf, Long.valueOf((l2 != null ? l2.longValue() : 0L) + i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzg(zzmp zzmpVar, zzvd zzvdVar) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar == null) {
            return;
        }
        zzz zzzVar = zzvdVar.zzb;
        zzzVar.getClass();
        zzpc zzpcVar = new zzpc(zzzVar, 0, this.zzc.zzf(zzmpVar.zzb, zzvhVar));
        int i = zzvdVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzq = zzpcVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzr = zzpcVar;
                return;
            }
        }
        this.zzp = zzpcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzh(zzmp zzmpVar, int i, long j) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x01ee, code lost:
    
        if (r12 != 1) goto L137;
     */
    @Override // com.google.android.gms.internal.ads.zzmr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(zzbh zzbhVar, zzmq zzmqVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int errorCode;
        int zzm;
        zzs zzsVar;
        int i5;
        int i6;
        if (zzmqVar.zzb() == 0) {
            return;
        }
        for (int i7 = 0; i7 < zzmqVar.zzb(); i7++) {
            int zza = zzmqVar.zza(i7);
            zzmp zzc = zzmqVar.zzc(zza);
            if (zza == 0) {
                this.zzc.zzk(zzc);
            } else if (zza == 11) {
                this.zzc.zzj(zzc, this.zzl);
            } else {
                this.zzc.zzi(zzc);
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzmqVar.zzd(0)) {
            zzmp zzc2 = zzmqVar.zzc(0);
            if (this.zzk != null) {
                zzA(zzc2.zzb, zzc2.zzd);
            }
        }
        if (zzmqVar.zzd(2) && this.zzk != null) {
            zzfyq zza2 = zzbhVar.zzp().zza();
            int size = zza2.size();
            int i8 = 0;
            loop1: while (true) {
                if (i8 >= size) {
                    zzsVar = null;
                    break;
                }
                zzbs zzbsVar = (zzbs) zza2.get(i8);
                int i9 = 0;
                while (true) {
                    i6 = i8 + 1;
                    if (i9 < zzbsVar.zza) {
                        if (zzbsVar.zzd(i9) && (zzsVar = zzbsVar.zzb(i9).zzs) != null) {
                            break loop1;
                        } else {
                            i9++;
                        }
                    }
                }
                i8 = i6;
            }
            if (zzsVar != null) {
                PlaybackMetrics.Builder builder = this.zzk;
                String str = zzex.zza;
                int i10 = 0;
                while (true) {
                    if (i10 >= zzsVar.zzb) {
                        i5 = 1;
                        break;
                    }
                    UUID uuid = zzsVar.zza(i10).zza;
                    if (uuid.equals(zzh.zzd)) {
                        i5 = 3;
                        break;
                    } else if (uuid.equals(zzh.zze)) {
                        i5 = 2;
                        break;
                    } else {
                        if (uuid.equals(zzh.zzc)) {
                            i5 = 6;
                            break;
                        }
                        i10++;
                    }
                }
                builder.setDrmType(i5);
            }
        }
        if (zzmqVar.zzd(1011)) {
            this.zzz++;
        }
        zzba zzbaVar = this.zzo;
        if (zzbaVar != null) {
            Context context = this.zza;
            int i11 = zzbaVar.zza;
            if (i11 == 1001) {
                i4 = 20;
            } else {
                zzin zzinVar = (zzin) zzbaVar;
                boolean z = zzinVar.zzc == 1;
                int i12 = zzinVar.zzg;
                Throwable cause = zzbaVar.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof zzhc) {
                        zzm = ((zzhc) cause).zzc;
                        i4 = 5;
                    } else if ((cause instanceof zzhb) || (cause instanceof zzaz)) {
                        zzm = 0;
                        i4 = 11;
                    } else {
                        boolean z2 = cause instanceof zzha;
                        if (z2 || (cause instanceof zzhk)) {
                            if (zzel.zzb(context).zza() == 1) {
                                zzm = 0;
                                i4 = 3;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    zzm = 0;
                                    i4 = 6;
                                } else if (cause2 instanceof SocketTimeoutException) {
                                    zzm = 0;
                                    i4 = 7;
                                } else if (z2 && ((zzha) cause).zzb == 1) {
                                    zzm = 0;
                                    i4 = 4;
                                } else {
                                    zzm = 0;
                                    i4 = 8;
                                }
                            }
                        } else if (i11 == 1002) {
                            i4 = 21;
                        } else if (cause instanceof zzsa) {
                            Throwable cause3 = cause.getCause();
                            cause3.getClass();
                            if (cause3 instanceof MediaDrm.MediaDrmStateException) {
                                errorCode = zzex.zzm(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                i3 = zzw(errorCode);
                                int i13 = i3;
                                zzm = errorCode;
                                i4 = i13;
                            } else if (cause3 instanceof MediaDrmResetException) {
                                i4 = 27;
                            } else if (cause3 instanceof NotProvisionedException) {
                                i4 = 24;
                            } else if (cause3 instanceof DeniedByServerException) {
                                i4 = 29;
                            } else {
                                if (!(cause3 instanceof zzsk)) {
                                    i4 = cause3 instanceof zzrz ? 28 : 30;
                                }
                                zzm = 0;
                                i4 = 23;
                            }
                        } else if ((cause instanceof zzgx) && (cause.getCause() instanceof FileNotFoundException)) {
                            Throwable cause4 = cause.getCause();
                            cause4.getClass();
                            Throwable cause5 = cause4.getCause();
                            if ((cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) {
                                i4 = 32;
                            } else {
                                zzm = 0;
                                i4 = 31;
                            }
                        } else {
                            zzm = 0;
                            i4 = 9;
                        }
                    }
                    final PlaybackErrorEvent build = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(elapsedRealtime - this.zze).setErrorCode(i4).setSubErrorCode(zzm).setException(zzbaVar).build();
                    this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzpd.this.zzd.reportPlaybackErrorEvent(build);
                        }
                    });
                    this.zzA = true;
                    this.zzo = null;
                } else {
                    if (z) {
                        i4 = 35;
                        if (i12 != 0) {
                        }
                    }
                    if (z && i12 == 3) {
                        i4 = 15;
                    } else {
                        if (!z || i12 != 2) {
                            if (cause instanceof zztl) {
                                zzm = zzex.zzm(((zztl) cause).zzd);
                                i4 = 13;
                                final PlaybackErrorEvent build2 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(elapsedRealtime - this.zze).setErrorCode(i4).setSubErrorCode(zzm).setException(zzbaVar).build();
                                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzpd.this.zzd.reportPlaybackErrorEvent(build2);
                                    }
                                });
                                this.zzA = true;
                                this.zzo = null;
                            } else {
                                i3 = 14;
                                if (cause instanceof zzth) {
                                    errorCode = ((zzth) cause).zza;
                                } else if (cause instanceof OutOfMemoryError) {
                                    i4 = 14;
                                } else if (cause instanceof zzqk) {
                                    errorCode = ((zzqk) cause).zza;
                                    i3 = 17;
                                } else if (cause instanceof zzqn) {
                                    errorCode = ((zzqn) cause).zza;
                                    i3 = 18;
                                } else if (cause instanceof MediaCodec.CryptoException) {
                                    errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                    i3 = zzw(errorCode);
                                } else {
                                    i4 = 22;
                                }
                                int i132 = i3;
                                zzm = errorCode;
                                i4 = i132;
                                final PlaybackErrorEvent build22 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(elapsedRealtime - this.zze).setErrorCode(i4).setSubErrorCode(zzm).setException(zzbaVar).build();
                                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzpd.this.zzd.reportPlaybackErrorEvent(build22);
                                    }
                                });
                                this.zzA = true;
                                this.zzo = null;
                            }
                        }
                        zzm = 0;
                        i4 = 23;
                        final PlaybackErrorEvent build222 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(elapsedRealtime - this.zze).setErrorCode(i4).setSubErrorCode(zzm).setException(zzbaVar).build();
                        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzpd.this.zzd.reportPlaybackErrorEvent(build222);
                            }
                        });
                        this.zzA = true;
                        this.zzo = null;
                    }
                }
            }
            zzm = 0;
            final PlaybackErrorEvent build2222 = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(elapsedRealtime - this.zze).setErrorCode(i4).setSubErrorCode(zzm).setException(zzbaVar).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoz
                @Override // java.lang.Runnable
                public final void run() {
                    zzpd.this.zzd.reportPlaybackErrorEvent(build2222);
                }
            });
            this.zzA = true;
            this.zzo = null;
        }
        if (zzmqVar.zzd(2)) {
            zzbt zzp = zzbhVar.zzp();
            boolean zzb = zzp.zzb(2);
            boolean zzb2 = zzp.zzb(1);
            boolean zzb3 = zzp.zzb(3);
            if (!zzb && !zzb2) {
                if (zzb3) {
                    zzb3 = true;
                }
            }
            if (!zzb) {
                zzB(elapsedRealtime, null, 0);
            }
            if (!zzb2) {
                zzy(elapsedRealtime, null, 0);
            }
            if (!zzb3) {
                zzz(elapsedRealtime, null, 0);
            }
        }
        if (zzD(this.zzp)) {
            zzpc zzpcVar = this.zzp;
            zzz zzzVar = zzpcVar.zza;
            if (zzzVar.zzw != -1) {
                int i14 = zzpcVar.zzb;
                zzB(elapsedRealtime, zzzVar, 0);
                this.zzp = null;
            }
        }
        if (zzD(this.zzq)) {
            zzpc zzpcVar2 = this.zzq;
            zzz zzzVar2 = zzpcVar2.zza;
            int i15 = zzpcVar2.zzb;
            zzy(elapsedRealtime, zzzVar2, 0);
            this.zzq = null;
        }
        if (zzD(this.zzr)) {
            zzpc zzpcVar3 = this.zzr;
            zzz zzzVar3 = zzpcVar3.zza;
            int i16 = zzpcVar3.zzb;
            zzz(elapsedRealtime, zzzVar3, 0);
            this.zzr = null;
        }
        switch (zzel.zzb(this.zza).zza()) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 9;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
            case 8:
            default:
                i = 1;
                break;
            case 7:
                i = 3;
                break;
            case 9:
                i = 8;
                break;
            case 10:
                i = 7;
                break;
        }
        if (i != this.zzn) {
            this.zzn = i;
            final NetworkEvent build3 = new NetworkEvent.Builder().setNetworkType(i).setTimeSinceCreatedMillis(elapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoy
                @Override // java.lang.Runnable
                public final void run() {
                    zzpd.this.zzd.reportNetworkEvent(build3);
                }
            });
        }
        if (zzbhVar.zzg() != 2) {
            this.zzv = false;
        }
        if (((zzmk) zzbhVar).zzD() == null) {
            this.zzw = false;
        } else if (zzmqVar.zzd(10)) {
            this.zzw = true;
        }
        int zzg = zzbhVar.zzg();
        if (this.zzv) {
            i2 = 5;
        } else if (this.zzw) {
            i2 = 13;
        } else {
            i2 = 4;
            if (zzg == 4) {
                i2 = 11;
            } else if (zzg == 2) {
                int i17 = this.zzm;
                i2 = (i17 == 0 || i17 == 2 || i17 == 12) ? 2 : !zzbhVar.zzv() ? 7 : zzbhVar.zzh() != 0 ? 10 : 6;
            } else if (zzg != 3) {
                i2 = (zzg != 1 || this.zzm == 0) ? this.zzm : 12;
            } else if (zzbhVar.zzv()) {
                i2 = zzbhVar.zzh() != 0 ? 9 : 3;
            }
        }
        if (this.zzm != i2) {
            this.zzm = i2;
            this.zzA = true;
            final PlaybackStateEvent build4 = new PlaybackStateEvent.Builder().setState(this.zzm).setTimeSinceCreatedMillis(elapsedRealtime - this.zze).build();
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpb
                @Override // java.lang.Runnable
                public final void run() {
                    zzpd.this.zzd.reportPlaybackStateEvent(build4);
                }
            });
        }
        if (zzmqVar.zzd(1028)) {
            this.zzc.zzg(zzmqVar.zzc(1028));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzj(zzmp zzmpVar, zzuy zzuyVar, zzvd zzvdVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzk(zzmp zzmpVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzl(zzmp zzmpVar, zzba zzbaVar) {
        this.zzo = zzbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzm(zzmp zzmpVar, zzbf zzbfVar, zzbf zzbfVar2, int i) {
        if (i == 1) {
            this.zzv = true;
            i = 1;
        }
        this.zzl = i;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzn(zzmp zzmpVar, Object obj, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzo(zzmp zzmpVar, zzid zzidVar) {
        this.zzx += zzidVar.zzg;
        this.zzy += zzidVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzp(zzmp zzmpVar, zzz zzzVar, zzie zzieVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzq(zzmp zzmpVar, zzcd zzcdVar) {
        zzpc zzpcVar = this.zzp;
        if (zzpcVar != null) {
            zzz zzzVar = zzpcVar.zza;
            if (zzzVar.zzw == -1) {
                zzx zzb = zzzVar.zzb();
                zzb.zzam(zzcdVar.zzb);
                zzb.zzQ(zzcdVar.zzc);
                this.zzp = new zzpc(zzb.zzan(), 0, zzpcVar.zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzu(zzmp zzmpVar, String str) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar == null || !zzvhVar.zzb()) {
            zzx();
            this.zzj = str;
            this.zzk = new PlaybackMetrics.Builder().setPlayerName(MediaLibraryInfo.TAG).setPlayerVersion("1.8.0-alpha01");
            zzA(zzmpVar.zzb, zzvhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzv(zzmp zzmpVar, String str, boolean z) {
        zzvh zzvhVar = zzmpVar.zzd;
        if ((zzvhVar == null || !zzvhVar.zzb()) && str.equals(this.zzj)) {
            zzx();
        }
        this.zzh.remove(str);
        this.zzi.remove(str);
    }
}
