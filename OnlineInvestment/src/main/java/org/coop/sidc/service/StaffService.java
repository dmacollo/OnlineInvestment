package org.coop.sidc.service;



import java.util.List;

import org.coop.sidc.domain.Staff;


public interface StaffService {

	public void save(Staff staff);

	public List<Staff> getAllStaff();
	
	public Staff getStaffById(Long id); 
	
	public void delete(Long id);


}
