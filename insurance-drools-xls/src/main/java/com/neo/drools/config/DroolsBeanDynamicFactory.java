package com.neo.drools.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import javax.annotation.PostConstruct;

public class DroolsBeanDynamicFactory {

//    private KieServices kieServices=KieServices.Factory.get();

    @PostConstruct
    public KieContainer getKieSession() {
        KieServices kieServices=KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId("com.secbro", "insurance-rules", "0.0.1-SNAPSHOT");

        KieContainer kContainer = kieServices.newKieContainer(releaseId);
        KieScanner kScanner = kieServices.newKieScanner(kContainer);

        // Start the KieScanner polling the Maven repository every 10 seconds
        kScanner.start(10000L);

//        KieSession ksession = kContainer.newKieSession();

        return kContainer;
    }


}
