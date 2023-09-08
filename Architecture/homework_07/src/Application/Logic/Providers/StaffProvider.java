package Application.Logic.Providers;

import Application.Logic.Primitives.Users.Staff;
import Domain.StaffRepository;

import java.util.List;

public class StaffProvider {
    private StaffRepository staffRepository;
    public StaffProvider(){
        this.staffRepository = StaffRepository.getStaffRepository();
    }

    public List<Staff> getStaffList(){
        return staffRepository.getAllStaff();
    }
}
