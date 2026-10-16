package com.mbridge.msdk.foundation.tools;

import com.google.common.primitives.SignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.UShort;

/* loaded from: classes6.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, b> encoderMap;
    private a0 fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private final Map<String, i> data = new HashMap();
    private final Executor executor = new d0();
    private final ArrayList<d> invalids = new ArrayList<>();
    private final c logger = b0.b;
    private boolean autoCommit = true;

    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private b[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            this.path = str.endsWith(RemoteSettings.FORWARD_SLASH_STRING) ? str : str + '/';
            this.name = str2;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            FastKV fastKV;
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV2 = map.get(str);
            if (fastKV2 != null) {
                return fastKV2;
            }
            synchronized (Builder.class) {
                fastKV = map.get(str);
                if (fastKV == null) {
                    fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                    map.put(str, fastKV);
                }
            }
            return fastKV;
        }

        public Builder encoder(b[] bVarArr) {
            this.encoders = bVarArr;
            return this;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastKV.this.writeToCFile();
        }
    }

    public interface b<T> {
        T a(byte[] bArr, int i, int i2);

        String a();

        byte[] a(T t);
    }

    public interface c {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    private static class d implements Comparable<d> {

        /* renamed from: a, reason: collision with root package name */
        int f4340a;
        int b;

        d(int i, int i2) {
            this.b = i;
            this.f4340a = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.b - dVar.b;
        }
    }

    static {
        int a2 = c1.a();
        PAGE_SIZE = a2;
        int max = Math.max(a2 << 1, 16384);
        DOUBLE_LIMIT = max;
        TRUNCATE_THRESHOLD = max << 1;
        TYPE_SIZE = new int[]{0, 1, 4, 4, 8, 8};
    }

    FastKV(String str, String str2, b[] bVarArr, int i) {
        this.path = str;
        this.name = str2;
        this.writingMode = i;
        HashMap hashMap = new HashMap();
        y0 y0Var = y0.f4388a;
        hashMap.put(y0Var.a(), y0Var);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String a2 = bVar.a();
                if (hashMap.containsKey(a2)) {
                    error("duplicate encoder tag:" + a2);
                } else {
                    hashMap.put(a2, bVar);
                }
            }
        }
        this.encoderMap = hashMap;
        loadData();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        int saveArray = saveArray(str, bArr, b2);
        if (saveArray != 0) {
            String str2 = this.tempExternalName;
            boolean z = str2 != null;
            if (z) {
                this.tempExternalName = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            this.data.put(str, b2 == 6 ? new p(this.updateStart, saveArray, (String) obj2, length, z) : b2 == 7 ? new h(this.updateStart, saveArray, obj2, length, z) : new o(this.updateStart, saveArray, obj2, length, z));
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, q qVar, byte b2) {
        if (qVar == null) {
            addObject(str, obj, bArr, b2);
        } else if (qVar.b || qVar.e != bArr.length) {
            updateObject(str, obj, bArr, qVar);
        } else {
            updateBytes(qVar.f4368a, bArr);
            qVar.d = obj;
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i = this.dataEnd;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        a0 a0Var = this.fastBuffer;
        if (a0Var == null || a0Var.f4349a.length != PAGE_SIZE) {
            this.fastBuffer = new a0(PAGE_SIZE);
        } else {
            a0Var.b(0, 0);
            this.fastBuffer.a(4, 0L);
        }
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i = this.writingMode;
        if (i == 1) {
            this.executor.execute(new a());
        } else if (i == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                error(e);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i, int i2) {
        this.invalidBytes += i2 - i;
        this.invalids.add(new d(i, i2));
    }

    private void deleteCFiles() {
        try {
            c1.a(new File(this.path, this.name + C_SUFFIX));
            c1.a(new File(this.path, this.name + TEMP_SUFFIX));
        } catch (Exception e) {
            error(e);
        }
    }

    private void ensureSize(int i) {
        int length = this.fastBuffer.f4349a.length;
        int i2 = this.dataEnd + i;
        if (i2 >= length) {
            int i3 = this.invalidBytes;
            if (i3 > i && i3 > bytesThreshold()) {
                gc(i);
                return;
            }
            int newCapacity = getNewCapacity(length, i2);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f4349a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f4349a = bArr;
            if (this.writingMode == 0) {
                try {
                    long j = newCapacity;
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e) {
                    error(new Exception(MAP_FAILED, e));
                    this.fastBuffer.b(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(Exception exc) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.b(this.name, exc);
        }
    }

    private void fastPutString(String str, String str2, p pVar) {
        int b2 = a0.b(str2);
        if (pVar == null) {
            int b3 = a0.b(str);
            checkKeySize(b3);
            int i = b3 + 4;
            this.updateSize = i + b2;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, b3);
            putStringValue(str2, b2);
            Map<String, i> map = this.data;
            int i2 = this.updateStart;
            map.put(str, new p(i2, i + i2, str2, b2, false));
            updateChange();
        } else {
            int i3 = pVar.f4368a;
            int i4 = i3 - pVar.c;
            int i5 = pVar.e;
            boolean z = false;
            if (i5 == b2) {
                this.checksum = this.fastBuffer.a(i3, i5) ^ this.checksum;
                if (b2 == str2.length()) {
                    str2.getBytes(0, b2, this.fastBuffer.f4349a, pVar.f4368a);
                } else {
                    a0 a0Var = this.fastBuffer;
                    a0Var.b = pVar.f4368a;
                    a0Var.c(str2);
                }
                this.updateStart = pVar.f4368a;
                this.updateSize = b2;
            } else {
                this.updateSize = i4 + b2;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i6 = i4 - 3;
                a0 a0Var2 = this.fastBuffer;
                byte[] bArr = a0Var2.f4349a;
                System.arraycopy(bArr, pVar.c + 1, bArr, a0Var2.b, i6);
                this.fastBuffer.b += i6;
                putStringValue(str2, b2);
                remove((byte) 6, pVar.c, pVar.f4368a + pVar.e);
                r5 = pVar.b ? (String) pVar.d : null;
                pVar.b = false;
                int i7 = this.updateStart;
                pVar.c = i7;
                pVar.f4368a = i7 + i4;
                pVar.e = b2;
                z = true;
            }
            pVar.d = str2;
            updateChange();
            if (z) {
                checkGC();
            }
            if (r5 != null) {
                c1.a(new File(this.path + this.name, r5));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(h hVar) {
        try {
            byte[] c2 = c1.c(new File(this.path + this.name, (String) hVar.d));
            return c2 != null ? c2 : EMPTY_ARRAY;
        } catch (Exception e) {
            error(e);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i, int i2) {
        if (i2 > 536870912) {
            throw new IllegalStateException("data size out of limit");
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = DOUBLE_LIMIT;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private Object getObjectFromFile(o oVar) {
        try {
            byte[] c2 = c1.c(new File(this.path + this.name, (String) oVar.d));
            if (c2 == null) {
                warning(new Exception("Read object data failed"));
                return null;
            }
            int i = c2[0] & 255;
            String str = new String(c2, 1, i, StandardCharsets.UTF_8);
            b bVar = this.encoderMap.get(str);
            if (bVar != null) {
                int i2 = i + 1;
                return bVar.a(c2, i2, c2.length - i2);
            }
            warning(new Exception("No encoder for tag:".concat(str)));
            return null;
        } catch (Exception e) {
            error(e);
            return null;
        }
    }

    private String getStringFromFile(p pVar) {
        try {
            byte[] c2 = c1.c(new File(this.path + this.name, (String) pVar.d));
            return (c2 == null || c2.length == 0) ? "" : new String(c2, StandardCharsets.UTF_8);
        } catch (Exception e) {
            error(e);
        }
        return "";
    }

    private void info(String str) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        a0 a0Var = new a0(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(a0Var.f4349a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f4349a;
        byte[] bArr2 = a0Var.f4349a;
        for (int i = 0; i < this.dataEnd; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void loadData() {
        long nanoTime = System.nanoTime();
        if (!loadFromCFile() && this.writingMode == 0) {
            loadFromABFile();
        }
        if (this.fastBuffer == null) {
            this.fastBuffer = new a0(PAGE_SIZE);
        }
        if (this.logger != null) {
            info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    private void loadFromABFile() {
        long j;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (c1.d(file) && c1.d(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                this.aChannel = randomAccessFile.getChannel();
                this.bChannel = randomAccessFile2.getChannel();
                try {
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : PAGE_SIZE);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                    this.fastBuffer = new a0(this.aBuffer.capacity());
                    if (length == 0 && length2 == 0) {
                        this.dataEnd = 12;
                        return;
                    }
                    int i = this.aBuffer.getInt();
                    long j2 = this.aBuffer.getLong();
                    int i2 = this.bBuffer.getInt();
                    long j3 = this.bBuffer.getLong();
                    if (i < 0) {
                        j = 12;
                    } else if (i <= length - 12) {
                        this.dataEnd = i + 12;
                        this.aBuffer.rewind();
                        j = 12;
                        this.aBuffer.get(this.fastBuffer.f4349a, 0, this.dataEnd);
                        if (j2 == this.fastBuffer.a(12, i) && parseData() == 0) {
                            this.checksum = j2;
                            if (length == length2 && isABFileEqual()) {
                                return;
                            }
                            warning(new Exception("B file error"));
                            copyBuffer(this.aBuffer, this.bBuffer, this.dataEnd);
                            return;
                        }
                    } else {
                        j = 12;
                    }
                    if (i2 >= 0 && i2 <= length2 - j) {
                        this.data.clear();
                        clearInvalid();
                        this.dataEnd = i2 + 12;
                        if (this.fastBuffer.f4349a.length != this.bBuffer.capacity()) {
                            this.fastBuffer = new a0(this.bBuffer.capacity());
                        }
                        this.bBuffer.rewind();
                        this.bBuffer.get(this.fastBuffer.f4349a, 0, this.dataEnd);
                        if (j3 == this.fastBuffer.a(12, i2) && parseData() == 0) {
                            warning(new Exception("A file error"));
                            copyBuffer(this.bBuffer, this.aBuffer, this.dataEnd);
                            this.checksum = j3;
                            return;
                        }
                    }
                    error(BOTH_FILES_ERROR);
                    resetData();
                    return;
                } catch (IOException e) {
                    error(e);
                    toBlockingMode();
                    tryBlockingIO(file, file2);
                    return;
                }
            }
            error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e2) {
            error(e2);
            clearData();
            toBlockingMode();
        }
    }

    private boolean loadFromCFile() {
        File file = new File(this.path, this.name + C_SUFFIX);
        File file2 = new File(this.path, this.name + TEMP_SUFFIX);
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!loadWithBlockingIO(file)) {
                    clearData();
                    deleteCFiles();
                    return false;
                }
                if (this.writingMode == 0) {
                    if (!writeToABFile(this.fastBuffer)) {
                        this.writingMode = 1;
                        return false;
                    }
                    info("recover from c file");
                    try {
                        deleteCFiles();
                        return true;
                    } catch (Exception e) {
                        e = e;
                        z = true;
                        error(e);
                        return z;
                    }
                }
            } else if (this.writingMode != 0) {
                File file3 = new File(this.path, this.name + A_SUFFIX);
                File file4 = new File(this.path, this.name + B_SUFFIX);
                if (file3.exists() && file4.exists()) {
                    tryBlockingIO(file3, file4);
                }
            }
            return false;
        } catch (Exception e2) {
            e = e2;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i);
            a0 a0Var = this.fastBuffer;
            if (a0Var == null || a0Var.f4349a.length != newCapacity) {
                a0Var = new a0(new byte[newCapacity]);
                this.fastBuffer = a0Var;
            } else {
                a0Var.b = 0;
            }
            c1.a(file, a0Var.f4349a, i);
            int d2 = a0Var.d();
            long e = a0Var.e();
            this.dataEnd = d2 + 12;
            if (d2 >= 0 && d2 <= i - 12 && e == a0Var.a(12, d2) && parseData() == 0) {
                this.checksum = e;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        d dVar = this.invalids.get(size);
        while (size > 0) {
            int i = size - 1;
            d dVar2 = this.invalids.get(i);
            if (dVar.b == dVar2.f4340a) {
                dVar2.f4340a = dVar.f4340a;
                this.invalids.remove(size);
            }
            dVar = dVar2;
            size = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x016b, code lost:
    
        throw new java.lang.Exception(com.mbridge.msdk.foundation.tools.FastKV.PARSE_DATA_FAILED);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int parseData() {
        a0 a0Var = this.fastBuffer;
        a0Var.b = 12;
        while (true) {
            try {
                int i = a0Var.b;
                int i2 = this.dataEnd;
                if (i >= i2) {
                    if (i == i2) {
                        return 0;
                    }
                    warning(new Exception(PARSE_DATA_FAILED));
                    return -1;
                }
                byte a2 = a0Var.a();
                byte b2 = (byte) (a2 & 63);
                if (b2 < 1 || b2 > 8) {
                    break;
                }
                int a3 = a0Var.a() & 255;
                if (a2 < 0) {
                    a0Var.b += a3;
                    int f = b2 <= 5 ? TYPE_SIZE[b2] : a0Var.f() & UShort.MAX_VALUE;
                    a0 a0Var2 = this.fastBuffer;
                    int i3 = a0Var2.b + f;
                    a0Var2.b = i3;
                    countInvalid(i, i3);
                } else {
                    String e = a0Var.e(a3);
                    int i4 = a0Var.b;
                    if (b2 > 5) {
                        int f2 = 65535 & a0Var.f();
                        boolean z = (a2 & SignedBytes.MAX_POWER_OF_TWO) != 0;
                        checkValueSize(f2, z);
                        if (b2 == 6) {
                            this.data.put(e, new p(i, i4 + 2, a0Var.e(f2), f2, z));
                        } else if (b2 == 7) {
                            this.data.put(e, new h(i, i4 + 2, z ? a0Var.e(f2) : a0Var.b(f2), f2, z));
                        } else if (z) {
                            this.data.put(e, new o(i, i4 + 2, a0Var.e(f2), f2, true));
                        } else {
                            int a4 = a0Var.a() & 255;
                            String e2 = a0Var.e(a4);
                            b bVar = this.encoderMap.get(e2);
                            int i5 = f2 - (a4 + 1);
                            if (i5 < 0) {
                                throw new Exception(PARSE_DATA_FAILED);
                            }
                            if (bVar != null) {
                                try {
                                    Object a5 = bVar.a(a0Var.f4349a, a0Var.b, i5);
                                    if (a5 != null) {
                                        this.data.put(e, new o(i, i4 + 2, a5, f2, false));
                                    }
                                } catch (Exception e3) {
                                    error(e3);
                                }
                            } else {
                                error("object with tag: " + e2 + " without encoder");
                            }
                            a0Var.b += i5;
                        }
                    } else if (b2 == 1) {
                        this.data.put(e, new j(i4, a0Var.a() == 1));
                    } else if (b2 == 2) {
                        this.data.put(e, new m(i4, a0Var.d()));
                    } else if (b2 == 3) {
                        this.data.put(e, new l(i4, a0Var.c()));
                    } else if (b2 != 4) {
                        this.data.put(e, new k(i4, a0Var.b()));
                    } else {
                        this.data.put(e, new n(i4, a0Var.e()));
                    }
                }
            } catch (Exception e4) {
                warning(e4);
                return -1;
            }
        }
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i = this.dataEnd;
        this.updateStart = i;
        this.dataEnd = this.updateSize + i;
        this.fastBuffer.b = i;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i) {
        this.fastBuffer.a((byte) i);
        if (i != str.length()) {
            this.fastBuffer.c(str);
            return;
        }
        a0 a0Var = this.fastBuffer;
        str.getBytes(0, i, a0Var.f4349a, a0Var.b);
        this.fastBuffer.b += i;
    }

    private void putStringValue(String str, int i) {
        this.fastBuffer.a((short) i);
        if (i != str.length()) {
            this.fastBuffer.c(str);
        } else {
            a0 a0Var = this.fastBuffer;
            str.getBytes(0, i, a0Var.f4349a, a0Var.b);
        }
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int capacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (capacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            long j = i;
            fileChannel.truncate(j);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        c1.a(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b2) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String b3 = c1.b();
        if (!c1.a(new File(this.path + this.name, b3), bArr)) {
            error("save large value failed");
            return 0;
        }
        this.tempExternalName = b3;
        byte[] bArr2 = new byte[32];
        b3.getBytes(0, 32, bArr2, 0);
        return wrapArray(str, bArr2, (byte) (b2 | SignedBytes.MAX_POWER_OF_TWO));
    }

    private long shiftCheckSum(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i = this.removeStart;
        if (i != 0) {
            mappedByteBuffer.put(i, this.fastBuffer.f4349a[i]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f4349a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        c1.a(this.aChannel);
        c1.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i) {
        int i2 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i2, i + i2);
        byte[] bArr = this.fastBuffer.f4349a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f4349a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j = newCapacity;
                this.aChannel.truncate(j);
                MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j);
                MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e) {
                error(new Exception(MAP_FAILED, e));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e) {
            warning(e);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e2) {
            warning(e2);
        }
        clearData();
    }

    private void updateBoolean(byte b2, int i) {
        long shiftCheckSum = this.checksum ^ shiftCheckSum(1L, i);
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.put(i, b2);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i, b2);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.f4349a[i] = b2;
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.a(i, length);
        a0 a0Var = this.fastBuffer;
        a0Var.b = i;
        a0Var.a(bArr);
        long a2 = this.checksum ^ this.fastBuffer.a(i, length);
        this.checksum = a2;
        if (this.writingMode != 0) {
            this.fastBuffer.a(4, a2);
            return;
        }
        this.aBuffer.putInt(0, -1);
        this.aBuffer.putLong(4, this.checksum);
        this.aBuffer.position(i);
        this.aBuffer.put(bArr);
        this.aBuffer.putInt(0, this.dataEnd - 12);
        this.bBuffer.putLong(4, this.checksum);
        this.bBuffer.position(i);
        this.bBuffer.put(bArr);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.a(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.b(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i, long j, int i2) {
        long shiftCheckSum = shiftCheckSum(j, i2) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putInt(i2, i);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i2, i);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.b(i2, i);
    }

    private void updateInt64(long j, long j2, int i) {
        long shiftCheckSum = shiftCheckSum(j2, i) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putLong(i, j);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i, j);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i, j);
    }

    private void updateObject(String str, Object obj, byte[] bArr, q qVar) {
        int saveArray = saveArray(str, bArr, qVar.a());
        if (saveArray != 0) {
            String str2 = qVar.b ? (String) qVar.d : null;
            remove(qVar.a(), qVar.c, qVar.f4368a + qVar.e);
            String str3 = this.tempExternalName;
            boolean z = str3 != null;
            qVar.c = this.updateStart;
            qVar.f4368a = saveArray;
            qVar.b = z;
            if (z) {
                qVar.d = str3;
                qVar.e = 32;
                this.tempExternalName = null;
            } else {
                qVar.d = obj;
                qVar.e = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                c1.a(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i, int[] iArr) {
        for (i iVar : this.data.values()) {
            int i2 = iVar.f4368a;
            if (i2 > i) {
                int i3 = iArr[(c1.a(iArr, i2) << 1) + 1];
                iVar.f4368a -= i3;
                if (iVar.a() >= 6) {
                    ((q) iVar).c -= i3;
                }
            }
        }
    }

    private void warning(Exception exc) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.a(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b2) {
        wrapHeader(str, b2, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        a0 a0Var = this.fastBuffer;
        int i = a0Var.b;
        a0Var.a(bArr);
        return i;
    }

    private void wrapHeader(String str, byte b2) {
        wrapHeader(str, b2, TYPE_SIZE[b2]);
    }

    private boolean writeToABFile(a0 a0Var) {
        int length = a0Var.f4349a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (!c1.d(file) || !c1.d(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.aBuffer = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bBuffer = map2;
            map2.order(byteOrder);
            this.aBuffer.put(a0Var.f4349a, 0, this.dataEnd);
            this.bBuffer.put(a0Var.f4349a, 0, this.dataEnd);
            return true;
        } catch (Exception e) {
            error(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            File file = new File(this.path, this.name + TEMP_SUFFIX);
            if (c1.d(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.dataEnd);
                randomAccessFile.write(this.fastBuffer.f4349a, 0, this.dataEnd);
                randomAccessFile.close();
                File file2 = new File(this.path, this.name + C_SUFFIX);
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    warning(new Exception("rename failed"));
                }
            }
        } catch (Exception e) {
            error(e);
        }
        return false;
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    void gc(int i) {
        Collections.sort(this.invalids);
        mergeInvalids();
        d dVar = this.invalids.get(0);
        int i2 = dVar.b;
        int i3 = this.dataEnd;
        int i4 = i3 - this.invalidBytes;
        int i5 = i4 - 12;
        int i6 = i4 - i2;
        int i7 = i3 - i2;
        boolean z = true;
        boolean z2 = i5 < i7 + i6;
        if (!z2) {
            this.checksum ^= this.fastBuffer.a(i2, i7);
        }
        int size = this.invalids.size();
        int i8 = size - 1;
        int i9 = this.dataEnd - this.invalids.get(i8).f4340a;
        int[] iArr = new int[(i9 > 0 ? size : i8) << 1];
        int i10 = dVar.b;
        int i11 = dVar.f4340a;
        int i12 = 1;
        while (i12 < size) {
            d dVar2 = this.invalids.get(i12);
            boolean z3 = z;
            int i13 = dVar2.b - i11;
            byte[] bArr = this.fastBuffer.f4349a;
            System.arraycopy(bArr, i11, bArr, i10, i13);
            int i14 = (i12 - 1) << 1;
            iArr[i14] = i11;
            iArr[i14 + 1] = i11 - i10;
            i10 += i13;
            i11 = dVar2.f4340a;
            i12++;
            z = z3;
        }
        if (i9 > 0) {
            byte[] bArr2 = this.fastBuffer.f4349a;
            System.arraycopy(bArr2, i11, bArr2, i10, i9);
            int i15 = i8 << 1;
            iArr[i15] = i11;
            iArr[i15 + 1] = i11 - i10;
        }
        clearInvalid();
        if (z2) {
            this.checksum = this.fastBuffer.a(12, i5);
        } else {
            this.checksum ^= this.fastBuffer.a(i2, i6);
        }
        this.dataEnd = i4;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i2);
            this.aBuffer.put(this.fastBuffer.f4349a, i2, i6);
            this.aBuffer.putInt(0, i5);
            this.bBuffer.putInt(0, i5);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i2);
            this.bBuffer.put(this.fastBuffer.f4349a, i2, i6);
        } else {
            this.fastBuffer.b(0, i5);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i2, iArr);
        int i16 = i4 + i;
        if (this.fastBuffer.f4349a.length - i16 > TRUNCATE_THRESHOLD) {
            truncate(i16);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, i> entry : this.data.entrySet()) {
            String key = entry.getKey();
            i value = entry.getValue();
            switch (value.a()) {
                case 1:
                    valueOf = Boolean.valueOf(((j) value).b);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((m) value).b);
                    break;
                case 3:
                    valueOf = Float.valueOf(((l) value).b);
                    break;
                case 4:
                    valueOf = Long.valueOf(((n) value).b);
                    break;
                case 5:
                    valueOf = Double.valueOf(((k) value).b);
                    break;
                case 6:
                    p pVar = (p) value;
                    if (pVar.b) {
                        valueOf = getStringFromFile(pVar);
                        break;
                    } else {
                        valueOf = pVar.d;
                        break;
                    }
                case 7:
                    h hVar = (h) value;
                    if (hVar.b) {
                        valueOf = getArrayFromFile(hVar);
                        break;
                    } else {
                        valueOf = hVar.d;
                        break;
                    }
                case 8:
                    o oVar = (o) value;
                    if (oVar.b) {
                        valueOf = getObjectFromFile(oVar);
                        break;
                    } else {
                        valueOf = oVar.d;
                        break;
                    }
                default:
                    valueOf = null;
                    break;
            }
            hashMap.put(key, valueOf);
        }
        return hashMap;
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized long getLong(String str) {
        n nVar;
        nVar = (n) this.data.get(str);
        return nVar == null ? 0L : nVar.b;
    }

    public synchronized <T> T getObject(String str) {
        o oVar = (o) this.data.get(str);
        if (oVar != null) {
            return oVar.b ? (T) getObjectFromFile(oVar) : (T) oVar.d;
        }
        return null;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }

    public synchronized void putArray(String str, byte[] bArr) {
        Throwable th;
        try {
            try {
                checkKey(str);
                if (bArr == null) {
                    try {
                        remove(str);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    addOrUpdate(str, bArr, bArr, (h) this.data.get(str), (byte) 7);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized void putBoolean(String str, boolean z) {
        checkKey(str);
        j jVar = (j) this.data.get(str);
        if (jVar == null) {
            wrapHeader(str, (byte) 1);
            a0 a0Var = this.fastBuffer;
            int i = a0Var.b;
            a0Var.a(z ? (byte) 1 : (byte) 0);
            updateChange();
            this.data.put(str, new j(i, z));
            checkIfCommit();
        } else if (jVar.b != z) {
            jVar.b = z;
            updateBoolean(z ? (byte) 1 : (byte) 0, jVar.f4368a);
            checkIfCommit();
        }
    }

    public synchronized void putDouble(String str, double d2) {
        Throwable th;
        try {
            try {
                checkKey(str);
                k kVar = (k) this.data.get(str);
                if (kVar == null) {
                    try {
                        wrapHeader(str, (byte) 5);
                        a0 a0Var = this.fastBuffer;
                        int i = a0Var.b;
                        a0Var.a(Double.doubleToRawLongBits(d2));
                        updateChange();
                        this.data.put(str, new k(i, d2));
                        checkIfCommit();
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else if (kVar.b != d2) {
                    long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
                    long doubleToRawLongBits2 = Double.doubleToRawLongBits(kVar.b) ^ doubleToRawLongBits;
                    kVar.b = d2;
                    updateInt64(doubleToRawLongBits, doubleToRawLongBits2, kVar.f4368a);
                    checkIfCommit();
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized void putFloat(String str, float f) {
        checkKey(str);
        l lVar = (l) this.data.get(str);
        if (lVar == null) {
            wrapHeader(str, (byte) 3);
            a0 a0Var = this.fastBuffer;
            int i = a0Var.b;
            a0Var.g(Float.floatToRawIntBits(f));
            updateChange();
            this.data.put(str, new l(i, f));
            checkIfCommit();
        } else if (lVar.b != f) {
            lVar.b = f;
            updateInt32(Float.floatToRawIntBits(f), (Float.floatToRawIntBits(lVar.b) ^ r6) & 4294967295L, lVar.f4368a);
            checkIfCommit();
        }
    }

    public synchronized void putInt(String str, int i) {
        checkKey(str);
        m mVar = (m) this.data.get(str);
        if (mVar == null) {
            wrapHeader(str, (byte) 2);
            a0 a0Var = this.fastBuffer;
            int i2 = a0Var.b;
            a0Var.g(i);
            updateChange();
            this.data.put(str, new m(i2, i));
            checkIfCommit();
        } else {
            if (mVar.b != i) {
                mVar.b = i;
                updateInt32(i, (r6 ^ i) & 4294967295L, mVar.f4368a);
                checkIfCommit();
            }
        }
    }

    public synchronized void putLong(String str, long j) {
        Throwable th;
        try {
            try {
                checkKey(str);
                n nVar = (n) this.data.get(str);
                if (nVar == null) {
                    try {
                        wrapHeader(str, (byte) 4);
                        a0 a0Var = this.fastBuffer;
                        int i = a0Var.b;
                        a0Var.a(j);
                        updateChange();
                        this.data.put(str, new n(i, j));
                        checkIfCommit();
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    long j2 = nVar.b;
                    if (j2 != j) {
                        long j3 = j ^ j2;
                        nVar.b = j;
                        updateInt64(j, j3, nVar.f4368a);
                        checkIfCommit();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized <T> void putObject(String str, T t, b<T> bVar) {
        Throwable th;
        byte[] bArr;
        try {
            try {
                checkKey(str);
                if (bVar == null) {
                    throw new IllegalArgumentException("Encoder is null");
                }
                String a2 = bVar.a();
                if (a2 == null || a2.isEmpty() || a2.length() > 50) {
                    throw new IllegalArgumentException("Invalid encoder tag:" + a2);
                }
                if (!this.encoderMap.containsKey(a2)) {
                    throw new IllegalArgumentException("Encoder hasn't been registered");
                }
                try {
                    if (t == null) {
                        remove(str);
                        return;
                    }
                    try {
                        bArr = bVar.a(t);
                    } catch (Exception e) {
                        error(e);
                        bArr = null;
                    }
                    if (bArr == null) {
                        remove(str);
                        return;
                    }
                    int b2 = a0.b(a2);
                    a0 a0Var = new a0(b2 + 1 + bArr.length);
                    a0Var.a((byte) b2);
                    a0Var.c(a2);
                    a0Var.a(bArr);
                    addOrUpdate(str, t, a0Var.f4349a, (o) this.data.get(str), (byte) 8);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized void putString(String str, String str2) {
        Throwable th;
        try {
            try {
                checkKey(str);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            if (str2 == null) {
                remove(str);
            } else {
                p pVar = (p) this.data.get(str);
                if (str2.length() * 3 >= 2048) {
                    addOrUpdate(str, str2, str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8), pVar, (byte) 6);
                }
                fastPutString(str, str2, pVar);
            }
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            putObject(str, set, y0.f4388a);
        }
    }

    public synchronized void remove(String str) {
        i iVar = this.data.get(str);
        if (iVar != null) {
            this.data.remove(str);
            byte a2 = iVar.a();
            String str2 = null;
            if (a2 <= 5) {
                int b2 = a0.b(str);
                int i = iVar.f4368a;
                remove(a2, i - (b2 + 2), i + TYPE_SIZE[a2]);
            } else {
                q qVar = (q) iVar;
                remove(a2, qVar.c, qVar.f4368a + qVar.e);
                if (qVar.b) {
                    str2 = (String) qVar.d;
                }
            }
            byte b3 = (byte) (a2 | Byte.MIN_VALUE);
            if (this.writingMode == 0) {
                this.aBuffer.putLong(4, this.checksum);
                this.aBuffer.put(this.removeStart, b3);
                this.bBuffer.putLong(4, this.checksum);
                this.bBuffer.put(this.removeStart, b3);
            } else {
                this.fastBuffer.a(4, this.checksum);
            }
            this.removeStart = 0;
            if (str2 != null) {
                c1.a(new File(this.path + this.name, str2));
            }
            checkGC();
            checkIfCommit();
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }

    private void wrapHeader(String str, byte b2, int i) {
        int b3 = a0.b(str);
        checkKeySize(b3);
        this.updateSize = b3 + 2 + i;
        preparePutBytes();
        this.fastBuffer.a(b2);
        putKey(str, b3);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        h hVar = (h) this.data.get(str);
        if (hVar != null) {
            return hVar.b ? getArrayFromFile(hVar) : (byte[]) hVar.d;
        }
        return bArr;
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        j jVar = (j) this.data.get(str);
        if (jVar != null) {
            z = jVar.b;
        }
        return z;
    }

    public synchronized double getDouble(String str, double d2) {
        k kVar = (k) this.data.get(str);
        if (kVar != null) {
            d2 = kVar.b;
        }
        return d2;
    }

    public synchronized float getFloat(String str, float f) {
        l lVar = (l) this.data.get(str);
        if (lVar != null) {
            f = lVar.b;
        }
        return f;
    }

    public synchronized int getInt(String str, int i) {
        m mVar = (m) this.data.get(str);
        if (mVar != null) {
            i = mVar.b;
        }
        return i;
    }

    public synchronized String getString(String str, String str2) {
        p pVar = (p) this.data.get(str);
        if (pVar != null) {
            return pVar.b ? getStringFromFile(pVar) : (String) pVar.d;
        }
        return str2;
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, b> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set<String> set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, set);
                    }
                } else if (value instanceof byte[]) {
                    putArray(key, (byte[]) value);
                } else if (map2 != null) {
                    b bVar = map2.get(value.getClass());
                    if (bVar != null) {
                        putObject(key, value, bVar);
                    } else {
                        warning(new Exception("missing encoder for type:" + value.getClass()));
                    }
                } else {
                    warning(new Exception("missing encoders"));
                }
            }
        }
    }

    private void error(String str) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.b(this.name, new Exception(str));
        }
    }

    public synchronized long getLong(String str, long j) {
        n nVar = (n) this.data.get(str);
        if (nVar != null) {
            j = nVar.b;
        }
        return j;
    }

    private void remove(byte b2, int i, int i2) {
        countInvalid(i, i2);
        byte[] bArr = this.fastBuffer.f4349a;
        this.checksum = (((bArr[i] ^ r9) & 255) << ((i & 7) << 3)) ^ this.checksum;
        bArr[i] = (byte) (b2 | Byte.MIN_VALUE);
        this.removeStart = i;
    }
}
