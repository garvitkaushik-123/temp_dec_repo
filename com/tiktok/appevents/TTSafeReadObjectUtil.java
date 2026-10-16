package com.tiktok.appevents;

import com.tiktok.appevents.TTAppEvent;
import com.tiktok.appevents.TTCrashHandler;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes6.dex */
public class TTSafeReadObjectUtil {
    public static TTAppEventPersist safeReadTTAppEventPersist(InputStream in) throws IOException, ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TTAppEventPersist.class);
        arrayList.add(ArrayList.class);
        arrayList.add(TTAppEvent.class);
        arrayList.add(Enum.class);
        arrayList.add(String.class);
        arrayList.add(Date.class);
        arrayList.add(Long.class);
        arrayList.add(TTUserInfo.class);
        arrayList.add(TTAppEvent.TTAppEventType.class);
        return (TTAppEventPersist) safeReadObjects(arrayList, Long.MAX_VALUE, Long.MAX_VALUE, in);
    }

    public static TTCrashHandler.TTCrashReport safeReadTTCrashHandler(InputStream in) throws IOException, ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TTCrashHandler.TTCrashReport.class);
        arrayList.add(TTCrashHandler.TTCrashReport.Monitor.class);
        arrayList.add(String.class);
        arrayList.add(Long.class);
        arrayList.add(Integer.class);
        arrayList.add(ArrayList.class);
        return (TTCrashHandler.TTCrashReport) safeReadObjects(arrayList, Long.MAX_VALUE, Long.MAX_VALUE, in);
    }

    public static <T> T safeReadObjects(final List<Class<?>> list, final long j, final long j2, InputStream inputStream) throws IOException, ClassNotFoundException {
        FilterInputStream filterInputStream = new FilterInputStream(inputStream) { // from class: com.tiktok.appevents.TTSafeReadObjectUtil.1
            private long length = 0;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                int read = super.read();
                if (read != -1) {
                    this.length++;
                    checkLength();
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] b, int off, int readLength) throws IOException {
                int read = super.read(b, off, readLength);
                if (read > 0) {
                    this.length += read;
                    checkLength();
                }
                return read;
            }

            private void checkLength() {
                if (this.length > j2) {
                    throw new SecurityException("too many bytes from stream. Limit is " + j2);
                }
            }
        };
        ObjectInputStream objectInputStream = new ObjectInputStream(filterInputStream) { // from class: com.tiktok.appevents.TTSafeReadObjectUtil.2
            private int objCount = 0;
            boolean enableResolve = enableResolveObject(true);

            @Override // java.io.ObjectInputStream
            protected Object resolveObject(Object obj) throws IOException {
                int i = this.objCount;
                this.objCount = i + 1;
                if (i > j) {
                    throw new SecurityException("too many objects from stream. Limit is " + j);
                }
                return super.resolveObject(obj);
            }

            @Override // java.io.ObjectInputStream
            protected Class<?> resolveClass(ObjectStreamClass osc) throws IOException, ClassNotFoundException {
                Class<?> resolveClass = super.resolveClass(osc);
                if (resolveClass.isArray() || resolveClass.equals(String.class) || Number.class.isAssignableFrom(resolveClass) || list.contains(resolveClass)) {
                    return resolveClass;
                }
                throw new SecurityException("deserialize unauthorized " + resolveClass);
            }
        };
        T t = (T) objectInputStream.readObject();
        try {
            inputStream.close();
            filterInputStream.close();
            objectInputStream.close();
            return t;
        } catch (Throwable th) {
            th.printStackTrace();
            return t;
        }
    }
}
