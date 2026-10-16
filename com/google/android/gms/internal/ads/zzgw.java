package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgw extends zzgc implements zzhe {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzhd zze;
    private final zzhd zzf;
    private zzgo zzg;
    private HttpURLConnection zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;

    /* synthetic */ zzgw(String str, int i, int i2, boolean z, boolean z2, zzhd zzhdVar, zzfvq zzfvqVar, boolean z3, zzgv zzgvVar) {
        super(true);
        this.zzd = str;
        this.zzb = i;
        this.zzc = i2;
        this.zza = z;
        this.zze = zzhdVar;
        this.zzf = new zzhd();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final HttpURLConnection zzk(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        String sb;
        String str;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzb);
        httpURLConnection.setReadTimeout(this.zzc);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.zze.zza());
        hashMap.putAll(this.zzf.zza());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j == 0) {
            if (j2 == -1) {
                sb = null;
                if (sb != null) {
                    httpURLConnection.setRequestProperty("Range", sb);
                }
                str = this.zzd;
                if (str != null) {
                    httpURLConnection.setRequestProperty("User-Agent", str);
                }
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, true == z ? "identity" : "gzip");
                httpURLConnection.setInstanceFollowRedirects(z2);
                httpURLConnection.setDoOutput(false);
                int i2 = zzgo.zzh;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                return httpURLConnection;
            }
            j = 0;
        }
        StringBuilder sb2 = new StringBuilder("bytes=");
        sb2.append(j);
        sb2.append("-");
        if (j2 != -1) {
            sb2.append((j + j2) - 1);
        }
        sb = sb2.toString();
        if (sb != null) {
        }
        str = this.zzd;
        if (str != null) {
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, true == z ? "identity" : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(false);
        int i22 = zzgo.zzh;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, String str, zzgo zzgoVar) throws zzha {
        if (str == null) {
            throw new zzha("Null location redirect", zzgoVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new zzha("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgoVar, 2001, 1);
            }
            if (this.zza || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new zzha("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", zzgoVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new zzha(e, zzgoVar, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzea.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws zzha {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            if (j != -1) {
                long j2 = j - this.zzm;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j2);
            }
            InputStream inputStream = this.zzi;
            String str = zzex.zza;
            InputStream inputStream2 = inputStream;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.zzm += read;
            zzg(read);
            return read;
        } catch (IOException e) {
            zzgo zzgoVar = this.zzg;
            String str2 = zzex.zza;
            throw zzha.zza(e, zzgoVar, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a9, code lost:
    
        if (r10 == r16) goto L40;
     */
    @Override // com.google.android.gms.internal.ads.zzgj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzb(zzgo zzgoVar) throws zzha {
        zzgw zzgwVar;
        int i;
        long j;
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        long j2;
        zzgw zzgwVar2 = this;
        zzgwVar2.zzg = zzgoVar;
        long j3 = 0;
        zzgwVar2.zzm = 0L;
        zzgwVar2.zzl = 0L;
        zzi(zzgoVar);
        try {
            URL url = new URL(zzgoVar.zza.toString());
            int i2 = zzgoVar.zzb;
            byte[] bArr2 = zzgoVar.zzc;
            long j4 = zzgoVar.zze;
            long j5 = zzgoVar.zzf;
            boolean zzb = zzgoVar.zzb(1);
            int i3 = 0;
            try {
                if (zzgwVar2.zza) {
                    i = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i3 > 20) {
                            throw new zzha(new NoRouteToHostException("Too many redirects: " + i4), zzgoVar, 2001, 1);
                        }
                        j = j3;
                        zzgwVar2 = this;
                        HttpURLConnection zzk = zzgwVar2.zzk(url, 1, null, j4, j5, zzb, false, zzgoVar.zzd);
                        URL url2 = url;
                        long j6 = j5;
                        zzgwVar = zzgwVar2;
                        try {
                            int responseCode = zzk.getResponseCode();
                            String headerField = zzk.getHeaderField("Location");
                            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                                httpURLConnection = zzk;
                                break;
                            }
                            zzk.disconnect();
                            URL zzl = zzgwVar.zzl(url2, headerField, zzgoVar);
                            j5 = j6;
                            url = zzl;
                            i3 = i4;
                            j3 = j;
                        } catch (IOException e) {
                            e = e;
                            zzgwVar.zzm();
                            throw zzha.zza(e, zzgoVar, 1);
                        }
                    }
                } else {
                    i = 0;
                    httpURLConnection = zzgwVar2.zzk(url, 1, null, j4, j5, zzb, true, zzgoVar.zzd);
                    zzgwVar = this;
                    j = 0;
                }
                zzgwVar.zzh = httpURLConnection;
                zzgwVar.zzk = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                int i5 = zzgwVar.zzk;
                if (i5 < 200 || i5 > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (zzgwVar.zzk == 416) {
                        if (zzgoVar.zze == zzhf.zzb(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                            zzgwVar.zzj = true;
                            zzj(zzgoVar);
                            long j7 = zzgoVar.zzf;
                            return j7 != -1 ? j7 : j;
                        }
                    }
                    InputStream errorStream = httpURLConnection.getErrorStream();
                    try {
                        bArr = errorStream != null ? zzgbg.zzb(errorStream) : zzex.zzb;
                    } catch (IOException unused) {
                        bArr = zzex.zzb;
                    }
                    zzgwVar.zzm();
                    throw new zzhc(zzgwVar.zzk, responseMessage, zzgwVar.zzk == 416 ? new zzgk(2008) : null, headerFields, zzgoVar, bArr);
                }
                httpURLConnection.getContentType();
                if (zzgwVar.zzk == 200) {
                    j2 = zzgoVar.zze;
                }
                j2 = j;
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                if (equalsIgnoreCase) {
                    zzgwVar.zzl = zzgoVar.zzf;
                } else {
                    long j8 = zzgoVar.zzf;
                    if (j8 != -1) {
                        zzgwVar.zzl = j8;
                    } else {
                        long zza = zzhf.zza(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        zzgwVar.zzl = zza != -1 ? zza - j2 : -1L;
                    }
                }
                try {
                    zzgwVar.zzi = httpURLConnection.getInputStream();
                    if (equalsIgnoreCase) {
                        zzgwVar.zzi = new GZIPInputStream(zzgwVar.zzi);
                    }
                    zzgwVar.zzj = true;
                    zzj(zzgoVar);
                    if (j2 != j) {
                        try {
                            byte[] bArr3 = new byte[4096];
                            while (j2 > j) {
                                int min = (int) Math.min(j2, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                                InputStream inputStream = zzgwVar.zzi;
                                String str = zzex.zza;
                                InputStream inputStream2 = inputStream;
                                int read = inputStream.read(bArr3, i, min);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new zzha(new InterruptedIOException(), zzgoVar, 2000, 1);
                                }
                                if (read == -1) {
                                    throw new zzha(zzgoVar, 2008, 1);
                                }
                                j2 -= read;
                                zzgwVar.zzg(read);
                            }
                        } catch (IOException e2) {
                            zzgwVar.zzm();
                            if (e2 instanceof zzha) {
                                throw ((zzha) e2);
                            }
                            throw new zzha(e2, zzgoVar, 2000, 1);
                        }
                    }
                    return zzgwVar.zzl;
                } catch (IOException e3) {
                    zzgwVar.zzm();
                    throw new zzha(e3, zzgoVar, 2000, 1);
                }
            } catch (IOException e4) {
                e = e4;
                zzgwVar = this;
            }
        } catch (IOException e5) {
            e = e5;
            zzgwVar = zzgwVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        zzgo zzgoVar = this.zzg;
        if (zzgoVar != null) {
            return zzgoVar.zza;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() throws zzha {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zzgo zzgoVar = this.zzg;
                    String str = zzex.zza;
                    zzgo zzgoVar2 = zzgoVar;
                    throw new zzha(e, zzgoVar, 2000, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
            this.zzh = null;
            this.zzg = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgc, com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        return httpURLConnection == null ? zzfyt.zzd() : new zzgu(httpURLConnection.getHeaderFields());
    }
}
