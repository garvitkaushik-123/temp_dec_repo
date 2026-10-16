package com.bykv.vk.openvk.eli.eli.DbA.eli.DbA;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.openvk.eli.eli.eli.ui.eli;
import com.bytedance.sdk.component.DbA.eli.Dfc;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DbA {
    private com.bykv.vk.openvk.eli.eli.eli.Os.Os DbA;
    private File aGH;
    private Context eli;
    private File ui;
    private volatile boolean Os = false;
    private final List<eli.InterfaceC0111eli> MGA = new ArrayList();
    private volatile boolean kb = false;

    public DbA(Context context, com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        this.aGH = null;
        this.ui = null;
        this.eli = context;
        this.DbA = os;
        this.aGH = com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.DbA(os.ui(), os.dV());
        this.ui = com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.Os(os.ui(), os.dV());
    }

    public void eli(eli.InterfaceC0111eli interfaceC0111eli) {
        if (this.kb) {
            synchronized (eli.InterfaceC0111eli.class) {
                this.MGA.add(interfaceC0111eli);
            }
            return;
        }
        this.MGA.add(interfaceC0111eli);
        if (DbA()) {
            this.DbA.wC(1);
            eli(this.DbA, 200);
            Os.eli(this.DbA);
        } else {
            this.kb = true;
            this.DbA.wC(0);
            Os();
        }
    }

    private boolean DbA() {
        if (this.ui.exists()) {
            return true;
        }
        if (!this.DbA.NU()) {
            if (this.aGH.length() >= this.DbA.MGA()) {
                return true;
            }
            if (this.DbA.aGH() > 0 && this.aGH.length() >= this.DbA.aGH()) {
                return true;
            }
        }
        return false;
    }

    private void Os() {
        du.eli eliVar;
        if (com.bykv.vk.openvk.eli.eli.eli.Os.aGH() != null) {
            eliVar = com.bykv.vk.openvk.eli.eli.eli.Os.aGH().DbA();
        } else {
            eliVar = new du.eli("v_preload");
        }
        eliVar.eli(this.DbA.QX(), TimeUnit.MILLISECONDS).DbA(this.DbA.Xb(), TimeUnit.MILLISECONDS).Os(this.DbA.bf(), TimeUnit.MILLISECONDS);
        du eli = eliVar.eli();
        nlS.eli eliVar2 = new nlS.eli();
        final long length = this.aGH.length();
        int MGA = this.DbA.MGA();
        boolean NU = this.DbA.NU();
        int aGH = this.DbA.aGH();
        if (aGH > 0) {
            if (aGH >= this.DbA.nlS()) {
                NU = true;
            } else {
                MGA = aGH;
            }
        }
        eliVar2.eli("videoPreload").eli(6);
        if (NU) {
            eliVar2.eli("RANGE", "bytes=" + length + "-").DbA(this.DbA.aqO()).eli().DbA();
        } else {
            eliVar2.eli("RANGE", "bytes=" + length + "-" + MGA).DbA(this.DbA.aqO()).eli().DbA();
        }
        eli.eli(eliVar2.DbA()).eli(new com.bytedance.sdk.component.DbA.eli.Os() { // from class: com.bykv.vk.openvk.eli.eli.DbA.eli.DbA.DbA.1
            @Override // com.bytedance.sdk.component.DbA.eli.Os
            public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, IOException iOException) {
                DbA dbA2 = DbA.this;
                dbA2.eli(dbA2.DbA, 601, iOException.getMessage());
                Os.eli(DbA.this.DbA);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:57:0x016d A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:55:0x0160, B:57:0x016d, B:58:0x0171), top: B:54:0x0160 }] */
            /* JADX WARN: Type inference failed for: r15v3 */
            @Override // com.bytedance.sdk.component.DbA.eli.Os
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA, nn nnVar) throws IOException {
                InputStream inputStream;
                Closeable closeable;
                Dfc dfc;
                long j;
                RandomAccessFile randomAccessFile;
                long j2 = length;
                Dfc dfc2 = null;
                try {
                } catch (Throwable th) {
                    th = th;
                    dfc2 = null;
                }
                if (nnVar != null) {
                    boolean aGH2 = nnVar.aGH();
                    try {
                        if (!aGH2) {
                            try {
                                DbA dbA2 = DbA.this;
                                dbA2.eli(dbA2.DbA, nnVar.Os(), nnVar.ui());
                                DbA.this.eli((Closeable) null);
                                DbA.this.eli((Closeable) null);
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = null;
                                closeable = null;
                            }
                            DbA.this.eli(dfc2);
                            DbA.this.eli(nnVar);
                            new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                            Os.eli(DbA.this.DbA);
                        }
                        Dfc MGA2 = nnVar.MGA();
                        try {
                            dfc = nnVar.MGA();
                            if (!aGH2 || dfc == null) {
                                inputStream = null;
                                j = 0;
                            } else {
                                try {
                                    j = length + dfc.eli();
                                    inputStream = dfc.Os();
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = null;
                                    randomAccessFile = 0;
                                    dfc2 = dfc;
                                    closeable = randomAccessFile;
                                    DbA.this.aGH();
                                    DbA dbA3 = DbA.this;
                                    dbA3.eli(dbA3.DbA, nnVar != null ? nnVar.Os() : 601, th.getMessage());
                                    DbA.this.eli(closeable);
                                    DbA.this.eli(inputStream);
                                    DbA.this.eli(dfc2);
                                    DbA.this.eli(nnVar);
                                    new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                                    Os.eli(DbA.this.DbA);
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            dfc2 = MGA2;
                            inputStream = null;
                            closeable = null;
                            DbA.this.aGH();
                            DbA dbA32 = DbA.this;
                            dbA32.eli(dbA32.DbA, nnVar != null ? nnVar.Os() : 601, th.getMessage());
                            DbA.this.eli(closeable);
                            DbA.this.eli(inputStream);
                            DbA.this.eli(dfc2);
                            DbA.this.eli(nnVar);
                            new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                            Os.eli(DbA.this.DbA);
                        }
                        if (inputStream != null) {
                            try {
                                randomAccessFile = new RandomAccessFile(DbA.this.aGH, "rw");
                                try {
                                    byte[] bArr = new byte[8192];
                                    int i = 0;
                                    long j3 = 0;
                                    while (true) {
                                        int read = inputStream.read(bArr, i, 8192 - i);
                                        if (read == -1) {
                                            if (DbA.this.DbA.NU() && j == DbA.this.aGH.length()) {
                                                DbA.this.ui();
                                            }
                                            DbA dbA4 = DbA.this;
                                            dbA4.eli(dbA4.DbA, nnVar.Os());
                                            dfc2 = randomAccessFile;
                                        } else if (DbA.this.Os) {
                                            DbA dbA5 = DbA.this;
                                            dbA5.DbA(dbA5.DbA, nnVar.Os());
                                            DbA.this.eli(randomAccessFile);
                                            break;
                                        } else {
                                            i += read;
                                            j3 += read;
                                            if (j3 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j3 == j - length) {
                                                com.bykv.vk.openvk.eli.eli.DbA.aGH.DbA.eli(randomAccessFile, bArr, Long.valueOf(j2).intValue(), i, DbA.this.DbA.dV());
                                                j2 += i;
                                                i = 0;
                                            }
                                        }
                                    }
                                    DbA.this.eli(inputStream);
                                    DbA.this.eli(dfc);
                                } catch (Throwable th5) {
                                    th = th5;
                                    dfc2 = dfc;
                                    closeable = randomAccessFile;
                                    DbA.this.aGH();
                                    DbA dbA322 = DbA.this;
                                    dbA322.eli(dbA322.DbA, nnVar != null ? nnVar.Os() : 601, th.getMessage());
                                    DbA.this.eli(closeable);
                                    DbA.this.eli(inputStream);
                                    DbA.this.eli(dfc2);
                                    DbA.this.eli(nnVar);
                                    new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                                    Os.eli(DbA.this.DbA);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                dfc2 = dfc;
                                closeable = null;
                                DbA.this.aGH();
                                DbA dbA3222 = DbA.this;
                                dbA3222.eli(dbA3222.DbA, nnVar != null ? nnVar.Os() : 601, th.getMessage());
                                DbA.this.eli(closeable);
                                DbA.this.eli(inputStream);
                                DbA.this.eli(dfc2);
                                DbA.this.eli(nnVar);
                                new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                                Os.eli(DbA.this.DbA);
                            }
                            DbA.this.eli(nnVar);
                            new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                            Os.eli(DbA.this.DbA);
                        }
                        try {
                            DbA dbA6 = DbA.this;
                            dbA6.eli(dbA6.DbA, nnVar.Os(), nnVar.ui());
                        } catch (Throwable th7) {
                            th = th7;
                            randomAccessFile = 0;
                            dfc2 = dfc;
                            closeable = randomAccessFile;
                            DbA.this.aGH();
                            DbA dbA32222 = DbA.this;
                            dbA32222.eli(dbA32222.DbA, nnVar != null ? nnVar.Os() : 601, th.getMessage());
                            DbA.this.eli(closeable);
                            DbA.this.eli(inputStream);
                            DbA.this.eli(dfc2);
                            DbA.this.eli(nnVar);
                            new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                            Os.eli(DbA.this.DbA);
                        }
                        DbA.this.aGH();
                        DbA dbA322222 = DbA.this;
                        dbA322222.eli(dbA322222.DbA, nnVar != null ? nnVar.Os() : 601, th.getMessage());
                        DbA.this.eli(closeable);
                        DbA.this.eli(inputStream);
                        DbA.this.eli(dfc2);
                        DbA.this.eli(nnVar);
                        new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                        Os.eli(DbA.this.DbA);
                    } catch (Throwable th8) {
                        DbA.this.eli(closeable);
                        DbA.this.eli(inputStream);
                        DbA.this.eli(dfc2);
                        DbA.this.eli(nnVar);
                        new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                        Os.eli(DbA.this.DbA);
                        throw th8;
                    }
                }
                DbA dbA7 = DbA.this;
                dbA7.eli(dbA7.DbA, 601, "Network link failed.");
                dfc2 = null;
                dfc = null;
                inputStream = null;
                DbA.this.eli(dfc2);
                DbA.this.eli(inputStream);
                DbA.this.eli(dfc);
                DbA.this.eli(nnVar);
                new Object[]{"Pre finally ", DbA.this.DbA.aqO(), " Preload size=", Integer.valueOf(DbA.this.DbA.MGA())};
                Os.eli(DbA.this.DbA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public com.bykv.vk.openvk.eli.eli.eli.Os.Os eli() {
        return this.DbA;
    }

    public void eli(boolean z) {
        this.Os = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
        synchronized (eli.InterfaceC0111eli.class) {
            for (eli.InterfaceC0111eli interfaceC0111eli : this.MGA) {
                if (interfaceC0111eli != null) {
                    interfaceC0111eli.eli(os, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
        synchronized (eli.InterfaceC0111eli.class) {
            for (eli.InterfaceC0111eli interfaceC0111eli : this.MGA) {
                if (interfaceC0111eli != null) {
                    interfaceC0111eli.eli(os, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
        synchronized (eli.InterfaceC0111eli.class) {
            for (eli.InterfaceC0111eli interfaceC0111eli : this.MGA) {
                if (interfaceC0111eli != null) {
                    interfaceC0111eli.DbA(os, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        try {
            this.ui.delete();
            this.aGH.delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        try {
            if (this.aGH.renameTo(this.ui)) {
            } else {
                throw new IOException("Error renaming file " + this.aGH + " to " + this.ui + " for completion!");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
