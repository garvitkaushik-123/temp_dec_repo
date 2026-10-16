package io.bidmachine.rendering.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.taskmanager.CancelableTask;
import io.bidmachine.util.network.NetworkUtils;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.NetworkTaskManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class NetworkRequest<ResponseType> {
    private static final TaskManager m = new NetworkTaskManager();

    /* renamed from: a, reason: collision with root package name */
    private final String f7191a;
    private final Method b;
    private final Map<String, String> c;
    private final Map<String, String> d;
    private final Integer e;
    private final Integer f;
    private final UrlConnectionProcessor g;
    private final DataRetriever h;
    private final ResponseProcessor<ResponseType> i;
    private final Listener<ResponseType> j;
    private TaskManager k;
    private CancelableTask l;

    public static class Builder<ResponseType> {

        /* renamed from: a, reason: collision with root package name */
        private final String f7192a;
        private final Method b;
        private final Map<String, String> c = new HashMap();
        private final Map<String, String> d = new HashMap();
        private Integer e;
        private Integer f;
        private UrlConnectionProcessor g;
        private DataRetriever h;
        private ResponseProcessor<ResponseType> i;
        private Listener<ResponseType> j;

        public Builder(String url, Method method) {
            this.f7192a = url;
            this.b = method;
        }

        public Builder<ResponseType> addHeader(String key, String value) {
            this.c.put(key, value);
            return this;
        }

        public Builder<ResponseType> addQueryParameter(String key, String value) {
            this.d.put(key, value);
            return this;
        }

        public NetworkRequest<ResponseType> build() {
            return new NetworkRequest<>(this.f7192a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public NetworkRequest<ResponseType> send() {
            NetworkRequest<ResponseType> build = build();
            build.send();
            return build;
        }

        public Builder<ResponseType> setConnectTimeout(Integer connectTimeout) {
            this.e = connectTimeout;
            return this;
        }

        public Builder<ResponseType> setHeaders(Map<String, String> headers) {
            Utils.set(this.c, headers);
            return this;
        }

        public Builder<ResponseType> setListener(Listener<ResponseType> listener) {
            this.j = listener;
            return this;
        }

        public Builder<ResponseType> setQueryParameters(Map<String, String> parameters) {
            Utils.set(this.d, parameters);
            return this;
        }

        public Builder<ResponseType> setReadTimeout(Integer readTimeout) {
            this.f = readTimeout;
            return this;
        }

        public Builder<ResponseType> setRequestDataRetriever(DataRetriever requestDataRetriever) {
            this.h = requestDataRetriever;
            return this;
        }

        public Builder<ResponseType> setResponseTransformer(ResponseProcessor<ResponseType> responseProcessor) {
            this.i = responseProcessor;
            return this;
        }

        public Builder<ResponseType> setUrlConnectionProcessor(UrlConnectionProcessor urlConnectionProcessor) {
            this.g = urlConnectionProcessor;
            return this;
        }

        public Builder<ResponseType> setUserAgent(String userAgent) {
            if (!TextUtils.isEmpty(userAgent)) {
                addHeader("User-Agent", userAgent);
            }
            return this;
        }
    }

    public static abstract class ByteArrayProcessor<T> implements ResponseProcessor<T>, ResponseTransformer<byte[], T> {
        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseProcessor
        public T process(URLConnection urlConnection) {
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            InputStream inputStream2 = null;
            try {
                inputStream = urlConnection.getInputStream();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    inputStream2 = inputStream;
                    th = th;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                Utils.write(inputStream, byteArrayOutputStream);
                T transform = transform(byteArrayOutputStream.toByteArray());
                io.bidmachine.util.Utils.flushSafely(byteArrayOutputStream);
                io.bidmachine.util.Utils.closeSafely(byteArrayOutputStream);
                io.bidmachine.util.Utils.closeSafely(inputStream);
                return transform;
            } catch (Throwable th3) {
                inputStream2 = inputStream;
                th = th3;
                io.bidmachine.util.Utils.flushSafely(byteArrayOutputStream);
                io.bidmachine.util.Utils.closeSafely(byteArrayOutputStream);
                io.bidmachine.util.Utils.closeSafely(inputStream2);
                throw th;
            }
        }
    }

    public interface DataRetriever {
        byte[] retrieve();
    }

    public static abstract class FileOutputStreamProcessor<T> implements ResponseProcessor<T>, ResponseTransformer<File, T> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f7193a;
        private final File b;

        public FileOutputStreamProcessor(Context context, File file) {
            this.f7193a = context.getApplicationContext();
            this.b = file;
        }

        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseProcessor
        public T process(URLConnection urlConnection) {
            FileOutputStream fileOutputStream;
            File externalDir = io.bidmachine.util.file.FileUtils.getExternalDir(this.f7193a);
            if (externalDir == null) {
                throw new IllegalStateException("Can't get external dir");
            }
            File createTempFile = io.bidmachine.util.file.FileUtils.createTempFile(externalDir);
            long contentLength = urlConnection.getContentLength();
            InputStream inputStream = null;
            try {
                InputStream inputStream2 = urlConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(createTempFile);
                    try {
                        long write = Utils.write(inputStream2, fileOutputStream);
                        io.bidmachine.util.Utils.flushSafely(fileOutputStream);
                        io.bidmachine.util.Utils.closeSafely(fileOutputStream);
                        io.bidmachine.util.Utils.closeSafely(inputStream2);
                        if (contentLength != write) {
                            io.bidmachine.util.file.FileUtils.deleteFile(createTempFile);
                            throw new IllegalStateException("The downloaded file size does not match the stated size");
                        }
                        if (!io.bidmachine.util.file.FileUtils.renameToSafely(createTempFile, this.b)) {
                            io.bidmachine.util.file.FileUtils.deleteFile(createTempFile);
                            if (!io.bidmachine.util.file.FileUtils.hasContent(this.b)) {
                                throw new IllegalStateException("Can't rename temp file");
                            }
                        }
                        return transform(this.b);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        io.bidmachine.util.Utils.flushSafely(fileOutputStream);
                        io.bidmachine.util.Utils.closeSafely(fileOutputStream);
                        io.bidmachine.util.Utils.closeSafely(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
    }

    public interface Listener<ResponseType> {
        void onError(Error error);

        void onSuccess(ResponseType response);
    }

    public enum Method {
        Get("GET"),
        Post("POST");


        /* renamed from: a, reason: collision with root package name */
        private final String f7194a;

        Method(String networkName) {
            this.f7194a = networkName;
        }

        public String getNetworkName() {
            return this.f7194a;
        }
    }

    public interface ResponseProcessor<ResponseType> {
        ResponseType process(URLConnection urlConnection);
    }

    public interface ResponseTransformer<From, To> {
        To transform(From from);
    }

    public static class StringProcessor extends ByteArrayProcessor<String> {
        @Override // io.bidmachine.rendering.utils.NetworkRequest.ResponseTransformer
        public String transform(byte[] bytes) {
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    public interface UrlConnectionProcessor {
        void process(URLConnection urlConnection);
    }

    private class b extends CancelableTask {
        private b() {
        }

        @Override // io.bidmachine.rendering.utils.taskmanager.CancelableTask
        public void runTask() {
            NetworkRequest.this.b();
        }
    }

    public NetworkRequest(String url, Method method, Map<String, String> headers, Map<String, String> queryParameters, Integer connectTimeout, Integer readTimeout, UrlConnectionProcessor urlConnectionProcessor, DataRetriever requestDataRetriever, ResponseProcessor<ResponseType> responseProcessor, Listener<ResponseType> listener) {
        this.f7191a = url;
        this.b = method;
        this.e = connectTimeout;
        this.f = readTimeout;
        this.i = responseProcessor;
        this.c = headers;
        this.d = queryParameters;
        this.g = urlConnectionProcessor;
        this.h = requestDataRetriever;
        this.j = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection a2 = a(a(this.f7191a, this.d));
            try {
                int responseCode = a2.getResponseCode();
                if (responseCode == 200) {
                    ResponseProcessor<ResponseType> responseProcessor = this.i;
                    if (responseProcessor == null) {
                        a((NetworkRequest<ResponseType>) null);
                        NetworkUtils.disconnectSafely(a2);
                        return;
                    } else {
                        try {
                            a((NetworkRequest<ResponseType>) responseProcessor.process(a2));
                        } catch (Throwable th) {
                            a(Error.create(th));
                        }
                    }
                } else if (responseCode == 204) {
                    a((NetworkRequest<ResponseType>) null);
                } else {
                    a(new Error("Server response code - " + responseCode + " " + a2.getResponseMessage()));
                }
                NetworkUtils.disconnectSafely(a2);
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = a2;
                try {
                    a(Error.create(th));
                } finally {
                    NetworkUtils.disconnectSafely(httpURLConnection);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void cancel() {
        TaskManager taskManager = this.k;
        CancelableTask cancelableTask = this.l;
        if (taskManager != null && cancelableTask != null) {
            taskManager.cancel(cancelableTask);
        }
        a();
    }

    public void send() {
        send(m);
    }

    private HttpURLConnection a(String urlString) {
        HttpURLConnection httpURLConnection;
        byte[] retrieve;
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(this.b.getNetworkName());
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            UrlConnectionProcessor urlConnectionProcessor = this.g;
            if (urlConnectionProcessor != null) {
                urlConnectionProcessor.process(httpURLConnection);
            }
            Integer num = this.e;
            if (num != null && num.intValue() >= 0) {
                httpURLConnection.setConnectTimeout(this.e.intValue());
            }
            Integer num2 = this.f;
            if (num2 != null && num2.intValue() >= 0) {
                httpURLConnection.setReadTimeout(this.f.intValue());
            }
            DataRetriever dataRetriever = this.h;
            if (dataRetriever != null && (retrieve = dataRetriever.retrieve()) != null) {
                a(httpURLConnection, retrieve);
            }
            switch (httpURLConnection.getResponseCode()) {
                case MRAID_ERROR_VALUE:
                case INVALID_IFA_STATUS_VALUE:
                case 303:
                case MRAID_BRIDGE_ERROR_VALUE:
                case 307:
                case 308:
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField) && io.bidmachine.util.Utils.isHttpUrl(headerField)) {
                        NetworkUtils.disconnectSafely(httpURLConnection);
                        return a(headerField);
                    }
                    return httpURLConnection;
                case AD_EXPIRED_VALUE:
                case 306:
                default:
                    return httpURLConnection;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            NetworkUtils.disconnectSafely(httpURLConnection2);
            throw th;
        }
    }

    public void send(TaskManager taskManager) {
        cancel();
        this.k = taskManager;
        b bVar = new b();
        this.l = bVar;
        try {
            taskManager.execute(bVar);
        } catch (Throwable th) {
            a(Error.create(th));
        }
    }

    private String a(String url, Map<String, String> queryParameters) {
        if (queryParameters.isEmpty()) {
            return url;
        }
        Uri.Builder buildUpon = Uri.parse(url).buildUpon();
        for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    private void a(URLConnection urlConnection, byte[] data) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(urlConnection.getOutputStream());
            try {
                bufferedOutputStream2.write(data);
                io.bidmachine.iab.utils.Utils.flush(bufferedOutputStream2);
                io.bidmachine.iab.utils.Utils.close(bufferedOutputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                io.bidmachine.iab.utils.Utils.flush(bufferedOutputStream);
                io.bidmachine.iab.utils.Utils.close(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(ResponseType response) {
        Listener<ResponseType> listener = this.j;
        if (listener != null) {
            listener.onSuccess(response);
        }
    }

    private void a(Error error) {
        Listener<ResponseType> listener = this.j;
        if (listener != null) {
            listener.onError(error);
        }
    }

    private void a() {
        this.k = null;
        this.l = null;
    }
}
