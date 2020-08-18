package tp.kits3.livedinner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


//Service meeans helper to Controller
//Controller <---> Service  <---> Database
//req , resp  logic/processss    data storage


@Service
public class ModelService {
	private static final Logger logger = LoggerFactory.getLogger(ModelService.class);
	public ModelService(){
		logger.info("{}."," init");
	}
	public void  getModelData() {
		logger.info("{}."," get data");
	}
}
