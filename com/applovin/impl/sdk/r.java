package com.applovin.impl.sdk;

import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.text.TextUtils;
import android.view.InputEvent;
import com.applovin.impl.b6;
import com.applovin.impl.o4;
import com.applovin.impl.p6;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v4;
import com.ironsource.N6;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final k f727a;
    private final Executor b;
    private final MeasurementManager e;
    private final TopicsManager h;
    private final Set c = new HashSet();
    private final Object d = new Object();
    private final AtomicReference f = new AtomicReference(new JSONArray());
    private final d g = new d(this, null);

    class a implements OutcomeReceiver {
        a() {
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Failed to register impression", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Successfully registered impression");
            }
        }
    }

    class b implements OutcomeReceiver {
        b() {
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Failed to register click", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Successfully registered click");
            }
        }
    }

    class c implements OutcomeReceiver {
        c() {
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Failed to register conversion", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Successfully registered conversion");
            }
        }
    }

    private class d implements OutcomeReceiver {
        private d() {
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(GetTopicsResponse getTopicsResponse) {
            List<Topic> topics = getTopicsResponse.getTopics();
            int size = topics.size();
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().d("PrivacySandboxService", size + " topic(s) received");
            }
            JSONArray jSONArray = new JSONArray();
            for (Topic topic : topics) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putInt(jSONObject, "id", topic.getTopicId());
                JsonUtils.putLong(jSONObject, N6.B, topic.getModelVersion());
                JsonUtils.putLong(jSONObject, "taxonomy", topic.getTaxonomyVersion());
                jSONArray.put(jSONObject);
            }
            r.this.f.set(jSONArray);
            r.this.b(((Boolean) r.this.f727a.a(v4.X6)).booleanValue(), ((Long) r.this.f727a.a(v4.V6)).longValue());
        }

        /* synthetic */ d(r rVar, a aVar) {
            this();
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            Long l = (Long) r.this.f727a.a(v4.W6);
            boolean z = l.longValue() == -1;
            r.this.f727a.O();
            if (o.a()) {
                r.this.f727a.O().a("PrivacySandboxService", "Failed to retrieve topics" + (z ? "" : ", retrying in " + l + " ms"), exc);
            }
            if (z) {
                return;
            }
            r.this.b(((Boolean) r.this.f727a.a(v4.Y6)).booleanValue(), l.longValue());
        }
    }

    protected r(k kVar) {
        this.f727a = kVar;
        this.b = kVar.r0().b();
        Context o = k.o();
        this.e = (MeasurementManager) o.getSystemService(MeasurementManager.class);
        this.h = (TopicsManager) o.getSystemService(TopicsManager.class);
        if (((Boolean) kVar.a(v4.U6)).booleanValue()) {
            b(((Boolean) kVar.a(v4.X6)).booleanValue(), 0L);
        }
    }

    private boolean c(String str) {
        synchronized (this.d) {
            if (this.c.contains(str)) {
                return false;
            }
            this.c.add(str);
            return true;
        }
    }

    public void b(final List list) {
        a("register impression", new Runnable() { // from class: com.applovin.impl.sdk.r$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                r.this.a(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (list == null || list.isEmpty() || this.e == null || !o4.e(k.E0)) {
            return;
        }
        this.f727a.O();
        if (o.a()) {
            this.f727a.O().a("PrivacySandboxService", "Registering impression...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.e.registerSource(Uri.parse((String) it.next()), null, this.b, new a());
        }
    }

    public void b(final List list, final InputEvent inputEvent) {
        a("register click", new Runnable() { // from class: com.applovin.impl.sdk.r$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                r.this.a(list, inputEvent);
            }
        });
    }

    public void b(final String str) {
        a("register conversion trigger event", new Runnable() { // from class: com.applovin.impl.sdk.r$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                r.this.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z, final long j) {
        a("retrieve topics", new Runnable() { // from class: com.applovin.impl.sdk.r$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                r.this.a(z, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, InputEvent inputEvent) {
        if (list == null || list.isEmpty() || this.e == null || !o4.e(k.E0)) {
            return;
        }
        this.f727a.O();
        if (o.a()) {
            this.f727a.O().a("PrivacySandboxService", "Registering click...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.e.registerSource(Uri.parse((String) it.next()), inputEvent, this.b, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str) || this.e == null || !o4.e(k.E0)) {
            return;
        }
        this.f727a.O();
        if (o.a()) {
            this.f727a.O().a("PrivacySandboxService", "Registering conversion: " + str);
        }
        this.e.registerTrigger(Uri.parse(str), this.b, new c());
    }

    public JSONArray a() {
        return (JSONArray) this.f.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, long j) {
        if (this.h == null) {
            return;
        }
        final GetTopicsRequest build = new GetTopicsRequest.Builder().setShouldRecordObservation(z).setAdsSdkName("AppLovin").build();
        if (j > 0) {
            this.f727a.r0().a(new p6(this.f727a, true, "getTopics", new Runnable() { // from class: com.applovin.impl.sdk.r$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.a(build);
                }
            }), b6.b.OTHER, j);
        } else {
            this.h.getTopics(build, this.b, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GetTopicsRequest getTopicsRequest) {
        this.h.getTopics(getTopicsRequest, this.b, this.g);
    }

    private void a(String str, Runnable runnable) {
        try {
            this.f727a.O();
            if (o.a()) {
                this.f727a.O().a("PrivacySandboxService", "Running operation: " + str);
            }
            runnable.run();
        } catch (Throwable th) {
            this.f727a.O();
            if (o.a()) {
                this.f727a.O().a("PrivacySandboxService", "Failed to run operation: " + str, th);
            }
            if (c(str)) {
                this.f727a.E().a("PrivacySandboxService", str, th);
            }
        }
    }
}
