package io.bidmachine.rendering.internal;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.EventTaskParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\r\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\f\u0010\u0011¨\u0006\u001a"}, d2 = {"Lio/bidmachine/rendering/internal/h;", "", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainProvider", "mainImmediateProvider", "ioProvider", "defaultProvider", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "a", "Lkotlin/jvm/functions/Function0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineDispatcher;", C3040d4.h.Z, InneractiveMediationDefs.GENDER_FEMALE, "mainImmediate", "g", "io", "h", EventTaskParams.STATE_GROUP_DEFAULT, "i", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final h j = new h(a.f7064a, b.f7065a, c.f7066a, d.f7067a);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0<CoroutineDispatcher> mainProvider;

    /* renamed from: b, reason: from kotlin metadata */
    private final Function0<CoroutineDispatcher> mainImmediateProvider;

    /* renamed from: c, reason: from kotlin metadata */
    private final Function0<CoroutineDispatcher> ioProvider;

    /* renamed from: d, reason: from kotlin metadata */
    private final Function0<CoroutineDispatcher> defaultProvider;

    /* renamed from: e, reason: from kotlin metadata */
    private final Lazy main;

    /* renamed from: f, reason: from kotlin metadata */
    private final Lazy mainImmediate;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy io;

    /* renamed from: h, reason: from kotlin metadata */
    private final Lazy default;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<CoroutineDispatcher> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7064a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getMain();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<CoroutineDispatcher> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7065a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getMain().getImmediate();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<CoroutineDispatcher> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7066a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getIO();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function0<CoroutineDispatcher> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7067a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return Dispatchers.getDefault();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/bidmachine/rendering/internal/h$e;", "", "<init>", "()V", "Lio/bidmachine/rendering/internal/h;", "sdkDispatchers", "Lio/bidmachine/rendering/internal/h;", "a", "()Lio/bidmachine/rendering/internal/h;", "getSdkDispatchers$annotations", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.h$e, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return h.j;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class f extends Lambda implements Function0<CoroutineDispatcher> {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) h.this.defaultProvider.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class g extends Lambda implements Function0<CoroutineDispatcher> {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) h.this.ioProvider.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    /* renamed from: io.bidmachine.rendering.internal.h$h, reason: collision with other inner class name */
    static final class C0624h extends Lambda implements Function0<CoroutineDispatcher> {
        C0624h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) h.this.mainProvider.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;"}, k = 3, mv = {1, 7, 1})
    static final class i extends Lambda implements Function0<CoroutineDispatcher> {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher invoke() {
            return (CoroutineDispatcher) h.this.mainImmediateProvider.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function0<? extends CoroutineDispatcher> mainProvider, Function0<? extends CoroutineDispatcher> mainImmediateProvider, Function0<? extends CoroutineDispatcher> ioProvider, Function0<? extends CoroutineDispatcher> defaultProvider) {
        Intrinsics.checkNotNullParameter(mainProvider, "mainProvider");
        Intrinsics.checkNotNullParameter(mainImmediateProvider, "mainImmediateProvider");
        Intrinsics.checkNotNullParameter(ioProvider, "ioProvider");
        Intrinsics.checkNotNullParameter(defaultProvider, "defaultProvider");
        this.mainProvider = mainProvider;
        this.mainImmediateProvider = mainImmediateProvider;
        this.ioProvider = ioProvider;
        this.defaultProvider = defaultProvider;
        this.main = LazyKt.lazy(new C0624h());
        this.mainImmediate = LazyKt.lazy(new i());
        this.io = LazyKt.lazy(new g());
        this.default = LazyKt.lazy(new f());
    }

    public static final h f() {
        return INSTANCE.a();
    }

    public final CoroutineDispatcher e() {
        return (CoroutineDispatcher) this.mainImmediate.getValue();
    }

    public final CoroutineDispatcher b() {
        return (CoroutineDispatcher) this.default.getValue();
    }

    public final CoroutineDispatcher c() {
        return (CoroutineDispatcher) this.io.getValue();
    }

    public final CoroutineDispatcher d() {
        return (CoroutineDispatcher) this.main.getValue();
    }
}
