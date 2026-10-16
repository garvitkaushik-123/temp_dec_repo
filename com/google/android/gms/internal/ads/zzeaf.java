package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeaf implements zzfge {
    protected final Context zza;
    protected final String zzb;

    public zzeaf(Context context, String str, zzbvy zzbvyVar, int i) {
        this.zza = context;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfge
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzeae zza(zzead zzeadVar) throws zzdwm {
        return zzc(zzeadVar.zza, zzeadVar.zzb, zzeadVar.zzc, zzeadVar.zzd, zzeadVar.zze, com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime());
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f7, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Received error HTTP response code: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x021d, code lost:
    
        throw new com.google.android.gms.internal.ads.zzdwm(1, "Received error HTTP response code: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0241, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final zzeae zzc(String str, int i, Map map, byte[] bArr, String str2, long j) throws zzdwm {
        URL url;
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        try {
            zzeae zzeaeVar = new zzeae();
            String str3 = this.zzb;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("SDK version: " + str3);
            com.google.android.gms.ads.internal.util.client.zzo.zze("AdRequestServiceImpl: Sending request: " + str);
            URL url2 = new URL(str);
            HashMap hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                int i4 = zzfra.zzb;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    try {
                        com.google.android.gms.ads.internal.zzv.zzr().zzg(this.zza, str3, false, httpURLConnection, false, i);
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            httpURLConnection.setRequestProperty("Content-Type", str2);
                        }
                        BufferedOutputStream bufferedOutputStream2 = null;
                        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                        try {
                            zzlVar.zzc(httpURLConnection, bArr);
                        } catch (Throwable th) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Network request logging failed.", th);
                            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "HttpRequestFunction.logAdRequest");
                        }
                        int length = bArr.length;
                        if (length > 0) {
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                bufferedOutputStream.write(bArr);
                                IOUtils.closeQuietly(bufferedOutputStream);
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream2 = bufferedOutputStream;
                                IOUtils.closeQuietly(bufferedOutputStream2);
                                throw th;
                            }
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (hashMap.containsKey(key)) {
                                ((List) hashMap.get(key)).addAll(value);
                            } else {
                                hashMap.put(key, new ArrayList(value));
                            }
                        }
                        zzlVar.zze(httpURLConnection, responseCode);
                        zzeaeVar.zza = responseCode;
                        zzeaeVar.zzb = hashMap;
                        zzeaeVar.zzc = "";
                        if (responseCode >= 200 && responseCode < 300) {
                            try {
                                InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                                try {
                                    com.google.android.gms.ads.internal.zzv.zzr();
                                    StringBuilder sb = new StringBuilder(8192);
                                    char[] cArr = new char[2048];
                                    while (true) {
                                        int read = inputStreamReader2.read(cArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        sb.append(cArr, 0, read);
                                    }
                                    String sb2 = sb.toString();
                                    IOUtils.closeQuietly(inputStreamReader2);
                                    zzlVar.zzg(sb2);
                                    zzeaeVar.zzc = sb2;
                                    if (TextUtils.isEmpty(sb2)) {
                                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfP)).booleanValue()) {
                                            throw new zzdwm(3);
                                        }
                                    }
                                    zzeaeVar.zzd = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - j;
                                } catch (Throwable th4) {
                                    th = th4;
                                    inputStreamReader = inputStreamReader2;
                                    IOUtils.closeQuietly(inputStreamReader);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                inputStreamReader = null;
                            }
                        } else {
                            if (responseCode < 300 || responseCode >= 400) {
                                break;
                            }
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (TextUtils.isEmpty(headerField)) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("No location header to follow redirect.");
                                throw new zzdwm(1, "No location header to follow redirect");
                            }
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzig)).booleanValue()) {
                                try {
                                    url = new URI(headerField).toURL();
                                } catch (URISyntaxException e) {
                                    throw new zzdwm(1, e.getMessage(), e);
                                }
                            } else {
                                url = new URL(headerField);
                            }
                            int i5 = i3 + 1;
                            if (i5 > ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfy)).intValue()) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Too many redirects.");
                                throw new zzdwm(1, "Too many redirects");
                            }
                            i3 = i5;
                            url2 = url;
                        }
                    } catch (zzdwm e2) {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziI)).booleanValue()) {
                            throw e2;
                        }
                        zzeaeVar.zzd = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - j;
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            }
        } catch (IOException e3) {
            String valueOf = String.valueOf(e3.getMessage());
            int i6 = com.google.android.gms.ads.internal.util.zze.zza;
            String concat = "Error while connecting to ad server: ".concat(valueOf);
            com.google.android.gms.ads.internal.util.client.zzo.zzj(concat);
            throw new zzdwm(1, concat, e3);
        }
    }
}
