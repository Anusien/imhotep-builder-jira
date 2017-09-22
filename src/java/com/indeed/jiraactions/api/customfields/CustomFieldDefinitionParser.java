package com.indeed.jiraactions.api.customfields;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indeed.util.core.nullsafety.ReturnValuesAreNonnullByDefault;
import org.apache.log4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.io.InputStream;

@ParametersAreNonnullByDefault
@ReturnValuesAreNonnullByDefault
public abstract class CustomFieldDefinitionParser {
    private CustomFieldDefinitionParser() { /* No */ }
    private static final Logger log = Logger.getLogger(CustomFieldDefinitionParser.class);
    private final static ObjectMapper mapper = new ObjectMapper()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    public static CustomFieldDefinition[] parseCustomFields(final InputStream in) throws IOException {
        return mapper.readValue(in, CustomFieldDefinition[].class);
    }
}
