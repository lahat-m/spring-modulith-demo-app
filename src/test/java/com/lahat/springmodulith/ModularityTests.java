package com.lahat.springmodulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
public class ModularityTests {

    ApplicationModules modules = ApplicationModules.of(SpringModulithApplication.class);

    @Test
    void verifyModularity(){
        modules.verify();
    }
}
