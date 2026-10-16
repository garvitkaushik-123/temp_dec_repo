package io.bidmachine;

import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.ApiRequest;
import io.bidmachine.ProtoTransformer;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
class AdResponseLoader {
    private NetworkCallback callback;
    private final String id;
    private Listener listener;
    private final Tag tag;

    interface Listener {
        void onCancel();

        void onFail(BMError bmError);

        void onSuccess(AdResponse adResponse);
    }

    public AdResponseLoader() {
        this(UUID.randomUUID().toString());
    }

    public AdResponseLoader(String id) {
        this.tag = new Tag("AdResponseLoader");
        this.id = id;
    }

    String getId() {
        return this.id;
    }

    public void load(AdRequestParameters adRequestParameters, NetworkAdUnitManager networkAdUnitManager, ApiRequest.Builder<?, Response> requestBuilder, Listener listener) {
        Logger.d(this.tag, "load");
        NetworkCallback networkCallback = this.callback;
        if (networkCallback != null) {
            networkCallback.clear();
        }
        this.listener = listener;
        NetworkCallback networkCallback2 = new NetworkCallback(this.id, requestBuilder.getUrl(), adRequestParameters, networkAdUnitManager, listener);
        this.callback = networkCallback2;
        requestBuilder.setCallback(networkCallback2);
        requestBuilder.setCancelCallback(this.callback);
        NetworkRequestManager.get().add(this.id, requestBuilder.request());
    }

    public void cancel() {
        Logger.d(this.tag, "cancel");
        this.listener = null;
        NetworkCallback networkCallback = this.callback;
        if (networkCallback != null) {
            networkCallback.clear();
            this.callback = null;
        }
    }

    static class NetworkCallback implements NetworkRequest.Callback<Response, BMError>, NetworkRequest.CancelCallback {
        private final AdRequestParameters adRequestParameters;
        private final String id;
        private final NetworkAdUnitManager networkAdUnitManager;
        private final String url;
        private final WeakReference<Listener> weakListener;
        private final AtomicBoolean isSent = new AtomicBoolean(false);
        private final AtomicBoolean isCleared = new AtomicBoolean(false);

        public NetworkCallback(String id, String url, AdRequestParameters adRequestParameters, NetworkAdUnitManager networkAdUnitManager, Listener listener) {
            this.id = id;
            this.url = url;
            this.adRequestParameters = adRequestParameters;
            this.networkAdUnitManager = networkAdUnitManager;
            this.weakListener = new WeakReference<>(listener);
        }

        @Override // io.bidmachine.core.NetworkRequest.Callback
        public void onSuccess(Response response) {
            NetworkRequestManager.get().remove(this.id);
            UrlProvider.setAuctionUrlFromSuccessRequest(this.url);
            ProtoTransformer.toAdResponse(this.adRequestParameters, this.networkAdUnitManager, response, new ProtoTransformer.Listener<AdResponse>() { // from class: io.bidmachine.AdResponseLoader.NetworkCallback.1
                @Override // io.bidmachine.ProtoTransformer.Listener
                public void onSuccess(AdResponse adResponse) {
                    AdResponseStatus adResponseStatus;
                    boolean cantSend = NetworkCallback.this.cantSend();
                    if (cantSend) {
                        adResponseStatus = AdResponseStatus.Idle;
                    } else {
                        adResponseStatus = AdResponseStatus.Busy;
                    }
                    adResponse.setStatus(adResponseStatus);
                    AdResponseManager.get().store(adResponse);
                    if (!cantSend) {
                        NetworkCallback.this.networkAdUnitManager.notifyNetworkAuctionResult(adResponse.getWinnerNetworkAdUnit());
                        NetworkCallback.this.sendSuccess(adResponse);
                    } else {
                        adResponse.release();
                    }
                }

                @Override // io.bidmachine.ProtoTransformer.Listener
                public void onFail(BMError error) {
                    NetworkCallback.this.networkAdUnitManager.notifyNetworkAuctionResult(null);
                    NetworkCallback.this.networkAdUnitManager.notifyNetworkClearAuction();
                    NetworkCallback.this.sendFail(error);
                }
            });
        }

        @Override // io.bidmachine.core.NetworkRequest.Callback
        public void onFail(BMError error) {
            NetworkRequestManager.get().remove(this.id);
            this.networkAdUnitManager.notifyNetworkAuctionResult(null);
            this.networkAdUnitManager.notifyNetworkClearAuction();
            AdResponse receive = AdResponseManager.get().receive(this.adRequestParameters);
            if (receive != null) {
                sendSuccess(receive);
            } else {
                sendFail(error);
            }
        }

        @Override // io.bidmachine.core.NetworkRequest.CancelCallback
        public void onCanceled() {
            NetworkRequestManager.get().remove(this.id);
            this.networkAdUnitManager.notifyNetworkClearAuction();
            sendCancel();
        }

        public void clear() {
            this.isCleared.set(true);
            this.weakListener.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean cantSend() {
            return this.isCleared.get() || this.isSent.get() || this.weakListener.get() == null;
        }

        private Listener prepareForSend() {
            if (cantSend()) {
                return null;
            }
            this.isSent.set(true);
            return this.weakListener.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendSuccess(AdResponse adResponse) {
            Listener prepareForSend = prepareForSend();
            if (prepareForSend != null) {
                prepareForSend.onSuccess(adResponse);
            } else {
                adResponse.setStatus(AdResponseStatus.Idle);
            }
            clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendFail(BMError error) {
            Listener prepareForSend = prepareForSend();
            if (prepareForSend != null) {
                prepareForSend.onFail(error);
            }
            clear();
        }

        private void sendCancel() {
            Listener prepareForSend = prepareForSend();
            if (prepareForSend != null) {
                prepareForSend.onCancel();
            }
            clear();
        }
    }
}
