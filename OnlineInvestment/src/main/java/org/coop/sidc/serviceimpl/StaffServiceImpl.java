package org.coop.sidc.serviceimpl;

import java.util.List;

import org.coop.sidc.domain.Staff;
import org.coop.sidc.repositories.StaffRepository;
import org.coop.sidc.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	StaffRepository staffrepository;
	
	@Override
	public void save(Staff staff) {
		staffrepository.save(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		
		return (List<Staff>) staffrepository.findAll();
	}

	@Override
	public Staff getStaffById(Long id) {
		
		return staffrepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		staffrepository.delete(id);
		
	}



}
