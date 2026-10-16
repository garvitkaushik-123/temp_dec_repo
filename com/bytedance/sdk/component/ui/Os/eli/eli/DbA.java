package com.bytedance.sdk.component.ui.Os.eli.eli;

import android.util.Log;
import com.bytedance.sdk.component.ui.Os.eli.eli.eli;
import com.bytedance.sdk.component.utils.aAs;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class DbA implements com.bytedance.sdk.component.ui.Os {
    private eli DbA;
    private long eli;

    public DbA(File file, long j, ExecutorService executorService) {
        this.eli = j;
        try {
            this.DbA = eli.eli(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.ui.Os
    public InputStream eli(String str) {
        eli eliVar = this.DbA;
        if (eliVar == null) {
            return null;
        }
        try {
            eli.Os eli = eliVar.eli(str);
            if (eli != null) {
                return eli.eli(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, byte[] bArr) {
        Closeable closeable;
        eli.C0147eli DbA;
        eli eliVar = this.DbA;
        if (eliVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        eli.C0147eli c0147eli = null;
        try {
            try {
                DbA = eliVar.DbA(str);
            } catch (IOException e) {
                e = e;
                closeable = null;
            }
            try {
                if (DbA == null) {
                    Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                    aAs.eli(null);
                    return false;
                }
                OutputStream eli = DbA.eli(0);
                if (eli == eli.Os) {
                    Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                    aAs.eli(eli);
                    return false;
                }
                eli.write(bArr);
                DbA.eli();
                this.DbA.eli();
                aAs.eli(eli);
                return true;
            } catch (IOException e2) {
                e = e2;
                closeable = null;
                c0147eli = DbA;
                try {
                    Log.w("LruCountDiskCache", e.toString());
                    if (c0147eli != null) {
                        try {
                            c0147eli.DbA();
                        } catch (IOException unused) {
                        }
                    }
                    aAs.eli(closeable);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    aAs.eli(closeable2);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            aAs.eli(closeable2);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.ui.eli
    /* renamed from: DbA, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] eli(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        eli eliVar = this.DbA;
        InputStream inputStream2 = null;
        if (eliVar == null || str == null) {
            return null;
        }
        try {
            eli.Os eli = eliVar.eli(str);
            if (eli == null) {
                aAs.eli(null);
                aAs.eli(null);
                return null;
            }
            inputStream = eli.eli(0);
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (IOException e) {
                            e = e;
                            Log.w("LruCountDiskCache", e.toString());
                            aAs.eli(inputStream);
                            aAs.eli(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        aAs.eli(inputStream2);
                        aAs.eli(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    Log.w("LruCountDiskCache", e.toString());
                    aAs.eli(inputStream);
                    aAs.eli(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    aAs.eli(inputStream2);
                    aAs.eli(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            aAs.eli(inputStream);
            aAs.eli(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            aAs.eli(inputStream2);
            aAs.eli(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.ui.eli
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public boolean DbA(String str) {
        try {
            try {
                eli.Os eli = this.DbA.eli(str);
                boolean z = eli != null;
                aAs.eli(eli);
                return z;
            } catch (IOException e) {
                Log.w("LruCountDiskCache", e.getMessage());
                aAs.eli(null);
                return false;
            }
        } catch (Throwable th) {
            aAs.eli(null);
            throw th;
        }
    }
}
