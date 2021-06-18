package hudson.plugins.uuid_parameter;

import hudson.Extension;
import hudson.model.Hudson;
import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;
import hudson.model.StringParameterValue;
import hudson.util.FormValidation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import java.util.UUID;

/**
 * Created by Adam Mehina, 2021.
 */
public class UUIDParameterDefinition extends ParameterDefinition {
    private static final long serialVersionUID = 7L;
    private final String uuidValue;

    @DataBoundConstructor
    public UUIDParameterDefinition(String name, String defaultValue, String description) {
        super(name, description);
        this.uuidValue = defaultValue;
    }

    public String createUUID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public StringParameterValue getDefaultParameterValue() {
        return new StringParameterValue(getName(), createUUID(), getDescription());
    }

    @Override
    public ParameterValue createValue(StaplerRequest req) {
        return getDefaultParameterValue();
    }

    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        StringParameterValue value = req.bindJSON(StringParameterValue.class, jo);
        if (value.getValue().isEmpty()){
            value = getDefaultParameterValue();
        }
        return value;
    }

    @Extension
    public static class DescriptorImpl extends ParameterDescriptor {

        private final static String DISPLAY_NAME = "UUID Parameter";

        @Override
        public String getDisplayName() {
            return DISPLAY_NAME;
        }

        public FormValidation doCheckDefaultValue(@QueryParameter String defaultValue) {
            if (defaultValue.length() == 0) {
                return FormValidation.ok();
            }
            try {
                UUID value = UUID.fromString(defaultValue);
                return FormValidation.ok();
            } catch (IllegalArgumentException e) {
                return FormValidation.error("Invalid default value");
            }
        }
    }
}