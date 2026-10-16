package io.ktor.client.statement;

import com.ironsource.C3337ue;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannelKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HttpStatement.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u0002H\f\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\rJT\u0010\u000b\u001a\u0002H\u000e\"\u0006\b\u0000\u0010\f\u0018\u0001\"\u0004\b\u0001\u0010\u000e23\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0011\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJJ\u0010\u0018\u001a\u0002H\f\"\u0004\b\u0000\u0010\f21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001a\u001a\u00020\u0019H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0015\u0010\u001d\u001a\u00020\u0017*\u00020\u0019H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "builder", "Lio/ktor/client/request/HttpRequestBuilder;", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "getClient$annotations", "()V", "getClient", "()Lio/ktor/client/HttpClient;", "body", "T", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", C3337ue.n, "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCapabilities", "", "execute", "Lio/ktor/client/statement/HttpResponse;", "executeUnsafe", "toString", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = builder;
        this.client = client;
        checkCapabilities();
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:3|(9:5|6|7|(1:(1:(1:(1:(2:13|14)(3:16|17|18))(3:19|20|21))(5:22|23|24|25|(2:27|28)(1:29)))(2:35|36))(3:44|45|(2:47|28)(1:48))|37|38|39|(3:41|25|(0)(0))|28))|7|(0)(0)|37|38|39|(0)|28) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a0, code lost:
    
        if (r2.cleanup(r11, r0) == r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object execute(Function2<? super HttpResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        HttpStatement$execute$1 httpStatement$execute$1;
        Object coroutine_suspended;
        int i;
        HttpStatement httpStatement;
        HttpResponse httpResponse;
        Object invoke;
        HttpResponse httpResponse2;
        try {
            if (continuation instanceof HttpStatement$execute$1) {
                httpStatement$execute$1 = (HttpStatement$execute$1) continuation;
                if ((httpStatement$execute$1.label & Integer.MIN_VALUE) != 0) {
                    httpStatement$execute$1.label -= Integer.MIN_VALUE;
                    Object obj = httpStatement$execute$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = httpStatement$execute$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        httpStatement$execute$1.L$0 = this;
                        httpStatement$execute$1.L$1 = function2;
                        httpStatement$execute$1.label = 1;
                        obj = executeUnsafe(httpStatement$execute$1);
                        if (obj != coroutine_suspended) {
                            httpStatement = this;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    Object obj2 = httpStatement$execute$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    return obj2;
                                }
                                if (i != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                th = (Throwable) httpStatement$execute$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                throw th;
                            }
                            httpResponse2 = (HttpResponse) httpStatement$execute$1.L$1;
                            httpStatement = (HttpStatement) httpStatement$execute$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                httpStatement$execute$1.L$0 = obj;
                                httpStatement$execute$1.L$1 = null;
                                httpStatement$execute$1.label = 3;
                            } catch (Throwable th) {
                                httpResponse = httpResponse2;
                                th = th;
                                httpStatement$execute$1.L$0 = th;
                                httpStatement$execute$1.L$1 = null;
                                httpStatement$execute$1.label = 4;
                            }
                            return httpStatement.cleanup(httpResponse2, httpStatement$execute$1) != coroutine_suspended ? coroutine_suspended : obj;
                        }
                        function2 = (Function2) httpStatement$execute$1.L$1;
                        httpStatement = (HttpStatement) httpStatement$execute$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    httpResponse = (HttpResponse) obj;
                    httpStatement$execute$1.L$0 = httpStatement;
                    httpStatement$execute$1.L$1 = httpResponse;
                    httpStatement$execute$1.label = 2;
                    invoke = function2.invoke(httpResponse, httpStatement$execute$1);
                    if (invoke != coroutine_suspended) {
                        obj = invoke;
                        httpResponse2 = httpResponse;
                        httpStatement$execute$1.L$0 = obj;
                        httpStatement$execute$1.L$1 = null;
                        httpStatement$execute$1.label = 3;
                        if (httpStatement.cleanup(httpResponse2, httpStatement$execute$1) != coroutine_suspended) {
                        }
                    }
                }
            }
            if (i != 0) {
            }
            httpResponse = (HttpResponse) obj;
            httpStatement$execute$1.L$0 = httpStatement;
            httpStatement$execute$1.L$1 = httpResponse;
            httpStatement$execute$1.label = 2;
            invoke = function2.invoke(httpResponse, httpStatement$execute$1);
            if (invoke != coroutine_suspended) {
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
        httpStatement$execute$1 = new HttpStatement$execute$1(this, continuation);
        Object obj3 = httpStatement$execute$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpStatement$execute$1.label;
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return execute(new HttpStatement$execute$4(null), continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) {
        try {
            HttpResponse httpResponse = (HttpResponse) executeUnsafe(null);
            try {
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(6, "T");
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, "T");
                Object bodyNullable = call.bodyNullable(TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null), null);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = bodyNullable;
                return bodyNullable;
            } finally {
                HttpResponseKt.complete(httpResponse);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        try {
            HttpResponse httpResponse = (HttpResponse) executeUnsafe(null);
            try {
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(6, "T");
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, "T");
                Object bodyNullable = call.bodyNullable(TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null), null);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = bodyNullable;
                return function2.invoke(bodyNullable, null);
            } finally {
                cleanup(httpResponse, null);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeUnsafe(Continuation<? super HttpResponse> continuation) {
        HttpStatement$executeUnsafe$1 httpStatement$executeUnsafe$1;
        int i;
        try {
            if (continuation instanceof HttpStatement$executeUnsafe$1) {
                httpStatement$executeUnsafe$1 = (HttpStatement$executeUnsafe$1) continuation;
                if ((httpStatement$executeUnsafe$1.label & Integer.MIN_VALUE) != 0) {
                    httpStatement$executeUnsafe$1.label -= Integer.MIN_VALUE;
                    Object obj = httpStatement$executeUnsafe$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = httpStatement$executeUnsafe$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        HttpRequestBuilder takeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                        HttpClient httpClient = this.client;
                        httpStatement$executeUnsafe$1.label = 1;
                        obj = httpClient.execute$ktor_client_core(takeFromWithExecutionContext, httpStatement$executeUnsafe$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return ((HttpClientCall) obj).getResponse();
                }
            }
            if (i != 0) {
            }
            return ((HttpClientCall) obj).getResponse();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
        httpStatement$executeUnsafe$1 = new HttpStatement$executeUnsafe$1(this, continuation);
        Object obj2 = httpStatement$executeUnsafe$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpStatement$executeUnsafe$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanup(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpStatement$cleanup$1 httpStatement$cleanup$1;
        int i;
        if (continuation instanceof HttpStatement$cleanup$1) {
            httpStatement$cleanup$1 = (HttpStatement$cleanup$1) continuation;
            if ((httpStatement$cleanup$1.label & Integer.MIN_VALUE) != 0) {
                httpStatement$cleanup$1.label -= Integer.MIN_VALUE;
                Object obj = httpStatement$cleanup$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpStatement$cleanup$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = httpResponse.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    CompletableJob completableJob = (CompletableJob) element;
                    completableJob.complete();
                    try {
                        ByteReadChannelKt.cancel(httpResponse.getContent());
                    } catch (Throwable unused) {
                    }
                    httpStatement$cleanup$1.L$0 = completableJob;
                    httpStatement$cleanup$1.label = 1;
                    if (completableJob.join(httpStatement$cleanup$1) == coroutine_suspended) {
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
        httpStatement$cleanup$1 = new HttpStatement$cleanup$1(this, continuation);
        Object obj2 = httpStatement$cleanup$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpStatement$cleanup$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    private final void checkCapabilities() {
        Set keySet;
        Map map = (Map) this.builder.getAttributes().getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map == null || (keySet = map.keySet()) == null) {
            return;
        }
        ArrayList<HttpClientPlugin> arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (obj instanceof HttpClientPlugin) {
                arrayList.add(obj);
            }
        }
        for (HttpClientPlugin httpClientPlugin : arrayList) {
            if (HttpClientPluginKt.pluginOrNull(this.client, httpClientPlugin) == null) {
                throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
            }
        }
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + AbstractJsonLexerKt.END_LIST;
    }
}
