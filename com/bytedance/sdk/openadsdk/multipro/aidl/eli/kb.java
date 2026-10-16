package com.bytedance.sdk.openadsdk.multipro.aidl.eli;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class kb extends eli {
    private static volatile kb DbA;
    private static final Map<String, RemoteCallbackList<IRewardAdInteractionListener>> eli = Collections.synchronizedMap(new HashMap());

    public static kb eli() {
        if (DbA == null) {
            synchronized (kb.class) {
                if (DbA == null) {
                    DbA = new kb();
                }
            }
        }
        return DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        eli.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException {
        eli(str, str2, z, i, str3, i2, str4);
    }

    private synchronized void eli(String str, String str2, boolean z, int i, String str3, int i2, String str4) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList;
        try {
            Map<String, RemoteCallbackList<IRewardAdInteractionListener>> map = eli;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = map.remove(str);
                } else {
                    remoteCallbackList = map.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i3 = 0; i3 < beginBroadcast; i3++) {
                        try {
                            IRewardAdInteractionListener broadcastItem = remoteCallbackList.getBroadcastItem(i3);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.onAdClose();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    broadcastItem.onRewardVerify(z, i, str3, i2, str4);
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            Xb.eli("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            Xb.eli("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }
}
