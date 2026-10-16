package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public class Md {

    /* renamed from: a, reason: collision with root package name */
    public static a f2953a = new a(2001, a("initsdk"));
    public static a b = new a(2026, a("sdkrecoverstart"));
    public static a c = new a(2002, a("createcontrollerweb"));
    public static a d = new a(2003, a("createcontrollernative"));
    public static a e = new a(2004, a("controllerstageready"));
    public static a f = new a(2005, a("loadad"));
    public static a g = new a(2006, a("loadadfailed"));
    public static a h = new a(2007, a("initproduct"));
    public static a i = new a(2008, a("initproductfailed"));
    public static a j = new a(2009, a("loadproduct"));
    public static a k = new a(2010, a("parseadmfailed"));
    public static a l = new a(2011, a("loadadsuccess"));
    public static a m = new a(2027, a("destroyproduct"));
    public static a n = new a(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, a("registerad"));
    public static a o = new a(2013, a("controllerfailed"));
    public static a p = new a(2015, a("appendnativefeaturesdatafailed"));
    public static a q = new a(2016, a("adunitcouldnotloadtowebview"));
    public static a r = new a(2017, a("webviewcleanupfailed"));
    public static a s = new a(2018, a("removewebviewfailed"));
    public static a t = new a(IronSourceError.ERROR_NEW_INIT_API_ALREADY_CALLED, a("banneralreadydestroyed"));
    public static a u = new a(2021, a("fialedregactlifecycle"));
    public static a v = new a(2022, a("loadcontrollerhtml"));
    public static a w = new a(2023, a("controllerhtmlsuccess"));
    public static a x = new a(2024, a("controllerhtmlfailed"));
    public static a y = new a(2025, a("webviewcrashrpg"));
    public static a z = new a(2031, a("getorientationcalled"));
    public static a A = new a(2032, a("webviewunavailable"));
    public static final a B = new a(2033, a("controller_init_delayed"));

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f2954a;
        int b;

        a(int i, String str) {
            this.b = i;
            this.f2954a = str;
        }
    }

    static String a(String str) {
        return D5.c + str;
    }
}
