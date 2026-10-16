package com.sourcepoint.cmplibrary.creation;

import android.app.Activity;
import android.content.Context;
import com.example.cmplibrary.BuildConfig;
import com.ironsource.C3040d4;
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
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManagerImplKt;
import com.sourcepoint.cmplibrary.data.network.converter.ExceptionUtilsKt;
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
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: Builder.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/sourcepoint/cmplibrary/creation/Builder;", "", "()V", "spClient", "Lcom/sourcepoint/cmplibrary/SpClient;", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "weakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "build", "Lcom/sourcepoint/cmplibrary/SpConsentLib;", C3040d4.f.e, "", "m", "", "failParam", "p", "setContext", "context", "setSpClient", "setSpConfig", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Builder {
    private SpClient spClient;
    private SpConfig spConfig;
    private WeakReference<Activity> weakReference;

    public final Builder setSpClient(SpClient spClient) {
        Intrinsics.checkNotNullParameter(spClient, "spClient");
        this.spClient = spClient;
        return this;
    }

    public final Builder setSpConfig(SpConfig spConfig) {
        Intrinsics.checkNotNullParameter(spConfig, "spConfig");
        this.spConfig = spConfig;
        return this;
    }

    public final Builder setContext(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.weakReference = new WeakReference<>(context);
        return this;
    }

    public final SpConsentLib build() {
        Env env;
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
        SpConfig spConfig = this.spConfig;
        if (spConfig == null) {
            fail("spConfig");
            throw new KotlinNothingValueException();
        }
        long j = spConfig.messageTimeout;
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).build();
        SpClient spClient = this.spClient;
        if (spClient == null) {
            ExceptionUtilsKt.genericFail("SpClient must be set!!!");
            throw new KotlinNothingValueException();
        }
        WeakReference<Activity> weakReference = this.weakReference;
        if (weakReference == null) {
            failParam("context");
            throw new KotlinNothingValueException();
        }
        Activity activity = weakReference.get();
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        if (applicationContext == null) {
            failParam("context");
            throw new KotlinNothingValueException();
        }
        ClientInfo createClientInfo = CreationalUtilityKt.createClientInfo();
        DataStorage create = DataStorageImplKt.create(DataStorage.INSTANCE, applicationContext, DataStorageGdprKt.create(DataStorageGdpr.INSTANCE, applicationContext), DataStorageCcpaKt.create(DataStorageCcpa.INSTANCE, applicationContext), DataStorageUSNatKt.create(DataStorageUSNat.INSTANCE, applicationContext));
        CampaignManager create2 = CampaignManagerKt.create(CampaignManager.INSTANCE, create, spConfig);
        ErrorMessageManager errorMessageManager = CreationalUtilityKt.errorMessageManager(create2, createClientInfo);
        Logger logger = spConfig.logger;
        if (logger == null) {
            logger = CreationalUtilityKt.createLogger(errorMessageManager);
        }
        JsonConverter create3 = JsonConverterImplKt.create(JsonConverter.INSTANCE);
        ConnectionManager create4 = ConnectionManagerImplKt.create(ConnectionManager.INSTANCE, applicationContext);
        NetworkClient networkClient = ComponentFactoryKt.networkClient(applicationContext, build, ResponseManagerImplKt.create(ResponseManager.INSTANCE, create3, logger), logger);
        ViewsManager create5 = ViewsManagerKt.create(ViewsManager.INSTANCE, weakReference, create4, spConfig.messageTimeout);
        ExecutorManager create6 = ExecutorManagerKt.create(ExecutorManager.INSTANCE, applicationContext);
        HttpUrlManagerSingleton httpUrlManagerSingleton = HttpUrlManagerSingleton.INSTANCE;
        ConsentManagerUtils create7 = ConsentManagerUtilsKt.create(ConsentManagerUtils.INSTANCE, create2, create);
        Logger logger2 = logger;
        Service create8 = ServiceImplKt.create(Service.INSTANCE, networkClient, create2, create7, create, logger2, create6, create4);
        ClientEventManager create9 = ClientEventManagerKt.create(ClientEventManager.INSTANCE, logger2, create6, create7, spClient, create4);
        return new SpConsentLibImpl(applicationContext, logger2, create3, create8, create6, create5, create2, ConsentManagerKt.create(ConsentManager.INSTANCE, create8, create7, env2, logger2, create, create6, create9), create, spClient, create9, httpUrlManagerSingleton, env2, create4);
    }

    private final Void fail(String m) {
        throw new RuntimeException("Invalid class exception. " + m + " is not an available option.");
    }

    private final Void failParam(String p) {
        throw new RuntimeException(p + " cannot be null!!!");
    }
}
