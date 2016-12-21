package org.hp.leopard;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.AbstractLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created by paul on 16/12/21.
 */

@Plugin(name = "spring", category = StrLookup.CATEGORY)
public class SpringEnvrionmentLookup extends AbstractLookup {


    @Autowired
    Environment environment;

    @Autowired
    Aware aware;
    @Override
    public String lookup(LogEvent logEvent, String s) {
        return SpringContext.getEnvironment().getProperty(s);
    }
}
