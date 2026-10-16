package io.adn.sdk.internal.data.repository;

import android.content.Context;
import android.os.PowerManager;
import io.adn.sdk.internal.domain.repository.DeviceMetricsRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceMetricsRepositoryImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\bJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/adn/sdk/internal/data/repository/DeviceMetricsRepositoryImpl;", "Lio/adn/sdk/internal/domain/repository/DeviceMetricsRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getCurrentThermalState", "", "()Ljava/lang/Integer;", "getCurrentThermalStateInternal", "getThermalStateFromPowerManager", "getPowerManager", "Landroid/os/PowerManager;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DeviceMetricsRepositoryImpl implements DeviceMetricsRepository {
    public static final int $stable = 8;
    private final Context context;

    public DeviceMetricsRepositoryImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // io.adn.sdk.internal.domain.repository.DeviceMetricsRepository
    public Integer getCurrentThermalState() {
        return getCurrentThermalStateInternal();
    }

    private final Integer getCurrentThermalStateInternal() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceMetricsRepositoryImpl deviceMetricsRepositoryImpl = this;
            Integer thermalStateFromPowerManager = getThermalStateFromPowerManager();
            m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(thermalStateFromPowerManager != null ? thermalStateFromPowerManager.intValue() : ThermalState.NORMAL.getValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        return (Integer) m10241constructorimpl;
    }

    private final Integer getThermalStateFromPowerManager() {
        Object m10241constructorimpl;
        boolean isPowerManagerApiAvailable;
        PowerManager powerManager;
        int value;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceMetricsRepositoryImpl deviceMetricsRepositoryImpl = this;
            isPowerManagerApiAvailable = DeviceMetricsRepositoryImplKt.isPowerManagerApiAvailable();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (!isPowerManagerApiAvailable || (powerManager = getPowerManager()) == null) {
            return null;
        }
        switch (powerManager.getCurrentThermalStatus()) {
            case 0:
                value = ThermalState.LOWEST.getValue();
                break;
            case 1:
                value = ThermalState.NORMAL.getValue();
                break;
            case 2:
                value = ThermalState.NORMAL.getValue();
                break;
            case 3:
                value = ThermalState.HIGH.getValue();
                break;
            case 4:
                value = ThermalState.HIGHEST.getValue();
                break;
            case 5:
                value = ThermalState.HIGHEST.getValue();
                break;
            case 6:
                value = ThermalState.HIGHEST.getValue();
                break;
            default:
                value = ThermalState.NONE.getValue();
                break;
        }
        m10241constructorimpl = Result.m10241constructorimpl(Integer.valueOf(value));
        return (Integer) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    private final PowerManager getPowerManager() {
        Object systemService = this.context.getSystemService("power");
        if (systemService instanceof PowerManager) {
            return (PowerManager) systemService;
        }
        return null;
    }
}
