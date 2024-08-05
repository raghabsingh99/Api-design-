package com.codeset.dashboard.constants;

public enum CodeSetEnum {

    CARDIOLOGY("CodeSetCardiology"),
    MSK("CodeSetMSK"),
    RAD("CodeSetRad"),
    RBM("CodeSetRBM"),
    REHAB("CodeSetRehab"),
    SLEEP("CodeSetSleep");

    public final String codeSetName;

    private CodeSetEnum(String codeSetName) {
        this.codeSetName = codeSetName;
    }

    public String getCodeSetName() {
        return codeSetName;
    }
}

