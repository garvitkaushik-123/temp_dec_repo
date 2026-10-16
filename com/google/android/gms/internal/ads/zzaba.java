package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaba extends zztp implements zzabr {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private int zzB;
    private zzmh zzC;
    private boolean zzD;
    private long zzE;
    private int zzF;
    private long zzG;
    private zzcd zzH;
    private zzcd zzI;
    private int zzJ;
    private int zzK;
    private zzabp zzL;
    private long zzM;
    private long zzN;
    private boolean zzO;
    private final Context zze;
    private final boolean zzf;
    private final zzaci zzg;
    private final boolean zzh;
    private final zzabs zzi;
    private final zzabq zzj;
    private final PriorityQueue zzk;
    private zzaaz zzl;
    private boolean zzm;
    private boolean zzn;
    private zzaco zzo;
    private boolean zzp;
    private int zzq;
    private List zzr;
    private Surface zzs;
    private zzabd zzt;
    private zzeo zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected zzaba(zzaay zzaayVar) {
        super(2, r2, r3, false, 30.0f);
        zztd zztdVar;
        zztr zztrVar;
        Context context;
        Handler handler;
        zzacj zzacjVar;
        zztdVar = zzaayVar.zzd;
        zztrVar = zzaayVar.zzc;
        context = zzaayVar.zza;
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzo = null;
        handler = zzaayVar.zze;
        zzacjVar = zzaayVar.zzf;
        this.zzg = new zzaci(handler, zzacjVar);
        this.zzf = this.zzo == null;
        this.zzi = new zzabs(applicationContext, this, 0L);
        this.zzj = new zzabq();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzu = zzeo.zza;
        this.zzw = 1;
        this.zzx = 0;
        this.zzH = zzcd.zza;
        this.zzK = 0;
        this.zzI = null;
        this.zzJ = -1000;
        this.zzM = -9223372036854775807L;
        this.zzN = -9223372036854775807L;
        this.zzk = new PriorityQueue();
        this.zzC = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0081, code lost:
    
        if (r3.equals("video/av01") != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzaf(zzti zztiVar, zzz zzzVar) {
        int i = zzzVar.zzv;
        int i2 = zzzVar.zzw;
        if (i != -1 && i2 != -1) {
            String str = zzzVar.zzo;
            str.getClass();
            char c = 2;
            if ("video/dolby-vision".equals(str)) {
                int i3 = zzuc.zza;
                Pair zza = zzdk.zza(zzzVar);
                if (zza != null) {
                    int intValue = ((Integer) zza.first).intValue();
                    if (intValue == 512 || intValue == 1 || intValue == 2) {
                        str = "video/avc";
                    } else if (intValue == 1024) {
                        str = "video/av01";
                    }
                }
                str = "video/hevc";
            }
            int i4 = 4;
            switch (str.hashCode()) {
                case -1664118616:
                    if (str.equals("video/3gpp")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1662735862:
                    break;
                case -1662541442:
                    if (str.equals("video/hevc")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1187890754:
                    if (str.equals("video/mp4v-es")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1331836730:
                    if (str.equals("video/avc")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1599127256:
                    if (str.equals("video/x-vnd.on2.vp8")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return ((i * i2) * 3) / i4;
                case 4:
                    return Math.max(2097152, ((i * i2) * 3) / 4);
                case 5:
                    if (!"BRAVIA 4K 2015".equals(Build.MODEL) && (!"Amazon".equals(Build.MANUFACTURER) || (!"KFSOWI".equals(Build.MODEL) && (!"AFTS".equals(Build.MODEL) || !zztiVar.zzf)))) {
                        String str2 = zzex.zza;
                        return ((((i + 15) / 16) * ((i2 + 15) / 16)) * 768) / 4;
                    }
                    break;
                case 6:
                    i4 = 8;
                    return ((i * i2) * 3) / i4;
            }
        }
        return -1;
    }

    protected static int zzag(zzti zztiVar, zzz zzzVar) {
        int i = zzzVar.zzp;
        if (i == -1) {
            return zzaf(zztiVar, zzzVar);
        }
        List list = zzzVar.zzr;
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += ((byte[]) list.get(i3)).length;
        }
        return i + i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:
    
        if (r1.equals("AFTEUFF014") != false) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static final boolean zzbe(String str) {
        boolean z;
        boolean z2 = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (zzaba.class) {
            if (!zzc) {
                char c = 5;
                if (Build.VERSION.SDK_INT <= 28) {
                    String str2 = Build.DEVICE;
                    switch (str2.hashCode()) {
                        case -1339091551:
                            if (str2.equals("dangal")) {
                                z = true;
                                break;
                            }
                            z = -1;
                            break;
                        case -1220081023:
                            if (str2.equals("dangalFHD")) {
                                z = 3;
                                break;
                            }
                            z = -1;
                            break;
                        case -1220066608:
                            if (str2.equals("dangalUHD")) {
                                z = 2;
                                break;
                            }
                            z = -1;
                            break;
                        case -1012436106:
                            if (str2.equals("oneday")) {
                                z = 7;
                                break;
                            }
                            z = -1;
                            break;
                        case -760312546:
                            if (str2.equals("aquaman")) {
                                z = false;
                                break;
                            }
                            z = -1;
                            break;
                        case -64886864:
                            if (str2.equals("magnolia")) {
                                z = 4;
                                break;
                            }
                            z = -1;
                            break;
                        case 3415681:
                            if (str2.equals("once")) {
                                z = 6;
                                break;
                            }
                            z = -1;
                            break;
                        case 825323514:
                            if (str2.equals("machuca")) {
                                z = 5;
                                break;
                            }
                            z = -1;
                            break;
                        default:
                            z = -1;
                            break;
                    }
                    switch (z) {
                        case false:
                        case true:
                        case true:
                        case true:
                        case true:
                        case true:
                        case true:
                        case true:
                            z2 = true;
                            break;
                    }
                    zzd = z2;
                    zzc = true;
                }
                String str3 = Build.MODEL;
                switch (str3.hashCode()) {
                    case -349662828:
                        if (str3.equals("AFTJMST12")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -321033677:
                        if (str3.equals("AFTKMST12")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2006354:
                        if (str3.equals("AFTA")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2006367:
                        if (str3.equals("AFTN")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2006371:
                        if (str3.equals("AFTR")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1785421873:
                        if (str3.equals("AFTEU011")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1785421876:
                        if (str3.equals("AFTEU014")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1798172390:
                        if (str3.equals("AFTSO001")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2119412532:
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                }
                zzd = z2;
                zzc = true;
            }
        }
        return zzd;
    }

    protected static final boolean zzbf(zzti zztiVar) {
        return Build.VERSION.SDK_INT >= 35 && zztiVar.zzh;
    }

    private final Surface zzbg(zzti zztiVar) {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            return zzacoVar.zzb();
        }
        Surface surface = this.zzs;
        if (surface != null) {
            return surface;
        }
        if (zzbf(zztiVar)) {
            return null;
        }
        zzdd.zzf(zzbd(zztiVar));
        zzabd zzabdVar = this.zzt;
        if (zzabdVar != null) {
            if (zzabdVar.zza != zztiVar.zzf) {
                zzbl();
            }
        }
        if (this.zzt == null) {
            this.zzt = zzabd.zza(this.zze, zztiVar.zzf);
        }
        return this.zzt;
    }

    private static List zzbh(Context context, zztr zztrVar, zzz zzzVar, boolean z, boolean z2) throws zztw {
        String str = zzzVar.zzo;
        if (str == null) {
            return zzfyq.zzn();
        }
        if ("video/dolby-vision".equals(str) && !zzaax.zza(context)) {
            List zzc2 = zzuc.zzc(zztrVar, zzzVar, z, z2);
            if (!zzc2.isEmpty()) {
                return zzc2;
            }
        }
        return zzuc.zze(zztrVar, zzzVar, z, z2);
    }

    private final void zzbi() {
        zzcd zzcdVar = this.zzI;
        if (zzcdVar != null) {
            this.zzg.zzt(zzcdVar);
        }
    }

    private final void zzbj(long j, long j2, zzz zzzVar) {
        zzabp zzabpVar = this.zzL;
        if (zzabpVar != null) {
            zzabpVar.zzcT(j, j2, zzzVar, zzaC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public final void zzbk() {
        this.zzg.zzq(this.zzs);
        this.zzv = true;
    }

    private final void zzbl() {
        zzabd zzabdVar = this.zzt;
        if (zzabdVar != null) {
            zzabdVar.release();
            this.zzt = null;
        }
    }

    private final void zzbm(Object obj) throws zzin {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzs == surface) {
            if (surface != null) {
                zzbi();
                Surface surface2 = this.zzs;
                if (surface2 == null || !this.zzv) {
                    return;
                }
                this.zzg.zzq(surface2);
                return;
            }
            return;
        }
        this.zzs = surface;
        if (this.zzo == null) {
            this.zzi.zzk(surface);
        }
        this.zzv = false;
        int zzcU = zzcU();
        zztf zzaF = zzaF();
        if (zzaF != null && this.zzo == null) {
            zzti zzaH = zzaH();
            zzaH.getClass();
            if (!zzbn(zzaH) || this.zzm) {
                zzaM();
                zzaJ();
            } else {
                Surface zzbg = zzbg(zzaH);
                if (zzbg != null) {
                    zzaF.zzp(zzbg);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zzaF.zzi();
                }
            }
        }
        if (surface != null) {
            zzbi();
        } else {
            this.zzI = null;
            zzaco zzacoVar = this.zzo;
            if (zzacoVar != null) {
                zzacoVar.zzi();
            }
        }
        if (zzcU == 2) {
            zzaco zzacoVar2 = this.zzo;
            if (zzacoVar2 != null) {
                zzacoVar2.zzk(true);
            } else {
                this.zzi.zzc(true);
            }
        }
    }

    private final boolean zzbn(zzti zztiVar) {
        if (this.zzo != null) {
            return true;
        }
        Surface surface = this.zzs;
        return (surface != null && surface.isValid()) || zzbf(zztiVar) || zzbd(zztiVar);
    }

    private final boolean zzbo(zzhs zzhsVar) {
        return zzhsVar.zze < zzcW();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzA(long j, boolean z) throws zzin {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null && !z) {
            zzacoVar.zzj(true);
        }
        super.zzA(j, z);
        if (this.zzo == null) {
            this.zzi.zzg();
        }
        if (z) {
            zzaco zzacoVar2 = this.zzo;
            if (zzacoVar2 != null) {
                zzacoVar2.zzk(false);
            } else {
                this.zzi.zzc(false);
            }
        }
        this.zzA = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzB() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null || !this.zzf) {
            return;
        }
        zzacoVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzD() {
        try {
            super.zzD();
        } finally {
            this.zzp = false;
            this.zzM = -9223372036854775807L;
            zzbl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzE() {
        this.zzz = 0;
        this.zzy = zzcX().zzb();
        this.zzE = 0L;
        this.zzF = 0;
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzx();
        } else {
            this.zzi.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected final void zzF() {
        if (this.zzz > 0) {
            long zzb2 = zzcX().zzb();
            this.zzg.zzn(this.zzz, zzb2 - this.zzy);
            this.zzz = 0;
            this.zzy = zzb2;
        }
        int i = this.zzF;
        if (i != 0) {
            this.zzg.zzr(this.zzE, i);
            this.zzE = 0L;
            this.zzF = 0;
        }
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzy();
        } else {
            this.zzi.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzG(zzz[] zzzVarArr, long j, long j2, zzvh zzvhVar) throws zzin {
        super.zzG(zzzVarArr, j, j2, zzvhVar);
        zzbl zzi = zzi();
        if (zzi.zzo()) {
            this.zzN = -9223372036854775807L;
        } else {
            this.zzN = zzi.zzn(zzvhVar.zza, new zzbj()).zzd;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final void zzN(float f, float f2) throws zzin {
        super.zzN(f, f2);
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzt(f);
        } else {
            this.zzi.zzl(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzmd
    public final String zzV() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final void zzW(long j, long j2) throws zzin {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            try {
                zzacoVar.zzo(j, j2);
            } catch (zzacn e) {
                throw zzk(e, e.zza, false, 7001);
            }
        }
        super.zzW(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzX() {
        if (!super.zzX()) {
            return false;
        }
        zzaco zzacoVar = this.zzo;
        return zzacoVar == null || zzacoVar.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzma
    public final boolean zzY() {
        boolean zzY = super.zzY();
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            return zzacoVar.zzD(zzY);
        }
        if (zzY && zzaF() == null) {
            return true;
        }
        return this.zzi.zzm(zzY);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zzth zzaG(Throwable th, zzti zztiVar) {
        return new zzaau(th, zztiVar, this.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzaK(long j) {
        super.zzaK(j);
        this.zzB--;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzaL(zzhs zzhsVar) throws zzin {
        int zzay = zzay(zzhsVar);
        if (Build.VERSION.SDK_INT < 34 || (zzay & 32) == 0) {
            this.zzB++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzaN() {
        super.zzaN();
        this.zzk.clear();
        this.zzB = 0;
        this.zzD = false;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzaT(zzz zzzVar) throws zzin {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null || zzacoVar.zzC()) {
            return true;
        }
        try {
            zzacoVar.zzA(zzzVar);
            return true;
        } catch (zzacn e) {
            throw zzk(e, zzzVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzaU(zzhs zzhsVar) {
        boolean z = false;
        if (!zzR() && !zzhsVar.zzh() && this.zzN != -9223372036854775807L) {
            if (this.zzN - (zzhsVar.zze - zzaA()) > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US && zzbo(zzhsVar)) {
                if (zzhsVar.zze()) {
                    return false;
                }
                if (zzhsVar.zzi()) {
                    zzhsVar.zzb();
                    z = true;
                }
                if (z) {
                    this.zza.zzd++;
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzaV() {
        return this.zzC == null || this.zzD || zzaQ() || zzaz() != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzaW(zzti zztiVar) {
        return zzbn(zztiVar);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzaX() {
        zzti zzaH = zzaH();
        if (this.zzo != null && zzaH != null) {
            String str = zzaH.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaX();
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final float zzaa(float f, zzz zzzVar, zzz[] zzzVarArr) {
        zzti zzaH;
        float f2 = -1.0f;
        for (zzz zzzVar2 : zzzVarArr) {
            float f3 = zzzVar2.zzz;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        float f4 = f2 == -1.0f ? -1.0f : f2 * f;
        if (this.zzC == null || (zzaH = zzaH()) == null) {
            return f4;
        }
        float zza = zzaH.zza(zzzVar.zzv, zzzVar.zzw);
        return f4 != -1.0f ? Math.max(f4, zza) : zza;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final int zzab(zztr zztrVar, zzz zzzVar) throws zztw {
        boolean z;
        String str = zzzVar.zzo;
        if (!zzay.zzj(str)) {
            return 128;
        }
        Context context = this.zze;
        int i = 0;
        boolean z2 = zzzVar.zzs != null;
        List zzbh = zzbh(context, zztrVar, zzzVar, z2, false);
        if (z2 && zzbh.isEmpty()) {
            zzbh = zzbh(context, zztrVar, zzzVar, false, false);
        }
        if (zzbh.isEmpty()) {
            return 129;
        }
        if (!zzaY(zzzVar)) {
            return 130;
        }
        zzti zztiVar = (zzti) zzbh.get(0);
        boolean zzf = zztiVar.zzf(zzzVar);
        if (!zzf) {
            for (int i2 = 1; i2 < zzbh.size(); i2++) {
                zzti zztiVar2 = (zzti) zzbh.get(i2);
                if (zztiVar2.zzf(zzzVar)) {
                    zzf = true;
                    z = false;
                    zztiVar = zztiVar2;
                    break;
                }
            }
        }
        z = true;
        int i3 = true != zzf ? 3 : 4;
        int i4 = true != zztiVar.zzg(zzzVar) ? 8 : 16;
        int i5 = true != zztiVar.zzg ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if ("video/dolby-vision".equals(str) && !zzaax.zza(context)) {
            i6 = 256;
        }
        if (zzf) {
            List zzbh2 = zzbh(context, zztrVar, zzzVar, z2, true);
            if (!zzbh2.isEmpty()) {
                zzti zztiVar3 = (zzti) zzuc.zzf(zzbh2, zzzVar).get(0);
                if (zztiVar3.zzf(zzzVar) && zztiVar3.zzg(zzzVar)) {
                    i = 32;
                }
            }
        }
        return i3 | i4 | i | i5 | i6;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zzie zzad(zzti zztiVar, zzz zzzVar, zzz zzzVar2) {
        int i;
        int i2;
        zzie zzc2 = zztiVar.zzc(zzzVar, zzzVar2);
        int i3 = zzc2.zze;
        zzaaz zzaazVar = this.zzl;
        zzaazVar.getClass();
        if (zzzVar2.zzv > zzaazVar.zza || zzzVar2.zzw > zzaazVar.zzb) {
            i3 |= 256;
        }
        if (zzag(zztiVar, zzzVar2) > zzaazVar.zzc) {
            i3 |= 64;
        }
        String str = zztiVar.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzc2.zzd;
        }
        return new zzie(str, zzzVar, zzzVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zzie zzae(zzkv zzkvVar) throws zzin {
        zzie zzae = super.zzae(zzkvVar);
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        this.zzg.zzp(zzzVar, zzae);
        return zzae;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final zztc zzaj(zzti zztiVar, zzz zzzVar, MediaCrypto mediaCrypto, float f) {
        zzaaz zzaazVar;
        Point point;
        int i;
        int i2;
        int i3;
        boolean z;
        zzz[] zzzVarArr;
        char c;
        boolean z2;
        int zzaf;
        zzz[] zzU = zzU();
        int length = zzU.length;
        int zzag = zzag(zztiVar, zzzVar);
        int i4 = zzzVar.zzw;
        int i5 = zzzVar.zzv;
        if (length == 1) {
            if (zzag != -1 && (zzaf = zzaf(zztiVar, zzzVar)) != -1) {
                zzag = Math.min((int) (zzag * 1.5f), zzaf);
            }
            zzaazVar = new zzaaz(i5, i4, zzag);
        } else {
            int i6 = i4;
            int i7 = i5;
            int i8 = 0;
            boolean z3 = false;
            while (i8 < length) {
                zzz zzzVar2 = zzU[i8];
                zzk zzkVar = zzzVar.zzE;
                if (zzkVar != null && zzzVar2.zzE == null) {
                    zzx zzb2 = zzzVar2.zzb();
                    zzb2.zzF(zzkVar);
                    zzzVar2 = zzb2.zzan();
                }
                if (zztiVar.zzc(zzzVar, zzzVar2).zzd != 0) {
                    int i9 = zzzVar2.zzv;
                    c = 65535;
                    if (i9 != -1) {
                        zzzVarArr = zzU;
                        if (zzzVar2.zzw != -1) {
                            z2 = false;
                            z3 |= z2;
                            i7 = Math.max(i7, i9);
                            i6 = Math.max(i6, zzzVar2.zzw);
                            zzag = Math.max(zzag, zzag(zztiVar, zzzVar2));
                        }
                    } else {
                        zzzVarArr = zzU;
                    }
                    z2 = true;
                    z3 |= z2;
                    i7 = Math.max(i7, i9);
                    i6 = Math.max(i6, zzzVar2.zzw);
                    zzag = Math.max(zzag, zzag(zztiVar, zzzVar2));
                } else {
                    zzzVarArr = zzU;
                    c = 65535;
                }
                i8++;
                zzU = zzzVarArr;
            }
            if (z3) {
                zzea.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i7 + VastAttributes.HORIZONTAL_POSITION + i6);
                boolean z4 = i4 > i5;
                int i10 = z4 ? i4 : i5;
                int i11 = true != z4 ? i4 : i5;
                int[] iArr = zzb;
                int i12 = 0;
                while (i12 < 9) {
                    float f2 = i11;
                    float f3 = i10;
                    int i13 = iArr[i12];
                    int i14 = i12;
                    float f4 = i13;
                    if (i13 <= i10 || (i = (int) (f4 * (f2 / f3))) <= i11) {
                        break;
                    }
                    int i15 = i10;
                    if (true != z4) {
                        i2 = i11;
                        i3 = i13;
                    } else {
                        i2 = i11;
                        i3 = i;
                    }
                    if (true != z4) {
                        i13 = i;
                    }
                    point = zztiVar.zzb(i3, i13);
                    float f5 = zzzVar.zzz;
                    if (point != null) {
                        z = z4;
                        if (zztiVar.zzh(point.x, point.y, f5)) {
                            break;
                        }
                    } else {
                        z = z4;
                    }
                    i12 = i14 + 1;
                    i10 = i15;
                    i11 = i2;
                    z4 = z;
                }
                point = null;
                if (point != null) {
                    i7 = Math.max(i7, point.x);
                    i6 = Math.max(i6, point.y);
                    zzx zzb3 = zzzVar.zzb();
                    zzb3.zzam(i7);
                    zzb3.zzQ(i6);
                    zzag = Math.max(zzag, zzaf(zztiVar, zzb3.zzan()));
                    zzea.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i7 + VastAttributes.HORIZONTAL_POSITION + i6);
                }
            }
            zzaazVar = new zzaaz(i7, i6, zzag);
        }
        String str = zztiVar.zzc;
        this.zzl = zzaazVar;
        boolean z5 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i5);
        mediaFormat.setInteger("height", i4);
        zzed.zzb(mediaFormat, zzzVar.zzr);
        float f6 = zzzVar.zzz;
        if (f6 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f6);
        }
        zzed.zza(mediaFormat, "rotation-degrees", zzzVar.zzA);
        zzk zzkVar2 = zzzVar.zzE;
        if (zzkVar2 != null) {
            zzed.zza(mediaFormat, "color-transfer", zzkVar2.zzd);
            zzed.zza(mediaFormat, "color-standard", zzkVar2.zzb);
            zzed.zza(mediaFormat, "color-range", zzkVar2.zzc);
            byte[] bArr = zzkVar2.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzzVar.zzo)) {
            int i16 = zzuc.zza;
            Pair zza = zzdk.zza(zzzVar);
            if (zza != null) {
                zzed.zza(mediaFormat, Scopes.PROFILE, ((Integer) zza.first).intValue());
            }
        }
        mediaFormat.setInteger("max-width", zzaazVar.zza);
        mediaFormat.setInteger("max-height", zzaazVar.zzb);
        zzed.zza(mediaFormat, "max-input-size", zzaazVar.zzc);
        mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if (z5) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzJ));
        }
        Surface zzbg = zzbg(zztiVar);
        if (this.zzo != null && !zzex.zzL(this.zze)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return zztc.zzb(zztiVar, mediaFormat, zzzVar, zzbg, null);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final List zzak(zztr zztrVar, zzz zzzVar, boolean z) throws zztw {
        return zzuc.zzf(zzbh(this.zze, zztrVar, zzzVar, false, false), zzzVar);
    }

    protected final void zzam(zztf zztfVar, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zztfVar.zzn(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzA = 0;
        if (this.zzo == null) {
            zzcd zzcdVar = this.zzH;
            if (!zzcdVar.equals(zzcd.zza) && !zzcdVar.equals(this.zzI)) {
                this.zzI = zzcdVar;
                this.zzg.zzt(zzcdVar);
            }
            if (!this.zzi.zzn() || this.zzs == null) {
                return;
            }
            zzbk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzan(zzhs zzhsVar) throws zzin {
        if (this.zzn) {
            ByteBuffer byteBuffer = zzhsVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zztf zzaF = zzaF();
                        zzaF.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzaF.zzq(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzao(Exception exc) {
        zzea.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzap(String str, zztc zztcVar, long j, long j2) {
        this.zzg.zzk(str, j, j2);
        this.zzm = zzbe(str);
        zzti zzaH = zzaH();
        zzaH.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(zzaH.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzi = zzaH.zzi();
            int length = zzi.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (zzi[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.zzn = z;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzaq(String str) {
        this.zzg.zzl(str);
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzar(zzz zzzVar, MediaFormat mediaFormat) {
        zztf zzaF = zzaF();
        if (zzaF != null) {
            zzaF.zzr(this.zzw);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f = zzzVar.zzB;
        int i = zzzVar.zzA;
        if (i == 90 || i == 270) {
            f = 1.0f / f;
            int i2 = integer2;
            integer2 = integer;
            integer = i2;
        }
        this.zzH = new zzcd(integer, integer2, f);
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null || !this.zzO) {
            this.zzi.zzj(zzzVar.zzz);
        } else {
            zzx zzb2 = zzzVar.zzb();
            zzb2.zzam(integer);
            zzb2.zzQ(integer2);
            zzb2.zzad(f);
            zzz zzan = zzb2.zzan();
            int i3 = this.zzq;
            List list = this.zzr;
            if (list == null) {
                list = zzfyq.zzn();
            }
            zzacoVar.zzl(1, zzan, zzaB(), i3, list);
            this.zzq = 2;
        }
        this.zzO = false;
    }

    protected final void zzas(zztf zztfVar, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zztfVar.zzo(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzat() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzw();
            long j = this.zzM;
            if (j == -9223372036854775807L) {
                j = zzaB();
                this.zzM = j;
            }
            this.zzo.zzp(-j);
        } else {
            this.zzi.zzf(2);
        }
        this.zzO = true;
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final void zzau() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final int zzay(zzhs zzhsVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzC == null || !zzbo(zzhsVar)) ? 0 : 32;
    }

    protected final void zzba(int i, int i2) {
        zzid zzidVar = this.zza;
        zzidVar.zzh += i;
        int i3 = i + i2;
        zzidVar.zzg += i3;
        this.zzz += i3;
        int i4 = this.zzA + i3;
        this.zzA = i4;
        zzidVar.zzi = Math.max(i4, zzidVar.zzi);
    }

    protected final void zzbb(long j) {
        zzid zzidVar = this.zza;
        zzidVar.zzk += j;
        zzidVar.zzl++;
        this.zzE += j;
        this.zzF++;
    }

    @Override // com.google.android.gms.internal.ads.zzabr
    public final boolean zzbc(long j, long j2, long j3, boolean z, boolean z2) throws zzin {
        int zzd2;
        if (this.zzo != null && this.zzf) {
            j2 -= -this.zzM;
        }
        if (j >= -500000 || z || (zzd2 = zzd(j2)) == 0) {
            return false;
        }
        if (z2) {
            zzid zzidVar = this.zza;
            int i = zzidVar.zzd + zzd2;
            zzidVar.zzd = i;
            zzidVar.zzf += this.zzB;
            zzidVar.zzd = i + this.zzk.size();
        } else {
            this.zza.zzj++;
            zzba(zzd2 + this.zzk.size(), this.zzB);
        }
        zzaP();
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            zzacoVar.zzj(false);
        }
        return true;
    }

    protected final boolean zzbd(zzti zztiVar) {
        if (zzbe(zztiVar.zza)) {
            return false;
        }
        return !zztiVar.zzf || zzabd.zzb(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final void zzu() {
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null) {
            this.zzi.zzb();
            return;
        }
        int i = this.zzq;
        if (i == 0 || i == 1) {
            this.zzq = 0;
        } else {
            zzacoVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzy() {
        this.zzI = null;
        this.zzN = -9223372036854775807L;
        this.zzv = false;
        this.zzD = true;
        try {
            super.zzy();
        } finally {
            zzaci zzaciVar = this.zzg;
            zzaciVar.zzm(this.zza);
            zzaciVar.zzt(zzcd.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic
    protected final void zzz(boolean z, boolean z2) throws zzin {
        super.zzz(z, z2);
        zzo();
        this.zzg.zzo(this.zza);
        if (!this.zzp) {
            if (this.zzr != null && this.zzo == null) {
                zzabh zzabhVar = new zzabh(this.zze, this.zzi);
                zzabhVar.zze(true);
                zzabhVar.zzd(zzcX());
                zzabo zzf = zzabhVar.zzf();
                zzf.zzt(1);
                this.zzo = zzf.zze(0);
            }
            this.zzp = true;
        }
        int i = !z2 ? 1 : 0;
        zzaco zzacoVar = this.zzo;
        if (zzacoVar == null) {
            zzabs zzabsVar = this.zzi;
            zzabsVar.zzi(zzcX());
            zzabsVar.zzf(i);
            return;
        }
        zzacoVar.zzr(new zzaav(this), zzgef.zzc());
        zzabp zzabpVar = this.zzL;
        if (zzabpVar != null) {
            this.zzo.zzv(zzabpVar);
        }
        if (this.zzs != null && !this.zzu.equals(zzeo.zza)) {
            this.zzo.zzs(this.zzs, this.zzu);
        }
        this.zzo.zzq(this.zzx);
        this.zzo.zzt(zzax());
        List list = this.zzr;
        if (list != null) {
            this.zzo.zzu(list);
        }
        this.zzq = i;
        zzaI();
    }

    @Override // com.google.android.gms.internal.ads.zztp
    protected final boolean zzav(long j, long j2, zztf zztfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) throws zzin {
        zzaba zzabaVar;
        long j4;
        zztfVar.getClass();
        long zzaA = j3 - zzaA();
        int i4 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.zzk;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j3) {
                break;
            }
            priorityQueue.poll();
            i4++;
        }
        zzba(i4, 0);
        zzaco zzacoVar = this.zzo;
        if (zzacoVar != null) {
            if (!z || z2) {
                return zzacoVar.zzz(j3, new zzaaw(this, zztfVar, i, zzaA));
            }
            zzas(zztfVar, i, zzaA);
            return true;
        }
        zzabs zzabsVar = this.zzi;
        long zzaB = zzaB();
        zzabq zzabqVar = this.zzj;
        int zza = zzabsVar.zza(j3, j, j2, zzaB, z, z2, zzabqVar);
        if (zza == 0) {
            long zzc2 = zzcX().zzc();
            zzbj(zzaA, zzc2, zzzVar);
            zzam(zztfVar, i, zzaA, zzc2);
            zzbb(zzabqVar.zzc());
            return true;
        }
        if (zza != 1) {
            if (zza != 2) {
                if (zza != 3) {
                    return false;
                }
                zzas(zztfVar, i, zzaA);
                zzbb(zzabqVar.zzc());
                return true;
            }
            Trace.beginSection("dropVideoBuffer");
            zztfVar.zzo(i, false);
            Trace.endSection();
            zzba(0, 1);
            zzbb(zzabqVar.zzc());
            return true;
        }
        long zzd2 = zzabqVar.zzd();
        long zzc3 = zzabqVar.zzc();
        if (zzd2 == this.zzG) {
            zzas(zztfVar, i, zzaA);
            j4 = zzd2;
            zzabaVar = this;
        } else {
            zzbj(zzaA, zzd2, zzzVar);
            zzam(zztfVar, i, zzaA, zzd2);
            zzabaVar = this;
            j4 = zzd2;
        }
        zzabaVar.zzbb(zzc3);
        zzabaVar.zzG = j4;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlv
    public final void zzv(int i, Object obj) throws zzin {
        if (i == 1) {
            zzbm(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            zzabp zzabpVar = (zzabp) obj;
            this.zzL = zzabpVar;
            zzaco zzacoVar = this.zzo;
            if (zzacoVar != null) {
                zzacoVar.zzv(zzabpVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int intValue = ((Integer) obj).intValue();
            if (this.zzK != intValue) {
                this.zzK = intValue;
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int intValue2 = ((Integer) obj).intValue();
            this.zzw = intValue2;
            zztf zzaF = zzaF();
            if (zzaF != null) {
                zzaF.zzr(intValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int intValue3 = ((Integer) obj).intValue();
            this.zzx = intValue3;
            zzaco zzacoVar2 = this.zzo;
            if (zzacoVar2 != null) {
                zzacoVar2.zzq(intValue3);
                return;
            } else {
                this.zzi.zzh(intValue3);
                return;
            }
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbz.zza)) {
                zzaco zzacoVar3 = this.zzo;
                if (zzacoVar3 == null || !zzacoVar3.zzC()) {
                    return;
                }
                zzacoVar3.zzm();
                return;
            }
            this.zzr = list;
            zzaco zzacoVar4 = this.zzo;
            if (zzacoVar4 != null) {
                zzacoVar4.zzu(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            zzeo zzeoVar = (zzeo) obj;
            if (zzeoVar.zzb() == 0 || zzeoVar.zza() == 0) {
                return;
            }
            this.zzu = zzeoVar;
            zzaco zzacoVar5 = this.zzo;
            if (zzacoVar5 != null) {
                Surface surface = this.zzs;
                zzdd.zzb(surface);
                zzacoVar5.zzs(surface, zzeoVar);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.zzJ = ((Integer) obj).intValue();
                zztf zzaF2 = zzaF();
                if (zzaF2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzJ));
                    zzaF2.zzq(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzs;
                zzbm(null);
                obj.getClass();
                ((zzaba) obj).zzv(1, surface2);
                break;
            case 18:
                boolean z = this.zzC != null;
                zzmh zzmhVar = (zzmh) obj;
                this.zzC = zzmhVar;
                if (z != (zzmhVar != null)) {
                    zzaZ();
                    break;
                }
                break;
            default:
                super.zzv(i, obj);
                break;
        }
    }
}
