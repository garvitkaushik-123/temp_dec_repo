package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes5.dex */
final class zzae extends zzpg {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzae(zzpv zzpvVar) {
        super(zzpvVar);
    }

    private final zzy zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzf(int i, int i2) {
        BitSet bitSet;
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        bitSet = zzyVar.zze;
        return bitSet.get(i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|1|(2:2|(2:4|(2:6|7)(1:558))(2:559|560))|8|(3:10|11|12)|16|(1:557)(7:19|20|21|22|23|24|(16:(8:26|27|28|29|30|(1:32)(3:525|(2:527|528)(1:530)|529)|33|(1:36)(1:35))|(1:38)|39|40|41|42|43|44|(3:46|(1:48)|49)(4:483|(6:484|485|486|487|488|(1:491)(1:490))|(1:493)|494)|50|(5:312|(9:314|315|316|317|318|319|320|321|(1:(4:323|(1:325)|326|(1:329)(1:328)))(1:467))(1:482)|377|(10:380|(3:384|(4:387|(5:389|390|(1:392)(1:396)|393|394)(1:397)|395|385)|398)|399|(3:403|(4:406|(3:411|412|413)|414|404)|417)|418|(3:420|(6:423|(2:425|(3:427|428|429))(1:432)|430|431|429|421)|433)|434|(3:443|(8:446|(1:448)|449|(1:451)|452|(3:454|455|456)(1:458)|457|444)|459)|460|378)|466)|52|53|(3:193|(4:196|(3:198|199|(8:201|202|(15:204|205|206|207|208|209|210|211|212|213|214|215|216|(4:218|(10:219|220|221|222|223|224|(3:226|227|228)(1:267)|229|230|(1:233)(1:232))|(1:235)|236)(3:287|288|(1:290))|237)(1:308)|238|(4:241|(3:259|260|261)(6:243|244|(2:245|(2:247|(1:249)(2:250|251))(2:257|258))|(1:253)|254|255)|256|239)|262|263|264)(1:309))(1:310)|265|194)|311)|55|(6:57|(3:59|(6:62|(7:64|65|66|67|68|(3:(9:70|71|72|73|74|(1:76)(1:143)|77|78|(1:81)(1:80))|(1:83)|84)(3:150|151|(1:153))|85)(1:164)|86|(2:87|(2:89|(3:125|126|127)(8:91|(2:92|(4:94|(3:96|(1:98)(1:121)|99)(1:122)|100|(1:1)(2:104|(1:106)(2:107|108)))(2:123|124))|115|(1:117)(1:119)|118|110|111|112))(0))|128|60)|165)|166|(10:169|170|171|172|173|174|176|(3:178|179|180)(1:182)|181|167)|189|190)(2:191|192))(2:542|543))|539|40|41|42|43|44|(0)(0)|50|(0)|52|53|(0)|55|(0)(0)|(3:(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0a09, code lost:
    
        if (r10 != false) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x02ee, code lost:
    
        if (r2 != null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x02f0, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0323, code lost:
    
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
        r2 = new androidx.collection.ArrayMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0332, code lost:
    
        if (r11.isEmpty() == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0336, code lost:
    
        r3 = r11.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0342, code lost:
    
        if (r3.hasNext() == false) goto L546;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0344, code lost:
    
        r4 = ((java.lang.Integer) r3.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzic) r11.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x035e, code lost:
    
        if (r7 == null) goto L550;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0364, code lost:
    
        if (r7.isEmpty() == false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0368, code lost:
    
        r5 = r36.zzg;
        r19 = r0;
        r0 = r5.zzA().zzt(r6.zzi(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x037c, code lost:
    
        if (r0.isEmpty() != false) goto L547;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x041a, code lost:
    
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x037e, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.zzib) r6.zzch();
        r8.zzf();
        r8.zzb(r0);
        r0 = r5.zzA().zzt(r6.zzk(), r7);
        r8.zzh();
        r8.zzd(r0);
        r0 = new java.util.ArrayList();
        r5 = r6.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x03ad, code lost:
    
        if (r5.hasNext() == false) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x03af, code lost:
    
        r22 = r3;
        r3 = (com.google.android.gms.internal.measurement.zzhk) r5.next();
        r23 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x03c7, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r3.zza())) != false) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x03c9, code lost:
    
        r0.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x03cc, code lost:
    
        r3 = r22;
        r4 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x03d1, code lost:
    
        r22 = r3;
        r23 = r4;
        r8.zze();
        r8.zza(r0);
        r0 = new java.util.ArrayList();
        r3 = r6.zzj().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x03ec, code lost:
    
        if (r3.hasNext() == false) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x03ee, code lost:
    
        r4 = (com.google.android.gms.internal.measurement.zzie) r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0400, code lost:
    
        if (r7.contains(java.lang.Integer.valueOf(r4.zzb())) != false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0402, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0406, code lost:
    
        r8.zzg();
        r8.zzc(r0);
        r2.put(java.lang.Integer.valueOf(r23), (com.google.android.gms.internal.measurement.zzic) r8.zzba());
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0425, code lost:
    
        r0 = r19;
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x041e, code lost:
    
        r19 = r0;
        r22 = r3;
        r2.put(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x042b, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x02fa, code lost:
    
        if (r2 != null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0320, code lost:
    
        if (r2 == null) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x024d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x024e, code lost:
    
        r19 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x0257, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x0258, code lost:
    
        r19 = r2;
        r20 = "audience_id";
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x0253, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x0254, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0196, code lost:
    
        if (r5 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x016a, code lost:
    
        r5.close();
        r7 = r7;
        r40 = r40;
        r41 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0168, code lost:
    
        if (r5 != null) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0ac4  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01dd A[Catch: SQLiteException -> 0x024d, all -> 0x0aca, TRY_LEAVE, TryCatch #27 {all -> 0x0aca, blocks: (B:44:0x01d7, B:46:0x01dd, B:483:0x01ed, B:484:0x01f4, B:486:0x01fd, B:487:0x020d, B:488:0x0235, B:503:0x021a, B:506:0x0228, B:509:0x022e, B:497:0x025d), top: B:41:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:483:0x01ed A[Catch: SQLiteException -> 0x024d, all -> 0x0aca, TRY_ENTER, TryCatch #27 {all -> 0x0aca, blocks: (B:44:0x01d7, B:46:0x01dd, B:483:0x01ed, B:484:0x01f4, B:486:0x01fd, B:487:0x020d, B:488:0x0235, B:503:0x021a, B:506:0x0228, B:509:0x022e, B:497:0x025d), top: B:41:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0ace  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x08fe  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.google.android.gms.measurement.internal.zzy] */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28, types: [int] */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19, types: [int] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r12v12, types: [com.google.android.gms.measurement.internal.zzaa, com.google.android.gms.measurement.internal.zzab] */
    /* JADX WARN: Type inference failed for: r17v25, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r18v12, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v38 */
    /* JADX WARN: Type inference failed for: r18v39 */
    /* JADX WARN: Type inference failed for: r18v41 */
    /* JADX WARN: Type inference failed for: r40v11 */
    /* JADX WARN: Type inference failed for: r40v12 */
    /* JADX WARN: Type inference failed for: r40v3 */
    /* JADX WARN: Type inference failed for: r41v18 */
    /* JADX WARN: Type inference failed for: r41v19 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v68, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v70, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v71, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v35, types: [com.google.android.gms.measurement.internal.zzhc] */
    /* JADX WARN: Type inference failed for: r7v44, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v46, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v48, types: [java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final List zza(String str, List list, List list2, Long l, Long l2, boolean z) {
        ?? r10;
        ?? r11;
        boolean z2;
        Long l3;
        Long l4;
        Cursor cursor;
        Map map;
        ?? r41;
        int i;
        Cursor cursor2;
        String str2;
        boolean z3;
        String str3;
        Cursor cursor3;
        Map map2;
        String str4;
        HashSet hashSet;
        Map map3;
        List<com.google.android.gms.internal.measurement.zzfj> list3;
        boolean z4;
        ?? r5;
        Cursor cursor4;
        zzz zzzVar;
        Iterator it;
        zzbd zzbdVar;
        String str5;
        Iterator it2;
        Map map4;
        long j;
        Cursor cursor5;
        String str6;
        String str7;
        ?? r18;
        Cursor cursor6;
        List list4;
        Iterator it3;
        Iterator it4;
        Map map5;
        String str8;
        com.google.android.gms.internal.measurement.zzfr zzfrVar;
        zzio zzioVar;
        Cursor cursor7;
        List list5;
        ?? r52;
        Long l5;
        Long l6;
        Cursor cursor8;
        boolean z5;
        boolean z6;
        List list6;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it5 = list.iterator();
        while (true) {
            r10 = 0;
            r11 = 1;
            if (!it5.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhm) it5.next()).zzh())) {
                z2 = true;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzpq.zzb();
        zzio zzioVar2 = this.zzu;
        zzam zzf = zzioVar2.zzf();
        String str9 = this.zza;
        zzgg zzggVar = zzgi.zzaE;
        boolean zzx = zzf.zzx(str9, zzggVar);
        com.google.android.gms.internal.measurement.zzpq.zzb();
        boolean zzx2 = zzioVar2.zzf().zzx(this.zza, zzgi.zzaD);
        ?? r53 = zzggVar;
        if (z2) {
            zzaw zzj = this.zzg.zzj();
            String str10 = this.zza;
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(str10);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase zzj2 = zzj.zzj();
                zzj2.update("events", contentValues, "app_id = ?", new String[]{str10});
                r53 = zzj2;
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Error resetting session-scoped event counts. appId", zzhe.zzn(str10), e);
                r53 = "Error resetting session-scoped event counts. appId";
            }
        }
        Map emptyMap = Collections.emptyMap();
        String str11 = "audience_id";
        try {
            if (zzx2 && zzx) {
                zzaw zzj3 = this.zzg.zzj();
                ?? r7 = this.zza;
                Preconditions.checkNotEmpty(r7);
                ArrayMap arrayMap = new ArrayMap();
                try {
                    try {
                        str2 = "event_filters";
                        r52 = zzj3.zzj().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{r7}, null, null, null);
                        try {
                            try {
                            } catch (SQLiteException e2) {
                                e = e2;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            l2 = r10;
                            l = r11;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (r53 != 0) {
                            r53.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    l2 = null;
                    l = 1;
                    r52 = null;
                } catch (Throwable th2) {
                    th = th2;
                    r53 = 0;
                    if (r53 != 0) {
                    }
                    throw th;
                }
                if (r52.moveToFirst()) {
                    while (true) {
                        l = r11;
                        try {
                            try {
                                com.google.android.gms.internal.measurement.zzfj zzfjVar = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), r52.getBlob(r11))).zzba();
                                if (zzfjVar.zzo()) {
                                    Integer valueOf = Integer.valueOf(r52.getInt(r10));
                                    List list7 = (List) arrayMap.get(valueOf);
                                    if (list7 == null) {
                                        z6 = r10;
                                        list6 = new ArrayList();
                                        arrayMap.put(valueOf, list6);
                                    } else {
                                        z6 = r10;
                                        list6 = list7;
                                    }
                                    list6.add(zzfjVar);
                                    z5 = z6;
                                } else {
                                    z5 = r10;
                                }
                            } catch (IOException e5) {
                                z5 = r10;
                                zzj3.zzu.zzaW().zze().zzc("Failed to merge filter. appId", zzhe.zzn(r7), e5);
                            }
                            if (!r52.moveToNext()) {
                                break;
                            }
                            r11 = l;
                            r10 = z5;
                        } catch (SQLiteException e6) {
                            e = e6;
                            l2 = r10;
                            ?? zze = zzj3.zzu.zzaW().zze();
                            ?? zzn = zzhe.zzn(r7);
                            zze.zzc("Database error querying filters. appId", zzn, e);
                            emptyMap = Collections.emptyMap();
                            cursor = zzn;
                            l4 = l;
                            l3 = l2;
                            cursor8 = zzn;
                            l6 = l;
                            l5 = l2;
                        }
                    }
                    if (r52 != null) {
                        r52.close();
                    }
                    map = arrayMap;
                    cursor2 = r7;
                    i = l;
                    r41 = z5;
                    zzaw zzj4 = this.zzg.zzj();
                    String str12 = this.zza;
                    zzj4.zzav();
                    zzj4.zzg();
                    Preconditions.checkNotEmpty(str12);
                    SQLiteDatabase zzj5 = zzj4.zzj();
                    str2 = "audience_filter_values";
                    String[] strArr = new String[2];
                    strArr[r41] = "audience_id";
                    strArr[i] = "current_results";
                    String[] strArr2 = new String[i];
                    strArr2[r41] = str12;
                    cursor3 = zzj5.query("audience_filter_values", strArr, "app_id=?", strArr2, null, null, null);
                    if (cursor3.moveToFirst()) {
                        Map emptyMap2 = Collections.emptyMap();
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        map2 = emptyMap2;
                        z3 = z2;
                        str3 = "audience_id";
                        str4 = "audience_filter_values";
                    } else {
                        ArrayMap arrayMap2 = new ArrayMap();
                        int i2 = r41;
                        while (true) {
                            int i3 = cursor3.getInt(i2);
                            try {
                                arrayMap2.put(Integer.valueOf(i3), (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzib) zzqa.zzp(com.google.android.gms.internal.measurement.zzic.zze(), cursor3.getBlob(1))).zzba());
                                z3 = z2;
                                str3 = str11;
                            } catch (IOException e7) {
                                z3 = z2;
                                try {
                                    str3 = str11;
                                    try {
                                        zzj4.zzu.zzaW().zze().zzd("Failed to merge filter results. appId, audienceId, error", zzhe.zzn(str12), Integer.valueOf(i3), e7);
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        zzj4.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str12), e);
                                        Map emptyMap3 = Collections.emptyMap();
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        map2 = emptyMap3;
                                        str4 = str2;
                                        if (!map2.isEmpty()) {
                                        }
                                        String str13 = str3;
                                        zzad zzadVar = null;
                                        String str14 = "Skipping failed audience ID";
                                        if (!list.isEmpty()) {
                                        }
                                        String str15 = str13;
                                        if (!z) {
                                        }
                                    }
                                } catch (SQLiteException e9) {
                                    e = e9;
                                    str3 = str11;
                                    zzj4.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str12), e);
                                    Map emptyMap32 = Collections.emptyMap();
                                    if (cursor3 != null) {
                                    }
                                    map2 = emptyMap32;
                                    str4 = str2;
                                    if (!map2.isEmpty()) {
                                    }
                                    String str132 = str3;
                                    zzad zzadVar2 = null;
                                    String str142 = "Skipping failed audience ID";
                                    if (!list.isEmpty()) {
                                    }
                                    String str152 = str132;
                                    if (!z) {
                                    }
                                }
                            }
                            if (!cursor3.moveToNext()) {
                                break;
                            }
                            z2 = z3;
                            str11 = str3;
                            i2 = 0;
                        }
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        map2 = arrayMap2;
                        str4 = "audience_filter_values";
                    }
                    if (!map2.isEmpty()) {
                        HashSet hashSet2 = new HashSet(map2.keySet());
                        if (z3) {
                            String str16 = this.zza;
                            zzaw zzj6 = this.zzg.zzj();
                            String str17 = this.zza;
                            zzj6.zzav();
                            zzj6.zzg();
                            Preconditions.checkNotEmpty(str17);
                            Map arrayMap3 = new ArrayMap();
                            try {
                                hashSet = hashSet2;
                            } catch (Throwable th3) {
                                th = th3;
                                r5 = hashSet2;
                            }
                            try {
                                int i4 = 0;
                                cursor4 = zzj6.zzj().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str17, str17});
                                try {
                                    if (cursor4.moveToFirst()) {
                                        while (true) {
                                            Integer valueOf2 = Integer.valueOf(cursor4.getInt(i4));
                                            List list8 = (List) arrayMap3.get(valueOf2);
                                            if (list8 == null) {
                                                list8 = new ArrayList();
                                                arrayMap3.put(valueOf2, list8);
                                            }
                                            list8.add(Integer.valueOf(cursor4.getInt(1)));
                                            if (!cursor4.moveToNext()) {
                                                break;
                                            }
                                            i4 = 0;
                                        }
                                    } else {
                                        arrayMap3 = Collections.emptyMap();
                                    }
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    zzj6.zzu.zzaW().zze().zzc("Database error querying scoped filters. appId", zzhe.zzn(str17), e);
                                    arrayMap3 = Collections.emptyMap();
                                }
                            } catch (SQLiteException e11) {
                                e = e11;
                                cursor4 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                r5 = 0;
                                if (r5 != 0) {
                                    r5.close();
                                }
                                throw th;
                            }
                        } else {
                            hashSet = hashSet2;
                            map3 = map2;
                        }
                        Iterator it6 = hashSet.iterator();
                        while (it6.hasNext()) {
                            int intValue = ((Integer) it6.next()).intValue();
                            com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) map3.get(Integer.valueOf(intValue));
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            ArrayMap arrayMap4 = new ArrayMap();
                            if (zzicVar != null && zzicVar.zza() != 0) {
                                for (com.google.android.gms.internal.measurement.zzhk zzhkVar : zzicVar.zzh()) {
                                    if (zzhkVar.zzh()) {
                                        arrayMap4.put(Integer.valueOf(zzhkVar.zza()), zzhkVar.zzg() ? Long.valueOf(zzhkVar.zzb()) : null);
                                    }
                                }
                            }
                            ArrayMap arrayMap5 = new ArrayMap();
                            if (zzicVar != null && zzicVar.zzc() != 0) {
                                for (com.google.android.gms.internal.measurement.zzie zzieVar : zzicVar.zzj()) {
                                    if (zzieVar.zzi() && zzieVar.zza() > 0) {
                                        arrayMap5.put(Integer.valueOf(zzieVar.zzb()), Long.valueOf(zzieVar.zzc(zzieVar.zza() - 1)));
                                        map3 = map3;
                                        zzicVar = zzicVar;
                                    }
                                }
                            }
                            Map map6 = map3;
                            com.google.android.gms.internal.measurement.zzic zzicVar2 = zzicVar;
                            if (zzicVar2 != null) {
                                int i5 = 0;
                                while (i5 < zzicVar2.zzd() * 64) {
                                    if (zzqa.zzy(zzicVar2.zzk(), i5)) {
                                        z4 = zzx;
                                        this.zzu.zzaW().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i5));
                                        bitSet2.set(i5);
                                        if (zzqa.zzy(zzicVar2.zzi(), i5)) {
                                            bitSet.set(i5);
                                            i5++;
                                            zzx = z4;
                                        }
                                    } else {
                                        z4 = zzx;
                                    }
                                    arrayMap4.remove(Integer.valueOf(i5));
                                    i5++;
                                    zzx = z4;
                                }
                            }
                            boolean z7 = zzx;
                            Integer valueOf3 = Integer.valueOf(intValue);
                            com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) map2.get(valueOf3);
                            if (zzx2 && z7 && (list3 = (List) map.get(valueOf3)) != null && this.zze != null && this.zzd != null) {
                                for (com.google.android.gms.internal.measurement.zzfj zzfjVar2 : list3) {
                                    int zzb = zzfjVar2.zzb();
                                    long longValue = this.zze.longValue() / 1000;
                                    if (zzfjVar2.zzm()) {
                                        longValue = this.zzd.longValue() / 1000;
                                    }
                                    Integer valueOf4 = Integer.valueOf(zzb);
                                    if (arrayMap4.containsKey(valueOf4)) {
                                        arrayMap4.put(valueOf4, Long.valueOf(longValue));
                                    }
                                    if (arrayMap5.containsKey(valueOf4)) {
                                        arrayMap5.put(valueOf4, Long.valueOf(longValue));
                                    }
                                }
                            }
                            this.zzc.put(Integer.valueOf(intValue), new zzy(this, this.zza, zzicVar3, bitSet, bitSet2, arrayMap4, arrayMap5, null));
                            zzx = z7;
                            map3 = map6;
                        }
                    }
                    String str1322 = str3;
                    zzad zzadVar22 = null;
                    String str1422 = "Skipping failed audience ID";
                    if (!list.isEmpty()) {
                        zzz zzzVar2 = new zzz(this, zzadVar22);
                        ArrayMap arrayMap6 = new ArrayMap();
                        Iterator it7 = list.iterator();
                        while (it7.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it7.next();
                            com.google.android.gms.internal.measurement.zzhm zza = zzzVar2.zza(this.zza, zzhmVar);
                            if (zza != null) {
                                zzpv zzpvVar = this.zzg;
                                zzbd zzr = zzpvVar.zzj().zzr(this.zza, zzhmVar, zza.zzh());
                                zzpvVar.zzj().zzV(zzr);
                                if (z) {
                                    continue;
                                } else {
                                    long j2 = zzr.zzc;
                                    String zzh = zza.zzh();
                                    Map map7 = (Map) arrayMap6.get(zzh);
                                    if (map7 == null) {
                                        zzaw zzj7 = zzpvVar.zzj();
                                        String str18 = this.zza;
                                        zzj7.zzav();
                                        zzj7.zzg();
                                        Preconditions.checkNotEmpty(str18);
                                        Preconditions.checkNotEmpty(zzh);
                                        ArrayMap arrayMap7 = new ArrayMap();
                                        SQLiteDatabase zzj8 = zzj7.zzj();
                                        zzzVar = zzzVar2;
                                        try {
                                            try {
                                                String[] strArr3 = new String[2];
                                                str5 = str1322;
                                                try {
                                                    strArr3[0] = str5;
                                                    it = it7;
                                                    try {
                                                        strArr3[1] = "data";
                                                        Cursor query = zzj8.query("event_filters", strArr3, "app_id=? AND event_name=?", new String[]{str18, zzh}, null, null, null);
                                                        try {
                                                            try {
                                                                if (query.moveToFirst()) {
                                                                    zzbdVar = zzr;
                                                                    int i6 = 1;
                                                                    r18 = str4;
                                                                    while (true) {
                                                                        try {
                                                                            try {
                                                                                com.google.android.gms.internal.measurement.zzfj zzfjVar3 = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), query.getBlob(i6))).zzba();
                                                                                Integer valueOf5 = Integer.valueOf(query.getInt(0));
                                                                                List list9 = (List) arrayMap7.get(valueOf5);
                                                                                if (list9 == null) {
                                                                                    r18 = query;
                                                                                    try {
                                                                                        list4 = new ArrayList();
                                                                                        arrayMap7.put(valueOf5, list4);
                                                                                        cursor6 = r18;
                                                                                    } catch (SQLiteException e12) {
                                                                                        e = e12;
                                                                                        cursor5 = r18;
                                                                                        str6 = r18;
                                                                                        try {
                                                                                            zzj7.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str18), e);
                                                                                            map7 = Collections.emptyMap();
                                                                                            str7 = str6;
                                                                                            if (cursor5 != null) {
                                                                                            }
                                                                                            arrayMap6.put(zzh, map7);
                                                                                            str4 = str7;
                                                                                            it2 = map7.keySet().iterator();
                                                                                            while (it2.hasNext()) {
                                                                                            }
                                                                                            it7 = it;
                                                                                            str1322 = str5;
                                                                                            zzzVar2 = zzzVar;
                                                                                        } catch (Throwable th5) {
                                                                                            th = th5;
                                                                                            if (cursor5 != null) {
                                                                                                cursor5.close();
                                                                                            }
                                                                                            throw th;
                                                                                        }
                                                                                    } catch (Throwable th6) {
                                                                                        th = th6;
                                                                                        cursor5 = r18;
                                                                                        if (cursor5 != null) {
                                                                                        }
                                                                                        throw th;
                                                                                    }
                                                                                } else {
                                                                                    cursor6 = query;
                                                                                    list4 = list9;
                                                                                }
                                                                                list4.add(zzfjVar3);
                                                                                r18 = cursor6;
                                                                            } catch (IOException e13) {
                                                                                r18 = query;
                                                                                zzj7.zzu.zzaW().zze().zzc("Failed to merge filter. appId", zzhe.zzn(str18), e13);
                                                                            }
                                                                            if (!r18.moveToNext()) {
                                                                                break;
                                                                            }
                                                                            query = r18;
                                                                            i6 = 1;
                                                                            r18 = r18;
                                                                        } catch (SQLiteException e14) {
                                                                            e = e14;
                                                                            r18 = query;
                                                                        }
                                                                    }
                                                                    if (r18 != 0) {
                                                                        r18.close();
                                                                    }
                                                                    map7 = arrayMap7;
                                                                    str7 = r18;
                                                                } else {
                                                                    ?? r182 = query;
                                                                    zzbdVar = zzr;
                                                                    map7 = Collections.emptyMap();
                                                                    str7 = r182;
                                                                    if (r182 != 0) {
                                                                        r182.close();
                                                                        str7 = r182;
                                                                    }
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                r18 = query;
                                                            }
                                                        } catch (SQLiteException e15) {
                                                            e = e15;
                                                            r18 = query;
                                                            zzbdVar = zzr;
                                                        }
                                                    } catch (SQLiteException e16) {
                                                        e = e16;
                                                        zzbdVar = zzr;
                                                        cursor5 = null;
                                                        str6 = str4;
                                                        zzj7.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str18), e);
                                                        map7 = Collections.emptyMap();
                                                        str7 = str6;
                                                        if (cursor5 != null) {
                                                            cursor5.close();
                                                            str7 = str6;
                                                        }
                                                        arrayMap6.put(zzh, map7);
                                                        str4 = str7;
                                                        it2 = map7.keySet().iterator();
                                                        while (it2.hasNext()) {
                                                        }
                                                        it7 = it;
                                                        str1322 = str5;
                                                        zzzVar2 = zzzVar;
                                                    }
                                                } catch (SQLiteException e17) {
                                                    e = e17;
                                                    it = it7;
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                cursor5 = null;
                                            }
                                        } catch (SQLiteException e18) {
                                            e = e18;
                                            it = it7;
                                            zzbdVar = zzr;
                                            str5 = str1322;
                                        }
                                        arrayMap6.put(zzh, map7);
                                        str4 = str7;
                                    } else {
                                        zzzVar = zzzVar2;
                                        it = it7;
                                        zzbdVar = zzr;
                                        str5 = str1322;
                                        str4 = str4;
                                    }
                                    it2 = map7.keySet().iterator();
                                    while (it2.hasNext()) {
                                        int intValue2 = ((Integer) it2.next()).intValue();
                                        Set set = this.zzb;
                                        Integer valueOf6 = Integer.valueOf(intValue2);
                                        if (set.contains(valueOf6)) {
                                            this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", valueOf6);
                                        } else {
                                            Iterator it8 = ((List) map7.get(valueOf6)).iterator();
                                            boolean z8 = true;
                                            String str19 = str4;
                                            while (true) {
                                                if (!it8.hasNext()) {
                                                    map4 = map7;
                                                    j = j2;
                                                    str4 = str19;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzfj zzfjVar4 = (com.google.android.gms.internal.measurement.zzfj) it8.next();
                                                ?? zzaaVar = new zzaa(this, this.zza, intValue2, zzfjVar4);
                                                map4 = map7;
                                                j = j2;
                                                ?? r183 = this.zzd;
                                                z8 = zzaaVar.zzd(r183, this.zze, zza, j, zzbdVar, zzf(intValue2, zzfjVar4.zzb()));
                                                if (!z8) {
                                                    this.zzb.add(Integer.valueOf(intValue2));
                                                    str4 = r183;
                                                    break;
                                                }
                                                zzd(Integer.valueOf(intValue2)).zzc(zzaaVar);
                                                j2 = j;
                                                map7 = map4;
                                                str19 = r183;
                                            }
                                            if (!z8) {
                                                this.zzb.add(Integer.valueOf(intValue2));
                                            }
                                            j2 = j;
                                            map7 = map4;
                                        }
                                    }
                                    it7 = it;
                                    str1322 = str5;
                                    zzzVar2 = zzzVar;
                                }
                            }
                        }
                    }
                    String str1522 = str1322;
                    if (!z) {
                        return new ArrayList();
                    }
                    if (!list2.isEmpty()) {
                        ArrayMap arrayMap8 = new ArrayMap();
                        Iterator it9 = list2.iterator();
                        while (it9.hasNext()) {
                            com.google.android.gms.internal.measurement.zzio zzioVar3 = (com.google.android.gms.internal.measurement.zzio) it9.next();
                            String zzg = zzioVar3.zzg();
                            Map map8 = (Map) arrayMap8.get(zzg);
                            if (map8 == null) {
                                zzaw zzj9 = this.zzg.zzj();
                                String str20 = this.zza;
                                zzj9.zzav();
                                zzj9.zzg();
                                Preconditions.checkNotEmpty(str20);
                                Preconditions.checkNotEmpty(zzg);
                                ArrayMap arrayMap9 = new ArrayMap();
                                try {
                                    int i7 = 1;
                                    Cursor query2 = zzj9.zzj().query("property_filters", new String[]{str1522, "data"}, "app_id=? AND property_name=?", new String[]{str20, zzg}, null, null, null);
                                    try {
                                        try {
                                            if (query2.moveToFirst()) {
                                                while (true) {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzfr zzfrVar2 = (com.google.android.gms.internal.measurement.zzfr) ((com.google.android.gms.internal.measurement.zzfq) zzqa.zzp(com.google.android.gms.internal.measurement.zzfr.zzc(), query2.getBlob(i7))).zzba();
                                                        Integer valueOf7 = Integer.valueOf(query2.getInt(0));
                                                        List list10 = (List) arrayMap9.get(valueOf7);
                                                        if (list10 == null) {
                                                            list5 = new ArrayList();
                                                            arrayMap9.put(valueOf7, list5);
                                                        } else {
                                                            list5 = list10;
                                                        }
                                                        list5.add(zzfrVar2);
                                                        it3 = it9;
                                                    } catch (IOException e19) {
                                                        it3 = it9;
                                                        try {
                                                            zzj9.zzu.zzaW().zze().zzc("Failed to merge filter", zzhe.zzn(str20), e19);
                                                        } catch (SQLiteException e20) {
                                                            e = e20;
                                                            cursor7 = query2;
                                                            try {
                                                                zzj9.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str20), e);
                                                                map8 = Collections.emptyMap();
                                                                if (cursor7 != null) {
                                                                    cursor7.close();
                                                                }
                                                                arrayMap8.put(zzg, map8);
                                                                it4 = map8.keySet().iterator();
                                                                while (true) {
                                                                    if (!it4.hasNext()) {
                                                                        break;
                                                                    }
                                                                    map8 = map5;
                                                                    str1422 = str8;
                                                                }
                                                                it9 = it3;
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                if (cursor7 != null) {
                                                                    cursor7.close();
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                    }
                                                    if (!query2.moveToNext()) {
                                                        break;
                                                    }
                                                    it9 = it3;
                                                    i7 = 1;
                                                }
                                                if (query2 != null) {
                                                    query2.close();
                                                }
                                                map8 = arrayMap9;
                                            } else {
                                                it3 = it9;
                                                map8 = Collections.emptyMap();
                                                if (query2 != null) {
                                                    query2.close();
                                                }
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            cursor7 = query2;
                                            if (cursor7 != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e21) {
                                        e = e21;
                                        it3 = it9;
                                    }
                                } catch (SQLiteException e22) {
                                    e = e22;
                                    it3 = it9;
                                    cursor7 = null;
                                } catch (Throwable th11) {
                                    th = th11;
                                    cursor7 = null;
                                }
                                arrayMap8.put(zzg, map8);
                            } else {
                                it3 = it9;
                            }
                            it4 = map8.keySet().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    int intValue3 = ((Integer) it4.next()).intValue();
                                    Set set2 = this.zzb;
                                    Integer valueOf8 = Integer.valueOf(intValue3);
                                    if (set2.contains(valueOf8)) {
                                        this.zzu.zzaW().zzj().zzb(str1422, valueOf8);
                                        break;
                                    }
                                    Iterator it10 = ((List) map8.get(valueOf8)).iterator();
                                    boolean z9 = true;
                                    while (true) {
                                        if (!it10.hasNext()) {
                                            map5 = map8;
                                            str8 = str1422;
                                            break;
                                        }
                                        zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it10.next();
                                        zzioVar = this.zzu;
                                        if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                            map5 = map8;
                                            str8 = str1422;
                                            zzioVar.zzaW().zzj().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue3), zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null, zzioVar.zzj().zzf(zzfrVar.zze()));
                                            zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().zzs(zzfrVar));
                                        } else {
                                            map5 = map8;
                                            str8 = str1422;
                                        }
                                        if (!zzfrVar.zzj() || zzfrVar.zza() > 256) {
                                            break;
                                        }
                                        zzac zzacVar = new zzac(this, this.zza, intValue3, zzfrVar);
                                        z9 = zzacVar.zzd(this.zzd, this.zze, zzioVar3, zzf(intValue3, zzfrVar.zza()));
                                        if (!z9) {
                                            this.zzb.add(Integer.valueOf(intValue3));
                                            break;
                                        }
                                        zzd(Integer.valueOf(intValue3)).zzc(zzacVar);
                                        map8 = map5;
                                        str1422 = str8;
                                    }
                                    zzioVar.zzaW().zzk().zzc("Invalid property filter ID. appId, id", zzhe.zzn(this.zza), String.valueOf(zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null));
                                    this.zzb.add(Integer.valueOf(intValue3));
                                    map8 = map5;
                                    str1422 = str8;
                                }
                            }
                            it9 = it3;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    Set keySet = this.zzc.keySet();
                    keySet.removeAll(this.zzb);
                    Iterator it11 = keySet.iterator();
                    while (it11.hasNext()) {
                        int intValue4 = ((Integer) it11.next()).intValue();
                        Map map9 = this.zzc;
                        Integer valueOf9 = Integer.valueOf(intValue4);
                        zzy zzyVar = (zzy) map9.get(valueOf9);
                        Preconditions.checkNotNull(zzyVar);
                        com.google.android.gms.internal.measurement.zzhi zza2 = zzyVar.zza(intValue4);
                        arrayList.add(zza2);
                        zzaw zzj10 = this.zzg.zzj();
                        String str21 = this.zza;
                        com.google.android.gms.internal.measurement.zzic zzd = zza2.zzd();
                        zzj10.zzav();
                        zzj10.zzg();
                        Preconditions.checkNotEmpty(str21);
                        Preconditions.checkNotNull(zzd);
                        byte[] zzcd = zzd.zzcd();
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(MBridgeConstans.APP_ID, str21);
                        contentValues2.put(str1522, valueOf9);
                        contentValues2.put("current_results", zzcd);
                        try {
                            try {
                                if (zzj10.zzj().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                    zzj10.zzu.zzaW().zze().zzb("Failed to insert filter results (got -1). appId", zzhe.zzn(str21));
                                }
                            } catch (SQLiteException e23) {
                                e = e23;
                                zzj10.zzu.zzaW().zze().zzc("Error storing filter results. appId", zzhe.zzn(str21), e);
                            }
                        } catch (SQLiteException e24) {
                            e = e24;
                        }
                    }
                    return arrayList;
                }
                emptyMap = Collections.emptyMap();
                cursor = r7;
                l4 = 1;
                l3 = null;
                cursor8 = r7;
                l6 = 1;
                l5 = null;
            } else {
                l3 = null;
                l4 = 1;
                cursor = "app_id = ?";
            }
            str2 = "audience_filter_values";
            String[] strArr4 = new String[2];
            strArr4[r41] = "audience_id";
            strArr4[i] = "current_results";
            String[] strArr22 = new String[i];
            strArr22[r41] = str12;
            cursor3 = zzj5.query("audience_filter_values", strArr4, "app_id=?", strArr22, null, null, null);
            if (cursor3.moveToFirst()) {
            }
            if (!map2.isEmpty()) {
            }
            String str13222 = str3;
            zzad zzadVar222 = null;
            String str14222 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            String str15222 = str13222;
            if (!z) {
            }
        } catch (Throwable th12) {
            th = th12;
            Cursor cursor9 = cursor2;
            if (cursor9 != null) {
                cursor9.close();
            }
            throw th;
        }
        map = emptyMap;
        cursor2 = cursor;
        i = l4;
        r41 = l3;
        zzaw zzj42 = this.zzg.zzj();
        String str122 = this.zza;
        zzj42.zzav();
        zzj42.zzg();
        Preconditions.checkNotEmpty(str122);
        SQLiteDatabase zzj52 = zzj42.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }
}
