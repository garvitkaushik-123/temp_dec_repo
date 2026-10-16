package com.bykv.vk.openvk.preload.geckox.g;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ChannelUpdateLock.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f957a = new HashMap();
    private FileLock b;
    private String c;

    private a(String str, FileLock fileLock) {
        this.c = str;
        this.b = fileLock;
    }

    public static a a(String str) throws Exception {
        Map<String, Lock> map = f957a;
        synchronized (map) {
            Lock lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
            if (!lock.tryLock()) {
                return null;
            }
            try {
                FileLock c = FileLock.c(str);
                if (c == null) {
                    lock.unlock();
                    return null;
                }
                return new a(str, c);
            } catch (Exception e) {
                lock.lock();
                com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException(e));
                return null;
            }
        }
    }

    public final void a() {
        Map<String, Lock> map = f957a;
        synchronized (map) {
            try {
                this.b.a();
                this.b.b();
                map.get(this.c).unlock();
            } catch (Throwable th) {
                f957a.get(this.c).unlock();
                throw th;
            }
        }
    }
}
