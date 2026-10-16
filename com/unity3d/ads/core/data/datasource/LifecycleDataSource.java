package com.unity3d.ads.core.data.datasource;

import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: LifecycleDataSource.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/LifecycleDataSource;", "", "appActive", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAppActive", "()Lkotlinx/coroutines/flow/StateFlow;", "appIsForeground", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface LifecycleDataSource {
    boolean appIsForeground();

    StateFlow<Boolean> getAppActive();
}
