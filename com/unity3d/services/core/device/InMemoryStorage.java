package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import kotlin.Metadata;

/* compiled from: InMemoryStorage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/device/InMemoryStorage;", "Lcom/unity3d/services/core/device/Storage;", "()V", "clearStorage", "", "readStorage", "writeStorage", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InMemoryStorage extends Storage {
    public InMemoryStorage() {
        super("", StorageManager.StorageType.MEMORY);
    }

    @Override // com.unity3d.services.core.device.Storage
    public synchronized boolean readStorage() {
        return true;
    }

    @Override // com.unity3d.services.core.device.Storage
    public synchronized boolean writeStorage() {
        return true;
    }

    @Override // com.unity3d.services.core.device.Storage
    public synchronized boolean clearStorage() {
        clearData();
        return true;
    }
}
