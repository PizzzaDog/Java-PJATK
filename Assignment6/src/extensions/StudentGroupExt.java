package extensions;

import classes.StudentGroup;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupExt {
    private static List<StudentGroup> _studentGroupList = new ArrayList<>();

    public static void addToGroupList(StudentGroup group) {
        if(!_studentGroupList.contains(group))
            _studentGroupList.add(group);
    }
}
