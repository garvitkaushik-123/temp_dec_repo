package com.unity3d.ads.core.data.datasource;

import com.ironsource.V5;
import com.unity3d.ads.core.data.model.CacheError;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CacheSource;
import com.unity3d.ads.core.data.model.CachedFile;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.GetFileExtensionFromUrl;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.HttpResponseKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: AndroidRemoteCacheDataSource.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidRemoteCacheDataSource;", "Lcom/unity3d/ads/core/data/datasource/CacheDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "createFile", "Lcom/unity3d/ads/core/domain/CreateFile;", "getFileExtensionFromUrl", "Lcom/unity3d/ads/core/domain/GetFileExtensionFromUrl;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/CreateFile;Lcom/unity3d/ads/core/domain/GetFileExtensionFromUrl;Lcom/unity3d/services/core/network/core/HttpClient;)V", "downloadFile", "Lcom/unity3d/services/core/network/model/HttpResponse;", "url", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFile", "Lcom/unity3d/ads/core/data/model/CacheResult;", "cachePath", "Ljava/io/File;", V5.c.b, "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToCache", "", "dest", "body", "", "(Ljava/io/File;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidRemoteCacheDataSource implements CacheDataSource {
    private final CreateFile createFile;
    private final GetFileExtensionFromUrl getFileExtensionFromUrl;
    private final HttpClient httpClient;
    private final CoroutineDispatcher ioDispatcher;

    public AndroidRemoteCacheDataSource(CoroutineDispatcher ioDispatcher, CreateFile createFile, GetFileExtensionFromUrl getFileExtensionFromUrl, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(createFile, "createFile");
        Intrinsics.checkNotNullParameter(getFileExtensionFromUrl, "getFileExtensionFromUrl");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.ioDispatcher = ioDispatcher;
        this.createFile = createFile;
        this.getFileExtensionFromUrl = getFileExtensionFromUrl;
        this.httpClient = httpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveToCache(File file, Object obj, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.ioDispatcher, new AndroidRemoteCacheDataSource$saveToCache$2(obj, file, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // com.unity3d.ads.core.data.datasource.CacheDataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getFile(File file, String str, String str2, Integer num, Continuation<? super CacheResult> continuation) {
        AndroidRemoteCacheDataSource$getFile$1 androidRemoteCacheDataSource$getFile$1;
        int i;
        String str3;
        Object obj;
        Integer num2;
        AndroidRemoteCacheDataSource androidRemoteCacheDataSource;
        File file2;
        String str4;
        HttpResponse httpResponse;
        String str5;
        Integer num3;
        HttpResponse httpResponse2;
        String str6;
        String str7;
        File file3;
        Object body;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        try {
            if (continuation instanceof AndroidRemoteCacheDataSource$getFile$1) {
                androidRemoteCacheDataSource$getFile$1 = (AndroidRemoteCacheDataSource$getFile$1) continuation;
                if ((androidRemoteCacheDataSource$getFile$1.label & Integer.MIN_VALUE) != 0) {
                    androidRemoteCacheDataSource$getFile$1.label -= Integer.MIN_VALUE;
                    Object obj2 = androidRemoteCacheDataSource$getFile$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = androidRemoteCacheDataSource$getFile$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        if (str2 == null) {
                            return new CacheResult.Failure(CacheError.MALFORMED_URL, CacheSource.REMOTE, null, 4, null);
                        }
                        androidRemoteCacheDataSource$getFile$1.L$0 = this;
                        androidRemoteCacheDataSource$getFile$1.L$1 = file;
                        androidRemoteCacheDataSource$getFile$1.L$2 = str;
                        androidRemoteCacheDataSource$getFile$1.L$3 = str2;
                        androidRemoteCacheDataSource$getFile$1.L$4 = num;
                        androidRemoteCacheDataSource$getFile$1.label = 1;
                        Object downloadFile = downloadFile(str2, num, androidRemoteCacheDataSource$getFile$1);
                        if (downloadFile == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str2;
                        obj = downloadFile;
                        num2 = num;
                        androidRemoteCacheDataSource = this;
                        file2 = file;
                        str4 = str;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            file3 = (File) androidRemoteCacheDataSource$getFile$1.L$5;
                            str6 = (String) androidRemoteCacheDataSource$getFile$1.L$4;
                            httpResponse2 = (HttpResponse) androidRemoteCacheDataSource$getFile$1.L$3;
                            num3 = (Integer) androidRemoteCacheDataSource$getFile$1.L$2;
                            str7 = (String) androidRemoteCacheDataSource$getFile$1.L$1;
                            str5 = (String) androidRemoteCacheDataSource$getFile$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion = Result.INSTANCE;
                                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                                HttpResponse httpResponse3 = httpResponse2;
                                File file4 = file3;
                                String str8 = str6;
                                String str9 = str5;
                                String str10 = str7;
                                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                                if (m10244exceptionOrNullimpl == null) {
                                }
                            }
                            HttpResponse httpResponse32 = httpResponse2;
                            File file42 = file3;
                            String str82 = str6;
                            String str92 = str5;
                            String str102 = str7;
                            m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                            if (m10244exceptionOrNullimpl == null) {
                                return new CacheResult.Failure(CacheError.FILE_STATE_WRONG, CacheSource.REMOTE, m10244exceptionOrNullimpl);
                            }
                            String str11 = str82;
                            if (str11 == null) {
                                str11 = "";
                            }
                            return new CacheResult.Success(new CachedFile("", str102, str92, file42, str11, httpResponse32.getContentSize(), httpResponse32.getProtocol(), num3 != null ? num3.intValue() : Integer.MAX_VALUE), CacheSource.REMOTE);
                        }
                        Integer num4 = (Integer) androidRemoteCacheDataSource$getFile$1.L$4;
                        str3 = (String) androidRemoteCacheDataSource$getFile$1.L$3;
                        str4 = (String) androidRemoteCacheDataSource$getFile$1.L$2;
                        File file5 = (File) androidRemoteCacheDataSource$getFile$1.L$1;
                        androidRemoteCacheDataSource = (AndroidRemoteCacheDataSource) androidRemoteCacheDataSource$getFile$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        num2 = num4;
                        obj = obj2;
                        file2 = file5;
                    }
                    httpResponse = (HttpResponse) obj;
                    String invoke = str3.length() != 0 ? null : androidRemoteCacheDataSource.getFileExtensionFromUrl.invoke(str3);
                    if (!HttpResponseKt.isSuccessful(httpResponse)) {
                        File invoke2 = androidRemoteCacheDataSource.createFile.invoke(file2, str4);
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            AndroidRemoteCacheDataSource androidRemoteCacheDataSource2 = androidRemoteCacheDataSource;
                            body = httpResponse.getBody();
                            androidRemoteCacheDataSource$getFile$1.L$0 = str4;
                            androidRemoteCacheDataSource$getFile$1.L$1 = str3;
                            androidRemoteCacheDataSource$getFile$1.L$2 = num2;
                            androidRemoteCacheDataSource$getFile$1.L$3 = httpResponse;
                            androidRemoteCacheDataSource$getFile$1.L$4 = invoke;
                            androidRemoteCacheDataSource$getFile$1.L$5 = invoke2;
                            androidRemoteCacheDataSource$getFile$1.label = 2;
                        } catch (Throwable th2) {
                            th = th2;
                            str5 = str4;
                            num3 = num2;
                            httpResponse2 = httpResponse;
                            str6 = invoke;
                            str7 = str3;
                            file3 = invoke2;
                            Result.Companion companion3 = Result.INSTANCE;
                            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                            HttpResponse httpResponse322 = httpResponse2;
                            File file422 = file3;
                            String str822 = str6;
                            String str922 = str5;
                            String str1022 = str7;
                            m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                            if (m10244exceptionOrNullimpl == null) {
                            }
                        }
                        if (androidRemoteCacheDataSource.saveToCache(invoke2, body, androidRemoteCacheDataSource$getFile$1) != coroutine_suspended) {
                            str5 = str4;
                            num3 = num2;
                            httpResponse2 = httpResponse;
                            str6 = invoke;
                            str7 = str3;
                            file3 = invoke2;
                            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                            HttpResponse httpResponse3222 = httpResponse2;
                            File file4222 = file3;
                            String str8222 = str6;
                            String str9222 = str5;
                            String str10222 = str7;
                            m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                            if (m10244exceptionOrNullimpl == null) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return new CacheResult.Failure(CacheError.NETWORK_ERROR, CacheSource.REMOTE, null, 4, null);
                }
            }
            if (i != 0) {
            }
            httpResponse = (HttpResponse) obj;
            String invoke3 = str3.length() != 0 ? null : androidRemoteCacheDataSource.getFileExtensionFromUrl.invoke(str3);
            if (!HttpResponseKt.isSuccessful(httpResponse)) {
            }
        } catch (Exception e) {
            return new CacheResult.Failure(CacheError.NETWORK_ERROR, CacheSource.REMOTE, e);
        }
        androidRemoteCacheDataSource$getFile$1 = new AndroidRemoteCacheDataSource$getFile$1(this, continuation);
        Object obj22 = androidRemoteCacheDataSource$getFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidRemoteCacheDataSource$getFile$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFile(String str, Integer num, Continuation<? super HttpResponse> continuation) {
        return this.httpClient.execute(new HttpRequest(str, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, num != null ? num.intValue() : Integer.MAX_VALUE, 65534, null), continuation);
    }
}
