package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.environment.workerthread.WorkerManager;
import com.ironsource.environment.workerthread.WorkerResult;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class B3 {

    class a implements WorkerManager.WorkEndedListener<C3> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2798a;

        a(b bVar) {
            this.f2798a = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ironsource.environment.workerthread.WorkerManager.WorkEndedListener
        public void onWorkCompleted(List<WorkerResult<C3>> list, long j) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (WorkerResult<C3> workerResult : list) {
                if (workerResult instanceof WorkerResult.Completed) {
                    arrayList2.add((C3) ((WorkerResult.Completed) workerResult).data);
                } else if (workerResult instanceof WorkerResult.Canceled) {
                    arrayList.add(((CallableC3394y3) ((WorkerResult.Canceled) workerResult).callable).c());
                } else if (workerResult instanceof WorkerResult.Failed) {
                    WorkerResult.Failed failed = (WorkerResult.Failed) workerResult;
                    CallableC3394y3 callableC3394y3 = (CallableC3394y3) failed.callable;
                    arrayList2.add(new C3(callableC3394y3.d(), callableC3394y3.c(), null, 0L, failed.exception.getMessage()));
                }
            }
            B3.this.a(arrayList2, arrayList, j);
            this.f2798a.a(arrayList2, j, arrayList);
        }

        @Override // com.ironsource.environment.workerthread.WorkerManager.WorkEndedListener
        public void onWorkFailed(String str) {
            String str2 = "failed to collect bidding data, error= " + str;
            IronLog.INTERNAL.verbose(str2);
            this.f2798a.onFailure(str2);
        }
    }

    public interface b {
        void a(List<C3> list, long j, List<String> list2);

        void onFailure(String str);
    }

    public void a(List<CallableC3394y3> list, b bVar, long j, TimeUnit timeUnit) {
        try {
            if (list.isEmpty()) {
                IronLog.INTERNAL.verbose("BiddingDataCallable list is empty");
                return;
            }
            WorkerManager workerManager = new WorkerManager(IronSourceThreadManager.INSTANCE.getThreadPoolExecutor());
            Iterator<CallableC3394y3> it = list.iterator();
            while (it.hasNext()) {
                workerManager.addCallable(it.next());
            }
            IronLog.INTERNAL.verbose("instances=" + list.size() + ", timeout=" + j + " millis");
            workerManager.startWork(new a(bVar), j, timeUnit);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "Exception - failed to collect bidding data, error= " + th.getMessage();
            IronLog.INTERNAL.error(str);
            bVar.onFailure(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<C3> list, List<String> list2, long j) {
        IronLog.INTERNAL.verbose("tokens received=" + list.size() + ", reached timeout=" + list2.size() + ", total duration=" + j + " millis");
        for (C3 c3 : list) {
            if (c3.a() != null) {
                IronLog.INTERNAL.verbose(c3.c() + " - success (" + c3.e() + " millis)");
            } else {
                IronLog.INTERNAL.verbose(c3.c() + " - failed (" + c3.e() + " millis) error: " + c3.b());
            }
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            IronLog.INTERNAL.verbose(it.next() + " reached timeout");
        }
    }
}
