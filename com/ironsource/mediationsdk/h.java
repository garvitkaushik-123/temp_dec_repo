package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class h {
    public static final int c = -1;
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, ArrayList<a>> f3533a = new ConcurrentHashMap<>();
    private int b;

    public enum a {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public h(List<NetworkSettings> list, int i) {
        this.b = i;
        for (NetworkSettings networkSettings : list) {
            this.f3533a.put(networkSettings.getProviderName(), new ArrayList<>());
        }
    }

    public void a(ConcurrentHashMap<String, a> concurrentHashMap) {
        if (this.b == 0) {
            return;
        }
        for (String str : this.f3533a.keySet()) {
            a aVar = a.ISAuctionPerformanceNotPartOfWaterfall;
            if (concurrentHashMap.containsKey(str)) {
                aVar = concurrentHashMap.get(str);
            }
            ArrayList<a> arrayList = this.f3533a.get(str);
            if (this.b != -1 && arrayList.size() == this.b) {
                arrayList.remove(0);
            }
            arrayList.add(aVar);
        }
    }

    public String a(String str) {
        ArrayList<a> arrayList = this.f3533a.get(str);
        String str2 = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<a> it = arrayList.iterator();
            str2 = "" + it.next().ordinal();
            while (it.hasNext()) {
                str2 = (str2 + ",") + it.next().ordinal();
            }
        }
        return str2;
    }
}
