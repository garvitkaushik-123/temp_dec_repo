package com.inmobi.media;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

/* renamed from: com.inmobi.media.c3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2591c3 {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f2531a;
    public final long b;

    public C2591c3(Interceptor[] interceptorArr, Dispatcher dispatcher, C2687he timeoutConfig) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(timeoutConfig, "timeoutConfig");
        this.b = timeoutConfig.c;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (interceptorArr != null) {
            for (Interceptor interceptor : interceptorArr) {
                builder.addInterceptor(interceptor);
            }
        }
        builder.addInterceptor(new C2978zc());
        builder.addNetworkInterceptor(new C2810p7());
        builder.protocols(CollectionsKt.mutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1));
        builder.retryOnConnectionFailure(false);
        builder.dispatcher(dispatcher);
        long j = timeoutConfig.f2590a;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j, timeUnit);
        builder.readTimeout(timeoutConfig.b, timeUnit);
        builder.callTimeout(timeoutConfig.c, timeUnit);
        OkHttpClient build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.f2531a = build;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r5 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final O9 a(final OkHttpClient okHttpClient, final Request request, String str) {
        Response response;
        ByteString byteString;
        O9 c2807p4;
        MediaType mediaType;
        Response response2 = null;
        r1 = null;
        String str2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        response2 = null;
        Response response3 = null;
        Response response4 = null;
        Response response5 = null;
        Response response6 = null;
        try {
            try {
                ExecutorService executorService = okHttpClient.dispatcher().executorService();
                Intrinsics.checkNotNullExpressionValue(executorService, "executorService(...)");
                try {
                    response = (Response) He.a(executorService, this.b, TimeUnit.SECONDS, new Callable() { // from class: com.inmobi.media.c3$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return C2591c3.a(OkHttpClient.this, request);
                        }
                    });
                } catch (MalformedURLException unused) {
                } catch (SocketTimeoutException unused2) {
                } catch (IOException unused3) {
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception unused4) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int code = response.code();
                ResponseBody body = response.body();
                if (body != null) {
                    byte[] bytes = body.bytes();
                    byteString = ByteString.of(Arrays.copyOf(bytes, bytes.length));
                }
                byteString = ByteString.EMPTY;
                Map<String, List<String>> multimap = response.headers().toMultimap();
                ResponseBody body2 = response.body();
                long contentLength = body2 != null ? body2.getContentLength() : 0L;
                ResponseBody body3 = response.body();
                if (body3 != null && (mediaType = body3.get$contentType()) != null) {
                    str2 = mediaType.getMediaType();
                }
                long receivedResponseAtMillis = response.receivedResponseAtMillis() - response.sentRequestAtMillis();
                long j = 0;
                if (receivedResponseAtMillis >= 0) {
                    j = receivedResponseAtMillis;
                }
                Intrinsics.checkNotNull(multimap);
                K9 k9 = new K9(j, multimap, (int) contentLength, str2);
                if (He.a(response)) {
                    Intrinsics.checkNotNull(byteString);
                    c2807p4 = new Q9(str, code, byteString, k9);
                } else {
                    EnumC2758m4.b.getClass();
                    c2807p4 = new C2807p4(str, C2726k4.a(code));
                }
                response.close();
                return c2807p4;
            } catch (MalformedURLException unused5) {
                response3 = response;
                C2807p4 c2807p42 = new C2807p4(str, EnumC2758m4.h);
                if (response3 != null) {
                    response3.close();
                }
                return c2807p42;
            } catch (SocketTimeoutException unused6) {
                response4 = response;
                C2807p4 c2807p43 = new C2807p4(str, EnumC2758m4.i);
                if (response4 != null) {
                    response4.close();
                }
                return c2807p43;
            } catch (IOException unused7) {
                response5 = response;
                C2807p4 c2807p44 = new C2807p4(str, EnumC2758m4.e);
                if (response5 != null) {
                    response5.close();
                }
                return c2807p44;
            } catch (CancellationException e2) {
                throw e2;
            } catch (Exception unused8) {
                response6 = response;
                C2807p4 c2807p45 = new C2807p4(str, EnumC2758m4.d);
                if (response6 != null) {
                    response6.close();
                }
                return c2807p45;
            } catch (Throwable th2) {
                th = th2;
                response2 = response;
                if (response2 != null) {
                    response2.close();
                }
                throw th;
            }
        } catch (MalformedURLException unused9) {
        } catch (SocketTimeoutException unused10) {
        } catch (IOException unused11) {
        } catch (CancellationException e3) {
            throw e3;
        } catch (Exception unused12) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static final Response a(OkHttpClient client, Request okHttpRequest) {
        Intrinsics.checkNotNullParameter(client, "$client");
        Intrinsics.checkNotNullParameter(okHttpRequest, "$okHttpRequest");
        return client.newCall(okHttpRequest).execute();
    }
}
