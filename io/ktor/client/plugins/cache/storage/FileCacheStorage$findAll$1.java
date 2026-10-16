package io.ktor.client.plugins.cache.storage;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FileCacheStorage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {}, l = {Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER}, m = "findAll", n = {}, s = {})
/* loaded from: classes8.dex */
final class FileCacheStorage$findAll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileCacheStorage$findAll$1(FileCacheStorage fileCacheStorage, Continuation<? super FileCacheStorage$findAll$1> continuation) {
        super(continuation);
        this.this$0 = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.findAll(null, this);
    }
}
