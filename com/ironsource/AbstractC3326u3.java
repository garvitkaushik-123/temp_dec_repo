package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.AbstractC3326u3;
import com.ironsource.C7;
import com.ironsource.E5;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.u3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3326u3 implements B7 {
    private int[] A;
    private int[] B;
    private int[] C;
    int G;
    String H;
    String I;
    Set<Integer> J;
    private C5 K;
    private IronSourceSegment L;
    private C3354ve M;
    private ISErrorListener N;
    private boolean l;
    private F4 p;
    private AbstractC3052e q;
    private ArrayList<C3413z5> r;
    private int t;
    private H8 u;
    private Context v;
    private int[] z;

    /* renamed from: a, reason: collision with root package name */
    final int f3868a = 1;
    final int b = 100;
    final int c = 5000;
    final int d = 90000;
    final int e = 1024;
    final int f = 5;
    final String g = "supersonic_sdk.db";
    final String h = IronSourceConstants.EVENTS_PROVIDER;
    final String i = "placement";
    private final String j = "abt";
    private final String k = N6.Z0;
    private boolean m = false;
    private boolean n = false;
    private int o = -1;
    private boolean s = true;
    private int w = 100;
    private int x = 5000;
    private int y = 1;
    private Map<String, String> D = new HashMap();
    private Map<String, String> E = new HashMap();
    private String F = "";
    private final Object O = new Object();

    /* renamed from: com.ironsource.u3$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3326u3.this.a();
        }
    }

    /* renamed from: com.ironsource.u3$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3413z5 f3870a;
        final /* synthetic */ IronSource.AD_UNIT b;

        b(C3413z5 c3413z5, IronSource.AD_UNIT ad_unit) {
            this.f3870a = c3413z5;
            this.b = ad_unit;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3870a.a("eventSessionId", AbstractC3326u3.this.u.b());
            this.f3870a.a("essn", Integer.valueOf(AbstractC3326u3.this.u.c()));
            String connectionType = IronSourceUtils.getConnectionType(AbstractC3326u3.this.v);
            if (AbstractC3326u3.this.g(this.f3870a)) {
                this.f3870a.a("connectionType", connectionType);
            }
            if (AbstractC3326u3.this.a(connectionType, this.f3870a)) {
                C3413z5 c3413z5 = this.f3870a;
                c3413z5.a(AbstractC3326u3.this.b(c3413z5));
            }
            String d = C2986a4.d(AbstractC3326u3.this.v);
            if (d != null) {
                this.f3870a.a("rawConnectionType", d);
            }
            int a2 = AbstractC3326u3.this.a(this.f3870a.c(), this.b);
            if (a2 != e.NOT_SUPPORTED.b()) {
                this.f3870a.a("adUnit", Integer.valueOf(a2));
            }
            AbstractC3326u3.this.a(this.f3870a, "reason");
            AbstractC3326u3.this.a(this.f3870a, IronSourceConstants.EVENTS_EXT1);
            if (!AbstractC3326u3.this.E.isEmpty()) {
                for (Map.Entry entry : AbstractC3326u3.this.E.entrySet()) {
                    if (!this.f3870a.b().has((String) entry.getKey()) && entry.getKey() != "eventId" && entry.getKey() != "timestamp") {
                        this.f3870a.a((String) entry.getKey(), entry.getValue());
                    }
                }
            }
            if (AbstractC3326u3.this.i(this.f3870a)) {
                if (AbstractC3326u3.this.h(this.f3870a) && !AbstractC3326u3.this.e(this.f3870a)) {
                    this.f3870a.a("sessionDepth", Integer.valueOf(AbstractC3326u3.this.c(this.f3870a)));
                }
                if (AbstractC3326u3.this.j(this.f3870a)) {
                    AbstractC3326u3.this.f(this.f3870a);
                }
                long a3 = AbstractC3326u3.this.u.a();
                if (a3 > 0) {
                    this.f3870a.a("firstSessionTimestamp", Long.valueOf(a3));
                }
                IronLog.EVENT.verbose(this.f3870a.toString());
                AbstractC3326u3.this.r.add(this.f3870a);
                AbstractC3326u3.this.t++;
            }
            AbstractC3326u3 abstractC3326u3 = AbstractC3326u3.this;
            boolean a4 = abstractC3326u3.a(abstractC3326u3.B) ? AbstractC3326u3.this.a(this.f3870a.c(), AbstractC3326u3.this.B) : AbstractC3326u3.this.d(this.f3870a);
            AbstractC3326u3 abstractC3326u32 = AbstractC3326u3.this;
            if (!abstractC3326u32.m && a4) {
                abstractC3326u32.m = true;
            }
            if (abstractC3326u32.p != null) {
                if (abstractC3326u32.g()) {
                    AbstractC3326u3.this.f();
                    return;
                }
                AbstractC3326u3 abstractC3326u33 = AbstractC3326u3.this;
                if (abstractC3326u33.b((ArrayList<C3413z5>) abstractC3326u33.r) || a4) {
                    AbstractC3326u3.this.a();
                }
            }
        }
    }

    /* renamed from: com.ironsource.u3$d */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC3326u3.this.f();
        }
    }

    /* renamed from: com.ironsource.u3$e */
    public enum e {
        NOT_SUPPORTED(-1),
        INTERSTITIAL(2),
        REWARDED_VIDEO(3),
        NATIVE_AD(4),
        BANNER(8);


        /* renamed from: a, reason: collision with root package name */
        private int f3873a;

        e(int i) {
            this.f3873a = i;
        }

        public int b() {
            return this.f3873a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int b(C3413z5 c3413z5) {
        return c3413z5.c() + 90000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ArrayList<C3413z5> a2;
        try {
            this.m = false;
            ArrayList<C3413z5> arrayList = new ArrayList<>();
            try {
                synchronized (this.O) {
                    a2 = this.p.a(this.I);
                    this.p.b(this.I);
                }
                E5.c cVar = new E5.c(new E5.a(a2, this.r), this.x);
                this.p.a(cVar.a(), this.I);
                arrayList.addAll(cVar.b());
            } catch (Throwable th) {
                C3260q4.d().a(th);
                IronLog.INTERNAL.error("CombinedEventList exception: " + th.getMessage());
                ISErrorListener iSErrorListener = this.N;
                if (iSErrorListener != null) {
                    iSErrorListener.onError(new IllegalStateException("Combined event exception: ", th));
                }
                arrayList.clear();
                arrayList.addAll(this.r);
            }
            if (arrayList.size() > 0) {
                this.r.clear();
                this.t = 0;
                JSONObject b2 = K6.a().b();
                try {
                    a(b2);
                    String b3 = b();
                    if (!TextUtils.isEmpty(b3)) {
                        b2.put("abt", b3);
                    }
                    String n = com.ironsource.mediationsdk.p.j().n();
                    if (!TextUtils.isEmpty(n)) {
                        b2.put(N6.Z0, n);
                    }
                    Map<String, String> c2 = c();
                    if (!c2.isEmpty()) {
                        for (Map.Entry<String, String> entry : c2.entrySet()) {
                            if (!b2.has(entry.getKey())) {
                                b2.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    JSONObject a3 = new J5().a();
                    Iterator<String> keys = a3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        b2.put(next, a3.get(next));
                    }
                } catch (Throwable th2) {
                    C3260q4.d().a(th2);
                    IronLog.INTERNAL.error("Exception while building the event general properties: " + th2.getMessage());
                }
                String a4 = this.q.a(arrayList, b2);
                if (TextUtils.isEmpty(a4)) {
                    IronLog.INTERNAL.error("Failed to parse events.");
                    ISErrorListener iSErrorListener2 = this.N;
                    if (iSErrorListener2 != null) {
                        iSErrorListener2.onError(new IllegalStateException("Event parse failed"));
                        return;
                    }
                    return;
                }
                if (this.n) {
                    try {
                        a4 = Base64.encodeToString(H9.a(a4, this.o), 0);
                    } catch (Exception e2) {
                        C3260q4.d().a(e2);
                        ISErrorListener iSErrorListener3 = this.N;
                        if (iSErrorListener3 != null) {
                            iSErrorListener3.onError(new IllegalStateException("Error on compression: ", e2));
                        }
                    }
                }
                C3068ef.f3275a.a(new K5(new c(), a4, this.q.b(), arrayList));
            }
        } catch (Throwable th3) {
            C3260q4.d().a(th3);
            IronLog.INTERNAL.error("Send event exception: " + th3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return (this.t >= this.w || this.m) && this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(C3413z5 c3413z5) {
        if (c3413z5 == null) {
            return false;
        }
        if (a(this.z)) {
            return !a(c3413z5.c(), this.z);
        }
        if (a(this.A)) {
            return a(c3413z5.c(), this.A);
        }
        return true;
    }

    public synchronized void a(Context context, IronSourceSegment ironSourceSegment) {
        String defaultEventsFormatterType = IronSourceUtils.getDefaultEventsFormatterType(context, this.I, this.H);
        this.H = defaultEventsFormatterType;
        b(defaultEventsFormatterType);
        this.q.a(IronSourceUtils.getDefaultEventsURL(context, this.I, null));
        this.p = F4.a(context, "supersonic_sdk.db", 5);
        this.K.a(new a());
        this.z = IronSourceUtils.getDefaultOptOutEvents(context, this.I);
        this.A = IronSourceUtils.getDefaultOptInEvents(context, this.I);
        this.B = IronSourceUtils.getDefaultTriggerEvents(context, this.I);
        this.C = IronSourceUtils.getDefaultNonConnectivityEvents(context, this.I);
        this.L = ironSourceSegment;
        this.v = context;
    }

    protected abstract int c(C3413z5 c3413z5);

    @Override // com.ironsource.B7
    public void c(int[] iArr, Context context) {
        this.A = iArr;
        IronSourceUtils.saveDefaultOptInEvents(context, this.I, iArr);
    }

    abstract void d();

    @Override // com.ironsource.B7
    public void d(int i) {
        if (i > 0) {
            this.x = i;
        }
    }

    protected abstract boolean d(C3413z5 c3413z5);

    protected abstract String e(int i);

    void e() {
        this.r = new ArrayList<>();
        this.t = 0;
        this.q = H5.a(this.H, this.G);
        C5 c5 = new C5(this.I + "EventThread");
        this.K = c5;
        c5.start();
        this.K.a();
        this.u = C3334ub.U().m();
        this.J = new HashSet();
        d();
    }

    protected abstract void f(C3413z5 c3413z5);

    public void h() {
        this.K.a(new d());
    }

    protected abstract boolean j(C3413z5 c3413z5);

    private void b(String str) {
        AbstractC3052e abstractC3052e = this.q;
        if (abstractC3052e == null || !abstractC3052e.c().equals(str)) {
            this.q = H5.a(str, this.G);
        }
    }

    @Override // com.ironsource.B7
    public void d(int[] iArr, Context context) {
        this.C = iArr;
        IronSourceUtils.saveDefaultNonConnectivityEvents(context, this.I, iArr);
    }

    protected boolean g(C3413z5 c3413z5) {
        return (c3413z5.c() == A5.CONSENT_TRUE_CODE.b() || c3413z5.c() == A5.CONSENT_FALSE_CODE.b() || c3413z5.c() == A5.SET_META_DATA.b() || c3413z5.c() == A5.SET_META_DATA_AFTER_INIT.b() || c3413z5.c() == A5.SET_USER_ID.b()) ? false : true;
    }

    protected boolean h(C3413z5 c3413z5) {
        return (c3413z5.c() == A5.FIRST_INSTANCE.b() || c3413z5.c() == A5.FIRST_INSTANCE_RESULT.b() || c3413z5.c() == A5.INIT_COMPLETE.b() || c3413z5.c() == A5.SDK_INIT_FAILED.b() || c3413z5.c() == A5.SDK_INIT_SUCCESS.b() || c3413z5.c() == A5.USING_CACHE_FOR_INIT_EVENT.b() || c3413z5.c() == A5.CONSENT_TRUE_CODE.b() || c3413z5.c() == A5.CONSENT_FALSE_CODE.b() || c3413z5.c() == A5.SET_META_DATA.b() || c3413z5.c() == A5.SET_META_DATA_AFTER_INIT.b() || c3413z5.c() == A5.SET_USER_ID.b()) ? false : true;
    }

    @Override // com.ironsource.B7
    public void c(int i) {
        this.o = i;
    }

    @Override // com.ironsource.B7
    public void b(int i) {
        if (i > 0) {
            this.y = i;
        }
    }

    public void c(boolean z) {
        this.l = z;
    }

    /* renamed from: com.ironsource.u3$c */
    class c implements C7 {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(C7.a aVar) {
            try {
                if (aVar.c()) {
                    AbstractC3326u3 abstractC3326u3 = AbstractC3326u3.this;
                    ArrayList<C3413z5> a2 = abstractC3326u3.p.a(abstractC3326u3.I);
                    AbstractC3326u3.this.t = a2.size() + AbstractC3326u3.this.r.size();
                } else {
                    IronLog.INTERNAL.error("Failed to send events. Saving them back to storage.");
                    AbstractC3326u3.this.a(AbstractC3326u3.this.a(aVar.b(), aVar.a()));
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                ISErrorListener iSErrorListener = AbstractC3326u3.this.N;
                if (iSErrorListener != null) {
                    iSErrorListener.onError(new IllegalStateException("Error on sending data ", e));
                }
            }
            a(aVar.b());
        }

        public void a(ArrayList<C3413z5> arrayList) {
            if (arrayList != null) {
                try {
                    arrayList.clear();
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error("clearData exception: " + e.getMessage());
                }
            }
        }

        @Override // com.ironsource.C7
        public synchronized void a(final C7.a aVar) {
            AbstractC3326u3.this.K.a(new Runnable() { // from class: com.ironsource.u3$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC3326u3.c.this.b(aVar);
                }
            });
        }
    }

    @Override // com.ironsource.B7
    public void b(int[] iArr, Context context) {
        this.z = iArr;
        IronSourceUtils.saveDefaultOptOutEvents(context, this.I, iArr);
    }

    public Map<String, String> c() {
        return this.D;
    }

    @Override // com.ironsource.B7
    public void b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC3052e abstractC3052e = this.q;
        if (abstractC3052e != null) {
            abstractC3052e.a(str);
        }
        IronSourceUtils.saveDefaultEventsURL(context, this.I, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(C3413z5 c3413z5) {
        JSONObject b2 = c3413z5.b();
        if (b2 == null) {
            return false;
        }
        return b2.has("sessionDepth");
    }

    @Override // com.ironsource.B7
    public void b(boolean z) {
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ArrayList<C3413z5> arrayList) {
        return arrayList != null && arrayList.size() >= this.y;
    }

    public String b() {
        return this.F;
    }

    public void b(Map<String, String> map) {
        this.E.putAll(map);
    }

    public synchronized void a(C3354ve c3354ve) {
        this.M = c3354ve;
    }

    public void a(ISErrorListener iSErrorListener) {
        this.N = iSErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(String str, C3413z5 c3413z5) {
        boolean contains;
        if (!str.equalsIgnoreCase("none")) {
            return false;
        }
        if (a(this.C)) {
            contains = a(c3413z5.c(), this.C);
        } else {
            contains = this.J.contains(Integer.valueOf(c3413z5.c()));
        }
        return contains;
    }

    @Override // com.ironsource.B7
    public synchronized void a(C3413z5 c3413z5) {
        a(c3413z5, (IronSource.AD_UNIT) null);
    }

    public synchronized void a(C3413z5 c3413z5, IronSource.AD_UNIT ad_unit) {
        if (c3413z5 != null) {
            if (this.s) {
                this.K.a(new b(c3413z5, ad_unit));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<C3413z5> a(ArrayList<C3413z5> arrayList, String str) {
        String a2 = a(str, 1024);
        Iterator<C3413z5> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(a2);
        }
        return arrayList;
    }

    protected void a(ArrayList<C3413z5> arrayList) {
        if (arrayList != null) {
            synchronized (this.O) {
                this.p.a(arrayList, this.I);
                this.t = this.p.a(this.I).size() + this.r.size();
            }
        }
    }

    @Override // com.ironsource.B7
    public void a(int i) {
        if (i > 0) {
            this.w = i;
        }
    }

    @Override // com.ironsource.B7
    public void a(int[] iArr, Context context) {
        this.B = iArr;
        IronSourceUtils.saveDefaultTriggerEvents(context, this.I, iArr);
    }

    @Override // com.ironsource.B7
    public void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.H = str;
        IronSourceUtils.saveDefaultEventsFormatterType(context, this.I, str);
        b(str);
    }

    @Override // com.ironsource.B7
    public void a(boolean z) {
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.O) {
            this.p.a(this.r, this.I);
            this.r.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int[] iArr) {
        if (a(iArr)) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(JSONObject jSONObject) {
        try {
            IronSourceSegment ironSourceSegment = this.L;
            if (ironSourceSegment != null) {
                if (ironSourceSegment.getAge() > 0) {
                    jSONObject.put("age", this.L.getAge());
                }
                if (!TextUtils.isEmpty(this.L.getGender())) {
                    jSONObject.put(IronSourceSegment.GENDER, this.L.getGender());
                }
                if (this.L.getLevel() > 0) {
                    jSONObject.put("lvl", this.L.getLevel());
                }
                if (this.L.getIsPaying() != null) {
                    jSONObject.put("pay", this.L.getIsPaying().get());
                }
                if (this.L.getIapt() > 0.0d) {
                    jSONObject.put("iapt", this.L.getIapt());
                }
                if (this.L.getUcd() > 0) {
                    jSONObject.put("ucd", this.L.getUcd());
                }
            }
            C3354ve c3354ve = this.M;
            if (c3354ve != null) {
                String b2 = c3354ve.b();
                if (!TextUtils.isEmpty(b2)) {
                    jSONObject.put("segmentId", b2);
                }
                JSONObject a2 = this.M.a();
                Iterator<String> keys = a2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, a2.get(next));
                }
            }
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    public void a(String str) {
        this.F = str;
    }

    public void a(Map<String, String> map) {
        this.D.putAll(map);
    }

    public void a(Map<String, Object> map, int i, String str) {
        map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put(IronSourceConstants.AUCTION_FALLBACK, str);
    }

    private void a(C3413z5 c3413z5, String str, int i) {
        JSONObject b2 = c3413z5.b();
        if (b2 == null || !b2.has(str)) {
            return;
        }
        try {
            c3413z5.a(str, a(b2.optString(str, null), i));
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    String a(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C3413z5 c3413z5, String str) {
        a(c3413z5, str, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, IronSource.AD_UNIT ad_unit) {
        int b2 = e.NOT_SUPPORTED.b();
        if (ad_unit != IronSource.AD_UNIT.REWARDED_VIDEO && ((i < 1000 || i >= 2000) && (i < 91000 || i >= 92000))) {
            if (ad_unit != IronSource.AD_UNIT.INTERSTITIAL && ((i < 2000 || i >= 3000) && (i < 92000 || i >= 93000))) {
                if (ad_unit == IronSource.AD_UNIT.BANNER || ((i >= 3000 && i < 4000) || (i >= 93000 && i < 94000))) {
                    return e.BANNER.b();
                }
                return (ad_unit == IronSource.AD_UNIT.NATIVE_AD || (i >= 4000 && i < 5000) || (i >= 94000 && i < 95000)) ? e.NATIVE_AD.b() : b2;
            }
            return e.INTERSTITIAL.b();
        }
        return e.REWARDED_VIDEO.b();
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.L = ironSourceSegment;
    }

    void a(Runnable runnable) {
        this.K.a(runnable);
    }

    protected int f(int i) {
        return a(i, (IronSource.AD_UNIT) null);
    }
}
