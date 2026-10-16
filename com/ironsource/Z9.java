package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class Z9 {
    private static Z9 c;

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<ImpressionDataListener> f3162a = new HashSet<>();
    private ConcurrentHashMap<String, List<String>> b = new ConcurrentHashMap<>();

    Z9() {
    }

    public static synchronized Z9 b() {
        Z9 z9;
        synchronized (Z9.class) {
            if (c == null) {
                c = new Z9();
            }
            z9 = c;
        }
        return z9;
    }

    public HashSet<ImpressionDataListener> a() {
        return this.f3162a;
    }

    public ConcurrentHashMap<String, List<String>> c() {
        return this.b;
    }

    public void d() {
        synchronized (this) {
            this.f3162a.clear();
        }
    }

    public void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f3162a.add(impressionDataListener);
        }
    }

    public void a(String str, List<String> list) {
        this.b.put(str, list);
    }

    public void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f3162a.remove(impressionDataListener);
        }
    }
}
