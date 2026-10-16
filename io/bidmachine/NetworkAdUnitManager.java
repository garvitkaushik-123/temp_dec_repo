package io.bidmachine;

import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.Tag;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class NetworkAdUnitManager {
    private final AtomicBoolean isNetworkAuctionNotified;
    private final List<NetworkAdUnit> networkAdUnitList;
    private final Tag tag;

    public NetworkAdUnitManager() {
        this(null);
    }

    public NetworkAdUnitManager(List<NetworkAdUnit> networkAdUnitList) {
        this.tag = new Tag("NetworkAdUnitManager");
        this.isNetworkAuctionNotified = new AtomicBoolean(false);
        this.networkAdUnitList = new CopyOnWriteArrayList();
        setNetworkAdUnitList(networkAdUnitList);
    }

    void setNetworkAdUnitList(List<NetworkAdUnit> networkAdUnitList) {
        this.networkAdUnitList.clear();
        if (Utils.isEmpty(networkAdUnitList)) {
            return;
        }
        this.networkAdUnitList.addAll(networkAdUnitList);
    }

    NetworkAdUnit findOrAddWinnerNetworkAdUnit(NetworkAdapter networkAdapter, AdsFormat adsFormat, Map<String, String> networkParams) {
        String str = networkParams.get(ProtoExtConstants.AD_UNIT_ID);
        NetworkAdUnit networkAdUnit = null;
        if (!TextUtils.isEmpty(str)) {
            for (NetworkAdUnit networkAdUnit2 : this.networkAdUnitList) {
                if (networkAdUnit2.getId().equals(str)) {
                    networkAdUnit = networkAdUnit2;
                }
            }
        }
        if (networkAdUnit != null) {
            return networkAdUnit;
        }
        NetworkAdUnit networkAdUnit3 = new NetworkAdUnit(networkAdapter, adsFormat, networkParams);
        this.networkAdUnitList.add(networkAdUnit3);
        return networkAdUnit3;
    }

    void notifyNetworkAuctionResult(NetworkAdUnit winnerNetworkAdUnit) {
        if (this.isNetworkAuctionNotified.compareAndSet(false, true)) {
            Logger.d(this.tag, "notifyNetworkAuctionResult");
            for (NetworkAdUnit networkAdUnit : this.networkAdUnitList) {
                if (networkAdUnit == winnerNetworkAdUnit) {
                    try {
                        networkAdUnit.onWinAuction();
                    } catch (Throwable unused) {
                    }
                } else {
                    networkAdUnit.onLossAuction();
                }
            }
        }
    }

    void notifyNetworkClearAuction() {
        if (this.networkAdUnitList.isEmpty()) {
            return;
        }
        Logger.d(this.tag, "notifyNetworkClearAuction");
        Iterator<NetworkAdUnit> it = this.networkAdUnitList.iterator();
        while (it.hasNext()) {
            try {
                it.next().clearAuction();
            } catch (Throwable unused) {
            }
        }
        this.networkAdUnitList.clear();
    }

    List<NetworkAdUnit> getNetworkAdUnitList() {
        return this.networkAdUnitList;
    }
}
