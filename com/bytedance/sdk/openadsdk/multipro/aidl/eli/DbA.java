package com.bytedance.sdk.openadsdk.multipro.aidl.eli;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.ironsource.C3355vf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private static volatile DbA DbA;
    private static final Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> eli = Collections.synchronizedMap(new HashMap());

    public static DbA eli() {
        if (DbA == null) {
            synchronized (DbA.class) {
                if (DbA == null) {
                    DbA = new DbA();
                }
            }
        }
        return DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerAppOpenAdListener(String str, IAppOpenAdInteractionListener iAppOpenAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IAppOpenAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iAppOpenAdInteractionListener);
        eli.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeAppOpenAdCallback(String str, String str2) throws RemoteException {
        eli(str, str2);
    }

    private synchronized void eli(String str, String str2) {
        RemoteCallbackList<IAppOpenAdInteractionListener> remoteCallbackList;
        try {
            Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> map = eli;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = map.remove(str);
                } else {
                    remoteCallbackList = map.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        try {
                            IAppOpenAdInteractionListener broadcastItem = remoteCallbackList.getBroadcastItem(i);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.onAdShow();
                                } else if (C3355vf.f.equals(str2)) {
                                    broadcastItem.onAdClicked();
                                } else if ("onAdSkip".equals(str2)) {
                                    broadcastItem.onAdSkip();
                                } else if ("onAdTimeOver".equals(str2)) {
                                    broadcastItem.onAdTimeOver();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            Xb.eli("MultiProcess", "appOpenAd2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            Xb.eli("MultiProcess", "appOpenAd1 method " + str2 + " throws Exception :", th2);
        }
    }
}
