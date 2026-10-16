package com.sourcepoint.cmplibrary.creation;

import android.content.Context;
import com.sourcepoint.cmplibrary.data.network.NetworkClient;
import com.sourcepoint.cmplibrary.data.network.NetworkClientImplKt;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManagerImplKt;
import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManagerSingleton;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: ComponentFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"getConnectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "appCtx", "Landroid/content/Context;", "networkClient", "Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "netClient", "Lokhttp3/OkHttpClient;", "responseManage", "Lcom/sourcepoint/cmplibrary/data/network/util/ResponseManager;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComponentFactoryKt {
    public static final ConnectionManager getConnectionManager(Context appCtx) {
        Intrinsics.checkNotNullParameter(appCtx, "appCtx");
        return ConnectionManagerImplKt.create(ConnectionManager.INSTANCE, appCtx);
    }

    public static final NetworkClient networkClient(Context appCtx, OkHttpClient netClient, ResponseManager responseManage, Logger logger) {
        Intrinsics.checkNotNullParameter(appCtx, "appCtx");
        Intrinsics.checkNotNullParameter(netClient, "netClient");
        Intrinsics.checkNotNullParameter(responseManage, "responseManage");
        Intrinsics.checkNotNullParameter(logger, "logger");
        return NetworkClientImplKt.createNetworkClient(netClient, HttpUrlManagerSingleton.INSTANCE, logger, responseManage);
    }
}
