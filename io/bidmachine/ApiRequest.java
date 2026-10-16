package io.bidmachine;

import android.text.TextUtils;
import com.explorestack.protobuf.openrtb.Openrtb;
import com.explorestack.protobuf.openrtb.Request;
import com.explorestack.protobuf.openrtb.Response;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.protobuf.InitRequest;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.protobuf.analytics.events.SDKEvent;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes7.dex */
public class ApiRequest<RequestDataType, ResponseType> extends NetworkRequest<RequestDataType, ResponseType, BMError> {
    static int REQUEST_TIMEOUT = 10000;
    String requiredUrl;
    int timeOut;

    public static abstract class ApiDataBinder<RequestDataType, ResponseDataType> extends NetworkRequest.RequestDataBinder<RequestDataType, ResponseDataType, BMError> {
    }

    private ApiRequest(NetworkRequest.Method method, String path, RequestDataType requestData) {
        super(method, path, requestData);
        addContentEncoder(new NetworkRequest.GZIPRequestDataEncoder());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.core.NetworkRequest
    public BMError obtainError(URLConnection connection, int responseCode) {
        BMError internal;
        if (responseCode >= 200 && responseCode < 300) {
            return BMError.BMServerNoFill;
        }
        if (responseCode >= 400 && responseCode < 500) {
            internal = BMError.Request;
        } else if (responseCode >= 500 && responseCode < 600) {
            internal = BMError.Server;
        } else {
            internal = BMError.internal("Unknown server error");
        }
        return new BMError(internal, responseCode, "Server returned " + responseCode + " code");
    }

    static /* synthetic */ String lambda$obtainError$0(Throwable th, URLConnection uRLConnection) {
        return "obtainError: " + th + "(" + uRLConnection + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.core.NetworkRequest
    public BMError obtainError(final URLConnection connection, final Throwable t) {
        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ApiRequest$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return ApiRequest.lambda$obtainError$0(t, connection);
            }
        });
        if (t instanceof UnknownHostException) {
            return BMError.NoConnection;
        }
        if ((t instanceof SocketTimeoutException) || (t instanceof ConnectTimeoutException)) {
            return BMError.TimeoutError;
        }
        return BMError.throwable("Unknown api request error", t);
    }

    @Override // io.bidmachine.core.NetworkRequest
    protected String getBaseUrl() {
        return this.requiredUrl;
    }

    @Override // io.bidmachine.core.NetworkRequest
    protected void prepareRequestParams(URLConnection connection) {
        super.prepareRequestParams(connection);
        connection.setConnectTimeout(this.timeOut);
        connection.setReadTimeout(this.timeOut);
    }

    public static class Builder<RequestDataType, ResponseDataType> {
        private NetworkRequest.Callback<ResponseDataType, BMError> callback;
        private NetworkRequest.CancelCallback cancelCallback;
        private ApiDataBinder<RequestDataType, ResponseDataType> dataBinder;
        private RequestDataType requestData;
        private String url;
        private int timeOut = ApiRequest.REQUEST_TIMEOUT;
        private NetworkRequest.Method method = NetworkRequest.Method.Post;

        public Builder<RequestDataType, ResponseDataType> url(String url) {
            this.url = url;
            return this;
        }

        public Builder<RequestDataType, ResponseDataType> setDataBinder(ApiDataBinder<RequestDataType, ResponseDataType> dataBinder) {
            this.dataBinder = dataBinder;
            return this;
        }

        public Builder<RequestDataType, ResponseDataType> setRequestData(RequestDataType requestData) {
            this.requestData = requestData;
            return this;
        }

        public Builder<RequestDataType, ResponseDataType> setLoadingTimeOut(int timeOut) {
            if (timeOut <= 0) {
                timeOut = ApiRequest.REQUEST_TIMEOUT;
            }
            this.timeOut = timeOut;
            return this;
        }

        public Builder<RequestDataType, ResponseDataType> setCallback(NetworkRequest.Callback<ResponseDataType, BMError> callback) {
            this.callback = callback;
            return this;
        }

        public Builder<RequestDataType, ResponseDataType> setCancelCallback(NetworkRequest.CancelCallback cancelCallback) {
            this.cancelCallback = cancelCallback;
            return this;
        }

        public Builder<RequestDataType, ResponseDataType> setMethod(NetworkRequest.Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return this.url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ApiRequest<RequestDataType, ResponseDataType> build() {
            ApiRequest<RequestDataType, ResponseDataType> apiRequest = new ApiRequest<>(this.method, null, this.requestData);
            apiRequest.setCallback(this.callback);
            apiRequest.setCancelCallback(this.cancelCallback);
            apiRequest.setDataBinder(this.dataBinder);
            apiRequest.requiredUrl = this.url;
            apiRequest.timeOut = this.timeOut;
            return apiRequest;
        }

        public ApiRequest<RequestDataType, ResponseDataType> request() {
            ApiRequest<RequestDataType, ResponseDataType> build = build();
            build.request();
            return build;
        }
    }

    public static class ApiInitDataBinder extends ApiDataBinder<InitRequest, InitResponse> {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ Object createSuccessResult(NetworkRequest networkRequest, URLConnection urlConnection, byte[] bytes) throws Exception {
            return createSuccessResult((NetworkRequest<InitRequest, InitResponse, BMError>) networkRequest, urlConnection, bytes);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ byte[] obtainData(NetworkRequest networkRequest, URLConnection urlConnection, Object initRequest) throws Exception {
            return obtainData((NetworkRequest<InitRequest, InitResponse, BMError>) networkRequest, urlConnection, (InitRequest) initRequest);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<InitRequest, InitResponse, BMError> networkRequest, URLConnection urlConnection) {
            urlConnection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        protected byte[] obtainData(NetworkRequest<InitRequest, InitResponse, BMError> networkRequest, URLConnection urlConnection, InitRequest initRequest) throws Exception {
            ProtoLogger.log("Init Request", initRequest);
            if (initRequest != null) {
                return initRequest.toByteArray();
            }
            return null;
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected InitResponse createSuccessResult(NetworkRequest<InitRequest, InitResponse, BMError> networkRequest, URLConnection urlConnection, byte[] bytes) throws Exception {
            InitResponse parseFrom = InitResponse.parseFrom(bytes);
            ProtoLogger.log("Init Response", parseFrom);
            return parseFrom;
        }
    }

    public static class ApiResponseAuctionDataBinder extends ApiDataBinder<Request, Response> {
        protected byte[] obtainData(NetworkRequest<Request, Response, BMError> request, URLConnection connection, Request requestData) throws Exception {
            return null;
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ Object createSuccessResult(NetworkRequest request, URLConnection connection, byte[] resultData) throws Exception {
            return createSuccessResult((NetworkRequest<Request, Response, BMError>) request, connection, resultData);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ byte[] obtainData(NetworkRequest request, URLConnection connection, Object requestData) throws Exception {
            return obtainData((NetworkRequest<Request, Response, BMError>) request, connection, (Request) requestData);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<Request, Response, BMError> request, URLConnection connection) {
            connection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected Response createSuccessResult(NetworkRequest<Request, Response, BMError> request, URLConnection connection, byte[] resultData) throws Exception {
            Openrtb parseFrom = Openrtb.parseFrom(resultData);
            if (parseFrom == null) {
                return null;
            }
            ProtoLogger.log("Auction Response", parseFrom);
            return parseFrom.getResponse();
        }
    }

    public static class ApiAuctionDataBinder extends ApiResponseAuctionDataBinder {
        @Override // io.bidmachine.ApiRequest.ApiResponseAuctionDataBinder, io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ byte[] obtainData(NetworkRequest request, URLConnection connection, Object requestData) throws Exception {
            return obtainData((NetworkRequest<Request, Response, BMError>) request, connection, (Request) requestData);
        }

        @Override // io.bidmachine.ApiRequest.ApiResponseAuctionDataBinder
        protected byte[] obtainData(NetworkRequest<Request, Response, BMError> request, URLConnection connection, Request requestData) throws Exception {
            Openrtb.Builder newBuilder = Openrtb.newBuilder();
            newBuilder.setRequest(requestData);
            newBuilder.setVer("3.0");
            newBuilder.setDomainspec("adcom");
            newBuilder.setDomainver("1.0");
            ProtoLogger.log("Auction Request", newBuilder);
            return newBuilder.build().toByteArray();
        }
    }

    public static class ApiTrackerDataBinder extends ApiDataBinder<Object, String> {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected String createSuccessResult(NetworkRequest<Object, String, BMError> request, URLConnection connection, byte[] resultData) throws Exception {
            return null;
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected byte[] obtainData(NetworkRequest<Object, String, BMError> request, URLConnection connection, Object requestData) throws Exception {
            return null;
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ Object createSuccessResult(NetworkRequest request, URLConnection connection, byte[] resultData) throws Exception {
            return createSuccessResult((NetworkRequest<Object, String, BMError>) request, connection, resultData);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<Object, String, BMError> request, URLConnection connection) {
            String userAgent = UserAgentManager.getUserAgent();
            if (TextUtils.isEmpty(userAgent)) {
                return;
            }
            connection.setRequestProperty("User-Agent", userAgent);
        }
    }

    public static class ApiEventDataBinder extends ApiDataBinder<SDKEvent, Void> {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected Void createSuccessResult(NetworkRequest<SDKEvent, Void, BMError> request, URLConnection connection, byte[] resultData) throws Exception {
            return null;
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ Object createSuccessResult(NetworkRequest request, URLConnection connection, byte[] resultData) throws Exception {
            return createSuccessResult((NetworkRequest<SDKEvent, Void, BMError>) request, connection, resultData);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ byte[] obtainData(NetworkRequest request, URLConnection connection, Object requestData) throws Exception {
            return obtainData((NetworkRequest<SDKEvent, Void, BMError>) request, connection, (SDKEvent) requestData);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<SDKEvent, Void, BMError> request, URLConnection connection) {
            connection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        protected byte[] obtainData(NetworkRequest<SDKEvent, Void, BMError> request, URLConnection connection, SDKEvent requestData) throws Exception {
            if (requestData != null) {
                return requestData.toByteArray();
            }
            return null;
        }
    }
}
