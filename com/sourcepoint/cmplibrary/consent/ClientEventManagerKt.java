package com.sourcepoint.cmplibrary.consent;

import com.sourcepoint.cmplibrary.SpClient;
import com.sourcepoint.cmplibrary.consent.ClientEventManager;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientEventManager.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;", "Lcom/sourcepoint/cmplibrary/consent/ClientEventManager$Companion;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "executor", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "consentManagerUtils", "Lcom/sourcepoint/cmplibrary/consent/ConsentManagerUtils;", "spClient", "Lcom/sourcepoint/cmplibrary/SpClient;", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClientEventManagerKt {
    public static final ClientEventManager create(ClientEventManager.Companion companion, Logger logger, ExecutorManager executor, ConsentManagerUtils consentManagerUtils, SpClient spClient, ConnectionManager connectionManager) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consentManagerUtils, "consentManagerUtils");
        Intrinsics.checkNotNullParameter(spClient, "spClient");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        return new ClientEventManagerImpl(logger, executor, spClient, consentManagerUtils, connectionManager);
    }
}
