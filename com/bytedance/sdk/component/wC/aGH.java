package com.bytedance.sdk.component.wC;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.Dfc;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class aGH {
    private static AtomicInteger Os = new AtomicInteger(0);
    public static final String[] eli = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] DbA = {"tt_pangle", "bd_tracker"};
    private static int aGH = 0;
    private static int ui = 0;

    public static void eli() {
        try {
            DbA();
        } catch (Throwable unused) {
        }
    }

    private static void DbA() {
        int i;
        String str;
        Os FC = MGA.FC();
        if (FC == null) {
            return;
        }
        int i2 = 1;
        int addAndGet = Os.addAndGet(1);
        if (MGA.Os < 0 || addAndGet % MGA.Os != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap hashMap = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean eli2 = Dfc.eli();
        int size = allStackTraces.size();
        if (size > ui) {
            ui = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i4 += i2;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb = new StringBuilder("\n");
            if (eli2) {
                sb.append("Thread Name is : " + key.getName());
                sb.append("\n");
            }
            int length = value.length;
            String str2 = null;
            int i5 = 0;
            while (i5 < length) {
                int i6 = i2;
                String stackTraceElement = value[i5].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (eli2) {
                    sb.append(stackTraceElement + "\n");
                }
                if (TextUtils.isEmpty(str2)) {
                    if (eli(stackTraceElement, eli)) {
                        str = stackTraceElement;
                    } else {
                        str = stackTraceElement;
                        if (!eli(key.getName(), DbA)) {
                        }
                    }
                    i3++;
                    str2 = str;
                }
                i5++;
                it = it2;
                i2 = i6;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            int i7 = i2;
            if (eli2) {
                if (TextUtils.isEmpty(str2)) {
                    i = i7;
                } else {
                    String str3 = str2 + C3040d4.i.c + key.getName();
                    eli eliVar = (eli) hashMap.get(str3);
                    if (eliVar != null) {
                        eliVar.eli(eliVar.eli() + 1);
                        i = i7;
                    } else {
                        String sb2 = sb.toString();
                        String name = key.getName();
                        i = i7;
                        eliVar = new eli(str3, i, sb2, name);
                    }
                    hashMap.put(str3, eliVar);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i4 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb.toString());
                }
            } else {
                i = i7;
            }
            i2 = i;
            it = it3;
        }
        if (i3 > aGH) {
            aGH = i3;
        }
        if (eli2) {
            Log.e("PoolTaskStatistics", "SDK current threads=" + i3 + ", SDK Max threads=" + aGH + ", Application threads = " + size + ", Application max threads = " + ui);
            Iterator it4 = hashMap.entrySet().iterator();
            while (it4.hasNext()) {
                Log.i("PoolTaskStatistics", ((eli) ((Map.Entry) it4.next()).getValue()).toString());
            }
        }
        FC.eli(new com.bytedance.sdk.component.wC.DbA.eli(i3, aGH, size, ui));
    }

    private static boolean eli(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class eli {
        public String DbA;
        public String Os;
        public String aGH;
        public int eli;

        public eli(String str, int i, String str2, String str3) {
            this.Os = str;
            this.eli = i;
            this.aGH = str2;
            this.DbA = str3;
        }

        public void eli(int i) {
            this.eli = i;
        }

        public int eli() {
            return this.eli;
        }

        public String toString() {
            return "ThreadModel{times=" + this.eli + ", name='" + this.DbA + "', lastStackStack='" + this.Os + "'}";
        }
    }
}
