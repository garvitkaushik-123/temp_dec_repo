package com.tiktok.util;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.google.common.net.HttpHeaders;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.appevents.TTCrashHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class HttpRequestUtil {
    private static final String API_ERR = "api_err";
    private static final String MONITOR_API_TYPE = "monitor";
    private static final String TAG = "com.tiktok.util.HttpRequestUtil";
    private static final TTLogger ttLogger = new TTLogger(HttpRequestUtil.class.getCanonicalName(), TikTokBusinessSdk.getLogLevel());

    public static boolean shouldRedirect(int status) {
        if (status != 200) {
            return status == 302 || status == 301 || status == 303 || status == 307;
        }
        return false;
    }

    public static class HttpRequestOptions {
        private static int UNSET = -1;
        public int connectTimeout;
        public int readTimeout;

        public HttpRequestOptions() {
            int i = UNSET;
            this.connectTimeout = i;
            this.readTimeout = i;
        }

        public void configConnection(HttpURLConnection connection) {
            int i = this.connectTimeout;
            if (i != UNSET) {
                connection.setConnectTimeout(i);
            }
            int i2 = this.readTimeout;
            if (i2 != UNSET) {
                connection.setReadTimeout(i2);
            }
        }
    }

    public static String doGet(String url, Map<String, String> headerParamMap) {
        HttpRequestOptions httpRequestOptions = new HttpRequestOptions();
        httpRequestOptions.connectTimeout = 2000;
        httpRequestOptions.readTimeout = 5000;
        return doGet(url, headerParamMap, httpRequestOptions);
    }

    public static HttpsURLConnection connect(String url, Map<String, String> headerParamMap, HttpRequestOptions options, String method, String contentLength) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(url).openConnection();
            try {
                httpsURLConnection2.setRequestMethod(method);
                options.configConnection(httpsURLConnection2);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setUseCaches(false);
                if (method.equals("GET")) {
                    httpsURLConnection2.setDoOutput(false);
                } else if (method.equals("POST")) {
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setRequestProperty(HttpHeaders.CONTENT_LENGTH, contentLength);
                }
                for (Map.Entry<String, String> entry : headerParamMap.entrySet()) {
                    httpsURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpsURLConnection2.connect();
                return httpsURLConnection2;
            } catch (Exception e) {
                e = e;
                httpsURLConnection = httpsURLConnection2;
                TTCrashHandler.handleCrash(TAG, e, 1);
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (Exception e2) {
                        TTCrashHandler.handleCrash(TAG, e2, 1);
                    }
                }
                return httpsURLConnection;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String doGet(String url, Map<String, String> headerParamMap, HttpRequestOptions options) {
        String message;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "";
        try {
            message = "";
            str2 = new URL(url).getPath().split("/app_sdk/")[1];
        } catch (Throwable th) {
            message = th.getMessage();
        }
        HttpsURLConnection connect = connect(url, headerParamMap, options, "GET", null);
        if (connect == null) {
            return null;
        }
        int i = 0;
        try {
            try {
                if (shouldRedirect(connect.getResponseCode())) {
                    String headerField = connect.getHeaderField("Location");
                    connect.disconnect();
                    connect = connect(headerField, headerParamMap, options, "GET", null);
                }
                i = connect.getResponseCode();
                str = i == 200 ? streamToString(connect.getInputStream()) : null;
                if (connect != null) {
                    try {
                        connect.disconnect();
                    } catch (Exception e) {
                        message = e.getMessage();
                        TTCrashHandler.handleCrash(TAG, e, 1);
                    }
                }
            } catch (Throwable th2) {
                if (connect != null) {
                    try {
                        connect.disconnect();
                    } catch (Exception e2) {
                        e2.getMessage();
                        TTCrashHandler.handleCrash(TAG, e2, 1);
                    }
                }
                throw th2;
            }
        } catch (Exception e3) {
            message = e3.getMessage();
            TTCrashHandler.handleCrash(TAG, e3, 1);
            if (connect != null) {
                try {
                    connect.disconnect();
                } catch (Exception e4) {
                    message = e4.getMessage();
                    TTCrashHandler.handleCrash(TAG, e4, 1);
                }
            }
            str = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            int codeFromApi = getCodeFromApi(str);
            if (codeFromApi != 0) {
                if (i == 200) {
                    message = getMessageFromApi(str);
                    i = codeFromApi;
                }
                TikTokBusinessSdk.getAppEventLogger().monitorMetric(API_ERR, TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)).put("latency", currentTimeMillis2 - currentTimeMillis).put("api_type", str2).put("status_code", i).put(PglCryptUtils.KEY_MESSAGE, message).put("log_id", getLogIDFromApi(str)), null);
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static String doPost(String url, Map<String, String> headerParamMap, String jsonStr) {
        HttpRequestOptions httpRequestOptions = new HttpRequestOptions();
        httpRequestOptions.connectTimeout = 2000;
        httpRequestOptions.readTimeout = 5000;
        return doPost(url, headerParamMap, jsonStr, httpRequestOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0137 A[Catch: Exception -> 0x0174, TryCatch #7 {Exception -> 0x0174, blocks: (B:39:0x0128, B:42:0x0130, B:44:0x0137, B:46:0x013f), top: B:38:0x0128 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String doPost(String url, Map<String, String> headerParamMap, String jsonStr, HttpRequestOptions options) {
        String message;
        Throwable th;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        String str;
        OutputStream outputStream2;
        int i;
        int i2;
        long currentTimeMillis;
        int codeFromApi;
        byte[] bytes;
        String valueOf;
        long currentTimeMillis2 = System.currentTimeMillis();
        String str2 = "";
        try {
            str2 = new URL(url).getPath().split("/app_sdk/")[1];
            message = "";
        } catch (Throwable th2) {
            message = th2.getMessage();
        }
        try {
            bytes = jsonStr.getBytes("UTF-8");
            valueOf = String.valueOf(bytes.length);
            httpsURLConnection = connect(url, headerParamMap, options, "POST", valueOf);
        } catch (Exception e) {
            e = e;
            str = null;
            outputStream2 = null;
            httpsURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            httpsURLConnection = null;
        }
        if (httpsURLConnection == null) {
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.disconnect();
                } catch (Exception e2) {
                    e2.getMessage();
                    TTCrashHandler.handleCrash(TAG, e2, 1);
                }
            }
            return null;
        }
        try {
            outputStream2 = httpsURLConnection.getOutputStream();
            try {
                try {
                    outputStream2.write(bytes);
                    outputStream2.flush();
                    if (shouldRedirect(httpsURLConnection.getResponseCode())) {
                        String headerField = httpsURLConnection.getHeaderField("Location");
                        httpsURLConnection.disconnect();
                        httpsURLConnection = connect(headerField, headerParamMap, options, "POST", valueOf);
                        outputStream2 = httpsURLConnection.getOutputStream();
                        outputStream2.write(bytes);
                        outputStream2.flush();
                    }
                    i2 = httpsURLConnection.getResponseCode();
                    if (i2 == 200) {
                        try {
                            str = streamToString(httpsURLConnection.getInputStream());
                        } catch (Exception e3) {
                            e = e3;
                            i = i2;
                            str = null;
                            String message2 = e.getMessage();
                            TTCrashHandler.handleCrash(TAG, e, 1);
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e4) {
                                    message2 = e4.getMessage();
                                    TTCrashHandler.handleCrash(TAG, e4, 1);
                                }
                            }
                            message = message2;
                            if (httpsURLConnection != null) {
                                try {
                                    httpsURLConnection.disconnect();
                                } catch (Exception e5) {
                                    String message3 = e5.getMessage();
                                    TTCrashHandler.handleCrash(TAG, e5, 1);
                                    message = message3;
                                }
                            }
                            i2 = i;
                            currentTimeMillis = System.currentTimeMillis();
                            codeFromApi = getCodeFromApi(str);
                            if (codeFromApi != 0) {
                                message = getMessageFromApi(str);
                                i2 = codeFromApi;
                            }
                            if (codeFromApi != 0) {
                                TikTokBusinessSdk.getAppEventLogger().monitorMetric(API_ERR, TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis2)).put("latency", currentTimeMillis - currentTimeMillis2).put("api_type", str2).put("status_code", i2).put(PglCryptUtils.KEY_MESSAGE, message).put("log_id", getLogIDFromApi(str)), null);
                            }
                            return str;
                        }
                    } else {
                        str = null;
                    }
                } catch (Exception e6) {
                    e = e6;
                    str = null;
                    i = 0;
                    String message22 = e.getMessage();
                    TTCrashHandler.handleCrash(TAG, e, 1);
                    if (outputStream2 != null) {
                    }
                    message = message22;
                    if (httpsURLConnection != null) {
                    }
                    i2 = i;
                    currentTimeMillis = System.currentTimeMillis();
                    codeFromApi = getCodeFromApi(str);
                    if (codeFromApi != 0) {
                    }
                    if (codeFromApi != 0) {
                    }
                    return str;
                }
                try {
                    if (TikTokBusinessSdk.isInSdkDebugMode().booleanValue()) {
                        TTLogger tTLogger = ttLogger;
                        tTLogger.info("doPost request body: %s", jsonStr);
                        tTLogger.info("doPost result: %s", str == null ? String.valueOf(i2) : str);
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e7) {
                            String message4 = e7.getMessage();
                            TTCrashHandler.handleCrash(TAG, e7, 1);
                            message = message4;
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e8) {
                            String message5 = e8.getMessage();
                            TTCrashHandler.handleCrash(TAG, e8, 1);
                            message = message5;
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                    i = i2;
                    String message222 = e.getMessage();
                    TTCrashHandler.handleCrash(TAG, e, 1);
                    if (outputStream2 != null) {
                    }
                    message = message222;
                    if (httpsURLConnection != null) {
                    }
                    i2 = i;
                    currentTimeMillis = System.currentTimeMillis();
                    codeFromApi = getCodeFromApi(str);
                    if (codeFromApi != 0) {
                    }
                    if (codeFromApi != 0) {
                    }
                    return str;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e10) {
                        e10.getMessage();
                        TTCrashHandler.handleCrash(TAG, e10, 1);
                    }
                }
                if (httpsURLConnection != null) {
                    throw th;
                }
                try {
                    httpsURLConnection.disconnect();
                    throw th;
                } catch (Exception e11) {
                    e11.getMessage();
                    TTCrashHandler.handleCrash(TAG, e11, 1);
                    throw th;
                }
            }
        } catch (Exception e12) {
            e = e12;
            str = null;
            outputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            if (outputStream != null) {
            }
            if (httpsURLConnection != null) {
            }
        }
        currentTimeMillis = System.currentTimeMillis();
        try {
            codeFromApi = getCodeFromApi(str);
            if (codeFromApi != 0 && i2 == 200) {
                message = getMessageFromApi(str);
                i2 = codeFromApi;
            }
            if (codeFromApi != 0 && !url.contains(MONITOR_API_TYPE)) {
                TikTokBusinessSdk.getAppEventLogger().monitorMetric(API_ERR, TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis2)).put("latency", currentTimeMillis - currentTimeMillis2).put("api_type", str2).put("status_code", i2).put(PglCryptUtils.KEY_MESSAGE, message).put("log_id", getLogIDFromApi(str)), null);
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static String streamToString(InputStream is) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String trim = sb.toString().trim();
                        bufferedReader.close();
                        return trim;
                    }
                }
            } finally {
            }
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 1);
            return null;
        }
    }

    public static int getCodeFromApi(String resp) {
        if (resp == null) {
            return -1;
        }
        try {
            return new JSONObject(resp).getInt("code");
        } catch (Exception unused) {
            return -2;
        }
    }

    public static String getMessageFromApi(String resp) {
        if (resp != null) {
            try {
                return new JSONObject(resp).getString(PglCryptUtils.KEY_MESSAGE);
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        return "result is empty";
    }

    public static String getLogIDFromApi(String resp) {
        if (resp != null) {
            try {
                return new JSONObject(resp).getString("request_id");
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
