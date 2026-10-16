package io.bidmachine.analytics.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes7.dex */
public final class p0 {
    public static final d g = new d(null);
    private static final p0 h = new p0(a.f6775a, b.f6776a, c.f6777a);

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f6774a;
    private final Function0 b;
    private final Function0 c;
    private final Lazy d = LazyKt.lazy(new g());
    private final Lazy e = LazyKt.lazy(new f());
    private final Lazy f = LazyKt.lazy(new e());

    static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6775a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getMain();
        }
    }

    static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6776a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getIO();
        }
    }

    static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f6777a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getDefault();
        }
    }

    public static final class d {
        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p0 a() {
            return p0.h;
        }

        private d() {
        }
    }

    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) p0.this.c.invoke();
        }
    }

    static final class f extends Lambda implements Function0 {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) p0.this.b.invoke();
        }
    }

    static final class g extends Lambda implements Function0 {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) p0.this.f6774a.invoke();
        }
    }

    public p0(Function0 function0, Function0 function02, Function0 function03) {
        this.f6774a = function0;
        this.b = function02;
        this.c = function03;
    }

    public final CoroutineDispatcher b() {
        return (CoroutineDispatcher) this.f.getValue();
    }

    public final CoroutineDispatcher c() {
        return (CoroutineDispatcher) this.e.getValue();
    }
}
