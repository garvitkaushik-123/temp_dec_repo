package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbot {
    private static final Charset zzc = Charset.forName("UTF-8");
    public static final zzboq zza = new zzbos();
    public static final zzboo zzb = new zzboo() { // from class: com.google.android.gms.internal.ads.zzbor
        @Override // com.google.android.gms.internal.ads.zzboo
        public final Object zza(JSONObject jSONObject) {
            return zzbot.zza(jSONObject);
        }
    };

    static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
