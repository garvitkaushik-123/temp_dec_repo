package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource;
import com.unity3d.ads.core.data.model.WebViewConfiguration;
import com.unity3d.ads.datastore.WebviewConfigurationStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetLatestWebViewConfiguration.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JG\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;", "", "webviewConfigurationDataSource", "Lcom/unity3d/ads/core/data/datasource/WebviewConfigurationDataSource;", "(Lcom/unity3d/ads/core/data/datasource/WebviewConfigurationDataSource;)V", "invoke", "Lcom/unity3d/ads/core/data/model/WebViewConfiguration;", "receivedEntryPoint", "", "receivedVersion", "", "receivedAdditionalFiles", "", "receivedType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class GetLatestWebViewConfiguration {
    private final WebviewConfigurationDataSource webviewConfigurationDataSource;

    public GetLatestWebViewConfiguration(WebviewConfigurationDataSource webviewConfigurationDataSource) {
        Intrinsics.checkNotNullParameter(webviewConfigurationDataSource, "webviewConfigurationDataSource");
        this.webviewConfigurationDataSource = webviewConfigurationDataSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object invoke$default(GetLatestWebViewConfiguration getLatestWebViewConfiguration, String str, Integer num, List list, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return getLatestWebViewConfiguration.invoke(str, num, list, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, Integer num, List<String> list, String str2, Continuation<? super WebViewConfiguration> continuation) {
        GetLatestWebViewConfiguration$invoke$1 getLatestWebViewConfiguration$invoke$1;
        int i;
        GetLatestWebViewConfiguration getLatestWebViewConfiguration;
        WebViewConfiguration webViewConfiguration;
        WebViewConfiguration webViewConfiguration2;
        if (continuation instanceof GetLatestWebViewConfiguration$invoke$1) {
            getLatestWebViewConfiguration$invoke$1 = (GetLatestWebViewConfiguration$invoke$1) continuation;
            if ((getLatestWebViewConfiguration$invoke$1.label & Integer.MIN_VALUE) != 0) {
                getLatestWebViewConfiguration$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = getLatestWebViewConfiguration$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = getLatestWebViewConfiguration$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    WebviewConfigurationDataSource webviewConfigurationDataSource = this.webviewConfigurationDataSource;
                    getLatestWebViewConfiguration$invoke$1.L$0 = this;
                    getLatestWebViewConfiguration$invoke$1.L$1 = str;
                    getLatestWebViewConfiguration$invoke$1.L$2 = num;
                    getLatestWebViewConfiguration$invoke$1.L$3 = list;
                    getLatestWebViewConfiguration$invoke$1.L$4 = str2;
                    getLatestWebViewConfiguration$invoke$1.label = 1;
                    obj = webviewConfigurationDataSource.get(getLatestWebViewConfiguration$invoke$1);
                    if (obj != coroutine_suspended) {
                        getLatestWebViewConfiguration = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    WebViewConfiguration webViewConfiguration3 = (WebViewConfiguration) getLatestWebViewConfiguration$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return webViewConfiguration3;
                }
                str2 = (String) getLatestWebViewConfiguration$invoke$1.L$4;
                list = (List) getLatestWebViewConfiguration$invoke$1.L$3;
                num = (Integer) getLatestWebViewConfiguration$invoke$1.L$2;
                str = (String) getLatestWebViewConfiguration$invoke$1.L$1;
                getLatestWebViewConfiguration = (GetLatestWebViewConfiguration) getLatestWebViewConfiguration$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore = (WebviewConfigurationStore.WebViewConfigurationStore) obj;
                int version = webViewConfigurationStore.getVersion();
                String entryPoint = webViewConfigurationStore.getEntryPoint();
                Intrinsics.checkNotNullExpressionValue(entryPoint, "it.entryPoint");
                List<String> additionalFilesList = webViewConfigurationStore.getAdditionalFilesList();
                Intrinsics.checkNotNullExpressionValue(additionalFilesList, "it.additionalFilesList");
                String type = webViewConfigurationStore.getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                webViewConfiguration = new WebViewConfiguration(version, entryPoint, additionalFilesList, type);
                if (str != null && num == null && list == null && str2 == null) {
                    return webViewConfiguration;
                }
                int intValue = num == null ? num.intValue() : webViewConfiguration.getVersion();
                if (str == null) {
                    str = webViewConfiguration.getEntryPoint();
                }
                if (list == null) {
                    list = webViewConfiguration.getAdditionalFiles();
                }
                if (str2 == null) {
                    str2 = webViewConfiguration.getType();
                }
                webViewConfiguration2 = new WebViewConfiguration(intValue, str, list, str2);
                if (!Intrinsics.areEqual(webViewConfiguration2, webViewConfiguration)) {
                    WebviewConfigurationDataSource webviewConfigurationDataSource2 = getLatestWebViewConfiguration.webviewConfigurationDataSource;
                    WebviewConfigurationStore.WebViewConfigurationStore.Builder newBuilder = WebviewConfigurationStore.WebViewConfigurationStore.newBuilder();
                    newBuilder.setVersion(webViewConfiguration2.getVersion());
                    newBuilder.setEntryPoint(webViewConfiguration2.getEntryPoint());
                    newBuilder.addAllAdditionalFiles(webViewConfiguration2.getAdditionalFiles());
                    newBuilder.setType(webViewConfiguration2.getType());
                    WebviewConfigurationStore.WebViewConfigurationStore build = newBuilder.build();
                    Intrinsics.checkNotNullExpressionValue(build, "newBuilder().apply {\n   …                }.build()");
                    getLatestWebViewConfiguration$invoke$1.L$0 = webViewConfiguration2;
                    getLatestWebViewConfiguration$invoke$1.L$1 = null;
                    getLatestWebViewConfiguration$invoke$1.L$2 = null;
                    getLatestWebViewConfiguration$invoke$1.L$3 = null;
                    getLatestWebViewConfiguration$invoke$1.L$4 = null;
                    getLatestWebViewConfiguration$invoke$1.label = 2;
                    if (webviewConfigurationDataSource2.set(build, getLatestWebViewConfiguration$invoke$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return webViewConfiguration2;
            }
        }
        getLatestWebViewConfiguration$invoke$1 = new GetLatestWebViewConfiguration$invoke$1(this, continuation);
        Object obj2 = getLatestWebViewConfiguration$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = getLatestWebViewConfiguration$invoke$1.label;
        if (i != 0) {
        }
        WebviewConfigurationStore.WebViewConfigurationStore webViewConfigurationStore2 = (WebviewConfigurationStore.WebViewConfigurationStore) obj2;
        int version2 = webViewConfigurationStore2.getVersion();
        String entryPoint2 = webViewConfigurationStore2.getEntryPoint();
        Intrinsics.checkNotNullExpressionValue(entryPoint2, "it.entryPoint");
        List<String> additionalFilesList2 = webViewConfigurationStore2.getAdditionalFilesList();
        Intrinsics.checkNotNullExpressionValue(additionalFilesList2, "it.additionalFilesList");
        String type2 = webViewConfigurationStore2.getType();
        Intrinsics.checkNotNullExpressionValue(type2, "it.type");
        webViewConfiguration = new WebViewConfiguration(version2, entryPoint2, additionalFilesList2, type2);
        if (str != null) {
        }
        if (num == null) {
        }
        if (str == null) {
        }
        if (list == null) {
        }
        if (str2 == null) {
        }
        webViewConfiguration2 = new WebViewConfiguration(intValue, str, list, str2);
        if (!Intrinsics.areEqual(webViewConfiguration2, webViewConfiguration)) {
        }
        return webViewConfiguration2;
    }
}
