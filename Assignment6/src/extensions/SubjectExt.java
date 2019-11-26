package extensions;

import classes.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class SubjectExt {
        public static List<Subject> _subjectList = new ArrayList<>();

        public static void addToSubjectList(Subject e) {
            if(!_subjectList.contains(e)) {
                _subjectList.add(e);
            }
        }
    }


