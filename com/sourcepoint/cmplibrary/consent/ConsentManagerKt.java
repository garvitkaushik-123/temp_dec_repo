package com.sourcepoint.cmplibrary.consent;

import androidx.core.app.NotificationCompat;
import com.ironsource.D5;
import com.sourcepoint.cmplibrary.consent.ConsentManager;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.Service;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.exception.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentManager.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¨\u0006\u0011"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/consent/ConsentManager;", "Lcom/sourcepoint/cmplibrary/consent/ConsentManager$Companion;", NotificationCompat.CATEGORY_SERVICE, "Lcom/sourcepoint/cmplibrary/data/Service;", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "dataStorage", "Lcom/sourcepoint/cmplibrary/data/local/DataStorage;", "executorManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "clientEventManager", "Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConsentManagerKt {
    public static final ConsentManager create(ConsentManager.Companion companion, Service service, ConsentManagerUtils consentManagerUtils, Env env, Logger logger, DataStorage dataStorage, ExecutorManager executorManager, ClientEventManager clientEventManager) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dataStorage, "dataStorage");
        Intrinsics.checkNotNullParameter(executorManager, "executorManager");
        Intrinsics.checkNotNullParameter(clientEventManager, "clientEventManager");
        return new ConsentManagerImpl(service, consentManagerUtils, logger, env, dataStorage, executorManager, clientEventManager);
    }
}
