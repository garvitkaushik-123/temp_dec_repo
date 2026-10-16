package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers;

import com.moloco.sdk.internal.MolocoLogger;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class g implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a {
    public static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f5985a;
    public final MutableSharedFlow<a> b;
    public final MutableSharedFlow<a> c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final C0509a b;
        public static final a c = new a("VIDEO", 0, "videoContainer");
        public static final a d = new a("MRAID", 1, "mraidContainer");
        public static final a e = new a("STATIC", 2, "staticContainer");
        public static final /* synthetic */ a[] f;
        public static final /* synthetic */ EnumEntries g;

        /* renamed from: a, reason: collision with root package name */
        public final String f5986a;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g$a$a, reason: collision with other inner class name */
        public static final class C0509a {
            public /* synthetic */ C0509a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (a aVar : a.values()) {
                    if (Intrinsics.areEqual(aVar.c(), value)) {
                        return aVar;
                    }
                }
                return null;
            }

            public C0509a() {
            }
        }

        static {
            a[] a2 = a();
            f = a2;
            g = EnumEntriesKt.enumEntries(a2);
            b = new C0509a(null);
        }

        public a(String str, int i, String str2) {
            this.f5986a = str2;
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{c, d, e};
        }

        public static EnumEntries<a> b() {
            return g;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }

        public final String c() {
            return this.f5986a;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.PlayListItemDisplayingEventHandler$handleEvent$1", f = "PlayListItemDisplayingEventHandler.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5987a;
        public final /* synthetic */ a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5987a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = g.this.b;
                a aVar = this.c;
                this.f5987a = 1;
                if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public String b() {
        return "PlayListItemDisplayingEventHandler";
    }

    public final MutableSharedFlow<a> c() {
        return this.c;
    }

    public g(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f5985a = scope;
        MutableSharedFlow<a> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.b = MutableSharedFlow$default;
        this.c = MutableSharedFlow$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public Set<String> a() {
        return SetsKt.setOf("playlistItemDisplaying");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a
    public void a(JSONObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, b(), event + " displaying.", false, 4, null);
        if (!Intrinsics.areEqual(event.getString("event"), CollectionsKt.first(a()))) {
            MolocoLogger.debug$default(molocoLogger, b(), "Event not supported: " + event.getString("event"), false, 4, null);
            return;
        }
        String string = event.getString("creativeType");
        a.C0509a c0509a = a.b;
        Intrinsics.checkNotNull(string);
        a a2 = c0509a.a(string);
        MolocoLogger.debug$default(molocoLogger, b(), a2 + " displaying.", false, 4, null);
        if (a2 != null) {
            BuildersKt__Builders_commonKt.launch$default(this.f5985a, null, null, new b(a2, null), 3, null);
        }
    }

    public /* synthetic */ g(CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }
}
