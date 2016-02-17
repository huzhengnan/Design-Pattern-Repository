package gr.uom.java.pattern.gui.progress;
import java.io.File;
import java.util.Vector;

import gr.uom.java.pattern.PatternInstance;
import cc.mallet.javaTotext.*;

public class PatternDetectionSource {

    private String patternName;
    private Vector<PatternInstance> patternInstanceVector;
    private PopulateDBWithPatterns DBobj;
    public PatternDetectionSource(String patternName, Vector<PatternInstance> patternInstanceVector) throws Throwable {
        this.patternName = patternName;
        this.patternInstanceVector = patternInstanceVector;
        this.DBobj = new PopulateDBWithPatterns();
        DBobj.patternName = patternName;
        DBobj.patternInstanceVector = patternInstanceVector;
        DBobj.populatePatternInstance(DBobj);
        System.out.println(patternName+" "+patternInstanceVector);
        if(patternName.equals("Proxy2")){
        	javaTotext.run(new File(DBobj.getFileDir(DBobj.con)));
        }
        DBobj.closeConnection(); 
     }

	public String getPatternName() {
        return patternName;
    }

    public Vector<PatternInstance> getPatternInstanceVector() {
        return patternInstanceVector;
    }

}
