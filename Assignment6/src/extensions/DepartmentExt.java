package extensions;

import classes.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentExt {
    public static List<Department> _depList = new ArrayList<Department>();

    public static void addToDepList(Department dep) {
        if(!_depList.contains(dep)) {
            _depList.add(dep);
        }
    }

    public static List<Department> get_depList() {
        return _depList;
    }
}
