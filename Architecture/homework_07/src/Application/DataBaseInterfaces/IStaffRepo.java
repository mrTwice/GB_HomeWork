package Application.DataBaseInterfaces;

import Application.Models.Primitives.Staff;

import java.util.List;

public interface IStaffRepo {
    List<Staff> getAllStaff();
    Staff getStaffByID(int id);
}
