package io.adn.sdk.internal.data.api.local;

import com.ironsource.C3040d4;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.adn.sdk.internal.domain.model.metrics.ScreenSize;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SystemInfoApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020!H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\""}, d2 = {"Lio/adn/sdk/internal/data/api/local/SystemInfoApi;", "", BidTokenRepositoryKt.PPI, "", "getPpi", "()I", "osVersion", "", "getOsVersion", "()Ljava/lang/String;", N6.B, "getModel", "manufacturer", "getManufacturer", "isAirplaneModeEnabled", C3040d4.i.Y, "isBatterySaverEnabled", "isBatteryCharging", "isBluetoothEnabled", "isNightModeEnabled", "availableDiskSpaceInMB", "totalDiskSpaceInMB", "doNotDisturbStatus", "hasHeadset", "keyboardLanguages", "", "isSoundEnabled", "locale", "orientation", "screenSize", "Lio/adn/sdk/internal/domain/model/metrics/ScreenSize;", "isWalking", "bootTime", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface SystemInfoApi {
    int availableDiskSpaceInMB();

    int batteryLevel();

    long bootTime();

    int doNotDisturbStatus();

    String getManufacturer();

    String getModel();

    String getOsVersion();

    int getPpi();

    int hasHeadset();

    int isAirplaneModeEnabled();

    int isBatteryCharging();

    int isBatterySaverEnabled();

    int isBluetoothEnabled();

    int isNightModeEnabled();

    int isSoundEnabled();

    int isWalking();

    List<String> keyboardLanguages();

    String locale();

    String orientation();

    ScreenSize screenSize();

    int totalDiskSpaceInMB();
}
