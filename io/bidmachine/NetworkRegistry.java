package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingConfig;
import io.bidmachine.ads.networks.mraid.MraidConfig;
import io.bidmachine.ads.networks.nast.NastConfig;
import io.bidmachine.ads.networks.vast.VastConfig;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.internal.utils.LogSafeRunnable;
import io.bidmachine.protobuf.AdNetwork;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class NetworkRegistry {
    static final Map<String, NetworkAdapter> NETWORK_ADAPTER_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> CORE_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> FROM_INIT_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> PENDING_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> INITIALIZING_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<String, NetworkConfig> INITIALIZED_NETWORK_CONFIG_MAP = new ConcurrentHashMap();
    static final Map<AdsType, Map<String, NetworkConfig>> INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP = new ConcurrentHashMap(AdsType.values().length);
    static final Map<AdsType, Map<String, NetworkConfig>> INITIALIZED_NETWORK_CONFIG_TYPED_MAP = new ConcurrentHashMap(AdsType.values().length);
    private static final AtomicBoolean IS_NETWORKS_INITIALIZING_EXECUTED = new AtomicBoolean(false);
    private static final AtomicBoolean IS_CORE_NETWORKS_INITIALIZING = new AtomicBoolean(false);
    private static final AtomicBoolean IS_CORE_NETWORKS_INITIALIZED = new AtomicBoolean(false);
    private static final Object CORE_INITIALIZING_LOCK = new Object();
    private static final Object INITIALIZING_LOCK = new Object();

    interface NetworksInitializeCallback {
        void onExecuted();
    }

    static NetworkAdapter obtainAdapter(NetworkConfig networkConfig) {
        synchronized (NetworkRegistry.class) {
            String networkKey = networkConfig.getNetworkKey();
            NetworkAdapter adapter = getAdapter(networkKey);
            if (adapter != null) {
                return adapter;
            }
            NetworkAdapter createNetworkAdapter = networkConfig.createNetworkAdapter();
            NETWORK_ADAPTER_MAP.put(networkKey, createNetworkAdapter);
            return createNetworkAdapter;
        }
    }

    public static NetworkAdapter getAdapter(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        return NETWORK_ADAPTER_MAP.get(key);
    }

    static Map<String, NetworkConfig> copyOrNullInitializedCoreNetworkConfigs(AdsType adsType) {
        Map<String, NetworkConfig> map = INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP.get(adsType);
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    static Map<String, NetworkConfig> copyOrNullInitializedNetworkConfigs(AdsType adsType) {
        Map<String, NetworkConfig> map = INITIALIZED_NETWORK_CONFIG_TYPED_MAP.get(adsType);
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    static Collection<NetworkConfig> getCoreNetworkConfigList() {
        return CORE_NETWORK_CONFIG_MAP.values();
    }

    static void registerCoreNetworks() {
        registerCoreNetwork(new MraidConfig().withMediationConfig(AdsFormat.Banner, new HashMap()).withMediationConfig(AdsFormat.InterstitialStatic, new HashMap()).withMediationConfig(AdsFormat.RewardedStatic, new HashMap()));
        registerCoreNetwork(new VastConfig().withMediationConfig(AdsFormat.InterstitialVideo, new HashMap()).withMediationConfig(AdsFormat.RewardedVideo, new HashMap()));
        registerCoreNetwork(new NastConfig().withMediationConfig(AdsFormat.Native, new HashMap()));
        registerCoreNetwork(new AdaptiveRenderingConfig().withMediationConfig(AdsFormat.Banner, new HashMap()).withMediationConfig(AdsFormat.Interstitial, new HashMap()).withMediationConfig(AdsFormat.Rewarded, new HashMap()));
    }

    static void registerCoreNetwork(NetworkConfig networkConfig) {
        String networkKey = networkConfig.getNetworkKey();
        Map<String, NetworkConfig> map = CORE_NETWORK_CONFIG_MAP;
        if (map.containsKey(networkKey)) {
            return;
        }
        map.put(networkKey, networkConfig);
        registerNetwork(networkConfig);
    }

    static void registerAndInitializeCoreNetworks(Context context) {
        AtomicBoolean atomicBoolean = IS_CORE_NETWORKS_INITIALIZED;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (CORE_INITIALIZING_LOCK) {
            if (IS_CORE_NETWORKS_INITIALIZING.compareAndSet(false, true)) {
                registerCoreNetworks();
                initializeNetworksAwait(context, getCoreNetworkConfigList());
                atomicBoolean.set(true);
            }
        }
    }

    static NetworkConfig getConfig(String key) {
        if (key == null) {
            return null;
        }
        return INITIALIZED_NETWORK_CONFIG_MAP.get(key);
    }

    static Map<String, NetworkConfig> createInitNetworkConfigMap() {
        return new HashMap(FROM_INIT_NETWORK_CONFIG_MAP);
    }

    static boolean isNetworkRegistered(String name) {
        return getAdapter(name) != null;
    }

    static String checkAndPutNetwork(Context context, AdsType adsType, NetworkConfig networkConfig, Map<String, NetworkConfig> networkConfigMap) {
        NetworkAdapter adapter = getAdapter(networkConfig.getNetworkKey());
        if (adapter == null) {
            return "Network not registered";
        }
        if (!adapter.isAdsTypeSupported(adsType)) {
            return "Network does not support this ad type";
        }
        if (!adapter.isInitialized(context)) {
            return "Network not initialized";
        }
        networkConfigMap.put(networkConfig.getNetworkKey(), networkConfig);
        return null;
    }

    static Collection<NetworkConfig> getPendingNetworkConfigList() {
        return PENDING_NETWORK_CONFIG_MAP.values();
    }

    static void registerNetworks(NetworkConfig... networkConfigs) {
        if (networkConfigs == null) {
            return;
        }
        for (NetworkConfig networkConfig : networkConfigs) {
            registerNetwork(networkConfig);
        }
    }

    static void registerNetworks(Context context, final String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(jsonData);
            for (int i = 0; i < jSONArray.length(); i++) {
                NetworkConfig create = NetworkConfigFactory.create(context, jSONArray.getJSONObject(i));
                if (create != null) {
                    registerNetwork(create);
                }
            }
        } catch (JSONException e) {
            Logger.w(e);
        }
    }

    static void registerNetworks(final Context context, final String jsonData, final NetworkRegistryCallback callback) {
        CommonBackgroundTaskManager.get().execute(new LogSafeRunnable() { // from class: io.bidmachine.NetworkRegistry$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.SafeRunnable
            public final void onRun() {
                NetworkRegistry.lambda$registerNetworks$1(context, jsonData, callback);
            }
        });
    }

    static /* synthetic */ void lambda$registerNetworks$1(Context context, String str, final NetworkRegistryCallback networkRegistryCallback) throws Throwable {
        registerNetworks(context, str);
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.NetworkRegistry$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NetworkRegistry.lambda$registerNetworks$0(NetworkRegistryCallback.this);
            }
        });
    }

    static /* synthetic */ void lambda$registerNetworks$0(NetworkRegistryCallback networkRegistryCallback) {
        if (networkRegistryCallback != null) {
            networkRegistryCallback.onRegistered();
        }
    }

    static void registerNetwork(NetworkConfig networkConfig) {
        BidMachineImpl bidMachineImpl;
        Context appContext;
        if (networkConfig == null || isNetworkRegistered(networkConfig.getNetworkKey())) {
            return;
        }
        obtainAdapter(networkConfig);
        PENDING_NETWORK_CONFIG_MAP.put(networkConfig.getNetworkKey(), networkConfig);
        if (!isNetworksInitializingExecuted() || (appContext = (bidMachineImpl = BidMachineImpl.get()).getAppContext()) == null) {
            return;
        }
        initializeNetwork(new SimpleContextProvider(appContext), new InitializationParamsImpl(bidMachineImpl.getTargetingParams(), bidMachineImpl.getUserRestrictionParams()), networkConfig, null);
    }

    static void registerInitNetwork(Context context, AdNetwork adNetwork) {
        NetworkConfig create;
        if (isNetworkRegistered(adNetwork.getName()) || (create = NetworkConfigFactory.create(context, adNetwork)) == null) {
            return;
        }
        FROM_INIT_NETWORK_CONFIG_MAP.put(create.getNetworkKey(), create);
        registerNetwork(create);
    }

    static boolean isNetworksInitializingExecuted() {
        return IS_NETWORKS_INITIALIZING_EXECUTED.get();
    }

    static void initializeNetworksSync(final Context context) {
        if (IS_NETWORKS_INITIALIZING_EXECUTED.compareAndSet(false, true)) {
            initializeNetworksAwait(context.getApplicationContext());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.bidmachine.NetworkRegistry$1] */
    static void initializeNetworksAsync(final Context context, final NetworksInitializeCallback initializeCallback) {
        if (IS_NETWORKS_INITIALIZING_EXECUTED.compareAndSet(false, true)) {
            final Context applicationContext = context.getApplicationContext();
            new Thread() { // from class: io.bidmachine.NetworkRegistry.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    NetworkRegistry.initializeNetworksAwait(applicationContext);
                    NetworksInitializeCallback networksInitializeCallback = initializeCallback;
                    if (networksInitializeCallback != null) {
                        networksInitializeCallback.onExecuted();
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initializeNetworksAwait(Context context) {
        initializeNetworksAwait(context, getPendingNetworkConfigList());
    }

    private static void initializeNetworksAwait(Context context, Collection<NetworkConfig> networkConfigCollection) {
        BidMachineImpl bidMachineImpl = BidMachineImpl.get();
        initializeNetworksAwait(new SimpleContextProvider(context), new InitializationParamsImpl(bidMachineImpl.getTargetingParams(), bidMachineImpl.getUserRestrictionParams()), networkConfigCollection);
    }

    private static void initializeNetworksAwait(ContextProvider contextProvider, InitializationParams initializationParams, Collection<NetworkConfig> networkConfigCollection) {
        if (networkConfigCollection.isEmpty()) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(networkConfigCollection.size());
        for (NetworkConfig networkConfig : networkConfigCollection) {
            Objects.requireNonNull(countDownLatch);
            initializeNetwork(contextProvider, initializationParams, networkConfig, new NetworksInitializeCallback() { // from class: io.bidmachine.NetworkRegistry$$ExternalSyntheticLambda1
                @Override // io.bidmachine.NetworkRegistry.NetworksInitializeCallback
                public final void onExecuted() {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Logger.w(e);
        }
    }

    private static void initializeNetwork(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfig networkConfig, NetworksInitializeCallback callback) {
        synchronized (INITIALIZING_LOCK) {
            String networkKey = networkConfig.getNetworkKey();
            Map<String, NetworkConfig> map = INITIALIZING_NETWORK_CONFIG_MAP;
            if (map.containsKey(networkKey)) {
                PENDING_NETWORK_CONFIG_MAP.remove(networkKey);
                if (callback != null) {
                    callback.onExecuted();
                }
            } else {
                map.put(networkKey, networkConfig);
                new NetworkLoadTask(contextProvider, initializationParams, networkConfig, callback).executeAsync();
            }
        }
    }

    static void setLoggingEnabled(boolean enabled) {
        Iterator<Map.Entry<String, NetworkAdapter>> it = NETWORK_ADAPTER_MAP.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().setLogging(enabled);
            } catch (Throwable th) {
                Logger.w(th);
            }
        }
    }

    static void reset() {
        NETWORK_ADAPTER_MAP.clear();
        CORE_NETWORK_CONFIG_MAP.clear();
        FROM_INIT_NETWORK_CONFIG_MAP.clear();
        PENDING_NETWORK_CONFIG_MAP.clear();
        INITIALIZING_NETWORK_CONFIG_MAP.clear();
        INITIALIZED_NETWORK_CONFIG_MAP.clear();
        INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP.clear();
        INITIALIZED_NETWORK_CONFIG_TYPED_MAP.clear();
        IS_NETWORKS_INITIALIZING_EXECUTED.set(false);
        IS_CORE_NETWORKS_INITIALIZING.set(false);
        IS_CORE_NETWORKS_INITIALIZED.set(false);
        NetworkLoadTask.NETWORK_LOAD_TASK_LIST.clear();
    }

    static final class NetworkLoadTask implements Runnable {
        private static final Executor EXECUTOR = Executors.newFixedThreadPool(Math.max(8, Runtime.getRuntime().availableProcessors() * 4));
        private static final Object INITIALIZED_NETWORK_CONFIG_TYPED_LOCK = new Object();
        static final List<NetworkLoadTask> NETWORK_LOAD_TASK_LIST = new CopyOnWriteArrayList();
        private final NetworksInitializeCallback callback;
        private final ContextProvider contextProvider;
        private final InitializationParams initializationParams;
        private final NetworkConfig networkConfig;
        private final String networkKey;
        private final TrackingObject trackingObject;

        private NetworkLoadTask(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfig networkConfig, NetworksInitializeCallback callback) {
            this.contextProvider = contextProvider;
            this.initializationParams = initializationParams;
            this.networkConfig = networkConfig;
            this.callback = callback;
            String networkKey = networkConfig.getNetworkKey();
            this.networkKey = networkKey;
            this.trackingObject = new BidMachineTrackingObject(networkKey + "_initialize");
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d(this.networkKey, "Initialization started");
            try {
                this.trackingObject.eventStart(TrackEventType.HeaderBiddingNetworkInitialize, new TrackEventInfo().withParameter("HB_NETWORK", this.networkKey));
                NetworkAdapter obtainAdapter = NetworkRegistry.obtainAdapter(this.networkConfig);
                obtainAdapter.setLogging(Logger.isLoggingEnabled());
                obtainAdapter.initialize(this.contextProvider, this.initializationParams, this.networkConfig.getNetworkConfigParams(), new InitializationCallback(this));
                if (!NetworkRegistry.INITIALIZED_NETWORK_CONFIG_MAP.containsKey(this.networkKey)) {
                    NetworkRegistry.INITIALIZED_NETWORK_CONFIG_MAP.put(this.networkKey, this.networkConfig);
                }
                for (AdsType adsType : this.networkConfig.getSupportedAdsTypes(obtainAdapter)) {
                    synchronized (INITIALIZED_NETWORK_CONFIG_TYPED_LOCK) {
                        if (NetworkRegistry.CORE_NETWORK_CONFIG_MAP.containsKey(this.networkKey)) {
                            addAdsTypeNetworkConfig(NetworkRegistry.INITIALIZED_CORE_NETWORK_CONFIG_TYPED_MAP, adsType, this.networkKey, this.networkConfig);
                        }
                        addAdsTypeNetworkConfig(NetworkRegistry.INITIALIZED_NETWORK_CONFIG_TYPED_MAP, adsType, this.networkKey, this.networkConfig);
                    }
                }
                NetworkRegistry.PENDING_NETWORK_CONFIG_MAP.remove(this.networkKey);
            } catch (Throwable th) {
                Logger.w(th);
                onInitializationFail("Network initialization exception");
            }
            NetworksInitializeCallback networksInitializeCallback = this.callback;
            if (networksInitializeCallback != null) {
                networksInitializeCallback.onExecuted();
            }
        }

        void executeSync() {
            NETWORK_LOAD_TASK_LIST.add(this);
            run();
        }

        void executeAsync() {
            NETWORK_LOAD_TASK_LIST.add(this);
            try {
                EXECUTOR.execute(this);
            } catch (Throwable th) {
                Logger.w(th);
                onInitializationFail("Exception creating network initialization task");
            }
        }

        void onInitializationSuccess(final NetworkAdapter networkAdapter) {
            Logger.d(this.networkKey, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkRegistry$NetworkLoadTask$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Initialization completed: %s, %s", r0.obtainNetworkSdkVersion(), NetworkAdapter.this.getAdapterVersion());
                    return format;
                }
            });
            if (networkAdapter instanceof HeaderBiddingAdapter) {
                this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkInitialize, null, new EventData().setNetworkName(this.networkKey), null);
            } else {
                this.trackingObject.clearEvent(TrackEventType.HeaderBiddingNetworkInitialize);
            }
            NETWORK_LOAD_TASK_LIST.remove(this);
        }

        void onInitializationFail(final String error) {
            Logger.e(this.networkKey, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkRegistry$NetworkLoadTask$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Initialization error: %s", error);
                    return format;
                }
            });
            this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkInitialize, null, new EventData().setNetworkName(this.networkKey), BMError.adapterInitialization(error));
            NETWORK_LOAD_TASK_LIST.remove(this);
        }

        private void addAdsTypeNetworkConfig(Map<AdsType, Map<String, NetworkConfig>> storage, AdsType adsType, String networkKey, NetworkConfig networkConfig) {
            Map<String, NetworkConfig> map = storage.get(adsType);
            if (map == null) {
                map = new ConcurrentHashMap<>();
                storage.put(adsType, map);
            }
            map.put(networkKey, networkConfig);
        }

        private static class InitializationCallback implements InternalNetworkInitializationCallback {
            private final WeakReference<NetworkLoadTask> weakNetworkLoadTask;

            public InitializationCallback(NetworkLoadTask networkLoadTask) {
                this.weakNetworkLoadTask = new WeakReference<>(networkLoadTask);
            }

            @Override // io.bidmachine.InternalNetworkInitializationCallback
            public void onSuccess(NetworkAdapter networkAdapter) {
                NetworkLoadTask networkLoadTask = this.weakNetworkLoadTask.get();
                if (networkLoadTask != null) {
                    networkLoadTask.onInitializationSuccess(networkAdapter);
                }
            }

            @Override // io.bidmachine.InternalNetworkInitializationCallback
            public void onFail(NetworkAdapter networkAdapter, String error) {
                NetworkLoadTask networkLoadTask = this.weakNetworkLoadTask.get();
                if (networkLoadTask != null) {
                    networkLoadTask.onInitializationFail(error);
                }
            }
        }
    }
}
