package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.mbridge.msdk.MBridgeConstans;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes5.dex */
public final class zzpv implements zzjs {
    private static volatile zzpv zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzmh zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzif zzc;
    private final zzhk zzd;
    private zzaw zze;
    private zzhm zzf;
    private zzoy zzg;
    private zzae zzh;
    private final zzqa zzi;
    private zzmc zzj;
    private zzoa zzk;
    private final zzpi zzl;
    private zzhw zzm;
    private final zzio zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzqe zzK = new zzpq(this);

    zzpv(zzpw zzpwVar, zzio zzioVar) {
        Preconditions.checkNotNull(zzpwVar);
        this.zzn = zzio.zzp(zzpwVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzpi(this);
        zzqa zzqaVar = new zzqa(this);
        zzqaVar.zzaw();
        this.zzi = zzqaVar;
        zzhk zzhkVar = new zzhk(this);
        zzhkVar.zzaw();
        this.zzd = zzhkVar;
        zzif zzifVar = new zzif(this);
        zzifVar.zzaw();
        this.zzc = zzifVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzq(new zzpk(this, zzpwVar));
    }

    static /* bridge */ /* synthetic */ void zzH(zzpv zzpvVar, zzpw zzpwVar) {
        zzpvVar.zzaX().zzg();
        zzpvVar.zzm = new zzhw(zzpvVar);
        zzaw zzawVar = new zzaw(zzpvVar);
        zzawVar.zzaw();
        zzpvVar.zze = zzawVar;
        zzpvVar.zzi().zzu((zzal) Preconditions.checkNotNull(zzpvVar.zzc));
        zzoa zzoaVar = new zzoa(zzpvVar);
        zzoaVar.zzaw();
        zzpvVar.zzk = zzoaVar;
        zzae zzaeVar = new zzae(zzpvVar);
        zzaeVar.zzaw();
        zzpvVar.zzh = zzaeVar;
        zzmc zzmcVar = new zzmc(zzpvVar);
        zzmcVar.zzaw();
        zzpvVar.zzj = zzmcVar;
        zzoy zzoyVar = new zzoy(zzpvVar);
        zzoyVar.zzaw();
        zzpvVar.zzg = zzoyVar;
        zzpvVar.zzf = new zzhm(zzpvVar);
        if (zzpvVar.zzs != zzpvVar.zzt) {
            zzpvVar.zzaW().zze().zzc("Not all upload components initialized", Integer.valueOf(zzpvVar.zzs), Integer.valueOf(zzpvVar.zzt));
        }
        zzpvVar.zzo.set(true);
        zzpvVar.zzaW().zzj().zza("UploadController is now fully initialized");
    }

    static final void zzaA(com.google.android.gms.internal.measurement.zzhl zzhlVar, int i, String str) {
        List zzp = zzhlVar.zzp();
        for (int i2 = 0; i2 < zzp.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i2)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
        zze.zzj("_err");
        zze.zzi(Long.valueOf(i).longValue());
        com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zze.zzba();
        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
        zze2.zzj("_ev");
        zze2.zzk(str);
        com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) zze2.zzba();
        zzhlVar.zzf(zzhqVar);
        zzhlVar.zzf(zzhqVar2);
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhl zzhlVar, String str) {
        List zzp = zzhlVar.zzp();
        for (int i = 0; i < zzp.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i)).zzg())) {
                zzhlVar.zzh(i);
                return;
            }
        }
    }

    private final int zzaC(String str, zzao zzaoVar) {
        zzju zzf;
        zzif zzifVar = this.zzc;
        if (zzifVar.zzi(str) == null) {
            zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.FAILSAFE);
            return 1;
        }
        zzh zzl = zzj().zzl(str);
        if (zzl == null || zze.zza(zzl.zzK()).zzb() != zzju.POLICY || (zzf = zzifVar.zzf(str, zzjw.AD_PERSONALIZATION)) == zzju.UNINITIALIZED) {
            zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.REMOTE_DEFAULT);
            return zzifVar.zzu(str, zzjw.AD_PERSONALIZATION) ? 0 : 1;
        }
        zzaoVar.zzd(zzjw.AD_PERSONALIZATION, zzan.REMOTE_ENFORCED_DEFAULT);
        return zzf == zzju.GRANTED ? 0 : 1;
    }

    private final zzr zzaD(String str) {
        zzh zzl = zzj().zzl(str);
        if (zzl == null || TextUtils.isEmpty(zzl.zzF())) {
            zzaW().zzd().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzaF = zzaF(zzl);
        if (zzaF == null || zzaF.booleanValue()) {
            return new zzr(str, zzl.zzH(), zzl.zzF(), zzl.zze(), zzl.zzE(), zzl.zzq(), zzl.zzn(), (String) null, zzl.zzaJ(), false, zzl.zzG(), 0L, 0, zzl.zzaI(), false, zzl.zzA(), zzl.zzx(), zzl.zzo(), zzl.zzN(), (String) null, zzu(str).zzq(), "", (String) null, zzl.zzaL(), zzl.zzw(), zzu(str).zzb(), zzm(str).zzj(), zzl.zza(), zzl.zzf(), zzl.zzM(), zzl.zzK(), 0L, zzl.zzb());
        }
        zzaW().zze().zzb("App version does not match; dropping. appId", zzhe.zzn(str));
        return null;
    }

    private final zzaz zzaE() {
        if (this.zzI == null) {
            this.zzI = new zzpn(this, this.zzn);
        }
        return this.zzI;
    }

    private final Boolean zzaF(zzh zzhVar) {
        try {
            if (zzhVar.zze() != -2147483648L) {
                if (zzhVar.zze() == Wrappers.packageManager(this.zzn.zzaT()).getPackageInfo(zzhVar.zzC(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaT()).getPackageInfo(zzhVar.zzC(), 0).versionName;
                String zzF = zzhVar.zzF();
                if (zzF != null && zzF.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static String zzaG(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private final void zzaH() {
        zzaX().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaW().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaW().zzj().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzhw zzhwVar, long j, boolean z) {
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzqd zzy = zzj().zzy(zzhwVar.zzaF(), str);
        zzqd zzqdVar = (zzy == null || (obj = zzy.zze) == null) ? new zzqd(zzhwVar.zzaF(), "auto", str, zzaU().currentTimeMillis(), Long.valueOf(j)) : new zzqd(zzhwVar.zzaF(), "auto", str, zzaU().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
        zze.zzf(str);
        zze.zzg(zzaU().currentTimeMillis());
        Object obj2 = zzqdVar.zze;
        zze.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) zze.zzba();
        int zza = zzqa.zza(zzhwVar, str);
        if (zza >= 0) {
            zzhwVar.zzaC(zza, zzioVar);
        } else {
            zzhwVar.zzp(zzioVar);
        }
        if (j > 0) {
            zzj().zzai(zzqdVar);
            zzaW().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaE().zze()) {
            return;
        }
        long max = Math.max(0L, ((Integer) zzgi.zzaA.zza(null)).intValue() - (zzaU().elapsedRealtime() - this.zzJ));
        zzaW().zzj().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzaE().zzd(max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaK(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private final void zzaL() {
        long max;
        long j;
        zzaX().zzg();
        zzM();
        if (this.zza > 0) {
            long abs = 3600000 - Math.abs(zzaU().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzaW().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzq().zzc();
                zzx().zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzaN()) {
            zzaW().zzj().zza("Nothing to upload or uploading impossible");
            zzq().zzc();
            zzx().zza();
            return;
        }
        long currentTimeMillis = zzaU().currentTimeMillis();
        zzi();
        long max2 = Math.max(0L, ((Long) zzgi.zzN.zza(null)).longValue());
        boolean z = true;
        if (!zzj().zzac() && !zzj().zzab()) {
            z = false;
        }
        if (z) {
            String zzo = zzi().zzo();
            if (TextUtils.isEmpty(zzo) || ".none.".equals(zzo)) {
                zzi();
                max = Math.max(0L, ((Long) zzgi.zzH.zza(null)).longValue());
            } else {
                zzi();
                max = Math.max(0L, ((Long) zzgi.zzI.zza(null)).longValue());
            }
        } else {
            zzi();
            max = Math.max(0L, ((Long) zzgi.zzG.zza(null)).longValue());
        }
        long zza = this.zzk.zzd.zza();
        long zza2 = this.zzk.zze.zza();
        long j2 = 0;
        boolean z2 = z;
        long max3 = Math.max(zzj().zzf(), zzj().zzh());
        if (max3 == 0) {
            j = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(zza - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
            j = max2 + abs2;
            long max4 = Math.max(abs3, abs4);
            if (z2 && max4 > 0) {
                j = Math.min(abs2, max4) + max;
            }
            if (!zzA().zzz(max4, max)) {
                j = max4 + max;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i = 0;
                while (true) {
                    zzi();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzgi.zzP.zza(null)).intValue()))) {
                        j = 0;
                        break;
                    }
                    zzi();
                    j += Math.max(j2, ((Long) zzgi.zzO.zza(null)).longValue()) * (1 << i);
                    if (j > abs4) {
                        break;
                    }
                    i++;
                    j2 = 0;
                }
            }
            j2 = 0;
        }
        if (j == j2) {
            zzaW().zzj().zza("Next upload time is 0");
            zzq().zzc();
            zzx().zza();
            return;
        }
        if (!zzp().zzd()) {
            zzaW().zzj().zza("No network");
            zzq().zzb();
            zzx().zza();
            return;
        }
        long zza3 = this.zzk.zzc.zza();
        zzi();
        long max5 = Math.max(0L, ((Long) zzgi.zzE.zza(null)).longValue());
        if (!zzA().zzz(zza3, max5)) {
            j = Math.max(j, zza3 + max5);
        }
        zzq().zzc();
        long currentTimeMillis2 = j - zzaU().currentTimeMillis();
        if (currentTimeMillis2 <= 0) {
            zzi();
            currentTimeMillis2 = Math.max(0L, ((Long) zzgi.zzJ.zza(null)).longValue());
            this.zzk.zzd.zzb(zzaU().currentTimeMillis());
        }
        zzaW().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
        zzx().zzd(currentTimeMillis2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:336:0x0d36, code lost:
    
        if (r7 > (com.google.android.gms.measurement.internal.zzam.zzI() + r5)) goto L431;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0331 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x038e A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03c2 A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03f8 A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04c8 A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0559 A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0502 A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03db A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0d28 A[Catch: all -> 0x0e6a, TryCatch #4 {all -> 0x0e6a, blocks: (B:327:0x0c9b, B:329:0x0cb0, B:332:0x0cb7, B:333:0x0ce8, B:335:0x0d28, B:337:0x0d59, B:339:0x0d5d, B:340:0x0d67, B:342:0x0daa, B:344:0x0db7, B:346:0x0dc8, B:348:0x0e12, B:350:0x0e23, B:353:0x0e2d, B:354:0x0e4b, B:360:0x0e38, B:365:0x0ddf, B:368:0x0df8, B:369:0x0d38, B:370:0x0cbf, B:372:0x0ccb, B:373:0x0cd1, B:521:0x0e59), top: B:4:0x0024, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0daa A[Catch: all -> 0x0e6a, TRY_LEAVE, TryCatch #4 {all -> 0x0e6a, blocks: (B:327:0x0c9b, B:329:0x0cb0, B:332:0x0cb7, B:333:0x0ce8, B:335:0x0d28, B:337:0x0d59, B:339:0x0d5d, B:340:0x0d67, B:342:0x0daa, B:344:0x0db7, B:346:0x0dc8, B:348:0x0e12, B:350:0x0e23, B:353:0x0e2d, B:354:0x0e4b, B:360:0x0e38, B:365:0x0ddf, B:368:0x0df8, B:369:0x0d38, B:370:0x0cbf, B:372:0x0ccb, B:373:0x0cd1, B:521:0x0e59), top: B:4:0x0024, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0dc8 A[Catch: SQLiteException -> 0x0dde, all -> 0x0e6a, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x0dde, blocks: (B:344:0x0db7, B:346:0x0dc8), top: B:343:0x0db7, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x09f2 A[Catch: all -> 0x0e55, TryCatch #2 {all -> 0x0e55, blocks: (B:400:0x08f6, B:401:0x0909, B:403:0x090f, B:429:0x0bc7, B:431:0x09a0, B:434:0x09d0, B:436:0x09f2, B:437:0x09fa, B:439:0x0a00, B:443:0x0a10, B:448:0x0a38, B:449:0x0a5b, B:451:0x0a67, B:453:0x0a7b, B:454:0x0abc, B:457:0x0ad2, B:459:0x0ad9, B:461:0x0ae8, B:463:0x0aec, B:465:0x0af0, B:467:0x0af4, B:468:0x0b00, B:469:0x0b05, B:471:0x0b0b, B:473:0x0b25, B:474:0x0b2a, B:475:0x0bc4, B:477:0x0b3f, B:479:0x0b43, B:482:0x0b69, B:484:0x0b91, B:485:0x0b9c, B:487:0x0bac, B:489:0x0bb4, B:490:0x0b50, B:494:0x0a24, B:501:0x0bd0, B:503:0x0bdc, B:504:0x0be2, B:505:0x0bea, B:507:0x0bf0, B:321:0x0c06, B:323:0x0c16, B:324:0x0c93, B:380:0x0c2e, B:382:0x0c34, B:384:0x0c3c, B:385:0x0c43, B:390:0x0c51, B:391:0x0c58, B:393:0x0c84, B:394:0x0c8b, B:395:0x0c88, B:396:0x0c55, B:398:0x0c40), top: B:399:0x08f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0a38 A[Catch: all -> 0x0e55, TryCatch #2 {all -> 0x0e55, blocks: (B:400:0x08f6, B:401:0x0909, B:403:0x090f, B:429:0x0bc7, B:431:0x09a0, B:434:0x09d0, B:436:0x09f2, B:437:0x09fa, B:439:0x0a00, B:443:0x0a10, B:448:0x0a38, B:449:0x0a5b, B:451:0x0a67, B:453:0x0a7b, B:454:0x0abc, B:457:0x0ad2, B:459:0x0ad9, B:461:0x0ae8, B:463:0x0aec, B:465:0x0af0, B:467:0x0af4, B:468:0x0b00, B:469:0x0b05, B:471:0x0b0b, B:473:0x0b25, B:474:0x0b2a, B:475:0x0bc4, B:477:0x0b3f, B:479:0x0b43, B:482:0x0b69, B:484:0x0b91, B:485:0x0b9c, B:487:0x0bac, B:489:0x0bb4, B:490:0x0b50, B:494:0x0a24, B:501:0x0bd0, B:503:0x0bdc, B:504:0x0be2, B:505:0x0bea, B:507:0x0bf0, B:321:0x0c06, B:323:0x0c16, B:324:0x0c93, B:380:0x0c2e, B:382:0x0c34, B:384:0x0c3c, B:385:0x0c43, B:390:0x0c51, B:391:0x0c58, B:393:0x0c84, B:394:0x0c8b, B:395:0x0c88, B:396:0x0c55, B:398:0x0c40), top: B:399:0x08f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0a5b A[Catch: all -> 0x0e55, TryCatch #2 {all -> 0x0e55, blocks: (B:400:0x08f6, B:401:0x0909, B:403:0x090f, B:429:0x0bc7, B:431:0x09a0, B:434:0x09d0, B:436:0x09f2, B:437:0x09fa, B:439:0x0a00, B:443:0x0a10, B:448:0x0a38, B:449:0x0a5b, B:451:0x0a67, B:453:0x0a7b, B:454:0x0abc, B:457:0x0ad2, B:459:0x0ad9, B:461:0x0ae8, B:463:0x0aec, B:465:0x0af0, B:467:0x0af4, B:468:0x0b00, B:469:0x0b05, B:471:0x0b0b, B:473:0x0b25, B:474:0x0b2a, B:475:0x0bc4, B:477:0x0b3f, B:479:0x0b43, B:482:0x0b69, B:484:0x0b91, B:485:0x0b9c, B:487:0x0bac, B:489:0x0bb4, B:490:0x0b50, B:494:0x0a24, B:501:0x0bd0, B:503:0x0bdc, B:504:0x0be2, B:505:0x0bea, B:507:0x0bf0, B:321:0x0c06, B:323:0x0c16, B:324:0x0c93, B:380:0x0c2e, B:382:0x0c34, B:384:0x0c3c, B:385:0x0c43, B:390:0x0c51, B:391:0x0c58, B:393:0x0c84, B:394:0x0c8b, B:395:0x0c88, B:396:0x0c55, B:398:0x0c40), top: B:399:0x08f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0171 A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01eb A[Catch: all -> 0x0e6c, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0223 A[Catch: all -> 0x0e6c, TRY_ENTER, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0288 A[EDGE_INSN: B:89:0x0288->B:90:0x0288 BREAK  A[LOOP:2: B:75:0x0219->B:83:0x0283], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x028e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02bc A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x031f A[Catch: all -> 0x0e6c, TryCatch #5 {all -> 0x0e6c, blocks: (B:3:0x000f, B:6:0x0026, B:9:0x002e, B:10:0x0041, B:13:0x0057, B:16:0x007f, B:18:0x00b4, B:21:0x00c5, B:23:0x00cf, B:26:0x068a, B:27:0x00fa, B:29:0x010c, B:32:0x011c, B:34:0x0122, B:36:0x0128, B:38:0x0135, B:40:0x0141, B:42:0x0147, B:45:0x0152, B:46:0x0163, B:48:0x0171, B:51:0x0191, B:53:0x0197, B:55:0x01a7, B:57:0x01b5, B:59:0x01c5, B:61:0x01d2, B:66:0x01d5, B:69:0x01eb, B:75:0x0219, B:78:0x0223, B:80:0x0231, B:83:0x0283, B:84:0x0250, B:86:0x0262, B:93:0x0290, B:95:0x02bc, B:96:0x02e6, B:98:0x031f, B:99:0x0327, B:102:0x0333, B:104:0x036c, B:105:0x0388, B:107:0x038e, B:109:0x039e, B:111:0x03b4, B:112:0x03a8, B:120:0x03bb, B:123:0x03c2, B:126:0x03f8, B:127:0x0404, B:130:0x0412, B:134:0x0435, B:135:0x0424, B:144:0x04bc, B:146:0x04c8, B:149:0x04d9, B:151:0x04ea, B:153:0x04f6, B:155:0x0553, B:157:0x0559, B:158:0x0565, B:160:0x056b, B:162:0x057b, B:164:0x0585, B:165:0x059a, B:167:0x05a0, B:168:0x05bb, B:170:0x05c1, B:172:0x05df, B:174:0x05e8, B:176:0x0611, B:177:0x05ee, B:179:0x05fe, B:183:0x061c, B:184:0x0636, B:186:0x063c, B:189:0x064f, B:194:0x065c, B:195:0x0660, B:197:0x0666, B:199:0x0676, B:204:0x0502, B:206:0x050e, B:209:0x051f, B:211:0x0530, B:213:0x053c, B:215:0x0441, B:217:0x044d, B:219:0x0459, B:224:0x049e, B:225:0x0476, B:228:0x0488, B:230:0x048e, B:232:0x0498, B:236:0x03db, B:246:0x06a0, B:248:0x06ae, B:250:0x06b7, B:252:0x06e7, B:253:0x06bf, B:255:0x06c8, B:257:0x06ce, B:259:0x06da, B:261:0x06e2, B:268:0x06ea, B:269:0x06f6, B:272:0x06fe, B:275:0x0710, B:276:0x071b, B:278:0x0723, B:279:0x0749, B:281:0x0763, B:282:0x0778, B:284:0x0792, B:285:0x07a7, B:286:0x07b5, B:288:0x07bb, B:290:0x07cb, B:291:0x07d2, B:293:0x07de, B:295:0x07e5, B:298:0x07e8, B:300:0x082a, B:302:0x0830, B:303:0x0857, B:305:0x085f, B:306:0x0868, B:308:0x086e, B:309:0x0874, B:311:0x0889, B:313:0x0899, B:315:0x08a9, B:317:0x08b1, B:318:0x08b4, B:406:0x0928, B:408:0x0941, B:410:0x0957, B:412:0x095c, B:414:0x0960, B:416:0x0964, B:418:0x096e, B:419:0x0974, B:421:0x0978, B:423:0x097e, B:424:0x098c, B:425:0x0995, B:496:0x09b6, B:499:0x09bc, B:509:0x083e, B:511:0x0844, B:513:0x084a, B:514:0x07a4, B:515:0x0775, B:516:0x0729, B:518:0x072f), top: B:2:0x000f, inners: #7 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v57, types: [com.google.android.gms.measurement.internal.zzpv] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaM(String str, long j) {
        boolean z;
        zzpv zzpvVar;
        int i;
        int i2;
        long j2;
        long parseLong;
        long j3;
        int zzc;
        long j4;
        SecureRandom secureRandom;
        int i3;
        Long l;
        Boolean bool;
        long zzt;
        int i4;
        zzpv zzpvVar2;
        boolean z2;
        zzaw zzj;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        long currentTimeMillis;
        long zzo;
        ContentValues contentValues;
        String str2;
        boolean zzw;
        String str3;
        int i5;
        boolean z3;
        int i6;
        zzpr zzprVar;
        int i7;
        String str4;
        int i8;
        int i9;
        int i10;
        zzpr zzprVar2;
        int i11;
        boolean z4;
        boolean z5;
        boolean z6;
        int i12;
        int i13;
        int i14;
        com.google.android.gms.internal.measurement.zzhp zzhpVar;
        boolean z7;
        int i15;
        boolean z8;
        String str5;
        zzpv zzpvVar3 = this;
        zzpv zzpvVar4 = "_ai";
        String str6 = FirebaseAnalytics.Param.ITEMS;
        zzpvVar3.zzj().zzH();
        try {
            zzpr zzprVar3 = new zzpr(zzpvVar3, null);
            zzpvVar3.zzj().zzat(str, j, zzpvVar3.zzB, zzprVar3);
            List list = zzprVar3.zzc;
            try {
                if (list != null && !list.isEmpty()) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzprVar3.zza.zzch();
                    zzhwVar.zzu();
                    com.google.android.gms.internal.measurement.zzhl zzhlVar = null;
                    com.google.android.gms.internal.measurement.zzhl zzhlVar2 = null;
                    int i16 = -1;
                    int i17 = 0;
                    int i18 = 0;
                    boolean z9 = false;
                    int i19 = 0;
                    int i20 = -1;
                    String str7 = "_ai";
                    while (true) {
                        i = i18;
                        boolean z10 = z9;
                        i2 = i19;
                        com.google.android.gms.internal.measurement.zzhl zzhlVar3 = zzhlVar;
                        if (i17 >= zzprVar3.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhl zzhlVar4 = (com.google.android.gms.internal.measurement.zzhl) ((com.google.android.gms.internal.measurement.zzhm) zzprVar3.zzc.get(i17)).zzch();
                        com.google.android.gms.internal.measurement.zzhl zzhlVar5 = zzhlVar2;
                        if (zzpvVar3.zzr().zzx(zzprVar3.zza.zzF(), zzhlVar4.zzo())) {
                            zzpvVar3.zzaW().zzk().zzc("Dropping blocked raw event. appId", zzhe.zzn(zzprVar3.zza.zzF()), zzpvVar3.zzn.zzj().zzd(zzhlVar4.zzo()));
                            if (!zzpvVar3.zzr().zzt(zzprVar3.zza.zzF()) && !zzpvVar3.zzr().zzy(zzprVar3.zza.zzF()) && !"_err".equals(zzhlVar4.zzo())) {
                                zzpvVar3.zzB().zzR(zzpvVar3.zzK, zzprVar3.zza.zzF(), 11, "_ev", zzhlVar4.zzo(), 0);
                            }
                            i18 = i;
                            str3 = str7;
                            str4 = str6;
                            zzhlVar = zzhlVar3;
                            zzhlVar2 = zzhlVar5;
                            i7 = i16;
                            i8 = i17;
                        } else {
                            com.google.android.gms.internal.measurement.zzoy.zzb();
                            int i21 = i17;
                            if (zzpvVar3.zzi().zzx(null, zzgi.zzbf)) {
                                String zzo2 = zzhlVar4.zzo();
                                if (zzo2.equals(FirebaseAnalytics.Event.PURCHASE) || zzo2.equals("_iap") || zzo2.equals("ecommerce_purchase")) {
                                    com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                                    str2 = str6;
                                    zze.zzj("_cbs");
                                    if (!z10) {
                                        String zzF = zzprVar3.zza.zzF();
                                        if (zzpvVar3.zzaO(zzF, FirebaseAnalytics.Event.PURCHASE) && zzpvVar3.zzaO(zzF, "_iap") && zzpvVar3.zzaO(zzF, "ecommerce_purchase")) {
                                            str5 = "new_buyer";
                                            zze.zzk(str5);
                                            zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                                            z10 = true;
                                            if (zzhlVar4.zzo().equals(zzjy.zza(str7))) {
                                                zzhlVar4.zzi(str7);
                                                zzpvVar3.zzaW().zzj().zza("Renaming ad_impression to _ai");
                                                if (Log.isLoggable(zzpvVar3.zzaW().zzr(), 5)) {
                                                    for (int i22 = 0; i22 < zzhlVar4.zza(); i22++) {
                                                        if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhlVar4.zzn(i22).zzg()) && !zzhlVar4.zzn(i22).zzh().isEmpty() && "admob".equalsIgnoreCase(zzhlVar4.zzn(i22).zzh())) {
                                                            zzpvVar3.zzaW().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                                        }
                                                    }
                                                }
                                            }
                                            zzw = zzpvVar3.zzr().zzw(zzprVar3.zza.zzF(), zzhlVar4.zzo());
                                            if (zzw) {
                                                str3 = str7;
                                            } else {
                                                zzpvVar3.zzA();
                                                String zzo3 = zzhlVar4.zzo();
                                                Preconditions.checkNotEmpty(zzo3);
                                                str3 = str7;
                                                if (zzo3.hashCode() != 95027 || !zzo3.equals("_ui")) {
                                                    i5 = i20;
                                                    i6 = i2;
                                                    z3 = false;
                                                    if (z3) {
                                                        zzprVar = zzprVar3;
                                                        i2 = i6;
                                                    } else {
                                                        ArrayList arrayList = new ArrayList(zzhlVar4.zzp());
                                                        int i23 = 0;
                                                        int i24 = -1;
                                                        int i25 = -1;
                                                        while (true) {
                                                            i2 = i6;
                                                            zzprVar = zzprVar3;
                                                            if (i23 >= arrayList.size()) {
                                                                break;
                                                            }
                                                            if ("value".equals(((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i23)).zzg())) {
                                                                i24 = i23;
                                                            } else if ("currency".equals(((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i23)).zzg())) {
                                                                i25 = i23;
                                                            }
                                                            i23++;
                                                            i6 = i2;
                                                            zzprVar3 = zzprVar;
                                                        }
                                                        if (i24 != -1) {
                                                            if (((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i24)).zzw() || ((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i24)).zzu()) {
                                                                if (i25 != -1) {
                                                                    String zzh = ((com.google.android.gms.internal.measurement.zzhq) arrayList.get(i25)).zzh();
                                                                    if (zzh.length() == 3) {
                                                                        int i26 = 0;
                                                                        while (i26 < zzh.length()) {
                                                                            int codePointAt = zzh.codePointAt(i26);
                                                                            if (Character.isLetter(codePointAt)) {
                                                                                i26 += Character.charCount(codePointAt);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                zzpvVar3.zzaW().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                                zzhlVar4.zzh(i24);
                                                                zzaB(zzhlVar4, "_c");
                                                                zzaA(zzhlVar4, 19, "currency");
                                                                break;
                                                            }
                                                            zzpvVar3.zzaW().zzl().zza("Value must be specified with a numeric type.");
                                                            zzhlVar4.zzh(i24);
                                                            zzaB(zzhlVar4, "_c");
                                                            zzaA(zzhlVar4, 18, "value");
                                                        }
                                                        if ("_e".equals(zzhlVar4.zzo())) {
                                                            zzpvVar3.zzA();
                                                            if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba(), "_fr") == null) {
                                                                if (zzhlVar5 != null && Math.abs(zzhlVar5.zzc() - zzhlVar4.zzc()) <= 1000) {
                                                                    com.google.android.gms.internal.measurement.zzhl zzhlVar6 = (com.google.android.gms.internal.measurement.zzhl) zzhlVar5.clone();
                                                                    if (zzpvVar3.zzaP(zzhlVar4, zzhlVar6)) {
                                                                        zzhwVar.zzad(i16, zzhlVar6);
                                                                        i20 = i5;
                                                                        zzhlVar = null;
                                                                        zzhlVar2 = null;
                                                                        if (zzhlVar4.zza() == 0) {
                                                                            zzpvVar3.zzA();
                                                                            Bundle zzF2 = zzqa.zzF(zzhlVar4.zzp());
                                                                            int i27 = 0;
                                                                            while (i27 < zzhlVar4.zza()) {
                                                                                com.google.android.gms.internal.measurement.zzhq zzn = zzhlVar4.zzn(i27);
                                                                                String str8 = str2;
                                                                                if (!zzn.zzg().equals(str8) || zzn.zzi().isEmpty()) {
                                                                                    i9 = i27;
                                                                                    i10 = i16;
                                                                                    zzprVar2 = zzprVar;
                                                                                    if (!zzn.zzg().equals(str8)) {
                                                                                        zzpvVar3.zzaw(zzhlVar4.zzo(), (com.google.android.gms.internal.measurement.zzhp) zzn.zzch(), zzF2, zzprVar2.zza.zzF());
                                                                                    }
                                                                                } else {
                                                                                    zzprVar2 = zzprVar;
                                                                                    String zzF3 = zzprVar2.zza.zzF();
                                                                                    List zzi = zzn.zzi();
                                                                                    Bundle[] bundleArr = new Bundle[zzi.size()];
                                                                                    i9 = i27;
                                                                                    int i28 = 0;
                                                                                    while (i28 < zzi.size()) {
                                                                                        com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) zzi.get(i28);
                                                                                        zzpvVar3.zzA();
                                                                                        int i29 = i28;
                                                                                        Bundle zzF4 = zzqa.zzF(zzhqVar.zzi());
                                                                                        Iterator it = zzhqVar.zzi().iterator();
                                                                                        while (it.hasNext()) {
                                                                                            zzpvVar3.zzaw(zzhlVar4.zzo(), (com.google.android.gms.internal.measurement.zzhp) ((com.google.android.gms.internal.measurement.zzhq) it.next()).zzch(), zzF4, zzF3);
                                                                                            it = it;
                                                                                            i16 = i16;
                                                                                        }
                                                                                        bundleArr[i29] = zzF4;
                                                                                        i28 = i29 + 1;
                                                                                        i16 = i16;
                                                                                    }
                                                                                    i10 = i16;
                                                                                    zzF2.putParcelableArray(str8, bundleArr);
                                                                                }
                                                                                i27 = i9 + 1;
                                                                                str2 = str8;
                                                                                zzprVar = zzprVar2;
                                                                                i16 = i10;
                                                                            }
                                                                            i7 = i16;
                                                                            str4 = str2;
                                                                            zzprVar3 = zzprVar;
                                                                            zzhlVar4.zzg();
                                                                            zzqa zzA = zzpvVar3.zzA();
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            for (String str9 : zzF2.keySet()) {
                                                                                com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                                                                                zze2.zzj(str9);
                                                                                Object obj = zzF2.get(str9);
                                                                                if (obj != null) {
                                                                                    zzA.zzw(zze2, obj);
                                                                                    arrayList2.add((com.google.android.gms.internal.measurement.zzhq) zze2.zzba());
                                                                                }
                                                                            }
                                                                            Iterator it2 = arrayList2.iterator();
                                                                            while (it2.hasNext()) {
                                                                                zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) it2.next());
                                                                            }
                                                                        } else {
                                                                            i7 = i16;
                                                                            str4 = str2;
                                                                            zzprVar3 = zzprVar;
                                                                        }
                                                                        i8 = i21;
                                                                        zzprVar3.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                                        zzhwVar.zzn(zzhlVar4);
                                                                        i18 = i + 1;
                                                                    }
                                                                }
                                                                i20 = i;
                                                                zzhlVar = zzhlVar4;
                                                                zzhlVar2 = zzhlVar5;
                                                                if (zzhlVar4.zza() == 0) {
                                                                }
                                                                i8 = i21;
                                                                zzprVar3.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                                zzhwVar.zzn(zzhlVar4);
                                                                i18 = i + 1;
                                                            }
                                                            i20 = i5;
                                                            zzhlVar = zzhlVar3;
                                                            zzhlVar2 = zzhlVar5;
                                                            if (zzhlVar4.zza() == 0) {
                                                            }
                                                            i8 = i21;
                                                            zzprVar3.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                            zzhwVar.zzn(zzhlVar4);
                                                            i18 = i + 1;
                                                        } else {
                                                            if ("_vs".equals(zzhlVar4.zzo())) {
                                                                zzpvVar3.zzA();
                                                                if (zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba(), "_et") == null) {
                                                                    if (zzhlVar3 != null && Math.abs(zzhlVar3.zzc() - zzhlVar4.zzc()) <= 1000) {
                                                                        com.google.android.gms.internal.measurement.zzhl zzhlVar7 = (com.google.android.gms.internal.measurement.zzhl) zzhlVar3.clone();
                                                                        if (zzpvVar3.zzaP(zzhlVar7, zzhlVar4)) {
                                                                            int i30 = i5;
                                                                            zzhwVar.zzad(i30, zzhlVar7);
                                                                            i20 = i30;
                                                                            zzhlVar = null;
                                                                            zzhlVar2 = null;
                                                                            if (zzhlVar4.zza() == 0) {
                                                                            }
                                                                            i8 = i21;
                                                                            zzprVar3.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                                            zzhwVar.zzn(zzhlVar4);
                                                                            i18 = i + 1;
                                                                        }
                                                                    }
                                                                    i16 = i;
                                                                    i20 = i5;
                                                                    zzhlVar2 = zzhlVar4;
                                                                    zzhlVar = zzhlVar3;
                                                                    if (zzhlVar4.zza() == 0) {
                                                                    }
                                                                    i8 = i21;
                                                                    zzprVar3.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                                    zzhwVar.zzn(zzhlVar4);
                                                                    i18 = i + 1;
                                                                }
                                                            }
                                                            i20 = i5;
                                                            zzhlVar = zzhlVar3;
                                                            zzhlVar2 = zzhlVar5;
                                                            if (zzhlVar4.zza() == 0) {
                                                            }
                                                            i8 = i21;
                                                            zzprVar3.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhm) zzhlVar4.zzba());
                                                            zzhwVar.zzn(zzhlVar4);
                                                            i18 = i + 1;
                                                        }
                                                    }
                                                    if ("_e".equals(zzhlVar4.zzo())) {
                                                    }
                                                }
                                            }
                                            z3 = zzw;
                                            i11 = 0;
                                            z4 = false;
                                            boolean z11 = false;
                                            while (true) {
                                                z5 = z4;
                                                if (i11 >= zzhlVar4.zza()) {
                                                    break;
                                                }
                                                if ("_c".equals(zzhlVar4.zzn(i11).zzg())) {
                                                    com.google.android.gms.internal.measurement.zzhp zzhpVar2 = (com.google.android.gms.internal.measurement.zzhp) zzhlVar4.zzn(i11).zzch();
                                                    i15 = i20;
                                                    z8 = z11;
                                                    zzhpVar2.zzi(1L);
                                                    zzhlVar4.zzk(i11, (com.google.android.gms.internal.measurement.zzhq) zzhpVar2.zzba());
                                                    z4 = true;
                                                } else {
                                                    i15 = i20;
                                                    z8 = z11;
                                                    if ("_r".equals(zzhlVar4.zzn(i11).zzg())) {
                                                        com.google.android.gms.internal.measurement.zzhp zzhpVar3 = (com.google.android.gms.internal.measurement.zzhp) zzhlVar4.zzn(i11).zzch();
                                                        zzhpVar3.zzi(1L);
                                                        zzhlVar4.zzk(i11, (com.google.android.gms.internal.measurement.zzhq) zzhpVar3.zzba());
                                                        z11 = true;
                                                        z4 = z5;
                                                        i11++;
                                                        i20 = i15;
                                                    } else {
                                                        z4 = z5;
                                                    }
                                                }
                                                z11 = z8;
                                                i11++;
                                                i20 = i15;
                                            }
                                            i5 = i20;
                                            z6 = z11;
                                            if (!z5 && z3) {
                                                zzpvVar3.zzaW().zzj().zzb("Marking event as conversion", zzpvVar3.zzn.zzj().zzd(zzhlVar4.zzo()));
                                                com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                                                zze3.zzj("_c");
                                                zze3.zzi(1L);
                                                zzhlVar4.zze(zze3);
                                            }
                                            if (!z6) {
                                                zzpvVar3.zzaW().zzj().zzb("Marking event as real-time", zzpvVar3.zzn.zzj().zzd(zzhlVar4.zzo()));
                                                com.google.android.gms.internal.measurement.zzhp zze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                                zze4.zzj("_r");
                                                zze4.zzi(1L);
                                                zzhlVar4.zze(zze4);
                                            }
                                            if (zzpvVar3.zzj().zzo(zzpvVar3.zza(), zzprVar3.zza.zzF(), false, false, false, false, true, false, false).zze > zzpvVar3.zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzo)) {
                                                zzaB(zzhlVar4, "_r");
                                                i12 = i2;
                                            } else {
                                                i12 = 1;
                                            }
                                            if (zzqf.zzaq(zzhlVar4.zzo()) && z3 && zzpvVar3.zzj().zzo(zzpvVar3.zza(), zzprVar3.zza.zzF(), false, false, true, false, false, false, false).zzc > zzpvVar3.zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzn)) {
                                                zzpvVar3.zzaW().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                                i14 = 0;
                                                int i31 = -1;
                                                zzhpVar = null;
                                                z7 = false;
                                                while (i14 < zzhlVar4.zza()) {
                                                    com.google.android.gms.internal.measurement.zzhq zzn2 = zzhlVar4.zzn(i14);
                                                    int i32 = i14;
                                                    if ("_c".equals(zzn2.zzg())) {
                                                        zzhpVar = (com.google.android.gms.internal.measurement.zzhp) zzn2.zzch();
                                                        i31 = i32;
                                                    } else if ("_err".equals(zzn2.zzg())) {
                                                        z7 = true;
                                                    }
                                                    i14 = i32 + 1;
                                                }
                                                if (z7) {
                                                    if (zzhpVar != null) {
                                                        zzhlVar4.zzh(i31);
                                                    } else {
                                                        zzhpVar = null;
                                                    }
                                                }
                                                if (zzhpVar == null) {
                                                    com.google.android.gms.internal.measurement.zzhp zzhpVar4 = (com.google.android.gms.internal.measurement.zzhp) zzhpVar.clone();
                                                    zzhpVar4.zzj("_err");
                                                    i13 = i12;
                                                    zzhpVar4.zzi(10L);
                                                    zzhlVar4.zzk(i31, (com.google.android.gms.internal.measurement.zzhq) zzhpVar4.zzba());
                                                } else {
                                                    i13 = i12;
                                                    zzpvVar3.zzaW().zze().zzb("Did not find conversion parameter. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                                }
                                                i6 = i13;
                                                if (z3) {
                                                }
                                                if ("_e".equals(zzhlVar4.zzo())) {
                                                }
                                            }
                                            i13 = i12;
                                            i6 = i13;
                                            if (z3) {
                                            }
                                            if ("_e".equals(zzhlVar4.zzo())) {
                                            }
                                        }
                                    }
                                    str5 = "returning_buyer";
                                    zze.zzk(str5);
                                    zzhlVar4.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                                    z10 = true;
                                    if (zzhlVar4.zzo().equals(zzjy.zza(str7))) {
                                    }
                                    zzw = zzpvVar3.zzr().zzw(zzprVar3.zza.zzF(), zzhlVar4.zzo());
                                    if (zzw) {
                                    }
                                    z3 = zzw;
                                    i11 = 0;
                                    z4 = false;
                                    boolean z112 = false;
                                    while (true) {
                                        z5 = z4;
                                        if (i11 >= zzhlVar4.zza()) {
                                        }
                                        i11++;
                                        i20 = i15;
                                    }
                                    i5 = i20;
                                    z6 = z112;
                                    if (!z5) {
                                        zzpvVar3.zzaW().zzj().zzb("Marking event as conversion", zzpvVar3.zzn.zzj().zzd(zzhlVar4.zzo()));
                                        com.google.android.gms.internal.measurement.zzhp zze32 = com.google.android.gms.internal.measurement.zzhq.zze();
                                        zze32.zzj("_c");
                                        zze32.zzi(1L);
                                        zzhlVar4.zze(zze32);
                                    }
                                    if (!z6) {
                                    }
                                    if (zzpvVar3.zzj().zzo(zzpvVar3.zza(), zzprVar3.zza.zzF(), false, false, false, false, true, false, false).zze > zzpvVar3.zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzo)) {
                                    }
                                    if (zzqf.zzaq(zzhlVar4.zzo())) {
                                        zzpvVar3.zzaW().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                                        i14 = 0;
                                        int i312 = -1;
                                        zzhpVar = null;
                                        z7 = false;
                                        while (i14 < zzhlVar4.zza()) {
                                        }
                                        if (z7) {
                                        }
                                        if (zzhpVar == null) {
                                        }
                                        i6 = i13;
                                        if (z3) {
                                        }
                                        if ("_e".equals(zzhlVar4.zzo())) {
                                        }
                                    }
                                    i13 = i12;
                                    i6 = i13;
                                    if (z3) {
                                    }
                                    if ("_e".equals(zzhlVar4.zzo())) {
                                    }
                                }
                            }
                            str2 = str6;
                            if (zzhlVar4.zzo().equals(zzjy.zza(str7))) {
                            }
                            zzw = zzpvVar3.zzr().zzw(zzprVar3.zza.zzF(), zzhlVar4.zzo());
                            if (zzw) {
                            }
                            z3 = zzw;
                            i11 = 0;
                            z4 = false;
                            boolean z1122 = false;
                            while (true) {
                                z5 = z4;
                                if (i11 >= zzhlVar4.zza()) {
                                }
                                i11++;
                                i20 = i15;
                            }
                            i5 = i20;
                            z6 = z1122;
                            if (!z5) {
                            }
                            if (!z6) {
                            }
                            if (zzpvVar3.zzj().zzo(zzpvVar3.zza(), zzprVar3.zza.zzF(), false, false, false, false, true, false, false).zze > zzpvVar3.zzi().zzh(zzprVar3.zza.zzF(), zzgi.zzo)) {
                            }
                            if (zzqf.zzaq(zzhlVar4.zzo())) {
                            }
                            i13 = i12;
                            i6 = i13;
                            if (z3) {
                            }
                            if ("_e".equals(zzhlVar4.zzo())) {
                            }
                        }
                        i19 = i2;
                        i17 = i8 + 1;
                        str6 = str4;
                        z9 = z10;
                        i16 = i7;
                        str7 = str3;
                    }
                    long j5 = 0;
                    int i33 = i;
                    long j6 = 0;
                    int i34 = 0;
                    while (i34 < i33) {
                        com.google.android.gms.internal.measurement.zzhm zzh2 = zzhwVar.zzh(i34);
                        if ("_e".equals(zzh2.zzh())) {
                            zzpvVar3.zzA();
                            if (zzqa.zzG(zzh2, "_fr") != null) {
                                zzhwVar.zzD(i34);
                                i33--;
                                i34--;
                                i34++;
                            }
                        }
                        zzpvVar3.zzA();
                        com.google.android.gms.internal.measurement.zzhq zzG = zzqa.zzG(zzh2, "_et");
                        if (zzG != null) {
                            Long valueOf = zzG.zzw() ? Long.valueOf(zzG.zzd()) : null;
                            if (valueOf != null && valueOf.longValue() > 0) {
                                j6 += valueOf.longValue();
                            }
                        }
                        i34++;
                    }
                    zzpvVar3.zzaI(zzhwVar, j6, false);
                    Iterator it3 = zzhwVar.zzaM().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhm) it3.next()).zzh())) {
                            zzpvVar3.zzj().zzP(zzhwVar.zzaF(), "_se");
                            break;
                        }
                    }
                    if (zzqa.zza(zzhwVar, "_sid") >= 0) {
                        zzpvVar3.zzaI(zzhwVar, j6, true);
                    } else {
                        int zza = zzqa.zza(zzhwVar, "_se");
                        if (zza >= 0) {
                            zzhwVar.zzE(zza);
                            zzpvVar3.zzaW().zze().zzb("Session engagement user property is in the bundle without session ID. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                        }
                    }
                    String zzF5 = zzprVar3.zza.zzF();
                    zzpvVar3.zzaX().zzg();
                    zzpvVar3.zzM();
                    zzh zzl = zzpvVar3.zzj().zzl(zzF5);
                    if (zzl == null) {
                        zzpvVar3.zzaW().zze().zzb("Cannot fix consent fields without appInfo. appId", zzhe.zzn(zzF5));
                    } else {
                        zzpvVar3.zzQ(zzl, zzhwVar);
                    }
                    String zzF6 = zzprVar3.zza.zzF();
                    zzpvVar3.zzaX().zzg();
                    zzpvVar3.zzM();
                    zzh zzl2 = zzpvVar3.zzj().zzl(zzF6);
                    if (zzl2 == null) {
                        zzpvVar3.zzaW().zzk().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzhe.zzn(zzF6));
                    } else {
                        zzpvVar3.zzaa(zzl2, zzhwVar);
                    }
                    zzhwVar.zzax(Long.MAX_VALUE);
                    zzhwVar.zzab(Long.MIN_VALUE);
                    for (int i35 = 0; i35 < zzhwVar.zzc(); i35++) {
                        com.google.android.gms.internal.measurement.zzhm zzh3 = zzhwVar.zzh(i35);
                        if (zzh3.zzd() < zzhwVar.zzf()) {
                            zzhwVar.zzax(zzh3.zzd());
                        }
                        if (zzh3.zzd() > zzhwVar.zze()) {
                            zzhwVar.zzab(zzh3.zzd());
                        }
                    }
                    zzhwVar.zzB();
                    zzjx zzjxVar = zzjx.zza;
                    zzjx zzl3 = zzpvVar3.zzu(zzprVar3.zza.zzF()).zzl(zzjx.zzk(zzprVar3.zza.zzK(), 100));
                    zzjx zzt2 = zzpvVar3.zzj().zzt(zzprVar3.zza.zzF());
                    zzpvVar3.zzj().zzW(zzprVar3.zza.zzF(), zzl3);
                    zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                    if (!zzl3.zzr(zzjwVar) && zzt2.zzr(zzjwVar)) {
                        zzpvVar3.zzj().zzI(zzprVar3.zza.zzF());
                    } else if (zzl3.zzr(zzjwVar) && !zzt2.zzr(zzjwVar)) {
                        zzpvVar3.zzj().zzQ(zzprVar3.zza.zzF());
                    }
                    zzjw zzjwVar2 = zzjw.AD_STORAGE;
                    if (!zzl3.zzr(zzjwVar2)) {
                        zzhwVar.zzz();
                        zzhwVar.zzw();
                        zzhwVar.zzt();
                    }
                    if (!zzl3.zzr(zzjwVar)) {
                        zzhwVar.zzq();
                        zzhwVar.zzA();
                    }
                    zzqr.zzb();
                    if (zzpvVar3.zzi().zzx(zzprVar3.zza.zzF(), zzgi.zzaV) && zzpvVar3.zzB().zzab(zzprVar3.zza.zzF()) && zzpvVar3.zzu(zzprVar3.zza.zzF()).zzr(zzjwVar2) && zzprVar3.zza.zzbt()) {
                        zzpvVar3.zzR(zzhwVar, zzprVar3);
                    }
                    zzhwVar.zzr();
                    zzhwVar.zzi(zzpvVar3.zzh().zza(zzhwVar.zzaF(), zzhwVar.zzaM(), zzhwVar.zzaN(), Long.valueOf(zzhwVar.zzf()), Long.valueOf(zzhwVar.zze()), !zzl3.zzr(zzjwVar)));
                    if (zzpvVar3.zzi().zzB(zzprVar3.zza.zzF())) {
                        try {
                            HashMap hashMap = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom zzJ = zzpvVar3.zzB().zzJ();
                            int i36 = 0;
                            zzpvVar3 = zzpvVar3;
                            while (i36 < zzhwVar.zzc()) {
                                com.google.android.gms.internal.measurement.zzhl zzhlVar8 = (com.google.android.gms.internal.measurement.zzhl) zzhwVar.zzh(i36).zzch();
                                if (zzhlVar8.zzo().equals("_ep")) {
                                    zzpvVar3.zzA();
                                    String str10 = (String) zzqa.zzH((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba(), "_en");
                                    zzbd zzbdVar = (zzbd) hashMap.get(str10);
                                    if (zzbdVar == null && (zzbdVar = zzpvVar3.zzj().zzs(zzprVar3.zza.zzF(), (String) Preconditions.checkNotNull(str10))) != null) {
                                        hashMap.put(str10, zzbdVar);
                                    }
                                    if (zzbdVar != null && zzbdVar.zzi == null) {
                                        Long l2 = zzbdVar.zzj;
                                        if (l2 != null && l2.longValue() > 1) {
                                            zzpvVar3.zzA();
                                            zzqa.zzD(zzhlVar8, "_sr", l2);
                                        }
                                        Boolean bool2 = zzbdVar.zzk;
                                        if (bool2 != null && bool2.booleanValue()) {
                                            zzpvVar3.zzA();
                                            zzqa.zzD(zzhlVar8, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba());
                                    }
                                    zzhwVar.zzad(i36, zzhlVar8);
                                    j3 = j5;
                                    secureRandom = zzJ;
                                    i4 = i36;
                                } else {
                                    zzif zzr = zzpvVar3.zzr();
                                    String zzF7 = zzprVar3.zza.zzF();
                                    String zza2 = zzr.zza(zzF7, "measurement.account.time_zone_offset_minutes");
                                    if (!TextUtils.isEmpty(zza2)) {
                                        try {
                                            parseLong = Long.parseLong(zza2);
                                        } catch (NumberFormatException e) {
                                            zzr.zzu.zzaW().zzk().zzc("Unable to parse timezone offset. appId", zzhe.zzn(zzF7), e);
                                        }
                                        long zzt3 = zzpvVar3.zzB().zzt(zzhlVar8.zzc(), parseLong);
                                        com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba();
                                        j3 = j5;
                                        Long l3 = 1L;
                                        if (!TextUtils.isEmpty("_dbg")) {
                                            Iterator it4 = zzhmVar.zzi().iterator();
                                            while (true) {
                                                if (!it4.hasNext()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) it4.next();
                                                if ("_dbg".equals(zzhqVar2.zzg())) {
                                                    if (l3.equals(Long.valueOf(zzhqVar2.zzd()))) {
                                                        zzc = 1;
                                                    }
                                                }
                                            }
                                        }
                                        zzc = zzr().zzc(zzprVar3.zza.zzF(), zzhlVar8.zzo());
                                        if (zzc > 0) {
                                            zzaW().zzk().zzc("Sample rate must be positive. event, rate", zzhlVar8.zzo(), Integer.valueOf(zzc));
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba());
                                            zzhwVar.zzad(i36, zzhlVar8);
                                        } else {
                                            zzbd zzbdVar2 = (zzbd) hashMap.get(zzhlVar8.zzo());
                                            if (zzbdVar2 == null && (zzbdVar2 = zzj().zzs(zzprVar3.zza.zzF(), zzhlVar8.zzo())) == null) {
                                                j4 = parseLong;
                                                zzaW().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzprVar3.zza.zzF(), zzhlVar8.zzo());
                                                zzbdVar2 = new zzbd(zzprVar3.zza.zzF(), zzhlVar8.zzo(), 1L, 1L, 1L, zzhlVar8.zzc(), 0L, null, null, null, null);
                                            } else {
                                                j4 = parseLong;
                                            }
                                            zzA();
                                            Long l4 = (Long) zzqa.zzH((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba(), "_eid");
                                            Boolean valueOf2 = Boolean.valueOf(l4 != null);
                                            if (zzc == 1) {
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba());
                                                if (valueOf2.booleanValue() && (zzbdVar2.zzi != null || zzbdVar2.zzj != null || zzbdVar2.zzk != null)) {
                                                    hashMap.put(zzhlVar8.zzo(), zzbdVar2.zza(null, null, null));
                                                }
                                                zzhwVar.zzad(i36, zzhlVar8);
                                            } else {
                                                if (zzJ.nextInt(zzc) == 0) {
                                                    zzA();
                                                    Long valueOf3 = Long.valueOf(zzc);
                                                    zzqa.zzD(zzhlVar8, "_sr", valueOf3);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba());
                                                    if (valueOf2.booleanValue()) {
                                                        zzbdVar2 = zzbdVar2.zza(null, valueOf3, null);
                                                    }
                                                    hashMap.put(zzhlVar8.zzo(), zzbdVar2.zzb(zzhlVar8.zzc(), zzt3));
                                                    secureRandom = zzJ;
                                                    i4 = i36;
                                                } else {
                                                    Long l5 = zzbdVar2.zzh;
                                                    if (l5 != null) {
                                                        l = l4;
                                                        bool = valueOf2;
                                                        i3 = i36;
                                                        zzt = l5.longValue();
                                                        secureRandom = zzJ;
                                                    } else {
                                                        secureRandom = zzJ;
                                                        i3 = i36;
                                                        l = l4;
                                                        bool = valueOf2;
                                                        zzt = zzB().zzt(zzhlVar8.zzb(), j4);
                                                    }
                                                    if (zzt != zzt3) {
                                                        zzA();
                                                        zzqa.zzD(zzhlVar8, "_efs", 1L);
                                                        zzA();
                                                        Long valueOf4 = Long.valueOf(zzc);
                                                        zzqa.zzD(zzhlVar8, "_sr", valueOf4);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba());
                                                        if (bool.booleanValue()) {
                                                            zzbdVar2 = zzbdVar2.zza(null, valueOf4, true);
                                                        }
                                                        hashMap.put(zzhlVar8.zzo(), zzbdVar2.zzb(zzhlVar8.zzc(), zzt3));
                                                    } else if (bool.booleanValue()) {
                                                        hashMap.put(zzhlVar8.zzo(), zzbdVar2.zza(l, null, null));
                                                    }
                                                    i4 = i3;
                                                }
                                                zzhwVar.zzad(i4, zzhlVar8);
                                            }
                                        }
                                        secureRandom = zzJ;
                                        i4 = i36;
                                    }
                                    parseLong = j5;
                                    long zzt32 = zzpvVar3.zzB().zzt(zzhlVar8.zzc(), parseLong);
                                    com.google.android.gms.internal.measurement.zzhm zzhmVar2 = (com.google.android.gms.internal.measurement.zzhm) zzhlVar8.zzba();
                                    j3 = j5;
                                    Long l32 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                    }
                                    zzc = zzr().zzc(zzprVar3.zza.zzF(), zzhlVar8.zzo());
                                    if (zzc > 0) {
                                    }
                                    secureRandom = zzJ;
                                    i4 = i36;
                                }
                                i36 = i4 + 1;
                                zzpvVar3 = this;
                                j5 = j3;
                                zzJ = secureRandom;
                            }
                            j2 = j5;
                            if (arrayList3.size() < zzhwVar.zzc()) {
                                zzhwVar.zzu();
                                zzhwVar.zzj(arrayList3);
                            }
                            Iterator it5 = hashMap.entrySet().iterator();
                            while (it5.hasNext()) {
                                zzj().zzV((zzbd) ((Map.Entry) it5.next()).getValue());
                            }
                        } catch (Throwable th) {
                            th = th;
                            zzpvVar4 = this;
                            zzpvVar4.zzj().zzL();
                            throw th;
                        }
                    } else {
                        j2 = 0;
                    }
                    String zzF8 = zzprVar3.zza.zzF();
                    zzh zzl4 = zzj().zzl(zzF8);
                    if (zzl4 == null) {
                        zzaW().zze().zzb("Bundling raw events w/o app info. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                    } else if (zzhwVar.zzc() > 0) {
                        long zzs = zzl4.zzs();
                        if (zzs != j2) {
                            zzhwVar.zzap(zzs);
                        } else {
                            zzhwVar.zzx();
                        }
                        long zzu = zzl4.zzu();
                        if (zzu != j2) {
                            zzs = zzu;
                        }
                        if (zzs != j2) {
                            zzhwVar.zzaq(zzs);
                        } else {
                            zzhwVar.zzy();
                        }
                        zzl4.zzQ(zzhwVar.zzc());
                        zzhwVar.zzV((int) zzl4.zzr());
                        zzhwVar.zzP((int) zzl4.zzt());
                        zzl4.zzau(zzhwVar.zzf());
                        zzl4.zzas(zzhwVar.zze());
                        String zzB = zzl4.zzB();
                        if (zzB != null) {
                            zzhwVar.zzaj(zzB);
                        } else {
                            zzhwVar.zzv();
                        }
                        zzj().zzT(zzl4, false, false);
                    }
                    if (zzhwVar.zzc() > 0) {
                        zzpvVar4 = this;
                        zzpvVar4.zzn.zzaV();
                        com.google.android.gms.internal.measurement.zzgo zzj2 = zzpvVar4.zzr().zzj(zzprVar3.zza.zzF());
                        try {
                            try {
                                if (zzj2 != null && zzj2.zzw()) {
                                    zzhwVar.zzR(zzj2.zzc());
                                    zzj = zzpvVar4.zzj();
                                    zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                                    zzj.zzg();
                                    zzj.zzav();
                                    Preconditions.checkNotNull(zzhxVar);
                                    Preconditions.checkNotEmpty(zzhxVar.zzF());
                                    Preconditions.checkState(zzhxVar.zzbK());
                                    zzj.zzO();
                                    zzio zzioVar = zzj.zzu;
                                    currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
                                    zzo = zzhxVar.zzo();
                                    zzioVar.zzf();
                                    if (zzo >= currentTimeMillis - zzam.zzI()) {
                                        long zzo4 = zzhxVar.zzo();
                                        zzioVar.zzf();
                                    }
                                    zzioVar.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(currentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                                    byte[] zzB2 = zzj.zzg.zzA().zzB(zzhxVar.zzcd());
                                    zzio zzioVar2 = zzj.zzu;
                                    zzioVar2.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(zzB2.length));
                                    contentValues = new ContentValues();
                                    contentValues.put(MBridgeConstans.APP_ID, zzhxVar.zzF());
                                    contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                                    contentValues.put("data", zzB2);
                                    contentValues.put("has_realtime", Integer.valueOf(i2));
                                    if (zzhxVar.zzbR()) {
                                        contentValues.put("retry_count", Integer.valueOf(zzhxVar.zzg()));
                                    }
                                    zzpvVar2 = zzpvVar4;
                                    if (zzj.zzj().insert("queue", null, contentValues) == -1) {
                                        zzioVar2.zzaW().zze().zzb("Failed to insert bundle (got -1). appId", zzhe.zzn(zzhxVar.zzF()));
                                        zzpvVar2 = zzpvVar4;
                                    }
                                }
                                zzpvVar2 = zzpvVar4;
                                if (zzj.zzj().insert("queue", null, contentValues) == -1) {
                                }
                            } catch (SQLiteException e2) {
                                zzj.zzu.zzaW().zze().zzc("Error storing bundle. appId", zzhe.zzn(zzhxVar.zzF()), e2);
                                zzpvVar2 = zzpvVar4;
                            }
                            byte[] zzB22 = zzj.zzg.zzA().zzB(zzhxVar.zzcd());
                            zzio zzioVar22 = zzj.zzu;
                            zzioVar22.zzaW().zzj().zzb("Saving bundle, size", Integer.valueOf(zzB22.length));
                            contentValues = new ContentValues();
                            contentValues.put(MBridgeConstans.APP_ID, zzhxVar.zzF());
                            contentValues.put("bundle_end_timestamp", Long.valueOf(zzhxVar.zzo()));
                            contentValues.put("data", zzB22);
                            contentValues.put("has_realtime", Integer.valueOf(i2));
                            if (zzhxVar.zzbR()) {
                            }
                        } catch (IOException e3) {
                            zzj.zzu.zzaW().zze().zzc("Data loss. Failed to serialize bundle. appId", zzhe.zzn(zzhxVar.zzF()), e3);
                            zzpvVar2 = zzpvVar4;
                        }
                        if (zzprVar3.zza.zzP().isEmpty()) {
                            zzhwVar.zzR(-1L);
                        } else {
                            zzpvVar4.zzaW().zzk().zzb("Did not find measurement config or missing version info. appId", zzhe.zzn(zzprVar3.zza.zzF()));
                        }
                        zzj = zzpvVar4.zzj();
                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                        zzj.zzg();
                        zzj.zzav();
                        Preconditions.checkNotNull(zzhxVar);
                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                        Preconditions.checkState(zzhxVar.zzbK());
                        zzj.zzO();
                        zzio zzioVar3 = zzj.zzu;
                        currentTimeMillis = zzioVar3.zzaU().currentTimeMillis();
                        zzo = zzhxVar.zzo();
                        zzioVar3.zzf();
                        if (zzo >= currentTimeMillis - zzam.zzI()) {
                        }
                        zzioVar3.zzaW().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzhe.zzn(zzhxVar.zzF()), Long.valueOf(currentTimeMillis), Long.valueOf(zzhxVar.zzo()));
                    } else {
                        zzpvVar2 = this;
                    }
                    zzpvVar2.zzj().zzJ(zzprVar3.zzb);
                    zzaw zzj3 = zzpvVar2.zzj();
                    SQLiteDatabase zzj4 = zzj3.zzj();
                    try {
                        String[] strArr = new String[2];
                        strArr[0] = zzF8;
                        z2 = true;
                        try {
                            strArr[1] = zzF8;
                            zzj4.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", strArr);
                        } catch (SQLiteException e4) {
                            e = e4;
                            zzj3.zzu.zzaW().zze().zzc("Failed to remove unused event metadata. appId", zzhe.zzn(zzF8), e);
                            zzpvVar2.zzj().zzS();
                            z = z2;
                            zzpvVar = zzpvVar2;
                            zzpvVar.zzj().zzL();
                            return z;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        z2 = true;
                    }
                    zzpvVar2.zzj().zzS();
                    z = z2;
                    zzpvVar = zzpvVar2;
                    zzpvVar.zzj().zzL();
                    return z;
                }
                zzpv zzpvVar5 = zzpvVar3;
                z = false;
                zzpvVar5.zzj().zzS();
                zzpvVar = zzpvVar5;
                zzpvVar.zzj().zzL();
                return z;
            } catch (Throwable th2) {
                th = th2;
                zzpvVar4.zzj().zzL();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zzpvVar4 = zzpvVar3;
        }
    }

    private final boolean zzaN() {
        zzaX().zzg();
        zzM();
        return zzj().zzaa() || !TextUtils.isEmpty(zzj().zzA());
    }

    private final boolean zzaO(String str, String str2) {
        zzbd zzs = zzj().zzs(str, str2);
        return zzs == null || zzs.zzc < 1;
    }

    private final boolean zzaP(com.google.android.gms.internal.measurement.zzhl zzhlVar, com.google.android.gms.internal.measurement.zzhl zzhlVar2) {
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba(), "_sc");
        String zzh = zzG == null ? null : zzG.zzh();
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG2 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar2.zzba(), "_pc");
        String zzh2 = zzG2 != null ? zzG2.zzh() : null;
        if (zzh2 == null || !zzh2.equals(zzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhlVar.zzo()));
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG3 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba(), "_et");
        if (zzG3 == null || !zzG3.zzw() || zzG3.zzd() <= 0) {
            return true;
        }
        long zzd = zzG3.zzd();
        zzA();
        com.google.android.gms.internal.measurement.zzhq zzG4 = zzqa.zzG((com.google.android.gms.internal.measurement.zzhm) zzhlVar2.zzba(), "_et");
        if (zzG4 != null && zzG4.zzd() > 0) {
            zzd += zzG4.zzd();
        }
        zzA();
        zzqa.zzD(zzhlVar2, "_et", Long.valueOf(zzd));
        zzA();
        zzqa.zzD(zzhlVar, "_fr", 1L);
        return true;
    }

    private static final boolean zzaQ(zzr zzrVar) {
        return (TextUtils.isEmpty(zzrVar.zzb) && TextUtils.isEmpty(zzrVar.zzp)) ? false : true;
    }

    private static final zzpg zzaR(zzpg zzpgVar) {
        if (zzpgVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzpgVar.zzax()) {
            return zzpgVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzpgVar.getClass()))));
    }

    private static final Boolean zzaS(zzr zzrVar) {
        Boolean bool = zzrVar.zzq;
        String str = zzrVar.zzE;
        if (!TextUtils.isEmpty(str)) {
            zzju zzb2 = zze.zza(str).zzb();
            zzju zzjuVar = zzju.UNINITIALIZED;
            int ordinal = zzb2.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return null;
            }
            if (ordinal == 2) {
                return true;
            }
            if (ordinal == 3) {
                return false;
            }
        }
        return bool;
    }

    public static zzpv zzz(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpv.class) {
                if (zzb == null) {
                    zzb = new zzpv((zzpw) Preconditions.checkNotNull(new zzpw(context)), null);
                }
            }
        }
        return zzb;
    }

    public final zzqa zzA() {
        zzqa zzqaVar = this.zzi;
        zzaR(zzqaVar);
        return zzqaVar;
    }

    public final zzqf zzB() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzw();
    }

    final String zzC(zzjx zzjxVar) {
        if (!zzjxVar.zzr(zzjw.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzB().zzJ().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final String zzD(zzr zzrVar) {
        try {
            return (String) zzaX().zzf(new zzpo(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zze().zzc("Failed to get app instance id. appId", zzhe.zzn(zzrVar.zza), e);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:4|(2:6|(1:(7:30|31|32|33|(1:(4:35|(1:37)|38|(1:41)(1:40)))(0)|(1:44)|45)(3:11|(9:14|15|16|17|18|19|21|22|12)|29)))|54|31|32|33|(0)(0)|(0)|45) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x012c, code lost:
    
        r3.zzu.zzaW().zze().zzc("Error querying trigger uris. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r1), r0);
        r0 = java.util.Collections.emptyList();
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105 A[Catch: all -> 0x0129, SQLiteException -> 0x012b, LOOP:1: B:35:0x0105->B:40:0x0126, LOOP_START, PHI: r16
      0x0105: PHI (r16v2 int) = (r16v1 int), (r16v3 int) binds: [B:34:0x0103, B:40:0x0126] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {SQLiteException -> 0x012b, blocks: (B:33:0x00dc, B:35:0x0105, B:38:0x010d), top: B:32:0x00dc, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final List zzF(zzr zzrVar, Bundle bundle) {
        int i;
        Cursor cursor;
        zzaX().zzg();
        zzqr.zzb();
        zzam zzi = zzi();
        String str = zzrVar.zza;
        if (!zzi.zzx(str, zzgi.zzaV) || str == null) {
            return new ArrayList();
        }
        try {
            if (bundle != null) {
                int[] intArray = bundle.getIntArray("uriSources");
                long[] longArray = bundle.getLongArray("uriTimestamps");
                if (intArray != null) {
                    if (longArray == null || longArray.length != intArray.length) {
                        i = 2;
                        zzaW().zze().zza("Uri sources and timestamps do not match");
                        zzaw zzj = zzj();
                        String str2 = zzrVar.zza;
                        Preconditions.checkNotEmpty(str2);
                        zzj.zzg();
                        zzj.zzav();
                        List arrayList = new ArrayList();
                        cursor = null;
                        SQLiteDatabase zzj2 = zzj.zzj();
                        String[] strArr = new String[3];
                        strArr[0] = "trigger_uri";
                        strArr[1] = "timestamp_millis";
                        strArr[i] = "source";
                        cursor = zzj2.query("trigger_uris", strArr, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                        if (cursor.moveToFirst()) {
                            while (true) {
                                String string = cursor.getString(0);
                                if (string == null) {
                                    string = "";
                                }
                                int i2 = i;
                                arrayList.add(new zzov(string, cursor.getLong(1), cursor.getInt(i2)));
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                    for (int i3 = 0; i3 < intArray.length; i3++) {
                        zzaw zzj3 = zzj();
                        int i4 = intArray[i3];
                        long j = longArray[i3];
                        Preconditions.checkNotEmpty(str);
                        zzj3.zzg();
                        zzj3.zzav();
                        try {
                            try {
                                int delete = zzj3.zzj().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i4), String.valueOf(j)});
                                zzj3.zzu.zzaW().zzj().zzd("Pruned " + delete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i4), Long.valueOf(j));
                            } catch (SQLiteException e) {
                                e = e;
                                zzj3.zzu.zzaW().zze().zzc("Error pruning trigger URIs. appId", zzhe.zzn(str), e);
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    }
                }
            }
            SQLiteDatabase zzj22 = zzj.zzj();
            String[] strArr2 = new String[3];
            strArr2[0] = "trigger_uri";
            strArr2[1] = "timestamp_millis";
            strArr2[i] = "source";
            cursor = zzj22.query("trigger_uris", strArr2, "app_id=?", new String[]{str2}, null, null, "rowid", null);
            if (cursor.moveToFirst()) {
            }
            if (cursor != null) {
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        i = 2;
        zzaw zzj4 = zzj();
        String str22 = zzrVar.zza;
        Preconditions.checkNotEmpty(str22);
        zzj4.zzg();
        zzj4.zzav();
        List arrayList2 = new ArrayList();
        cursor = null;
    }

    final void zzK(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    final void zzL() {
        zzaX().zzg();
        zzM();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzaz()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zze().zza("Bad channel to read from");
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read == 4) {
                        allocate.flip();
                        i = allocate.getInt();
                    } else if (read != -1) {
                        zzaW().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                } catch (IOException e) {
                    zzaW().zze().zzb("Failed to read from channel", e);
                }
            }
            int zzi = this.zzn.zzh().zzi();
            zzaX().zzg();
            if (i > zzi) {
                zzaW().zze().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi));
                return;
            }
            if (i < zzi) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zze().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(zzi);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zze().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi));
                        return;
                    } catch (IOException e2) {
                        zzaW().zze().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zze().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi));
            }
        }
    }

    final void zzM() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzN(String str, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        int zza;
        int indexOf;
        Set zzo = zzr().zzo(str);
        if (zzo != null) {
            zzhwVar.zzl(zzo);
        }
        if (zzr().zzB(str)) {
            zzhwVar.zzs();
        }
        if (zzr().zzE(str)) {
            String zzaK = zzhwVar.zzaK();
            if (!TextUtils.isEmpty(zzaK) && (indexOf = zzaK.indexOf(".")) != -1) {
                zzhwVar.zzam(zzaK.substring(0, indexOf));
            }
        }
        if (zzr().zzF(str) && (zza = zzqa.zza(zzhwVar, "_id")) != -1) {
            zzhwVar.zzE(zza);
        }
        if (zzr().zzD(str)) {
            zzhwVar.zzt();
        }
        if (zzr().zzA(str)) {
            zzhwVar.zzq();
            if (zzu(str).zzr(zzjw.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzps zzpsVar = (zzps) map.get(str);
                if (zzpsVar == null || zzpsVar.zzb + zzi().zzk(str, zzgi.zzaj) < zzaU().elapsedRealtime()) {
                    zzpsVar = new zzps(this);
                    map.put(str, zzpsVar);
                }
                zzhwVar.zzac(zzpsVar.zza);
            }
        }
        if (zzr().zzC(str)) {
            zzhwVar.zzA();
        }
    }

    final void zzO(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzH()) && TextUtils.isEmpty(zzhVar.zzA())) {
            zzW((String) Preconditions.checkNotNull(zzhVar.zzC()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzC());
        zzaW().zzj().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgo zzj = zzr().zzj(str);
        String zzl = zzr().zzl(str);
        ArrayMap arrayMap = null;
        if (zzj != null) {
            if (!TextUtils.isEmpty(zzl)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzl);
                arrayMap = arrayMap2;
            }
            String zzk = zzr().zzk(str);
            if (!TextUtils.isEmpty(zzk)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, zzk);
            }
        }
        this.zzu = true;
        zzp().zza(zzhVar, arrayMap, new zzhg() { // from class: com.google.android.gms.measurement.internal.zzpj
            @Override // com.google.android.gms.measurement.internal.zzhg
            public final void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                zzpv.this.zzW(str2, i, th, bArr, map);
            }
        });
    }

    final void zzP(zzr zzrVar, long j) {
        zzh zzl = zzj().zzl((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzl != null && zzB().zzaw(zzrVar.zzb, zzl.zzH(), zzrVar.zzp, zzl.zzA())) {
            zzaW().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzhe.zzn(zzl.zzC()));
            zzaw zzj = zzj();
            String zzC = zzl.zzC();
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzC);
            try {
                SQLiteDatabase zzj2 = zzj.zzj();
                String[] strArr = {zzC};
                int delete = zzj2.delete("events", "app_id=?", strArr) + zzj2.delete("user_attributes", "app_id=?", strArr) + zzj2.delete("conditional_properties", "app_id=?", strArr) + zzj2.delete("apps", "app_id=?", strArr) + zzj2.delete("raw_events", "app_id=?", strArr) + zzj2.delete("raw_events_metadata", "app_id=?", strArr) + zzj2.delete("event_filters", "app_id=?", strArr) + zzj2.delete("property_filters", "app_id=?", strArr) + zzj2.delete("audience_filter_values", "app_id=?", strArr) + zzj2.delete("consent_settings", "app_id=?", strArr) + zzj2.delete("default_event_params", "app_id=?", strArr) + zzj2.delete("trigger_uris", "app_id=?", strArr);
                if (delete > 0) {
                    zzj.zzu.zzaW().zzj().zzc("Deleted application data. app, records", zzC, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Error deleting application data. appId, error", zzhe.zzn(zzC), e);
            }
            zzl = null;
        }
        if (zzl != null) {
            boolean z = (zzl.zze() == -2147483648L || zzl.zze() == zzrVar.zzj) ? false : true;
            String zzF = zzl.zzF();
            if (z || ((zzl.zze() != -2147483648L || zzF == null || zzF.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzF);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), "auto", j);
                if (zzi().zzx(null, zzgi.zzbm)) {
                    zzU(zzbhVar, zzrVar);
                } else {
                    zzS(zzbhVar, zzrVar);
                }
            }
        }
    }

    final void zzQ(zzh zzhVar, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        com.google.android.gms.internal.measurement.zzio zzioVar;
        zzaX().zzg();
        zzM();
        zzao zzb2 = zzao.zzb(zzhwVar.zzaH());
        String zzC = zzhVar.zzC();
        zzaX().zzg();
        zzM();
        zzjx zzu = zzu(zzC);
        zzju zzjuVar = zzju.UNINITIALIZED;
        int ordinal = zzu.zze().ordinal();
        if (ordinal == 1) {
            zzb2.zzd(zzjw.AD_STORAGE, zzan.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            zzb2.zzc(zzjw.AD_STORAGE, zzu.zzb());
        } else {
            zzb2.zzd(zzjw.AD_STORAGE, zzan.FAILSAFE);
        }
        int ordinal2 = zzu.zzf().ordinal();
        if (ordinal2 == 1) {
            zzb2.zzd(zzjw.ANALYTICS_STORAGE, zzan.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            zzb2.zzc(zzjw.ANALYTICS_STORAGE, zzu.zzb());
        } else {
            zzb2.zzd(zzjw.ANALYTICS_STORAGE, zzan.FAILSAFE);
        }
        String zzC2 = zzhVar.zzC();
        zzaX().zzg();
        zzM();
        zzba zzl = zzl(zzC2, zzm(zzC2), zzu(zzC2), zzb2);
        zzhwVar.zzak(((Boolean) Preconditions.checkNotNull(zzl.zzh())).booleanValue());
        if (!TextUtils.isEmpty(zzl.zzi())) {
            zzhwVar.zzU(zzl.zzi());
        }
        zzaX().zzg();
        zzM();
        Iterator it = zzhwVar.zzaN().iterator();
        while (true) {
            if (it.hasNext()) {
                zzioVar = (com.google.android.gms.internal.measurement.zzio) it.next();
                if ("_npa".equals(zzioVar.zzg())) {
                    break;
                }
            } else {
                zzioVar = null;
                break;
            }
        }
        if (zzioVar != null) {
            zzjw zzjwVar = zzjw.AD_PERSONALIZATION;
            if (zzb2.zza(zzjwVar) == zzan.UNSET) {
                zzqd zzy = zzj().zzy(zzhVar.zzC(), "_npa");
                if (zzy != null) {
                    String str = zzy.zzb;
                    if ("tcf".equals(str)) {
                        zzb2.zzd(zzjwVar, zzan.TCF);
                    } else if (MBridgeConstans.DYNAMIC_VIEW_WX_APP.equals(str)) {
                        zzb2.zzd(zzjwVar, zzan.API);
                    } else {
                        zzb2.zzd(zzjwVar, zzan.MANIFEST);
                    }
                } else {
                    Boolean zzx = zzhVar.zzx();
                    if (zzx == null || ((zzx.booleanValue() && zzioVar.zzc() != 1) || !(zzx.booleanValue() || zzioVar.zzc() == 0))) {
                        zzb2.zzd(zzjwVar, zzan.API);
                    } else {
                        zzb2.zzd(zzjwVar, zzan.MANIFEST);
                    }
                }
            }
        } else {
            int zzaC = zzaC(zzhVar.zzC(), zzb2);
            com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
            zze.zzf("_npa");
            zze.zzg(zzaU().currentTimeMillis());
            zze.zze(zzaC);
            zzhwVar.zzp((com.google.android.gms.internal.measurement.zzio) zze.zzba());
            zzaW().zzj().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaC));
        }
        zzhwVar.zzS(zzb2.toString());
        boolean zzv = this.zzc.zzv(zzhVar.zzC());
        List zzaM = zzhwVar.zzaM();
        int i = 0;
        for (int i2 = 0; i2 < zzaM.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhm) zzaM.get(i2)).zzh())) {
                com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) ((com.google.android.gms.internal.measurement.zzhm) zzaM.get(i2)).zzch();
                List zzp = zzhlVar.zzp();
                int i3 = 0;
                while (true) {
                    if (i3 >= zzp.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhq) zzp.get(i3)).zzg())) {
                        String zzh = ((com.google.android.gms.internal.measurement.zzhq) zzp.get(i3)).zzh();
                        if (zzv && zzh.length() > 4) {
                            char[] charArray = zzh.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                                i4++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            zzh = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                        zze2.zzj("_tcfd");
                        zze2.zzk(zzh);
                        zzhlVar.zzj(i3, zze2);
                    } else {
                        i3++;
                    }
                }
                zzhwVar.zzad(i2, zzhlVar);
                return;
            }
        }
    }

    final void zzR(com.google.android.gms.internal.measurement.zzhw zzhwVar, zzpr zzprVar) {
        for (int i = 0; i < zzhwVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhwVar.zzh(i).zzch();
            Iterator it = zzhlVar.zzp().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhq) it.next()).zzg())) {
                    if (zzprVar.zza.zza() >= zzi().zzh(zzprVar.zza.zzF(), zzgi.zzak)) {
                        int zzh = zzi().zzh(zzprVar.zza.zzF(), zzgi.zzax);
                        String str = null;
                        if (zzh <= 0) {
                            if (zzi().zzx(zzprVar.zza.zzF(), zzgi.zzaX)) {
                                str = zzB().zzF();
                                com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze.zzj("_tu");
                                zze.zzk(str);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze.zzba());
                            }
                            com.google.android.gms.internal.measurement.zzhp zze2 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze2.zzj("_tr");
                            zze2.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze2.zzba());
                            zzov zzl = zzA().zzl(zzprVar.zza.zzF(), zzhwVar, zzhlVar, str);
                            if (zzl != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", zzprVar.zza.zzF(), zzl.zza);
                                zzj().zzad(zzprVar.zza.zzF(), zzl);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzprVar.zza.zzF())) {
                                    deque.add(zzprVar.zza.zzF());
                                }
                            }
                        } else if (zzj().zzo(zza(), zzprVar.zza.zzF(), false, false, false, false, false, false, true).zzg > zzh) {
                            com.google.android.gms.internal.measurement.zzhp zze3 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze3.zzj("_tnr");
                            zze3.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze3.zzba());
                        } else {
                            if (zzi().zzx(zzprVar.zza.zzF(), zzgi.zzaX)) {
                                str = zzB().zzF();
                                com.google.android.gms.internal.measurement.zzhp zze4 = com.google.android.gms.internal.measurement.zzhq.zze();
                                zze4.zzj("_tu");
                                zze4.zzk(str);
                                zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze4.zzba());
                            }
                            com.google.android.gms.internal.measurement.zzhp zze5 = com.google.android.gms.internal.measurement.zzhq.zze();
                            zze5.zzj("_tr");
                            zze5.zzi(1L);
                            zzhlVar.zzf((com.google.android.gms.internal.measurement.zzhq) zze5.zzba());
                            zzov zzl2 = zzA().zzl(zzprVar.zza.zzF(), zzhwVar, zzhlVar, str);
                            if (zzl2 != null) {
                                zzaW().zzj().zzc("Generated trigger URI. appId, uri", zzprVar.zza.zzF(), zzl2.zza);
                                zzj().zzad(zzprVar.zza.zzF(), zzl2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzprVar.zza.zzF())) {
                                    deque2.add(zzprVar.zza.zzF());
                                }
                            }
                        }
                    }
                    zzhwVar.zzae(i, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba());
                }
            }
        }
    }

    final void zzS(zzbh zzbhVar, zzr zzrVar) {
        zzbh zzbhVar2;
        List<zzai> zzC;
        List<zzai> zzC2;
        List<zzai> zzC3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzM();
        long j = zzbhVar.zzd;
        zzhf zzb2 = zzhf.zzb(zzbhVar);
        zzaX().zzg();
        boolean z = false;
        zzqf.zzN((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : this.zzG, zzb2.zzd, false);
        zzbh zza = zzb2.zza();
        zzA();
        if (zzqa.zzE(zza, zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            List list = zzrVar.zzs;
            if (list != null) {
                String str3 = zza.zza;
                if (!list.contains(str3)) {
                    zzaW().zzd().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza.zza, zza.zzc);
                    return;
                } else {
                    Bundle zzc = zza.zzb.zzc();
                    zzc.putLong("ga_safelisted", 1L);
                    zzbhVar2 = new zzbh(str3, new zzbf(zzc), zza.zzc, zza.zzd);
                }
            } else {
                zzbhVar2 = zza;
            }
            zzj().zzH();
            try {
                zzra.zzb();
                if (zzi().zzx(null, zzgi.zzbi) && "_s".equals(zzbhVar2.zza) && !zzj().zzZ(str2, "_s") && zzbhVar2.zzb.zze("_sid").longValue() != 0) {
                    if (!zzj().zzZ(str2, "_f") && !zzj().zzZ(str2, "_v")) {
                        zzj().zzG(str2, Long.valueOf(zzaU().currentTimeMillis() - 15000), "_sid", zzf(str2, zzbhVar2));
                    }
                    zzj().zzG(str2, null, "_sid", zzf(str2, zzbhVar2));
                }
                zzaw zzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj.zzg();
                zzj.zzav();
                char c = 2;
                if (j < 0) {
                    zzj.zzu.zzaW().zzk().zzc("Invalid time querying timed out conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                    zzC = Collections.emptyList();
                } else {
                    zzC = zzj.zzC("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzai zzaiVar : zzC) {
                    if (zzaiVar != null) {
                        boolean z2 = z;
                        zzaW().zzj().zzd("User property timed out", zzaiVar.zza, this.zzn.zzj().zzf(zzaiVar.zzc.zzb), zzaiVar.zzc.zza());
                        zzbh zzbhVar3 = zzaiVar.zzg;
                        if (zzbhVar3 != null) {
                            zzax(new zzbh(zzbhVar3, j), zzrVar);
                        }
                        zzj().zza(str2, zzaiVar.zzc.zzb);
                        z = z2;
                    }
                }
                boolean z3 = z;
                zzaw zzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzav();
                if (j < 0) {
                    zzj2.zzu.zzaW().zzk().zzc("Invalid time querying expired conditional properties", zzhe.zzn(str2), Long.valueOf(j));
                    zzC2 = Collections.emptyList();
                } else {
                    String[] strArr = new String[2];
                    strArr[z3 ? 1 : 0] = str2;
                    strArr[1] = String.valueOf(j);
                    zzC2 = zzj2.zzC("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr);
                }
                ArrayList arrayList = new ArrayList(zzC2.size());
                for (zzai zzaiVar2 : zzC2) {
                    if (zzaiVar2 != null) {
                        char c2 = c;
                        zzaW().zzj().zzd("User property expired", zzaiVar2.zza, this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                        zzj().zzP(str2, zzaiVar2.zzc.zzb);
                        zzbh zzbhVar4 = zzaiVar2.zzk;
                        if (zzbhVar4 != null) {
                            arrayList.add(zzbhVar4);
                        }
                        zzj().zza(str2, zzaiVar2.zzc.zzb);
                        c = c2;
                    }
                }
                char c3 = c;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzax(new zzbh((zzbh) it.next(), j), zzrVar);
                }
                zzaw zzj3 = zzj();
                String str4 = zzbhVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzj3.zzg();
                zzj3.zzav();
                if (j < 0) {
                    zzio zzioVar = zzj3.zzu;
                    zzioVar.zzaW().zzk().zzd("Invalid time querying triggered conditional properties", zzhe.zzn(str2), zzioVar.zzj().zzd(str4), Long.valueOf(j));
                    zzC3 = Collections.emptyList();
                } else {
                    String[] strArr2 = new String[3];
                    strArr2[z3 ? 1 : 0] = str2;
                    strArr2[1] = str4;
                    strArr2[c3] = String.valueOf(j);
                    zzC3 = zzj3.zzC("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr2);
                }
                ArrayList arrayList2 = new ArrayList(zzC3.size());
                for (zzai zzaiVar3 : zzC3) {
                    if (zzaiVar3 != null) {
                        zzqb zzqbVar = zzaiVar3.zzc;
                        zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(zzaiVar3.zza), zzaiVar3.zzb, zzqbVar.zzb, j, Preconditions.checkNotNull(zzqbVar.zza()));
                        if (zzj().zzai(zzqdVar)) {
                            zzaW().zzj().zzd("User property triggered", zzaiVar3.zza, this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                        } else {
                            zzaW().zze().zzd("Too many active user properties, ignoring", zzhe.zzn(zzaiVar3.zza), this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                        }
                        zzbh zzbhVar5 = zzaiVar3.zzi;
                        if (zzbhVar5 != null) {
                            arrayList2.add(zzbhVar5);
                        }
                        zzaiVar3.zzc = new zzqb(zzqdVar);
                        zzaiVar3.zze = true;
                        zzj().zzah(zzaiVar3);
                    }
                }
                zzax(zzbhVar2, zzrVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzax(new zzbh((zzbh) it2.next(), j), zzrVar);
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzT(zzbh zzbhVar, String str) {
        zzh zzl = zzj().zzl(str);
        if (zzl == null || TextUtils.isEmpty(zzl.zzF())) {
            zzaW().zzd().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean zzaF = zzaF(zzl);
        if (zzaF == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zzk().zzb("Could not find package. appId", zzhe.zzn(str));
            }
        } else if (!zzaF.booleanValue()) {
            zzaW().zze().zzb("App version does not match; dropping event. appId", zzhe.zzn(str));
            return;
        }
        zzU(zzbhVar, new zzr(str, zzl.zzH(), zzl.zzF(), zzl.zze(), zzl.zzE(), zzl.zzq(), zzl.zzn(), (String) null, zzl.zzaJ(), false, zzl.zzG(), 0L, 0, zzl.zzaI(), false, zzl.zzA(), zzl.zzx(), zzl.zzo(), zzl.zzN(), (String) null, zzu(str).zzq(), "", (String) null, zzl.zzaL(), zzl.zzw(), zzu(str).zzb(), zzm(str).zzj(), zzl.zza(), zzl.zzf(), zzl.zzM(), zzl.zzK(), 0L, zzl.zzb()));
    }

    final void zzU(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzhf zzb2 = zzhf.zzb(zzbhVar);
        zzB().zzO(zzb2.zzd, zzj().zzk(str));
        zzB().zzQ(zzb2, zzi().zzf(str));
        zzbh zza = zzb2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza.zza)) {
            zzbf zzbfVar = zza.zzb;
            if ("referrer API v2".equals(zzbfVar.zzg("_cis"))) {
                String zzg = zzbfVar.zzg("gclid");
                if (!TextUtils.isEmpty(zzg)) {
                    zzas(new zzqb("_lgclid", zza.zzd, zzg, "auto"), zzrVar);
                }
            }
        }
        zzS(zza, zzrVar);
    }

    final void zzV() {
        this.zzt++;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:5:0x002b, B:13:0x0047, B:14:0x0157, B:24:0x0061, B:28:0x00b1, B:29:0x00a2, B:30:0x00b6, B:34:0x00c8, B:35:0x00e1, B:37:0x00f5, B:38:0x0114, B:40:0x011e, B:42:0x0124, B:43:0x0128, B:45:0x0134, B:47:0x013e, B:49:0x014c, B:50:0x0154, B:51:0x0103, B:52:0x00d0, B:54:0x00da), top: B:4:0x002b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:5:0x002b, B:13:0x0047, B:14:0x0157, B:24:0x0061, B:28:0x00b1, B:29:0x00a2, B:30:0x00b6, B:34:0x00c8, B:35:0x00e1, B:37:0x00f5, B:38:0x0114, B:40:0x011e, B:42:0x0124, B:43:0x0128, B:45:0x0134, B:47:0x013e, B:49:0x014c, B:50:0x0154, B:51:0x0103, B:52:0x00d0, B:54:0x00da), top: B:4:0x002b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:5:0x002b, B:13:0x0047, B:14:0x0157, B:24:0x0061, B:28:0x00b1, B:29:0x00a2, B:30:0x00b6, B:34:0x00c8, B:35:0x00e1, B:37:0x00f5, B:38:0x0114, B:40:0x011e, B:42:0x0124, B:43:0x0128, B:45:0x0134, B:47:0x013e, B:49:0x014c, B:50:0x0154, B:51:0x0103, B:52:0x00d0, B:54:0x00da), top: B:4:0x002b, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzW(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzaH();
            }
        }
        zzhc zzj = zzaW().zzj();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzj.zzb("onConfigFetched. Response size", valueOf);
        zzj().zzH();
        try {
            zzh zzl = zzj().zzl(str);
            if (i != 200 && i != 204) {
                if (i == 304) {
                    i = 304;
                }
                z = false;
                if (zzl == null) {
                    zzaW().zzk().zzb("App does not exist in onConfigFetched. appId", zzhe.zzn(str));
                } else {
                    if (!z && i != 404) {
                        zzl.zzam(zzaU().currentTimeMillis());
                        zzj().zzT(zzl, false, false);
                        zzaW().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                        zzr().zzq(str);
                        this.zzk.zze.zzb(zzaU().currentTimeMillis());
                        if (i == 503 || i == 429) {
                            this.zzk.zzc.zzb(zzaU().currentTimeMillis());
                        }
                        zzaL();
                    }
                    String zzaG = zzaG(map, HttpHeaders.LAST_MODIFIED);
                    String zzaG2 = zzaG(map, "ETag");
                    if (i != 404 && i != 304) {
                        zzr().zzz(str, bArr, zzaG, zzaG2);
                        zzl.zzab(zzaU().currentTimeMillis());
                        zzj().zzT(zzl, false, false);
                        if (i != 404) {
                            zzaW().zzl().zzb("Config not found. Using empty config. appId", str);
                        } else {
                            zzaW().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), valueOf);
                        }
                        if (!zzp().zzd() && zzaN()) {
                            zzat();
                        } else if (!zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().zzY(zzl.zzC())) {
                            zzav(zzl.zzC());
                        } else {
                            zzaL();
                        }
                    }
                    if (zzr().zzj(str) == null) {
                        zzr().zzz(str, null, null, null);
                    }
                    zzl.zzab(zzaU().currentTimeMillis());
                    zzj().zzT(zzl, false, false);
                    if (i != 404) {
                    }
                    if (!zzp().zzd()) {
                    }
                    if (!zzi().zzx(null, zzgi.zzaM)) {
                    }
                    zzaL();
                }
                zzj().zzS();
            }
            if (th == null) {
                z = true;
                if (zzl == null) {
                }
                zzj().zzS();
            }
            z = false;
            if (zzl == null) {
            }
            zzj().zzS();
        } finally {
            zzj().zzL();
        }
    }

    final void zzX(boolean z) {
        zzaL();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r21 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzY(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        zzaw zzj;
        long longValue;
        int i2 = i;
        zzaX().zzg();
        zzM();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.zzv = false;
                zzaH();
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        try {
            if (z) {
                if (i2 != 200) {
                    if (i2 == 204) {
                        i2 = 204;
                    }
                    String str2 = new String(bArr2, StandardCharsets.UTF_8);
                    zzaW().zzl().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
                    this.zzk.zze.zzb(zzaU().currentTimeMillis());
                    if (i2 == 503 || i2 == 429) {
                        this.zzk.zzc.zzb(zzaU().currentTimeMillis());
                    }
                    zzj().zzM(list2);
                    zzaL();
                    return;
                }
            }
            if (zzi().zzx(null, zzgi.zzaM)) {
                if (zzi().zzx(null, zzgi.zzaP)) {
                    HashMap hashMap = new HashMap();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) pair.first;
                        zzph zzphVar = (zzph) pair.second;
                        if (zzphVar.zza() != zzmf.SGTM_CLIENT) {
                            long zzd = zzj().zzd(str, zzhvVar, zzphVar.zzc(), zzphVar.zzd(), zzphVar.zza(), null);
                            if (zzphVar.zza() == zzmf.GOOGLE_SIGNAL_PENDING && zzd != -1 && !zzhvVar.zzf().isEmpty()) {
                                hashMap.put(zzhvVar.zzf(), Long.valueOf(zzd));
                            }
                        }
                    }
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Pair pair2 = (Pair) it2.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) pair2.first;
                        zzph zzphVar2 = (zzph) pair2.second;
                        if (zzphVar2.zza() == zzmf.SGTM_CLIENT) {
                            zzj().zzd(str, zzhvVar2, zzphVar2.zzc(), zzphVar2.zzd(), zzphVar2.zza(), (Long) hashMap.get(zzhvVar2.zzf()));
                        }
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        Pair pair3 = (Pair) it3.next();
                        com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) pair3.first;
                        zzph zzphVar3 = (zzph) pair3.second;
                        zzj().zzd(str, zzhvVar3, zzphVar3.zzc(), zzphVar3.zzd(), zzphVar3.zza(), null);
                    }
                }
            }
            for (Long l : list2) {
                try {
                    zzj = zzj();
                    longValue = l.longValue();
                    zzj.zzg();
                    zzj.zzav();
                    try {
                    } catch (SQLiteException e) {
                        zzj.zzu.zzaW().zze().zzb("Failed to delete a bundle in a queue table", e);
                        throw e;
                    }
                } catch (SQLiteException e2) {
                    List list3 = this.zzA;
                    if (list3 == null || !list3.contains(l)) {
                        throw e2;
                    }
                }
                if (zzj.zzj().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                }
            }
            zzj().zzS();
            zzj().zzL();
            this.zzA = null;
            if (zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().zzY(str)) {
                zzav(str);
            } else if (zzp().zzd() && zzaN()) {
                zzat();
            } else {
                this.zzB = -1L;
                zzaL();
            }
            this.zza = 0L;
            return;
        } catch (Throwable th2) {
            zzj().zzL();
            throw th2;
        }
        zzhc zzj2 = zzaW().zzj();
        Integer valueOf = Integer.valueOf(i2);
        zzj2.zzc("Network upload successful with code, uploadAttempted", valueOf, Boolean.valueOf(z));
        if (z) {
            try {
                this.zzk.zzd.zzb(zzaU().currentTimeMillis());
            } catch (SQLiteException e3) {
                zzaW().zze().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzaU().elapsedRealtime();
                zzaW().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
        }
        this.zzk.zze.zzb(0L);
        zzaL();
        if (z) {
            zzaW().zzj().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaW().zzj().zza("Purged empty bundles");
        }
        zzj().zzH();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x008c  */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzZ(String str, int i, Throwable th, byte[] bArr, zzpz zzpzVar) {
        zzaX().zzg();
        zzM();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaH();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            ?? substring = str2.substring(0, Math.min(32, str2.length()));
            zzhc zzl = zzaW().zzl();
            Integer valueOf = Integer.valueOf(i);
            if (th == null) {
                th = substring;
            }
            zzl.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            zzj().zzN(Long.valueOf(zzpzVar.zzc()));
            zzaL();
            this.zzv = false;
            zzaH();
        }
        if (th == null) {
            zzj().zzK(Long.valueOf(zzpzVar.zzc()));
            zzaW().zzj().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (zzi().zzx(null, zzgi.zzaM) && zzp().zzd() && zzj().zzY(str)) {
                zzav(str);
            } else {
                zzaL();
            }
            this.zzv = false;
            zzaH();
        }
        String str22 = new String(bArr, StandardCharsets.UTF_8);
        ?? substring2 = str22.substring(0, Math.min(32, str22.length()));
        zzhc zzl2 = zzaW().zzl();
        Integer valueOf2 = Integer.valueOf(i);
        if (th == null) {
        }
        zzl2.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf2, th);
        zzj().zzN(Long.valueOf(zzpzVar.zzc()));
        zzaL();
        this.zzv = false;
        zzaH();
    }

    final long zza() {
        long currentTimeMillis = zzaU().currentTimeMillis();
        zzoa zzoaVar = this.zzk;
        zzoaVar.zzav();
        zzoaVar.zzg();
        zzhp zzhpVar = zzoaVar.zzf;
        long zza = zzhpVar.zza();
        if (zza == 0) {
            zza = zzoaVar.zzu.zzw().zzJ().nextInt(86400000) + 1;
            zzhpVar.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final Context zzaT() {
        return this.zzn.zzaT();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final Clock zzaU() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzaf zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzhe zzaW() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final zzil zzaX() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    final void zzaa(zzh zzhVar, com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        zzaX().zzg();
        zzM();
        com.google.android.gms.internal.measurement.zzhb zzc = com.google.android.gms.internal.measurement.zzhc.zzc();
        byte[] zzaN = zzhVar.zzaN();
        if (zzaN != null) {
            try {
                zzc = (com.google.android.gms.internal.measurement.zzhb) zzqa.zzp(zzc, zzaN);
            } catch (com.google.android.gms.internal.measurement.zzmm unused) {
                zzaW().zzk().zzb("Failed to parse locally stored ad campaign info. appId", zzhe.zzn(zzhVar.zzC()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhm zzhmVar : zzhwVar.zzaM()) {
            if (zzhmVar.zzh().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzqa.zzI(zzhmVar, "gclid", "");
                String str2 = (String) zzqa.zzI(zzhmVar, "gbraid", "");
                String str3 = (String) zzqa.zzI(zzhmVar, "gad_source", "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    long longValue = ((Long) zzqa.zzI(zzhmVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhmVar.zzd();
                    }
                    if ("referrer API v2".equals(zzqa.zzH(zzhmVar, "_cis"))) {
                        if (longValue > zzc.zzb()) {
                            if (str.isEmpty()) {
                                zzc.zzh();
                            } else {
                                zzc.zzp(str);
                            }
                            if (str2.isEmpty()) {
                                zzc.zzg();
                            } else {
                                zzc.zzo(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc.zzf();
                            } else {
                                zzc.zzn(str3);
                            }
                            zzc.zzm(longValue);
                        }
                    } else if (longValue > zzc.zza()) {
                        if (str.isEmpty()) {
                            zzc.zze();
                        } else {
                            zzc.zzk(str);
                        }
                        if (str2.isEmpty()) {
                            zzc.zzd();
                        } else {
                            zzc.zzj(str2);
                        }
                        if (str3.isEmpty()) {
                            zzc.zzc();
                        } else {
                            zzc.zzi(str3);
                        }
                        zzc.zzl(longValue);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzhc) zzc.zzba()).equals(com.google.android.gms.internal.measurement.zzhc.zze())) {
            zzhwVar.zzF((com.google.android.gms.internal.measurement.zzhc) zzc.zzba());
        }
        zzhVar.zzR(((com.google.android.gms.internal.measurement.zzhc) zzc.zzba()).zzcd());
        if (zzhVar.zzaK()) {
            zzj().zzT(zzhVar, false, false);
        }
    }

    final void zzab(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzi().zzx(null, zzgi.zzay)) {
            long currentTimeMillis = zzaU().currentTimeMillis();
            int zzh = zzi().zzh(null, zzgi.zzah);
            zzi();
            long zzF = currentTimeMillis - zzam.zzF();
            while (i < zzh && zzaM(null, zzF)) {
                i++;
            }
        } else {
            zzi();
            long zzH = zzam.zzH();
            while (i < zzH && zzaM(str, 0L)) {
                i++;
            }
        }
        if (zzi().zzx(null, zzgi.zzaz)) {
            zzaX().zzg();
            zzaJ();
        }
        if (zzi().zzx(null, zzgi.zzaQ) && this.zzl.zzd(str, com.google.android.gms.internal.measurement.zzih.zzb(zzrVar.zzG))) {
            zzaW().zzj().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzau(str, zzaU().currentTimeMillis());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x00c6, code lost:
    
        if (true == r12.booleanValue()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00c8, code lost:
    
        r23 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00cd, code lost:
    
        r15 = new com.google.android.gms.measurement.internal.zzqb("_npa", r17, java.lang.Long.valueOf(r23), "auto");
        r24 = 1;
        r12 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x00e0, code lost:
    
        if (r11 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00ea, code lost:
    
        if (r11.zze.equals(r15.zzd) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00ec, code lost:
    
        zzas(r15, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00cb, code lost:
    
        r23 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03dd A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0120 A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x010c A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106 A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0114 A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012d A[Catch: all -> 0x040c, TRY_LEAVE, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0283 A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02ae A[Catch: all -> 0x040c, TRY_LEAVE, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0376 A[Catch: all -> 0x040c, TryCatch #3 {all -> 0x040c, blocks: (B:25:0x009e, B:27:0x00ac, B:31:0x00f9, B:33:0x0106, B:34:0x010f, B:36:0x0114, B:38:0x012d, B:42:0x0141, B:44:0x0165, B:47:0x016d, B:49:0x017c, B:50:0x0257, B:52:0x0283, B:53:0x0286, B:55:0x02ae, B:59:0x0376, B:60:0x0379, B:61:0x03fd, B:66:0x02c3, B:68:0x02e6, B:70:0x02ee, B:72:0x02f6, B:76:0x0309, B:78:0x031a, B:81:0x0326, B:83:0x0334, B:85:0x0359, B:87:0x035f, B:88:0x0367, B:90:0x036d, B:94:0x0345, B:96:0x0312, B:101:0x02d2, B:102:0x018b, B:104:0x01b4, B:105:0x01c3, B:107:0x01ca, B:109:0x01d0, B:111:0x01da, B:113:0x01e4, B:115:0x01ea, B:117:0x01f0, B:119:0x01f5, B:122:0x0213, B:126:0x0218, B:127:0x022c, B:128:0x023a, B:129:0x0248, B:130:0x038f, B:132:0x03c4, B:133:0x03c7, B:134:0x03dd, B:136:0x03e3, B:137:0x0120, B:138:0x010c, B:140:0x00be, B:143:0x00cd, B:145:0x00e2, B:147:0x00ec, B:151:0x00f6), top: B:24:0x009e, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzac(zzr zzrVar) {
        long j;
        long j2;
        zzbd zzs;
        boolean z;
        long zze;
        zzio zzioVar;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j3;
        boolean z2;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        if (zzaQ(zzrVar)) {
            zzh zzl = zzj().zzl(str);
            if (zzl != null && TextUtils.isEmpty(zzl.zzH()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzl.zzab(0L);
                zzj().zzT(zzl, false, false);
                zzr().zzr(str);
            }
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            long j4 = zzrVar.zzl;
            if (j4 == 0) {
                j4 = zzaU().currentTimeMillis();
            }
            long j5 = j4;
            this.zzn.zzg().zzg();
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaW().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzhe.zzn(str), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzH();
            try {
                zzqd zzy = zzj().zzy(str, "_npa");
                Boolean zzaS = zzaS(zzrVar);
                if (zzy != null && !"auto".equals(zzy.zzb)) {
                    j = j5;
                    j2 = 1;
                    if (zzi().zzx(null, zzgi.zzbl)) {
                        zzP(zzrVar, j);
                    } else {
                        zzP(zzrVar, zzrVar.zzF);
                    }
                    zzg(zzrVar);
                    if (i != 0) {
                        zzs = zzj().zzs(str, "_f");
                        z = false;
                    } else {
                        zzs = zzj().zzs(str, "_v");
                        z = true;
                    }
                    if (zzs != null) {
                        long j6 = ((j / 3600000) + j2) * 3600000;
                        if (z) {
                            long j7 = j;
                            zzas(new zzqb("_fvt", j7, Long.valueOf(j6), "auto"), zzrVar);
                            zzaX().zzg();
                            zzM();
                            Bundle bundle = new Bundle();
                            bundle.putLong("_c", 1L);
                            bundle.putLong("_r", 1L);
                            bundle.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                                bundle.putLong("_dac", 1L);
                            }
                            zzU(new zzbh("_v", new zzbf(bundle), "auto", j7), zzrVar);
                        } else {
                            Long valueOf = Long.valueOf(j6);
                            long j8 = j;
                            zzas(new zzqb("_fot", j8, valueOf, "auto"), zzrVar);
                            zzaX().zzg();
                            zzhw zzhwVar = (zzhw) Preconditions.checkNotNull(this.zzm);
                            if (str != null && !str.isEmpty()) {
                                zzio zzioVar2 = zzhwVar.zza;
                                zzioVar2.zzaX().zzg();
                                if (zzhwVar.zza()) {
                                    zzhv zzhvVar = new zzhv(zzhwVar, str);
                                    zzioVar2.zzaX().zzg();
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = zzioVar2.zzaT().getPackageManager();
                                    if (packageManager == null) {
                                        zzioVar2.zzaW().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                                            zzioVar2.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                        } else {
                                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                                            if (resolveInfo.serviceInfo != null) {
                                                String str2 = resolveInfo.serviceInfo.packageName;
                                                if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str2) && zzhwVar.zza()) {
                                                    try {
                                                        zzioVar2.zzaW().zzj().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzioVar2.zzaT(), new Intent(intent), zzhvVar, 1) ? "available" : "not available");
                                                    } catch (RuntimeException e) {
                                                        zzhwVar.zza.zzaW().zze().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                    }
                                                } else {
                                                    zzioVar2.zzaW().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    zzioVar2.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                }
                                zzaX().zzg();
                                zzM();
                                Bundle bundle2 = new Bundle();
                                long j9 = j2;
                                bundle2.putLong("_c", j9);
                                bundle2.putLong("_r", j9);
                                bundle2.putLong("_uwa", 0L);
                                bundle2.putLong("_pfo", 0L);
                                bundle2.putLong("_sys", 0L);
                                bundle2.putLong("_sysu", 0L);
                                bundle2.putLong("_et", j9);
                                if (zzrVar.zzo) {
                                    bundle2.putLong("_dac", j9);
                                }
                                String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                                zzaw zzj = zzj();
                                Preconditions.checkNotEmpty(str3);
                                zzj.zzg();
                                zzj.zzav();
                                zze = zzj.zze(str3, "first_open_count");
                                zzioVar = this.zzn;
                                if (zzioVar.zzaT().getPackageManager() != null) {
                                    zzaW().zze().zzb("PackageManager is null, first open report might be inaccurate. appId", zzhe.zzn(str3));
                                } else {
                                    try {
                                        packageInfo = Wrappers.packageManager(zzioVar.zzaT()).getPackageInfo(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        zzaW().zze().zzc("Package info is null, first open report might be inaccurate. appId", zzhe.zzn(str3), e2);
                                        packageInfo = null;
                                    }
                                    if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                        applicationInfo = null;
                                    } else {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            applicationInfo = null;
                                            if (!zzi().zzx(null, zzgi.zzaH)) {
                                                bundle2.putLong("_uwa", 1L);
                                            } else if (zze == 0) {
                                                bundle2.putLong("_uwa", 1L);
                                                zze = 0;
                                            }
                                            z2 = false;
                                        } else {
                                            applicationInfo = null;
                                            z2 = true;
                                        }
                                        zzas(new zzqb("_fi", j8, Long.valueOf(true != z2 ? 0L : 1L), "auto"), zzrVar);
                                    }
                                    try {
                                        applicationInfo2 = Wrappers.packageManager(this.zzn.zzaT()).getApplicationInfo(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        zzaW().zze().zzc("Application info is null, first open report might be inaccurate. appId", zzhe.zzn(str3), e3);
                                        applicationInfo2 = applicationInfo;
                                    }
                                    if (applicationInfo2 != null) {
                                        if ((applicationInfo2.flags & 1) != 0) {
                                            j3 = 1;
                                            bundle2.putLong("_sys", 1L);
                                        } else {
                                            j3 = 1;
                                        }
                                        if ((applicationInfo2.flags & 128) != 0) {
                                            bundle2.putLong("_sysu", j3);
                                        }
                                    }
                                }
                                if (zze >= 0) {
                                    bundle2.putLong("_pfo", zze);
                                }
                                zzU(new zzbh("_f", new zzbf(bundle2), "auto", j8), zzrVar);
                            }
                            zzhwVar.zza.zzaW().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                            zzaX().zzg();
                            zzM();
                            Bundle bundle22 = new Bundle();
                            long j92 = j2;
                            bundle22.putLong("_c", j92);
                            bundle22.putLong("_r", j92);
                            bundle22.putLong("_uwa", 0L);
                            bundle22.putLong("_pfo", 0L);
                            bundle22.putLong("_sys", 0L);
                            bundle22.putLong("_sysu", 0L);
                            bundle22.putLong("_et", j92);
                            if (zzrVar.zzo) {
                            }
                            String str32 = (String) Preconditions.checkNotNull(zzrVar.zza);
                            zzaw zzj2 = zzj();
                            Preconditions.checkNotEmpty(str32);
                            zzj2.zzg();
                            zzj2.zzav();
                            zze = zzj2.zze(str32, "first_open_count");
                            zzioVar = this.zzn;
                            if (zzioVar.zzaT().getPackageManager() != null) {
                            }
                            if (zze >= 0) {
                            }
                            zzU(new zzbh("_f", new zzbf(bundle22), "auto", j8), zzrVar);
                        }
                    } else {
                        long j10 = j;
                        if (zzrVar.zzi) {
                            zzU(new zzbh("_cd", new zzbf(new Bundle()), "auto", j10), zzrVar);
                        }
                    }
                    zzj().zzS();
                }
                j = j5;
                j2 = 1;
                if (zzy != null) {
                    zzag("_npa", zzrVar);
                }
                if (zzi().zzx(null, zzgi.zzbl)) {
                }
                zzg(zzrVar);
                if (i != 0) {
                }
                if (zzs != null) {
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzad() {
        this.zzs++;
    }

    final void zzae(zzai zzaiVar) {
        zzr zzaD = zzaD((String) Preconditions.checkNotNull(zzaiVar.zza));
        if (zzaD != null) {
            zzaf(zzaiVar, zzaD);
        }
    }

    final void zzaf(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzj().zzH();
            try {
                zzg(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzaiVar.zza);
                zzai zzm = zzj().zzm(str, zzaiVar.zzc.zzb);
                if (zzm != null) {
                    zzaW().zzd().zzc("Removing conditional user property", zzaiVar.zza, this.zzn.zzj().zzf(zzaiVar.zzc.zzb));
                    zzj().zza(str, zzaiVar.zzc.zzb);
                    if (zzm.zze) {
                        zzj().zzP(str, zzaiVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzaiVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzax((zzbh) Preconditions.checkNotNull(zzB().zzC(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzc() : null, zzm.zzb, zzbhVar.zzd, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zzk().zzc("Conditional user property doesn't exist", zzhe.zzn(zzaiVar.zza), this.zzn.zzj().zzf(zzaiVar.zzc.zzb));
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzag(String str, zzr zzrVar) {
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            Boolean zzaS = zzaS(zzrVar);
            if ("_npa".equals(str) && zzaS != null) {
                zzaW().zzd().zza("Falling back to manifest metadata value for ad personalization");
                zzas(new zzqb("_npa", zzaU().currentTimeMillis(), Long.valueOf(true != zzaS.booleanValue() ? 0L : 1L), "auto"), zzrVar);
                return;
            }
            zzhc zzd = zzaW().zzd();
            zzio zzioVar = this.zzn;
            zzd.zzb("Removing user property", zzioVar.zzj().zzf(str));
            zzj().zzH();
            try {
                zzg(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzP((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzP((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzS();
                zzaW().zzd().zzb("User property removed", zzioVar.zzj().zzf(str));
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzah(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzav();
        try {
            SQLiteDatabase zzj2 = zzj.zzj();
            String[] strArr = {str};
            int delete = zzj2.delete("apps", "app_id=?", strArr) + zzj2.delete("events", "app_id=?", strArr) + zzj2.delete("events_snapshot", "app_id=?", strArr) + zzj2.delete("user_attributes", "app_id=?", strArr) + zzj2.delete("conditional_properties", "app_id=?", strArr) + zzj2.delete("raw_events", "app_id=?", strArr) + zzj2.delete("raw_events_metadata", "app_id=?", strArr) + zzj2.delete("queue", "app_id=?", strArr) + zzj2.delete("audience_filter_values", "app_id=?", strArr) + zzj2.delete("main_event_params", "app_id=?", strArr) + zzj2.delete("default_event_params", "app_id=?", strArr) + zzj2.delete("trigger_uris", "app_id=?", strArr) + zzj2.delete("upload_queue", "app_id=?", strArr);
            if (delete > 0) {
                zzj.zzu.zzaW().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzj.zzu.zzaW().zze().zzc("Error resetting analytics data. appId, error", zzhe.zzn(str), e);
        }
        if (zzrVar.zzh) {
            zzac(zzrVar);
        }
    }

    final void zzai(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zze = zzba.zze(zzrVar.zzA);
        zzaW().zzj().zzc("Setting DMA consent for package", str, zze);
        zzaX().zzg();
        zzM();
        zzju zzf = zzba.zzc(zzd(str), 100).zzf();
        this.zzD.put(str, zze);
        zzj().zzU(str, zze);
        zzju zzf2 = zzba.zzc(zzd(str), 100).zzf();
        zzaX().zzg();
        zzM();
        boolean z = zzf == zzju.DENIED && zzf2 == zzju.GRANTED;
        boolean z2 = zzf == zzju.GRANTED && zzf2 == zzju.DENIED;
        if (z || z2) {
            zzaW().zzj().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzo(zza(), str, false, false, false, false, false, false, false).zzf < zzi().zzh(str, zzgi.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzj().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzo(zza(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    public final void zzaj(String str, zzmh zzmhVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzmhVar != null) {
            this.zzH = str;
            this.zzG = zzmhVar;
        }
    }

    final void zzak(zzr zzrVar) {
        zzaX().zzg();
        zzM();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjx zzk = zzjx.zzk(zzrVar.zzu, zzrVar.zzz);
        zzu(str);
        zzaW().zzj().zzc("Setting storage consent for package", str, zzk);
        zzaq(str, zzk);
    }

    final void zzal(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zze().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    protected final void zzam() {
        zzaX().zzg();
        zzj().zzO();
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        if (zzj.zzae() && ((Long) zzgi.zzau.zza(null)).longValue() != 0) {
            SQLiteDatabase zzj2 = zzj.zzj();
            zzio zzioVar = zzj.zzu;
            int delete = zzj2.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzioVar.zzaU().currentTimeMillis()), String.valueOf(zzgi.zzau.zza(null))});
            if (delete > 0) {
                zzioVar.zzaW().zzj().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaU().currentTimeMillis());
        }
        zzaL();
    }

    final void zzan(zzai zzaiVar) {
        zzr zzaD = zzaD((String) Preconditions.checkNotNull(zzaiVar.zza));
        if (zzaD != null) {
            zzao(zzaiVar, zzaD);
        }
    }

    final void zzao(zzai zzaiVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzaiVar);
        Preconditions.checkNotEmpty(zzaiVar.zza);
        Preconditions.checkNotNull(zzaiVar.zzb);
        Preconditions.checkNotNull(zzaiVar.zzc);
        Preconditions.checkNotEmpty(zzaiVar.zzc.zzb);
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzai zzaiVar2 = new zzai(zzaiVar);
            boolean z = false;
            zzaiVar2.zze = false;
            zzj().zzH();
            try {
                zzai zzm = zzj().zzm((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzc.zzb);
                if (zzm != null && !zzm.zzb.equals(zzaiVar2.zzb)) {
                    zzaW().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzb, zzm.zzb);
                }
                if (zzm != null && zzm.zze) {
                    zzaiVar2.zzb = zzm.zzb;
                    zzaiVar2.zzd = zzm.zzd;
                    zzaiVar2.zzh = zzm.zzh;
                    zzaiVar2.zzf = zzm.zzf;
                    zzaiVar2.zzi = zzm.zzi;
                    zzaiVar2.zze = true;
                    zzqb zzqbVar = zzaiVar2.zzc;
                    zzaiVar2.zzc = new zzqb(zzqbVar.zzb, zzm.zzc.zzc, zzqbVar.zza(), zzm.zzc.zzf);
                } else if (TextUtils.isEmpty(zzaiVar2.zzf)) {
                    zzqb zzqbVar2 = zzaiVar2.zzc;
                    zzaiVar2.zzc = new zzqb(zzqbVar2.zzb, zzaiVar2.zzd, zzqbVar2.zza(), zzaiVar2.zzc.zzf);
                    zzaiVar2.zze = true;
                    z = true;
                }
                if (zzaiVar2.zze) {
                    zzqb zzqbVar3 = zzaiVar2.zzc;
                    zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(zzaiVar2.zza), zzaiVar2.zzb, zzqbVar3.zzb, zzqbVar3.zzc, Preconditions.checkNotNull(zzqbVar3.zza()));
                    if (zzj().zzai(zzqdVar)) {
                        zzaW().zzd().zzd("User property updated immediately", zzaiVar2.zza, this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                    } else {
                        zzaW().zze().zzd("(2)Too many active user properties, ignoring", zzhe.zzn(zzaiVar2.zza), this.zzn.zzj().zzf(zzqdVar.zzc), zzqdVar.zze);
                    }
                    if (z && zzaiVar2.zzi != null) {
                        zzax(new zzbh(zzaiVar2.zzi, zzaiVar2.zzd), zzrVar);
                    }
                }
                if (zzj().zzah(zzaiVar2)) {
                    zzaW().zzd().zzd("Conditional property added", zzaiVar2.zza, this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                } else {
                    zzaW().zze().zzd("Too many conditional properties, ignoring", zzhe.zzn(zzaiVar2.zza), this.zzn.zzj().zzf(zzaiVar2.zzc.zzb), zzaiVar2.zzc.zza());
                }
                zzj().zzS();
            } finally {
                zzj().zzL();
            }
        }
    }

    final void zzap(String str, zzag zzagVar) {
        long j;
        zzam zzi = zzi();
        zzgg zzggVar = zzgi.zzaP;
        if (zzi.zzx(null, zzggVar)) {
            zzaX().zzg();
            zzM();
            zzaw zzj = zzj();
            long j2 = zzagVar.zza;
            zzpz zzx = zzj.zzx(j2);
            if (zzx == null) {
                zzaW().zzk().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j2));
                return;
            }
            String zzh = zzx.zzh();
            if (zzagVar.zzb != zzme.SUCCESS.zza()) {
                if (zzagVar.zzb == zzme.BACKOFF.zza()) {
                    Map map = this.zzF;
                    zzpt zzptVar = (zzpt) map.get(zzh);
                    if (zzptVar == null) {
                        zzptVar = new zzpt(this);
                        map.put(zzh, zzptVar);
                    } else {
                        zzptVar.zzb();
                    }
                    j = zzptVar.zzc;
                    zzaW().zzj().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zzh, Long.valueOf((j - zzaU().currentTimeMillis()) / 1000));
                }
                zzaw zzj2 = zzj();
                Long valueOf = Long.valueOf(zzagVar.zza);
                zzj2.zzN(valueOf);
                zzaW().zzj().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf);
                return;
            }
            Map map2 = this.zzF;
            if (map2.containsKey(zzh)) {
                map2.remove(zzh);
            }
            zzaw zzj3 = zzj();
            Long valueOf2 = Long.valueOf(j2);
            zzj3.zzK(valueOf2);
            zzaW().zzj().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf2);
            long j3 = zzagVar.zzc;
            if (j3 > 0) {
                zzaw zzj4 = zzj();
                zzio zzioVar = zzj4.zzu;
                if (zzioVar.zzf().zzx(null, zzggVar)) {
                    zzj4.zzg();
                    zzj4.zzav();
                    Long valueOf3 = Long.valueOf(j3);
                    Preconditions.checkNotNull(valueOf3);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("upload_type", Integer.valueOf(zzmf.GOOGLE_SIGNAL.zza()));
                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar.zzaU().currentTimeMillis()));
                    try {
                        if (zzj4.zzj().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j3), str, String.valueOf(zzmf.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                            zzioVar.zzaW().zzk().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf3);
                        }
                    } catch (SQLiteException e) {
                        zzj4.zzu.zzaW().zze().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j3), e);
                        throw e;
                    }
                }
                zzaW().zzj().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzagVar.zzc));
                zzav(str);
            }
        }
    }

    final void zzaq(String str, zzjx zzjxVar) {
        zzaX().zzg();
        zzM();
        this.zzC.put(str, zzjxVar);
        zzj().zzX(str, zzjxVar);
    }

    final void zzar(String str, boolean z, Long l, Long l2) {
        zzh zzl = zzj().zzl(str);
        if (zzl != null) {
            zzl.zzaF(z);
            zzl.zzaG(l);
            zzl.zzaH(l2);
            if (zzl.zzaK()) {
                zzj().zzT(zzl, false, false);
            }
        }
    }

    final void zzas(zzqb zzqbVar, zzr zzrVar) {
        zzqd zzy;
        long j;
        zzaX().zzg();
        zzM();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzqf zzB = zzB();
            String str = zzqbVar.zzb;
            int zzj = zzB.zzj(str);
            if (zzj != 0) {
                zzqf zzB2 = zzB();
                zzi();
                zzB().zzR(this.zzK, zzrVar.zza, zzj, "_ev", zzB2.zzG(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int zzd = zzB().zzd(str, zzqbVar.zza());
            if (zzd != 0) {
                zzqf zzB3 = zzB();
                zzi();
                String zzG = zzB3.zzG(str, 24, true);
                Object zza = zzqbVar.zza();
                if (zza != null && ((zza instanceof String) || (zza instanceof CharSequence))) {
                    r13 = zza.toString().length();
                }
                zzB().zzR(this.zzK, zzrVar.zza, zzd, "_ev", zzG, r13);
                return;
            }
            Object zzE = zzB().zzE(str, zzqbVar.zza());
            if (zzE != null) {
                if ("_sid".equals(str)) {
                    long j2 = zzqbVar.zzc;
                    String str2 = zzqbVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzqd zzy2 = zzj().zzy(str3, "_sno");
                    if (zzy2 != null) {
                        Object obj = zzy2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzas(new zzqb("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                        }
                    }
                    if (zzy2 != null) {
                        zzaW().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzy2.zze);
                    }
                    zzbd zzs = zzj().zzs(str3, "_s");
                    if (zzs != null) {
                        zzhc zzj2 = zzaW().zzj();
                        long j3 = zzs.zzc;
                        zzj2.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    } else {
                        j = 0;
                    }
                    zzas(new zzqb("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                }
                String str4 = zzrVar.zza;
                zzqd zzqdVar = new zzqd((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzqbVar.zzf), str, zzqbVar.zzc, zzE);
                zzhc zzj3 = zzaW().zzj();
                zzio zzioVar = this.zzn;
                String str5 = zzqdVar.zzc;
                zzj3.zzc("Setting user property", zzioVar.zzj().zzf(str5), zzE);
                zzj().zzH();
                try {
                    if ("_id".equals(str5) && (zzy = zzj().zzy(str4, "_id")) != null && !zzqdVar.zze.equals(zzy.zze)) {
                        zzj().zzP(str4, "_lair");
                    }
                    zzg(zzrVar);
                    boolean zzai = zzj().zzai(zzqdVar);
                    if ("_sid".equals(str)) {
                        long zzd2 = zzA().zzd(zzrVar.zzw);
                        zzh zzl = zzj().zzl(str4);
                        if (zzl != null) {
                            zzl.zzaB(zzd2);
                            if (zzl.zzaK()) {
                                zzj().zzT(zzl, false, false);
                            }
                        }
                    }
                    zzj().zzS();
                    if (!zzai) {
                        zzaW().zze().zzc("Too many unique user properties are set. Ignoring user property", zzioVar.zzj().zzf(str5), zzqdVar.zze);
                        zzB().zzR(this.zzK, str4, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzL();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0128, code lost:
    
        r12.zzB = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0110, code lost:
    
        if (r8 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0125, code lost:
    
        if (r8 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0171, code lost:
    
        if (r0 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0173, code lost:
    
        r0.close();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0198, code lost:
    
        r0 = android.text.TextUtils.isEmpty(r8);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019c, code lost:
    
        if (r0 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019e, code lost:
    
        r0 = zzj().zzl(r8);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a6, code lost:
    
        if (r0 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a8, code lost:
    
        zzO(r0);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017b, code lost:
    
        if (r0 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0195, code lost:
    
        if (r0 != 0) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0195 -> B:60:0x0173). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0195 -> B:61:0x0198). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzat() {
        zzaw zzj;
        long zzF;
        SQLiteException e;
        zzaw zzawVar;
        Cursor cursor;
        zzaX().zzg();
        zzM();
        ?? r0 = 1;
        this.zzw = true;
        try {
            zzio zzioVar = this.zzn;
            zzioVar.zzaV();
            Boolean zzl = zzioVar.zzu().zzl();
            if (zzl == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (zzl.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else {
                zzaX().zzg();
                if (this.zzz != null) {
                    zzaW().zzj().zza("Uploading requested multiple times");
                } else if (zzp().zzd()) {
                    long currentTimeMillis = zzaU().currentTimeMillis();
                    Cursor cursor2 = null;
                    r8 = null;
                    Cursor cursor3 = null;
                    r8 = null;
                    r8 = null;
                    r8 = null;
                    String str = null;
                    int zzh = zzi().zzh(null, zzgi.zzah);
                    zzi();
                    long zzF2 = currentTimeMillis - zzam.zzF();
                    for (int i = 0; i < zzh && zzaM(null, zzF2); i++) {
                    }
                    zzqr.zzb();
                    zzaX().zzg();
                    zzaJ();
                    long zza = this.zzk.zzd.zza();
                    if (zza != 0) {
                        zzaW().zzd().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
                    }
                    String zzA = zzj().zzA();
                    long j = -1;
                    if (TextUtils.isEmpty(zzA)) {
                        try {
                            this.zzB = -1L;
                            zzj = zzj();
                            zzi();
                            zzF = currentTimeMillis - zzam.zzF();
                            zzj.zzg();
                            zzj.zzav();
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = r0;
                        }
                        try {
                            r0 = zzj.zzj().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzF)});
                            try {
                                if (r0.moveToFirst()) {
                                    str = r0.getString(0);
                                    cursor = r0;
                                    zzawVar = zzj;
                                    zzj = zzj;
                                } else {
                                    zzj.zzu.zzaW().zzj().zza("No expired configs for apps with pending events");
                                    cursor = r0;
                                    zzawVar = zzj;
                                    zzj = zzj;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                zzhc zze = zzj.zzu.zzaW().zze();
                                ?? r4 = "Error selecting expired configs";
                                zze.zzb("Error selecting expired configs", e);
                                cursor = r0;
                                zzawVar = r4;
                                zzj = r4;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            r0 = 0;
                            zzhc zze2 = zzj.zzu.zzaW().zze();
                            ?? r42 = "Error selecting expired configs";
                            zze2.zzb("Error selecting expired configs", e);
                            cursor = r0;
                            zzawVar = r42;
                            zzj = r42;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } else {
                        if (this.zzB == -1) {
                            zzaw zzj2 = zzj();
                            try {
                                try {
                                    cursor3 = zzj2.zzj().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if (cursor3.moveToFirst()) {
                                        j = cursor3.getLong(0);
                                    }
                                } catch (SQLiteException e4) {
                                    zzj2.zzu.zzaW().zze().zzb("Error querying raw events", e4);
                                }
                            } finally {
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                            }
                        }
                        zzau(zzA, currentTimeMillis);
                    }
                } else {
                    zzaW().zzj().zza("Network not connected, ignoring upload request");
                    zzaL();
                }
            }
        } finally {
            this.zzw = false;
            zzaH();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0071, code lost:
    
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x022d, code lost:
    
        if (r11 == null) goto L107;
     */
    /* JADX WARN: Removed duplicated region for block: B:182:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x070c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzau(String str, long j) {
        Cursor cursor;
        Cursor cursor2;
        List emptyList;
        boolean z;
        com.google.android.gms.internal.measurement.zzhv zzhvVar;
        String str2;
        zzph zzphVar;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        com.google.android.gms.internal.measurement.zzim zzb2;
        String str3;
        Cursor cursor3;
        byte[] blob;
        zzqa zzA;
        long j2;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        long j3;
        long j4;
        int zzh = zzi().zzh(str, zzgi.zzg);
        int i2 = 0;
        int max = Math.max(0, zzi().zzh(str, zzgi.zzh));
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzav();
        int i3 = 1;
        Preconditions.checkArgument(zzh > 0);
        Preconditions.checkArgument(max > 0);
        Preconditions.checkNotEmpty(str);
        try {
            cursor2 = zzj.zzj().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzh));
            try {
                if (cursor2.moveToFirst()) {
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    while (true) {
                        long j5 = cursor2.getLong(i2);
                        try {
                            blob = cursor2.getBlob(i3);
                            zzA = zzj.zzg.zzA();
                        } catch (IOException e) {
                            e = e;
                            cursor3 = cursor2;
                        }
                        try {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                cursor3 = cursor2;
                                try {
                                    try {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                        cursor2 = cursor3;
                                    } catch (IOException e2) {
                                        e = e2;
                                        try {
                                            zzA.zzu.zzaW().zze().zzb("Failed to ungzip content", e);
                                            throw e;
                                        } catch (IOException e3) {
                                            e = e3;
                                            zzj.zzu.zzaW().zze().zzc("Failed to unzip queued bundle. appId", zzhe.zzn(str), e);
                                            if (cursor3.moveToNext()) {
                                                break;
                                            }
                                            cursor2 = cursor3;
                                            i2 = 0;
                                            i3 = 1;
                                            if (cursor3 != null) {
                                            }
                                            emptyList = arrayList;
                                            if (emptyList.isEmpty()) {
                                            }
                                        }
                                    }
                                } catch (SQLiteException e4) {
                                    e = e4;
                                    cursor2 = cursor3;
                                    try {
                                        zzj.zzu.zzaW().zze().zzc("Error querying bundles. appId", zzhe.zzn(str), e);
                                        emptyList = Collections.emptyList();
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor = cursor3;
                                    if (cursor != null) {
                                    }
                                    throw th;
                                }
                            }
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!arrayList.isEmpty() && byteArray.length + i4 > max) {
                                break;
                            }
                            try {
                                com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), byteArray);
                                if (!arrayList.isEmpty()) {
                                    com.google.android.gms.internal.measurement.zzhx zzhxVar2 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) arrayList.get(0)).first;
                                    com.google.android.gms.internal.measurement.zzhx zzhxVar3 = (com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba();
                                    if (!zzhxVar2.zzK().equals(zzhxVar3.zzK()) || !zzhxVar2.zzJ().equals(zzhxVar3.zzJ()) || zzhxVar2.zzbu() != zzhxVar3.zzbu() || !zzhxVar2.zzL().equals(zzhxVar3.zzL())) {
                                        break;
                                    }
                                    Iterator it = zzhxVar2.zzY().iterator();
                                    while (true) {
                                        Iterator it2 = it;
                                        j2 = -1;
                                        if (!it.hasNext()) {
                                            zzhxVar = zzhxVar3;
                                            j3 = -1;
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzio zzioVar = (com.google.android.gms.internal.measurement.zzio) it2.next();
                                        zzhxVar = zzhxVar3;
                                        if ("_npa".equals(zzioVar.zzg())) {
                                            j3 = zzioVar.zzc();
                                            break;
                                        } else {
                                            it = it2;
                                            zzhxVar3 = zzhxVar;
                                        }
                                    }
                                    Iterator it3 = zzhxVar.zzY().iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            j4 = j3;
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzio zzioVar2 = (com.google.android.gms.internal.measurement.zzio) it3.next();
                                        j4 = j3;
                                        if ("_npa".equals(zzioVar2.zzg())) {
                                            j2 = zzioVar2.zzc();
                                            break;
                                        }
                                        j3 = j4;
                                    }
                                    if (j4 != j2) {
                                        break;
                                    }
                                }
                                if (!cursor2.isNull(2)) {
                                    zzhwVar.zzat(cursor2.getInt(2));
                                }
                                i4 += byteArray.length;
                                arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba(), Long.valueOf(j5)));
                            } catch (IOException e5) {
                                zzj.zzu.zzaW().zze().zzc("Failed to merge queued bundle. appId", zzhe.zzn(str), e5);
                            }
                            cursor3 = cursor2;
                            if (cursor3.moveToNext() || i4 > max) {
                                break;
                                break;
                            } else {
                                cursor2 = cursor3;
                                i2 = 0;
                                i3 = 1;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            cursor3 = cursor2;
                        }
                    }
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    emptyList = arrayList;
                } else {
                    emptyList = Collections.emptyList();
                }
            } catch (SQLiteException e7) {
                e = e7;
                cursor3 = cursor2;
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor2;
            }
        } catch (SQLiteException e8) {
            e = e8;
            cursor2 = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        if (emptyList.isEmpty()) {
            if (zzu(str).zzr(zzjw.AD_STORAGE)) {
                Iterator it4 = emptyList.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        str3 = null;
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzhx zzhxVar4 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) it4.next()).first;
                    if (!zzhxVar4.zzT().isEmpty()) {
                        str3 = zzhxVar4.zzT();
                        break;
                    }
                }
                if (str3 != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= emptyList.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhx zzhxVar5 = (com.google.android.gms.internal.measurement.zzhx) ((Pair) emptyList.get(i5)).first;
                        if (!zzhxVar5.zzT().isEmpty() && !zzhxVar5.zzT().equals(str3)) {
                            emptyList = emptyList.subList(0, i5);
                            break;
                        }
                        i5++;
                    }
                }
            }
            com.google.android.gms.internal.measurement.zzht zzb3 = com.google.android.gms.internal.measurement.zzhv.zzb();
            int size = emptyList.size();
            List arrayList2 = new ArrayList(emptyList.size());
            boolean z5 = zzi().zzy(str) && zzu(str).zzr(zzjw.AD_STORAGE);
            boolean zzr = zzu(str).zzr(zzjw.AD_STORAGE);
            boolean zzr2 = zzu(str).zzr(zzjw.ANALYTICS_STORAGE);
            zzrd.zzb();
            boolean zzx = zzi().zzx(str, zzgi.zzaL);
            zzpi zzpiVar = this.zzl;
            zzph zza = zzpiVar.zza(str);
            int i6 = 0;
            while (i6 < size) {
                com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) ((com.google.android.gms.internal.measurement.zzhx) ((Pair) emptyList.get(i6)).first).zzch();
                List list = emptyList;
                arrayList2.add((Long) ((Pair) emptyList.get(i6)).second);
                zzi().zzj();
                boolean z6 = z5;
                boolean z7 = zzr;
                zzhwVar2.zzaB(119002L);
                zzhwVar2.zzaA(j);
                this.zzn.zzaV();
                zzhwVar2.zzau(false);
                if (!z6) {
                    zzhwVar2.zzt();
                }
                if (!z7) {
                    zzhwVar2.zzz();
                    zzhwVar2.zzw();
                }
                if (!zzr2) {
                    zzhwVar2.zzq();
                }
                zzN(str, zzhwVar2);
                if (!zzx) {
                    zzhwVar2.zzA();
                }
                if (!zzr2) {
                    zzhwVar2.zzr();
                }
                String zzaL = zzhwVar2.zzaL();
                if (TextUtils.isEmpty(zzaL) || zzaL.equals("00000000-0000-0000-0000-000000000000")) {
                    ArrayList arrayList3 = new ArrayList(zzhwVar2.zzaM());
                    Iterator it5 = arrayList3.iterator();
                    z2 = z6;
                    i = size;
                    Long l = null;
                    Long l2 = null;
                    boolean z8 = false;
                    boolean z9 = false;
                    while (it5.hasNext()) {
                        Iterator it6 = it5;
                        com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it5.next();
                        boolean z10 = zzr2;
                        boolean z11 = zzx;
                        if ("_fx".equals(zzhmVar.zzh())) {
                            it6.remove();
                            zzr2 = z10;
                            it5 = it6;
                            zzx = z11;
                            z8 = true;
                        } else if ("_f".equals(zzhmVar.zzh())) {
                            zzA();
                            com.google.android.gms.internal.measurement.zzhq zzG = zzqa.zzG(zzhmVar, "_pfo");
                            if (zzG != null) {
                                l = Long.valueOf(zzG.zzd());
                            }
                            zzA();
                            com.google.android.gms.internal.measurement.zzhq zzG2 = zzqa.zzG(zzhmVar, "_uwa");
                            if (zzG2 != null) {
                                l2 = Long.valueOf(zzG2.zzd());
                            }
                            zzr2 = z10;
                            it5 = it6;
                            zzx = z11;
                        } else {
                            zzr2 = z10;
                            it5 = it6;
                            zzx = z11;
                        }
                        z9 = true;
                    }
                    z3 = zzr2;
                    z4 = zzx;
                    if (z8) {
                        zzhwVar2.zzu();
                        zzhwVar2.zzj(arrayList3);
                    }
                    if (z9) {
                        zzar(zzhwVar2.zzaF(), true, l, l2);
                    }
                } else {
                    z2 = z6;
                    i = size;
                    z3 = zzr2;
                    z4 = zzx;
                }
                if (zzhwVar2.zzc() != 0) {
                    if (zzi().zzx(str, zzgi.zzaB)) {
                        zzhwVar2.zzQ(zzA().zzf(((com.google.android.gms.internal.measurement.zzhx) zzhwVar2.zzba()).zzcd()));
                    }
                    if (zzi().zzx(null, zzgi.zzaP) && (zzb2 = zza.zzb()) != null) {
                        zzhwVar2.zzaw(zzb2);
                    }
                    zzb3.zzc(zzhwVar2);
                }
                i6++;
                zzr = z7;
                emptyList = list;
                z5 = z2;
                size = i;
                zzr2 = z3;
                zzx = z4;
            }
            if (zzb3.zza() == 0) {
                zzal(arrayList2);
                zzY(false, 204, null, null, str, Collections.emptyList());
                return;
            }
            com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
            List arrayList4 = new ArrayList();
            boolean z12 = zzi().zzx(null, zzgi.zzaP) && zza.zza() == zzmf.SGTM_CLIENT;
            if (zza.zza() == zzmf.SGTM) {
                z = z12;
            } else {
                if (!z12) {
                    zzhvVar = zzhvVar2;
                    if (zzi().zzx(null, zzgi.zzaO) || zzp().zzd()) {
                        Object zzq = !Log.isLoggable(zzaW().zzr(), 2) ? zzA().zzq(zzhvVar) : null;
                        zzA();
                        byte[] zzcd = zzhvVar.zzcd();
                        zzal(arrayList2);
                        this.zzk.zze.zzb(j);
                        zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzq);
                        this.zzv = true;
                        zzp().zzc(str, zza, zzhvVar, new zzpl(this, str, arrayList4));
                    }
                    return;
                }
                z = true;
            }
            Iterator it7 = ((com.google.android.gms.internal.measurement.zzhv) zzb3.zzba()).zzh().iterator();
            while (true) {
                if (it7.hasNext()) {
                    if (((com.google.android.gms.internal.measurement.zzhx) it7.next()).zzbI()) {
                        str2 = UUID.randomUUID().toString();
                        break;
                    }
                } else {
                    str2 = null;
                    break;
                }
            }
            com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
            zzaX().zzg();
            zzM();
            com.google.android.gms.internal.measurement.zzht zzc = com.google.android.gms.internal.measurement.zzhv.zzc(zzhvVar3);
            if (!TextUtils.isEmpty(str2)) {
                zzc.zzf(str2);
            }
            String zzm = zzr().zzm(str);
            if (!TextUtils.isEmpty(zzm)) {
                zzc.zzg(zzm);
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it8 = zzhvVar3.zzh().iterator();
            while (it8.hasNext()) {
                com.google.android.gms.internal.measurement.zzhw zzA2 = com.google.android.gms.internal.measurement.zzhx.zzA((com.google.android.gms.internal.measurement.zzhx) it8.next());
                zzA2.zzt();
                arrayList5.add((com.google.android.gms.internal.measurement.zzhx) zzA2.zzba());
            }
            zzc.zzd();
            zzc.zzb(arrayList5);
            zzam zzi = zzi();
            zzgg zzggVar = zzgi.zzaN;
            if (zzi.zzx(null, zzggVar)) {
                zzaW().zzj().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(str2) ? "null" : zzc.zzi());
            } else {
                zzaW().zzj().zza("[sgtm] Processed MeasurementBatch for sGTM.");
            }
            zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzc.zzba();
            if (!TextUtils.isEmpty(str2) && zzi().zzx(null, zzggVar)) {
                com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzb3.zzba();
                zzaX().zzg();
                zzM();
                com.google.android.gms.internal.measurement.zzht zzb4 = com.google.android.gms.internal.measurement.zzhv.zzb();
                zzaW().zzj().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", str2);
                zzb4.zzf(str2);
                for (com.google.android.gms.internal.measurement.zzhx zzhxVar6 : zzhvVar4.zzh()) {
                    com.google.android.gms.internal.measurement.zzhw zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                    zzz.zzY(zzhxVar6.zzN());
                    zzz.zzV(zzhxVar6.zzd());
                    zzb4.zzc(zzz);
                }
                com.google.android.gms.internal.measurement.zzhv zzhvVar5 = (com.google.android.gms.internal.measurement.zzhv) zzb4.zzba();
                String zzm2 = zzpiVar.zzg.zzr().zzm(str);
                if (TextUtils.isEmpty(zzm2)) {
                    zzphVar = new zzph((String) zzgi.zzr.zza(null), Collections.emptyMap(), z ? zzmf.GOOGLE_SIGNAL_PENDING : zzmf.GOOGLE_SIGNAL, null);
                } else {
                    Uri parse = Uri.parse((String) zzgi.zzr.zza(null));
                    Uri.Builder buildUpon = parse.buildUpon();
                    buildUpon.authority(zzm2 + "." + parse.getAuthority());
                    zzphVar = new zzph(buildUpon.build().toString(), Collections.emptyMap(), z ? zzmf.GOOGLE_SIGNAL_PENDING : zzmf.GOOGLE_SIGNAL, null);
                }
                arrayList4.add(Pair.create(zzhvVar5, zzphVar));
            }
            if (z) {
                com.google.android.gms.internal.measurement.zzht zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzhvVar.zzch();
                for (int i7 = 0; i7 < zzhvVar.zza(); i7++) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVar3 = (com.google.android.gms.internal.measurement.zzhw) zzhvVar.zze(i7).zzch();
                    zzhwVar3.zzC();
                    zzhwVar3.zzO(j);
                    zzhtVar.zze(i7, zzhwVar3);
                }
                arrayList4.add(Pair.create((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba(), zza));
                zzal(arrayList2);
                zzY(false, 204, null, null, str, arrayList4);
                if (zzay(str, zza.zzc())) {
                    zzaW().zzj().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                    intent.setPackage(str);
                    zzaK(this.zzn.zzaT(), intent);
                    return;
                }
                return;
            }
            if (zzi().zzx(null, zzgi.zzaO)) {
            }
            if (!Log.isLoggable(zzaW().zzr(), 2)) {
            }
            zzA();
            byte[] zzcd2 = zzhvVar.zzcd();
            zzal(arrayList2);
            this.zzk.zze.zzb(j);
            zzaW().zzj().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd2.length), zzq);
            this.zzv = true;
            zzp().zzc(str, zza, zzhvVar, new zzpl(this, str, arrayList4));
        }
    }

    final void zzav(String str) {
        com.google.android.gms.internal.measurement.zzhv zzg;
        zzaX().zzg();
        zzM();
        this.zzw = true;
        try {
            zzio zzioVar = this.zzn;
            zzioVar.zzaV();
            Boolean zzl = zzioVar.zzu().zzl();
            if (zzl == null) {
                zzaW().zzk().zza("Upload data called on the client side before use of service was decided");
            } else if (zzl.booleanValue()) {
                zzaW().zze().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else if (!zzp().zzd()) {
                zzaW().zzj().zza("Network not connected, ignoring upload request");
                zzaL();
            } else if (zzj().zzY(str)) {
                zzpz zzw = zzj().zzw(str);
                if (zzw != null && (zzg = zzw.zzg()) != null) {
                    zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzw.zzd(), zzw.zzh());
                    byte[] zzcd = zzg.zzcd();
                    if (Log.isLoggable(zzaW().zzr(), 2)) {
                        zzaW().zzj().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzA().zzq(zzg));
                    }
                    this.zzv = true;
                    zzp().zzc(str, zzw.zzf(), zzg, new zzpm(this, str, zzw));
                }
            } else {
                zzaW().zzj().zzb("[sgtm] Upload queue has no batches for appId", str);
            }
        } finally {
            this.zzw = false;
            zzaH();
        }
    }

    final void zzaw(String str, com.google.android.gms.internal.measurement.zzhp zzhpVar, Bundle bundle, String str2) {
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        long zzd = (zzqf.zzap(zzhpVar.zzl()) || zzqf.zzap(str)) ? zzi().zzd(str2, true) : zzi().zzc(str2, true);
        long codePointCount = zzhpVar.zzm().codePointCount(0, zzhpVar.zzm().length());
        zzqf zzB = zzB();
        String zzl = zzhpVar.zzl();
        zzi();
        String zzG = zzB.zzG(zzl, 40, true);
        if (codePointCount <= zzd || listOf.contains(zzhpVar.zzl())) {
            return;
        }
        if ("_ev".equals(zzhpVar.zzl())) {
            bundle.putString("_ev", zzB().zzG(zzhpVar.zzm(), zzi().zzd(str2, true), true));
            return;
        }
        zzaW().zzl().zzc("Param value is too long; discarded. Name, value length", zzG, Long.valueOf(codePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", zzG);
                bundle.putLong("_el", codePointCount);
            }
        }
        bundle.remove(zzhpVar.zzl());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:371|(10:376|377|378|(1:380)|59|(0)(0)|62|(0)(0)|68|69)|381|382|383|384|385|386|387|377|378|(0)|59|(0)(0)|62|(0)(0)|68|69) */
    /* JADX WARN: Can't wrap try/catch for region: R(56:(2:71|(3:73|(1:75)|76))|77|(2:79|(3:81|(1:83)|84))|85|86|(1:88)|89|(2:93|(1:95))|96|(2:106|107)|110|(6:111|112|113|114|115|116)|117|(1:119)|120|(2:122|(2:126|127)(1:125))(1:337)|128|(1:130)|131|(1:133)|134|(1:136)|137|(1:139)|140|(1:142)|143|(1:145)|146|(2:148|(1:150))|151|(6:155|(1:159)|160|(1:162)(1:195)|163|(1:165)(15:166|(1:168)(1:194)|169|(1:171)(1:193)|172|(1:174)(1:192)|175|(1:177)(1:191)|178|(1:180)(1:190)|181|(1:183)(1:189)|184|(1:186)(1:188)|187))|196|(1:198)|199|(1:201)(1:336)|(4:206|(4:209|(3:211|212|(3:214|215|(3:217|218|220)(1:327))(1:329))(1:333)|328|207)|334|221)|335|(1:224)|225|(1:227)|228|(13:(2:232|(4:234|(1:236)|237|(29:245|(1:247)(1:325)|248|(1:250)|251|252|(2:254|(1:256))|257|(3:259|(1:261)|262)(1:324)|263|(1:267)|268|(1:270)|271|(4:274|(2:280|281)|282|272)|286|287|288|289|290|(2:291|(2:293|(1:295)(1:310))(3:311|312|(1:317)(1:316)))|296|297|298|299|(1:301)(2:306|307)|302|303|304)))|288|289|290|(3:291|(0)(0)|310)|296|297|298|299|(0)(0)|302|303|304)|326|252|(0)|257|(0)(0)|263|(2:265|267)|268|(0)|271|(1:272)|286|287) */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x07e1, code lost:
    
        if (r10.isEmpty() == false) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0b54, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0b55, code lost:
    
        zzaW().zze().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r9.zzaF()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x029a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x029f, code lost:
    
        r9.zzu.zzaW().zze().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r10), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x029c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x029d, code lost:
    
        r21 = 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x051d A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0553 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0607 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0612 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x061d A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0628 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0634 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0645 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x066f A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x06bd A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x072c A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0755 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0787 A[Catch: all -> 0x0b9b, TRY_LEAVE, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x07e6 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x07f5 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x082c A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x08ea A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0900 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0967 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0988 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x09a4 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0a62 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0b0b A[Catch: SQLiteException -> 0x0b24, all -> 0x0b9b, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0b24, blocks: (B:299:0x0afb, B:301:0x0b0b), top: B:298:0x0afb, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0b1f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0a71 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x075a A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x05c2 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0321 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x019f A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x020a A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x02d4 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x01fa A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0384 A[Catch: all -> 0x0b9b, TryCatch #6 {all -> 0x0b9b, blocks: (B:43:0x0155, B:46:0x0166, B:48:0x016e, B:52:0x0178, B:59:0x030b, B:62:0x0343, B:64:0x0384, B:66:0x0389, B:67:0x03a0, B:71:0x03ab, B:73:0x03c3, B:75:0x03c8, B:76:0x03df, B:79:0x03fd, B:83:0x041f, B:84:0x0436, B:85:0x043f, B:88:0x045c, B:89:0x0470, B:91:0x0478, B:93:0x0484, B:95:0x048a, B:96:0x0491, B:98:0x049d, B:100:0x04a5, B:102:0x04ad, B:104:0x04b3, B:107:0x04b7, B:110:0x04c3, B:112:0x04d0, B:115:0x04f9, B:119:0x051d, B:120:0x0532, B:122:0x0553, B:125:0x056a, B:127:0x05a7, B:128:0x05d0, B:130:0x0607, B:131:0x060a, B:133:0x0612, B:134:0x0615, B:136:0x061d, B:137:0x0620, B:139:0x0628, B:140:0x062b, B:142:0x0634, B:143:0x0638, B:145:0x0645, B:146:0x0648, B:148:0x066f, B:150:0x0677, B:151:0x067a, B:153:0x0689, B:155:0x0693, B:159:0x06a8, B:163:0x06b4, B:166:0x06bd, B:169:0x06ca, B:172:0x06d8, B:175:0x06e6, B:178:0x06f4, B:181:0x0702, B:184:0x070d, B:187:0x071a, B:196:0x0726, B:198:0x072c, B:199:0x072f, B:201:0x0755, B:203:0x0760, B:206:0x0768, B:207:0x0781, B:209:0x0787, B:212:0x079b, B:215:0x07a7, B:218:0x07b4, B:331:0x07cd, B:221:0x07dd, B:224:0x07e6, B:225:0x07e9, B:227:0x07f5, B:228:0x07fa, B:230:0x0818, B:232:0x081c, B:234:0x082c, B:236:0x0837, B:237:0x0842, B:239:0x084c, B:241:0x0858, B:243:0x0862, B:245:0x0868, B:247:0x0877, B:248:0x0891, B:250:0x0897, B:251:0x08a0, B:252:0x08ae, B:254:0x08ea, B:256:0x08f3, B:257:0x08f6, B:259:0x0900, B:261:0x091c, B:262:0x0927, B:263:0x095f, B:265:0x0967, B:267:0x0971, B:268:0x097e, B:270:0x0988, B:271:0x0995, B:272:0x099e, B:274:0x09a4, B:276:0x09e0, B:278:0x09ea, B:280:0x09fc, B:287:0x0a02, B:289:0x0a47, B:290:0x0a51, B:291:0x0a5c, B:293:0x0a62, B:297:0x0ab0, B:299:0x0afb, B:301:0x0b0b, B:302:0x0b6a, B:307:0x0b21, B:309:0x0b25, B:312:0x0a71, B:314:0x0a9d, B:320:0x0b3c, B:321:0x0b53, B:323:0x0b55, B:336:0x075a, B:337:0x05c2, B:340:0x0504, B:344:0x0321, B:345:0x0328, B:347:0x032e, B:350:0x033d, B:355:0x0195, B:357:0x019f, B:359:0x01b4, B:364:0x01d0, B:367:0x0204, B:369:0x020a, B:371:0x0218, B:373:0x022c, B:376:0x0233, B:378:0x02ca, B:380:0x02d4, B:381:0x0261, B:383:0x0281, B:386:0x028a, B:387:0x02b2, B:390:0x029f, B:395:0x01dc, B:397:0x01fa), top: B:42:0x0155, inners: #1, #3, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03a9  */
    /* JADX WARN: Type inference failed for: r22v7, types: [java.lang.CharSequence, java.lang.Long, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzax(zzbh zzbhVar, zzr zzrVar) {
        boolean z;
        String zzg;
        String str;
        long longValue;
        String str2;
        zzbh zzbhVar2;
        Object obj;
        int i;
        int i2;
        zzqd zzqdVar;
        zzqd zzqdVar2;
        zzbf zzbfVar;
        long j;
        long zzH;
        String str3;
        long j2;
        zzbd zzs;
        zzbc zzbcVar;
        zzbd zzbdVar;
        String str4;
        com.google.android.gms.internal.measurement.zzhw zzz;
        String str5;
        String str6;
        String str7;
        long j3;
        String str8;
        zzjx zzl;
        long j4;
        Map emptyMap;
        ArrayList arrayList;
        String str9;
        zzjx zzl2;
        zzjw zzjwVar;
        String str10;
        zzjw zzjwVar2;
        zzio zzioVar;
        zzh zzl3;
        int i3;
        List zzE;
        int i4;
        zzaw zzj;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        zzaw zzj2;
        zzbe zzbeVar;
        int i5;
        ContentValues contentValues;
        Pair zzd;
        zzh zzl4;
        zzh zzhVar;
        long j5;
        Object obj2;
        zzqd zzy;
        Preconditions.checkNotNull(zzrVar);
        String str11 = zzrVar.zza;
        Preconditions.checkNotEmpty(str11);
        long nanoTime = System.nanoTime();
        zzaX().zzg();
        zzM();
        zzA();
        if (zzqa.zzE(zzbhVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzg(zzrVar);
                return;
            }
            zzif zzr = zzr();
            String str12 = zzbhVar.zza;
            if (zzr.zzx(str11, str12)) {
                zzaW().zzk().zzc("Dropping blocked event. appId", zzhe.zzn(str11), this.zzn.zzj().zzd(str12));
                if (!zzr().zzt(str11) && !zzr().zzy(str11)) {
                    if ("_err".equals(str12)) {
                        return;
                    }
                    zzB().zzR(this.zzK, str11, 11, "_ev", str12, 0);
                    return;
                }
                zzh zzl5 = zzj().zzl(str11);
                if (zzl5 != null) {
                    long abs = Math.abs(zzaU().currentTimeMillis() - Math.max(zzl5.zzp(), zzl5.zzg()));
                    zzi();
                    if (abs > ((Long) zzgi.zzM.zza(null)).longValue()) {
                        zzaW().zzd().zza("Fetching config for blocked app");
                        zzO(zzl5);
                        return;
                    }
                    return;
                }
                return;
            }
            zzhf zzb2 = zzhf.zzb(zzbhVar);
            zzB().zzQ(zzb2, zzi().zzf(str11));
            int zzi = zzi().zzi(str11, zzgi.zzaf, 10, 35);
            Bundle bundle = zzb2.zzd;
            for (String str13 : new TreeSet(bundle.keySet())) {
                if (FirebaseAnalytics.Param.ITEMS.equals(str13)) {
                    zzB().zzP(bundle.getParcelableArray(str13), zzi);
                }
            }
            zzbh zza = zzb2.zza();
            if (Log.isLoggable(zzaW().zzr(), 2)) {
                zzaW().zzj().zzb("Logging event", this.zzn.zzj().zzc(zza));
            }
            zzj().zzH();
            try {
                zzg(zzrVar);
                String str14 = zza.zza;
                if (!"ecommerce_purchase".equals(str14) && !FirebaseAnalytics.Event.PURCHASE.equals(str14) && !FirebaseAnalytics.Event.REFUND.equals(str14)) {
                    z = false;
                    if (!"_iap".equals(str14)) {
                        if (!z) {
                            str2 = MBridgeConstans.APP_ID;
                            zzbhVar2 = zza;
                            i = 2;
                            str = "_err";
                            obj = null;
                            i2 = 1;
                            String str15 = zzbhVar2.zza;
                            boolean zzaq = zzqf.zzaq(str15);
                            boolean equals = str.equals(str15);
                            zzB();
                            zzbfVar = zzbhVar2.zzb;
                            if (zzbfVar != null) {
                                j = 0;
                            } else {
                                zzbe zzbeVar2 = new zzbe(zzbfVar);
                                j = 0;
                                while (zzbeVar2.hasNext()) {
                                    String next = zzbeVar2.next();
                                    String str16 = next;
                                    if (zzbfVar.zzf(next) instanceof Parcelable[]) {
                                        j += ((Parcelable[]) r11).length;
                                    }
                                }
                            }
                            String str17 = str11;
                            ?? r22 = obj;
                            int i6 = i2;
                            zzas zzp = zzj().zzp(zza(), str17, j + 1, true, zzaq, false, equals, false, false, false);
                            long j6 = zzp.zzb;
                            zzi();
                            zzH = j6 - zzam.zzH();
                            if (zzH <= 0) {
                                if (zzH % 1000 == 1) {
                                    zzaW().zze().zzc("Data loss. Too many events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzp.zzb));
                                }
                                zzj().zzS();
                            } else {
                                if (zzaq) {
                                    long j7 = zzp.zza;
                                    zzi();
                                    long intValue = j7 - ((Integer) zzgi.zzm.zza(r22)).intValue();
                                    if (intValue > 0) {
                                        if (intValue % 1000 == 1) {
                                            zzaW().zze().zzc("Data loss. Too many public events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzp.zza));
                                        }
                                        zzB().zzR(this.zzK, str17, 16, "_ev", zzbhVar2.zza, 0);
                                        zzj().zzS();
                                    }
                                }
                                if (equals) {
                                    long max = zzp.zzd - Math.max(0, Math.min(1000000, zzi().zzh(zzrVar.zza, zzgi.zzl)));
                                    if (max > 0) {
                                        if (max == 1) {
                                            zzaW().zze().zzc("Too many error events logged. appId, count", zzhe.zzn(str17), Long.valueOf(zzp.zzd));
                                        }
                                        zzj().zzS();
                                    }
                                }
                                Bundle zzc = zzbfVar.zzc();
                                zzqf zzB = zzB();
                                String str18 = zzbhVar2.zzc;
                                zzB.zzS(zzc, "_o", str18);
                                if (zzB().zzak(str17, zzrVar.zzD)) {
                                    zzB().zzS(zzc, "_dbg", 1L);
                                    zzB().zzS(zzc, "_r", 1L);
                                }
                                if ("_s".equals(str15) && (zzy = zzj().zzy(zzrVar.zza, "_sno")) != null) {
                                    Object obj3 = zzy.zze;
                                    if (obj3 instanceof Long) {
                                        zzB().zzS(zzc, "_sno", obj3);
                                    }
                                }
                                if (zzi().zzx(r22, zzgi.zzbg) && Objects.equals(str18, "am") && Objects.equals(str15, "_ai") && (obj2 = zzc.get("value")) != null && (obj2 instanceof String)) {
                                    try {
                                        double parseDouble = Double.parseDouble((String) obj2);
                                        zzc.remove("value");
                                        zzc.putDouble("value", parseDouble);
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                zzaw zzj3 = zzj();
                                Preconditions.checkNotEmpty(str17);
                                zzj3.zzg();
                                zzj3.zzav();
                                try {
                                    SQLiteDatabase zzj4 = zzj3.zzj();
                                    String valueOf = String.valueOf(Math.max(0, Math.min(1000000, zzj3.zzu.zzf().zzh(str17, zzgi.zzp))));
                                    String[] strArr = new String[i];
                                    strArr[0] = str17;
                                    strArr[i6] = valueOf;
                                    str3 = "raw_events";
                                    try {
                                        j2 = zzj4.delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", strArr);
                                    } catch (SQLiteException e) {
                                        e = e;
                                        zzj3.zzu.zzaW().zze().zzc("Error deleting over the limit events. appId", zzhe.zzn(str17), e);
                                        j2 = 0;
                                        if (j2 > 0) {
                                        }
                                        zzio zzioVar2 = this.zzn;
                                        zzbc zzbcVar2 = new zzbc(zzioVar2, zzbhVar2.zzc, str17, zzbhVar2.zza, zzbhVar2.zzd, 0L, zzc);
                                        zzaw zzj5 = zzj();
                                        String str19 = zzbcVar2.zzb;
                                        zzs = zzj5.zzs(str17, str19);
                                        if (zzs == null) {
                                        }
                                        zzj().zzV(zzbdVar);
                                        zzaX().zzg();
                                        zzM();
                                        Preconditions.checkNotNull(zzbcVar);
                                        Preconditions.checkNotNull(zzrVar);
                                        String str20 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str20);
                                        str4 = zzrVar.zza;
                                        Preconditions.checkArgument(str20.equals(str4));
                                        zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                        zzz.zzar(i6);
                                        zzz.zzan("android");
                                        if (!TextUtils.isEmpty(str4)) {
                                        }
                                        str5 = zzrVar.zzd;
                                        if (!TextUtils.isEmpty(str5)) {
                                        }
                                        str6 = zzrVar.zzc;
                                        if (!TextUtils.isEmpty(str6)) {
                                        }
                                        str7 = zzrVar.zzw;
                                        if (!TextUtils.isEmpty(str7)) {
                                        }
                                        j3 = zzrVar.zzj;
                                        if (j3 != -2147483648L) {
                                        }
                                        zzz.zzai(zzrVar.zze);
                                        str8 = zzrVar.zzb;
                                        if (!TextUtils.isEmpty(str8)) {
                                        }
                                        zzl = zzu((String) Preconditions.checkNotNull(str4)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzz.zzT(zzl.zzp());
                                        if (zzz.zzaJ().isEmpty()) {
                                        }
                                        zzqr.zzb();
                                        if (zzi().zzx(str4, zzgi.zzaV)) {
                                            zzz.zzG(zzrVar.zzB);
                                            j5 = zzrVar.zzC;
                                            if (!zzl.zzr(zzjw.AD_STORAGE)) {
                                                j5 = (j5 & (-2)) | 32;
                                            }
                                            zzz.zzaa(j5 != 1 ? i6 : 0);
                                            if (j5 == 0) {
                                            }
                                        }
                                        j4 = zzrVar.zzf;
                                        if (j4 != 0) {
                                        }
                                        zzz.zzZ(zzrVar.zzr);
                                        zzqa zzA = zzA();
                                        com.google.android.gms.internal.measurement.zzjm zza2 = com.google.android.gms.internal.measurement.zzjm.zza(zzA.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.google.android.gms.internal.measurement.zzki.zzc();
                                            }
                                        });
                                        if (zza2 != null) {
                                        }
                                        if (emptyMap != null) {
                                            arrayList = new ArrayList();
                                            int intValue2 = ((Integer) zzgi.zzae.zza(r22)).intValue();
                                            while (r13.hasNext()) {
                                            }
                                        }
                                        arrayList = r22;
                                        if (arrayList != null) {
                                        }
                                        if (zzi().zzx(r22, zzgi.zzbk)) {
                                        }
                                        str9 = zzrVar.zza;
                                        zzl2 = zzu((String) Preconditions.checkNotNull(str9)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                        zzjwVar = zzjw.AD_STORAGE;
                                        if (zzl2.zzr(zzjwVar)) {
                                            zzd = this.zzk.zzd(str9, zzl2);
                                            if (!TextUtils.isEmpty((CharSequence) zzd.first)) {
                                            }
                                        }
                                        str10 = str3;
                                        zzjwVar2 = zzjwVar;
                                        zzioVar = this.zzn;
                                        zzioVar.zzg().zzv();
                                        zzz.zzX(Build.MODEL);
                                        zzioVar.zzg().zzv();
                                        zzz.zzam(Build.VERSION.RELEASE);
                                        zzz.zzaz((int) zzioVar.zzg().zza());
                                        zzz.zzaD(zzioVar.zzg().zzb());
                                        zzz.zzay(zzrVar.zzy);
                                        if (zzioVar.zzJ()) {
                                        }
                                        zzl3 = zzj().zzl(str9);
                                        if (zzl3 == null) {
                                        }
                                        if (zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                                        }
                                        if (!TextUtils.isEmpty(zzl3.zzG())) {
                                        }
                                        zzE = zzj().zzE(str9);
                                        while (i4 < zzE.size()) {
                                        }
                                        zzj = zzj();
                                        zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                        zzj.zzg();
                                        zzj.zzav();
                                        Preconditions.checkNotNull(zzhxVar);
                                        Preconditions.checkNotEmpty(zzhxVar.zzF());
                                        byte[] zzcd = zzhxVar.zzcd();
                                        long zzf = zzj.zzg.zzA().zzf(zzcd);
                                        ContentValues contentValues2 = new ContentValues();
                                        String str21 = str2;
                                        contentValues2.put(str21, zzhxVar.zzF());
                                        contentValues2.put("metadata_fingerprint", Long.valueOf(zzf));
                                        contentValues2.put("metadata", zzcd);
                                        zzj.zzj().insertWithOnConflict("raw_events_metadata", r22, contentValues2, 4);
                                        zzj2 = zzj();
                                        zzbeVar = new zzbe(zzbcVar.zzf);
                                        while (true) {
                                            if (zzbeVar.hasNext()) {
                                            }
                                        }
                                        i5 = 1;
                                        zzj2.zzg();
                                        zzj2.zzav();
                                        Preconditions.checkNotNull(zzbcVar);
                                        String str22 = zzbcVar.zza;
                                        Preconditions.checkNotEmpty(str22);
                                        byte[] zzcd2 = zzj2.zzg.zzA().zzm(zzbcVar).zzcd();
                                        contentValues = new ContentValues();
                                        contentValues.put(str21, str22);
                                        contentValues.put("name", zzbcVar.zzb);
                                        contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(zzf));
                                        contentValues.put("data", zzcd2);
                                        contentValues.put("realtime", Integer.valueOf(i5));
                                        try {
                                            if (zzj2.zzj().insert(str10, r22, contentValues) == -1) {
                                            }
                                        } catch (SQLiteException e2) {
                                            zzj2.zzu.zzaW().zze().zzc("Error storing raw event. appId", zzhe.zzn(zzbcVar.zza), e2);
                                        }
                                        zzj().zzS();
                                        zzj().zzL();
                                        zzaL();
                                        zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    str3 = "raw_events";
                                }
                                if (j2 > 0) {
                                    zzaW().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzhe.zzn(str17), Long.valueOf(j2));
                                }
                                zzio zzioVar22 = this.zzn;
                                zzbc zzbcVar22 = new zzbc(zzioVar22, zzbhVar2.zzc, str17, zzbhVar2.zza, zzbhVar2.zzd, 0L, zzc);
                                zzaw zzj52 = zzj();
                                String str192 = zzbcVar22.zzb;
                                zzs = zzj52.zzs(str17, str192);
                                if (zzs == null) {
                                    zzbc zza3 = zzbcVar22.zza(zzioVar22, zzs.zzf);
                                    zzbd zzc2 = zzs.zzc(zza3.zzd);
                                    zzbcVar = zza3;
                                    zzbdVar = zzc2;
                                } else if (zzj().zzi(str17) < zzi().zzb(str17) || !zzaq) {
                                    zzbdVar = new zzbd(str17, str192, 0L, 0L, 0L, zzbcVar22.zzd, 0L, null, null, null, null);
                                    zzbcVar = zzbcVar22;
                                } else {
                                    zzaW().zze().zzd("Too many event names used, ignoring event. appId, name, supported count", zzhe.zzn(str17), zzioVar22.zzj().zzd(str192), Integer.valueOf(zzi().zzb(str17)));
                                    zzB().zzR(this.zzK, str17, 8, null, null, 0);
                                }
                                zzj().zzV(zzbdVar);
                                zzaX().zzg();
                                zzM();
                                Preconditions.checkNotNull(zzbcVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str202 = zzbcVar.zza;
                                Preconditions.checkNotEmpty(str202);
                                str4 = zzrVar.zza;
                                Preconditions.checkArgument(str202.equals(str4));
                                zzz = com.google.android.gms.internal.measurement.zzhx.zzz();
                                zzz.zzar(i6);
                                zzz.zzan("android");
                                if (!TextUtils.isEmpty(str4)) {
                                    zzz.zzI(str4);
                                }
                                str5 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str5)) {
                                    zzz.zzK(str5);
                                }
                                str6 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str6)) {
                                    zzz.zzL(str6);
                                }
                                str7 = zzrVar.zzw;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzz.zzav(str7);
                                }
                                j3 = zzrVar.zzj;
                                if (j3 != -2147483648L) {
                                    zzz.zzM((int) j3);
                                }
                                zzz.zzai(zzrVar.zze);
                                str8 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzz.zzah(str8);
                                }
                                zzl = zzu((String) Preconditions.checkNotNull(str4)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzz.zzT(zzl.zzp());
                                if (zzz.zzaJ().isEmpty()) {
                                    String str23 = zzrVar.zzp;
                                    if (!TextUtils.isEmpty(str23)) {
                                        zzz.zzH(str23);
                                    }
                                }
                                zzqr.zzb();
                                if (zzi().zzx(str4, zzgi.zzaV) && zzB().zzab(str4)) {
                                    zzz.zzG(zzrVar.zzB);
                                    j5 = zzrVar.zzC;
                                    if (!zzl.zzr(zzjw.AD_STORAGE) && j5 != 0) {
                                        j5 = (j5 & (-2)) | 32;
                                    }
                                    zzz.zzaa(j5 != 1 ? i6 : 0);
                                    if (j5 == 0) {
                                        com.google.android.gms.internal.measurement.zzhf zza4 = com.google.android.gms.internal.measurement.zzhg.zza();
                                        zza4.zzc((j5 & 1) != 0 ? i6 : 0);
                                        zza4.zze((j5 & 2) != 0 ? i6 : 0);
                                        zza4.zzf((j5 & 4) != 0 ? i6 : 0);
                                        zza4.zzg((j5 & 8) != 0 ? i6 : 0);
                                        zza4.zzb((j5 & 16) != 0 ? i6 : 0);
                                        zza4.zza((32 & j5) != 0 ? i6 : 0);
                                        zza4.zzd((j5 & 64) != 0 ? i6 : 0);
                                        zzz.zzN((com.google.android.gms.internal.measurement.zzhg) zza4.zzba());
                                    }
                                }
                                j4 = zzrVar.zzf;
                                if (j4 != 0) {
                                    zzz.zzW(j4);
                                }
                                zzz.zzZ(zzrVar.zzr);
                                zzqa zzA2 = zzA();
                                com.google.android.gms.internal.measurement.zzjm zza22 = com.google.android.gms.internal.measurement.zzjm.zza(zzA2.zzg.zzn.zzaT().getContentResolver(), com.google.android.gms.internal.measurement.zzjx.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbj
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        com.google.android.gms.internal.measurement.zzki.zzc();
                                    }
                                });
                                emptyMap = zza22 != null ? Collections.emptyMap() : zza22.zzd();
                                if (emptyMap != null && !emptyMap.isEmpty()) {
                                    arrayList = new ArrayList();
                                    int intValue22 = ((Integer) zzgi.zzae.zza(r22)).intValue();
                                    for (Map.Entry entry : emptyMap.entrySet()) {
                                        if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                            try {
                                                int parseInt = Integer.parseInt((String) entry.getValue());
                                                if (parseInt != 0) {
                                                    arrayList.add(Integer.valueOf(parseInt));
                                                    if (arrayList.size() >= intValue22) {
                                                        zzA2.zzu.zzaW().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                                        break;
                                                    }
                                                    continue;
                                                } else {
                                                    continue;
                                                }
                                            } catch (NumberFormatException e4) {
                                                zzA2.zzu.zzaW().zzk().zzb("Experiment ID NumberFormatException", e4);
                                            }
                                        }
                                    }
                                }
                                arrayList = r22;
                                if (arrayList != null) {
                                    zzz.zzk(arrayList);
                                }
                                if (zzi().zzx(r22, zzgi.zzbk)) {
                                    zzz.zzaf("");
                                }
                                str9 = zzrVar.zza;
                                zzl2 = zzu((String) Preconditions.checkNotNull(str9)).zzl(zzjx.zzk(zzrVar.zzu, 100));
                                zzjwVar = zzjw.AD_STORAGE;
                                try {
                                    if (zzl2.zzr(zzjwVar) && zzrVar.zzn) {
                                        zzd = this.zzk.zzd(str9, zzl2);
                                        if (!TextUtils.isEmpty((CharSequence) zzd.first)) {
                                            zzz.zzas((String) zzd.first);
                                            if (zzd.second != null) {
                                                zzz.zzal(((Boolean) zzd.second).booleanValue());
                                            }
                                            if (!zzbcVar.zzb.equals("_fx") && !((String) zzd.first).equals("00000000-0000-0000-0000-000000000000") && (zzl4 = zzj().zzl(str9)) != null && zzl4.zzaM()) {
                                                zzar(str9, false, r22, r22);
                                                Bundle bundle2 = new Bundle();
                                                Long zzy2 = zzl4.zzy();
                                                if (zzy2 != null) {
                                                    str10 = str3;
                                                    long longValue2 = zzy2.longValue();
                                                    zzjwVar2 = zzjwVar;
                                                    zzhVar = zzl4;
                                                    bundle2.putLong("_pfo", Math.max(0L, longValue2));
                                                } else {
                                                    str10 = str3;
                                                    zzjwVar2 = zzjwVar;
                                                    zzhVar = zzl4;
                                                }
                                                Long zzz2 = zzhVar.zzz();
                                                if (zzz2 != null) {
                                                    bundle2.putLong("_uwa", zzz2.longValue());
                                                }
                                                bundle2.putLong("_r", 1L);
                                                this.zzK.zza(str9, "_fx", bundle2);
                                                zzioVar = this.zzn;
                                                zzioVar.zzg().zzv();
                                                zzz.zzX(Build.MODEL);
                                                zzioVar.zzg().zzv();
                                                zzz.zzam(Build.VERSION.RELEASE);
                                                zzz.zzaz((int) zzioVar.zzg().zza());
                                                zzz.zzaD(zzioVar.zzg().zzb());
                                                zzz.zzay(zzrVar.zzy);
                                                if (zzioVar.zzJ()) {
                                                    zzz.zzaF();
                                                    if (!TextUtils.isEmpty(r22)) {
                                                        zzz.zzY(r22);
                                                    }
                                                }
                                                zzl3 = zzj().zzl(str9);
                                                if (zzl3 == null) {
                                                    zzl3 = new zzh(zzioVar, str9);
                                                    zzl3.zzV(zzC(zzl2));
                                                    zzl3.zzan(zzrVar.zzk);
                                                    zzl3.zzao(zzrVar.zzb);
                                                    if (zzl2.zzr(zzjwVar2)) {
                                                        zzl3.zzax(this.zzk.zzf(str9, zzrVar.zzn));
                                                    }
                                                    zzl3.zzat(0L);
                                                    zzl3.zzau(0L);
                                                    zzl3.zzas(0L);
                                                    zzl3.zzX(zzrVar.zzc);
                                                    zzl3.zzY(zzrVar.zzj);
                                                    zzl3.zzW(zzrVar.zzd);
                                                    zzl3.zzap(zzrVar.zze);
                                                    zzl3.zzaj(zzrVar.zzf);
                                                    zzl3.zzav(zzrVar.zzh);
                                                    zzl3.zzal(zzrVar.zzr);
                                                    i3 = 0;
                                                    zzj().zzT(zzl3, false, false);
                                                } else {
                                                    i3 = 0;
                                                }
                                                if (zzl2.zzr(zzjw.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzl3.zzD())) {
                                                    zzz.zzJ((String) Preconditions.checkNotNull(zzl3.zzD()));
                                                }
                                                if (!TextUtils.isEmpty(zzl3.zzG())) {
                                                    zzz.zzag((String) Preconditions.checkNotNull(zzl3.zzG()));
                                                }
                                                zzE = zzj().zzE(str9);
                                                for (i4 = i3; i4 < zzE.size(); i4++) {
                                                    com.google.android.gms.internal.measurement.zzin zze = com.google.android.gms.internal.measurement.zzio.zze();
                                                    zze.zzf(((zzqd) zzE.get(i4)).zzc);
                                                    zze.zzg(((zzqd) zzE.get(i4)).zzd);
                                                    zzA().zzx(zze, ((zzqd) zzE.get(i4)).zze);
                                                    zzz.zzo(zze);
                                                    if ("_sid".equals(((zzqd) zzE.get(i4)).zzc) && zzl3.zzv() != 0 && zzA().zzd(zzrVar.zzw) != zzl3.zzv()) {
                                                        zzz.zzA();
                                                    }
                                                }
                                                zzj = zzj();
                                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                                zzj.zzg();
                                                zzj.zzav();
                                                Preconditions.checkNotNull(zzhxVar);
                                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                                byte[] zzcd3 = zzhxVar.zzcd();
                                                long zzf2 = zzj.zzg.zzA().zzf(zzcd3);
                                                ContentValues contentValues22 = new ContentValues();
                                                String str212 = str2;
                                                contentValues22.put(str212, zzhxVar.zzF());
                                                contentValues22.put("metadata_fingerprint", Long.valueOf(zzf2));
                                                contentValues22.put("metadata", zzcd3);
                                                zzj.zzj().insertWithOnConflict("raw_events_metadata", r22, contentValues22, 4);
                                                zzj2 = zzj();
                                                zzbeVar = new zzbe(zzbcVar.zzf);
                                                while (true) {
                                                    if (zzbeVar.hasNext()) {
                                                        String next2 = zzbeVar.next();
                                                        String str24 = next2;
                                                        if ("_r".equals(next2)) {
                                                            break;
                                                        }
                                                    } else {
                                                        zzif zzr2 = zzr();
                                                        String str25 = zzbcVar.zza;
                                                        boolean zzw = zzr2.zzw(str25, zzbcVar.zzb);
                                                        zzas zzo = zzj().zzo(zza(), str25, false, false, false, false, false, false, false);
                                                        if (!zzw || zzo.zze >= zzi().zzh(str25, zzgi.zzo)) {
                                                            i5 = 0;
                                                        }
                                                    }
                                                }
                                                i5 = 1;
                                                zzj2.zzg();
                                                zzj2.zzav();
                                                Preconditions.checkNotNull(zzbcVar);
                                                String str222 = zzbcVar.zza;
                                                Preconditions.checkNotEmpty(str222);
                                                byte[] zzcd22 = zzj2.zzg.zzA().zzm(zzbcVar).zzcd();
                                                contentValues = new ContentValues();
                                                contentValues.put(str212, str222);
                                                contentValues.put("name", zzbcVar.zzb);
                                                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(zzf2));
                                                contentValues.put("data", zzcd22);
                                                contentValues.put("realtime", Integer.valueOf(i5));
                                                if (zzj2.zzj().insert(str10, r22, contentValues) == -1) {
                                                    zzj2.zzu.zzaW().zze().zzb("Failed to insert raw event (got -1). appId", zzhe.zzn(str222));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzS();
                                                zzj().zzL();
                                                zzaL();
                                                zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                        }
                                    }
                                    zzj.zzj().insertWithOnConflict("raw_events_metadata", r22, contentValues22, 4);
                                    zzj2 = zzj();
                                    zzbeVar = new zzbe(zzbcVar.zzf);
                                    while (true) {
                                        if (zzbeVar.hasNext()) {
                                        }
                                    }
                                    i5 = 1;
                                    zzj2.zzg();
                                    zzj2.zzav();
                                    Preconditions.checkNotNull(zzbcVar);
                                    String str2222 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str2222);
                                    byte[] zzcd222 = zzj2.zzg.zzA().zzm(zzbcVar).zzcd();
                                    contentValues = new ContentValues();
                                    contentValues.put(str212, str2222);
                                    contentValues.put("name", zzbcVar.zzb);
                                    contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(zzf2));
                                    contentValues.put("data", zzcd222);
                                    contentValues.put("realtime", Integer.valueOf(i5));
                                    if (zzj2.zzj().insert(str10, r22, contentValues) == -1) {
                                    }
                                    zzj().zzS();
                                    zzj().zzL();
                                    zzaL();
                                    zzaW().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                    return;
                                } catch (SQLiteException e5) {
                                    zzj.zzu.zzaW().zze().zzc("Error storing raw event metadata. appId", zzhe.zzn(zzhxVar.zzF()), e5);
                                    throw e5;
                                }
                                str10 = str3;
                                zzjwVar2 = zzjwVar;
                                zzioVar = this.zzn;
                                zzioVar.zzg().zzv();
                                zzz.zzX(Build.MODEL);
                                zzioVar.zzg().zzv();
                                zzz.zzam(Build.VERSION.RELEASE);
                                zzz.zzaz((int) zzioVar.zzg().zza());
                                zzz.zzaD(zzioVar.zzg().zzb());
                                zzz.zzay(zzrVar.zzy);
                                if (zzioVar.zzJ()) {
                                }
                                zzl3 = zzj().zzl(str9);
                                if (zzl3 == null) {
                                }
                                if (zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                                    zzz.zzJ((String) Preconditions.checkNotNull(zzl3.zzD()));
                                }
                                if (!TextUtils.isEmpty(zzl3.zzG())) {
                                }
                                zzE = zzj().zzE(str9);
                                while (i4 < zzE.size()) {
                                }
                                zzj = zzj();
                                zzhxVar = (com.google.android.gms.internal.measurement.zzhx) zzz.zzba();
                                zzj.zzg();
                                zzj.zzav();
                                Preconditions.checkNotNull(zzhxVar);
                                Preconditions.checkNotEmpty(zzhxVar.zzF());
                                byte[] zzcd32 = zzhxVar.zzcd();
                                long zzf22 = zzj.zzg.zzA().zzf(zzcd32);
                                ContentValues contentValues222 = new ContentValues();
                                String str2122 = str2;
                                contentValues222.put(str2122, zzhxVar.zzF());
                                contentValues222.put("metadata_fingerprint", Long.valueOf(zzf22));
                                contentValues222.put("metadata", zzcd32);
                            }
                        }
                        z = true;
                    }
                    zzbf zzbfVar2 = zza.zzb;
                    zzg = zzbfVar2.zzg("currency");
                    if (z) {
                        str = "_err";
                        longValue = zzbfVar2.zze("value").longValue();
                    } else {
                        double doubleValue = zzbfVar2.zzd("value").doubleValue() * 1000000.0d;
                        if (doubleValue == 0.0d) {
                            str = "_err";
                            doubleValue = zzbfVar2.zze("value").longValue() * 1000000.0d;
                        } else {
                            str = "_err";
                        }
                        if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                            zzaW().zzk().zzc("Data lost. Currency value is too big. appId", zzhe.zzn(str11), Double.valueOf(doubleValue));
                            zzj().zzS();
                        } else {
                            longValue = Math.round(doubleValue);
                            if (FirebaseAnalytics.Event.REFUND.equals(str14)) {
                                longValue = -longValue;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(zzg)) {
                        String upperCase = zzg.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String concat = "_ltv_".concat(String.valueOf(upperCase));
                            zzqd zzy3 = zzj().zzy(str11, concat);
                            if (zzy3 != null && (zzy3.zze instanceof Long)) {
                                long longValue3 = ((Long) zzy3.zze).longValue();
                                String str26 = zza.zzc;
                                long currentTimeMillis = zzaU().currentTimeMillis();
                                Long valueOf2 = Long.valueOf(longValue3 + longValue);
                                str2 = MBridgeConstans.APP_ID;
                                obj = null;
                                i2 = 1;
                                zzqdVar = new zzqd(str11, str26, concat, currentTimeMillis, valueOf2);
                                str11 = str11;
                                i = 2;
                                zzbhVar2 = zza;
                                zzqdVar2 = zzqdVar;
                                if (!zzj().zzai(zzqdVar2)) {
                                    zzaW().zze().zzd("Too many unique user properties are set. Ignoring user property. appId", zzhe.zzn(str11), this.zzn.zzj().zzf(zzqdVar2.zzc), zzqdVar2.zze);
                                    zzB().zzR(this.zzK, str11, 9, null, null, 0);
                                }
                                String str152 = zzbhVar2.zza;
                                boolean zzaq2 = zzqf.zzaq(str152);
                                boolean equals2 = str.equals(str152);
                                zzB();
                                zzbfVar = zzbhVar2.zzb;
                                if (zzbfVar != null) {
                                }
                                String str172 = str11;
                                ?? r222 = obj;
                                int i62 = i2;
                                zzas zzp2 = zzj().zzp(zza(), str172, j + 1, true, zzaq2, false, equals2, false, false, false);
                                long j62 = zzp2.zzb;
                                zzi();
                                zzH = j62 - zzam.zzH();
                                if (zzH <= 0) {
                                }
                            }
                            str2 = MBridgeConstans.APP_ID;
                            obj = null;
                            i2 = 1;
                            zzaw zzj6 = zzj();
                            int zzh = zzi().zzh(str11, zzgi.zzS) - 1;
                            Preconditions.checkNotEmpty(str11);
                            zzj6.zzg();
                            zzj6.zzav();
                            i = 2;
                            zzj6.zzj().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str11, str11, String.valueOf(zzh)});
                            zzbhVar2 = zza;
                            zzqdVar = new zzqd(str11, zza.zzc, concat, zzaU().currentTimeMillis(), Long.valueOf(longValue));
                            str11 = str11;
                            zzqdVar2 = zzqdVar;
                            if (!zzj().zzai(zzqdVar2)) {
                            }
                            String str1522 = zzbhVar2.zza;
                            boolean zzaq22 = zzqf.zzaq(str1522);
                            boolean equals22 = str.equals(str1522);
                            zzB();
                            zzbfVar = zzbhVar2.zzb;
                            if (zzbfVar != null) {
                            }
                            String str1722 = str11;
                            ?? r2222 = obj;
                            int i622 = i2;
                            zzas zzp22 = zzj().zzp(zza(), str1722, j + 1, true, zzaq22, false, equals22, false, false, false);
                            long j622 = zzp22.zzb;
                            zzi();
                            zzH = j622 - zzam.zzH();
                            if (zzH <= 0) {
                            }
                        }
                    }
                    str2 = MBridgeConstans.APP_ID;
                    zzbhVar2 = zza;
                    obj = null;
                    i = 2;
                    i2 = 1;
                    String str15222 = zzbhVar2.zza;
                    boolean zzaq222 = zzqf.zzaq(str15222);
                    boolean equals222 = str.equals(str15222);
                    zzB();
                    zzbfVar = zzbhVar2.zzb;
                    if (zzbfVar != null) {
                    }
                    String str17222 = str11;
                    ?? r22222 = obj;
                    int i6222 = i2;
                    zzas zzp222 = zzj().zzp(zza(), str17222, j + 1, true, zzaq222, false, equals222, false, false, false);
                    long j6222 = zzp222.zzb;
                    zzi();
                    zzH = j6222 - zzam.zzH();
                    if (zzH <= 0) {
                    }
                }
                z = true;
                if (!"_iap".equals(str14)) {
                }
                zzbf zzbfVar22 = zza.zzb;
                zzg = zzbfVar22.zzg("currency");
                if (z) {
                }
                if (!TextUtils.isEmpty(zzg)) {
                }
                str2 = MBridgeConstans.APP_ID;
                zzbhVar2 = zza;
                obj = null;
                i = 2;
                i2 = 1;
                String str152222 = zzbhVar2.zza;
                boolean zzaq2222 = zzqf.zzaq(str152222);
                boolean equals2222 = str.equals(str152222);
                zzB();
                zzbfVar = zzbhVar2.zzb;
                if (zzbfVar != null) {
                }
                String str172222 = str11;
                ?? r222222 = obj;
                int i62222 = i2;
                zzas zzp2222 = zzj().zzp(zza(), str172222, j + 1, true, zzaq2222, false, equals2222, false, false, false);
                long j62222 = zzp2222.zzb;
                zzi();
                zzH = j62222 - zzam.zzH();
                if (zzH <= 0) {
                }
            } finally {
                zzj().zzL();
            }
        }
    }

    final boolean zzay(String str, String str2) {
        zzh zzl = zzj().zzl(str);
        if (zzl != null && zzB().zzak(str, zzl.zzM())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpt zzptVar = (zzpt) this.zzF.get(str2);
        if (zzptVar == null) {
            return true;
        }
        return zzptVar.zzc();
    }

    final boolean zzaz() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzf();
        File filesDir = this.zzn.zzaT().getFilesDir();
        com.google.android.gms.internal.measurement.zzbx.zza();
        int i = com.google.android.gms.internal.measurement.zzcc.zzb;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock tryLock = channel.tryLock();
            this.zzx = tryLock;
            if (tryLock != null) {
                zzaW().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zze().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zze().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zze().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zzk().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final Bundle zzd(String str) {
        zzaX().zzg();
        zzM();
        if (zzr().zzi(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjx zzu = zzu(str);
        bundle.putAll(zzu.zzc());
        bundle.putAll(zzl(str, zzm(str), zzu, new zzao()).zzb());
        zzqd zzy = zzj().zzy(str, "_npa");
        bundle.putString("ad_personalization", 1 != (zzy != null ? zzy.zze.equals(1L) : zzaC(str, new zzao())) ? "granted" : "denied");
        return bundle;
    }

    final Bundle zzf(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zze("_sid").longValue());
        zzqd zzy = zzj().zzy(str, "_sno");
        if (zzy != null) {
            Object obj = zzy.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final zzh zzg(zzr zzrVar) {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        zzaX().zzg();
        zzM();
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        String str6 = zzrVar.zzv;
        zzpu zzpuVar = null;
        if (!str6.isEmpty()) {
            this.zzE.put(str5, new zzps(this, str6));
        }
        zzh zzl = zzj().zzl(str5);
        zzjx zzl2 = zzu(str5).zzl(zzjx.zzk(zzrVar.zzu, 100));
        zzjw zzjwVar = zzjw.AD_STORAGE;
        String zzf = zzl2.zzr(zzjwVar) ? this.zzk.zzf(str5, zzrVar.zzn) : "";
        boolean z2 = true;
        if (zzl == null) {
            zzh zzhVar = new zzh(this.zzn, str5);
            if (zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                zzhVar.zzV(zzC(zzl2));
            }
            if (zzl2.zzr(zzjwVar)) {
                zzhVar.zzax(zzf);
            }
            zzl = zzhVar;
        } else if (zzl2.zzr(zzjwVar) && zzf != null && !zzf.equals(zzl.zzJ())) {
            boolean isEmpty = TextUtils.isEmpty(zzl.zzJ());
            zzl.zzax(zzf);
            if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(str5, zzl2).first) && !isEmpty) {
                if (zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                    zzl.zzV(zzC(zzl2));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzy(str5, "_id") != null && zzj().zzy(str5, "_lair") == null) {
                    zzj().zzai(new zzqd(str5, "auto", "_lair", zzaU().currentTimeMillis(), 1L));
                }
                zzl.zzao(zzrVar.zzb);
                zzl.zzS(zzrVar.zzp);
                str = zzrVar.zzk;
                if (!TextUtils.isEmpty(str)) {
                    zzl.zzan(str);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzl.zzap(j);
                }
                str2 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str2)) {
                    zzl.zzX(str2);
                }
                zzl.zzY(zzrVar.zzj);
                str3 = zzrVar.zzd;
                if (str3 != null) {
                    zzl.zzW(str3);
                }
                zzl.zzaj(zzrVar.zzf);
                zzl.zzav(zzrVar.zzh);
                str4 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str4)) {
                    zzl.zzaq(str4);
                }
                zzl.zzU(zzrVar.zzn);
                zzl.zzaw(zzrVar.zzq);
                zzl.zzal(zzrVar.zzr);
                zzl.zzaA(zzrVar.zzw);
                com.google.android.gms.internal.measurement.zzpn.zzb();
                if (zzi().zzx(null, zzgi.zzaK)) {
                    com.google.android.gms.internal.measurement.zzpn.zzb();
                    if (zzi().zzx(null, zzgi.zzaJ)) {
                        zzl.zzay(null);
                    }
                } else {
                    zzl.zzay(zzrVar.zzs);
                }
                zzl.zzaD(zzrVar.zzx);
                zzl.zzaC(zzrVar.zzD);
                zzqr.zzb();
                if (zzi().zzx(null, zzgi.zzaV)) {
                    zzl.zzT(zzrVar.zzB);
                }
                zzl.zzaE(zzrVar.zzy);
                zzl.zzaz(zzrVar.zzE);
                if (zzi().zzx(null, zzgi.zzaP)) {
                    zzl.zzaa(zzrVar.zzG);
                }
                if (!zzl.zzaK()) {
                    z2 = z;
                } else if (!z) {
                    return zzl;
                }
                zzj().zzT(zzl, z2, false);
                return zzl;
            }
            if (TextUtils.isEmpty(zzl.zzD()) && zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
                zzl.zzV(zzC(zzl2));
            }
        } else if (TextUtils.isEmpty(zzl.zzD()) && zzl2.zzr(zzjw.ANALYTICS_STORAGE)) {
            zzl.zzV(zzC(zzl2));
        }
        z = false;
        zzl.zzao(zzrVar.zzb);
        zzl.zzS(zzrVar.zzp);
        str = zzrVar.zzk;
        if (!TextUtils.isEmpty(str)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str2 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str2)) {
        }
        zzl.zzY(zzrVar.zzj);
        str3 = zzrVar.zzd;
        if (str3 != null) {
        }
        zzl.zzaj(zzrVar.zzf);
        zzl.zzav(zzrVar.zzh);
        str4 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str4)) {
        }
        zzl.zzU(zzrVar.zzn);
        zzl.zzaw(zzrVar.zzq);
        zzl.zzal(zzrVar.zzr);
        zzl.zzaA(zzrVar.zzw);
        com.google.android.gms.internal.measurement.zzpn.zzb();
        if (zzi().zzx(null, zzgi.zzaK)) {
        }
        zzl.zzaD(zzrVar.zzx);
        zzl.zzaC(zzrVar.zzD);
        zzqr.zzb();
        if (zzi().zzx(null, zzgi.zzaV)) {
        }
        zzl.zzaE(zzrVar.zzy);
        zzl.zzaz(zzrVar.zzE);
        if (zzi().zzx(null, zzgi.zzaP)) {
        }
        if (!zzl.zzaK()) {
        }
        zzj().zzT(zzl, z2, false);
        return zzl;
    }

    public final zzae zzh() {
        zzae zzaeVar = this.zzh;
        zzaR(zzaeVar);
        return zzaeVar;
    }

    public final zzam zzi() {
        return ((zzio) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaR(zzawVar);
        return zzawVar;
    }

    final zzba zzl(String str, zzba zzbaVar, zzjx zzjxVar, zzao zzaoVar) {
        zzju zzjuVar;
        zzju zzf;
        int i = 90;
        if (zzr().zzi(str) == null) {
            if (zzbaVar.zzf() == zzju.DENIED) {
                i = zzbaVar.zza();
                zzaoVar.zzc(zzjw.AD_USER_DATA, i);
            } else {
                zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.FAILSAFE);
            }
            return new zzba((Boolean) false, i, (Boolean) true, "-");
        }
        zzju zzf2 = zzbaVar.zzf();
        if (zzf2 == zzju.GRANTED || zzf2 == (zzjuVar = zzju.DENIED)) {
            i = zzbaVar.zza();
            zzaoVar.zzc(zzjw.AD_USER_DATA, i);
        } else if (zzf2 != zzju.POLICY || (zzf = this.zzc.zzf(str, zzjw.AD_USER_DATA)) == zzju.UNINITIALIZED) {
            zzif zzifVar = this.zzc;
            zzjw zzh = zzifVar.zzh(str, zzjw.AD_USER_DATA);
            zzju zze = zzjxVar.zze();
            zzju zzjuVar2 = zzju.GRANTED;
            boolean z = zze == zzjuVar2 || zze == zzjuVar;
            if (zzh == zzjw.AD_STORAGE && z) {
                zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.REMOTE_DELEGATION);
                zzf2 = zze;
            } else {
                zzjw zzjwVar = zzjw.AD_USER_DATA;
                zzaoVar.zzd(zzjwVar, zzan.REMOTE_DEFAULT);
                zzf2 = true != zzifVar.zzu(str, zzjwVar) ? zzjuVar : zzjuVar2;
            }
        } else {
            zzaoVar.zzd(zzjw.AD_USER_DATA, zzan.REMOTE_ENFORCED_DEFAULT);
            zzf2 = zzf;
        }
        boolean zzv = this.zzc.zzv(str);
        SortedSet zzp = zzr().zzp(str);
        if (zzf2 == zzju.DENIED || zzp.isEmpty()) {
            return new zzba((Boolean) false, i, Boolean.valueOf(zzv), "-");
        }
        return new zzba((Boolean) true, i, Boolean.valueOf(zzv), zzv ? TextUtils.join("", zzp) : "");
    }

    final zzba zzm(String str) {
        zzaX().zzg();
        zzM();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzq = zzj().zzq(str);
        map.put(str, zzq);
        return zzq;
    }

    public final zzgx zzo() {
        return this.zzn.zzj();
    }

    public final zzhk zzp() {
        zzhk zzhkVar = this.zzd;
        zzaR(zzhkVar);
        return zzhkVar;
    }

    public final zzhm zzq() {
        zzhm zzhmVar = this.zzf;
        if (zzhmVar != null) {
            return zzhmVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzif zzr() {
        zzif zzifVar = this.zzc;
        zzaR(zzifVar);
        return zzifVar;
    }

    final zzio zzt() {
        return this.zzn;
    }

    final zzjx zzu(String str) {
        zzjx zzjxVar = zzjx.zza;
        zzaX().zzg();
        zzM();
        zzjx zzjxVar2 = (zzjx) this.zzC.get(str);
        if (zzjxVar2 == null) {
            zzjxVar2 = zzj().zzu(str);
            if (zzjxVar2 == null) {
                zzjxVar2 = zzjx.zza;
            }
            zzaq(str, zzjxVar2);
        }
        return zzjxVar2;
    }

    public final zzmc zzv() {
        zzmc zzmcVar = this.zzj;
        zzaR(zzmcVar);
        return zzmcVar;
    }

    public final zzoa zzw() {
        return this.zzk;
    }

    public final zzoy zzx() {
        zzoy zzoyVar = this.zzg;
        zzaR(zzoyVar);
        return zzoyVar;
    }

    public final zzpi zzy() {
        return this.zzl;
    }
}
