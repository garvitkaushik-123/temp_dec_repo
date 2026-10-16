package com.unity3d.ads.core.data.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidStaticDeviceInfoDataSource.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource", f = "AndroidStaticDeviceInfoDataSource.kt", i = {0, 0}, l = {99}, m = "fetch", n = {"this", "additionalStores"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class AndroidStaticDeviceInfoDataSource$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidStaticDeviceInfoDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidStaticDeviceInfoDataSource$fetch$1(AndroidStaticDeviceInfoDataSource androidStaticDeviceInfoDataSource, Continuation<? super AndroidStaticDeviceInfoDataSource$fetch$1> continuation) {
        super(continuation);
        this.this$0 = androidStaticDeviceInfoDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch(null, this);
    }
}
