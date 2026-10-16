package com.inmobi.media;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import com.inmobi.commons.core.configs.AdConfig;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.inmobi.media.ia, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2699ia {
    public static final void a(AdConfig.OmidConfig omidConfig, int i, N9 mRequest, int i2) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(omidConfig, "$omidConfig");
        Intrinsics.checkNotNullParameter(mRequest, "$mNetworkRequest");
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        if ((System.currentTimeMillis() / 1000) - new Sa(d, "omid_js_store").b() > omidConfig.getExpiry()) {
            int i3 = 0;
            while (i3 <= i) {
                Intrinsics.checkNotNullExpressionValue("ia", "TAG");
                Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                P9 b = mRequest.b();
                Context d2 = Uc.d();
                if (b.b()) {
                    Intrinsics.checkNotNullExpressionValue("ia", "TAG");
                    i3++;
                    if (i3 > i) {
                        return;
                    } else {
                        try {
                            Thread.sleep(i2 * 1000);
                        } catch (InterruptedException unused) {
                        }
                    }
                } else if (d2 != null) {
                    Sa sa = new Sa(d2, "omid_js_store");
                    Map map = b.f;
                    String str = null;
                    List list = map != null ? (List) map.get(HttpHeaders.CONTENT_ENCODING) : null;
                    if (Intrinsics.areEqual(list != null ? (String) list.get(0) : null, "gzip")) {
                        Intrinsics.checkNotNullExpressionValue("ia", "TAG");
                        boolean z = T9.f2439a;
                        byte[] bArr2 = b.b;
                        if (bArr2 == null || bArr2.length == 0) {
                            bArr = new byte[0];
                        } else {
                            Intrinsics.checkNotNull(bArr2);
                            bArr = new byte[bArr2.length];
                            byte[] bArr3 = b.b;
                            Intrinsics.checkNotNull(bArr3);
                            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
                        }
                        byte[] a2 = T9.a(bArr);
                        if (a2 != null) {
                            try {
                                String str2 = new String(a2, Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue("ia", "TAG");
                                str = str2;
                            } catch (UnsupportedEncodingException unused2) {
                                Intrinsics.checkNotNullExpressionValue("ia", "TAG");
                            }
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue("ia", "TAG");
                        str = b.a();
                    }
                    if (str != null) {
                        sa.b("omid_js_string", str);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void a(final AdConfig.OmidConfig omidConfig) {
        Intrinsics.checkNotNullParameter(omidConfig, "omidConfig");
        String url = omidConfig.getUrl();
        final int maxRetries = omidConfig.getMaxRetries();
        final int retryInterval = omidConfig.getRetryInterval();
        if (url == null) {
            Intrinsics.checkNotNullExpressionValue("ia", "TAG");
            return;
        }
        final N9 n9 = new N9(url, null);
        n9.x = false;
        n9.t = false;
        n9.u = false;
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).submit(new Runnable() { // from class: com.inmobi.media.ia$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2699ia.a(AdConfig.OmidConfig.this, maxRetries, n9, retryInterval);
            }
        });
    }
}
