package Application.Models.Providers;

import Domain.StaffRepository;

public class StaffProvider {
    private StaffRepository staffRepository;
    public StaffProvider(){
        this.staffRepository = StaffRepository.getStaffRepository();
    }

}
