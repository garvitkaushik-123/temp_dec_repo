package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.D5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSourceInputStream;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes6.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #1 {all -> 0x004d, blocks: (B:11:0x0045, B:18:0x0051, B:20:0x0057, B:24:0x0069, B:28:0x0077, B:31:0x005d), top: B:10:0x0045, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[LOOP:1: B:9:0x002d->B:26:0x0071, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] executePost(HttpDataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws IOException {
        int i;
        boolean z;
        String redirectUrl;
        HttpDataSource createDataSource = factory.createDataSource();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                createDataSource.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        String str2 = str;
        int i2 = 0;
        while (true) {
            DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(createDataSource, new DataSpec(Uri.parse(str2), bArr, 0L, 0L, -1L, null, 1));
            try {
                try {
                    return Util.toByteArray(dataSourceInputStream);
                } catch (HttpDataSource.InvalidResponseCodeException e) {
                    if (e.responseCode == 307 || e.responseCode == 308) {
                        i = i2 + 1;
                        if (i2 < 5) {
                            z = true;
                            redirectUrl = !z ? getRedirectUrl(e) : null;
                            if (redirectUrl != null) {
                                throw e;
                            }
                            Util.closeQuietly(dataSourceInputStream);
                            str2 = redirectUrl;
                            i2 = i;
                        } else {
                            i2 = i;
                        }
                    }
                    i = i2;
                    z = false;
                    if (!z) {
                    }
                    if (redirectUrl != null) {
                    }
                }
            } finally {
                Util.closeQuietly(dataSourceInputStream);
            }
        }
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException) {
        List<String> list;
        Map<String, List<String>> map = invalidResponseCodeException.headerFields;
        if (map == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest, String str) throws Exception {
        String defaultUrl = keyRequest.getDefaultUrl();
        if (!TextUtils.isEmpty(defaultUrl)) {
            str = defaultUrl;
        }
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(str)) {
            str = this.defaultLicenseUrl;
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = C.PLAYREADY_UUID;
        hashMap.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : C.CLEARKEY_UUID.equals(uuid) ? D5.L : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            hashMap.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, str, keyRequest.getData(), hashMap);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        return executePost(this.dataSourceFactory, provisionRequest.getDefaultUrl() + "&signedRequest=" + Util.fromUtf8Bytes(provisionRequest.getData()), new byte[0], null);
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(String str, boolean z, HttpDataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z;
        this.keyRequestProperties = new HashMap();
    }
}
