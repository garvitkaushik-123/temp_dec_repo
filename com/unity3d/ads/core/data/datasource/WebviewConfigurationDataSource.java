package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.DataStore;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: WebviewConfigurationDataSource.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/WebviewConfigurationDataSource;", "", "webviewConfigurationStore", "Landroidx/datastore/core/DataStore;", "Lcom/unity3d/ads/datastore/WebviewConfigurationStore$WebViewConfigurationStore;", "(Landroidx/datastore/core/DataStore;)V", "get", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "set", "", "data", "(Lcom/unity3d/ads/datastore/WebviewConfigurationStore$WebViewConfigurationStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class WebviewConfigurationDataSource {
    private final DataStore<WebviewConfigurationStore.WebViewConfigurationStore> webviewConfigurationStore;

    public WebviewConfigurationDataSource(DataStore<WebviewConfigurationStore.WebViewConfigurationStore> webviewConfigurationStore) {
        Intrinsics.checkNotNullParameter(webviewConfigurationStore, "webviewConfigurationStore");
        this.webviewConfigurationStore = webviewConfigurationStore;
    }

    public final Object get(Continuation<? super WebviewConfigurationStore.WebViewConfigurationStore> continuation) {
        return FlowKt.first(FlowKt.m11782catch(this.webviewConfigurationStore.getData(), new WebviewConfigurationDataSource$get$2(null)), continuation);
    }

    public final Object set(WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore, Continuation<? super Unit> continuation) {
        Object updateData = this.webviewConfigurationStore.updateData(new WebviewConfigurationDataSource$set$2(webViewConfigurationStore, null), continuation);
        return updateData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateData : Unit.INSTANCE;
    }
}
