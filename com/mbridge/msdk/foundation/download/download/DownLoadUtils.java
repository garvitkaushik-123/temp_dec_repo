package com.mbridge.msdk.foundation.download.download;

import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.z0;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes6.dex */
public class DownLoadUtils {
    private static final int DOWNLOAD_CONNECTION_TIME_OUT = 20000;
    private static final int DOWNLOAD_READ_TIME_OUT = 30000;
    public static final String END_TAG = "<mbridgeloadend></mbridgeloadend>";
    private static final String TAG = "DownLoadUtils";

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        r3.onFailed("url is error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void getSourceCodeFromNetUrl(final String str, final H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source, final boolean z) {
        try {
            if (!z0.a(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.DownLoadUtils.1
                    @Override // com.mbridge.msdk.foundation.same.task.a
                    public void cancelTask() {
                    }

                    @Override // com.mbridge.msdk.foundation.same.task.a
                    public void pauseTask(boolean z2) {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:103:0x017b A[Catch: Exception -> 0x0177, TRY_LEAVE, TryCatch #6 {Exception -> 0x0177, blocks: (B:110:0x0173, B:103:0x017b), top: B:109:0x0173 }] */
                    /* JADX WARN: Removed duplicated region for block: B:109:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:36:0x011d A[Catch: all -> 0x0119, TryCatch #12 {all -> 0x0119, blocks: (B:69:0x0108, B:72:0x010e, B:74:0x0111, B:36:0x011d, B:38:0x0123, B:40:0x0129, B:42:0x0131, B:44:0x0135, B:64:0x013b, B:66:0x013f), top: B:68:0x0108 }] */
                    /* JADX WARN: Removed duplicated region for block: B:66:0x013f A[Catch: all -> 0x0119, TRY_LEAVE, TryCatch #12 {all -> 0x0119, blocks: (B:69:0x0108, B:72:0x010e, B:74:0x0111, B:36:0x011d, B:38:0x0123, B:40:0x0129, B:42:0x0131, B:44:0x0135, B:64:0x013b, B:66:0x013f), top: B:68:0x0108 }] */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:85:0x00fa A[Catch: Exception -> 0x00f6, TRY_LEAVE, TryCatch #8 {Exception -> 0x00f6, blocks: (B:92:0x00f2, B:85:0x00fa), top: B:91:0x00f2 }] */
                    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Type inference failed for: r0v18, types: [com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r1v11 */
                    /* JADX WARN: Type inference failed for: r1v2 */
                    /* JADX WARN: Type inference failed for: r1v24, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r1v27 */
                    /* JADX WARN: Type inference failed for: r1v28 */
                    /* JADX WARN: Type inference failed for: r1v29 */
                    /* JADX WARN: Type inference failed for: r1v3 */
                    /* JADX WARN: Type inference failed for: r1v4 */
                    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r7v17 */
                    /* JADX WARN: Type inference failed for: r7v18 */
                    /* JADX WARN: Type inference failed for: r7v19 */
                    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
                    @Override // com.mbridge.msdk.foundation.same.task.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void runTask() {
                        ByteArrayOutputStream byteArrayOutputStream;
                        InputStream inputStream;
                        ByteArrayOutputStream byteArrayOutputStream2;
                        Object obj;
                        Object obj2;
                        Exception e;
                        InputStream inputStream2;
                        String message;
                        byte[] bArr;
                        ?? r7;
                        H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source2;
                        InputStream inputStream3;
                        Object obj3;
                        boolean z2;
                        Object obj4;
                        ?? r1 = "responseCode is ";
                        Object obj5 = null;
                        boolean z3 = false;
                        try {
                            try {
                                H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source3 = H5DownLoadManager.IOnDownLoadH5Source.this;
                                if (iOnDownLoadH5Source3 != null) {
                                    iOnDownLoadH5Source3.onStart();
                                }
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                                httpsURLConnection.setHostnameVerifier(new MBridgeHostnameVerifier(str));
                                httpsURLConnection.setReadTimeout(30000);
                                httpsURLConnection.setConnectTimeout(20000);
                                int responseCode = httpsURLConnection.getResponseCode();
                                p0.a(DownLoadUtils.TAG, "response code " + responseCode);
                                if (responseCode == 200) {
                                    r1 = httpsURLConnection.getInputStream();
                                    try {
                                        byte[] bArr2 = new byte[6144];
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        while (true) {
                                            try {
                                                try {
                                                    int read = r1.read(bArr2);
                                                    if (read == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream.write(bArr2, 0, read);
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (r1 != 0) {
                                                        try {
                                                            r1.close();
                                                        } catch (Exception e2) {
                                                            e2.printStackTrace();
                                                            e2.getMessage();
                                                            throw th;
                                                        }
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                        byteArrayOutputStream.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                byteArrayOutputStream2 = null;
                                            }
                                        }
                                        if (byteArrayOutputStream.toByteArray() != null) {
                                            bArr = byteArrayOutputStream.toByteArray();
                                            try {
                                                obj4 = !z ? new String(bArr) : null;
                                            } catch (Exception e4) {
                                                byteArrayOutputStream2 = bArr;
                                                e = e4;
                                                obj2 = null;
                                                inputStream2 = r1;
                                                message = e.getMessage();
                                                p0.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (Exception e5) {
                                                        e5.printStackTrace();
                                                        message = e5.getMessage();
                                                        bArr = byteArrayOutputStream2;
                                                        r1 = inputStream2;
                                                        r7 = obj2;
                                                        if (z3) {
                                                        }
                                                        if (!z3) {
                                                        }
                                                        iOnDownLoadH5Source2 = H5DownLoadManager.IOnDownLoadH5Source.this;
                                                        if (iOnDownLoadH5Source2 != null) {
                                                        }
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                bArr = byteArrayOutputStream2;
                                                r1 = inputStream2;
                                                r7 = obj2;
                                                if (z3) {
                                                }
                                                if (!z3) {
                                                }
                                                iOnDownLoadH5Source2 = H5DownLoadManager.IOnDownLoadH5Source.this;
                                                if (iOnDownLoadH5Source2 != null) {
                                                }
                                            }
                                        } else {
                                            bArr = null;
                                            obj4 = null;
                                        }
                                        message = "";
                                        z2 = true;
                                        inputStream3 = r1;
                                        obj3 = obj4;
                                    } catch (Exception e6) {
                                        inputStream = r1;
                                        e = e6;
                                        byteArrayOutputStream2 = null;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        obj = byteArrayOutputStream;
                                        InputStream inputStream4 = inputStream;
                                        e = e;
                                        inputStream2 = inputStream4;
                                        obj2 = obj;
                                        message = e.getMessage();
                                        p0.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                        if (inputStream2 != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        bArr = byteArrayOutputStream2;
                                        r1 = inputStream2;
                                        r7 = obj2;
                                        if (z3) {
                                        }
                                        if (!z3) {
                                        }
                                        iOnDownLoadH5Source2 = H5DownLoadManager.IOnDownLoadH5Source.this;
                                        if (iOnDownLoadH5Source2 != null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = null;
                                        obj5 = r1;
                                        r1 = obj5;
                                        if (r1 != 0) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    message = "responseCode is " + responseCode;
                                    inputStream3 = null;
                                    bArr = null;
                                    byteArrayOutputStream = null;
                                    obj3 = null;
                                    z2 = false;
                                }
                                try {
                                    httpsURLConnection.disconnect();
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e7) {
                                            e7.printStackTrace();
                                            message = e7.getMessage();
                                            r1 = inputStream3;
                                            r7 = obj3;
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z3 = z2;
                                    r1 = inputStream3;
                                    r7 = obj3;
                                } catch (Exception e8) {
                                    ByteArrayOutputStream byteArrayOutputStream3 = bArr;
                                    inputStream = inputStream3;
                                    e = e8;
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    obj = obj3;
                                    InputStream inputStream42 = inputStream;
                                    e = e;
                                    inputStream2 = inputStream42;
                                    obj2 = obj;
                                    message = e.getMessage();
                                    p0.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                    if (inputStream2 != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    bArr = byteArrayOutputStream2;
                                    r1 = inputStream2;
                                    r7 = obj2;
                                    if (z3) {
                                    }
                                    if (!z3) {
                                    }
                                    iOnDownLoadH5Source2 = H5DownLoadManager.IOnDownLoadH5Source.this;
                                    if (iOnDownLoadH5Source2 != null) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            inputStream = null;
                            byteArrayOutputStream2 = null;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayOutputStream = null;
                            r1 = obj5;
                            if (r1 != 0) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                        if (z3) {
                            try {
                                if (z && bArr != null && bArr.length > 0) {
                                    H5DownLoadManager.IOnDownLoadH5Source.this.onSuccess(null, bArr, str);
                                }
                            } catch (Throwable th5) {
                                if (MBridgeConstans.DEBUG) {
                                    th5.printStackTrace();
                                }
                                H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source4 = H5DownLoadManager.IOnDownLoadH5Source.this;
                                if (iOnDownLoadH5Source4 != null) {
                                    try {
                                        iOnDownLoadH5Source4.onFailed(th5.getMessage());
                                        return;
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        if (!z3 && z0.b(r7) && r7.length() > 0 && r7.contains(DownLoadUtils.END_TAG)) {
                            ?? r0 = H5DownLoadManager.IOnDownLoadH5Source.this;
                            if (r0 != 0) {
                                r0.onSuccess(r7, bArr, str);
                            }
                        } else {
                            iOnDownLoadH5Source2 = H5DownLoadManager.IOnDownLoadH5Source.this;
                            if (iOnDownLoadH5Source2 != null) {
                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}
