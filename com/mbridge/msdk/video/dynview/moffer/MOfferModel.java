package com.mbridge.msdk.video.dynview.moffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MOfferModel implements NoProGuard {
    private static final String MOF_LOAD_RESULT_CODE_OFFER_LESS_THAN_5 = "12930014";
    private static final String MOF_LOAD_RESULT_FAILED = "2";
    private static final String MOF_LOAD_RESULT_SUCCESS = "1";
    private static final String TAG = "MOfferModel";
    private int admf;
    private int admftm;
    private List<Integer> cacheImpressionReportList;
    private List<Integer> cacheOnlyImpressionReportList;
    private boolean isShowMoreOffer;
    private CampaignUnit mCampaignUnit;
    private Context mContext;
    private LinearLayout mLinearLayout;
    private CampaignEx mMainOfferCampaignEx;
    private com.mbridge.msdk.video.dynview.listener.g mMoreOfferLayoutListener;
    private com.mbridge.msdk.video.module.listener.a mNotifyListener;
    private ObservableScrollView mObservableScrollView;
    private com.mbridge.msdk.foundation.same.net.wrapper.e mParam;
    private String mRid;
    private String mUnitId;
    private MBridgeRelativeLayout viewMofferLayout;
    private final String VALUE_MOF_TYPE = "1";
    private final String VALUE_H5_TYPE = "1";
    private final String VALUE_MOF = "1";
    private final String VALUE_COUNTRY_CODE = "CN";
    private final String VALUE_MOF_VER = "1";
    private final String VALUE_OFF_SET = "0";
    private final String VALUE_CATEGORY = "0";
    private final String VALUE_ONLY_IMPRESSION = "1";
    private final String VALUE_PING_MODE = "1";
    private final String VALUE_HTTP_REQ = "2";
    private final String VALUE_AD_NUM = "20";
    private final String VALUE_TNUM = "20";
    private final String VALUE_API_VERSION = "2.3";
    private final String VALUE_DEFAULT_VIDEO_TEMP_ID = "404";
    private final String K = CampaignEx.JSON_KEY_AD_K;
    private final String MOF_TEST_UID = "mof_testuid";
    private final String MCC = "mcc";
    private final String MOF_UID = "mof_uid";
    private final String MNC = "mnc";
    private final String RV_TID = "rv_tid";
    private final String EC_ID = "ecid";
    private final String TP_LGP = "tplgp";
    private final String V_FMD5 = "v_fmd5";
    private final String I_FMD5 = "i_fmd5";
    private final String APP_ID = MBridgeConstans.APP_ID;
    private final String SIGN = "sign";
    private final String PARENT_UNIT = "parent_unit";
    private final String E = "e";
    private final String MOF_TYPE = "mof_type";
    private final String H5_TYPE = "h5_type";
    private final String MOF = "mof";
    private final String COUNTRY_CODE = "country_code";
    private final String MOF_VER = "mof_ver";
    private final String CRT_CID = "crt_cid";
    private final String CRT_RID = "crt_rid";
    private final String H5_T = "h5_t";
    private final String MOF_T = "mof_t";
    private final String MOF_DATA = "mof_data";
    private final String OFFER_ID = "offer_id";
    private final String OFF_SET = "offset";
    private final String CATEGORY = "category";
    private final String ONLY_IMPRESSION = "only_impression";
    private final String PING_MODE = "ping_mode";
    private final String HTTP_REQ = "http_req";
    private final String AD_NUM = "ad_num";
    private final String TNUM = "tnum";
    private final String API_VERSION = "api_version";
    private final String MOF_DOMAIN = "mof_domain";
    private final String PARENT_ID = "parent_id";
    private final String MOF_PARENT_ID = "mof_parent_id";
    private final String MOF_CALLBACK_DATE = "mcd";
    private final String UC_PARENT_UNIT = "uc_parent_unit";
    private final String DEFAULT_PATH_V3 = "/openapi/ad/v3";
    private final String PARENT_EXCHANGE = "parent_exchange";
    private final String PARENT_AD_TYPE = "parent_ad_type";
    private final String PARENT_TEMPLATE_ID = "parent_template_id";
    private final String ONE_ID = "oneId";
    private final String DY_VIEW = "dy_view";
    private final String MORE_OFFER_DEFAULT_UNIT_ID = "117361";
    private final String MORE_OFFER_DEFAULT_APP_ID = "92762";
    private final String MORE_OFFER_DEFAULT_APP_KEY = "936dcbdd57fe235fd7cf61c2e93da3c4";
    private final String MORE_OFFER_LOAD_SUCCESS = "more offer load success";
    private final String MORE_OFFER_LOAD_FAILED = "more offer load failed";
    private final String MORE_OFFER_SHOW = "more offer show";
    private final String MORE_OFFER_CLICK = "more offer click";
    private final String MORE_OFFER_SHOW_FAILED = "more offer show fail";
    private final String UNIT_ID = MBridgeConstans.PROPERTIES_UNIT_ID;
    private final String R_ID = "r_id";
    private final int DO_ACTION_IMPRESSION = 0;
    private final int DO_ACTION_ONLY_IMPRESSION = 1;
    private volatile boolean hasReportMoreOfferLoad = false;
    private volatile boolean hasReportMoreOfferShow = false;
    private int bitmapSuccessCount = 0;
    private List<Integer> mImpressionId = new ArrayList();
    private int mControlShowSize = 0;
    private boolean isOnlyImpShow = false;
    private boolean mHasReportMofScenes = false;
    private boolean mIsRetry = false;
    private int mFromType = 0;
    private OnItemExposeListener onItemExposeListener = new a();
    private com.mbridge.msdk.video.dynview.moffer.c mMoreOfferShowCallBack = new b();

    class a implements OnItemExposeListener {
        a() {
        }

        @Override // com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener
        public void onItemViewFirstVisible() {
            if (MOfferModel.this.viewMofferLayout == null || !MOfferModel.this.isOnlyImpShow) {
                return;
            }
            if (MOfferModel.this.viewMofferLayout.getVisibility() == 0) {
                try {
                    com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mCampaignUnit, 0, 1, "117361");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (MOfferModel.this.cacheOnlyImpressionReportList == null) {
                MOfferModel.this.cacheOnlyImpressionReportList = new ArrayList();
            }
            MOfferModel.this.cacheOnlyImpressionReportList.add(0);
        }

        @Override // com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener
        public void onItemViewVisible(boolean z, int i) {
            if (MOfferModel.this.viewMofferLayout == null) {
                return;
            }
            if (MOfferModel.this.viewMofferLayout.getVisibility() != 0) {
                if (MOfferModel.this.cacheImpressionReportList == null) {
                    MOfferModel.this.cacheImpressionReportList = new ArrayList();
                }
                if (MOfferModel.this.cacheImpressionReportList.contains(Integer.valueOf(i))) {
                    return;
                }
                MOfferModel.this.cacheImpressionReportList.add(Integer.valueOf(i));
                return;
            }
            if (!MOfferModel.this.hasReportMoreOfferShow) {
                com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                MOfferModel.this.hasReportMoreOfferShow = true;
            }
            try {
                com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mCampaignUnit, i, 0, "117361");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class b implements com.mbridge.msdk.video.dynview.moffer.c {
        b() {
        }

        @Override // com.mbridge.msdk.video.dynview.moffer.c
        public void a(List<View> list) {
            TextView textView;
            if (MOfferModel.this.viewMofferLayout == null || (textView = (TextView) MOfferModel.this.viewMofferLayout.findViewById(MOfferModel.this.findID("mbridge_reward_end_card_like_tv"))) == null) {
                return;
            }
            textView.setVisibility(0);
        }
    }

    class d implements com.mbridge.msdk.video.dynview.moffer.b {
        d() {
        }

        @Override // com.mbridge.msdk.video.dynview.moffer.b
        public void a() {
            try {
                if (MOfferModel.this.cacheImpressionReportList != null) {
                    for (int i = 0; i < MOfferModel.this.cacheImpressionReportList.size(); i++) {
                        if (!MOfferModel.this.hasReportMoreOfferShow) {
                            com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                            MOfferModel.this.hasReportMoreOfferShow = true;
                        }
                        com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheImpressionReportList.get(i)).intValue(), 0, "117361");
                    }
                }
                if (!MOfferModel.this.isOnlyImpShow && MOfferModel.this.cacheOnlyImpressionReportList != null) {
                    for (int i2 = 0; i2 < MOfferModel.this.cacheOnlyImpressionReportList.size(); i2++) {
                        com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheOnlyImpressionReportList.get(i2)).intValue(), 1, "117361");
                    }
                }
                MOfferModel.this.release();
            } catch (Exception e) {
                p0.b(MOfferModel.TAG, e.getMessage());
            }
        }
    }

    class e implements com.mbridge.msdk.video.dynview.moffer.d {
        e() {
        }

        @Override // com.mbridge.msdk.video.dynview.moffer.d
        public void a() {
            if (MOfferModel.this.viewMofferLayout != null && MOfferModel.this.viewMofferLayout.getVisibility() != 0) {
                com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show fail", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
            }
            MOfferModel.this.release();
        }
    }

    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            MOfferModel.this.checkViewVisiableState();
            return false;
        }
    }

    class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5040a;
        final /* synthetic */ View b;

        g(int i, View view) {
            this.f5040a = i;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CampaignEx campaignEx;
            try {
                if (MOfferModel.this.mCampaignUnit == null || MOfferModel.this.mCampaignUnit.ads == null || MOfferModel.this.mCampaignUnit.ads.size() <= 0 || (campaignEx = MOfferModel.this.mCampaignUnit.ads.get(this.f5040a)) == null) {
                    return;
                }
                if (MOfferModel.this.mNotifyListener != null) {
                    MOfferModel mOfferModel = MOfferModel.this;
                    mOfferModel.callBackClick(mOfferModel.mNotifyListener);
                }
                campaignEx.setLocalRequestId(MOfferModel.this.mCampaignUnit.getLocalRequestId());
                com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), "more offer click", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                com.mbridge.msdk.video.dynview.request.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, MOfferModel.this.mUnitId, this.b);
            } catch (Exception e) {
                p0.b(MOfferModel.TAG, e.getMessage());
            }
        }
    }

    class h implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoundImageView f5041a;

        h(RoundImageView roundImageView) {
            this.f5041a = roundImageView;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            try {
                if (this.f5041a != null && bitmap != null && !bitmap.isRecycled()) {
                    this.f5041a.setBorderRadius(13);
                    this.f5041a.setImageBitmap(bitmap);
                }
                MOfferModel.access$2208(MOfferModel.this);
                if (MOfferModel.this.isShowMoreOffer || MOfferModel.this.bitmapSuccessCount < 5 || MOfferModel.this.mMoreOfferShowCallBack == null) {
                    return;
                }
                MOfferModel.this.isShowMoreOffer = true;
                MOfferModel.this.mMoreOfferShowCallBack.a(null);
            } catch (Exception e) {
                p0.b(MOfferModel.TAG, e.getMessage());
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MOfferModel.this.mObservableScrollView != null) {
                if (MOfferModel.this.mObservableScrollView.getVisibility() == 0) {
                    MOfferModel.this.mObservableScrollView.setVisibility(8);
                } else {
                    MOfferModel.this.mObservableScrollView.setVisibility(0);
                }
            }
            try {
                new com.mbridge.msdk.video.dynview.ui.b().c(MOfferModel.this.mLinearLayout, 300L);
            } catch (Exception e) {
                p0.b(MOfferModel.TAG, e.getMessage());
            }
        }
    }

    static /* synthetic */ int access$2208(MOfferModel mOfferModel) {
        int i2 = mOfferModel.bitmapSuccessCount;
        mOfferModel.bitmapSuccessCount = i2 + 1;
        return i2;
    }

    private void addLikeTextView() {
        TextView textView;
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null || (textView = (TextView) mBridgeRelativeLayout.findViewById(findID("mbridge_reward_end_card_like_tv"))) == null) {
            return;
        }
        textView.setTextColor(Color.parseColor("#FF000000"));
        textView.setTextSize(10.0f);
        if (l0.p(com.mbridge.msdk.foundation.controller.c.m().d()).contains("zh")) {
            textView.setEms(1);
            textView.getLayoutParams().width = u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 30.0f);
            textView.setText("猜你喜欢");
        } else {
            textView.setText("Just\nfor\nYou");
        }
        textView.setOnClickListener(new i());
    }

    private View buildItemView(int i2) {
        com.mbridge.msdk.foundation.same.report.metrics.c a2;
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(h0.a(context, "mbridge_reward_end_card_more_offer_item", "layout"), (ViewGroup) null, false);
        int a3 = h0.a(this.mContext, "mbridge_reward_end_card_item_iv", "id");
        if (inflate == null) {
            return null;
        }
        setOfferData(this.mCampaignUnit.getAds(), i2, (RoundImageView) inflate.findViewById(a3), (TextView) inflate.findViewById(h0.a(this.mContext, "mbridge_reward_end_card_item_title_tv", "id")));
        CampaignEx campaignEx = this.mCampaignUnit.getAds().get(0);
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("adtp", 295);
        if (TextUtils.isEmpty(campaignEx.getBidToken())) {
            eVar.a(CampaignEx.JSON_KEY_HB, 0);
        } else {
            eVar.a(CampaignEx.JSON_KEY_HB, 1);
        }
        if (TextUtils.isEmpty(this.mCampaignUnit.getLocalRequestId())) {
            a2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(false, campaignEx.getBidToken(), eVar, campaignEx, this.mUnitId);
        } else {
            campaignEx.setLocalRequestId(this.mCampaignUnit.getLocalRequestId());
            a2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(this.mCampaignUnit.getLocalRequestId());
        }
        a1.a(inflate, a2.o(), campaignEx.getLocalAllowTrackClick());
        this.mCampaignUnit.setLocalRequestId(a2.o());
        inflate.setOnClickListener(new g(i2, inflate));
        return inflate;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:5|(1:7)|8|(2:9|10)|(20:14|15|(1:17)(1:52)|18|(1:20)(1:51)|21|(1:23)(1:50)|24|(2:26|(1:28))(1:49)|29|(1:31)(1:48)|32|(1:34)(1:47)|35|36|37|38|(1:40)(1:43)|41|42)|54|15|(0)(0)|18|(0)(0)|21|(0)(0)|24|(0)(0)|29|(0)(0)|32|(0)(0)|35|36|37|38|(0)(0)|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01f1, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void buildRequestParams(CampaignEx campaignEx) {
        String str;
        String a2;
        String str2;
        String str3;
        String str4;
        int adType;
        String str5;
        if (campaignEx == null) {
            return;
        }
        this.mParam = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        String campaignUnitId = campaignEx.getCampaignUnitId();
        String id = campaignEx.getId();
        String requestIdNotice = campaignEx.getRequestIdNotice();
        campaignEx.getRequestId();
        String a3 = b1.a(campaignEx.getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(a3)) {
            a3 = b1.a(campaignEx.getendcard_url(), "mof_uid");
        }
        String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
        if (!TextUtils.isEmpty(b2) && com.mbridge.msdk.setting.h.b().d(b2) != null) {
            str = com.mbridge.msdk.setting.h.b().d(b2).k();
            String a4 = b1.a(campaignEx.getendcard_url(), "mcc");
            String a5 = b1.a(campaignEx.getendcard_url(), "mnc");
            String a6 = b1.a(campaignEx.getendcard_url(), "rv_tid");
            a2 = !campaignEx.getendcard_url().contains("ecid") ? b1.a(campaignEx.getendcard_url(), "ecid") : String.valueOf(campaignEx.getEcTemplateId());
            str2 = a3;
            String a7 = b1.a(campaignEx.getendcard_url(), "tplgp");
            String str6 = str;
            String a8 = b1.a(campaignEx.getendcard_url(), "v_fmd5");
            String a9 = b1.a(campaignEx.getendcard_url(), "i_fmd5");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().b());
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "sign", SameMD5.getMD5(b2 + com.mbridge.msdk.foundation.controller.c.m().c()));
            com.mbridge.msdk.foundation.same.net.wrapper.e eVar = this.mParam;
            String str7 = "";
            if (TextUtils.isEmpty(requestIdNotice)) {
                str3 = "sign";
                str4 = requestIdNotice;
            } else {
                str3 = "sign";
                str4 = "";
            }
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "r_id", str4);
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "e", Arrays.toString(new String[]{id}));
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_type", "1");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "h5_type", "1");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof", "1");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "country_code", !TextUtils.isEmpty(str6) ? "CN" : str6);
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_ver", "1");
            this.mParam.a("parent_exchange", "");
            adType = campaignEx.getAdType();
            if (adType != 94) {
                str7 = "rewarded_video";
            } else if (adType == 287) {
                str7 = "interstitial_video";
            }
            this.mParam.a("parent_ad_type", str7);
            this.mParam.a("oneId", campaignEx.getReq_ext_data());
            if (TextUtils.isEmpty(a2)) {
                this.mParam.a("parent_template_id", a2);
            } else {
                this.mParam.a("parent_template_id", "404");
            }
            if (TextUtils.isEmpty(str2)) {
                com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "parent_unit", campaignUnitId);
            } else {
                com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "uc_parent_unit", campaignUnitId);
            }
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mnc", a5);
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mcc", a4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("crt_cid", id);
            jSONObject.put("crt_rid", requestIdNotice);
            jSONObject.put("rv_tid", a6);
            jSONObject.put("ecid", a2);
            jSONObject.put("tplgp", a7);
            jSONObject.put("v_fmd5", a8);
            jSONObject.put("i_fmd5", a9);
            jSONObject.put("h5_t", 1);
            jSONObject.put("mof_t", 1);
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_data", jSONObject.toString());
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "offer_id", id);
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "offset", "0");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "category", "0");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "only_impression", "1");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "ping_mode", "1");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "http_req", "2");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "ad_num", "20");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "tnum", "20");
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "api_version", "2.3");
            if (TextUtils.isEmpty(str2)) {
                str5 = str2;
            } else {
                com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, MBridgeConstans.APP_ID, "92762");
                com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, str3, SameMD5.getMD5("92762936dcbdd57fe235fd7cf61c2e93da3c4"));
                str5 = "117361";
            }
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, MBridgeConstans.PROPERTIES_UNIT_ID, str5);
            com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "dy_view", "1");
        }
        str = "CN";
        String a42 = b1.a(campaignEx.getendcard_url(), "mcc");
        String a52 = b1.a(campaignEx.getendcard_url(), "mnc");
        String a62 = b1.a(campaignEx.getendcard_url(), "rv_tid");
        if (!campaignEx.getendcard_url().contains("ecid")) {
        }
        str2 = a3;
        String a72 = b1.a(campaignEx.getendcard_url(), "tplgp");
        String str62 = str;
        String a82 = b1.a(campaignEx.getendcard_url(), "v_fmd5");
        String a92 = b1.a(campaignEx.getendcard_url(), "i_fmd5");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().b());
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "sign", SameMD5.getMD5(b2 + com.mbridge.msdk.foundation.controller.c.m().c()));
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar2 = this.mParam;
        String str72 = "";
        if (TextUtils.isEmpty(requestIdNotice)) {
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar2, "r_id", str4);
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "e", Arrays.toString(new String[]{id}));
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_type", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "h5_type", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "country_code", !TextUtils.isEmpty(str62) ? "CN" : str62);
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_ver", "1");
        this.mParam.a("parent_exchange", "");
        adType = campaignEx.getAdType();
        if (adType != 94) {
        }
        this.mParam.a("parent_ad_type", str72);
        this.mParam.a("oneId", campaignEx.getReq_ext_data());
        if (TextUtils.isEmpty(a2)) {
        }
        if (TextUtils.isEmpty(str2)) {
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mnc", a52);
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mcc", a42);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("crt_cid", id);
        jSONObject2.put("crt_rid", requestIdNotice);
        jSONObject2.put("rv_tid", a62);
        jSONObject2.put("ecid", a2);
        jSONObject2.put("tplgp", a72);
        jSONObject2.put("v_fmd5", a82);
        jSONObject2.put("i_fmd5", a92);
        jSONObject2.put("h5_t", 1);
        jSONObject2.put("mof_t", 1);
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_data", jSONObject2.toString());
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "offer_id", id);
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "offset", "0");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "category", "0");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "http_req", "2");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "ad_num", "20");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "tnum", "20");
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "api_version", "2.3");
        if (TextUtils.isEmpty(str2)) {
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, MBridgeConstans.PROPERTIES_UNIT_ID, str5);
        com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "dy_view", "1");
    }

    private void buildScrollViewGroup() {
        if (this.mContext == null || this.viewMofferLayout == null || this.mMainOfferCampaignEx == null) {
            return;
        }
        this.mLinearLayout = new LinearLayout(this.mContext);
        this.mLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.mLinearLayout.setOrientation(0);
        this.mLinearLayout.setGravity(17);
        for (int i2 = 0; i2 < this.mCampaignUnit.ads.size(); i2++) {
            View buildItemView = buildItemView(i2);
            if (buildItemView != null) {
                this.mLinearLayout.addView(buildItemView);
            }
        }
        this.mObservableScrollView.addView(this.mLinearLayout);
        this.mObservableScrollView.setOnTouchListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackClick(com.mbridge.msdk.video.module.listener.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(128, "");
    }

    private void createMoreOfferList() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null) {
            return;
        }
        this.mObservableScrollView = (ObservableScrollView) mBridgeRelativeLayout.findViewById(findID("mbridge_moreoffer_hls"));
        buildScrollViewGroup();
        addLikeTextView();
        showView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMoreOfferView() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit == null || this.mContext == null || campaignUnit.getAds() == null || this.mCampaignUnit.getAds().size() == 0) {
            return;
        }
        setMoreOfferLayoutCallBack();
        createMoreOfferList();
    }

    private void doAdmfContorl() {
        try {
            CampaignEx campaignEx = this.mMainOfferCampaignEx;
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getMoreOfferJsonData())) {
                JSONObject jSONObject = new JSONObject(this.mMainOfferCampaignEx.getMoreOfferJsonData());
                int i2 = this.mFromType;
                JSONObject jSONObject2 = i2 != 1 ? i2 != 2 ? null : jSONObject.getJSONObject(CampaignEx.ENDCARD_URL) : jSONObject.getJSONObject("template_url");
                if (jSONObject2 == null) {
                    return;
                }
                if (jSONObject2.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                    this.admftm = jSONObject2.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                }
                if (jSONObject2.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                    this.admf = jSONObject2.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                }
            }
        } catch (Exception e2) {
            p0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doControllableImpOnRequest() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit == null) {
            return;
        }
        try {
            com.mbridge.msdk.video.dynview.request.a.a(campaignUnit, 0, 1, "117361");
            this.isOnlyImpShow = true;
            if (this.mCampaignUnit.getAds() == null) {
                return;
            }
            int size = this.mCampaignUnit.getAds().size();
            if (this.admf >= size) {
                this.admf = size;
            }
            if (this.mImpressionId == null) {
                this.mImpressionId = new ArrayList();
            }
            for (int i2 = 0; i2 < this.admf; i2++) {
                if (!this.mImpressionId.contains(Integer.valueOf(i2))) {
                    com.mbridge.msdk.video.dynview.request.a.a(this.mCampaignUnit, i2, 0, "117361");
                    this.mImpressionId.add(Integer.valueOf(i2));
                }
            }
        } catch (Exception e2) {
            p0.b(TAG, e2.getMessage());
        }
    }

    private void doControllableImpOnShow(int i2) {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return;
        }
        try {
            int size = this.mCampaignUnit.getAds().size();
            if (this.mControlShowSize == 0) {
                this.mControlShowSize = this.admf + i2;
            }
            if (this.mControlShowSize >= size) {
                this.mControlShowSize = size;
            }
            while (i2 < this.mControlShowSize) {
                if (!this.mImpressionId.contains(Integer.valueOf(i2))) {
                    com.mbridge.msdk.video.dynview.request.a.a(this.mCampaignUnit, i2, 0, "117361");
                    this.mImpressionId.add(Integer.valueOf(i2));
                }
                i2++;
            }
        } catch (Exception e2) {
            p0.b(TAG, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findID(String str) {
        return h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "id");
    }

    private void initData() {
        CampaignEx campaignEx = this.mMainOfferCampaignEx;
        if (campaignEx == null || this.mContext == null) {
            return;
        }
        buildRequestParams(campaignEx);
        if (this.mParam == null) {
            return;
        }
        com.mbridge.msdk.video.dynview.request.b bVar = new com.mbridge.msdk.video.dynview.request.b(this.mContext);
        c cVar = new c();
        String str = com.mbridge.msdk.foundation.same.net.utils.d.h().Z;
        if (!TextUtils.isEmpty(this.mMainOfferCampaignEx.getReq_ext_data())) {
            try {
                JSONObject jSONObject = new JSONObject(this.mMainOfferCampaignEx.getReq_ext_data());
                String optString = jSONObject.optString("mof_domain");
                if (!TextUtils.isEmpty(optString)) {
                    str = optString + "/openapi/ad/v3";
                }
                String optString2 = jSONObject.optString("parent_id");
                if (!TextUtils.isEmpty(optString2)) {
                    com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mof_parent_id", optString2);
                }
                String optString3 = jSONObject.optString("oneId");
                if (!TextUtils.isEmpty(optString3)) {
                    com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "oneId", optString3);
                }
                String optString4 = jSONObject.optString("mcd");
                if (!TextUtils.isEmpty(optString4)) {
                    com.mbridge.msdk.foundation.same.net.utils.b.a(this.mParam, "mcd", optString4);
                }
                cVar.setUnitId(this.mMainOfferCampaignEx.getCampaignUnitId());
            } catch (Exception e2) {
                p0.b(TAG, e2.getMessage());
                str = com.mbridge.msdk.foundation.same.net.utils.d.h().Z;
            }
        }
        String str2 = str;
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        if (this.mIsRetry) {
            eVar.a("retry", "1");
        }
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mof_initiate", this.mMainOfferCampaignEx, eVar);
        bVar.getLoadOrSetting(1, str2, this.mParam, cVar, true, "more_offer", 30000L);
        doAdmfContorl();
    }

    private void initView() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        this.viewMofferLayout = (MBridgeRelativeLayout) LayoutInflater.from(this.mContext).inflate(h0.a(context, "mbridge_reward_more_offer_view", "layout"), (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        List<Integer> list = this.cacheImpressionReportList;
        if (list != null) {
            list.clear();
            this.cacheImpressionReportList = null;
        }
        List<Integer> list2 = this.cacheOnlyImpressionReportList;
        if (list2 != null) {
            list2.clear();
            this.cacheOnlyImpressionReportList = null;
        }
    }

    private void setCallbackForLogicVisibleView(View view, int i2) {
        if (view == null) {
            return;
        }
        try {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z = rect.width() > view.getMeasuredWidth() / 5;
            if (!globalVisibleRect || !z) {
                if (this.admf != 0) {
                    doControllableImpOnShow(i2);
                    return;
                }
                return;
            }
            List<Integer> list = this.mImpressionId;
            if (list != null && this.onItemExposeListener != null && !list.contains(Integer.valueOf(i2))) {
                this.mImpressionId.add(Integer.valueOf(i2));
                this.onItemExposeListener.onItemViewVisible(true, i2);
            }
        } catch (Exception e2) {
            p0.b(TAG, e2.getMessage());
        }
    }

    private void setMoreOfferLayoutCallBack() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null) {
            return;
        }
        mBridgeRelativeLayout.setMoreOfferCacheReportCallBack(new d());
        this.viewMofferLayout.setMoreOfferShowFailedCallBack(new e());
    }

    private void setOfferData(List<CampaignEx> list, int i2, RoundImageView roundImageView, TextView textView) {
        CampaignEx campaignEx;
        if (roundImageView == null || textView == null || list == null || this.mContext == null || this.mMainOfferCampaignEx == null || list.size() <= 0 || (campaignEx = list.get(i2)) == null) {
            return;
        }
        roundImageView.setImageDrawable(null);
        com.mbridge.msdk.foundation.same.image.b.a(this.mContext).a(campaignEx.getIconUrl(), new h(roundImageView));
        if (TextUtils.isEmpty(campaignEx.getAppName())) {
            return;
        }
        String a2 = b1.a(this.mMainOfferCampaignEx.getendcard_url(), "mof_textmod");
        if (TextUtils.isEmpty(a2) || !a2.equals("1")) {
            textView.setVisibility(8);
        } else {
            textView.setText(campaignEx.getAppName());
        }
    }

    public void buildMofferAd(CampaignEx campaignEx) {
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        this.mContext = d2;
        if (d2 == null) {
            return;
        }
        this.mMainOfferCampaignEx = campaignEx;
        initView();
        initData();
    }

    public void checkViewVisiableState() {
        if (this.mLinearLayout == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mLinearLayout.getChildCount(); i2++) {
            try {
                setCallbackForLogicVisibleView(this.mLinearLayout.getChildAt(i2), i2);
            } catch (Exception e2) {
                p0.b(TAG, e2.getMessage());
                return;
            }
        }
    }

    public long getECParentTemplateCode() {
        try {
            com.mbridge.msdk.foundation.same.net.wrapper.e eVar = this.mParam;
            String str = eVar != null ? eVar.a().get("parent_template_id") : "";
            if (TextUtils.isEmpty(str)) {
                return 404L;
            }
            return Long.parseLong(str);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return 404L;
        }
    }

    public CampaignEx getmMainOfferCampaignEx() {
        return this.mMainOfferCampaignEx;
    }

    public void mofDestroy() {
        if (this.mMoreOfferLayoutListener != null) {
            this.mMoreOfferLayoutListener = null;
        }
        if (this.onItemExposeListener != null) {
            this.onItemExposeListener = null;
        }
        if (this.mMoreOfferShowCallBack != null) {
            this.mMoreOfferShowCallBack = null;
        }
        if (this.mNotifyListener != null) {
            this.mNotifyListener = null;
        }
    }

    public void setFromType(int i2) {
        this.mFromType = i2;
    }

    public void setIsRetry(boolean z) {
        this.mIsRetry = z;
    }

    public void setMoreOfferListener(com.mbridge.msdk.video.dynview.listener.g gVar, com.mbridge.msdk.video.module.listener.a aVar) {
        this.mMoreOfferLayoutListener = gVar;
        this.mNotifyListener = aVar;
    }

    public void showView() {
        CampaignUnit campaignUnit;
        com.mbridge.msdk.video.dynview.listener.g gVar = this.mMoreOfferLayoutListener;
        if (gVar == null) {
            return;
        }
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null || (campaignUnit = this.mCampaignUnit) == null) {
            gVar.a(-1, "more Offer create fail");
            return;
        }
        gVar.a(mBridgeRelativeLayout, campaignUnit);
        if (!this.isOnlyImpShow) {
            com.mbridge.msdk.video.dynview.request.a.a(this.mCampaignUnit, 0, 1, "117361");
        }
        if (this.mHasReportMofScenes) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("scene", this.mFromType + "");
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mof_scenes", this.mMainOfferCampaignEx, eVar);
    }

    class c extends com.mbridge.msdk.video.dynview.request.abs.a {
        c() {
        }

        @Override // com.mbridge.msdk.video.dynview.request.abs.a
        public void a(List<com.mbridge.msdk.tracker.network.g> list, CampaignUnit campaignUnit) {
            if (MOfferModel.this.mParam == null || campaignUnit == null) {
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
                return;
            }
            try {
                MOfferModel mOfferModel = MOfferModel.this;
                mOfferModel.mUnitId = mOfferModel.mParam.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                MOfferModel mOfferModel2 = MOfferModel.this;
                mOfferModel2.mRid = mOfferModel2.mParam.a().get("r_id");
                if (campaignUnit.getAds() == null || campaignUnit.getAds().size() < 5) {
                    if (!MOfferModel.this.hasReportMoreOfferLoad) {
                        com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), "more offer load failed errorCode: -999 errorMsg: The campaign quantity less than 5.", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        MOfferModel.this.hasReportMoreOfferLoad = true;
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("result", "2");
                    eVar.a("code", MOfferModel.MOF_LOAD_RESULT_CODE_OFFER_LESS_THAN_5);
                    if (MOfferModel.this.mIsRetry) {
                        eVar.a("retry", "1");
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar);
                    com.mbridge.msdk.video.dynview.moffer.a.a().b();
                    return;
                }
                MOfferModel.this.mCampaignUnit = campaignUnit;
                if (MOfferModel.this.admf > 0 && MOfferModel.this.admftm == 1) {
                    MOfferModel.this.doControllableImpOnRequest();
                }
                if (!MOfferModel.this.hasReportMoreOfferLoad) {
                    com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), "more offer load success", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                    MOfferModel.this.hasReportMoreOfferLoad = true;
                }
                com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar2.a("result", "1");
                if (MOfferModel.this.mIsRetry) {
                    eVar2.a("retry", "1");
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar2);
                MOfferModel.this.createMoreOfferView();
            } catch (Exception e) {
                p0.b(MOfferModel.TAG, e.getMessage());
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
            }
        }

        @Override // com.mbridge.msdk.video.dynview.request.abs.a
        public void a(int i, String str) {
            if (MOfferModel.this.mParam == null) {
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
                return;
            }
            try {
                MOfferModel mOfferModel = MOfferModel.this;
                mOfferModel.mUnitId = mOfferModel.mParam.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                MOfferModel mOfferModel2 = MOfferModel.this;
                mOfferModel2.mRid = mOfferModel2.mParam.a().get("r_id");
                if (!MOfferModel.this.hasReportMoreOfferLoad) {
                    com.mbridge.msdk.video.dynview.request.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), "more offer load failed errorCode:" + i + "errorMsg:" + str, MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                    MOfferModel.this.hasReportMoreOfferLoad = true;
                }
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("result", "2");
                eVar.a("code", i + "");
                if (MOfferModel.this.mIsRetry) {
                    eVar.a("retry", "1");
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar);
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
            } catch (Exception e) {
                p0.b(MOfferModel.TAG, e.getMessage());
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
            }
        }
    }
}
