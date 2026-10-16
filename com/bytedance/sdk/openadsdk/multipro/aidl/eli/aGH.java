package com.bytedance.sdk.openadsdk.multipro.aidl.eli;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class aGH extends eli {
    private static volatile aGH DbA;
    public static ConcurrentHashMap<String, RemoteCallbackList<IDislikeClosedListener>> eli = new ConcurrentHashMap<>();

    public static aGH eli() {
        if (DbA == null) {
            synchronized (aGH.class) {
                if (DbA == null) {
                    DbA = new aGH();
                }
            }
        }
        return DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerDisLikeClosedListener(String str, IDislikeClosedListener iDislikeClosedListener) throws RemoteException {
        RemoteCallbackList<IDislikeClosedListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iDislikeClosedListener);
        eli.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public void unregisterDisLikeClosedListener(String str) throws RemoteException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        eli.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeDisLikeClosedCallback(String str, String str2) throws RemoteException {
        eli(str, str2);
    }

    private synchronized void eli(String str, String str2) {
        RemoteCallbackList<IDislikeClosedListener> remoteCallbackList;
        try {
            ConcurrentHashMap<String, RemoteCallbackList<IDislikeClosedListener>> concurrentHashMap = eli;
            if (concurrentHashMap != null && (remoteCallbackList = concurrentHashMap.get(str)) != null) {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        IDislikeClosedListener broadcastItem = remoteCallbackList.getBroadcastItem(i);
                        if (broadcastItem != null && "onItemClickClosed".equals(str2)) {
                            broadcastItem.onItemClickClosed();
                        }
                    } catch (Throwable th) {
                        Xb.eli("MultiProcess", "dislike '" + str2 + "'  throws Exception :", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th2) {
            Xb.eli("MultiProcess", "dislike '" + str2 + "'  throws Exception :", th2);
        }
    }
}
