package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CommonGetFileExtensionFromUrl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonGetFileExtensionFromUrl;", "Lcom/unity3d/ads/core/domain/GetFileExtensionFromUrl;", "removeUrlQuery", "Lcom/unity3d/ads/core/domain/RemoveUrlQuery;", "(Lcom/unity3d/ads/core/domain/RemoveUrlQuery;)V", "getRemoveUrlQuery", "()Lcom/unity3d/ads/core/domain/RemoveUrlQuery;", "invoke", "", "url", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonGetFileExtensionFromUrl implements GetFileExtensionFromUrl {
    private final RemoveUrlQuery removeUrlQuery;

    public CommonGetFileExtensionFromUrl(RemoveUrlQuery removeUrlQuery) {
        Intrinsics.checkNotNullParameter(removeUrlQuery, "removeUrlQuery");
        this.removeUrlQuery = removeUrlQuery;
    }

    public final RemoveUrlQuery getRemoveUrlQuery() {
        return this.removeUrlQuery;
    }

    @Override // com.unity3d.ads.core.domain.GetFileExtensionFromUrl
    public String invoke(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String invoke = this.removeUrlQuery.invoke(url);
        if (invoke == null) {
            return null;
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(invoke, '/', (String) null, 2, (Object) null);
        if (!StringsKt.contains$default((CharSequence) substringAfterLast$default, '.', false, 2, (Object) null)) {
            return null;
        }
        String substringAfterLast$default2 = StringsKt.substringAfterLast$default(substringAfterLast$default, '.', (String) null, 2, (Object) null);
        return substringAfterLast$default2.length() != 0 ? substringAfterLast$default2 : null;
    }
}
