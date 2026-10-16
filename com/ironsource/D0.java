package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class D0 {
    private static final int p = -1;

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f2820a;
    private final b b;
    private C0 c;
    private final AbstractC3326u3 d;
    public U8 e;
    public C3115hb f;
    public Hf g;
    public R1 h;
    public M i;
    public Mf j;
    public Dc k;
    private Map<A0, a> l;
    private Map<A0, a> m;
    private Map<A0, a> n;
    private Map<A0, a> o;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2821a;
        private final int b;

        public a(A5 a5, A5 a52) {
            if (a5 != null) {
                this.f2821a = a5.b();
            } else {
                this.f2821a = -1;
            }
            if (a52 != null) {
                this.b = a52.b();
            } else {
                this.b = -1;
            }
        }

        int a(b bVar) {
            return b.MEDIATION.equals(bVar) ? this.f2821a : this.b;
        }
    }

    public enum b {
        MEDIATION,
        PROVIDER
    }

    public D0(IronSource.AD_UNIT ad_unit, b bVar, C0 c0) {
        this(ad_unit, bVar, c0, a(ad_unit));
    }

    private static AbstractC3326u3 a(IronSource.AD_UNIT ad_unit) {
        return ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) ? Id.i() : C3400y9.i();
    }

    private void d() {
        HashMap hashMap = new HashMap();
        this.o = hashMap;
        hashMap.put(A0.INIT_STARTED, new a(A5.NT_MANAGER_INIT_STARTED, null));
        this.o.put(A0.INIT_ENDED, new a(A5.NT_MANAGER_INIT_ENDED, null));
        this.o.put(A0.PLACEMENT_CAPPED, new a(A5.NT_PLACEMENT_CAPPED, null));
        this.o.put(A0.AUCTION_REQUEST, new a(A5.NT_AUCTION_REQUEST, null));
        this.o.put(A0.AUCTION_SUCCESS, new a(A5.NT_AUCTION_SUCCESS, null));
        Map<A0, a> map = this.o;
        A0 a0 = A0.AUCTION_FAILED;
        A5 a5 = A5.NT_AUCTION_FAILED;
        map.put(a0, new a(a5, null));
        this.o.put(A0.AUCTION_FAILED_NO_CANDIDATES, new a(a5, null));
        this.o.put(A0.AUCTION_REQUEST_WATERFALL, new a(A5.NT_AUCTION_REQUEST_WATERFALL, null));
        this.o.put(A0.AUCTION_RESULT_WATERFALL, new a(A5.NT_AUCTION_RESPONSE_WATERFALL, null));
        this.o.put(A0.INIT_SUCCESS, new a(null, null));
        this.o.put(A0.INIT_FAILED, new a(null, null));
        this.o.put(A0.AD_OPENED, new a(A5.NT_CALLBACK_SHOW, A5.NT_INSTANCE_SHOW));
        this.o.put(A0.AD_CLICKED, new a(A5.NT_CALLBACK_CLICK, A5.NT_INSTANCE_CLICK));
        this.o.put(A0.LOAD_AD, new a(A5.NT_LOAD, A5.NT_INSTANCE_LOAD));
        this.o.put(A0.LOAD_AD_SUCCESS, new a(A5.NT_CALLBACK_LOAD_SUCCESS, A5.NT_INSTANCE_LOAD_SUCCESS));
        this.o.put(A0.LOAD_AD_FAILED_WITH_REASON, new a(A5.NT_CALLBACK_LOAD_ERROR, A5.NT_INSTANCE_LOAD_ERROR));
        this.o.put(A0.LOAD_AD_NO_FILL, new a(null, A5.NT_INSTANCE_LOAD_NO_FILL));
        this.o.put(A0.AD_FORMAT_CAPPED, new a(A5.NT_AD_UNIT_CAPPED, null));
        Map<A0, a> map2 = this.o;
        A0 a02 = A0.COLLECT_TOKEN;
        A5 a52 = A5.NT_COLLECT_TOKENS;
        A5 a53 = A5.NT_INSTANCE_COLLECT_TOKEN;
        map2.put(a02, new a(a52, a53));
        this.o.put(A0.COLLECT_TOKENS_COMPLETED, new a(A5.NT_COLLECT_TOKENS_COMPLETED, null));
        this.o.put(A0.COLLECT_TOKENS_FAILED, new a(A5.NT_COLLECT_TOKENS_FAILED, null));
        this.o.put(A0.INSTANCE_COLLECT_TOKEN, new a(a53, null));
        Map<A0, a> map3 = this.o;
        A0 a03 = A0.INSTANCE_COLLECT_TOKEN_SUCCESS;
        A5 a54 = A5.NT_INSTANCE_COLLECT_TOKEN_SUCCESS;
        map3.put(a03, new a(a54, a54));
        Map<A0, a> map4 = this.o;
        A0 a04 = A0.INSTANCE_COLLECT_TOKEN_FAILED;
        A5 a55 = A5.NT_INSTANCE_COLLECT_TOKEN_FAILED;
        map4.put(a04, new a(a55, a55));
        Map<A0, a> map5 = this.o;
        A0 a05 = A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT;
        A5 a56 = A5.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT;
        map5.put(a05, new a(a56, a56));
        this.o.put(A0.DESTROY_AD, new a(A5.NT_DESTROY, A5.NT_INSTANCE_DESTROY));
        Map<A0, a> map6 = this.o;
        A0 a06 = A0.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING;
        A5 a57 = A5.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING;
        map6.put(a06, new a(a57, a57));
        Map<A0, a> map7 = this.o;
        A0 a07 = A0.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS;
        A5 a58 = A5.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS;
        map7.put(a07, new a(a58, a58));
        Map<A0, a> map8 = this.o;
        A0 a08 = A0.TROUBLESHOOT_UNEXPECTED_INIT_FAILED;
        A5 a59 = A5.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED;
        map8.put(a08, new a(a59, a59));
        Map<A0, a> map9 = this.o;
        A0 a09 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS;
        A5 a510 = A5.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS;
        map9.put(a09, new a(a510, a510));
        Map<A0, a> map10 = this.o;
        A0 a010 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED;
        A5 a511 = A5.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED;
        map10.put(a010, new a(a511, a511));
        Map<A0, a> map11 = this.o;
        A0 a011 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS;
        A5 a512 = A5.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS;
        map11.put(a011, new a(a512, a512));
        Map<A0, a> map12 = this.o;
        A0 a012 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED;
        A5 a513 = A5.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED;
        map12.put(a012, new a(a513, a513));
        Map<A0, a> map13 = this.o;
        A0 a013 = A0.TROUBLESHOOT_UNEXPECTED_TIMEOUT;
        A5 a514 = A5.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT;
        map13.put(a013, new a(a514, a514));
        Map<A0, a> map14 = this.o;
        A0 a014 = A0.TROUBLESHOOT_UNEXPECTED_OPENED;
        A5 a515 = A5.TROUBLESHOOTING_NT_UNEXPECTED_OPENED;
        map14.put(a014, new a(a515, a515));
        Map<A0, a> map15 = this.o;
        A0 a015 = A0.TROUBLESHOOT_INTERNAL_ERROR;
        A5 a516 = A5.TROUBLESHOOTING_NT_INTERNAL_ERROR;
        map15.put(a015, new a(a516, a516));
        Map<A0, a> map16 = this.o;
        A0 a016 = A0.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        A5 a517 = A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        map16.put(a016, new a(a517, a517));
        Map<A0, a> map17 = this.o;
        A0 a017 = A0.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR;
        A5 a518 = A5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR;
        map17.put(a017, new a(a518, a518));
        this.o.put(A0.TROUBLESHOOT_NOTIFICATION_ERROR, new a(A5.TROUBLESHOOTING_NT_NOTIFICATIONS_ERROR, null));
    }

    void b() {
        c();
        e();
        a();
        d();
    }

    void c() {
        HashMap hashMap = new HashMap();
        this.l = hashMap;
        hashMap.put(A0.INIT_STARTED, new a(A5.IS_MANAGER_INIT_STARTED, null));
        this.l.put(A0.INIT_ENDED, new a(A5.IS_MANAGER_INIT_ENDED, null));
        this.l.put(A0.SESSION_CAPPED, new a(null, A5.IS_CAP_SESSION));
        this.l.put(A0.PLACEMENT_CAPPED, new a(A5.IS_CAP_PLACEMENT, null));
        this.l.put(A0.CHECK_PLACEMENT_CAPPED, new a(A5.IS_CHECK_PLACEMENT_CAPPED, null));
        this.l.put(A0.AUCTION_REQUEST, new a(A5.IS_AUCTION_REQUEST, null));
        this.l.put(A0.AUCTION_SUCCESS, new a(A5.IS_AUCTION_SUCCESS, null));
        Map<A0, a> map = this.l;
        A0 a0 = A0.AUCTION_FAILED;
        A5 a5 = A5.IS_AUCTION_FAILED;
        map.put(a0, new a(a5, null));
        this.l.put(A0.AUCTION_FAILED_NO_CANDIDATES, new a(a5, null));
        this.l.put(A0.AUCTION_REQUEST_WATERFALL, new a(A5.IS_AUCTION_REQUEST_WATERFALL, null));
        this.l.put(A0.AUCTION_RESULT_WATERFALL, new a(A5.IS_RESULT_WATERFALL, null));
        this.l.put(A0.INIT_SUCCESS, new a(null, null));
        this.l.put(A0.INIT_FAILED, new a(null, null));
        this.l.put(A0.SHOW_AD_SUCCESS, new a(A5.IS_CALLBACK_AD_DISPLAYED, A5.IS_INSTANCE_SHOW_SUCCESS));
        this.l.put(A0.AD_OPENED, new a(null, A5.IS_INSTANCE_OPENED));
        this.l.put(A0.AD_CLOSED, new a(A5.IS_CALLBACK_AD_CLOSED, A5.IS_INSTANCE_CLOSED));
        this.l.put(A0.AD_CLICKED, new a(A5.IS_CALLBACK_AD_CLICKED, A5.IS_INSTANCE_CLICKED));
        this.l.put(A0.AD_INFO_CHANGED, new a(A5.IS_CALLBACK_AD_INFO_CHANGED, null));
        this.l.put(A0.LOAD_AD, new a(A5.IS_LOAD_CALLED, A5.IS_INSTANCE_LOAD));
        this.l.put(A0.LOAD_AD_SUCCESS, new a(A5.IS_CALLBACK_LOAD_SUCCESS, A5.IS_INSTANCE_LOAD_SUCCESS));
        this.l.put(A0.LOAD_AD_FAILED_WITH_REASON, new a(A5.IS_CALLBACK_LOAD_ERROR, A5.IS_INSTANCE_LOAD_FAILED));
        this.l.put(A0.LOAD_AD_NO_FILL, new a(null, A5.IS_INSTANCE_LOAD_NO_FILL));
        this.l.put(A0.SHOW_AD, new a(A5.IS_SHOW_CALLED, A5.IS_INSTANCE_SHOW));
        this.l.put(A0.SHOW_AD_FAILED, new a(A5.IS_CALLBACK_AD_SHOW_ERROR, A5.IS_INSTANCE_SHOW_FAILED));
        this.l.put(A0.AD_FORMAT_CAPPED, new a(A5.IS_AD_FORMAT_CAPPED, null));
        this.l.put(A0.AD_UNIT_CAPPED, new a(A5.IS_AD_UNIT_CAPPED, null));
        this.l.put(A0.COLLECT_TOKEN, new a(A5.IS_COLLECT_TOKENS, null));
        this.l.put(A0.COLLECT_TOKENS_COMPLETED, new a(A5.IS_COLLECT_TOKENS_COMPLETED, null));
        this.l.put(A0.COLLECT_TOKENS_FAILED, new a(A5.IS_COLLECT_TOKENS_FAILED, null));
        this.l.put(A0.INSTANCE_COLLECT_TOKEN, new a(A5.IS_INSTANCE_COLLECT_TOKEN, null));
        this.l.put(A0.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(A5.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, null));
        this.l.put(A0.INSTANCE_COLLECT_TOKEN_FAILED, new a(A5.IS_INSTANCE_COLLECT_TOKEN_FAILED, null));
        this.l.put(A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(A5.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, null));
        this.l.put(A0.AD_READY_TRUE, new a(A5.IS_CHECK_READY_TRUE, null));
        this.l.put(A0.AD_READY_FALSE, new a(A5.IS_CHECK_READY_FALSE, null));
        this.l.put(A0.OPERATIONAL_LOAD_AD, new a(A5.IS_OPERATIONAL_LOAD_AD, null));
        this.l.put(A0.OPERATIONAL_LOAD_SUCCESS, new a(A5.IS_OPERATIONAL_LOAD_SUCCESS, null));
        this.l.put(A0.OPERATIONAL_LOAD_FAILED, new a(A5.IS_OPERATIONAL_LOAD_FAILED, null));
        this.l.put(A0.OPERATIONAL_SET_CONFIGURATIONS, new a(A5.IS_SET_CONFIGURATION, null));
        Map<A0, a> map2 = this.l;
        A0 a02 = A0.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING;
        A5 a52 = A5.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING;
        map2.put(a02, new a(a52, a52));
        Map<A0, a> map3 = this.l;
        A0 a03 = A0.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS;
        A5 a53 = A5.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS;
        map3.put(a03, new a(a53, a53));
        Map<A0, a> map4 = this.l;
        A0 a04 = A0.TROUBLESHOOT_UNEXPECTED_INIT_FAILED;
        A5 a54 = A5.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED;
        map4.put(a04, new a(a54, a54));
        Map<A0, a> map5 = this.l;
        A0 a05 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS;
        A5 a55 = A5.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS;
        map5.put(a05, new a(a55, a55));
        Map<A0, a> map6 = this.l;
        A0 a06 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED;
        A5 a56 = A5.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED;
        map6.put(a06, new a(a56, a56));
        Map<A0, a> map7 = this.l;
        A0 a07 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS;
        A5 a57 = A5.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS;
        map7.put(a07, new a(a57, a57));
        Map<A0, a> map8 = this.l;
        A0 a08 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED;
        A5 a58 = A5.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED;
        map8.put(a08, new a(a58, a58));
        Map<A0, a> map9 = this.l;
        A0 a09 = A0.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED;
        A5 a59 = A5.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED;
        map9.put(a09, new a(a59, a59));
        Map<A0, a> map10 = this.l;
        A0 a010 = A0.TROUBLESHOOT_UNEXPECTED_CLOSED;
        A5 a510 = A5.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED;
        map10.put(a010, new a(a510, a510));
        Map<A0, a> map11 = this.l;
        A0 a011 = A0.TROUBLESHOOT_UNEXPECTED_TIMEOUT;
        A5 a511 = A5.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT;
        map11.put(a011, new a(a511, a511));
        Map<A0, a> map12 = this.l;
        A0 a012 = A0.TROUBLESHOOT_INTERNAL_ERROR;
        A5 a512 = A5.TROUBLESHOOTING_IS_INTERNAL_ERROR;
        map12.put(a012, new a(a512, a512));
        Map<A0, a> map13 = this.l;
        A0 a013 = A0.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        A5 a513 = A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        map13.put(a013, new a(a513, a513));
        Map<A0, a> map14 = this.l;
        A0 a014 = A0.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR;
        A5 a514 = A5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR;
        map14.put(a014, new a(a514, a514));
        this.l.put(A0.TROUBLESHOOT_NOTIFICATION_ERROR, new a(A5.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, null));
        Map<A0, a> map15 = this.l;
        A0 a015 = A0.TROUBLESHOOT_AD_EXPIRED;
        A5 a515 = A5.TROUBLESHOOTING_IS_AD_EXPIRED;
        map15.put(a015, new a(a515, a515));
        this.l.put(A0.TROUBLESHOOT_LOAD, new a(A5.TROUBLESHOOTING_IS_LOAD, null));
        this.l.put(A0.TROUBLESHOOT_LOAD_WHILE_LOADED, new a(A5.TROUBLESHOOTING_IS_LOAD_WHILE_LOADED, null));
        this.l.put(A0.TROUBLESHOOT_LOAD_SUCCESS, new a(A5.TROUBLESHOOTING_IS_LOAD_SUCCESS, null));
        this.l.put(A0.TROUBLESHOOT_LOAD_FAILED, new a(A5.TROUBLESHOOTING_IS_LOAD_FAILED, null));
        this.l.put(A0.TROUBLESHOOT_SHOW, new a(A5.TROUBLESHOOTING_IS_SHOW, null));
        this.l.put(A0.TROUBLESHOOT_SHOW_SUCCESS, new a(A5.TROUBLESHOOTING_IS_SHOW_SUCCESS, null));
        this.l.put(A0.TROUBLESHOOT_SHOW_FAILED, new a(A5.TROUBLESHOOTING_IS_SHOW_FAILED, null));
        Map<A0, a> map16 = this.l;
        A0 a016 = A0.TROUBLESHOOT_ILLEGAL_STATE;
        A5 a516 = A5.TROUBLESHOOTING_IS_ILLEGAL_STATE;
        map16.put(a016, new a(a516, a516));
        this.l.put(A0.TROUBLESHOOT_AD_INFO_CHANGED, new a(A5.TROUBLESHOOT_IS_AD_INFO_CHANGED, null));
        this.l.put(A0.TROUBLESHOOT_DISPOSE, new a(A5.TROUBLESHOOTING_IS_DISPOSE, null));
    }

    void e() {
        HashMap hashMap = new HashMap();
        this.m = hashMap;
        hashMap.put(A0.INIT_STARTED, new a(A5.RV_MANAGER_INIT_STARTED, null));
        this.m.put(A0.INIT_ENDED, new a(A5.RV_MANAGER_INIT_ENDED, null));
        this.m.put(A0.SESSION_CAPPED, new a(null, A5.RV_CAP_SESSION));
        this.m.put(A0.PLACEMENT_CAPPED, new a(A5.RV_CAP_PLACEMENT, null));
        this.m.put(A0.CHECK_PLACEMENT_CAPPED, new a(A5.RV_CHECK_PLACEMENT_CAPPED, null));
        this.m.put(A0.AUCTION_REQUEST, new a(A5.RV_AUCTION_REQUEST, null));
        this.m.put(A0.AUCTION_SUCCESS, new a(A5.RV_AUCTION_SUCCESS, null));
        Map<A0, a> map = this.m;
        A0 a0 = A0.AUCTION_FAILED;
        A5 a5 = A5.RV_AUCTION_FAILED;
        map.put(a0, new a(a5, null));
        this.m.put(A0.AUCTION_FAILED_NO_CANDIDATES, new a(a5, null));
        this.m.put(A0.AUCTION_REQUEST_WATERFALL, new a(A5.RV_AUCTION_REQUEST_WATERFALL, null));
        this.m.put(A0.AUCTION_RESULT_WATERFALL, new a(A5.RV_AUCTION_RESPONSE_WATERFALL, null));
        this.m.put(A0.INIT_SUCCESS, new a(null, null));
        this.m.put(A0.INIT_FAILED, new a(null, null));
        this.m.put(A0.AD_VISIBLE, new a(null, A5.RV_INSTANCE_VISIBLE));
        this.m.put(A0.SHOW_AD_SUCCESS, new a(A5.RV_CALLBACK_AD_DISPLAYED, null));
        this.m.put(A0.AD_OPENED, new a(null, A5.RV_BUSINESS_INSTANCE_OPENED));
        this.m.put(A0.AD_CLOSED, new a(null, A5.RV_INSTANCE_CLOSED));
        this.m.put(A0.AD_STARTED, new a(null, A5.RV_INSTANCE_STARTED));
        this.m.put(A0.AD_ENDED, new a(null, A5.RV_INSTANCE_ENDED));
        this.m.put(A0.AD_CLICKED, new a(A5.RV_CALLBACK_AD_CLICKED, A5.RV_BUSINESS_INSTANCE_CLICKED));
        this.m.put(A0.AD_INFO_CHANGED, new a(A5.RV_CALLBACK_AD_INFO_CHANGED, null));
        this.m.put(A0.AD_REWARDED, new a(null, A5.RV_BUSINESS_INSTANCE_REWARDED));
        this.m.put(A0.AD_AVAILABILITY_CHANGED_TRUE, new a(A5.RV_CALLBACK_AVAILABILITY_TRUE, A5.RV_INSTANCE_AVAILABILITY_TRUE));
        this.m.put(A0.AD_AVAILABILITY_CHANGED_FALSE, new a(A5.RV_CALLBACK_AVAILABILITY_FALSE, A5.RV_INSTANCE_AVAILABILITY_FALSE));
        this.m.put(A0.LOAD_AD, new a(A5.RV_BUSINESS_MEDIATION_LOAD, A5.RV_BUSINESS_INSTANCE_LOAD));
        this.m.put(A0.LOAD_AD_SUCCESS, new a(A5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS, A5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS));
        this.m.put(A0.LOAD_AD_FAILED, new a(null, A5.RV_INSTANCE_LOAD_FAILED));
        this.m.put(A0.LOAD_AD_FAILED_WITH_REASON, new a(A5.RV_MEDIATION_LOAD_ERROR, A5.RV_INSTANCE_LOAD_FAILED_REASON));
        this.m.put(A0.LOAD_AD_NO_FILL, new a(null, A5.RV_INSTANCE_LOAD_NO_FILL));
        this.m.put(A0.SHOW_AD, new a(A5.RV_API_SHOW_CALLED, A5.RV_INSTANCE_SHOW));
        this.m.put(A0.SHOW_AD_CHANCE, new a(null, A5.RV_INSTANCE_SHOW_CHANCE));
        this.m.put(A0.SHOW_AD_FAILED, new a(A5.RV_CALLBACK_SHOW_FAILED, A5.RV_INSTANCE_SHOW_FAILED));
        this.m.put(A0.AD_FORMAT_CAPPED, new a(A5.RV_AD_UNIT_CAPPED, null));
        this.m.put(A0.COLLECT_TOKEN, new a(A5.RV_COLLECT_TOKENS, null));
        this.m.put(A0.COLLECT_TOKENS_COMPLETED, new a(A5.RV_COLLECT_TOKENS_COMPLETED, null));
        this.m.put(A0.COLLECT_TOKENS_FAILED, new a(A5.RV_COLLECT_TOKENS_FAILED, null));
        this.m.put(A0.INSTANCE_COLLECT_TOKEN, new a(A5.RV_INSTANCE_COLLECT_TOKEN, null));
        Map<A0, a> map2 = this.m;
        A0 a02 = A0.INSTANCE_COLLECT_TOKEN_SUCCESS;
        A5 a52 = A5.RV_INSTANCE_COLLECT_TOKEN_SUCCESS;
        map2.put(a02, new a(a52, a52));
        Map<A0, a> map3 = this.m;
        A0 a03 = A0.INSTANCE_COLLECT_TOKEN_FAILED;
        A5 a53 = A5.RV_INSTANCE_COLLECT_TOKEN_FAILED;
        map3.put(a03, new a(a53, a53));
        Map<A0, a> map4 = this.m;
        A0 a04 = A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT;
        A5 a54 = A5.RV_INSTANCE_COLLECT_TOKEN_TIMED_OUT;
        map4.put(a04, new a(a54, a54));
        this.m.put(A0.AD_READY_TRUE, new a(A5.RV_CHECK_READY_TRUE, null));
        this.m.put(A0.AD_READY_FALSE, new a(A5.RV_CHECK_READY_FALSE, null));
        this.m.put(A0.OPERATIONAL_LOAD_AD, new a(A5.RV_OPERATIONAL_LOAD_AD, null));
        this.m.put(A0.OPERATIONAL_LOAD_SUCCESS, new a(A5.RV_OPERATIONAL_LOAD_SUCCESS, null));
        this.m.put(A0.OPERATIONAL_LOAD_FAILED, new a(A5.RV_OPERATIONAL_LOAD_FAILED, null));
        this.m.put(A0.OPERATIONAL_SET_CONFIGURATIONS, new a(A5.RV_SET_CONFIGURATION, null));
        Map<A0, a> map5 = this.m;
        A0 a05 = A0.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING;
        A5 a55 = A5.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING;
        map5.put(a05, new a(a55, a55));
        Map<A0, a> map6 = this.m;
        A0 a06 = A0.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS;
        A5 a56 = A5.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS;
        map6.put(a06, new a(a56, a56));
        Map<A0, a> map7 = this.m;
        A0 a07 = A0.TROUBLESHOOT_UNEXPECTED_INIT_FAILED;
        A5 a57 = A5.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED;
        map7.put(a07, new a(a57, a57));
        Map<A0, a> map8 = this.m;
        A0 a08 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS;
        A5 a58 = A5.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS;
        map8.put(a08, new a(a58, a58));
        Map<A0, a> map9 = this.m;
        A0 a09 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED;
        A5 a59 = A5.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED;
        map9.put(a09, new a(a59, a59));
        Map<A0, a> map10 = this.m;
        A0 a010 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS;
        A5 a510 = A5.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS;
        map10.put(a010, new a(a510, a510));
        Map<A0, a> map11 = this.m;
        A0 a011 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED;
        A5 a511 = A5.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED;
        map11.put(a011, new a(a511, a511));
        Map<A0, a> map12 = this.m;
        A0 a012 = A0.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED;
        A5 a512 = A5.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED;
        map12.put(a012, new a(a512, a512));
        Map<A0, a> map13 = this.m;
        A0 a013 = A0.TROUBLESHOOT_UNEXPECTED_TIMEOUT;
        A5 a513 = A5.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT;
        map13.put(a013, new a(a513, a513));
        Map<A0, a> map14 = this.m;
        A0 a014 = A0.TROUBLESHOOT_UNEXPECTED_CLOSED;
        A5 a514 = A5.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED;
        map14.put(a014, new a(a514, a514));
        Map<A0, a> map15 = this.m;
        A0 a015 = A0.TROUBLESHOOT_LOAD_FAILED;
        A5 a515 = A5.TROUBLESHOOTING_RV_LOAD_FAILED;
        map15.put(a015, new a(a515, a515));
        Map<A0, a> map16 = this.m;
        A0 a016 = A0.TROUBLESHOOT_INTERNAL_ERROR;
        A5 a516 = A5.TROUBLESHOOTING_RV_INTERNAL_ERROR;
        map16.put(a016, new a(a516, a516));
        Map<A0, a> map17 = this.m;
        A0 a017 = A0.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        A5 a517 = A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        map17.put(a017, new a(a517, a517));
        Map<A0, a> map18 = this.m;
        A0 a018 = A0.TROUBLESHOOT_WATERFALL_OVERHEAD;
        A5 a518 = A5.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD;
        map18.put(a018, new a(a518, a518));
        this.m.put(A0.TROUBLESHOOT_NOTIFICATION_ERROR, new a(A5.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, null));
        Map<A0, a> map19 = this.m;
        A0 a019 = A0.TROUBLESHOOT_AD_EXPIRED;
        A5 a519 = A5.TROUBLESHOOTING_RV_AD_EXPIRED;
        map19.put(a019, new a(a519, a519));
        this.m.put(A0.TROUBLESHOOT_LOAD, new a(A5.TROUBLESHOOTING_RV_LOAD, null));
        this.m.put(A0.TROUBLESHOOT_LOAD_WHILE_LOADED, new a(A5.TROUBLESHOOTING_RV_LOAD_WHILE_LOADED, null));
        this.m.put(A0.TROUBLESHOOT_LOAD_SUCCESS, new a(A5.TROUBLESHOOTING_RV_LOAD_SUCCESS, null));
        this.m.put(A0.TROUBLESHOOT_SHOW, new a(A5.TROUBLESHOOTING_RV_SHOW, null));
        this.m.put(A0.TROUBLESHOOT_SHOW_SUCCESS, new a(A5.TROUBLESHOOTING_RV_SHOW_SUCCESS, null));
        this.m.put(A0.TROUBLESHOOT_SHOW_FAILED, new a(A5.TROUBLESHOOTING_RV_SHOW_FAILED, null));
        Map<A0, a> map20 = this.m;
        A0 a020 = A0.TROUBLESHOOT_ILLEGAL_STATE;
        A5 a520 = A5.TROUBLESHOOTING_RV_ILLEGAL_STATE;
        map20.put(a020, new a(a520, a520));
        this.m.put(A0.TROUBLESHOOT_AD_INFO_CHANGED, new a(A5.TROUBLESHOOT_RV_AD_INFO_CHANGED, null));
        this.m.put(A0.TROUBLESHOOT_DISPOSE, new a(A5.TROUBLESHOOTING_RV_DISPOSE, null));
    }

    public void f() {
        this.c = null;
        this.g = null;
        this.h = null;
        this.e = null;
        this.f = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public D0(IronSource.AD_UNIT ad_unit, b bVar, C0 c0, AbstractC3326u3 abstractC3326u3) {
        this.f2820a = ad_unit;
        this.b = bVar;
        this.c = c0;
        this.d = abstractC3326u3 == null ? a(ad_unit) : abstractC3326u3;
        b();
        this.e = new U8(this);
        this.f = new C3115hb(this);
        this.g = new Hf(this);
        this.h = new R1(this);
        this.i = new M(this);
        this.j = new Mf(this);
        this.k = new Dc(this);
    }

    protected void a(A0 a0, Map<String, Object> map) {
        a(a0, map, Calendar.getInstance().getTimeInMillis());
    }

    public void a(A0 a0, Map<String, Object> map, long j) {
        int a2 = a(a0);
        if (-1 == a2) {
            return;
        }
        HashMap hashMap = new HashMap();
        C0 c0 = this.c;
        if (c0 != null) {
            hashMap.putAll(c0.a(a0));
        }
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        this.d.a(new C3413z5(a2, j, new JSONObject(hashMap)));
    }

    private int a(A0 a0) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.f2820a) && this.l.containsKey(a0)) {
                return this.l.get(a0).a(this.b);
            }
            if (IronSource.AD_UNIT.REWARDED_VIDEO.equals(this.f2820a) && this.m.containsKey(a0)) {
                return this.m.get(a0).a(this.b);
            }
            if (IronSource.AD_UNIT.BANNER.equals(this.f2820a) && this.n.containsKey(a0)) {
                return this.n.get(a0).a(this.b);
            }
            if (IronSource.AD_UNIT.NATIVE_AD.equals(this.f2820a) && this.o.containsKey(a0)) {
                return this.o.get(a0).a(this.b);
            }
            return -1;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1;
        }
    }

    void a() {
        HashMap hashMap = new HashMap();
        this.n = hashMap;
        hashMap.put(A0.INIT_STARTED, new a(A5.BN_MANAGER_INIT_STARTED, null));
        this.n.put(A0.INIT_ENDED, new a(A5.BN_MANAGER_INIT_ENDED, null));
        this.n.put(A0.PLACEMENT_CAPPED, new a(A5.BN_PLACEMENT_CAPPED, null));
        this.n.put(A0.AUCTION_REQUEST, new a(A5.BN_AUCTION_REQUEST, null));
        this.n.put(A0.AUCTION_SUCCESS, new a(A5.BN_AUCTION_SUCCESS, null));
        Map<A0, a> map = this.n;
        A0 a0 = A0.AUCTION_FAILED;
        A5 a5 = A5.BN_AUCTION_FAILED;
        map.put(a0, new a(a5, null));
        this.n.put(A0.AUCTION_FAILED_NO_CANDIDATES, new a(a5, null));
        this.n.put(A0.AUCTION_REQUEST_WATERFALL, new a(A5.BN_AUCTION_REQUEST_WATERFALL, null));
        this.n.put(A0.AUCTION_RESULT_WATERFALL, new a(A5.BN_AUCTION_RESPONSE_WATERFALL, null));
        this.n.put(A0.INIT_SUCCESS, new a(null, null));
        this.n.put(A0.INIT_FAILED, new a(null, null));
        this.n.put(A0.AD_OPENED, new a(A5.BN_CALLBACK_SHOW, A5.BN_INSTANCE_SHOW));
        this.n.put(A0.AD_CLICKED, new a(A5.BN_CALLBACK_CLICK, A5.BN_INSTANCE_CLICK));
        this.n.put(A0.LOAD_AD, new a(A5.BN_LOAD, A5.BN_INSTANCE_LOAD));
        this.n.put(A0.RELOAD_AD, new a(A5.BN_RELOAD, A5.BN_INSTANCE_RELOAD));
        this.n.put(A0.LOAD_AD_SUCCESS, new a(A5.BN_CALLBACK_LOAD_SUCCESS, A5.BN_INSTANCE_LOAD_SUCCESS));
        this.n.put(A0.RELOAD_AD_SUCCESS, new a(A5.BN_CALLBACK_RELOAD_SUCCESS, A5.BN_INSTANCE_RELOAD_SUCCESS));
        this.n.put(A0.LOAD_AD_FAILED_WITH_REASON, new a(A5.BN_CALLBACK_LOAD_ERROR, A5.BN_INSTANCE_LOAD_ERROR));
        this.n.put(A0.RELOAD_AD_FAILED_WITH_REASON, new a(A5.BN_CALLBACK_RELOAD_ERROR, A5.BN_INSTANCE_RELOAD_ERROR));
        this.n.put(A0.LOAD_AD_NO_FILL, new a(null, A5.BN_INSTANCE_LOAD_NO_FILL));
        this.n.put(A0.RELOAD_AD_NO_FILL, new a(null, A5.BN_INSTANCE_RELOAD_NO_FILL));
        this.n.put(A0.AD_FORMAT_CAPPED, new a(A5.BN_AD_UNIT_CAPPED, null));
        this.n.put(A0.COLLECT_TOKEN, new a(A5.BN_COLLECT_TOKENS, null));
        this.n.put(A0.COLLECT_TOKENS_COMPLETED, new a(A5.BN_COLLECT_TOKENS_COMPLETED, null));
        this.n.put(A0.COLLECT_TOKENS_FAILED, new a(A5.BN_COLLECT_TOKENS_FAILED, null));
        this.n.put(A0.INSTANCE_COLLECT_TOKEN, new a(A5.BN_INSTANCE_COLLECT_TOKEN, null));
        Map<A0, a> map2 = this.n;
        A0 a02 = A0.INSTANCE_COLLECT_TOKEN_SUCCESS;
        A5 a52 = A5.BN_INSTANCE_COLLECT_TOKEN_SUCCESS;
        map2.put(a02, new a(a52, a52));
        Map<A0, a> map3 = this.n;
        A0 a03 = A0.INSTANCE_COLLECT_TOKEN_FAILED;
        A5 a53 = A5.BN_INSTANCE_COLLECT_TOKEN_FAILED;
        map3.put(a03, new a(a53, a53));
        Map<A0, a> map4 = this.n;
        A0 a04 = A0.INSTANCE_COLLECT_TOKEN_TIMED_OUT;
        A5 a54 = A5.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT;
        map4.put(a04, new a(a54, a54));
        this.n.put(A0.DESTROY_AD, new a(A5.BN_DESTROY, A5.BN_INSTANCE_DESTROY));
        this.n.put(A0.SKIP_RELOAD_AD, new a(A5.BN_SKIP_RELOAD, null));
        this.n.put(A0.AD_LEFT_APPLICATION, new a(A5.BN_CALLBACK_LEAVE_APP, A5.BN_INSTANCE_LEAVE_APP));
        this.n.put(A0.AD_PRESENT_SCREEN, new a(A5.BN_CALLBACK_PRESENT_SCREEN, A5.BN_INSTANCE_PRESENT_SCREEN));
        this.n.put(A0.AD_DISMISS_SCREEN, new a(A5.BN_CALLBACK_DISMISS_SCREEN, A5.BN_INSTANCE_DISMISS_SCREEN));
        this.n.put(A0.AD_VIEW_BOUND, new a(A5.BN_BOUND, A5.BN_INSTANCE_BOUND));
        this.n.put(A0.PAUSE_AD, new a(A5.BN_REFRESH_PAUSE, null));
        this.n.put(A0.RESUME_AD, new a(A5.BN_REFRESH_RESUME, null));
        this.n.put(A0.OPERATIONAL_SET_CONFIGURATIONS, new a(A5.BN_SET_CONFIGURATION, null));
        Map<A0, a> map5 = this.n;
        A0 a05 = A0.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING;
        A5 a55 = A5.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING;
        map5.put(a05, new a(a55, a55));
        Map<A0, a> map6 = this.n;
        A0 a06 = A0.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS;
        A5 a56 = A5.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS;
        map6.put(a06, new a(a56, a56));
        Map<A0, a> map7 = this.n;
        A0 a07 = A0.TROUBLESHOOT_UNEXPECTED_INIT_FAILED;
        A5 a57 = A5.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED;
        map7.put(a07, new a(a57, a57));
        Map<A0, a> map8 = this.n;
        A0 a08 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS;
        A5 a58 = A5.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS;
        map8.put(a08, new a(a58, a58));
        Map<A0, a> map9 = this.n;
        A0 a09 = A0.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED;
        A5 a59 = A5.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED;
        map9.put(a09, new a(a59, a59));
        Map<A0, a> map10 = this.n;
        A0 a010 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS;
        A5 a510 = A5.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS;
        map10.put(a010, new a(a510, a510));
        Map<A0, a> map11 = this.n;
        A0 a011 = A0.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED;
        A5 a511 = A5.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED;
        map11.put(a011, new a(a511, a511));
        Map<A0, a> map12 = this.n;
        A0 a012 = A0.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS;
        A5 a512 = A5.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS;
        map12.put(a012, new a(a512, a512));
        Map<A0, a> map13 = this.n;
        A0 a013 = A0.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED;
        A5 a513 = A5.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED;
        map13.put(a013, new a(a513, a513));
        Map<A0, a> map14 = this.n;
        A0 a014 = A0.TROUBLESHOOT_UNEXPECTED_TIMEOUT;
        A5 a514 = A5.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT;
        map14.put(a014, new a(a514, a514));
        Map<A0, a> map15 = this.n;
        A0 a015 = A0.TROUBLESHOOT_UNEXPECTED_OPENED;
        A5 a515 = A5.TROUBLESHOOTING_BN_UNEXPECTED_OPENED;
        map15.put(a015, new a(a515, a515));
        Map<A0, a> map16 = this.n;
        A0 a016 = A0.TROUBLESHOOT_INTERNAL_ERROR;
        A5 a516 = A5.TROUBLESHOOTING_BN_INTERNAL_ERROR;
        map16.put(a016, new a(a516, a516));
        Map<A0, a> map17 = this.n;
        A0 a017 = A0.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        A5 a517 = A5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR;
        map17.put(a017, new a(a517, a517));
        Map<A0, a> map18 = this.n;
        A0 a018 = A0.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR;
        A5 a518 = A5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR;
        map18.put(a018, new a(a518, a518));
        this.n.put(A0.TROUBLESHOOT_NOTIFICATION_ERROR, new a(A5.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, null));
        this.n.put(A0.TROUBLESHOOT_BN_RELOAD_EXCEPTION, new a(A5.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, null));
        this.n.put(A0.TROUBLESHOOT_IMPRESSION_TIMEOUT, new a(A5.TROUBLESHOOTING_BN_IMPRESSION_TIMEOUT_REACHED, null));
        this.n.put(A0.TROUBLESHOOT_BANNER_REFRESH_PAUSED, new a(A5.TROUBLESHOOT_BN_BANNER_REFRESH_PAUSED, null));
        this.n.put(A0.TROUBLESHOOT_BANNER_REFRESH_RESUMED, new a(A5.TROUBLESHOOT_BN_BANNER_REFRESH_RESUMED, null));
        this.n.put(A0.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_PAUSE, new a(A5.TROUBLESHOOT_BN_BANNER_REFRESH_TRIGGER_PAUSE, null));
        this.n.put(A0.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_RESUME, new a(A5.TROUBLESHOOT_BN_BANNER_REFRESH_TRIGGER_RESUME, null));
        Map<A0, a> map19 = this.n;
        A0 a019 = A0.TROUBLESHOOT_BANNER_REFRESH_TRANSITION;
        A5 a519 = A5.TROUBLESHOOT_BN_BANNER_REFRESH_TRANSITION;
        map19.put(a019, new a(a519, a519));
        Map<A0, a> map20 = this.n;
        A0 a020 = A0.TROUBLESHOOT_BANNER_REFRESH_ANIMATED;
        A5 a520 = A5.TROUBLESHOOT_BN_BANNER_REFRESH_ANIMATED;
        map20.put(a020, new a(a520, a520));
        Map<A0, a> map21 = this.n;
        A0 a021 = A0.TROUBLESHOOT_ILLEGAL_STATE;
        A5 a521 = A5.TROUBLESHOOTING_BN_ILLEGAL_STATE;
        map21.put(a021, new a(a521, a521));
        this.n.put(A0.TROUBLESHOOT_RELOAD, new a(A5.TROUBLESHOOTING_BN_RELOAD, null));
        Map<A0, a> map22 = this.n;
        A0 a022 = A0.TROUBLESHOOT_LOAD_SKIPPED;
        A5 a522 = A5.TROUBLESHOOTING_BN_LOAD_SKIPPED;
        map22.put(a022, new a(a522, a522));
    }
}
