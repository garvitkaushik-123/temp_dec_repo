package io.adn.sdk.internal.data.api.local;

import com.ironsource.C3040d4;
import kotlin.Metadata;

/* compiled from: AppInfoApi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/data/api/local/AppInfoApi;", "", C3040d4.i.W, "", "getAppVersion", "()Ljava/lang/String;", "appBundleId", "getAppBundleId", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AppInfoApi {
    String getAppBundleId();

    String getAppVersion();
}
