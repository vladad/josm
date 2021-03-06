// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.gui.preferences.advanced;

import javax.swing.JOptionPane;

import org.junit.Rule;
import org.junit.Test;
import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.testutils.JOSMTestRules;
import org.openstreetmap.josm.testutils.mockers.JOptionPaneSimpleMocker;

import com.google.common.collect.ImmutableMap;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Unit tests of {@link ExportProfileAction} class.
 */
public class ExportProfileActionTest {
    /**
     * Setup tests
     */
    @Rule
    @SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD")
    public JOSMTestRules test = new JOSMTestRules().preferences().assertionsInEDT();

    /**
     * Unit test of {@link ExportProfileAction#actionPerformed}.
     */
    @Test
    public void testAction() {
        new JOptionPaneSimpleMocker(ImmutableMap.of(
            "All the preferences of this group are default, nothing to save", JOptionPane.OK_OPTION
        ));
        new ExportProfileAction(Main.pref, "foo", "bar").actionPerformed(null);
        new ExportProfileAction(Main.pref, "expert", "expert").actionPerformed(null);
    }
}
