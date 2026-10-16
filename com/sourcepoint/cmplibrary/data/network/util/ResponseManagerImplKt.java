package com.sourcepoint.cmplibrary.data.network.util;

import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseManagerImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;", "Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager$Companion;", "jsonConverter", "Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseManagerImplKt {
    public static final ResponseManager create(ResponseManager.Companion companion, JsonConverter jsonConverter, Logger logger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(jsonConverter, "jsonConverter");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return new ResponseManagerImpl(jsonConverter, logger);
    }
}
