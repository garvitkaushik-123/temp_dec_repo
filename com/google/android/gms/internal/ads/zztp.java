package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import com.google.android.gms.ads.AdError;
import com.google.common.base.Ascii;
import com.ironsource.C3040d4;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.media3.common.PlaybackException;
import io.bidmachine.rendering.model.EventTaskParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zztp extends zzic {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private zzti zzA;
    private int zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private boolean zzI;
    private long zzJ;
    private int zzK;
    private int zzL;
    private ByteBuffer zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private boolean zzW;
    private boolean zzX;
    private boolean zzY;
    private long zzZ;
    protected zzid zza;
    private long zzaa;
    private boolean zzab;
    private boolean zzac;
    private boolean zzad;
    private zztn zzae;
    private long zzaf;
    private boolean zzag;
    private boolean zzah;
    private boolean zzai;
    private long zzaj;
    private long zzak;
    private zzsi zzal;
    private zzsi zzam;
    private final zztd zzc;
    private final zztr zzd;
    private final float zze;
    private final zzhs zzf;
    private final zzhs zzg;
    private final zzhs zzh;
    private final zzsw zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrv zzl;
    private zzz zzm;
    private zzz zzn;
    private zzlz zzo;
    private MediaCrypto zzp;
    private long zzq;
    private float zzr;
    private float zzs;
    private zztf zzt;
    private zzz zzu;
    private MediaFormat zzv;
    private boolean zzw;
    private float zzx;
    private ArrayDeque zzy;
    private zztl zzz;

    public zztp(int i, zztd zztdVar, zztr zztrVar, boolean z, float f) {
        super(i);
        this.zzc = zztdVar;
        zztrVar.getClass();
        this.zzd = zztrVar;
        this.zze = f;
        this.zzf = new zzhs(0, 0);
        this.zzg = new zzhs(0, 0);
        this.zzh = new zzhs(2, 0);
        zzsw zzswVar = new zzsw();
        this.zzi = zzswVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzr = 1.0f;
        this.zzs = 1.0f;
        this.zzq = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzae = zztn.zza;
        zzswVar.zzj(0);
        zzswVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrv();
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzT = 0;
        this.zzK = -1;
        this.zzL = -1;
        this.zzJ = -9223372036854775807L;
        this.zzZ = -9223372036854775807L;
        this.zzaa = -9223372036854775807L;
        this.zzaf = -9223372036854775807L;
        this.zzH = -9223372036854775807L;
        this.zzU = 0;
        this.zzV = 0;
        this.zza = new zzid();
        this.zzaj = -9223372036854775807L;
        this.zzak = -9223372036854775807L;
    }

    protected static boolean zzaY(zzz zzzVar) {
        return zzzVar.zzN == 0;
    }

    private final void zzaf() {
        this.zzP = false;
        zzal();
    }

    private final void zzag() throws zzin {
        if (this.zzW) {
            this.zzU = 1;
            this.zzV = 3;
        } else {
            zzaM();
            zzaJ();
        }
    }

    private final void zzah() {
        try {
            zztf zztfVar = this.zzt;
            zzdd.zzb(zztfVar);
            zztf zztfVar2 = zztfVar;
            zztfVar.zzj();
        } finally {
            zzaN();
        }
    }

    private final void zzal() {
        zzam();
        this.zzR = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzQ = false;
        this.zzl.zzb();
    }

    private final void zzam() {
        this.zzZ = -9223372036854775807L;
        this.zzaa = -9223372036854775807L;
        this.zzaf = -9223372036854775807L;
    }

    private final void zzas() {
        this.zzK = -1;
        this.zzg.zzc = null;
    }

    private final void zzba() {
        this.zzL = -1;
        this.zzM = null;
    }

    private final void zzbb(zztn zztnVar) {
        this.zzae = zztnVar;
        if (zztnVar.zzd != -9223372036854775807L) {
            this.zzag = true;
        }
    }

    private final boolean zzbd() throws zzin {
        if (this.zzW) {
            this.zzU = 1;
            if (this.zzD) {
                this.zzV = 3;
                return false;
            }
            this.zzV = 2;
        } else {
            zzbc();
        }
        return true;
    }

    private final boolean zzbe() {
        if (this.zzt == null) {
            return false;
        }
        if (zzaX()) {
            zzaM();
            return true;
        }
        if (zzaV()) {
            zzah();
            return false;
        }
        long j = this.zzak;
        if (j == -9223372036854775807L || zzcW() > j || this.zzaf >= j) {
            return false;
        }
        this.zzai = true;
        this.zzak = -9223372036854775807L;
        return false;
    }

    private final boolean zzbf() {
        return this.zzL >= 0;
    }

    private final boolean zzbg(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzz zzzVar = this.zzn;
        return (zzzVar != null && Objects.equals(zzzVar.zzo, "audio/opus") && zzaeq.zzf(j, j2)) ? false : true;
    }

    private final boolean zzbh(int i) throws zzin {
        zzkv zzl = zzl();
        zzhs zzhsVar = this.zzf;
        zzhsVar.zzb();
        int zzcV = zzcV(zzl, zzhsVar, i | 4);
        if (zzcV == -5) {
            zzae(zzl);
            return true;
        }
        if (zzcV != -4 || !zzhsVar.zzf()) {
            return false;
        }
        this.zzab = true;
        zzai();
        return false;
    }

    private final boolean zzbi(long j) {
        return this.zzq == -9223372036854775807L || zzcX().zzb() - j < this.zzq;
    }

    private final boolean zzbj(zzz zzzVar) throws zzin {
        if (this.zzt != null && this.zzV != 3 && zzcU() != 0) {
            float f = this.zzs;
            zzzVar.getClass();
            float zzaa = zzaa(f, zzzVar, zzU());
            float f2 = this.zzx;
            if (f2 != zzaa) {
                if (zzaa == -1.0f) {
                    zzag();
                    return false;
                }
                if (f2 != -1.0f || zzaa > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", zzaa);
                    zztf zztfVar = this.zzt;
                    zztfVar.getClass();
                    zztfVar.zzq(bundle);
                    this.zzx = zzaa;
                }
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzA(long j, boolean z) throws zzin {
        this.zzab = false;
        this.zzac = false;
        if (this.zzP) {
            zzal();
        } else {
            zzaP();
        }
        zzet zzetVar = this.zzae.zze;
        if (zzetVar.zza() > 0) {
            this.zzad = true;
        }
        zzetVar.zze();
        this.zzk.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzD() {
        try {
            zzaf();
            zzaM();
        } finally {
            this.zzam = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void zzG(zzz[] zzzVarArr, long j, long j2, zzvh zzvhVar) throws zzin {
        if (this.zzae.zzd == -9223372036854775807L) {
            zzbb(new zztn(-9223372036854775807L, j, j2));
            if (this.zzah) {
                zzat();
                return;
            }
            return;
        }
        ArrayDeque arrayDeque = this.zzk;
        if (arrayDeque.isEmpty()) {
            long j3 = this.zzZ;
            if (j3 != -9223372036854775807L) {
                long j4 = this.zzaf;
                if (j4 != -9223372036854775807L) {
                }
            }
            zzbb(new zztn(-9223372036854775807L, j, j2));
            if (this.zzae.zzd != -9223372036854775807L) {
                zzat();
                return;
            }
            return;
        }
        arrayDeque.add(new zztn(this.zzZ, j, j2));
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public void zzN(float f, float f2) throws zzin {
        this.zzr = f;
        this.zzs = f2;
        zzbj(this.zzu);
    }

    /* JADX WARN: Code restructure failed: missing block: B:227:0x02b3, code lost:
    
        if (r21.zzn != null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x036a, code lost:
    
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x055a, code lost:
    
        android.os.Trace.endSection();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02ef A[Catch: IllegalStateException -> 0x057d, CryptoException -> 0x05ca, TryCatch #3 {CryptoException -> 0x05ca, blocks: (B:3:0x0003, B:5:0x0007, B:8:0x000b, B:10:0x0010, B:13:0x0016, B:281:0x0032, B:283:0x0051, B:285:0x0062, B:380:0x007c, B:355:0x01b6, B:58:0x0575, B:294:0x0090, B:295:0x0094, B:297:0x0098, B:300:0x009e, B:303:0x00af, B:304:0x00be, B:367:0x00cb, B:369:0x00d1, B:344:0x019e, B:346:0x01a4, B:347:0x01a7, B:349:0x01ad, B:351:0x01b1, B:308:0x00d7, B:365:0x00dd, B:310:0x00e5, B:312:0x00f5, B:314:0x00ff, B:317:0x0105, B:319:0x0109, B:321:0x0116, B:323:0x0120, B:324:0x013d, B:326:0x0145, B:327:0x0146, B:329:0x014d, B:331:0x0155, B:333:0x015b, B:334:0x0162, B:336:0x016e, B:337:0x0177, B:340:0x0192, B:343:0x0198, B:360:0x017e, B:363:0x00fd, B:371:0x019b, B:412:0x0071, B:17:0x01cb, B:19:0x01d2, B:20:0x01e0, B:22:0x01e4, B:24:0x01f2, B:28:0x01fd, B:30:0x0203, B:32:0x020e, B:34:0x0218, B:36:0x0220, B:38:0x035b, B:44:0x036c, B:46:0x0370, B:48:0x0375, B:50:0x037b, B:52:0x0382, B:54:0x038a, B:60:0x0395, B:173:0x039a, B:175:0x039e, B:176:0x03ad, B:57:0x055a, B:63:0x03b1, B:65:0x03b5, B:67:0x03be, B:68:0x0550, B:73:0x03d8, B:74:0x03d9, B:77:0x03df, B:79:0x03e3, B:81:0x03ee, B:83:0x03fe, B:85:0x0407, B:87:0x0408, B:89:0x040b, B:90:0x040c, B:92:0x0412, B:94:0x041d, B:164:0x0424, B:166:0x042a, B:99:0x0433, B:101:0x0437, B:102:0x043e, B:103:0x0443, B:154:0x044b, B:156:0x0453, B:157:0x0458, B:159:0x045e, B:160:0x0463, B:162:0x0467, B:105:0x0478, B:107:0x047c, B:109:0x0482, B:111:0x0489, B:112:0x048d, B:114:0x0493, B:116:0x0499, B:117:0x049e, B:119:0x04a4, B:121:0x04ac, B:123:0x04b8, B:124:0x04ce, B:126:0x04bf, B:127:0x04c0, B:129:0x04c8, B:131:0x04d1, B:132:0x04d2, B:134:0x04e0, B:136:0x04e8, B:138:0x04f1, B:139:0x04f4, B:141:0x0501, B:144:0x0514, B:145:0x0534, B:146:0x0520, B:148:0x0529, B:150:0x0544, B:151:0x0505, B:152:0x04e6, B:169:0x0546, B:171:0x0558, B:181:0x0223, B:183:0x0228, B:185:0x0229, B:187:0x022d, B:189:0x0231, B:191:0x0235, B:192:0x0238, B:194:0x023e, B:196:0x024d, B:198:0x0254, B:200:0x0258, B:201:0x0261, B:203:0x0265, B:206:0x026b, B:207:0x026f, B:209:0x0279, B:210:0x0288, B:212:0x0296, B:214:0x029a, B:216:0x029e, B:218:0x02aa, B:219:0x02b5, B:221:0x02b9, B:223:0x02c6, B:224:0x02ad, B:226:0x02b1, B:228:0x02c7, B:231:0x02d6, B:233:0x02de, B:236:0x02e9, B:238:0x02ef, B:240:0x02f5, B:242:0x02fd, B:243:0x0302, B:244:0x030a, B:246:0x031c, B:248:0x0328, B:250:0x032e, B:254:0x033e, B:256:0x0342, B:258:0x0346, B:259:0x0350, B:263:0x0355, B:269:0x0561, B:275:0x0565, B:276:0x0566), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x031c A[Catch: IllegalStateException -> 0x057d, CryptoException -> 0x05ca, TRY_LEAVE, TryCatch #3 {CryptoException -> 0x05ca, blocks: (B:3:0x0003, B:5:0x0007, B:8:0x000b, B:10:0x0010, B:13:0x0016, B:281:0x0032, B:283:0x0051, B:285:0x0062, B:380:0x007c, B:355:0x01b6, B:58:0x0575, B:294:0x0090, B:295:0x0094, B:297:0x0098, B:300:0x009e, B:303:0x00af, B:304:0x00be, B:367:0x00cb, B:369:0x00d1, B:344:0x019e, B:346:0x01a4, B:347:0x01a7, B:349:0x01ad, B:351:0x01b1, B:308:0x00d7, B:365:0x00dd, B:310:0x00e5, B:312:0x00f5, B:314:0x00ff, B:317:0x0105, B:319:0x0109, B:321:0x0116, B:323:0x0120, B:324:0x013d, B:326:0x0145, B:327:0x0146, B:329:0x014d, B:331:0x0155, B:333:0x015b, B:334:0x0162, B:336:0x016e, B:337:0x0177, B:340:0x0192, B:343:0x0198, B:360:0x017e, B:363:0x00fd, B:371:0x019b, B:412:0x0071, B:17:0x01cb, B:19:0x01d2, B:20:0x01e0, B:22:0x01e4, B:24:0x01f2, B:28:0x01fd, B:30:0x0203, B:32:0x020e, B:34:0x0218, B:36:0x0220, B:38:0x035b, B:44:0x036c, B:46:0x0370, B:48:0x0375, B:50:0x037b, B:52:0x0382, B:54:0x038a, B:60:0x0395, B:173:0x039a, B:175:0x039e, B:176:0x03ad, B:57:0x055a, B:63:0x03b1, B:65:0x03b5, B:67:0x03be, B:68:0x0550, B:73:0x03d8, B:74:0x03d9, B:77:0x03df, B:79:0x03e3, B:81:0x03ee, B:83:0x03fe, B:85:0x0407, B:87:0x0408, B:89:0x040b, B:90:0x040c, B:92:0x0412, B:94:0x041d, B:164:0x0424, B:166:0x042a, B:99:0x0433, B:101:0x0437, B:102:0x043e, B:103:0x0443, B:154:0x044b, B:156:0x0453, B:157:0x0458, B:159:0x045e, B:160:0x0463, B:162:0x0467, B:105:0x0478, B:107:0x047c, B:109:0x0482, B:111:0x0489, B:112:0x048d, B:114:0x0493, B:116:0x0499, B:117:0x049e, B:119:0x04a4, B:121:0x04ac, B:123:0x04b8, B:124:0x04ce, B:126:0x04bf, B:127:0x04c0, B:129:0x04c8, B:131:0x04d1, B:132:0x04d2, B:134:0x04e0, B:136:0x04e8, B:138:0x04f1, B:139:0x04f4, B:141:0x0501, B:144:0x0514, B:145:0x0534, B:146:0x0520, B:148:0x0529, B:150:0x0544, B:151:0x0505, B:152:0x04e6, B:169:0x0546, B:171:0x0558, B:181:0x0223, B:183:0x0228, B:185:0x0229, B:187:0x022d, B:189:0x0231, B:191:0x0235, B:192:0x0238, B:194:0x023e, B:196:0x024d, B:198:0x0254, B:200:0x0258, B:201:0x0261, B:203:0x0265, B:206:0x026b, B:207:0x026f, B:209:0x0279, B:210:0x0288, B:212:0x0296, B:214:0x029a, B:216:0x029e, B:218:0x02aa, B:219:0x02b5, B:221:0x02b9, B:223:0x02c6, B:224:0x02ad, B:226:0x02b1, B:228:0x02c7, B:231:0x02d6, B:233:0x02de, B:236:0x02e9, B:238:0x02ef, B:240:0x02f5, B:242:0x02fd, B:243:0x0302, B:244:0x030a, B:246:0x031c, B:248:0x0328, B:250:0x032e, B:254:0x033e, B:256:0x0342, B:258:0x0346, B:259:0x0350, B:263:0x0355, B:269:0x0561, B:275:0x0565, B:276:0x0566), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x055e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0362 A[LOOP:0: B:20:0x01e0->B:40:0x0362, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0361 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.google.android.gms.internal.ads.zzma
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zzW(long j, long j2) throws zzin {
        boolean z;
        boolean z2;
        boolean z3;
        ?? r2;
        ?? r5;
        long j3;
        boolean z4;
        zzz zzzVar;
        Throwable th;
        boolean z5 = true;
        try {
            try {
                if (this.zzac) {
                    zzau();
                    return;
                }
                int i = 2;
                if (this.zzm != null || zzbh(2)) {
                    zzaJ();
                    Throwable th2 = null;
                    try {
                        try {
                            if (this.zzP) {
                                try {
                                    try {
                                        Trace.beginSection("bypassRender");
                                        while (true) {
                                            zzdd.zzf(this.zzac ^ z5);
                                            zzsw zzswVar = this.zzi;
                                            if (zzswVar.zzq()) {
                                                ByteBuffer byteBuffer = zzswVar.zzc;
                                                int i2 = this.zzL;
                                                int zzm = zzswVar.zzm();
                                                long j4 = zzswVar.zze;
                                                boolean zzbg = zzbg(zzcW(), zzswVar.zzn());
                                                boolean zzf = zzswVar.zzf();
                                                zzz zzzVar2 = this.zzn;
                                                if (zzzVar2 == null) {
                                                    throw th2;
                                                }
                                                zzz zzzVar3 = zzzVar2;
                                                if (!zzav(j, j2, null, byteBuffer, i2, 0, zzm, j4, zzbg, zzf, zzzVar2)) {
                                                    z5 = true;
                                                    break;
                                                } else {
                                                    zzaK(zzswVar.zzn());
                                                    zzswVar.zzb();
                                                    r2 = 0;
                                                }
                                            } else {
                                                r2 = th2;
                                            }
                                            try {
                                                if (this.zzab) {
                                                    z5 = true;
                                                    this.zzac = true;
                                                    break;
                                                }
                                                z5 = true;
                                                if (this.zzQ) {
                                                    zzdd.zzf(zzswVar.zzp(this.zzh));
                                                    r5 = 0;
                                                    this.zzQ = false;
                                                } else {
                                                    r5 = 0;
                                                }
                                                if (this.zzR) {
                                                    if (!zzswVar.zzq()) {
                                                        zzaf();
                                                        this.zzR = r5;
                                                        zzaJ();
                                                        if (!this.zzP) {
                                                            break;
                                                        }
                                                    } else {
                                                        th2 = r2;
                                                    }
                                                }
                                                zzdd.zzf(!this.zzab);
                                                zzkv zzl = zzl();
                                                zzhs zzhsVar = this.zzh;
                                                zzhsVar.zzb();
                                                do {
                                                    zzhsVar.zzb();
                                                    int zzcV = zzcV(zzl, zzhsVar, r5);
                                                    if (zzcV == -5) {
                                                        zzae(zzl);
                                                        break;
                                                    }
                                                    if (zzcV == -4) {
                                                        if (!zzhsVar.zzf()) {
                                                            long max = Math.max(this.zzZ, zzhsVar.zze);
                                                            this.zzZ = max;
                                                            if (zzR() || this.zzg.zzh()) {
                                                                this.zzaa = max;
                                                            }
                                                            if (this.zzad) {
                                                                zzz zzzVar4 = this.zzm;
                                                                if (zzzVar4 == null) {
                                                                    throw r2;
                                                                }
                                                                zzz zzzVar5 = zzzVar4;
                                                                this.zzn = zzzVar4;
                                                                if (Objects.equals(zzzVar4.zzo, "audio/opus") && !this.zzn.zzr.isEmpty()) {
                                                                    int zza = zzaeq.zza((byte[]) this.zzn.zzr.get(r5));
                                                                    zzx zzb2 = this.zzn.zzb();
                                                                    zzb2.zzM(zza);
                                                                    this.zzn = zzb2.zzan();
                                                                }
                                                                zzar(this.zzn, r2);
                                                                this.zzad = r5;
                                                            }
                                                            zzhsVar.zzk();
                                                            zzz zzzVar6 = this.zzn;
                                                            if (zzzVar6 != null && Objects.equals(zzzVar6.zzo, "audio/opus")) {
                                                                if (zzhsVar.zze()) {
                                                                    zzhsVar.zza = this.zzn;
                                                                    zzan(zzhsVar);
                                                                }
                                                                if (zzaeq.zzf(zzcW(), zzhsVar.zze)) {
                                                                    this.zzl.zza(zzhsVar, this.zzn.zzr);
                                                                }
                                                            }
                                                            if (zzswVar.zzq()) {
                                                                long zzcW = zzcW();
                                                                if (zzbg(zzcW, zzswVar.zzn()) != zzbg(zzcW, zzhsVar.zze)) {
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            this.zzab = true;
                                                            this.zzaa = this.zzZ;
                                                            break;
                                                        }
                                                    } else if (zzR()) {
                                                        this.zzaa = this.zzZ;
                                                    }
                                                } while (zzswVar.zzp(zzhsVar));
                                                this.zzQ = true;
                                                if (zzswVar.zzq()) {
                                                    zzswVar.zzk();
                                                }
                                                if (!zzswVar.zzq() && !this.zzab && !this.zzR) {
                                                    break;
                                                }
                                                th2 = r2;
                                            } catch (IllegalStateException e) {
                                                e = e;
                                                z5 = true;
                                                z = z5;
                                                z2 = e instanceof MediaCodec.CodecException;
                                                if (!z2) {
                                                    StackTraceElement[] stackTrace = e.getStackTrace();
                                                    if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                                                        throw e;
                                                    }
                                                }
                                                zzao(e);
                                                z3 = (z2 || !((MediaCodec.CodecException) e).isRecoverable()) ? false : z;
                                                if (z3) {
                                                    zzaM();
                                                }
                                                zzth zzaG = zzaG(e, this.zzA);
                                                throw zzk(zzaG, this.zzm, z3, zzaG.zza == 1101 ? PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED : 4003);
                                            }
                                        }
                                        Trace.endSection();
                                    } catch (IllegalStateException e2) {
                                        e = e2;
                                    }
                                } catch (MediaCodec.CryptoException e3) {
                                    e = e3;
                                    throw zzk(e, this.zzm, false, zzex.zzl(e.getErrorCode()));
                                }
                            } else {
                                Throwable th3 = null;
                                boolean z6 = false;
                                if (this.zzt != null) {
                                    long zzb3 = zzcX().zzb();
                                    Trace.beginSection("drainAndFeed");
                                    long j5 = zzb3;
                                    while (true) {
                                        zztf zztfVar = this.zzt;
                                        if (zztfVar == null) {
                                            throw th3;
                                        }
                                        zztf zztfVar2 = zztfVar;
                                        if (!zzbf()) {
                                            MediaCodec.BufferInfo bufferInfo = this.zzj;
                                            int zzb4 = zztfVar.zzb(bufferInfo);
                                            if (zzb4 >= 0) {
                                                if (!this.zzF) {
                                                    if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                                                        zzai();
                                                        break;
                                                    }
                                                    this.zzL = zzb4;
                                                    ByteBuffer zzg = zztfVar.zzg(zzb4);
                                                    this.zzM = zzg;
                                                    if (zzg != null) {
                                                        zzg.position(bufferInfo.offset);
                                                        this.zzM.limit(bufferInfo.offset + bufferInfo.size);
                                                    }
                                                    zzz zzzVar7 = (zzz) this.zzae.zze.zzc(bufferInfo.presentationTimeUs);
                                                    if (zzzVar7 == null && this.zzag && this.zzv != null) {
                                                        zzzVar7 = (zzz) this.zzae.zze.zzb();
                                                    }
                                                    if (zzzVar7 != null) {
                                                        this.zzn = zzzVar7;
                                                    } else if (this.zzw) {
                                                    }
                                                    zzz zzzVar8 = this.zzn;
                                                    if (zzzVar8 == null) {
                                                        throw th3;
                                                    }
                                                    zzz zzzVar9 = zzzVar8;
                                                    zzar(zzzVar8, this.zzv);
                                                    this.zzw = z6;
                                                    this.zzag = z6;
                                                } else {
                                                    this.zzF = z6;
                                                    zztfVar.zzo(zzb4, z6);
                                                    th = th3;
                                                    if (!zzbi(j5)) {
                                                    }
                                                }
                                            } else if (zzb4 == -2) {
                                                this.zzY = z5;
                                                zztf zztfVar3 = this.zzt;
                                                if (zztfVar3 == null) {
                                                    throw th3;
                                                }
                                                zztf zztfVar4 = zztfVar3;
                                                MediaFormat zzc = zztfVar3.zzc();
                                                if (this.zzB != 0 && zzc.getInteger("width") == 32 && zzc.getInteger("height") == 32) {
                                                    this.zzF = z5;
                                                } else {
                                                    this.zzv = zzc;
                                                    this.zzw = z5;
                                                }
                                                th = th3;
                                                if (!zzbi(j5)) {
                                                    break;
                                                }
                                                th3 = th;
                                                z5 = true;
                                                i = 2;
                                                z6 = false;
                                            } else {
                                                if (this.zzG && (this.zzab || this.zzU == i)) {
                                                    zzai();
                                                }
                                                long j6 = this.zzH;
                                                if (j6 != -9223372036854775807L && j6 + 100 < zzcX().zza()) {
                                                    zzai();
                                                }
                                            }
                                        }
                                        MediaCodec.BufferInfo bufferInfo2 = this.zzj;
                                        this.zzN = bufferInfo2.presentationTimeUs < zzcW() ? z5 : z6;
                                        long j7 = this.zzaa;
                                        if (j7 != -9223372036854775807L) {
                                            j3 = j5;
                                            if (j7 <= bufferInfo2.presentationTimeUs) {
                                                z4 = z5;
                                                this.zzO = z4;
                                                if (this.zzai) {
                                                    if (this.zzaj == -9223372036854775807L || bufferInfo2.presentationTimeUs > this.zzaj) {
                                                        this.zzaj = bufferInfo2.presentationTimeUs;
                                                        this.zzN = z5;
                                                        this.zzO = z6;
                                                    } else {
                                                        this.zzai = z6;
                                                        this.zzaj = -9223372036854775807L;
                                                    }
                                                }
                                                ByteBuffer byteBuffer2 = this.zzM;
                                                int i3 = this.zzL;
                                                int i4 = bufferInfo2.flags;
                                                long j8 = bufferInfo2.presentationTimeUs;
                                                boolean z7 = this.zzN;
                                                boolean z8 = this.zzO;
                                                long j9 = j3;
                                                zzzVar = this.zzn;
                                                if (zzzVar != null) {
                                                    throw th3;
                                                }
                                                zzz zzzVar10 = zzzVar;
                                                th = th3;
                                                if (!zzav(j, j2, zztfVar, byteBuffer2, i3, i4, 1, j8, z7, z8, zzzVar)) {
                                                    break;
                                                }
                                                zzaK(bufferInfo2.presentationTimeUs);
                                                boolean z9 = (bufferInfo2.flags & 4) != 0;
                                                if (!z9 && this.zzX && this.zzO) {
                                                    this.zzH = zzcX().zza();
                                                }
                                                zzba();
                                                if (z9) {
                                                    zzai();
                                                    break;
                                                } else {
                                                    j5 = j9;
                                                    if (!zzbi(j5)) {
                                                    }
                                                }
                                            }
                                        } else {
                                            j3 = j5;
                                        }
                                        z4 = z6;
                                        this.zzO = z4;
                                        if (this.zzai) {
                                        }
                                        ByteBuffer byteBuffer22 = this.zzM;
                                        int i32 = this.zzL;
                                        int i42 = bufferInfo2.flags;
                                        long j82 = bufferInfo2.presentationTimeUs;
                                        boolean z72 = this.zzN;
                                        boolean z82 = this.zzO;
                                        long j92 = j3;
                                        zzzVar = this.zzn;
                                        if (zzzVar != null) {
                                        }
                                    }
                                    th = th3;
                                    while (true) {
                                        zztf zztfVar5 = this.zzt;
                                        if (zztfVar5 != null && this.zzU != 2 && !this.zzab) {
                                            zztf zztfVar6 = zztfVar5;
                                            if (this.zzK < 0) {
                                                int zza2 = zztfVar5.zza();
                                                this.zzK = zza2;
                                                if (zza2 < 0) {
                                                    break;
                                                }
                                                zzhs zzhsVar2 = this.zzg;
                                                zzhsVar2.zzc = zztfVar5.zzf(zza2);
                                                zzhsVar2.zzb();
                                            }
                                            if (this.zzU != 1) {
                                                if (this.zzE) {
                                                    this.zzE = false;
                                                    ByteBuffer byteBuffer3 = this.zzg.zzc;
                                                    if (byteBuffer3 == null) {
                                                        throw th;
                                                    }
                                                    ByteBuffer byteBuffer4 = byteBuffer3;
                                                    byteBuffer3.put(zzb);
                                                    zztfVar5.zzk(this.zzK, 0, 38, 0L, 0);
                                                    zzas();
                                                    this.zzW = true;
                                                } else {
                                                    if (this.zzT == 1) {
                                                        int i5 = 0;
                                                        while (true) {
                                                            zzz zzzVar11 = this.zzu;
                                                            if (zzzVar11 == null) {
                                                                throw th;
                                                            }
                                                            zzz zzzVar12 = zzzVar11;
                                                            if (i5 >= zzzVar11.zzr.size()) {
                                                                this.zzT = 2;
                                                                break;
                                                            }
                                                            byte[] bArr = (byte[]) this.zzu.zzr.get(i5);
                                                            ByteBuffer byteBuffer5 = this.zzg.zzc;
                                                            if (byteBuffer5 == null) {
                                                                throw th;
                                                            }
                                                            ByteBuffer byteBuffer6 = byteBuffer5;
                                                            byteBuffer5.put(bArr);
                                                            i5++;
                                                        }
                                                    }
                                                    zzhs zzhsVar3 = this.zzg;
                                                    ByteBuffer byteBuffer7 = zzhsVar3.zzc;
                                                    if (byteBuffer7 == null) {
                                                        throw th;
                                                    }
                                                    ByteBuffer byteBuffer8 = byteBuffer7;
                                                    int position = byteBuffer7.position();
                                                    zzkv zzl2 = zzl();
                                                    try {
                                                        int zzcV2 = zzcV(zzl2, zzhsVar3, 0);
                                                        if (zzcV2 == -3) {
                                                            if (zzR()) {
                                                                this.zzaa = this.zzZ;
                                                            }
                                                        } else if (zzcV2 == -5) {
                                                            if (this.zzT == 2) {
                                                                this.zzg.zzb();
                                                                this.zzT = 1;
                                                            }
                                                            zzae(zzl2);
                                                        } else {
                                                            zzhs zzhsVar4 = this.zzg;
                                                            if (zzhsVar4.zzf()) {
                                                                this.zzaa = this.zzZ;
                                                                if (this.zzT == 2) {
                                                                    zzhsVar4.zzb();
                                                                    this.zzT = 1;
                                                                }
                                                                this.zzab = true;
                                                                if (!this.zzW) {
                                                                    zzai();
                                                                } else if (!this.zzG) {
                                                                    this.zzX = true;
                                                                    zztfVar5.zzk(this.zzK, 0, 0, 0L, 4);
                                                                    zzas();
                                                                }
                                                            } else if (!this.zzW && !zzhsVar4.zzg()) {
                                                                zzhsVar4.zzb();
                                                                if (this.zzT == 2) {
                                                                    this.zzT = 1;
                                                                }
                                                            } else if (!zzaU(zzhsVar4)) {
                                                                boolean zzl3 = zzhsVar4.zzl();
                                                                if (zzl3) {
                                                                    zzhsVar4.zzb.zzb(position);
                                                                }
                                                                long j10 = zzhsVar4.zze;
                                                                if (this.zzad) {
                                                                    ArrayDeque arrayDeque = this.zzk;
                                                                    if (arrayDeque.isEmpty()) {
                                                                        zzet zzetVar = this.zzae.zze;
                                                                        zzz zzzVar13 = this.zzm;
                                                                        if (zzzVar13 == null) {
                                                                            throw th;
                                                                        }
                                                                        zzz zzzVar14 = zzzVar13;
                                                                        zzetVar.zzd(j10, zzzVar13);
                                                                    } else {
                                                                        zzet zzetVar2 = ((zztn) arrayDeque.peekLast()).zze;
                                                                        zzz zzzVar15 = this.zzm;
                                                                        if (zzzVar15 == null) {
                                                                            throw th;
                                                                        }
                                                                        zzz zzzVar16 = zzzVar15;
                                                                        zzetVar2.zzd(j10, zzzVar15);
                                                                    }
                                                                    this.zzad = false;
                                                                }
                                                                long max2 = Math.max(this.zzZ, j10);
                                                                this.zzZ = max2;
                                                                if (zzR() || zzhsVar4.zzh()) {
                                                                    this.zzaa = max2;
                                                                }
                                                                zzhsVar4.zzk();
                                                                if (zzhsVar4.zze()) {
                                                                    zzan(zzhsVar4);
                                                                }
                                                                zzaL(zzhsVar4);
                                                                int zzay = zzay(zzhsVar4);
                                                                if (Build.VERSION.SDK_INT < 34 || (zzay & 32) == 0) {
                                                                    zzo();
                                                                    this.zzak = Math.max(this.zzak, zzhsVar4.zze);
                                                                }
                                                                if (zzl3) {
                                                                    zztf zztfVar7 = zztfVar5;
                                                                    zztfVar5.zzl(this.zzK, 0, zzhsVar4.zzb, j10, zzay);
                                                                } else {
                                                                    zztf zztfVar8 = zztfVar5;
                                                                    int i6 = this.zzK;
                                                                    ByteBuffer byteBuffer9 = zzhsVar4.zzc;
                                                                    if (byteBuffer9 == null) {
                                                                        throw th;
                                                                    }
                                                                    ByteBuffer byteBuffer10 = byteBuffer9;
                                                                    zztfVar5.zzk(i6, 0, byteBuffer9.limit(), j10, zzay);
                                                                }
                                                                zzas();
                                                                this.zzW = true;
                                                                this.zzT = 0;
                                                                this.zza.zzc++;
                                                            }
                                                        }
                                                    } catch (zzhr e4) {
                                                        zzao(e4);
                                                        zzbh(0);
                                                        zzah();
                                                    }
                                                }
                                                if (!zzbi(j5)) {
                                                    break;
                                                }
                                            } else {
                                                if (!this.zzG) {
                                                    this.zzX = true;
                                                    zztfVar5.zzk(this.zzK, 0, 0, 0L, 4);
                                                    zzas();
                                                }
                                                this.zzU = 2;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    this.zza.zzd += zzd(j);
                                    zzbh(1);
                                }
                            }
                            this.zza.zza();
                        } catch (IllegalStateException e5) {
                            e = e5;
                            z = true;
                            z2 = e instanceof MediaCodec.CodecException;
                            if (!z2) {
                            }
                            zzao(e);
                            if (z2) {
                            }
                            if (z3) {
                            }
                            zzth zzaG2 = zzaG(e, this.zzA);
                            throw zzk(zzaG2, this.zzm, z3, zzaG2.zza == 1101 ? PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED : 4003);
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        z2 = e instanceof MediaCodec.CodecException;
                        if (!z2) {
                        }
                        zzao(e);
                        if (z2) {
                        }
                        if (z3) {
                        }
                        zzth zzaG22 = zzaG(e, this.zzA);
                        throw zzk(zzaG22, this.zzm, z3, zzaG22.zza == 1101 ? PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED : 4003);
                    }
                }
            } catch (MediaCodec.CryptoException e7) {
                e = e7;
            }
        } catch (IllegalStateException e8) {
            e = e8;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public boolean zzX() {
        return this.zzac;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public boolean zzY() {
        if (this.zzm == null) {
            return false;
        }
        if (zzT() || zzbf()) {
            return true;
        }
        return this.zzJ != -9223372036854775807L && zzcX().zzb() < this.zzJ;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public final int zzZ(zzz zzzVar) throws zzin {
        try {
            return zzab(this.zzd, zzzVar);
        } catch (zztw e) {
            throw zzk(e, zzzVar, false, 4002);
        }
    }

    protected final long zzaA() {
        return this.zzae.zzd;
    }

    protected final long zzaB() {
        return this.zzae.zzc;
    }

    protected final MediaFormat zzaC() {
        return this.zzv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlz zzaE() {
        return this.zzo;
    }

    protected final zztf zzaF() {
        return this.zzt;
    }

    protected zzth zzaG(Throwable th, zzti zztiVar) {
        return new zzth(th, zztiVar);
    }

    protected final zzti zzaH() {
        return this.zzA;
    }

    public final void zzaI() {
        this.zzah = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0513 A[Catch: zztl -> 0x0542, TryCatch #5 {zztl -> 0x0542, blocks: (B:25:0x0057, B:27:0x005c, B:312:0x0063, B:314:0x0079, B:315:0x0084, B:29:0x0091, B:31:0x0099, B:33:0x009d, B:34:0x00a0, B:36:0x00a4, B:38:0x00ad, B:271:0x04f8, B:273:0x0513, B:274:0x051c, B:277:0x0529, B:278:0x052b, B:280:0x0516, B:303:0x052e, B:305:0x052f, B:308:0x0534, B:309:0x0535, B:310:0x053f, B:318:0x0088, B:319:0x0090, B:321:0x0541), top: B:24:0x0057, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0529 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0522 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0516 A[Catch: zztl -> 0x0542, TryCatch #5 {zztl -> 0x0542, blocks: (B:25:0x0057, B:27:0x005c, B:312:0x0063, B:314:0x0079, B:315:0x0084, B:29:0x0091, B:31:0x0099, B:33:0x009d, B:34:0x00a0, B:36:0x00a4, B:38:0x00ad, B:271:0x04f8, B:273:0x0513, B:274:0x051c, B:277:0x0529, B:278:0x052b, B:280:0x0516, B:303:0x052e, B:305:0x052f, B:308:0x0534, B:309:0x0535, B:310:0x053f, B:318:0x0088, B:319:0x0090, B:321:0x0541), top: B:24:0x0057, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x04b3 A[Catch: Exception -> 0x04e0, TryCatch #0 {Exception -> 0x04e0, blocks: (B:100:0x0147, B:102:0x0170, B:103:0x0178, B:105:0x017d, B:106:0x0185, B:108:0x0189, B:109:0x0191, B:111:0x0195, B:112:0x019d, B:114:0x01a1, B:116:0x01b1, B:119:0x0210, B:120:0x01b9, B:122:0x01c1, B:123:0x01c7, B:125:0x01cf, B:126:0x01d5, B:128:0x01dd, B:129:0x01e3, B:131:0x01eb, B:132:0x01f1, B:135:0x0215, B:136:0x0225, B:139:0x022c, B:141:0x0230, B:142:0x023e, B:144:0x0243, B:146:0x0247, B:147:0x0255, B:151:0x0275, B:153:0x027b, B:155:0x0281, B:156:0x029b, B:158:0x029f, B:160:0x02a5, B:162:0x02ab, B:163:0x02b7, B:165:0x02bd, B:166:0x02c5, B:168:0x02ca, B:169:0x02d2, B:171:0x02d7, B:172:0x02df, B:174:0x02e4, B:175:0x02ec, B:177:0x02f0, B:178:0x02f8, B:181:0x0302, B:182:0x0316, B:184:0x031a, B:186:0x032a, B:187:0x032f, B:189:0x0333, B:190:0x0338, B:191:0x033e, B:193:0x0342, B:195:0x0352, B:196:0x035e, B:198:0x0362, B:199:0x0367, B:201:0x036b, B:202:0x0370, B:204:0x0374, B:205:0x0379, B:207:0x037d, B:208:0x0382, B:210:0x0386, B:211:0x038b, B:213:0x038f, B:214:0x0394, B:216:0x0398, B:217:0x039d, B:219:0x03a1, B:220:0x03a6, B:222:0x03aa, B:223:0x03af, B:225:0x03b3, B:226:0x03b8, B:228:0x03bc, B:229:0x03c1, B:231:0x03c5, B:232:0x03ca, B:234:0x03ce, B:235:0x03d3, B:237:0x03d7, B:238:0x03dc, B:240:0x03e0, B:241:0x03e5, B:242:0x03ef, B:244:0x03f3, B:255:0x0420, B:256:0x040d, B:257:0x0414, B:264:0x0423, B:55:0x043d, B:57:0x044a, B:60:0x0455, B:62:0x0460, B:64:0x0468, B:66:0x0470, B:68:0x0478, B:70:0x0480, B:72:0x0488, B:76:0x04ad, B:78:0x04b3, B:80:0x04bc, B:81:0x04c9, B:90:0x0493, B:92:0x049d, B:94:0x04a7), top: B:99:0x0147 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04dd A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.media.MediaCrypto, com.google.android.gms.internal.ads.zzto] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzaJ() throws zzin {
        zzz zzzVar;
        boolean z;
        Throwable th;
        zztl zztlVar;
        zzz zzzVar2;
        zztc zztcVar;
        long j;
        long j2;
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        boolean z2;
        zztf zztfVar;
        if (this.zzt != null || this.zzP || (zzzVar = this.zzm) == null) {
            return;
        }
        boolean z3 = true;
        if (zzaS(zzzVar)) {
            zzaf();
            String str2 = zzzVar.zzo;
            if ("audio/mp4a-latm".equals(str2) || "audio/mpeg".equals(str2) || "audio/opus".equals(str2)) {
                this.zzi.zzo(32);
            } else {
                this.zzi.zzo(1);
            }
            this.zzP = true;
            return;
        }
        zzsi zzsiVar = this.zzam;
        this.zzal = zzsiVar;
        if (zzsiVar != null) {
            zzdd.zzf(true);
            zzsi zzsiVar2 = this.zzal;
            boolean z4 = zzsj.zza;
            zzsiVar2.zza();
        }
        try {
            zzz zzzVar3 = this.zzm;
            Throwable th2 = 0;
            if (zzzVar3 == null) {
                throw null;
            }
            zzz zzzVar4 = zzzVar3;
            if (this.zzy == null) {
                try {
                    List zzak = zzak(this.zzd, zzzVar3, false);
                    zzak.isEmpty();
                    this.zzy = new ArrayDeque();
                    if (!zzak.isEmpty()) {
                        this.zzy.add((zzti) zzak.get(0));
                    }
                    this.zzz = null;
                } catch (zztw e) {
                    throw new zztl(zzzVar3, (Throwable) e, false, -49998);
                }
            }
            if (this.zzy.isEmpty()) {
                throw new zztl(zzzVar3, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzy;
            if (arrayDeque == null) {
                throw null;
            }
            ArrayDeque arrayDeque2 = arrayDeque;
            while (this.zzt == null) {
                zzti zztiVar = (zzti) arrayDeque.peekFirst();
                if (zztiVar == null) {
                    throw th2;
                }
                zzti zztiVar2 = zztiVar;
                zzaT(zzzVar3);
                if (!zzaW(zztiVar)) {
                    return;
                }
                try {
                    this.zzA = zztiVar;
                    zzzVar2 = this.zzm;
                } catch (Exception e2) {
                    e = e2;
                    z = z3;
                    th = th2;
                }
                if (zzzVar2 == null) {
                    throw th2;
                }
                zzz zzzVar5 = zzzVar2;
                String str3 = zztiVar.zza;
                float zzaa = zzaa(this.zzs, zzzVar2, zzU());
                if (zzaa <= this.zze) {
                    zzaa = -1.0f;
                }
                long zzb2 = zzcX().zzb();
                zztc zzaj = zzaj(zztiVar, zzzVar2, th2, zzaa);
                if (Build.VERSION.SDK_INT >= 31) {
                    try {
                        LogSessionId zza = zzp().zza();
                        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                            zzaj.zzb.setString("log-session-id", zza.getStringId());
                        }
                    } catch (Exception e3) {
                        e = e3;
                        th = th2;
                        z = true;
                        zzea.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zztiVar.zza), e);
                        arrayDeque.removeFirst();
                        zztl zztlVar2 = new zztl(zzzVar3, (Throwable) e, false, zztiVar);
                        zzao(zztlVar2);
                        zztlVar = this.zzz;
                        if (zztlVar == null) {
                        }
                        if (arrayDeque.isEmpty()) {
                        }
                    }
                }
                try {
                    Trace.beginSection("createCodec:" + str3);
                    zztf zzd = this.zzc.zzd(zzaj);
                    this.zzt = zzd;
                    this.zzI = zzd.zzs(new zztm(this, th2));
                    Trace.endSection();
                    long zzb3 = zzcX().zzb();
                    th = th2;
                    if (zztiVar.zzf(zzzVar2)) {
                        zztcVar = zzaj;
                        j = zzb2;
                        j2 = zzb3;
                    } else {
                        try {
                            zztcVar = zzaj;
                            StringBuilder sb = new StringBuilder();
                            j = zzb2;
                            sb.append("id=");
                            sb.append(zzzVar2.zza);
                            sb.append(", mimeType=");
                            sb.append(zzzVar2.zzo);
                            String str4 = zzzVar2.zzn;
                            if (str4 != null) {
                                sb.append(", container=");
                                sb.append(str4);
                            }
                            int i5 = zzzVar2.zzj;
                            if (i5 != -1) {
                                sb.append(", bitrate=");
                                sb.append(i5);
                            }
                            String str5 = zzzVar2.zzk;
                            if (str5 != null) {
                                sb.append(", codecs=");
                                sb.append(str5);
                            }
                            zzs zzsVar = zzzVar2.zzs;
                            if (zzsVar != null) {
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                j2 = zzb3;
                                int i6 = 0;
                                while (i6 < zzsVar.zzb) {
                                    UUID uuid = zzsVar.zza(i6).zza;
                                    zzs zzsVar2 = zzsVar;
                                    if (uuid.equals(zzh.zzb)) {
                                        linkedHashSet.add("cenc");
                                    } else if (uuid.equals(zzh.zzc)) {
                                        linkedHashSet.add("clearkey");
                                    } else if (uuid.equals(zzh.zze)) {
                                        linkedHashSet.add("playready");
                                    } else if (uuid.equals(zzh.zzd)) {
                                        linkedHashSet.add("widevine");
                                    } else if (uuid.equals(zzh.zza)) {
                                        linkedHashSet.add(GatewayException.GATEWAY_RESPONSE_DEPTH_UNIVERSAL);
                                    } else {
                                        String obj = uuid.toString();
                                        StringBuilder sb2 = new StringBuilder();
                                        i4 = i6;
                                        sb2.append("unknown (");
                                        sb2.append(obj);
                                        sb2.append(")");
                                        linkedHashSet.add(sb2.toString());
                                        i6 = i4 + 1;
                                        zzsVar = zzsVar2;
                                    }
                                    i4 = i6;
                                    i6 = i4 + 1;
                                    zzsVar = zzsVar2;
                                }
                                sb.append(", drm=[");
                                zzfvh.zzb(sb, linkedHashSet, ",");
                                sb.append(AbstractJsonLexerKt.END_LIST);
                            } else {
                                j2 = zzb3;
                            }
                            int i7 = zzzVar2.zzv;
                            if (i7 != -1 && (i3 = zzzVar2.zzw) != -1) {
                                sb.append(", res=");
                                sb.append(i7);
                                sb.append(VastAttributes.HORIZONTAL_POSITION);
                                sb.append(i3);
                            }
                            int i8 = zzzVar2.zzx;
                            if (i8 != -1 && (i2 = zzzVar2.zzy) != -1) {
                                sb.append(", decRes=");
                                sb.append(i8);
                                sb.append(VastAttributes.HORIZONTAL_POSITION);
                                sb.append(i2);
                            }
                            float f = zzzVar2.zzB;
                            double d = f;
                            int i9 = zzgbj.zza;
                            if (Math.copySign(d - 1.0d, 1.0d) > 0.001d && d != 1.0d && (!Double.isNaN(d) || !Double.isNaN(1.0d))) {
                                sb.append(", par=");
                                Object[] objArr = {Float.valueOf(f)};
                                String str6 = zzex.zza;
                                sb.append(String.format(Locale.US, "%.3f", objArr));
                            }
                            zzk zzkVar = zzzVar2.zzE;
                            if (zzkVar != null && (zzkVar.zze() || zzkVar.zzf())) {
                                sb.append(", color=");
                                sb.append(zzkVar.zzd());
                            }
                            float f2 = zzzVar2.zzz;
                            if (f2 != -1.0f) {
                                sb.append(", fps=");
                                sb.append(f2);
                            }
                            int i10 = zzzVar2.zzF;
                            if (i10 != -1) {
                                sb.append(", maxSubLayers=");
                                sb.append(i10);
                            }
                            int i11 = zzzVar2.zzG;
                            if (i11 != -1) {
                                sb.append(", channels=");
                                sb.append(i11);
                            }
                            int i12 = zzzVar2.zzH;
                            if (i12 != -1) {
                                sb.append(", sample_rate=");
                                sb.append(i12);
                            }
                            String str7 = zzzVar2.zzd;
                            if (str7 != null) {
                                sb.append(", language=");
                                sb.append(str7);
                            }
                            List list = zzzVar2.zzc;
                            if (!list.isEmpty()) {
                                sb.append(", labels=[");
                                zzfvh.zzb(sb, zzfzg.zzc(list, new zzfve() { // from class: com.google.android.gms.internal.ads.zzw
                                    @Override // com.google.android.gms.internal.ads.zzfve
                                    public final Object apply(Object obj2) {
                                        zzab zzabVar = (zzab) obj2;
                                        int i13 = zzz.zzO;
                                        return zzabVar.zza + ": " + zzabVar.zzb;
                                    }
                                }), ",");
                                sb.append(C3040d4.i.e);
                            }
                            int i13 = zzzVar2.zze;
                            if (i13 != 0) {
                                sb.append(", selectionFlags=[");
                                String str8 = zzex.zza;
                                ArrayList arrayList = new ArrayList();
                                if ((i13 & 1) != 0) {
                                    arrayList.add(EventTaskParams.STATE_GROUP_DEFAULT);
                                }
                                if ((i13 & 2) != 0) {
                                    arrayList.add("forced");
                                }
                                zzfvh.zzb(sb, arrayList, ",");
                                sb.append(C3040d4.i.e);
                            }
                            int i14 = zzzVar2.zzf;
                            if (i14 != 0) {
                                sb.append(", roleFlags=[");
                                String str9 = zzex.zza;
                                ArrayList arrayList2 = new ArrayList();
                                if ((i14 & 1) != 0) {
                                    i = 32768;
                                    arrayList2.add(C3040d4.h.Z);
                                } else {
                                    i = 32768;
                                }
                                if ((i14 & 2) != 0) {
                                    arrayList2.add("alt");
                                }
                                if ((i14 & 4) != 0) {
                                    arrayList2.add("supplementary");
                                }
                                if ((i14 & 8) != 0) {
                                    arrayList2.add("commentary");
                                }
                                if ((i14 & 16) != 0) {
                                    arrayList2.add("dub");
                                }
                                if ((i14 & 32) != 0) {
                                    arrayList2.add("emergency");
                                }
                                if ((i14 & 64) != 0) {
                                    arrayList2.add("caption");
                                }
                                if ((i14 & 128) != 0) {
                                    arrayList2.add("subtitle");
                                }
                                if ((i14 & 256) != 0) {
                                    arrayList2.add("sign");
                                }
                                if ((i14 & 512) != 0) {
                                    arrayList2.add("describes-video");
                                }
                                if ((i14 & 1024) != 0) {
                                    arrayList2.add("describes-music");
                                }
                                if ((i14 & 2048) != 0) {
                                    arrayList2.add("enhanced-intelligibility");
                                }
                                if ((i14 & 4096) != 0) {
                                    arrayList2.add("transcribes-dialog");
                                }
                                if ((i14 & 8192) != 0) {
                                    arrayList2.add("easy-read");
                                }
                                if ((i14 & 16384) != 0) {
                                    arrayList2.add("trick-play");
                                }
                                if ((i14 & i) != 0) {
                                    arrayList2.add("auxiliary");
                                }
                                zzfvh.zzb(sb, arrayList2, ",");
                                sb.append(C3040d4.i.e);
                            } else {
                                i = 32768;
                            }
                            if ((i14 & i) != 0) {
                                sb.append(", auxiliaryTrackType=");
                                int i15 = zzzVar2.zzg;
                                String str10 = zzex.zza;
                                if (i15 == 0) {
                                    str = AdError.UNDEFINED_DOMAIN;
                                } else if (i15 == 1) {
                                    str = "original";
                                } else if (i15 == 2) {
                                    str = "depth-linear";
                                } else if (i15 == 3) {
                                    str = "depth-inverse";
                                } else {
                                    if (i15 != 4) {
                                        throw new IllegalStateException("Unsupported auxiliary track type");
                                    }
                                    str = "depth metadata";
                                }
                                sb.append(str);
                            }
                            Object[] objArr2 = {sb.toString(), str3};
                            String str11 = zzex.zza;
                            zzea.zzf("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr2));
                        } catch (Exception e4) {
                            e = e4;
                            z = true;
                            zzea.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zztiVar.zza), e);
                            arrayDeque.removeFirst();
                            zztl zztlVar22 = new zztl(zzzVar3, (Throwable) e, false, zztiVar);
                            zzao(zztlVar22);
                            zztlVar = this.zzz;
                            if (zztlVar == null) {
                                this.zzz = zztlVar22;
                            } else {
                                this.zzz = zztl.zza(zztlVar, zztlVar22);
                            }
                            if (arrayDeque.isEmpty()) {
                                throw this.zzz;
                            }
                            z3 = z;
                            th2 = th;
                        }
                    }
                    this.zzx = zzaa;
                    this.zzu = zzzVar2;
                    this.zzB = 0;
                    this.zzC = Build.VERSION.SDK_INT == 29 && "c2.android.aac.decoder".equals(str3);
                    this.zzD = false;
                    String str12 = zztiVar.zza;
                    if (Build.VERSION.SDK_INT <= 29) {
                        if (!"OMX.broadcom.video_decoder.tunnel".equals(str12) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(str12) && !"OMX.bcm.vdec.avc.tunnel".equals(str12) && !"OMX.bcm.vdec.avc.tunnel.secure".equals(str12) && !"OMX.bcm.vdec.hevc.tunnel".equals(str12) && !"OMX.bcm.vdec.hevc.tunnel.secure".equals(str12)) {
                        }
                        z2 = true;
                        this.zzG = z2;
                        zztfVar = this.zzt;
                        if (zztfVar == null) {
                            throw th;
                        }
                        zztf zztfVar2 = zztfVar;
                        if (zzcU() == 2) {
                            this.zzJ = zzcX().zzb() + 1000;
                        }
                        z = true;
                        try {
                            this.zza.zza++;
                            zzap(str3, zztcVar, j2, j2 - j);
                        } catch (Exception e5) {
                            e = e5;
                            zzea.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zztiVar.zza), e);
                            arrayDeque.removeFirst();
                            zztl zztlVar222 = new zztl(zzzVar3, (Throwable) e, false, zztiVar);
                            zzao(zztlVar222);
                            zztlVar = this.zzz;
                            if (zztlVar == null) {
                            }
                            if (arrayDeque.isEmpty()) {
                            }
                        }
                        z3 = z;
                        th2 = th;
                    }
                    if ("Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && zztiVar.zzf) {
                        z2 = true;
                        this.zzG = z2;
                        zztfVar = this.zzt;
                        if (zztfVar == null) {
                        }
                    } else {
                        z2 = false;
                        this.zzG = z2;
                        zztfVar = this.zzt;
                        if (zztfVar == null) {
                        }
                    }
                } catch (Throwable th3) {
                    Trace.endSection();
                    throw th3;
                }
            }
            this.zzy = th2;
        } catch (zztl e6) {
            throw zzk(e6, zzzVar, false, 4001);
        }
    }

    protected void zzaK(long j) {
        this.zzaf = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || j < ((zztn) arrayDeque.peek()).zzb) {
                return;
            }
            zztn zztnVar = (zztn) arrayDeque.poll();
            zztnVar.getClass();
            zzbb(zztnVar);
            zzat();
        }
    }

    protected void zzaL(zzhs zzhsVar) throws zzin {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void zzaM() {
        try {
            zztf zztfVar = this.zzt;
            if (zztfVar != null) {
                zztfVar.zzm();
                this.zza.zzb++;
                zzti zztiVar = this.zzA;
                if (zztiVar == null) {
                    throw null;
                }
                zzti zztiVar2 = zztiVar;
                zzaq(zztiVar.zza);
            }
        } finally {
            this.zzt = null;
            this.zzp = null;
            this.zzal = null;
            zzaO();
        }
    }

    protected void zzaN() {
        zzas();
        zzba();
        zzam();
        this.zzJ = -9223372036854775807L;
        this.zzX = false;
        this.zzH = -9223372036854775807L;
        this.zzW = false;
        this.zzE = false;
        this.zzF = false;
        this.zzN = false;
        this.zzO = false;
        this.zzU = 0;
        this.zzV = 0;
        this.zzT = this.zzS ? 1 : 0;
        this.zzai = false;
        this.zzaj = -9223372036854775807L;
        this.zzak = -9223372036854775807L;
    }

    protected final void zzaO() {
        zzaN();
        this.zzy = null;
        this.zzA = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzY = false;
        this.zzx = -1.0f;
        this.zzB = 0;
        this.zzC = false;
        this.zzD = false;
        this.zzG = false;
        this.zzI = false;
        this.zzS = false;
        this.zzT = 0;
    }

    protected final boolean zzaP() throws zzin {
        boolean zzbe = zzbe();
        if (zzbe) {
            zzaJ();
        }
        return zzbe;
    }

    protected final boolean zzaQ() {
        return this.zzai;
    }

    protected final boolean zzaR() {
        return this.zzP;
    }

    protected final boolean zzaS(zzz zzzVar) {
        return this.zzam == null && zzaw(zzzVar);
    }

    protected boolean zzaT(zzz zzzVar) throws zzin {
        return true;
    }

    protected boolean zzaU(zzhs zzhsVar) {
        return false;
    }

    protected boolean zzaV() {
        return true;
    }

    protected boolean zzaW(zzti zztiVar) {
        return true;
    }

    protected boolean zzaX() {
        int i = this.zzV;
        if (i == 3 || ((this.zzC && !this.zzY) || (this.zzD && this.zzX))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            zzbc();
            return false;
        } catch (zzin e) {
            zzea.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    protected final boolean zzaZ() throws zzin {
        return zzbj(this.zzu);
    }

    protected float zzaa(float f, zzz zzzVar, zzz[] zzzVarArr) {
        throw null;
    }

    protected abstract int zzab(zztr zztrVar, zzz zzzVar) throws zztw;

    protected long zzac(long j, long j2, boolean z) {
        return 10000L;
    }

    protected zzie zzad(zzti zztiVar, zzz zzzVar, zzz zzzVar2) {
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        if (zzbd() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b2, code lost:
    
        if (zzbd() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c5, code lost:
    
        if (zzbd() == false) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected zzie zzae(zzkv zzkvVar) throws zzin {
        int i;
        boolean z = true;
        this.zzad = true;
        zzz zzzVar = zzkvVar.zza;
        zzzVar.getClass();
        String str = zzzVar.zzo;
        if (str == null) {
            throw zzk(new IllegalArgumentException("Sample MIME type is null."), zzzVar, false, 4005);
        }
        if ((Objects.equals(str, "video/av01") || Objects.equals(str, "video/x-vnd.on2.vp9")) && !zzzVar.zzr.isEmpty()) {
            zzx zzb2 = zzzVar.zzb();
            zzb2.zzT(null);
            zzzVar = zzb2.zzan();
        }
        zzz zzzVar2 = zzzVar;
        this.zzam = zzkvVar.zzb;
        this.zzm = zzzVar2;
        if (this.zzP) {
            this.zzR = true;
            return null;
        }
        zztf zztfVar = this.zzt;
        if (zztfVar == null) {
            this.zzy = null;
            zzaJ();
            return null;
        }
        zzti zztiVar = this.zzA;
        zztiVar.getClass();
        zzz zzzVar3 = this.zzu;
        zzzVar3.getClass();
        zzsi zzsiVar = this.zzal;
        zzsi zzsiVar2 = this.zzam;
        if (zzsiVar != zzsiVar2) {
            zzag();
            return new zzie(zztiVar.zza, zzzVar3, zzzVar2, 0, 128);
        }
        boolean z2 = zzsiVar2 != zzsiVar;
        zzie zzad = zzad(zztiVar, zzzVar3, zzzVar2);
        int i2 = zzad.zzd;
        if (i2 != 0) {
            if (i2 == 1) {
                if (zzbj(zzzVar2)) {
                    this.zzu = zzzVar2;
                    if (!z2) {
                        if (this.zzW) {
                            this.zzU = 1;
                            if (this.zzD) {
                                this.zzV = 3;
                                i = 2;
                            } else {
                                this.zzV = 1;
                            }
                        }
                    }
                }
                i = 16;
            } else if (i2 != 2) {
                if (zzbj(zzzVar2)) {
                    this.zzu = zzzVar2;
                    if (z2) {
                    }
                }
                i = 16;
            } else {
                if (zzbj(zzzVar2)) {
                    this.zzS = true;
                    this.zzT = 1;
                    int i3 = this.zzB;
                    if (i3 != 2 && (i3 != 1 || zzzVar2.zzv != zzzVar3.zzv || zzzVar2.zzw != zzzVar3.zzw)) {
                        z = false;
                    }
                    this.zzE = z;
                    this.zzu = zzzVar2;
                    if (z2) {
                    }
                }
                i = 16;
            }
            return (i2 != 0 || (this.zzt == zztfVar && this.zzV != 3)) ? zzad : new zzie(zztiVar.zza, zzzVar3, zzzVar2, 0, i);
        }
        zzag();
        i = 0;
        if (i2 != 0) {
        }
    }

    protected abstract zztc zzaj(zzti zztiVar, zzz zzzVar, MediaCrypto mediaCrypto, float f);

    protected abstract List zzak(zztr zztrVar, zzz zzzVar, boolean z) throws zztw;

    protected void zzan(zzhs zzhsVar) throws zzin {
        throw null;
    }

    protected void zzao(Exception exc) {
        throw null;
    }

    protected void zzap(String str, zztc zztcVar, long j, long j2) {
        throw null;
    }

    protected void zzaq(String str) {
        throw null;
    }

    protected void zzar(zzz zzzVar, MediaFormat mediaFormat) throws zzin {
        throw null;
    }

    protected void zzat() {
    }

    protected void zzau() throws zzin {
        throw null;
    }

    protected abstract boolean zzav(long j, long j2, zztf zztfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzz zzzVar) throws zzin;

    protected boolean zzaw(zzz zzzVar) {
        return false;
    }

    protected final float zzax() {
        return this.zzr;
    }

    protected int zzay(zzhs zzhsVar) {
        return 0;
    }

    protected final long zzaz() {
        return this.zzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzmd
    public final int zze() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzma
    public final long zzf(long j, long j2) {
        return zzac(j, j2, this.zzI);
    }

    @Override // com.google.android.gms.internal.ads.zzic, com.google.android.gms.internal.ads.zzlv
    public void zzv(int i, Object obj) throws zzin {
        if (i == 11) {
            zzlz zzlzVar = (zzlz) obj;
            zzlzVar.getClass();
            this.zzo = zzlzVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzy() {
        this.zzm = null;
        zzbb(zztn.zza);
        this.zzk.clear();
        if (this.zzP) {
            zzaf();
        } else {
            zzbe();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzic
    protected void zzz(boolean z, boolean z2) throws zzin {
        this.zza = new zzid();
    }

    private final void zzbc() throws zzin {
        zzsi zzsiVar = this.zzam;
        zzsiVar.getClass();
        this.zzal = zzsiVar;
        this.zzU = 0;
        this.zzV = 0;
    }

    private final void zzai() throws zzin {
        int i = this.zzV;
        if (i == 1) {
            zzah();
            return;
        }
        if (i == 2) {
            zzah();
            zzbc();
        } else if (i != 3) {
            this.zzac = true;
            zzau();
        } else {
            zzaM();
            zzaJ();
        }
    }
}
