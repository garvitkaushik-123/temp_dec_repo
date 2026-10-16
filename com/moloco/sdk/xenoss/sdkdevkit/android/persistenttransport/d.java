package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import io.ktor.http.ContentType;

/* loaded from: classes6.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d dVar, String str, byte[] bArr, ContentType contentType, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPost");
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            dVar.a(str, bArr, contentType, str2);
        }
    }

    void a(String str);

    void a(String str, byte[] bArr, ContentType contentType, String str2);
}
