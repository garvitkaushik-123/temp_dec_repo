package com.bytedance.sdk.openadsdk.multipro.aidl.eli;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Os extends eli {
    private static volatile Os DbA;
    private static final HashMap<String, RemoteCallbackList<ICommonPermissionListener>> eli = new HashMap<>();

    public static Os eli() {
        if (DbA == null) {
            synchronized (Os.class) {
                if (DbA == null) {
                    DbA = new Os();
                }
            }
        }
        return DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        if (iCommonPermissionListener == null) {
            return;
        }
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonPermissionListener);
        eli.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        RemoteCallbackList<ICommonPermissionListener> remove = eli.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            ICommonPermissionListener broadcastItem = remove.getBroadcastItem(i);
            if (broadcastItem != null) {
                if (str2 == null) {
                    broadcastItem.onGranted();
                } else {
                    broadcastItem.onDenied(str2);
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
