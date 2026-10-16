package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdq extends zzcdn {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcdq(zzccb zzccbVar) {
        super(zzccbVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfqt.zza(zzfqs.zza(), cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String valueOf = String.valueOf(this.zzg.getAbsolutePath());
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not create preload cache directory at ".concat(valueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String valueOf2 = String.valueOf(this.zzg.getAbsolutePath());
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not set cache file permissions at ".concat(valueOf2));
        this.zzg = null;
    }

    private final File zza(File file) {
        return new File(zzfqt.zza(zzfqs.zza(), this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x031d, code lost:
    
        r22 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x031f, code lost:
    
        r22.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0327, code lost:
    
        if (com.google.android.gms.ads.internal.util.zze.zzm(3) == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0329, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzo.zze("Preloaded " + r14.format(r6) + " bytes from " + r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x034a, code lost:
    
        r9.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0353, code lost:
    
        if (r10.isFile() == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0355, code lost:
    
        r10.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x035d, code lost:
    
        r10.createNewFile();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03bc  */
    @Override // com.google.android.gms.internal.ads.zzcdn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzt(final String str) {
        int i;
        File file;
        String concat;
        String str2;
        String str3;
        String str4;
        FileOutputStream fileOutputStream;
        int i2;
        ByteBuffer byteBuffer;
        int i3;
        int i4;
        boolean z;
        FileOutputStream fileOutputStream2 = null;
        if (this.zzg == null) {
            zzg(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file2 = this.zzg;
            if (file2 == null) {
                i = 0;
            } else {
                i = 0;
                for (File file3 : file2.listFiles()) {
                    if (!file3.getName().endsWith(".done")) {
                        i++;
                    }
                }
            }
            if (i > ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzs)).intValue()) {
                File file4 = this.zzg;
                if (file4 == null) {
                    break;
                }
                long j = Long.MAX_VALUE;
                File file5 = null;
                for (File file6 : file4.listFiles()) {
                    if (!file6.getName().endsWith(".done")) {
                        long lastModified = file6.lastModified();
                        if (lastModified < j) {
                            file5 = file6;
                            j = lastModified;
                        }
                    }
                }
                if (file5 != null) {
                    z = file5.delete();
                    File zza = zza(file5);
                    if (zza.isFile()) {
                        z &= zza.delete();
                    }
                } else {
                    z = false;
                }
            } else {
                file = new File(zzfqt.zza(zzfqs.zza(), this.zzg, com.google.android.gms.ads.internal.util.client.zzf.zzk(str)));
                File zza2 = zza(file);
                if (file.isFile() && zza2.isFile()) {
                    int length = (int) file.length();
                    String valueOf = String.valueOf(str);
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Stream cache hit at ".concat(valueOf));
                    zzh(str, file.getAbsolutePath(), length);
                    return true;
                }
                String valueOf2 = String.valueOf(this.zzg.getAbsolutePath());
                String valueOf3 = String.valueOf(str);
                Set set = zze;
                concat = valueOf2.concat(valueOf3);
                synchronized (set) {
                    if (set.contains(concat)) {
                        int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache already in progress at " + str);
                        zzg(str, file.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    set.add(concat);
                    str2 = "error";
                    try {
                        HttpURLConnection zzn = zzfrr.zza().zzn(new zzfrq() { // from class: com.google.android.gms.internal.ads.zzcdp
                            @Override // com.google.android.gms.internal.ads.zzfrq
                            public final URLConnection zza() {
                                int i7 = zzcdq.zzd;
                                com.google.android.gms.ads.internal.zzv.zzy();
                                int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzR)).intValue();
                                URL url = new URL(str);
                                int i8 = 0;
                                while (true) {
                                    i8++;
                                    if (i8 > 20) {
                                        throw new IOException("Too many redirects (20)");
                                    }
                                    int i9 = zzfra.zzb;
                                    URLConnection openConnection = url.openConnection();
                                    openConnection.setConnectTimeout(intValue);
                                    openConnection.setReadTimeout(intValue);
                                    if (!(openConnection instanceof HttpURLConnection)) {
                                        throw new IOException("Invalid protocol.");
                                    }
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                                    com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                                    zzlVar.zzc(httpURLConnection, null);
                                    httpURLConnection.setInstanceFollowRedirects(false);
                                    int responseCode = httpURLConnection.getResponseCode();
                                    zzlVar.zze(httpURLConnection, responseCode);
                                    if (responseCode / 100 != 3) {
                                        return httpURLConnection;
                                    }
                                    String headerField = httpURLConnection.getHeaderField("Location");
                                    if (headerField == null) {
                                        throw new IOException("Missing Location header in redirect");
                                    }
                                    URL url2 = new URL(url, headerField);
                                    String protocol = url2.getProtocol();
                                    if (protocol == null) {
                                        throw new IOException("Protocol is null");
                                    }
                                    if (!protocol.equals("http") && !protocol.equals("https")) {
                                        throw new IOException("Unsupported scheme: ".concat(protocol));
                                    }
                                    String concat2 = "Redirecting to ".concat(headerField);
                                    int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zze(concat2);
                                    httpURLConnection.disconnect();
                                    url = url2;
                                }
                            }
                        }, 265, -1);
                        if (zzn instanceof HttpURLConnection) {
                            HttpURLConnection httpURLConnection = zzn;
                            int responseCode = zzn.getResponseCode();
                            if (responseCode >= 400) {
                                str2 = "badUrl";
                                try {
                                    str4 = "HTTP request failed. Code: " + Integer.toString(responseCode);
                                } catch (IOException | RuntimeException e) {
                                    e = e;
                                    str4 = null;
                                }
                                try {
                                    throw new IOException("HTTP status code " + responseCode + " at " + str);
                                } catch (IOException e2) {
                                    e = e2;
                                    str3 = concat;
                                    if (e instanceof RuntimeException) {
                                    }
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException | NullPointerException unused) {
                                    }
                                    if (this.zzh) {
                                    }
                                    if (file.exists()) {
                                    }
                                    zzg(str, file.getAbsolutePath(), str2, str4);
                                    zze.remove(str3);
                                    return false;
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    str3 = concat;
                                    if (e instanceof RuntimeException) {
                                    }
                                    fileOutputStream2.close();
                                    if (this.zzh) {
                                    }
                                    if (file.exists()) {
                                    }
                                    zzg(str, file.getAbsolutePath(), str2, str4);
                                    zze.remove(str3);
                                    return false;
                                }
                            }
                        }
                        int contentLength = zzn.getContentLength();
                        if (contentLength < 0) {
                            int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache aborted, missing content-length header at " + str);
                            zzg(str, file.getAbsolutePath(), "contentLengthMissing", null);
                            set.remove(concat);
                            return false;
                        }
                        DecimalFormat decimalFormat = zzf;
                        String format = decimalFormat.format(contentLength);
                        int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzt)).intValue();
                        if (contentLength > intValue) {
                            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Content length " + format + " exceeds limit at " + str);
                            zzg(str, file.getAbsolutePath(), "sizeExceeded", "File too big for full file cache. Size: " + format);
                            set.remove(concat);
                            return false;
                        }
                        int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zze("Caching " + format + " bytes from " + str);
                        ReadableByteChannel newChannel = Channels.newChannel(zzn.getInputStream());
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            FileChannel channel = fileOutputStream3.getChannel();
                            ByteBuffer allocate = ByteBuffer.allocate(1048576);
                            Clock zzD = com.google.android.gms.ads.internal.zzv.zzD();
                            long currentTimeMillis = zzD.currentTimeMillis();
                            try {
                                com.google.android.gms.ads.internal.util.zzbx zzbxVar = new com.google.android.gms.ads.internal.util.zzbx(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzQ)).longValue());
                                long longValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzP)).longValue();
                                i2 = 0;
                                while (true) {
                                    int read = newChannel.read(allocate);
                                    if (read < 0) {
                                        break;
                                    }
                                    int i10 = i2 + read;
                                    try {
                                        try {
                                            if (i10 > intValue) {
                                                String str5 = "File too big for full file cache. Size: " + Integer.toString(i10);
                                                throw new IOException("stream cache file size limit exceeded");
                                            }
                                            allocate.flip();
                                            while (channel.write(allocate) > 0) {
                                            }
                                            allocate.clear();
                                            if (zzD.currentTimeMillis() - currentTimeMillis > 1000 * longValue) {
                                                String str6 = "Timeout exceeded. Limit: " + Long.toString(longValue) + " sec";
                                                throw new IOException("stream cache time limit exceeded");
                                            }
                                            FileChannel fileChannel = channel;
                                            if (this.zzh) {
                                                throw new IOException("abort requested");
                                            }
                                            if (zzbxVar.zzb()) {
                                                fileOutputStream = fileOutputStream3;
                                                try {
                                                    try {
                                                        byteBuffer = allocate;
                                                        i3 = i10;
                                                        i4 = intValue;
                                                        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzcdh(this, str, file.getAbsolutePath(), i3, contentLength, false));
                                                    } catch (RuntimeException e4) {
                                                        e = e4;
                                                        str3 = concat;
                                                        fileOutputStream2 = fileOutputStream;
                                                        str4 = null;
                                                        if (e instanceof RuntimeException) {
                                                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "VideoStreamFullFileCache.preload");
                                                        }
                                                        fileOutputStream2.close();
                                                        if (this.zzh) {
                                                            int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                                                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Preload aborted for URL \"" + str + "\"");
                                                        } else {
                                                            int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                                                            com.google.android.gms.ads.internal.util.client.zzo.zzk("Preload failed for URL \"" + str + "\"", e);
                                                        }
                                                        if (file.exists() && !file.delete()) {
                                                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file.getAbsolutePath())));
                                                        }
                                                        zzg(str, file.getAbsolutePath(), str2, str4);
                                                        zze.remove(str3);
                                                        return false;
                                                    }
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    str3 = concat;
                                                    fileOutputStream2 = fileOutputStream;
                                                    str4 = null;
                                                    if (e instanceof RuntimeException) {
                                                    }
                                                    fileOutputStream2.close();
                                                    if (this.zzh) {
                                                    }
                                                    if (file.exists()) {
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not delete partial cache file at ".concat(String.valueOf(file.getAbsolutePath())));
                                                    }
                                                    zzg(str, file.getAbsolutePath(), str2, str4);
                                                    zze.remove(str3);
                                                    return false;
                                                }
                                            } else {
                                                fileOutputStream = fileOutputStream3;
                                                byteBuffer = allocate;
                                                i3 = i10;
                                                i4 = intValue;
                                            }
                                            i2 = i3;
                                            channel = fileChannel;
                                            fileOutputStream3 = fileOutputStream;
                                            intValue = i4;
                                            allocate = byteBuffer;
                                        } catch (IOException e6) {
                                            e = e6;
                                            str3 = concat;
                                            fileOutputStream2 = fileOutputStream;
                                            str4 = null;
                                            if (e instanceof RuntimeException) {
                                            }
                                            fileOutputStream2.close();
                                            if (this.zzh) {
                                            }
                                            if (file.exists()) {
                                            }
                                            zzg(str, file.getAbsolutePath(), str2, str4);
                                            zze.remove(str3);
                                            return false;
                                        } catch (RuntimeException e7) {
                                            e = e7;
                                            str3 = concat;
                                            fileOutputStream2 = fileOutputStream;
                                            str4 = null;
                                            if (e instanceof RuntimeException) {
                                            }
                                            fileOutputStream2.close();
                                            if (this.zzh) {
                                            }
                                            if (file.exists()) {
                                            }
                                            zzg(str, file.getAbsolutePath(), str2, str4);
                                            zze.remove(str3);
                                            return false;
                                        }
                                    } catch (IOException | RuntimeException e8) {
                                        e = e8;
                                        str4 = newChannel;
                                        str3 = concat;
                                        fileOutputStream2 = fileOutputStream;
                                        if (e instanceof RuntimeException) {
                                        }
                                        fileOutputStream2.close();
                                        if (this.zzh) {
                                        }
                                        if (file.exists()) {
                                        }
                                        zzg(str, file.getAbsolutePath(), str2, str4);
                                        zze.remove(str3);
                                        return false;
                                    }
                                }
                            } catch (IOException | RuntimeException e9) {
                                e = e9;
                                fileOutputStream = fileOutputStream3;
                            }
                        } catch (IOException | RuntimeException e10) {
                            e = e10;
                            fileOutputStream = fileOutputStream3;
                            str3 = concat;
                        }
                    } catch (IOException | RuntimeException e11) {
                        e = e11;
                        str3 = concat;
                        str4 = null;
                        fileOutputStream2 = null;
                    }
                }
            }
        } while (z);
        int i13 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to expire stream cache");
        zzg(str, null, "expireFailed", null);
        return false;
        zzh(str, file.getAbsolutePath(), i2);
        str3 = concat;
        try {
            zze.remove(str3);
            return true;
        } catch (IOException e12) {
            e = e12;
            fileOutputStream2 = fileOutputStream;
            str4 = null;
            if (e instanceof RuntimeException) {
            }
            fileOutputStream2.close();
            if (this.zzh) {
            }
            if (file.exists()) {
            }
            zzg(str, file.getAbsolutePath(), str2, str4);
            zze.remove(str3);
            return false;
        } catch (RuntimeException e13) {
            e = e13;
            fileOutputStream2 = fileOutputStream;
            str4 = null;
            if (e instanceof RuntimeException) {
            }
            fileOutputStream2.close();
            if (this.zzh) {
            }
            if (file.exists()) {
            }
            zzg(str, file.getAbsolutePath(), str2, str4);
            zze.remove(str3);
            return false;
        }
    }
}
