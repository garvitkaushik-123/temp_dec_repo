package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzfra;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzu implements zze {
    private final Context zza;
    private final String zzb;
    private String zzc;

    public zzu(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    private final URL zzc(String str) throws MalformedURLException {
        URL url = null;
        try {
            url = new URI(str).toURL();
        } catch (IllegalArgumentException e) {
            e = e;
            zze(str, e);
        } catch (MalformedURLException e2) {
            e = e2;
            zze(str, e);
        } catch (URISyntaxException e3) {
            zze(str, e3);
            if (((Boolean) zzbd.zzc().zzb(zzbde.zze)).booleanValue()) {
                url = zzd(str);
            }
        }
        if (url != null) {
            return url;
        }
        zzo.zze("Falling back to direct new URL(\"" + str + "\") constructor.");
        return new URL(str);
    }

    private final URL zzd(String str) {
        URL url;
        try {
            zzo.zze("Attempting to parse components, encode, and reconstruct URI.");
            URL url2 = new URL(str);
            URI uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
            url = uri.toURL();
            try {
                zzo.zze("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"" + str + "\" -> encoded URI: " + uri.toString());
                return url;
            } catch (IllegalArgumentException e) {
                e = e;
                zze(str, e);
                return url;
            } catch (MalformedURLException e2) {
                e = e2;
                zze(str, e);
                return url;
            } catch (URISyntaxException e3) {
                e = e3;
                zze(str, e);
                return url;
            }
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException e4) {
            e = e4;
            url = null;
        }
    }

    private final void zze(String str, Throwable th) {
        zzo.zzj("Error while parsing ping URL: " + str + ". " + th.getMessage());
        zzbun.zza(this.zza).zzi(th, "HttpUrlPinger.pingUrl", ((float) ((Integer) zzbd.zzc().zzb(zzbde.zznf)).intValue()) / 100.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00da, code lost:
    
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[RETURN] */
    @Override // com.google.android.gms.ads.internal.util.client.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzt zza(String str) {
        HttpURLConnection httpURLConnection;
        int responseCode;
        zzt zztVar;
        zzt zztVar2 = zzt.PERMANENT_FAILURE;
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                zzo.zze("Pinging URL: " + str);
                URL zzc = zzc(str);
                int i = zzfra.zzb;
                httpURLConnection = (HttpURLConnection) zzc.openConnection();
                try {
                    zzbb.zzb();
                    String str2 = this.zzb;
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setReadTimeout(60000);
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("User-Agent", str2);
                    }
                    httpURLConnection.setUseCaches(false);
                    zzl zzlVar = new zzl(null);
                    zzlVar.zzc(httpURLConnection, null);
                    responseCode = httpURLConnection.getResponseCode();
                    zzlVar.zze(httpURLConnection, responseCode);
                } finally {
                    httpURLConnection.disconnect();
                }
            } finally {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e = e;
            zze(str, e);
        } catch (MalformedURLException e2) {
            e = e2;
            zze(str, e);
        } catch (IOException e3) {
            e = e3;
            zzo.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
            zztVar2 = zzt.RETRIABLE_FAILURE;
        } catch (RuntimeException e4) {
            e = e4;
            zzo.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
            zztVar2 = zzt.RETRIABLE_FAILURE;
        }
        if (responseCode >= 200 && responseCode < 300) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzii)).booleanValue()) {
                this.zzc = httpURLConnection.getHeaderField("X-Afma-Ad-Event-Value");
            }
            zztVar = zzt.SUCCESS;
            zztVar2 = zztVar;
            if (!ClientLibraryUtils.isPackageSide()) {
                return zztVar2;
            }
            return zztVar2;
        }
        zzo.zzj("Received non-success response code " + responseCode + " from pinging URL: " + str);
        if (responseCode == 502) {
            zztVar = zzt.RETRIABLE_FAILURE;
            zztVar2 = zztVar;
        }
        if (!ClientLibraryUtils.isPackageSide()) {
        }
        return zztVar2;
    }

    public final String zzb() {
        return this.zzc;
    }
}
