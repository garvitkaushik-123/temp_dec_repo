package com.bykv.vk.openvk.eli.eli.DbA.eli.eli;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.DbA.eli.Dfc;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.bytedance.sdk.component.utils.Xb;
import com.vungle.ads.internal.protos.Sdk;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA implements Os {
    private File Os;
    private RandomAccessFile aAs;
    private File aGH;
    private final com.bykv.vk.openvk.eli.eli.eli.Os.Os du;
    private long ui;
    private volatile long eli = -2147483648L;
    private final Object DbA = new Object();
    private volatile long MGA = -1;
    private volatile int kb = -100;
    private volatile boolean wC = false;
    private volatile boolean FC = false;

    public DbA(Context context, com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        this.ui = 0L;
        this.aAs = null;
        this.du = os;
        try {
            this.Os = com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.DbA(os.ui(), os.dV());
            this.aGH = com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.Os(os.ui(), os.dV());
            if (aGH()) {
                this.aAs = new RandomAccessFile(this.aGH, "r");
            } else {
                this.aAs = new RandomAccessFile(this.Os, "rw");
            }
            if (aGH()) {
                return;
            }
            this.ui = this.Os.length();
            eli();
        } catch (Throwable unused) {
            new Object[]{"Error using file ", os.aqO(), " as disc cache"};
        }
    }

    private boolean aGH() {
        return this.aGH.exists();
    }

    public void eli() {
        du.eli eliVar;
        if (com.bykv.vk.openvk.eli.eli.eli.Os.aGH() != null) {
            eliVar = com.bykv.vk.openvk.eli.eli.eli.Os.aGH().DbA();
        } else {
            eliVar = new du.eli("v_cache");
        }
        eliVar.eli(this.du.QX(), TimeUnit.MILLISECONDS).DbA(this.du.Xb(), TimeUnit.MILLISECONDS).Os(this.du.bf(), TimeUnit.MILLISECONDS);
        du eli = eliVar.eli();
        new Object[]{"RANGE, bytes=", Long.valueOf(this.ui), " file hash=", this.du.dV()};
        eli.eli(new nlS.eli().eli("RANGE", "bytes=" + this.ui + "-").DbA(this.du.aqO()).eli().eli("videoLoadWhenPlaying").eli(9).DbA()).eli(new com.bytedance.sdk.component.DbA.eli.Os() { // from class: com.bykv.vk.openvk.eli.eli.DbA.eli.eli.DbA.1
            @Override // com.bytedance.sdk.component.DbA.eli.Os
            public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, IOException iOException) {
                DbA.this.eli(30000, iOException.getMessage());
            }

            @Override // com.bytedance.sdk.component.DbA.eli.Os
            public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, nn nnVar) throws IOException {
                Dfc dfc;
                boolean z;
                if (nnVar == null) {
                    DbA.this.eli(Sdk.SDKError.Reason.AD_INTERNAL_INTEGRATION_ERROR_VALUE, "response is empty");
                    return;
                }
                InputStream inputStream = null;
                try {
                    try {
                        DbA.this.FC = nnVar.aGH();
                        if (DbA.this.FC) {
                            dfc = nnVar.MGA();
                            try {
                                if (DbA.this.FC && dfc != null) {
                                    DbA.this.eli = dfc.eli() + DbA.this.ui;
                                    inputStream = dfc.Os();
                                }
                                if (inputStream == null) {
                                    DbA.this.eli(Sdk.SDKError.Reason.CONFIG_NOT_FOUND_ERROR_VALUE, "input_stream is empty");
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (dfc != null) {
                                        dfc.close();
                                    }
                                    if (nnVar != null) {
                                        nnVar.close();
                                    }
                                    if (!DbA.this.FC || DbA.this.Os.length() != DbA.this.eli) {
                                        return;
                                    }
                                    DbA.this.MGA();
                                }
                                byte[] bArr = new byte[8192];
                                long j = DbA.this.ui;
                                long j2 = 0;
                                loop0: while (true) {
                                    int i = 0;
                                    do {
                                        int read = inputStream.read(bArr, i, 8192 - i);
                                        z = true;
                                        if (read == -1) {
                                            break loop0;
                                        }
                                        i += read;
                                        j2 += read;
                                        if (j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI != 0 && j2 != DbA.this.eli - DbA.this.ui) {
                                            z = false;
                                        }
                                        new Object[]{"Write segment,execAppend =", Boolean.valueOf(z), " offset=", Integer.valueOf(i), " totalLength = ", Long.valueOf(DbA.this.eli), " saveSize =", Long.valueOf(j2), " startSaved=", Long.valueOf(DbA.this.ui), " fileHash=", DbA.this.du.dV(), " url=", DbA.this.du.aqO()};
                                    } while (!z);
                                    synchronized (DbA.this.DbA) {
                                        com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.eli(DbA.this.aAs, bArr, Long.valueOf(j).intValue(), i, DbA.this.du.dV());
                                    }
                                    j += i;
                                }
                                Long valueOf = Long.valueOf(DbA.this.ui);
                                Long valueOf2 = Long.valueOf(DbA.this.eli);
                                Long valueOf3 = Long.valueOf(j2);
                                if (j2 != DbA.this.eli - DbA.this.ui) {
                                    z = false;
                                }
                                new Object[]{"Write segment,Write over, startIndex =", valueOf, " totalLength = ", valueOf2, " saveSize = ", valueOf3, " writeEndSegment =", Boolean.valueOf(z), " url=", DbA.this.du.aqO()};
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    DbA.this.eli(Sdk.SDKError.Reason.AD_PUBLISHER_MISMATCH_VALUE, th.getMessage());
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (dfc != null) {
                                        dfc.close();
                                    }
                                    if (nnVar != null) {
                                        nnVar.close();
                                    }
                                    if (DbA.this.FC && DbA.this.Os.length() == DbA.this.eli) {
                                        DbA.this.MGA();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused) {
                                            throw th2;
                                        }
                                    }
                                    if (dfc != null) {
                                        dfc.close();
                                    }
                                    if (nnVar != null) {
                                        nnVar.close();
                                    }
                                    if (DbA.this.FC && DbA.this.Os.length() == DbA.this.eli) {
                                        DbA.this.MGA();
                                    }
                                    throw th2;
                                }
                            }
                        } else {
                            DbA.this.eli(nnVar.Os(), nnVar.ui());
                            dfc = null;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (dfc != null) {
                            dfc.close();
                        }
                        if (nnVar != null) {
                            nnVar.close();
                        }
                        if (!DbA.this.FC || DbA.this.Os.length() != DbA.this.eli) {
                            return;
                        }
                        DbA.this.MGA();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dfc = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, String str) {
        JSONObject Os;
        this.FC = false;
        this.kb = i;
        this.eli = this.MGA;
        Xb.DbA("CSJ_MediaDLPlay", "handleFailResponse: ", Integer.valueOf(i), " ", str);
        com.bykv.vk.openvk.eli.eli.eli.Os.Os os = this.du;
        if (os == null || !os.eli() || (Os = this.du.Os()) == null) {
            return;
        }
        try {
            Os.put("error_real_code", i);
            Os.put("error_real_msg", str);
        } catch (Throwable th) {
            Xb.eli("CSJ_MediaDLPlay", "handleFailResponse: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.eli.eli.Os
    public int eli(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.eli) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.wC) {
                synchronized (this.DbA) {
                    long ui = ui();
                    if (j < ui) {
                        new StringBuilder("read:  read ").append(j);
                        this.aAs.seek(j);
                        i4 = this.aAs.read(bArr, i, i2);
                    } else {
                        new Object[]{"read: wait at ", Long.valueOf(j), "  file size = ", Long.valueOf(ui)};
                        i3 += 33;
                        this.DbA.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                com.bykv.vk.openvk.eli.eli.eli.Os.Os os = this.du;
                if (os != null && os.eli() && this.kb != -100 && (!this.FC || this.eli == this.MGA)) {
                    throw new IOException();
                }
                if (i3 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.eli.eli.Os
    public void DbA() {
        try {
            if (!this.wC) {
                this.aAs.close();
            }
            File file = this.Os;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.aGH;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        this.wC = true;
    }

    private long ui() {
        if (aGH()) {
            return this.aGH.length();
        }
        return this.Os.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MGA() throws IOException {
        synchronized (this.DbA) {
            if (aGH()) {
                new Object[]{"complete: isCompleted ", this.du.aqO(), this.du.dV()};
                return;
            }
            try {
            } finally {
            }
            if (!this.Os.renameTo(this.aGH)) {
                throw new IOException("Error renaming file " + this.Os + " to " + this.aGH + " for completion!");
            }
            RandomAccessFile randomAccessFile = this.aAs;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.aAs = new RandomAccessFile(this.aGH, "rw");
            new Object[]{"complete: rename ", this.du.dV(), this.du.aqO()};
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.DbA.eli.eli.Os
    public long Os() throws IOException {
        if (aGH()) {
            this.eli = this.aGH.length();
        } else {
            synchronized (this.DbA) {
                int i = 0;
                do {
                    if (this.eli == -2147483648L) {
                        i += 15;
                        try {
                            this.DbA.wait(5L);
                        } catch (InterruptedException unused) {
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 20000);
                return -1L;
            }
        }
        new Object[]{"totalLength= ", Long.valueOf(this.eli)};
        return this.eli;
    }
}
