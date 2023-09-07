package Application.DataBaseInterfaces;

import Application.Logic.Primitives.Users.Staff;

import java.util.List;

public interface IStaffRepo {
    List<Staff> getAllStaff();
    Staff getStaffByID(int id);
}
