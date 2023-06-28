package io.jenkins.plugins.sample;

import org.junit.Test;

public class SampleConfigurationTest {

    /*
    This test case never worked in the first place since its introduction: https://github.com/jenkinsci/uuid-parameter-plugin/commit/535599970d34e286ce7458a6122bc140df02bf06
    There's no such "SampleConfiguration" class.
    @Rule
    public RestartableJenkinsRule rr = new RestartableJenkinsRule();

    @Test
    public void uiAndStorage() {
        rr.then(r -> {
            assertNull("not set initially", SampleConfiguration.get().getLabel());
            HtmlForm config = r.createWebClient().goTo("configure").getFormByName("config");
            HtmlTextInput textbox = config.getInputByName("_.label");
            textbox.setText("hello");
            r.submit(config);
            assertEquals("global config page let us edit it", "hello", SampleConfiguration.get().getLabel());
        });
        rr.then(r -> {
            assertEquals("still there after restart of Jenkins", "hello", SampleConfiguration.get().getLabel());
        });
    }

     */

    @Test
    public void anything() {
        /*
         * Intentionally blank. We just want a test that runs with JUnit so that buildPlugin() works
         * in the Jenkinsfile.
         */
    }

}
