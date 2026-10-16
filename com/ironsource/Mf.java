package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes6.dex */
public class Mf {

    /* renamed from: a, reason: collision with root package name */
    private final D0 f2955a;

    public Mf(D0 d0) {
        this.f2955a = d0;
    }

    public void a(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("reason", str);
        hashMap.put(IronSourceConstants.EVENTS_EXT1, str2);
        this.f2955a.a(A0.TROUBLESHOOT_NOTIFICATION_ERROR, hashMap);
    }

    public void b(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_LOAD_FAILED, hashMap);
    }

    public void c() {
        this.f2955a.a(A0.TROUBLESHOOT_LOAD_SUCCESS, null);
    }

    public void d() {
        this.f2955a.a(A0.TROUBLESHOOT_SHOW, null);
    }

    public void e() {
        this.f2955a.a(A0.TROUBLESHOOT_SHOW_SUCCESS, null);
    }

    public void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_ILLEGAL_STATE, hashMap);
    }

    public void g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_INTERNAL_ERROR, hashMap);
    }

    public void h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_LOAD_SKIPPED, hashMap);
    }

    public void i(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, hashMap);
    }

    public void j(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, hashMap);
    }

    public void k(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, hashMap);
    }

    public void l(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_CLOSED, hashMap);
    }

    public void m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, hashMap);
    }

    public void n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, hashMap);
    }

    public void o(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, hashMap);
    }

    public void p(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, hashMap);
    }

    public void q(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_OPENED, hashMap);
    }

    public void r(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, hashMap);
    }

    public void s(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, hashMap);
    }

    public void t(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, hashMap);
    }

    public void u(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_UNEXPECTED_TIMEOUT, hashMap);
    }

    public void v(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_WATERFALL_OVERHEAD, hashMap);
    }

    public void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_BN_RELOAD_EXCEPTION, hashMap);
    }

    public void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_PAUSE, hashMap);
    }

    public void e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_RESUME, hashMap);
    }

    public void b() {
        this.f2955a.a(A0.TROUBLESHOOT_LOAD, null);
    }

    public void a(Long l) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", l);
        this.f2955a.a(A0.TROUBLESHOOT_LOAD_WHILE_LOADED, hashMap);
    }

    public void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_IMPRESSION_TIMEOUT, hashMap);
    }

    public void a(LevelPlayAdError levelPlayAdError) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(levelPlayAdError.getErrorCode()));
        hashMap.put("reason", levelPlayAdError.getErrorMessage());
        this.f2955a.a(A0.TROUBLESHOOT_SHOW_FAILED, hashMap);
    }

    public void b(String str, long j, long j2, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        hashMap.put(IronSourceConstants.EVENTS_EXT1, a(j, j2, j3));
        this.f2955a.a(A0.TROUBLESHOOT_BANNER_REFRESH_RESUMED, hashMap);
    }

    public void a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, hashMap);
    }

    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        this.f2955a.a(A0.TROUBLESHOOT_AD_EXPIRED, hashMap);
    }

    public void a(String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_EXT1, (str.isEmpty() ? "" : "provider=" + str + ";") + "expirationDuration=" + j);
        this.f2955a.a(A0.TROUBLESHOOT_AD_EXPIRED, hashMap);
    }

    public void a(String str, long j, long j2, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        hashMap.put(IronSourceConstants.EVENTS_EXT1, a(j, j2, j3));
        this.f2955a.a(A0.TROUBLESHOOT_BANNER_REFRESH_PAUSED, hashMap);
    }

    public void a(boolean z, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_EXT1, "isAnimated:" + (z ? 1 : 0));
        hashMap.put("duration", Long.valueOf(j));
        this.f2955a.a(A0.TROUBLESHOOT_BANNER_REFRESH_TRANSITION, hashMap);
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(j));
        this.f2955a.a(A0.TROUBLESHOOT_BANNER_REFRESH_ANIMATED, hashMap);
    }

    private String a(long j, long j2, long j3) {
        return "interval: " + j + ", remainingTime: " + j2 + ", timePassed: " + j3;
    }

    public void a(LevelPlayAdInfo levelPlayAdInfo, LevelPlayAdInfo levelPlayAdInfo2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_EXT1, String.format(Locale.ENGLISH, "oldAdNetwork=%s;oldInstanceId=%s;oldRevenue=%.3f;oldPrecision=%s;newAdNetwork=%s;newInstanceId=%s;newRevenue=%.3f;newPrecision=%s;delta=%.3f", levelPlayAdInfo.getAdNetwork(), levelPlayAdInfo.getInstanceId(), Double.valueOf(levelPlayAdInfo.getRevenue()), levelPlayAdInfo.getPrecision(), levelPlayAdInfo2.getAdNetwork(), levelPlayAdInfo2.getInstanceId(), Double.valueOf(levelPlayAdInfo2.getRevenue()), levelPlayAdInfo2.getPrecision(), Double.valueOf(levelPlayAdInfo2.getRevenue() - levelPlayAdInfo.getRevenue())));
        this.f2955a.a(A0.TROUBLESHOOT_AD_INFO_CHANGED, hashMap);
    }

    public void a() {
        this.f2955a.a(A0.TROUBLESHOOT_DISPOSE, null);
    }

    public void a(long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_EXT1, String.format(Locale.ENGLISH, "refreshDuration=%d;notVisibleDuration=%d;reason=%s", Long.valueOf(j), Long.valueOf(j2), str));
        this.f2955a.a(A0.TROUBLESHOOT_RELOAD, hashMap);
    }
}
