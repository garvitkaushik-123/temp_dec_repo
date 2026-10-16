package com.sourcepoint.cmplibrary;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SpCache.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006J3\u0010\u0007\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\tH&¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpCache;", "", "fetch", "T", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "fetchOrStore", "block", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SpCache {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    <T> T fetch(Class<T> modelClass);

    <T> T fetchOrStore(Class<T> modelClass, Function0<? extends T> block);

    /* compiled from: SpCache.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/SpCache$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
