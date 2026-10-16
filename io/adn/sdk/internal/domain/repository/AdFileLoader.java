package io.adn.sdk.internal.domain.repository;

import io.adn.sdk.internal.domain.model.ad.FileContentType;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: AdFileLoader.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0010"}, d2 = {"Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "", "loadAdFile", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "url", "", "contentType", "Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "loadAdFile-0E7RQCE", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/FileContentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdFile", "Ljava/io/File;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdFileLoader {
    Object downloadFile(String str, Continuation<? super Unit> continuation);

    File getAdFile(String url);

    /* renamed from: loadAdFile-0E7RQCE */
    Object mo9478loadAdFile0E7RQCE(String str, FileContentType fileContentType, Continuation<? super Result<LoadedFile>> continuation);
}
