package io.bidmachine.ads.networks.gam_dynamic;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes7.dex */
public class WaterfallNetworkRequest extends NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> {
    private final int timeOut;
    private final String url;

    public interface Callback extends NetworkRequest.Callback<Waterfall.Configuration, BMError>, NetworkRequest.CancelCallback {
    }

    public WaterfallNetworkRequest(String url, Waterfall.Result requestData, int timeOut) {
        super(NetworkRequest.Method.Post, null, requestData);
        this.url = url;
        this.timeOut = timeOut;
        setDataBinder(new RequestBinder());
    }

    @Override // io.bidmachine.core.NetworkRequest
    protected String getBaseUrl() throws Exception {
        return this.url;
    }

    @Override // io.bidmachine.core.NetworkRequest
    protected void prepareRequestParams(URLConnection urlConnection) {
        super.prepareRequestParams(urlConnection);
        urlConnection.setConnectTimeout(this.timeOut);
        urlConnection.setReadTimeout(this.timeOut);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.core.NetworkRequest
    public BMError obtainError(URLConnection urlConnection, int responseCode) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.core.NetworkRequest
    public BMError obtainError(URLConnection urlConnection, Throwable t) {
        if (t instanceof UnknownHostException) {
            return BMError.NoConnection;
        }
        if ((t instanceof SocketTimeoutException) || (t instanceof ConnectTimeoutException)) {
            return BMError.TimeoutError;
        }
        return BMError.throwable("Unknown api request error", t);
    }

    private static class RequestBinder extends NetworkRequest.RequestDataBinder<Waterfall.Result, Waterfall.Configuration, BMError> {
        private RequestBinder() {
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> networkRequest, URLConnection urlConnection) {
            urlConnection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public byte[] obtainData(NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> networkRequest, URLConnection urlConnection, Waterfall.Result waterfallResult) throws Exception {
            return Waterfall.newBuilder().setRequest(waterfallResult).build().toByteArray();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public Waterfall.Configuration createSuccessResult(NetworkRequest<Waterfall.Result, Waterfall.Configuration, BMError> networkRequest, URLConnection urlConnection, byte[] resultData) throws Exception {
            return Waterfall.parseFrom(resultData).getResponse();
        }
    }
}
