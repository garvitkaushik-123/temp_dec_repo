package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.google.android.gms.common.Scopes;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzru extends zztp implements zzlb {
    private final Context zzb;
    private final zzqg zzc;
    private final zzqo zzd;
    private final zztb zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzz zzi;
    private zzz zzj;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzru(Context context, zztd zztdVar, zztr zztrVar, boolean z, Handler handler, zzqh zzqhVar, zzqo zzqoVar) {
        super(1, zztdVar, zztrVar, false, 44100.0f);
        zzrt zzrtVar = null;
        zztb zztbVar = Build.VERSION.SDK_INT >= 35 ? new zztb(zzta.zza) : null;
        this.zzb = context.getApplicationContext();
        this.zzd = zzqoVar;
        this.zze = zztbVar;
        this.zzo = -1000;
        this.zzc = new zzqg(handler, zzqhVar);
        this.zzq = -9223372036854775807L;
        zzqoVar.zzr(new zzrs(this, zzrtVar));
    }

    private final int zzba(zzti zztiVar, zzz zzzVar) {
        "OMX.google.raw.decoder".equals(zztiVar.zza);
        return zzzVar.zzp;
    }

    private static List zzbb(zztr zztrVar, zzz zzzVar, boolean z, zzqo zzqoVar) throws zztw {
        zzti zza;
        return zzzVar.zzo == null ? zzfyq.zzn() : (!zzqoVar.zzB(zzzVar) || (zza = zzuc.zza()) == null) ? zzuc.zze(zztrVar, zzzVar, false, false) : zzfyq.zzo(zza);
    }

    private final void zzbc() {
        long zzc = this.zzd.zzc(zzX());
        if (zzc != Long.MIN_VALUE) {
            if (!this.zzl) {
                zzc = Math.max(this.zzk, zzc);
            }
            this.zzk = zzc;
            this.zzl = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzA(long j, boolean z) throws zzin {
        super.zzA(j, z);
        this.zzd.zzg();
        this.zzk = j;
        this.zzq = -9223372036854775807L;
        this.zzn = false;
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzB() {
        zztb zztbVar;
        this.zzd.zzl();
        if (Build.VERSION.SDK_INT < 35 || (zztbVar = this.zze) == null) {
            return;
        }
        zztbVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzD() {
        this.zzn = false;
        this.zzq = -9223372036854775807L;
        try {
            super.zzD();
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzm();
            }
        } catch (Throwable th) {
            if (this.zzm) {
                this.zzm = false;
                this.zzd.zzm();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzE() {
        this.zzd.zzj();
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzF() {
        zzbc();
        this.zzp = false;
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzmd
    public final String zzV() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzX() {
        return super.zzX() && this.zzd.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzY() {
        return this.zzd.zzz() || super.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final long zza() {
        if (zzcU() == 2) {
            zzbc();
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final float zzaa(float f, zzz zzzVar, zzz[] zzzVarArr) {
        int i = -1;
        for (zzz zzzVar2 : zzzVarArr) {
            int i2 = zzzVar2.zzH;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return i * f;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final int zzab(zztr zztrVar, zzz zzzVar) throws zztw {
        int i;
        boolean z;
        String str = zzzVar.zzo;
        if (!zzay.zzh(str)) {
            return 128;
        }
        int i2 = zzzVar.zzN;
        boolean zzaY = zzaY(zzzVar);
        int i3 = 1;
        if (!zzaY || (i2 != 0 && zzuc.zza() == null)) {
            i = 0;
        } else {
            zzqo zzqoVar = this.zzd;
            zzps zze = zzqoVar.zze(zzzVar);
            if (zze.zzb) {
                i = true != zze.zzc ? 512 : 1536;
                if (zze.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (zzqoVar.zzB(zzzVar)) {
                return i | 172;
            }
        }
        if (!"audio/raw".equals(str) || this.zzd.zzB(zzzVar)) {
            zzqo zzqoVar2 = this.zzd;
            if (zzqoVar2.zzB(zzex.zzA(2, zzzVar.zzG, zzzVar.zzH))) {
                List zzbb = zzbb(zztrVar, zzzVar, false, zzqoVar2);
                if (!zzbb.isEmpty()) {
                    if (zzaY) {
                        zzti zztiVar = (zzti) zzbb.get(0);
                        boolean zzf = zztiVar.zzf(zzzVar);
                        if (!zzf) {
                            for (int i4 = 1; i4 < zzbb.size(); i4++) {
                                zzti zztiVar2 = (zzti) zzbb.get(i4);
                                if (zztiVar2.zzf(zzzVar)) {
                                    z = false;
                                    zzf = true;
                                    zztiVar = zztiVar2;
                                    break;
                                }
                            }
                        }
                        z = true;
                        int i5 = true != zzf ? 3 : 4;
                        int i6 = 8;
                        if (zzf && zztiVar.zzg(zzzVar)) {
                            i6 = 16;
                        }
                        return i5 | i6 | 32 | (true != zztiVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                    }
                    i3 = 2;
                }
            }
        }
        return i3 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final long zzac(long j, long j2, boolean z) {
        if (this.zzq != -9223372036854775807L) {
            if (this.zzd.zzb() != -9223372036854775807L) {
                long min = (long) ((Math.min(r4, this.zzq - j) / (zzc() != null ? zzc().zzb : 1.0f)) / 2.0f);
                if (this.zzp) {
                    min -= zzex.zzs(zzcX().zzb()) - j2;
                }
                return Math.max(10000L, min);
            }
        }
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zzie zzad(zzti zztiVar, zzz zzzVar, zzz zzzVar2) {
        int i;
        int i2;
        zzie zzc = zztiVar.zzc(zzzVar, zzzVar2);
        int i3 = zzc.zze;
        if (zzaS(zzzVar2)) {
            i3 |= 32768;
        }
        if (zzba(zztiVar, zzzVar2) > this.zzf) {
            i3 |= 64;
        }
        String str = zztiVar.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzc.zzd;
        }
        return new zzie(str, zzzVar, zzzVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zztc zzaj(zzti zztiVar, zzz zzzVar, MediaCrypto mediaCrypto, float f) {
        zzz[] zzU = zzU();
        int length = zzU.length;
        int zzba = zzba(zztiVar, zzzVar);
        if (length != 1) {
            for (zzz zzzVar2 : zzU) {
                if (zztiVar.zzc(zzzVar, zzzVar2).zzd != 0) {
                    zzba = Math.max(zzba, zzba(zztiVar, zzzVar2));
                }
            }
        }
        this.zzf = zzba;
        String str = zztiVar.zza;
        this.zzg = false;
        this.zzh = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zztiVar.zzc;
        int i = this.zzf;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        int i2 = zzzVar.zzG;
        mediaFormat.setInteger("channel-count", i2);
        int i3 = zzzVar.zzH;
        mediaFormat.setInteger("sample-rate", i3);
        zzed.zzb(mediaFormat, zzzVar.zzr);
        zzed.zza(mediaFormat, "max-input-size", i);
        mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        String str3 = zzzVar.zzo;
        if ("audio/ac4".equals(str3)) {
            Pair zza = zzdk.zza(zzzVar);
            if (zza != null) {
                zzed.zza(mediaFormat, Scopes.PROFILE, ((Integer) zza.first).intValue());
                zzed.zza(mediaFormat, "level", ((Integer) zza.second).intValue());
            }
            if (Build.VERSION.SDK_INT <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        if (this.zzd.zza(zzex.zzA(4, i2, i3)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (Build.VERSION.SDK_INT >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzo));
        }
        this.zzj = (!"audio/raw".equals(zztiVar.zzb) || "audio/raw".equals(str3)) ? null : zzzVar;
        return zztc.zza(zztiVar, mediaFormat, zzzVar, null, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final List zzak(zztr zztrVar, zzz zzzVar, boolean z) throws zztw {
        return zzuc.zzf(zzbb(zztrVar, zzzVar, false, this.zzd), zzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzan(zzhs zzhsVar) {
        zzz zzzVar;
        if (Build.VERSION.SDK_INT < 29 || (zzzVar = zzhsVar.zza) == null || !Objects.equals(zzzVar.zzo, "audio/opus") || !zzaR()) {
            return;
        }
        ByteBuffer byteBuffer = zzhsVar.zzf;
        byteBuffer.getClass();
        zzz zzzVar2 = zzhsVar.zza;
        zzzVar2.getClass();
        int i = zzzVar2.zzJ;
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzs(i, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzao(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzn(exc);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzap(String str, zztc zztcVar, long j, long j2) {
        this.zzc.zzs(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzaq(String str) {
        this.zzc.zzt(str);
    }

    protected final void zzas() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzat() {
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzau() throws zzin {
        try {
            this.zzd.zzk();
            if (zzaz() != -9223372036854775807L) {
                this.zzq = zzaz();
            }
        } catch (zzqn e) {
            throw zzk(e, e.zzc, e.zzb, true != zzaR() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzaw(zzz zzzVar) {
        zzo();
        return this.zzd.zzB(zzzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final zzbb zzc() {
        return this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final void zzg(zzbb zzbbVar) {
        this.zzd.zzt(zzbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final zzlb zzm() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzy() {
        this.zzm = true;
        this.zzi = null;
        this.zzq = -9223372036854775807L;
        try {
            this.zzd.zzg();
            super.zzy();
        } catch (Throwable th) {
            super.zzy();
            throw th;
        } finally {
            this.zzc.zzu(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzz(boolean z, boolean z2) throws zzin {
        super.zzz(z, z2);
        this.zzc.zzv(this.zza);
        zzo();
        zzqo zzqoVar = this.zzd;
        zzqoVar.zzu(zzp());
        zzqoVar.zzq(zzcX());
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zzie zzae(zzkv zzkvVar) throws zzin {
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        this.zzi = zzzVar;
        zzie zzae = super.zzae(zzkvVar);
        this.zzc.zzw(zzzVar, zzae);
        return zzae;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzav(long j, long j2, zztf zztfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) throws zzin {
        byteBuffer.getClass();
        this.zzq = -9223372036854775807L;
        if (this.zzj != null && (i2 & 2) != 0) {
            zztfVar.getClass();
            zztfVar.zzo(i, false);
            return true;
        }
        if (z) {
            if (zztfVar != null) {
                zztfVar.zzo(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzh();
            return true;
        }
        try {
            if (!this.zzd.zzy(byteBuffer, j3, i3)) {
                this.zzq = j3;
                return false;
            }
            if (zztfVar != null) {
                zztfVar.zzo(i, false);
            }
            this.zza.zze += i3;
            return true;
        } catch (zzqk e) {
            zzz zzzVar2 = this.zzi;
            if (zzaR()) {
                zzo();
            }
            throw zzk(e, zzzVar2, e.zzb, 5001);
        } catch (zzqn e2) {
            if (zzaR()) {
                zzo();
            }
            throw zzk(e2, zzzVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlv
    public final void zzv(int i, Object obj) throws zzin {
        zztb zztbVar;
        if (i == 2) {
            zzqo zzqoVar = this.zzd;
            obj.getClass();
            zzqoVar.zzx(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zze zzeVar = (zze) obj;
            zzqo zzqoVar2 = this.zzd;
            zzeVar.getClass();
            zzqoVar2.zzn(zzeVar);
            return;
        }
        if (i == 6) {
            zzf zzfVar = (zzf) obj;
            zzqo zzqoVar3 = this.zzd;
            zzfVar.getClass();
            zzqoVar3.zzp(zzfVar);
            return;
        }
        if (i == 12) {
            this.zzd.zzv((AudioDeviceInfo) obj);
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.zzo = ((Integer) obj).intValue();
            zztf zzaF = zzaF();
            if (zzaF == null || Build.VERSION.SDK_INT < 35) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.zzo));
            zzaF.zzq(bundle);
            return;
        }
        if (i == 9) {
            zzqo zzqoVar4 = this.zzd;
            obj.getClass();
            zzqoVar4.zzw(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                super.zzv(i, obj);
                return;
            }
            obj.getClass();
            int intValue = ((Integer) obj).intValue();
            this.zzd.zzo(intValue);
            if (Build.VERSION.SDK_INT < 35 || (zztbVar = this.zze) == null) {
                return;
            }
            zztbVar.zzd(intValue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzar(zzz zzzVar, MediaFormat mediaFormat) throws zzin {
        int[] iArr;
        int i;
        zzz zzzVar2 = this.zzj;
        int[] iArr2 = null;
        boolean z = true;
        if (zzzVar2 != null) {
            zzzVar = zzzVar2;
        } else if (zzaF() != null) {
            mediaFormat.getClass();
            int integer = "audio/raw".equals(zzzVar.zzo) ? zzzVar.zzI : mediaFormat.containsKey("pcm-encoding") ? mediaFormat.getInteger("pcm-encoding") : mediaFormat.containsKey("v-bits-per-sample") ? zzex.zzn(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2;
            zzx zzxVar = new zzx();
            zzxVar.zzah("audio/raw");
            zzxVar.zzab(integer);
            zzxVar.zzM(zzzVar.zzJ);
            zzxVar.zzN(zzzVar.zzK);
            zzxVar.zzaa(zzzVar.zzl);
            Object obj = zzzVar.zzm;
            zzxVar.zzS(zzzVar.zza);
            zzxVar.zzU(zzzVar.zzb);
            zzxVar.zzV(zzzVar.zzc);
            zzxVar.zzW(zzzVar.zzd);
            zzxVar.zzaj(zzzVar.zze);
            zzxVar.zzaf(zzzVar.zzf);
            zzxVar.zzD(mediaFormat.getInteger("channel-count"));
            zzxVar.zzai(mediaFormat.getInteger("sample-rate"));
            zzz zzan = zzxVar.zzan();
            if (this.zzg && zzan.zzG == 6 && (i = zzzVar.zzG) < 6) {
                iArr2 = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    iArr2[i2] = i2;
                }
            } else if (this.zzh) {
                int i3 = zzan.zzG;
                if (i3 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i3 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i3 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i3 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i3 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzzVar = zzan;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                if (zzaR()) {
                    zzo();
                }
                if (Build.VERSION.SDK_INT < 29) {
                    z = false;
                }
                zzdd.zzf(z);
            }
            this.zzd.zzf(zzzVar, 0, iArr2);
        } catch (zzqj e) {
            throw zzk(e, e.zza, false, 5001);
        }
    }
}
