package com.clover.core.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clover.core.repository.PropuestaRepo;
import com.clover.core.service.ExplorarService;

@Service("ExplorarService")
public class ExplorarServiceImpl implements ExplorarService
{
	@Autowired
	@Qualifier("PropuestaRepo")
	private PropuestaRepo propuestaRepo;
	
	private static final Log logger = LogFactory.getLog(ExplorarService.class);
}
