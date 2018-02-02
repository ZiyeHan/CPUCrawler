package com.chris.cpu.enums;

public enum CoreEnum {
        SINGLE_CORE  ("#1"),
        MULTI_CORE("#2"),
        ;

        private final String coreOption;

        CoreEnum(String coreOption) {
            this.coreOption = coreOption;
        }

        public String getCoreOption() {
            return this.coreOption;
        }

}
