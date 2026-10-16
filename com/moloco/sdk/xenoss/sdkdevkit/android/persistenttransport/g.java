package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import com.moloco.sdk.internal.MolocoLogger;
import io.ktor.client.HttpClient;
import io.ktor.http.ContentType;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes6.dex */
public final class g implements f {
    public static final int d = 8;
    public final HttpClient b;
    public final CoroutineScope c;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$send$1", f = "NonPersistentHttpRequest.kt", i = {0, 1}, l = {46, 50}, m = "invokeSuspend", n = {"runAttemptCount", "runAttemptCount"}, s = {"I$0", "I$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6369a;
        public int b;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new a(this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
        
            if (r13 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0083, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(10000, r12) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0085, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0083 -> B:6:0x0086). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                if (i < 5) {
                }
            } else if (i2 == 1) {
                i = this.f6369a;
                ResultKt.throwOnFailure(obj);
                z = ((Boolean) obj).booleanValue();
                if (!z) {
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f6369a;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i < 5) {
                    return Unit.INSTANCE;
                }
                boolean a2 = g.this.a(com.moloco.sdk.internal.android_context.b.a(null, 1, null));
                MolocoLogger.info$default(MolocoLogger.INSTANCE, h.f6371a, "Network available: " + a2 + " for non persistent request", null, false, 12, null);
                if (a2) {
                    HttpClient httpClient = g.this.b;
                    String str = this.d;
                    this.f6369a = i;
                    this.b = 1;
                    obj = e.a(httpClient, str, this);
                } else {
                    z = false;
                    if (!z) {
                        return Unit.INSTANCE;
                    }
                    this.f6369a = i;
                    this.b = 2;
                }
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$sendPost$1", f = "NonPersistentHttpRequest.kt", i = {0, 1}, l = {61, 65}, m = "invokeSuspend", n = {"runAttemptCount", "runAttemptCount"}, s = {"I$0", "I$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6370a;
        public int b;
        public final /* synthetic */ String d;
        public final /* synthetic */ byte[] e;
        public final /* synthetic */ ContentType f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, byte[] bArr, ContentType contentType, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = bArr;
            this.f = contentType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new b(this.d, this.e, this.f, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0074, code lost:
        
            if (r14 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(10000, r13) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x008f -> B:6:0x0092). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            boolean z;
            b bVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                i = 0;
                if (i < 5) {
                }
            } else if (i2 == 1) {
                i = this.f6370a;
                ResultKt.throwOnFailure(obj);
                bVar = this;
                z = ((Boolean) obj).booleanValue();
                if (!z) {
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.f6370a;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i < 5) {
                    return Unit.INSTANCE;
                }
                boolean a2 = g.this.a(com.moloco.sdk.internal.android_context.b.a(null, 1, null));
                MolocoLogger.info$default(MolocoLogger.INSTANCE, h.f6371a, "Network available: " + a2 + " for non persistent request", null, false, 12, null);
                if (a2) {
                    HttpClient httpClient = g.this.b;
                    String str = this.d;
                    byte[] bArr = this.e;
                    ContentType contentType = this.f;
                    this.f6370a = i;
                    this.b = 1;
                    bVar = this;
                    obj = e.a(httpClient, str, bArr, contentType, null, bVar, 8, null);
                } else {
                    bVar = this;
                    z = false;
                    if (!z) {
                        return Unit.INSTANCE;
                    }
                    bVar.f6370a = i;
                    bVar.b = 2;
                }
            }
        }
    }

    public g(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.b = httpClient;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getDefault());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(url, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(url, body, contentType, null), 3, null);
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3);
    }
}
