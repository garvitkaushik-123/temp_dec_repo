package com.unity3d.ads.core.data.datasource;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.ironsource.V5;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidRemoteCacheDataSource.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource", f = "AndroidRemoteCacheDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {57, 65}, m = "getFile", n = {"this", "cachePath", V5.c.b, "url", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, V5.c.b, "url", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, C3337ue.n, "extension", C3040d4.h.b}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes7.dex */
final class AndroidRemoteCacheDataSource$getFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidRemoteCacheDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidRemoteCacheDataSource$getFile$1(AndroidRemoteCacheDataSource androidRemoteCacheDataSource, Continuation<? super AndroidRemoteCacheDataSource$getFile$1> continuation) {
        super(continuation);
        this.this$0 = androidRemoteCacheDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getFile(null, null, null, null, this);
    }
}
