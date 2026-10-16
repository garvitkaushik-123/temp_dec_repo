package com.fyber.inneractive.sdk.bidder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class f extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final e f1033a;

    public f(e eVar) {
        this.f1033a = eVar;
    }

    public final void a() {
        com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.app.action.INTERRUPTION_FILTER_CHANGED"));
        com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.intent.action.AIRPLANE_MODE"));
        if (com.fyber.inneractive.sdk.util.o.a("android.permission.BLUETOOTH")) {
            com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"));
            com.fyber.inneractive.sdk.util.o.f1770a.registerReceiver(this, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
        boolean z;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.getClass();
        action.hashCode();
        switch (action.hashCode()) {
            case -1538406691:
                if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1530327060:
                if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1076576821:
                if (action.equals("android.intent.action.AIRPLANE_MODE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1123270207:
                if (action.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1779291251:
                if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2070024785:
                if (action.equals("android.media.RINGER_MODE_CHANGED")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2106958107:
                if (action.equals("android.app.action.INTERRUPTION_FILTER_CHANGED")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                b bVar = (b) this.f1033a;
                bVar.b.getClass();
                int intExtra = intent.getIntExtra("plugged", -1);
                z = intExtra == 1 || intExtra == 2 || intExtra == 4;
                Boolean bool = bVar.c.B;
                if (bool == null || bool.booleanValue() != z) {
                    bVar.c.B = Boolean.valueOf(z);
                    bVar.d();
                }
                bVar.b.getClass();
                if (!TextUtils.equals(bVar.c.C, com.fyber.inneractive.sdk.serverapi.b.a((intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1)))) {
                    d dVar = bVar.c;
                    bVar.b.getClass();
                    dVar.C = com.fyber.inneractive.sdk.serverapi.b.a((intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1));
                    bVar.d();
                    break;
                }
                break;
            case 1:
            case 3:
                b bVar2 = (b) this.f1033a;
                bVar2.getClass();
                Boolean bool2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", Integer.MIN_VALUE) == 2 ? Boolean.TRUE : null;
                d dVar2 = bVar2.c;
                if (dVar2.t != bool2) {
                    dVar2.t = bool2;
                    bVar2.d();
                    break;
                }
                break;
            case 2:
                b bVar3 = (b) this.f1033a;
                bVar3.c.w = Boolean.valueOf(intent.getBooleanExtra("state", false));
                bVar3.d();
                break;
            case 4:
                b bVar4 = (b) this.f1033a;
                bVar4.c.u = com.fyber.inneractive.sdk.serverapi.b.n();
                bVar4.d();
                break;
            case 5:
                b bVar5 = (b) this.f1033a;
                bVar5.getClass();
                int intExtra2 = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
                z = intExtra2 == 0 || intExtra2 == 1;
                Boolean bool3 = bVar5.c.y;
                if (bool3 == null || bool3.booleanValue() != z) {
                    bVar5.c.y = Boolean.valueOf(z);
                    bVar5.d();
                    break;
                }
                break;
            case 6:
                ((b) this.f1033a).c();
                break;
        }
    }
}
