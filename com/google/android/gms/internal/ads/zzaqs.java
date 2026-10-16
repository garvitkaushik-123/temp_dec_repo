package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzaqs implements zzapw {
    protected final zzaqu zza;
    private final zzaqr zzb;

    public zzaqs(zzaqr zzaqrVar) {
        zzaqu zzaquVar = new zzaqu(4096);
        this.zzb = zzaqrVar;
        this.zza = zzaquVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapw
    public zzapz zza(zzaqd zzaqdVar) throws zzaqm {
        zzarb zzarbVar;
        byte[] bArr;
        zzarf zzarfVar;
        zzarf zzarfVar2;
        int zzb;
        String str;
        zzaqm zzaqmVar;
        String str2;
        Map map;
        byte[] bArr2;
        byte[] bArr3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                zzapm zzd = zzaqdVar.zzd();
                if (zzd == null) {
                    map = Collections.emptyMap();
                } else {
                    HashMap hashMap = new HashMap();
                    String str3 = zzd.zzb;
                    if (str3 != null) {
                        hashMap.put(HttpHeaders.IF_NONE_MATCH, str3);
                    }
                    long j = zzd.zzd;
                    if (j > 0) {
                        hashMap.put(HttpHeaders.IF_MODIFIED_SINCE, zzara.zzc(j));
                    }
                    map = hashMap;
                }
                zzarbVar = this.zzb.zza(zzaqdVar, map);
                try {
                    int zzb2 = zzarbVar.zzb();
                    List zzd2 = zzarbVar.zzd();
                    if (zzb2 == 304) {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        zzapm zzd3 = zzaqdVar.zzd();
                        if (zzd3 == null) {
                            return new zzapz(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, (byte[]) null, true, elapsedRealtime2, zzd2);
                        }
                        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                        if (!zzd2.isEmpty()) {
                            Iterator it = zzd2.iterator();
                            while (it.hasNext()) {
                                treeSet.add(((zzapv) it.next()).zza());
                            }
                        }
                        ArrayList arrayList = new ArrayList(zzd2);
                        List list = zzd3.zzh;
                        if (list != null) {
                            if (!list.isEmpty()) {
                                for (zzapv zzapvVar : zzd3.zzh) {
                                    if (!treeSet.contains(zzapvVar.zza())) {
                                        arrayList.add(zzapvVar);
                                    }
                                }
                            }
                        } else if (!zzd3.zzg.isEmpty()) {
                            for (Map.Entry entry : zzd3.zzg.entrySet()) {
                                if (!treeSet.contains(entry.getKey())) {
                                    arrayList.add(new zzapv((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                        }
                        return new zzapz(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, zzd3.zza, true, elapsedRealtime2, (List) arrayList);
                    }
                    InputStream zzc = zzarbVar.zzc();
                    if (zzc != null) {
                        int zza = zzarbVar.zza();
                        zzaqu zzaquVar = this.zza;
                        zzarh zzarhVar = new zzarh(zzaquVar, zza);
                        try {
                            bArr3 = zzaquVar.zzb(1024);
                            while (true) {
                                try {
                                    int read = zzc.read(bArr3);
                                    if (read == -1) {
                                        break;
                                    }
                                    zzarhVar.write(bArr3, 0, read);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        zzc.close();
                                        break;
                                    } catch (IOException unused) {
                                        zzaqp.zzd("Error occurred when closing InputStream", new Object[0]);
                                    }
                                    zzaquVar.zza(bArr3);
                                    zzarhVar.close();
                                    throw th;
                                }
                            }
                            bArr2 = zzarhVar.toByteArray();
                            try {
                                zzc.close();
                            } catch (IOException unused2) {
                                zzaqp.zzd("Error occurred when closing InputStream", new Object[0]);
                            }
                            zzaquVar.zza(bArr3);
                            zzarhVar.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bArr3 = null;
                        }
                    } else {
                        bArr2 = new byte[0];
                    }
                    bArr = bArr2;
                    try {
                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (zzaqp.zzb || elapsedRealtime3 > 3000) {
                            zzaqp.zza("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", zzaqdVar, Long.valueOf(elapsedRealtime3), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(zzb2), Integer.valueOf(zzaqdVar.zzy().zza()));
                        }
                        if (zzb2 < 200 || zzb2 > 299) {
                            throw new IOException();
                        }
                        return new zzapz(zzb2, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, zzd2);
                    } catch (IOException e) {
                        e = e;
                        if (e instanceof SocketTimeoutException) {
                            zzarfVar = new zzarf("socket", new zzaql(), null);
                        } else {
                            if (e instanceof MalformedURLException) {
                                throw new RuntimeException("Bad URL ".concat(String.valueOf(zzaqdVar.zzk())), e);
                            }
                            if (zzarbVar == null) {
                                throw new zzaqa(e);
                            }
                            int zzb3 = zzarbVar.zzb();
                            zzaqp.zzb("Unexpected response code %d for %s", Integer.valueOf(zzb3), zzaqdVar.zzk());
                            if (bArr != null) {
                                zzapz zzapzVar = new zzapz(zzb3, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, zzarbVar.zzd());
                                if (zzb3 != 401 && zzb3 != 403) {
                                    if (zzb3 < 400 || zzb3 > 499) {
                                        throw new zzaqk(zzapzVar);
                                    }
                                    throw new zzapq(zzapzVar);
                                }
                                zzarfVar = new zzarf("auth", new zzapl(zzapzVar), null);
                            } else {
                                zzarfVar = new zzarf("network", new zzapy(), null);
                            }
                        }
                        zzarfVar2 = zzarfVar;
                        zzapr zzy = zzaqdVar.zzy();
                        zzb = zzaqdVar.zzb();
                        try {
                            zzaqmVar = zzarfVar2.zzb;
                            zzy.zzc(zzaqmVar);
                            str2 = zzarfVar2.zza;
                            zzaqdVar.zzm(String.format("%s-retry [timeout=%s]", str2, Integer.valueOf(zzb)));
                        } catch (zzaqm e2) {
                            str = zzarfVar2.zza;
                            zzaqdVar.zzm(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzb)));
                            throw e2;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                }
            } catch (IOException e4) {
                e = e4;
                zzarbVar = null;
                bArr = null;
            }
            str2 = zzarfVar2.zza;
            zzaqdVar.zzm(String.format("%s-retry [timeout=%s]", str2, Integer.valueOf(zzb)));
        }
    }
}
