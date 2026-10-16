package io.adn.sdk.internal.data.repository;

import android.os.Build;
import kotlin.Metadata;

/* compiled from: DeviceMetricsRepositoryImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"isPowerManagerApiAvailable", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DeviceMetricsRepositoryImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPowerManagerApiAvailable() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
