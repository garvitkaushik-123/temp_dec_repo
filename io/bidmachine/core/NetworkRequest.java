package io.bidmachine.core;

import android.util.Base64;
import com.explorestack.protobuf.AbstractMessage;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.NetworkTaskManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> {
    private static final TaskManager TASK_MANAGER = new NetworkTaskManager();
    private Callback<RequestResultType, ErrorResultType> callback;
    private CancelCallback cancelCallback;
    private ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> contentEncoders;
    private URLConnection currentConnection;
    private State currentState = State.Idle;
    private RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> dataBinder;
    private ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> dataEncoders;
    private ErrorResultType errorResult;
    private final Method method;
    private final String path;
    private final RequestDataType requestData;
    private RequestResultType requestResult;

    public interface Callback<RequestResultType, ErrorResultType> {
        void onFail(ErrorResultType errorResultType);

        void onSuccess(RequestResultType requestResultType);
    }

    public interface CancelCallback {
        void onCanceled();
    }

    public static abstract class RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> {
        protected ErrorResultType createFailResult(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, byte[] resultData) throws Exception {
            return null;
        }

        protected abstract RequestResultType createSuccessResult(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, byte[] resultData) throws Exception;

        protected abstract byte[] obtainData(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, RequestDataType requestData) throws Exception;

        protected abstract void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection);

        protected void prepareRequest(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection) {
        }
    }

    public static abstract class RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> {
        protected abstract byte[] decode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, byte[] data) throws Exception;

        protected abstract byte[] encode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, byte[] data) throws Exception;

        protected void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection) {
        }
    }

    public enum State {
        Idle,
        Running,
        Success,
        Fail,
        Canceled
    }

    protected abstract ErrorResultType obtainError(URLConnection connection, int responseCode);

    protected abstract ErrorResultType obtainError(URLConnection connection, Throwable t);

    public enum Method {
        Get("GET"),
        Post("POST");

        private final String methodString;

        Method(String methodString) {
            this.methodString = methodString;
        }

        public void apply(URLConnection connection) throws ProtocolException {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).setRequestMethod(this.methodString);
            }
        }
    }

    public NetworkRequest(Method method, String path, RequestDataType requestData) {
        this.method = method;
        this.path = path;
        this.requestData = requestData;
    }

    public void setDataBinder(RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> dataBinder) {
        this.dataBinder = dataBinder;
    }

    public void addDataEncoder(RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> encoder) {
        if (this.dataEncoders == null) {
            this.dataEncoders = new ArrayList<>();
        }
        this.dataEncoders.add(encoder);
    }

    public void addContentEncoder(RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> encoder) {
        if (this.contentEncoders == null) {
            this.contentEncoders = new ArrayList<>();
        }
        this.contentEncoders.add(encoder);
    }

    public void setCallback(Callback<RequestResultType, ErrorResultType> callback) {
        this.callback = callback;
    }

    public void setCancelCallback(CancelCallback cancelCallback) {
        this.cancelCallback = cancelCallback;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public void request() {
        request(TASK_MANAGER);
    }

    public void request(TaskManager taskManager) {
        try {
            taskManager.execute(new NetworkRequestRunner());
        } catch (Throwable th) {
            Logger.w(th);
            Callback<RequestResultType, ErrorResultType> callback = this.callback;
            if (callback != null) {
                callback.onFail(obtainError((URLConnection) null, th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process() {
        URLConnection uRLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> requestDataBinder;
        BufferedOutputStream bufferedOutputStream;
        this.currentState = State.Running;
        try {
            URLConnection openConnection = (this.path != null ? new URL(getBaseUrl() + RemoteSettings.FORWARD_SLASH_STRING + this.path) : new URL(getBaseUrl())).openConnection();
            try {
                this.currentConnection = openConnection;
                this.method.apply(openConnection);
                prepareRequestParams(openConnection);
                byte[] obtainRequestData = obtainRequestData(openConnection);
                if (obtainRequestData != null) {
                    byte[] encodeRequestData = encodeRequestData(openConnection, obtainRequestData);
                    openConnection.setDoOutput(true);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(openConnection.getOutputStream());
                        try {
                            bufferedOutputStream.write(encodeRequestData);
                            Utils.flush(bufferedOutputStream);
                            Utils.close(bufferedOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            Utils.flush(bufferedOutputStream);
                            Utils.close(bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                }
                try {
                    int obtainResponseCode = obtainResponseCode(openConnection);
                    if (isCanceled()) {
                        Utils.flush(null);
                        Utils.close(null);
                        Utils.close(null);
                        if (openConnection instanceof HttpURLConnection) {
                            ((HttpURLConnection) openConnection).disconnect();
                        }
                        this.currentConnection = null;
                        if (isCanceled()) {
                            return;
                        }
                        this.currentState = this.errorResult == null ? State.Success : State.Fail;
                        return;
                    }
                    if (obtainResponseCode != 200) {
                        this.errorResult = obtainError(openConnection, obtainResponseCode);
                        inputStream2 = null;
                        byteArrayOutputStream2 = null;
                    } else {
                        inputStream2 = openConnection.getInputStream();
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                        } catch (Throwable th3) {
                            inputStream = inputStream2;
                            th = th3;
                            byteArrayOutputStream = null;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                }
                            }
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            if (byteArray != null) {
                                byteArray = decodeResponseData(openConnection, byteArray);
                            }
                            if (byteArray != null && byteArray.length > 0 && (requestDataBinder = this.dataBinder) != null) {
                                RequestResultType createSuccessResult = requestDataBinder.createSuccessResult(this, openConnection, byteArray);
                                this.requestResult = createSuccessResult;
                                if (createSuccessResult == null) {
                                    this.errorResult = this.dataBinder.createFailResult(this, openConnection, byteArray);
                                }
                            }
                        } catch (Throwable th4) {
                            inputStream = inputStream2;
                            th = th4;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            Utils.flush(byteArrayOutputStream);
                            Utils.close(byteArrayOutputStream);
                            Utils.close(inputStream);
                            throw th;
                        }
                    }
                    Utils.flush(byteArrayOutputStream2);
                    Utils.close(byteArrayOutputStream2);
                    Utils.close(inputStream2);
                    if (openConnection instanceof HttpURLConnection) {
                        ((HttpURLConnection) openConnection).disconnect();
                    }
                    this.currentConnection = null;
                    if (isCanceled()) {
                        return;
                    }
                    this.currentState = this.errorResult == null ? State.Success : State.Fail;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th6) {
                uRLConnection = openConnection;
                th = th6;
                try {
                    Logger.w(th);
                    this.errorResult = obtainError(uRLConnection, th);
                } finally {
                    if (uRLConnection instanceof HttpURLConnection) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                    this.currentConnection = null;
                    if (!isCanceled()) {
                        this.currentState = this.errorResult == null ? State.Success : State.Fail;
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            uRLConnection = null;
        }
    }

    protected void prepareRequestParams(URLConnection connection) {
        connection.setConnectTimeout(40000);
        connection.setReadTimeout(40000);
    }

    protected byte[] obtainRequestData(URLConnection connection) throws Exception {
        RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> requestDataBinder = this.dataBinder;
        if (requestDataBinder == null) {
            return null;
        }
        requestDataBinder.prepareRequest(this, connection);
        this.dataBinder.prepareHeaders(this, connection);
        return this.dataBinder.obtainData(this, connection, this.requestData);
    }

    protected byte[] encodeRequestData(URLConnection connection, byte[] requestData) throws Exception {
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList = this.dataEncoders;
        if (arrayList != null) {
            Iterator<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> it = arrayList.iterator();
            while (it.hasNext()) {
                RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> next = it.next();
                next.prepareHeaders(this, connection);
                requestData = next.encode(this, connection, requestData);
            }
        }
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList2 = this.contentEncoders;
        if (arrayList2 != null) {
            Iterator<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> next2 = it2.next();
                next2.prepareHeaders(this, connection);
                requestData = next2.encode(this, connection, requestData);
            }
        }
        return requestData;
    }

    protected byte[] decodeResponseData(URLConnection connection, byte[] responseData) throws Exception {
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList = this.contentEncoders;
        if (arrayList != null) {
            Iterator<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> it = arrayList.iterator();
            while (it.hasNext()) {
                responseData = it.next().decode(this, connection, responseData);
            }
        }
        ArrayList<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> arrayList2 = this.dataEncoders;
        if (arrayList2 != null) {
            Iterator<RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType>> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                responseData = it2.next().decode(this, connection, responseData);
            }
        }
        return responseData;
    }

    private int obtainResponseCode(URLConnection connection) throws IOException {
        if (connection instanceof HttpURLConnection) {
            return ((HttpURLConnection) connection).getResponseCode();
        }
        return -1;
    }

    private InputStream obtainErrorStream(URLConnection connection) {
        if (connection instanceof HttpURLConnection) {
            return ((HttpURLConnection) connection).getErrorStream();
        }
        return null;
    }

    protected String getBaseUrl() throws Exception {
        return "TODO: implement url";
    }

    public void cancel() {
        this.currentState = State.Canceled;
        CancelCallback cancelCallback = this.cancelCallback;
        if (cancelCallback != null) {
            cancelCallback.onCanceled();
        }
    }

    public boolean isCanceled() {
        return this.currentState == State.Canceled;
    }

    static abstract class ProtobufDataBinder<RequestDataType extends AbstractMessage, RequestResultType, ErrorResultType> extends RequestDataBinder<RequestDataType, RequestResultType, ErrorResultType> {
        ProtobufDataBinder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected /* bridge */ /* synthetic */ byte[] obtainData(NetworkRequest request, URLConnection connection, Object requestData) throws Exception {
            return obtainData((NetworkRequest<URLConnection, RequestResultType, ErrorResultType>) request, connection, (URLConnection) requestData);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection) {
            connection.setRequestProperty("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        }

        protected byte[] obtainData(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, RequestDataType requestData) {
            if (requestData != null) {
                return requestData.toByteArray();
            }
            return null;
        }
    }

    static abstract class JsonDataBinder<RequestResultType, ErrorResultType> extends RequestDataBinder<JSONObject, RequestResultType, ErrorResultType> {
        JsonDataBinder() {
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        protected void prepareHeaders(NetworkRequest<JSONObject, RequestResultType, ErrorResultType> request, URLConnection connection) {
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public byte[] obtainData(NetworkRequest<JSONObject, RequestResultType, ErrorResultType> request, URLConnection connection, JSONObject requestData) throws Exception {
            if (requestData != null) {
                return requestData.toString().getBytes("UTF-8");
            }
            return null;
        }
    }

    public static class SimpleJsonObjectDataBinder<ErrorResultType> extends JsonDataBinder<JSONObject, ErrorResultType> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public JSONObject createSuccessResult(NetworkRequest<JSONObject, JSONObject, ErrorResultType> request, URLConnection connection, byte[] resultData) throws Exception {
            return new JSONObject(new String(resultData));
        }
    }

    public static class SimpleJsonArrayDataBinder<ErrorResultType> extends JsonDataBinder<JSONArray, ErrorResultType> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.core.NetworkRequest.RequestDataBinder
        public JSONArray createSuccessResult(NetworkRequest<JSONObject, JSONArray, ErrorResultType> request, URLConnection connection, byte[] resultData) throws Exception {
            return new JSONArray(new String(resultData));
        }
    }

    public static class Base64RequestDataEncoder extends RequestDataEncoder {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] encode(NetworkRequest request, URLConnection connection, byte[] data) {
            return Base64.encode(data, 0);
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] decode(NetworkRequest request, URLConnection connection, byte[] data) {
            return Base64.decode(data, 0);
        }
    }

    public static class GZIPRequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> extends RequestDataEncoder<RequestDataType, RequestResultType, ErrorResultType> {
        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected void prepareHeaders(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection) {
            connection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
            connection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] encode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, byte[] data) throws Exception {
            GZIPOutputStream gZIPOutputStream;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        gZIPOutputStream.write(data);
                        Utils.close(gZIPOutputStream);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        Utils.flush(byteArrayOutputStream2);
                        Utils.close(byteArrayOutputStream2);
                        Utils.flush(null);
                        Utils.close(null);
                        return byteArray;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        Utils.flush(byteArrayOutputStream);
                        Utils.close(byteArrayOutputStream);
                        Utils.flush(gZIPOutputStream);
                        Utils.close(gZIPOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
            }
        }

        @Override // io.bidmachine.core.NetworkRequest.RequestDataEncoder
        protected byte[] decode(NetworkRequest<RequestDataType, RequestResultType, ErrorResultType> request, URLConnection connection, byte[] data) throws Exception {
            GZIPInputStream gZIPInputStream;
            ByteArrayInputStream byteArrayInputStream;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            if (!"gzip".equals(connection.getContentEncoding())) {
                return data;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(data);
                    try {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    Utils.flush(byteArrayOutputStream);
                                    Utils.close(byteArrayOutputStream);
                                    Utils.close(byteArrayInputStream);
                                    Utils.close(gZIPInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            Utils.flush(byteArrayOutputStream);
                            Utils.close(byteArrayOutputStream);
                            Utils.close(byteArrayInputStream);
                            Utils.close(gZIPInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        gZIPInputStream = null;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    byteArrayInputStream = null;
                    th = th4;
                    gZIPInputStream = null;
                }
            } catch (Throwable th5) {
                gZIPInputStream = null;
                byteArrayInputStream = null;
                th = th5;
                byteArrayOutputStream = null;
            }
        }
    }

    private final class NetworkRequestRunner implements Runnable {
        private NetworkRequestRunner() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            NetworkRequest.this.process();
            if (NetworkRequest.this.callback == null || NetworkRequest.this.isCanceled()) {
                return;
            }
            if (NetworkRequest.this.currentState == State.Success) {
                NetworkRequest.this.callback.onSuccess(NetworkRequest.this.requestResult);
            } else {
                NetworkRequest.this.callback.onFail(NetworkRequest.this.errorResult);
            }
        }
    }
}
