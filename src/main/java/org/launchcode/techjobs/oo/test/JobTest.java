package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//added this import for tests:
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //Test the Empty Constructor-define a test called testSettingJobId. Do not forget to annotate it with @Test.
    @Test
    public void testSettingJobId (){
        //Use assertNotEquals to verify that the IDs of the two objects are distinct.
        Job testJob2 = new Job ();
        Job testJob1 = new Job ();
        assertNotEquals(testJob2, testJob1);
    }

    //Test the Full Constructor-define a test called testJobConstructorSetsAllFields.
    @Test
    public void testJobConstructorSetsAllFields () {
       //Declare and initialize a new Job object with the following data:
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //Use assertTrue and assertEquals statements to test that the constructor correctly assigns both the class
        // and value of each field. Your test should have 5 assert statements of each type.
        assertTrue(testJob3 instanceof Job);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
    }

    @Test
    //Generate two Job objects that have identical field values EXCEPT for id. Test that equals returns false.
    public void testJobsForEquality(){
        Job testJob4 = new Job ("Rental Rep", new Employer ("ERAC"), new Location ("STL"),
                new PositionType ("level 1"), new CoreCompetency ("negotiation"));
        Job testJob5 = new Job ("Rental Rep", new Employer ("ERAC"), new Location ("STL"),
                new PositionType ("level 1"), new CoreCompetency ("negotiation"));
        assertFalse(testJob4 == testJob5);
    }

    //tests for blank line before and after the job information.
    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job testJob6 = new Job("Rental Rep", new Employer ("ERAC"), new Location ("STL"),
                new PositionType ("level 1"), new CoreCompetency ("negotiation"));
        //reflects the 1st \n character
        char newLine = testJob6.toString().charAt(0);
        //reflects the last character, \n
        char newLine2 = testJob6.toString().charAt(testJob6.toString().length()-1);
        //use assertEquals to verify that the 1st and last characters in toString are \n:
        assertEquals(newLine, '\n');
        assertEquals(newLine2, '\n');
    }

    //tests that string should contain a label for each field, followed by the data stored in that field. .
    // Each field should be on its own line.
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob7 = new Job("Rental Rep", new Employer ("ERAC"), new Location ("STL"),
                new PositionType ("level 1"), new CoreCompetency ("negotiation"));
        String testJob7String = "\nID: 4\nName: Rental Rep\nEmployer: ERAC\nLocation: STL\nPosition Type: level 1\nCore Competency: negotiation\n";
        assertEquals(testJob7String, testJob7.toString());
    }

    //tests for If a field is empty, the method should add Data not available after the label.
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob8 = new Job ("", new Employer (""), new Location (""),
                new PositionType (""), new CoreCompetency (""));
        String testJob8String = "\nID: 3\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n";
        assertEquals(testJob8String, testJob8.toString());
    }
}
