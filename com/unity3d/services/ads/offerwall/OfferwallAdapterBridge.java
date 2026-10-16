package com.unity3d.services.ads.offerwall;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.unity3d.ads.core.domain.offerwall.OfferwallEventData;
import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: OfferwallAdapterBridge.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0002J\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/unity3d/services/ads/offerwall/OfferwallAdapterBridge;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "_offerwallEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/core/domain/offerwall/OfferwallEventData;", "offerwallEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getOfferwallEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "placementsMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getPlacement", "placementName", "getPlacementName", "placementObj", "getVersion", "isAdReady", "", "isConnected", "loadAd", "", "showAd", "tapjoyPlacementListener", "Ljava/lang/reflect/InvocationHandler;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OfferwallAdapterBridge {
    private final MutableSharedFlow<OfferwallEventData> _offerwallEventFlow;
    private final SharedFlow<OfferwallEventData> offerwallEventFlow;
    private final HashMap<String, Object> placementsMap;
    private final CoroutineScope scope;

    public OfferwallAdapterBridge(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        MutableSharedFlow<OfferwallEventData> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._offerwallEventFlow = MutableSharedFlow$default;
        this.offerwallEventFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
        this.placementsMap = new HashMap<>();
    }

    public final SharedFlow<OfferwallEventData> getOfferwallEventFlow() {
        return this.offerwallEventFlow;
    }

    public final String getVersion() {
        try {
            String str = (String) Class.forName("com.tapjoy.Tapjoy").getDeclaredMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
            return str == null ? "0.0.0" : str;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }

    public final boolean isConnected() {
        try {
            Boolean bool = (Boolean) Class.forName("com.tapjoy.Tapjoy").getDeclaredMethod("isConnected", new Class[0]).invoke(null, new Object[0]);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isAdReady(String placementName) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Object placement = getPlacement(placementName);
        Method declaredMethod = (placement == null || (cls = placement.getClass()) == null) ? null : cls.getDeclaredMethod("isContentReady", new Class[0]);
        Boolean bool = (Boolean) (declaredMethod != null ? declaredMethod.invoke(placement, new Object[0]) : null);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void loadAd(String placementName) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Object placement = getPlacement(placementName);
        this.placementsMap.put(placementName, placement);
        Method declaredMethod = (placement == null || (cls = placement.getClass()) == null) ? null : cls.getDeclaredMethod("requestContent", new Class[0]);
        if (declaredMethod != null) {
            declaredMethod.invoke(placement, new Object[0]);
        }
    }

    public final void showAd(String placementName) {
        Class<?> cls;
        Class<?> cls2;
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Object obj = this.placementsMap.get(placementName);
        Method method = null;
        Method declaredMethod = (obj == null || (cls2 = obj.getClass()) == null) ? null : cls2.getDeclaredMethod("isContentAvailable", new Class[0]);
        Boolean bool = (Boolean) (declaredMethod != null ? declaredMethod.invoke(obj, new Object[0]) : null);
        if (bool != null ? bool.booleanValue() : false) {
            if (obj != null && (cls = obj.getClass()) != null) {
                method = cls.getDeclaredMethod("showContent", new Class[0]);
            }
            if (method != null) {
                method.invoke(obj, new Object[0]);
            }
        } else {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new OfferwallAdapterBridge$showAd$1(this, placementName, null), 3, null);
        }
        this.placementsMap.remove(placementName);
    }

    private final InvocationHandler tapjoyPlacementListener() {
        return new InvocationHandler() { // from class: com.unity3d.services.ads.offerwall.OfferwallAdapterBridge$$ExternalSyntheticLambda0
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object tapjoyPlacementListener$lambda$0;
                tapjoyPlacementListener$lambda$0 = OfferwallAdapterBridge.tapjoyPlacementListener$lambda$0(OfferwallAdapterBridge.this, obj, method, objArr);
                return tapjoyPlacementListener$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Object tapjoyPlacementListener$lambda$0(OfferwallAdapterBridge this$0, Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String name = method.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1508301783:
                    if (name.equals("onContentReady")) {
                        Object obj2 = objArr[0];
                        Intrinsics.checkNotNullExpressionValue(obj2, "args[0]");
                        String placementName = this$0.getPlacementName(obj2);
                        DeviceLog.debug("Placement content ready: " + placementName);
                        BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new OfferwallAdapterBridge$tapjoyPlacementListener$1$3(this$0, placementName, null), 3, null);
                        break;
                    }
                    break;
                case -1482787952:
                    if (name.equals("onContentDismiss")) {
                        Object obj3 = objArr[0];
                        Intrinsics.checkNotNullExpressionValue(obj3, "args[0]");
                        String placementName2 = this$0.getPlacementName(obj3);
                        DeviceLog.debug("Placement content dismissed: " + placementName2);
                        BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new OfferwallAdapterBridge$tapjoyPlacementListener$1$5(this$0, placementName2, null), 3, null);
                        break;
                    }
                    break;
                case 89925559:
                    if (name.equals("onContentShow")) {
                        Object obj4 = objArr[0];
                        Intrinsics.checkNotNullExpressionValue(obj4, "args[0]");
                        String placementName3 = this$0.getPlacementName(obj4);
                        DeviceLog.debug("Placement content shown: " + placementName3);
                        BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new OfferwallAdapterBridge$tapjoyPlacementListener$1$4(this$0, placementName3, null), 3, null);
                        break;
                    }
                    break;
                case 1356881459:
                    if (name.equals("onRequestSuccess")) {
                        Object placementObj = objArr[0];
                        Intrinsics.checkNotNullExpressionValue(placementObj, "placementObj");
                        String placementName4 = this$0.getPlacementName(placementObj);
                        Boolean bool = (Boolean) placementObj.getClass().getDeclaredMethod("isContentAvailable", new Class[0]).invoke(placementObj, new Object[0]);
                        boolean booleanValue = bool != null ? bool.booleanValue() : false;
                        DeviceLog.debug("Placement request succeeded: " + placementName4 + " - isContentAvailable: " + booleanValue);
                        BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new OfferwallAdapterBridge$tapjoyPlacementListener$1$1(booleanValue, this$0, placementName4, null), 3, null);
                        break;
                    }
                    break;
                case 2137477050:
                    if (name.equals("onRequestFailure")) {
                        Object obj5 = objArr[0];
                        Intrinsics.checkNotNullExpressionValue(obj5, "args[0]");
                        String placementName5 = this$0.getPlacementName(obj5);
                        this$0.placementsMap.remove(placementName5 == null ? "" : placementName5);
                        Object obj6 = objArr[1];
                        DeviceLog.error("Placement request failed: " + placementName5 + " - errorCode: " + ((Integer) obj6.getClass().getField("code").get(obj6)) + ", errorMessage: " + ((String) obj6.getClass().getField(PglCryptUtils.KEY_MESSAGE).get(obj6)));
                        BuildersKt__Builders_commonKt.launch$default(this$0.scope, null, null, new OfferwallAdapterBridge$tapjoyPlacementListener$1$2(this$0, placementName5, null), 3, null);
                        break;
                    }
                    break;
            }
        }
        return null;
    }

    private final String getPlacementName(Object placementObj) {
        return (String) placementObj.getClass().getDeclaredMethod("getName", new Class[0]).invoke(placementObj, new Object[0]);
    }

    private final Object getPlacement(String placementName) {
        return Class.forName("com.tapjoy.Tapjoy").getDeclaredMethod("getPlacement", String.class, Class.forName("com.tapjoy.TJPlacementListener")).invoke(null, placementName, Proxy.newProxyInstance(Class.forName("com.tapjoy.TJPlacementListener").getClassLoader(), new Class[]{Class.forName("com.tapjoy.TJPlacementListener")}, tapjoyPlacementListener()));
    }
}
