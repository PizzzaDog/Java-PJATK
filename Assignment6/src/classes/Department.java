package classes;

import extensions.DepartmentExt;

import java.util.List;
import java.util.Objects;

public class Department {

    private Dep _depatment;
    private List<Teacher> _employee;

    public Department(Dep depatment, List<Teacher> employeeList) {
        _depatment = depatment;
        _employee = employeeList;
        DepartmentExt.addToDepList(this);
    }
    public Dep get_depatment() {
        return _depatment;
    }

    public List<Teacher> getEmployee() {
        return _employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return _depatment == that._depatment &&
                _employee.equals(that._employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_depatment, _employee);
    }
}
