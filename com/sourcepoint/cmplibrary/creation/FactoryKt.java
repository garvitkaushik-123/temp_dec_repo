package com.sourcepoint.cmplibrary.creation;

import android.app.Activity;
import android.content.Context;
import com.example.cmplibrary.BuildConfig;
import com.sourcepoint.cmplibrary.SpClient;
import com.sourcepoint.cmplibrary.SpConsentLib;
import com.sourcepoint.cmplibrary.SpConsentLibImpl;
import com.sourcepoint.cmplibrary.campaign.CampaignManager;
import com.sourcepoint.cmplibrary.campaign.CampaignManagerKt;
import com.sourcepoint.cmplibrary.consent.ClientEventManager;
import com.sourcepoint.cmplibrary.consent.ClientEventManagerKt;
import com.sourcepoint.cmplibrary.consent.ConsentManager;
import com.sourcepoint.cmplibrary.consent.ConsentManagerKt;
import com.sourcepoint.cmplibrary.consent.ConsentManagerUtils;
import com.sourcepoint.cmplibrary.consent.ConsentManagerUtilsKt;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.core.ExecutorManagerKt;
import com.sourcepoint.cmplibrary.data.Service;
import com.sourcepoint.cmplibrary.data.ServiceImplKt;
import com.sourcepoint.cmplibrary.data.local.DataStorage;
import com.sourcepoint.cmplibrary.data.local.DataStorageCcpa;
import com.sourcepoint.cmplibrary.data.local.DataStorageCcpaKt;
import com.sourcepoint.cmplibrary.data.local.DataStorageGdpr;
import com.sourcepoint.cmplibrary.data.local.DataStorageGdprKt;
import com.sourcepoint.cmplibrary.data.local.DataStorageImplKt;
import com.sourcepoint.cmplibrary.data.local.DataStorageUSNat;
import com.sourcepoint.cmplibrary.data.local.DataStorageUSNatKt;
import com.sourcepoint.cmplibrary.data.network.NetworkClient;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.data.network.util.HttpUrlManagerSingleton;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManager;
import com.sourcepoint.cmplibrary.data.network.util.ResponseManagerImplKt;
import com.sourcepoint.cmplibrary.exception.ClientInfo;
import com.sourcepoint.cmplibrary.exception.ErrorMessageManager;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import com.sourcepoint.cmplibrary.util.ViewsManager;
import com.sourcepoint.cmplibrary.util.ViewsManagerKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"makeConsentLib", "Lcom/sourcepoint/cmplibrary/SpConsentLib;", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "activity", "Landroid/app/Activity;", "spClient", "Lcom/sourcepoint/cmplibrary/SpClient;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FactoryKt {
    public static final SpConsentLib makeConsentLib(SpConfig spConfig, Activity activity, SpClient spClient) {
        Env env;
        Intrinsics.checkNotNullParameter(spConfig, "spConfig");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(spClient, "spClient");
        Env[] values = Env.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                env = null;
                break;
            }
            env = values[i];
            if (Intrinsics.areEqual(env.name(), BuildConfig.SDK_ENV)) {
                break;
            }
            i++;
        }
        if (env == null) {
            env = Env.PROD;
        }
        Env env2 = env;
        long j = spConfig.messageTimeout;
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).build();
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ClientInfo createClientInfo = CreationalUtilityKt.createClientInfo();
        DataStorage create = DataStorageImplKt.create(DataStorage.INSTANCE, applicationContext, DataStorageGdprKt.create(DataStorageGdpr.INSTANCE, applicationContext), DataStorageCcpaKt.create(DataStorageCcpa.INSTANCE, applicationContext), DataStorageUSNatKt.create(DataStorageUSNat.INSTANCE, applicationContext));
        CampaignManager create2 = CampaignManagerKt.create(CampaignManager.INSTANCE, create, spConfig);
        ErrorMessageManager errorMessageManager = CreationalUtilityKt.errorMessageManager(create2, createClientInfo);
        Logger logger = spConfig.logger;
        if (logger == null) {
            logger = CreationalUtilityKt.createLogger(errorMessageManager);
        }
        JsonConverter create3 = JsonConverterImplKt.create(JsonConverter.INSTANCE);
        ConnectionManager connectionManager = ComponentFactoryKt.getConnectionManager(applicationContext);
        NetworkClient networkClient = ComponentFactoryKt.networkClient(applicationContext, build, ResponseManagerImplKt.create(ResponseManager.INSTANCE, create3, logger), logger);
        ViewsManager create4 = ViewsManagerKt.create(ViewsManager.INSTANCE, new WeakReference(activity), connectionManager, spConfig.messageTimeout);
        ExecutorManager create5 = ExecutorManagerKt.create(ExecutorManager.INSTANCE, applicationContext);
        HttpUrlManagerSingleton httpUrlManagerSingleton = HttpUrlManagerSingleton.INSTANCE;
        ConsentManagerUtils create6 = ConsentManagerUtilsKt.create(ConsentManagerUtils.INSTANCE, create2, create);
        Service create7 = ServiceImplKt.create(Service.INSTANCE, networkClient, create2, create6, create, logger, create5, connectionManager);
        ClientEventManager create8 = ClientEventManagerKt.create(ClientEventManager.INSTANCE, logger, create5, create6, spClient, connectionManager);
        return new SpConsentLibImpl(applicationContext, logger, create3, create7, create5, create4, create2, ConsentManagerKt.create(ConsentManager.INSTANCE, create7, create6, env2, logger, create, create5, create8), create, spClient, create8, httpUrlManagerSingleton, env2, connectionManager);
    }
}
