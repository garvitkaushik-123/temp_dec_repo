package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcdy extends zzgc implements zzhe {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzhd zzg;
    private zzgo zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    zzcdy(String str, zzhj zzhjVar, int i, int i2, int i3) {
        super(true);
        this.zzc = new zzcdx(this);
        this.zzr = new HashSet();
        zzdd.zzc(str);
        this.zzf = str;
        this.zzg = new zzhd();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzhjVar != null) {
            zzf(zzhjVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0105, code lost:
    
        if (r2 == r16) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x023d A[Catch: IOException -> 0x028c, TryCatch #4 {IOException -> 0x028c, blocks: (B:3:0x000e, B:4:0x0026, B:6:0x002c, B:8:0x0036, B:9:0x0043, B:10:0x005b, B:12:0x0061, B:19:0x0085, B:21:0x009f, B:22:0x00b1, B:23:0x00b6, B:25:0x00bf, B:26:0x00c6, B:40:0x00ed, B:102:0x0232, B:104:0x023d, B:106:0x024e, B:112:0x0257, B:113:0x0266, B:116:0x026d, B:117:0x0274, B:121:0x0275, B:122:0x028b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf A[Catch: IOException -> 0x028c, TryCatch #4 {IOException -> 0x028c, blocks: (B:3:0x000e, B:4:0x0026, B:6:0x002c, B:8:0x0036, B:9:0x0043, B:10:0x005b, B:12:0x0061, B:19:0x0085, B:21:0x009f, B:22:0x00b1, B:23:0x00b6, B:25:0x00bf, B:26:0x00c6, B:40:0x00ed, B:102:0x0232, B:104:0x023d, B:106:0x024e, B:112:0x0257, B:113:0x0266, B:116:0x026d, B:117:0x0274, B:121:0x0275, B:122:0x028b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzb(zzgo zzgoVar) throws zzha {
        long j;
        long j2;
        int responseCode;
        String headerField;
        int responseCode2;
        long j3;
        long parseLong;
        String headerField2;
        this.zzh = zzgoVar;
        long j4 = 0;
        this.zzp = 0L;
        this.zzo = 0L;
        try {
            URL url = new URL(zzgoVar.zza.toString());
            byte[] bArr = zzgoVar.zzc;
            long j5 = zzgoVar.zze;
            long j6 = zzgoVar.zzf;
            boolean zzb2 = zzgoVar.zzb(1);
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i > 20) {
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection instanceof HttpsURLConnection) {
                    j = j4;
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.zzc);
                } else {
                    j = j4;
                }
                httpURLConnection.setConnectTimeout(this.zzd);
                httpURLConnection.setReadTimeout(this.zze);
                for (Map.Entry entry : this.zzg.zza().entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (j5 == j) {
                    if (j6 != -1) {
                        j2 = j;
                    }
                    httpURLConnection.setRequestProperty("User-Agent", this.zzf);
                    if (!zzb2) {
                        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        this.zzi = httpURLConnection;
                        try {
                            responseCode2 = httpURLConnection.getResponseCode();
                            this.zzl = responseCode2;
                            if (responseCode2 >= 200 || responseCode2 > 299) {
                                Map<String, List<String>> headerFields = this.zzi.getHeaderFields();
                                zzn();
                                zzhc zzhcVar = new zzhc(this.zzl, null, null, headerFields, zzgoVar, zzex.zzb);
                                if (this.zzl == 416) {
                                    throw zzhcVar;
                                }
                                zzhcVar.initCause(new zzgk(2008));
                                throw zzhcVar;
                            }
                            if (responseCode2 == 200) {
                                j3 = zzgoVar.zze;
                            }
                            j3 = j;
                            this.zzm = j3;
                            if (zzgoVar.zzb(1)) {
                                this.zzn = zzgoVar.zzf;
                            } else {
                                long j7 = zzgoVar.zzf;
                                if (j7 != -1) {
                                    this.zzn = j7;
                                } else {
                                    HttpURLConnection httpURLConnection2 = this.zzi;
                                    String headerField3 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                                    if (!TextUtils.isEmpty(headerField3)) {
                                        try {
                                            parseLong = Long.parseLong(headerField3);
                                        } catch (NumberFormatException unused) {
                                            String str = "Unexpected Content-Length [" + headerField3 + C3040d4.i.e;
                                            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzg(str);
                                        }
                                        headerField2 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_RANGE);
                                        if (!TextUtils.isEmpty(headerField2)) {
                                            Matcher matcher = zza.matcher(headerField2);
                                            if (matcher.find()) {
                                                try {
                                                    long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                                    if (parseLong < j) {
                                                        parseLong = parseLong2;
                                                    } else if (parseLong != parseLong2) {
                                                        String str2 = "Inconsistent headers [" + headerField3 + "] [" + headerField2 + C3040d4.i.e;
                                                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzj(str2);
                                                        parseLong = Math.max(parseLong, parseLong2);
                                                    }
                                                } catch (NumberFormatException unused2) {
                                                    String str3 = "Unexpected Content-Range [" + headerField2 + C3040d4.i.e;
                                                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzg(str3);
                                                }
                                            }
                                        }
                                        this.zzn = parseLong != -1 ? parseLong - this.zzm : -1L;
                                    }
                                    parseLong = -1;
                                    headerField2 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_RANGE);
                                    if (!TextUtils.isEmpty(headerField2)) {
                                    }
                                    this.zzn = parseLong != -1 ? parseLong - this.zzm : -1L;
                                }
                            }
                            try {
                                this.zzj = this.zzi.getInputStream();
                                this.zzk = true;
                                zzj(zzgoVar);
                                return this.zzn;
                            } catch (IOException e) {
                                zzn();
                                throw new zzha(e, zzgoVar, 2000, 1);
                            }
                        } catch (IOException e2) {
                            zzn();
                            throw new zzha("Unable to connect to ".concat(String.valueOf(zzgoVar.zza.toString())), e2, zzgoVar, 2000, 1);
                        }
                    }
                    headerField = httpURLConnection.getHeaderField("Location");
                    httpURLConnection.disconnect();
                    if (headerField != null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    URL url2 = new URL(url, headerField);
                    String protocol = url2.getProtocol();
                    if (!"https".equals(protocol) && !"http".equals(protocol)) {
                        throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                    }
                    url = url2;
                    i = i2;
                    j4 = j;
                } else {
                    j2 = j5;
                }
                String str4 = "bytes=" + j2 + "-";
                if (j6 != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append((j2 + j6) - 1);
                    str4 = sb.toString();
                }
                httpURLConnection.setRequestProperty("Range", str4);
                httpURLConnection.setRequestProperty("User-Agent", this.zzf);
                if (!zzb2) {
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 300) {
                    this.zzi = httpURLConnection;
                    responseCode2 = httpURLConnection.getResponseCode();
                    this.zzl = responseCode2;
                    if (responseCode2 >= 200) {
                    }
                    Map<String, List<String>> headerFields2 = this.zzi.getHeaderFields();
                    zzn();
                    zzhc zzhcVar2 = new zzhc(this.zzl, null, null, headerFields2, zzgoVar, zzex.zzb);
                    if (this.zzl == 416) {
                    }
                }
                headerField = httpURLConnection.getHeaderField("Location");
                httpURLConnection.disconnect();
                if (headerField != null) {
                }
            }
        } catch (IOException e3) {
            throw new zzha("Unable to connect to ".concat(String.valueOf(zzgoVar.zza.toString())), e3, zzgoVar, 2000, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() throws zzha {
        try {
            if (this.zzj != null) {
                String str = zzex.zza;
                try {
                    this.zzj.close();
                } catch (IOException e) {
                    throw new zzha(e, this.zzh, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgc, com.google.android.gms.internal.ads.zzgj
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final void zzm(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws zzha {
        try {
            if (this.zzo != this.zzm) {
                AtomicReference atomicReference = zzb;
                byte[] bArr2 = (byte[]) atomicReference.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        atomicReference.set(bArr2);
                        break;
                    }
                    int read = this.zzj.read(bArr2, 0, (int) Math.min(j2 - j, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.zzo += read;
                    zzg(read);
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j4);
            }
            int read2 = this.zzj.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.zzn == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzp += read2;
            zzg(read2);
            return read2;
        } catch (IOException e) {
            throw new zzha(e, this.zzh, 2000, 2);
        }
    }
}
