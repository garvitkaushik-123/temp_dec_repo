package com.sourcepoint.cmplibrary;

import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpCache.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H\u0016¢\u0006\u0002\u0010\nJ3\u0010\u000b\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH\u0016¢\u0006\u0002\u0010\u000eR\"\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpCacheObjet;", "Lcom/sourcepoint/cmplibrary/SpCache;", "()V", "cache", "", "Ljava/lang/Class;", "", "fetch", "T", "modelClass", "(Ljava/lang/Class;)Ljava/lang/Object;", "fetchOrStore", "block", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpCacheObjet implements SpCache {
    public static final SpCacheObjet INSTANCE = new SpCacheObjet();
    private static final Map<Class<? extends Object>, Object> cache = new LinkedHashMap();

    private SpCacheObjet() {
    }

    @Override // com.sourcepoint.cmplibrary.SpCache
    public <T> T fetchOrStore(Class<T> modelClass, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(block, "block");
        Map<Class<? extends Object>, Object> map = cache;
        T t = (T) map.get(modelClass);
        if (t == null) {
            t = block.invoke();
            map.put(modelClass, t);
        }
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.sourcepoint.cmplibrary.SpCacheObjet.fetchOrStore");
        return t;
    }

    @Override // com.sourcepoint.cmplibrary.SpCache
    public <T> T fetch(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        T t = (T) cache.get(modelClass);
        if (t == null) {
            t = null;
        }
        if (t != null) {
            return t;
        }
        ExceptionUtilsKt.fail(modelClass + " has not been created!!!");
        throw new KotlinNothingValueException();
    }
}
