package io.bidmachine.rendering.internal.state;

import com.ironsource.D5;
import io.bidmachine.rendering.internal.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/bidmachine/rendering/internal/state/c;", "Lio/bidmachine/rendering/internal/state/d;", "", "parent", "Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "<init>", "(Ljava/lang/String;Lio/bidmachine/rendering/internal/h;)V", D5.q, "Lio/bidmachine/rendering/internal/h;", "()Lio/bidmachine/rendering/internal/h;", "Lio/bidmachine/rendering/internal/state/b;", "o", "Lkotlin/Lazy;", "()Lio/bidmachine/rendering/internal/state/b;", "coroutineScope", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c extends d {

    /* renamed from: n, reason: from kotlin metadata */
    private final h coroutineDispatchers;

    /* renamed from: o, reason: from kotlin metadata */
    private final Lazy coroutineScope;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/bidmachine/rendering/internal/state/b;", "a", "()Lio/bidmachine/rendering/internal/state/b;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<b> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            c cVar = c.this;
            return new b(cVar, cVar.getCoroutineDispatchers());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String parent, h coroutineDispatchers) {
        super(parent);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(coroutineDispatchers, "coroutineDispatchers");
        this.coroutineDispatchers = coroutineDispatchers;
        this.coroutineScope = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new a());
    }

    /* renamed from: n, reason: from getter */
    public final h getCoroutineDispatchers() {
        return this.coroutineDispatchers;
    }

    public final b o() {
        return (b) this.coroutineScope.getValue();
    }
}
