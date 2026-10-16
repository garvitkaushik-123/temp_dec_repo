package com.bytedance.sdk.component.ui.Os.eli.eli;

import android.util.Log;
import coil.disk.DiskLruCache;
import com.bytedance.sdk.component.utils.aAs;
import com.ironsource.C3040d4;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class eli implements Closeable {
    final ExecutorService DbA;
    private long FC;
    private final File MGA;
    private final int aAs;
    private final File aGH;
    private final File kb;
    private Writer nlS;
    private int nn;
    private final File ui;
    private final int wC;
    static final Pattern eli = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream Os = new OutputStream() { // from class: com.bytedance.sdk.component.ui.Os.eli.eli.eli.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long du = 0;
    private final LinkedHashMap<String, DbA> NU = new LinkedHashMap<>(0, 0.75f, true);
    private long Dfc = -1;
    private long aqO = 0;
    private final Callable<Void> dV = new Callable<Void>() { // from class: com.bytedance.sdk.component.ui.Os.eli.eli.eli.1
        @Override // java.util.concurrent.Callable
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (eli.this) {
                if (eli.this.nlS == null) {
                    return null;
                }
                eli.this.wC();
                if (eli.this.MGA()) {
                    eli.this.ui();
                    eli.this.nn = 0;
                }
                return null;
            }
        }
    };

    private eli(File file, int i, int i2, long j, ExecutorService executorService) {
        this.aGH = file;
        this.wC = i;
        this.ui = new File(file, DiskLruCache.JOURNAL_FILE);
        this.MGA = new File(file, DiskLruCache.JOURNAL_FILE_TMP);
        this.kb = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.aAs = i2;
        this.FC = j;
        this.DbA = executorService;
    }

    public static eli eli(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        if (file2.exists()) {
            File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
            if (file3.exists()) {
                file2.delete();
            } else {
                eli(file2, file3, false);
            }
        }
        eli eliVar = new eli(file, i, i2, j, executorService);
        if (eliVar.ui.exists()) {
            try {
                eliVar.Os();
                eliVar.aGH();
                return eliVar;
            } catch (IOException e) {
                Log.w("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                eliVar.DbA();
            }
        }
        file.mkdirs();
        eli eliVar2 = new eli(file, i, i2, j, executorService);
        eliVar2.ui();
        return eliVar2;
    }

    private void Os() throws IOException {
        com.bytedance.sdk.component.ui.Os.eli.eli.Os os = new com.bytedance.sdk.component.ui.Os.eli.eli.Os(new FileInputStream(this.ui), aGH.eli);
        try {
            String eli2 = os.eli();
            String eli3 = os.eli();
            String eli4 = os.eli();
            String eli5 = os.eli();
            String eli6 = os.eli();
            if (!DiskLruCache.MAGIC.equals(eli2) || !"1".equals(eli3) || !Integer.toString(this.wC).equals(eli4) || !Integer.toString(this.aAs).equals(eli5) || !"".equals(eli6)) {
                throw new IOException("unexpected journal header: [" + eli2 + ", " + eli3 + ", " + eli5 + ", " + eli6 + C3040d4.i.e);
            }
            int i = 0;
            while (true) {
                try {
                    aGH(os.eli());
                    i++;
                } catch (EOFException unused) {
                    this.nn = i - this.NU.size();
                    if (os.DbA()) {
                        ui();
                    } else {
                        this.nlS = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ui, true), aGH.eli));
                    }
                    aAs.eli(os);
                    return;
                }
            }
        } catch (Throwable th) {
            aAs.eli(os);
            throw th;
        }
    }

    private void aGH(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.NU.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        DbA dbA = this.NU.get(substring);
        if (dbA == null) {
            dbA = new DbA(substring);
            this.NU.put(substring, dbA);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            dbA.aGH = true;
            dbA.ui = null;
            dbA.eli(split);
            return;
        }
        if (indexOf2 != -1 || indexOf != 5 || !str.startsWith("DIRTY")) {
            if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
            return;
        }
        dbA.ui = new C0147eli(dbA);
    }

    private void aGH() throws IOException {
        eli(this.MGA);
        Iterator<DbA> it = this.NU.values().iterator();
        while (it.hasNext()) {
            DbA next = it.next();
            int i = 0;
            if (next.ui == null) {
                while (i < this.aAs) {
                    this.du += next.Os[i];
                    i++;
                }
            } else {
                next.ui = null;
                while (i < this.aAs) {
                    eli(next.eli(i));
                    eli(next.DbA(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ui() throws IOException {
        Writer writer = this.nlS;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.MGA), aGH.eli));
        try {
            bufferedWriter.write(DiskLruCache.MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.wC));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aAs));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (DbA dbA : this.NU.values()) {
                if (dbA.ui != null) {
                    bufferedWriter.write("DIRTY " + dbA.DbA + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dbA.DbA + dbA.eli() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.ui.exists()) {
                eli(this.ui, this.kb, true);
            }
            eli(this.MGA, this.ui, false);
            this.kb.delete();
            this.nlS = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ui, true), aGH.eli));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void eli(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void eli(File file, File file2, boolean z) throws IOException {
        if (z) {
            eli(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized Os eli(String str) throws IOException {
        Throwable th;
        InputStream inputStream;
        try {
            kb();
            ui(str);
            DbA dbA = this.NU.get(str);
            if (dbA == null) {
                return null;
            }
            if (!dbA.aGH) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.aAs];
            for (int i = 0; i < this.aAs; i++) {
                try {
                    try {
                        try {
                            inputStreamArr[i] = new FileInputStream(dbA.eli(i));
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i2 = 0; i2 < this.aAs && (inputStream = inputStreamArr[i2]) != null; i2++) {
                            aAs.eli(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            this.nn++;
            this.nlS.append((CharSequence) ("READ " + str + '\n'));
            if (MGA()) {
                this.DbA.submit(this.dV);
            }
            return new Os(str, dbA.MGA, inputStreamArr, dbA.Os);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public C0147eli DbA(String str) throws IOException {
        return eli(str, -1L);
    }

    private synchronized C0147eli eli(String str, long j) throws IOException {
        kb();
        ui(str);
        DbA dbA = this.NU.get(str);
        if (j != -1 && (dbA == null || dbA.MGA != j)) {
            return null;
        }
        if (dbA == null) {
            dbA = new DbA(str);
            this.NU.put(str, dbA);
        } else if (dbA.ui != null) {
            return null;
        }
        C0147eli c0147eli = new C0147eli(dbA);
        dbA.ui = c0147eli;
        this.nlS.write("DIRTY " + str + '\n');
        this.nlS.flush();
        return c0147eli;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eli(C0147eli c0147eli, boolean z) throws IOException {
        DbA dbA = c0147eli.DbA;
        if (dbA.ui != c0147eli) {
            throw new IllegalStateException();
        }
        if (z && !dbA.aGH) {
            for (int i = 0; i < this.aAs; i++) {
                if (!c0147eli.Os[i]) {
                    c0147eli.DbA();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!dbA.DbA(i).exists()) {
                    c0147eli.DbA();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.aAs; i2++) {
            File DbA2 = dbA.DbA(i2);
            if (z) {
                if (DbA2.exists()) {
                    File eli2 = dbA.eli(i2);
                    DbA2.renameTo(eli2);
                    long j = dbA.Os[i2];
                    long length = eli2.length();
                    dbA.Os[i2] = length;
                    this.du = (this.du - j) + length;
                }
            } else {
                eli(DbA2);
            }
        }
        this.nn++;
        dbA.ui = null;
        if (dbA.aGH | z) {
            dbA.aGH = true;
            this.nlS.write("CLEAN " + dbA.DbA + dbA.eli() + '\n');
            if (z) {
                long j2 = this.aqO;
                this.aqO = 1 + j2;
                dbA.MGA = j2;
            }
        } else {
            this.NU.remove(dbA.DbA);
            this.nlS.write("REMOVE " + dbA.DbA + '\n');
        }
        this.nlS.flush();
        if (this.du > this.FC || MGA()) {
            this.DbA.submit(this.dV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MGA() {
        int i = this.nn;
        return i >= 2000 && i >= this.NU.size();
    }

    public synchronized boolean Os(String str) throws IOException {
        kb();
        ui(str);
        DbA dbA = this.NU.get(str);
        if (dbA != null && dbA.ui == null) {
            for (int i = 0; i < this.aAs; i++) {
                File eli2 = dbA.eli(i);
                if (eli2.exists() && !eli2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(eli2)));
                }
                this.du -= dbA.Os[i];
                dbA.Os[i] = 0;
            }
            this.nn++;
            this.nlS.append((CharSequence) ("REMOVE " + str + '\n'));
            this.NU.remove(str);
            if (MGA()) {
                this.DbA.submit(this.dV);
            }
            return true;
        }
        return false;
    }

    private void kb() {
        if (this.nlS == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void eli() throws IOException {
        kb();
        wC();
        this.nlS.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.nlS == null) {
            return;
        }
        Iterator it = new ArrayList(this.NU.values()).iterator();
        while (it.hasNext()) {
            DbA dbA = (DbA) it.next();
            if (dbA.ui != null) {
                dbA.ui.DbA();
            }
        }
        wC();
        this.nlS.close();
        this.nlS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() throws IOException {
        long j = this.FC;
        long j2 = this.Dfc;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.du > j) {
            Os(this.NU.entrySet().iterator().next().getKey());
        }
        this.Dfc = -1L;
    }

    public void DbA() throws IOException {
        close();
        aGH.eli(this.aGH);
    }

    private void ui(String str) {
        if (!eli.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class Os implements Closeable {
        private final String DbA;
        private final long Os;
        private final InputStream[] aGH;
        private final long[] ui;

        private Os(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.DbA = str;
            this.Os = j;
            this.aGH = inputStreamArr;
            this.ui = jArr;
        }

        public InputStream eli(int i) {
            return this.aGH[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aGH) {
                aAs.eli(inputStream);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.component.ui.Os.eli.eli.eli$eli, reason: collision with other inner class name */
    public final class C0147eli {
        private final DbA DbA;
        private final boolean[] Os;
        private boolean aGH;
        private boolean ui;

        private C0147eli(DbA dbA) {
            this.DbA = dbA;
            this.Os = dbA.aGH ? null : new boolean[eli.this.aAs];
        }

        public OutputStream eli(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0148eli c0148eli;
            if (i < 0 || i >= eli.this.aAs) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + eli.this.aAs);
            }
            synchronized (eli.this) {
                if (this.DbA.ui != this) {
                    throw new IllegalStateException();
                }
                if (!this.DbA.aGH) {
                    this.Os[i] = true;
                }
                File DbA = this.DbA.DbA(i);
                try {
                    fileOutputStream = new FileOutputStream(DbA);
                } catch (FileNotFoundException unused) {
                    eli.this.aGH.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(DbA);
                    } catch (FileNotFoundException unused2) {
                        return eli.Os;
                    }
                }
                c0148eli = new C0148eli(fileOutputStream);
            }
            return c0148eli;
        }

        public void eli() throws IOException {
            if (this.aGH) {
                eli.this.eli(this, false);
                eli.this.Os(this.DbA.DbA);
            } else {
                eli.this.eli(this, true);
            }
            this.ui = true;
        }

        public void DbA() throws IOException {
            eli.this.eli(this, false);
        }

        /* renamed from: com.bytedance.sdk.component.ui.Os.eli.eli.eli$eli$eli, reason: collision with other inner class name */
        private class C0148eli extends FilterOutputStream {
            private C0148eli(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0147eli.this.aGH = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0147eli.this.aGH = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0147eli.this.aGH = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0147eli.this.aGH = true;
                }
            }
        }
    }

    private final class DbA {
        private final String DbA;
        private long MGA;
        private final long[] Os;
        private boolean aGH;
        private C0147eli ui;

        private DbA(String str) {
            this.DbA = str;
            this.Os = new long[eli.this.aAs];
        }

        public String eli() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.Os) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eli(String[] strArr) throws IOException {
            if (strArr.length != eli.this.aAs) {
                throw DbA(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.Os[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw DbA(strArr);
                }
            }
        }

        private IOException DbA(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File eli(int i) {
            return new File(eli.this.aGH, this.DbA + "." + i);
        }

        public File DbA(int i) {
            return new File(eli.this.aGH, this.DbA + "." + i + ".tmp");
        }
    }
}
