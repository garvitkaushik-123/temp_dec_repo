package com.moloco.sdk.common_adapter_internal;

import com.moloco.sdk.Init;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.bidrequest.Geo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/moloco/sdk/Init$SDKInitResponse;", "", "adUnitId", "Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "a", "(Lcom/moloco/sdk/Init$SDKInitResponse;Ljava/lang/String;)Lcom/moloco/sdk/common_adapter_internal/AdapterSessionData;", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "DefaultGeo", "moloco-sdk_release"}, k = 2, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class AdapterAccessKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Geo f5362a = new Geo(null, null, null, null, null, null);

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final AdapterSessionData a(Init.SDKInitResponse sDKInitResponse, String str) {
        Geo geo;
        String str2;
        List<Init.SDKInitResponse.AdUnit> adUnitsList;
        Object obj;
        Object obj2;
        Init.SDKInitResponse.Geo geo2 = sDKInitResponse.getGeo();
        if (geo2 != null) {
            geo = new Geo(geo2.getCity(), geo2.getCountryIso3Code(), geo2.getCountryIso2Code(), geo2.getZipCode(), Float.valueOf(geo2.getLatitude()), Float.valueOf(geo2.getLongitude()));
        } else {
            geo = f5362a;
        }
        Geo geo3 = geo;
        String bidRequestEndpoint = Moloco.getBidRequestEndpoint();
        String appId = sDKInitResponse.getAppId();
        String publisherId = sDKInitResponse.getPublisherId();
        String platformId = sDKInitResponse.getPlatformId();
        List<Init.SDKInitResponse.AdUnit> adUnitsList2 = sDKInitResponse.getAdUnitsList();
        Float f = null;
        if (adUnitsList2 != null) {
            Iterator<T> it = adUnitsList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual(((Init.SDKInitResponse.AdUnit) obj2).getId(), str)) {
                    break;
                }
            }
            Init.SDKInitResponse.AdUnit adUnit = (Init.SDKInitResponse.AdUnit) obj2;
            if (adUnit != null) {
                str2 = adUnit.getName();
                adUnitsList = sDKInitResponse.getAdUnitsList();
                if (adUnitsList != null) {
                    Iterator<T> it2 = adUnitsList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (Intrinsics.areEqual(((Init.SDKInitResponse.AdUnit) obj).getId(), str)) {
                            break;
                        }
                    }
                    Init.SDKInitResponse.AdUnit adUnit2 = (Init.SDKInitResponse.AdUnit) obj;
                    if (adUnit2 != null) {
                        f = Float.valueOf(adUnit2.getBidFloor());
                    }
                }
                return new AdapterSessionData(geo3, bidRequestEndpoint, appId, publisherId, platformId, str2, f);
            }
        }
        str2 = null;
        adUnitsList = sDKInitResponse.getAdUnitsList();
        if (adUnitsList != null) {
        }
        return new AdapterSessionData(geo3, bidRequestEndpoint, appId, publisherId, platformId, str2, f);
    }
}
