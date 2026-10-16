package com.pgl.ssdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ironsource.Y1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes6.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile l0 f6399a;
    private Context b;
    private List<Integer> c = new ArrayList();

    private l0(Context context) {
        this.b = null;
        this.b = context;
    }

    public static l0 a(Context context) {
        if (f6399a == null) {
            synchronized (l0.class) {
                if (f6399a == null) {
                    f6399a = new l0(context);
                }
            }
        }
        return f6399a;
    }

    public int b() {
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 0;
        }
        return registerReceiver.getIntExtra("plugged", 0);
    }

    public int c() {
        if (this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
            return 0;
        }
        return Math.round(((r0.getIntExtra("level", 0) / r0.getIntExtra("scale", 0)) * 100.0f) * 10.0f) / 10;
    }

    public synchronized String d() {
        if (this.c.size() <= 0) {
            return Y1.f;
        }
        return String.valueOf(this.c.get(r0.size() - 1).intValue() % 10000);
    }

    public synchronized String e() {
        return new JSONArray((Collection) this.c).toString();
    }

    public int f() {
        int c;
        int i = 0;
        try {
            synchronized (this) {
                i = b();
                c = c();
            }
            return (i * 10000) + c;
        } catch (Exception unused) {
            return i * 10000;
        }
    }

    public void a() {
        int f = f();
        if (f == -1) {
            return;
        }
        this.c.add(Integer.valueOf(f));
        try {
            int size = this.c.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.c.subList(size - 10, size));
                this.c.clear();
                this.c = arrayList;
            }
        } catch (Throwable unused) {
        }
    }
}
