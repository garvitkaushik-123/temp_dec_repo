package com.vungle.ads.internal.network;

import com.ironsource.N6;
import com.mbridge.msdk.foundation.entity.b;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* compiled from: VungleApi.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&JL\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H&J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H&J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0019"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApi;", "", b.JSON_KEY_ADS, "Lcom/vungle/ads/internal/network/Call;", "Lcom/vungle/ads/internal/model/AdPayload;", N6.d0, "", "path", "body", "Lcom/vungle/ads/internal/model/CommonRequestBody;", "config", "Lcom/vungle/ads/internal/model/ConfigPayload;", "pingTPAT", "Ljava/lang/Void;", "url", "requestType", "Lcom/vungle/ads/internal/network/HttpMethod;", "headers", "", "requestBody", "Lokhttp3/RequestBody;", "ri", "sendAdMarkup", "sendErrors", "sendMetrics", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface VungleApi {
    Call<AdPayload> ads(String ua, String path, CommonRequestBody body);

    Call<ConfigPayload> config(String ua, String path, CommonRequestBody body);

    Call<Void> pingTPAT(String ua, String url, HttpMethod requestType, Map<String, String> headers, RequestBody requestBody);

    Call<Void> ri(String ua, String path, CommonRequestBody body);

    Call<Void> sendAdMarkup(String path, RequestBody requestBody);

    Call<Void> sendErrors(String ua, String path, RequestBody requestBody);

    Call<Void> sendMetrics(String ua, String path, RequestBody requestBody);

    /* compiled from: VungleApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call pingTPAT$default(VungleApi vungleApi, String str, String str2, HttpMethod httpMethod, Map map, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pingTPAT");
            }
            if ((i & 4) != 0) {
                httpMethod = HttpMethod.GET;
            }
            return vungleApi.pingTPAT(str, str2, httpMethod, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : requestBody);
        }
    }
}
