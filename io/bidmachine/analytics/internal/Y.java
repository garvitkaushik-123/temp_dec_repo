package io.bidmachine.analytics.internal;

import android.util.Base64;
import io.bidmachine.analytics.BidMachineAnalytics;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes7.dex */
public abstract class Y {
    public static final a e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final o0 f6684a;
    private final String b;
    private final p0 c;
    private final C3578s d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f6685a;
        int c;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6685a = obj;
            this.c |= Integer.MIN_VALUE;
            Object a2 = Y.this.a(this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6686a;

        static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            int f6687a;
            final /* synthetic */ Y b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Y y, Continuation continuation) {
                super(2, continuation);
                this.b = y;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6687a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Y y = this.b;
                return y.a(y.d, this.b.b());
            }
        }

        c(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Y.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object m10241constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6686a;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (Y.this.d == null) {
                            Result.Companion companion = Result.INSTANCE;
                            return Result.m10240boximpl(Result.m10241constructorimpl(Y.this.a()));
                        }
                        CoroutineDispatcher b = Y.this.c.b();
                        a aVar = new a(Y.this, null);
                        this.f6686a = 1;
                        obj = BuildersKt.withContext(b, aVar, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    byte[] bArr = (byte[]) obj;
                    Y y = Y.this;
                    y.a(y.b, bArr);
                    Result.Companion companion2 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(Y.this.a());
                } catch (Throwable unused) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m10240boximpl(Result.m10241constructorimpl(Y.this.a()));
                }
            } catch (Throwable th) {
                Result.Companion companion4 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m10240boximpl(m10241constructorimpl);
        }
    }

    public Y(o0 o0Var, String str, p0 p0Var, C3578s c3578s) {
        this.f6684a = o0Var;
        this.b = str;
        this.c = p0Var;
        this.d = c3578s;
    }

    public abstract Y a();

    public abstract byte[] b();

    private final int b(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Continuation continuation) {
        b bVar;
        int i;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.c = i2 - Integer.MIN_VALUE;
                Object obj = bVar.f6685a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bVar.c;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher c2 = this.c.c();
                    c cVar = new c(null);
                    bVar.c = 1;
                    obj = BuildersKt.withContext(c2, cVar, bVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.f6685a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.c;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] a(C3578s c3578s, byte[] bArr) {
        if (bArr != null) {
            return AbstractC3579t.a(bArr, c3578s);
        }
        return null;
    }

    public /* synthetic */ Y(o0 o0Var, String str, p0 p0Var, C3578s c3578s, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(o0Var, str, p0Var, (i & 8) != 0 ? BidMachineAnalytics.INSTANCE.getEncryptionManager$bidmachine_android_sdk_bg_3_4_0() : c3578s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, byte[] bArr) {
        URLConnection uRLConnection = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            URLConnection openConnection = new URL(str).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            try {
                this.f6684a.a(httpURLConnection);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(40000);
                httpURLConnection.setReadTimeout(40000);
                C3578s c3578s = this.d;
                if (c3578s != null) {
                    httpURLConnection.setRequestProperty("bm-data", Base64.encodeToString(c3578s.a().b(), 2));
                }
                if (bArr != null && bArr.length != 0) {
                    httpURLConnection.setDoOutput(true);
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        try {
                            bufferedOutputStream2.write(bArr);
                            s0.a((Flushable) bufferedOutputStream2);
                            s0.a((Closeable) bufferedOutputStream2);
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedOutputStream != null) {
                                Result.m10240boximpl(s0.a((Flushable) bufferedOutputStream));
                            }
                            if (bufferedOutputStream != null) {
                                Result.m10240boximpl(s0.a((Closeable) bufferedOutputStream));
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                int b2 = b(httpURLConnection);
                if (b2 != 200 && b2 != 204) {
                    if (b2 != 305 && b2 != 307 && b2 != 308) {
                        switch (b2) {
                        }
                        throw new IllegalStateException(("Invalid response code: " + b2).toString());
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField != null && headerField.length() > 0) {
                        a(headerField, bArr);
                        a(httpURLConnection);
                        return;
                    }
                    throw new IllegalStateException(("Invalid response code: " + b2).toString());
                }
                a(httpURLConnection);
            } catch (Throwable th3) {
                th = th3;
                uRLConnection = httpURLConnection;
                a(uRLConnection);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final Object a(URLConnection uRLConnection) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
