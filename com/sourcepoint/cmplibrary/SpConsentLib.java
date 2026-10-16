package com.sourcepoint.cmplibrary;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.consent.CustomConsentClient;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.PMTab;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.util.SpBackPressOttDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: SpConsentLib.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJH\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00030\u000eH&J?\u0010\u0010\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJH\u0010\u0010\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00030\u000eH&J\b\u0010\u0011\u001a\u00020\u0003H&J \u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H&J\u001a\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0014\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006H&J1\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0002\u0010\u001fJ\u0014\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H&J \u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J \u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#H&J(\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J(\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0014H&J0\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&¨\u0006."}, d2 = {"Lcom/sourcepoint/cmplibrary/SpConsentLib;", "", "customConsentGDPR", "", "vendors", "", "", "categories", "legIntCategories", "successCallback", "Lcom/sourcepoint/cmplibrary/consent/CustomConsentClient;", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Lcom/sourcepoint/cmplibrary/consent/CustomConsentClient;)V", "", "success", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "deleteCustomConsentTo", "dispose", "handleOnBackPress", "isMessageDismissible", "", "onHomePage", "Lkotlin/Function0;", "ottDelegate", "Lcom/sourcepoint/cmplibrary/util/SpBackPressOttDelegate;", "loadMessage", "cmpViewId", "", "authId", "pubData", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Integer;)V", "loadPrivacyManager", "pmId", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "pmTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "useGroupPmIfAvailable", "rejectAll", "removeView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "showView", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SpConsentLib {
    void customConsentGDPR(List<String> vendors, List<String> categories, List<String> legIntCategories, Function1<? super SPConsents, Unit> success);

    void customConsentGDPR(String[] vendors, String[] categories, String[] legIntCategories, CustomConsentClient successCallback);

    void deleteCustomConsentTo(List<String> vendors, List<String> categories, List<String> legIntCategories, Function1<? super SPConsents, Unit> success);

    void deleteCustomConsentTo(String[] vendors, String[] categories, String[] legIntCategories, CustomConsentClient successCallback);

    void dispose();

    void handleOnBackPress(boolean isMessageDismissible, SpBackPressOttDelegate ottDelegate);

    void handleOnBackPress(boolean isMessageDismissible, Function0<Unit> onHomePage);

    void loadMessage();

    void loadMessage(int cmpViewId);

    void loadMessage(String authId);

    void loadMessage(String authId, JSONObject pubData, Integer cmpViewId);

    void loadMessage(JSONObject pubData);

    void loadPrivacyManager(String pmId, CampaignType campaignType);

    void loadPrivacyManager(String pmId, CampaignType campaignType, MessageType messageType);

    void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType);

    void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType, MessageType messageType);

    void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType, boolean useGroupPmIfAvailable);

    void loadPrivacyManager(String pmId, PMTab pmTab, CampaignType campaignType, boolean useGroupPmIfAvailable, MessageType messageType);

    void rejectAll(CampaignType campaignType);

    void removeView(View view);

    void showView(View view);

    /* compiled from: SpConsentLib.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void loadMessage$default(SpConsentLib spConsentLib, String str, JSONObject jSONObject, Integer num, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMessage");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                jSONObject = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            spConsentLib.loadMessage(str, jSONObject, num);
        }

        public static /* synthetic */ void loadMessage$default(SpConsentLib spConsentLib, JSONObject jSONObject, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMessage");
            }
            if ((i & 1) != 0) {
                jSONObject = null;
            }
            spConsentLib.loadMessage(jSONObject);
        }

        public static /* synthetic */ void loadMessage$default(SpConsentLib spConsentLib, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMessage");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            spConsentLib.loadMessage(str);
        }

        public static /* synthetic */ void handleOnBackPress$default(SpConsentLib spConsentLib, boolean z, SpBackPressOttDelegate spBackPressOttDelegate, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleOnBackPress");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            spConsentLib.handleOnBackPress(z, spBackPressOttDelegate);
        }

        public static /* synthetic */ void handleOnBackPress$default(SpConsentLib spConsentLib, boolean z, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleOnBackPress");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            spConsentLib.handleOnBackPress(z, (Function0<Unit>) function0);
        }
    }
}
